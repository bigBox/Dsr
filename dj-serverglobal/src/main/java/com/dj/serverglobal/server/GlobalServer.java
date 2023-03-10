package com.dj.serverglobal.server;

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
import com.dj.serverglobal.GlobalStart;
import com.dj.serverglobal.listener.TopicListener;
import com.dj.serverglobal.manager.ActionManager;
import com.dj.serverglobal.manager.ChannelManager;
import com.dj.serverglobal.manager.ConfManager;
import com.dj.serverglobal.manager.EventManager;
import com.dj.serverglobal.manager.QuartzManager;
import com.dj.serverglobal.server.http.NettyServerFilter;
import com.dj.serverglobal.worker.GuildBattleGameWorker;
import com.dj.serverglobal.worker.GuildBattleRobotWorker;
//import com.dj.serverglobal.worker.TradeRobotWorker;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.Utility;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("deprecation")
public class GlobalServer extends SocketServer {
    protected GlobalServer(String serverConfig) {
        super(serverConfig);
    }

    public static GlobalServer getInstance() {
        return getInstance(ConstantServer.defaultInnerServerConfig);
    }

    public static GlobalServer getInstance(String serverConfig) {
        getInstance(serverConfig, config -> INSTANCE = new GlobalServer(serverConfig));
        return (GlobalServer) INSTANCE;
    }

    @Override
    public void run() {
        try {
            super.run();
            ConfManager.getInstance().load(LocalConfig.isUseRemoteJson());	//????????????
            SpringContext.init();              								//??????spring??????
            DbTemplate.getInstance().initSqlMapClient();    				//?????????????????????
            ActionManager.getInstance().initAction(GlobalStart.class);		//action???????????????
            EventManager.getInstance();         							//??????????????????
            TopicListener.getInstance().initListener();						//redis??????????????????
            SpringContext.getBean(GlobalServerInit.class).init();			//??????????????????
            QuartzManager.init();               							//???????????????
            GuildBattleGameWorker.getWorker().start(); 						//??????????????????
            GuildBattleRobotWorker.getWorker().start(); 					//???????????????????????????
            //TradeRobotWorker.getWorker().start(); 						//???????????????
            SensitivewordFilter.init();										//??????????????????
            startHttp();
            
            setServerReady(true);											//?????????????????????
            log.info("GlobalServer{} start at {} cost {} ms", getServerConfig().getId(), DateUtil.formatDate(new Date(), DateUtil.STYLE4), System.currentTimeMillis() - getStartTime());
        } catch (Exception e) {
            log.info(Utility.getTraceString(e));
            System.exit(1);
        }
    }

    private void startHttp() {
    	EventLoopGroup group = new NioEventLoopGroup();  
    	ServerBootstrap b = new ServerBootstrap();
    	try {
            b.group(group);
            b.channel(NioServerSocketChannel.class);
            b.childHandler(new NettyServerFilter()); //???????????????
            // ???????????????????????????
            ChannelFuture f = b.bind(getServerConfig().getHttpPort()).sync();
            log.info("httpPort {}", getServerConfig().getHttpPort());
            // ???????????????????????????
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
        	log.info(Utility.getTraceString(e));
            System.exit(1);
        } finally {
            group.shutdownGracefully(); //??????EventLoopGroup?????????????????????????????????????????????  
        }
	}

	@Override
    public void doMsgHandler(MyMsg msg) {
        recvExcutor.addTask(msg.getRoleID(), ProtobufFactory.borrowMsgConnectTask(MsgConnectTask.class, msg));
    }

    @Override
    protected void stop() {
        // ????????????
        CacheManager guildCacheManager = SpringContext.getBean("guildCacheManager", CacheManager.class);
        guildCacheManager.getAsyncWriteManager().close();
        // ????????????
        //CacheManager tradeCacheManager = SpringContext.getBean("tradeCacheManager", CacheManager.class);
        //tradeCacheManager.getAsyncWriteManager().close();
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
