package com.dj.servergate.server;

import com.dj.protobuf.ServerType;
import com.dj.protobuf.server.RegisterGate2GameReq;
import com.dj.protobuf.server.RegisterGate2GlobalReq;
import com.dj.protobuf.server.RegisterGate2PlayerReq;
import com.dj.servercore.executor.OrderedQueuePoolExecutor;
import com.dj.servercore.pool.ProtobufFactory;
import com.dj.servercore.server.ConnectServer;
import com.dj.servercore.server.base.ServerAttribute;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergate.manager.ChannelManager;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author zcq
 * @ClassName: GateConnectServer
 * @Description: 该服务器连接逻辑服务器
 * @date 2019年6月25日
 */
@SuppressWarnings("deprecation")
@Slf4j
public class GateConnectServer extends ConnectServer {

    // 处理Gate作为内网通信客户端的消息
    private OrderedQueuePoolExecutor recvExcutor = new OrderedQueuePoolExecutor("ConnectMsgQueue");

    protected GateConnectServer(String serverConfig) {
        super(serverConfig);
    }

    @Override
    public void doMsgHandler(MyMsg msg) {
        recvExcutor.addTask(msg.getRoleID(), ProtobufFactory.borrowMsgConnectTask(MsgConnectTask.class, msg));
    }

    @Override
    public void register(Channel channel, ServerType type) {
        switch (type) {
            case PLAYER:
                RegisterGate2PlayerReq.Builder player = RegisterGate2PlayerReq.newBuilder();
                player.setServerId(getServerConfig().getId());
                player.setServerName(getServerConfig().getName());
                channel.writeAndFlush(player.build());
                break;
            case GAME:
                RegisterGate2GameReq.Builder game = RegisterGate2GameReq.newBuilder();
                game.setServerId(getServerConfig().getId());
                game.setServerName(getServerConfig().getName());
                channel.writeAndFlush(game.build());
                break;
            case GLOBAL:
                RegisterGate2GlobalReq.Builder global = RegisterGate2GlobalReq.newBuilder();
                global.setServerId(getServerConfig().getId());
                global.setServerName(getServerConfig().getName());
                channel.writeAndFlush(global.build());
                break;
            default:
                break;
        }
    }

    @Override
    public void addServer(ServerType type, int serverID) {
        ChannelManager.getInstance().addServer(type, serverID);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        if (ctx != null && ctx.hasAttr(ServerAttribute.serverID)) {
            int serverID = ctx.attr(ServerAttribute.serverID).get();
            ServerType type = ctx.attr(ServerAttribute.serverType).get();
            log.info("type={}, serverID={}", type, serverID);
            removeServer(type, serverID);
        }
    }

    @Override
    public void removeServer(ServerType type, int serverID) {
        Map<Integer, Channel> typeMap = serverChannels.get(type);
        if (typeMap != null && typeMap.containsKey(serverID)) {
            typeMap.remove(serverID);
            ChannelManager.getInstance().removeServer(type, serverID);
        }
        log.info("type={}, serverID={}", type, serverID);
    }
}
