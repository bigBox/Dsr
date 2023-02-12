package com.dj.serverplayer.server;

import java.util.Date;

import com.dj.serverapi.sensitiveword.SensitivewordFilter;
import com.dj.domain.constant.ConstantServer;
import com.dj.servercore.db.DbTemplate;
import com.dj.servercore.db.cache.CacheManager;
import com.dj.servercore.pool.ProtobufFactory;
import com.dj.servercore.server.SocketServer;
import com.dj.servercore.server.base.ServerAttribute;
import com.dj.servercore.server.config.LocalConfig;
import com.dj.servercore.spring.SpringContext;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.serverplayer.PlayerStart;
import com.dj.serverplayer.listener.TopicListener;
import com.dj.serverplayer.manager.ActionManager;
import com.dj.serverplayer.manager.ChannelManager;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.EventManager;
import com.dj.serverplayer.manager.QuartzManager;
import com.dj.serverplayer.worker.MeetEggWorker;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.Utility;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("deprecation")
public class PlayerServer extends SocketServer {

    private boolean todayIsHoliday = false;
    private long lastGetHolidayTime = 0L;

    protected PlayerServer(String serverConfig) {
        super(serverConfig);
    }

    public static PlayerServer getInstance() {
        return getInstance(ConstantServer.defaultInnerServerConfig);
    }

    public static PlayerServer getInstance(String serverConfig) {
        getInstance(serverConfig, config -> INSTANCE = new PlayerServer(serverConfig));
        return (PlayerServer) INSTANCE;
    }

    @Override
    public void run() {
        try {
            super.run();
            ConfManager.getInstance().load(LocalConfig.isUseRemoteJson());	//加载数值
            SpringContext.init();               							//载入spring框架
            DbTemplate.getInstance().initSqlMapClient();    				//数据库操作模板
            ActionManager.getInstance().initAction(PlayerStart.class);		//action行为处理器
            EventManager.getInstance();         							//启动监听事件
            TopicListener.getInstance().initListener();						//redis主题订阅发布
            QuartzManager.init();               							//启动定时器
            //SpringContext.getBean(PlayerServerInit.class).init();			//玩家服初始化
            MeetEggWorker.getWorker().start();   							//启动接鸡蛋线程
            SensitivewordFilter.init();										//屏蔽字初始化
            if(lastGetHolidayTime < 1) {
                //todayIsHoliday = DateUtil.getHolidayRequest();
                lastGetHolidayTime = System.currentTimeMillis();
            }
            setServerReady(true);											//玩家服准备好了
            //log.info("bbsUrl {}", getServerConfig().getBbsUrl());
            log.info("PlayerServer{} start at {} cost {} ms", getServerConfig().getId(), DateUtil.formatDate(new Date(), DateUtil.STYLE4), System.currentTimeMillis() - getStartTime());
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
        // 玩家缓存
        CacheManager playerCacheManager = SpringContext.getBean("playerCacheManager", CacheManager.class);
        playerCacheManager.getAsyncWriteManager().close();
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

//    public boolean todayIsHoliday() {
//        if(!DateUtil.isSameDay(new Date(lastGetHolidayTime), new Date())) {
//            todayIsHoliday = DateUtil.getHolidayRequest();
//            lastGetHolidayTime = System.currentTimeMillis();
//        }
//        return todayIsHoliday;
//    }
}
