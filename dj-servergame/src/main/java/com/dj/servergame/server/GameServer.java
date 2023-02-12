package com.dj.servergame.server;

import java.util.Date;

import com.dj.serverapi.sensitiveword.SensitivewordFilter;
import com.dj.domain.constant.ConstantServer;
import com.dj.servercore.db.DbTemplate;
import com.dj.servercore.pool.ProtobufFactory;
import com.dj.servercore.server.SocketServer;
import com.dj.servercore.server.base.ServerAttribute;
import com.dj.servercore.server.config.LocalConfig;
import com.dj.servercore.spring.SpringContext;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergame.GameStart;
import com.dj.servergame.listener.TopicListener;
import com.dj.servergame.manager.ActionManager;
import com.dj.servergame.manager.ChannelManager;
import com.dj.servergame.manager.ConfManager;
import com.dj.servergame.manager.EventManager;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.Utility;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("deprecation")
public class GameServer extends SocketServer {

    protected GameServer(String serverConfig) {
        super(serverConfig);
    }

    public static GameServer getInstance() {
        return getInstance(ConstantServer.defaultInnerServerConfig);
    }

    public static GameServer getInstance(String serverConfig) {
        getInstance(serverConfig, config -> INSTANCE = new GameServer(serverConfig));
        return (GameServer) INSTANCE;
    }

    @Override
    public void run() {
        try {
            super.run();
            ConfManager.getInstance().load(LocalConfig.isUseRemoteJson());	//加载数值
            SpringContext.init();               							//载入spring框架
            DbTemplate.getInstance().initSqlMapClient();    				//数据库操作模板
            ActionManager.getInstance().initAction(GameStart.class);		//action行为处理器
            EventManager.getInstance();         							//启动监听事件
            TopicListener.getInstance().initListener();						//redis主题订阅发布
            SensitivewordFilter.init();

            setServerReady(true);											//游戏服准备好了
            log.info("GameServer{} start at {} cost {} ms", getServerConfig().getId(), DateUtil.formatDate(new Date(), DateUtil.STYLE4), System.currentTimeMillis() - getStartTime());
        } catch (Exception e) {
            log.info(Utility.getTraceString(e));
            System.exit(1);
        }
    }

    @Override
    public void doMsgHandler(MyMsg msg) {
        recvExcutor.addTask(msg.getRoleID(), ProtobufFactory.borrowMsgConnectTask(MsgConnectTask.class, msg));
    }

    @Override
    protected void stop() {

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        if (ctx != null && ctx.hasAttr(ServerAttribute.serverID)) {
            int serverID = ctx.attr(ServerAttribute.serverID).get();
            log.info("serverID={}", serverID);
            if (ChannelManager.getInstance().delChannel(serverID)) {
                setStopTime(1000);
            }
        }
    }
}
