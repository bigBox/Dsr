package com.dj.servergate.server;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.dj.domain.constant.ConstantServer;
import com.dj.protobuf.ServerType;
import com.dj.protobuf.forward.ForwardGameHomeReq;
import com.dj.protobuf.forward.ForwardPlayerInitReq;
import com.dj.protobuf.forward.GameLogoutReq;
import com.dj.protobuf.forward.LogoutReq;
import com.dj.servercore.executor.OrderedQueuePoolExecutor;
import com.dj.servercore.pool.ProtobufFactory;
import com.dj.servercore.server.ConnectServer;
import com.dj.servercore.server.SocketServerWS;
import com.dj.servercore.server.base.ServerAttribute;
import com.dj.servercore.server.config.LocalConfig;
import com.dj.servercore.server.netty.channel.BaseChannel;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergate.GateStart;
import com.dj.servergate.manager.ActionManager;
import com.dj.servergate.manager.ChannelManager;
import com.dj.servergate.manager.QuartzManager;
import com.dj.domain.util.ThreadUtil;
import com.dj.domain.util.Utility;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: GateServer
 * @Description: 该服务器提供给客户端连接
 * @date 2019年6月25日
 */
@Slf4j
@SuppressWarnings("deprecation")
public class GateServer extends SocketServerWS {

    private static Object obj = new Object();

    private static GateServer server;
    // 连接逻辑服务器
    @Getter
    private ConnectServer connectServer;

    // 处理客户端消息
    private OrderedQueuePoolExecutor recvExcutor = new OrderedQueuePoolExecutor("ClientMsgQueue");

    public GateServer() {
        this(ConstantServer.defaultNettyServerConfig, ConstantServer.defaultConnectServerConfig);
    }

    protected GateServer(String serverConfig, String connectServerConfig) {
        super(serverConfig);
        if (LocalConfig.isUseRemoteConnect()) {
            connectServerConfig = GateServer.serverConfig.getServerCdnUrl() + connectServerConfig;
        }
        connectServer = new GateConnectServer(connectServerConfig);
    }

    public static GateServer getInstance() {
        synchronized (obj) {
            if (server == null) {
                server = new GateServer();
            }
        }
        return server;
    }

    public static GateServer getInstance(String nettyServerConfig) {
        synchronized (obj) {
            if (server == null) {
                server = new GateServer(nettyServerConfig, ConstantServer.defaultConnectServerConfig);
            }
        }
        return server;
    }

    public static GateServer getInstance(String nettyServerConfig, String connectServerConfig) {
        synchronized (obj) {
            if (server == null) {
                server = new GateServer(nettyServerConfig, connectServerConfig);
            }
        }
        return server;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(getServerConfig().getName() + getServerConfig().getId());
        ActionManager.getInstance().initAction(GateStart.class);//action行为处理器
        new Thread(connectServer).start();
        try {
            ConnectServer.cdl.await(5, TimeUnit.SECONDS);
            ThreadUtil.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error(Utility.getTraceString(e));
        }
        log.info("cdl {}", ConnectServer.cdl.getCount());
        //等所有逻辑服连接完成，再启动网关端口对外开放
        super.run();
        QuartzManager.init();       //启动定时器
        log.info("GateServer{} start at {} cost {} ms", getServerConfig().getId(), new Date(getStartTime()), System.currentTimeMillis() - getStartTime());
    }

    @Override
    public void doMsgHandler(MyMsg msg) {
        recvExcutor.addTask(msg.getRoleID(), ProtobufFactory.borrowMsgClientTask(MsgClientTask.class, msg));
    }

    public Map<Integer, Channel> getServerChannelMap(ServerType type) {
        return connectServer.getServerChannels().get(type);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        if (ctx.hasAttr(ServerAttribute.roleID)) {
            long roleID = ctx.attr(ServerAttribute.roleID).get();
            ChannelId tmpId = ctx.pipeline().channel().id();
            BaseChannel clientChannel = ChannelManager.getInstance().getChannel(roleID);
            if (clientChannel == null) {
                return;
            }
            ChannelId channelId = clientChannel.getChannel().pipeline().channel().id();
            if (tmpId != channelId) {
                return;
            }
            // 玩家退出
            log.info("roleID {}", roleID);
            // 退出玩家服
            LogoutReq.Builder logoutReq = LogoutReq.newBuilder();
            logoutReq.setRoleID(roleID);
            LogoutReq logout = logoutReq.build();
            ForwardPlayerInitReq.Builder playerBuilder = ForwardPlayerInitReq.newBuilder();
            playerBuilder.setRoleID(roleID);
            playerBuilder.setReqClz(logout.getClass().getName());
            playerBuilder.setReq(logout.toByteString());
            playerBuilder.setPs("");
            ChannelManager.getInstance().sendToConnectServer(ServerType.PLAYER, clientChannel.getServerPlayerID(), playerBuilder.build());
            // 退出游戏服
            GameLogoutReq.Builder gameLogoutReq = GameLogoutReq.newBuilder();
            gameLogoutReq.setRoleID(roleID);
            GameLogoutReq gameLogout = gameLogoutReq.build();
            ForwardGameHomeReq.Builder gameBuilder = ForwardGameHomeReq.newBuilder();
            gameBuilder.setRoleID(roleID);
            gameBuilder.setReqClz(gameLogout.getClass().getName());
            gameBuilder.setReq(gameLogout.toByteString());
            gameBuilder.setPs("");
            ChannelManager.getInstance().sendToConnectServer(ServerType.GAME, clientChannel.getServerGameID(), gameBuilder.build());
            // 关闭该玩家通道
            ChannelManager.getInstance().closeChannelByRole(roleID);
        }
    }
}
