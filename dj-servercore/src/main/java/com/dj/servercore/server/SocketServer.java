package com.dj.servercore.server;

import java.util.concurrent.locks.ReentrantLock;
import com.alibaba.fastjson.parser.ParserConfig;
import com.dj.domain.ServerThread;
import com.dj.protobuf.ServerType;
import com.dj.servercore.executor.OrderedQueuePoolExecutor;
import com.dj.servercore.pool.MyThreadFactory;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.servercore.server.base.AbsServer;
import com.dj.servercore.server.base.ExitDaemon;
import com.dj.servercore.server.base.IServer;
import com.dj.servercore.server.config.InnerServerConfig;
import com.dj.servercore.server.config.ServerConfigXmlLoader;
import com.dj.servercore.server.netty.coder.MyProtobufDecoder;
import com.dj.servercore.server.netty.coder.MyProtobufEncoder;
import com.dj.servercore.server.netty.handler.SocketChannelHandler;
import com.dj.domain.util.Utility;
import com.dj.domain.util.inf.IArgumentRunnable;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class SocketServer extends AbsServer implements IServer {

    private static ReentrantLock LOCK = new ReentrantLock();

    @Setter
    @Getter
    private static InnerServerConfig serverConfig;

    @Getter
    private static int threadNum;
    @Getter
    private static ServerType serverType;

    @Getter
    protected static RedisTemplate redisTemplate;

    public static SocketServer INSTANCE;

    /**
     * @Field serverReady : 服务器是否已经准备好
     */
    @Getter
    @Setter
    protected static volatile boolean serverReady = false;

    protected OrderedQueuePoolExecutor recvExcutor = new OrderedQueuePoolExecutor("SocketMsgQueue");

    protected SocketServer(String serverConfig) {
        super(ServerConfigXmlLoader.loadInner(serverConfig));
        setStartTime(System.currentTimeMillis());
    }

    public static <T extends SocketServer> SocketServer getInstance(String config, IArgumentRunnable<String> newInstanceRunnable) {
        LOCK.lock();
        try {
            if (INSTANCE == null) {
                newInstanceRunnable.run(config);
            }
        } finally {
            LOCK.unlock();
        }
        return INSTANCE;
    }

    @Override
    protected void init() {
        super.init();
        serverConfig = (InnerServerConfig) AbsServer.serverConfig;
        if (serverConfig == null) {
            return;
        }
        serverType = ServerType.valueOf(SocketServer.getServerConfig().getName().toUpperCase());
        switch (serverType) {
            case PLAYER:
                threadNum = ServerThread.SERVER_PLAYER_THREAD_NUM;
                break;
            case GAME:
                threadNum = ServerThread.SERVER_GAME_THREAD_NUM;
                break;
            case GLOBAL:
                threadNum = ServerThread.SERVER_GLOBAL_THREAD_NUM;
                break;
            default:
                threadNum = ServerThread.SERVER_THREAD_NUM;
                break;
        }
        log.info("{} threadNum {}", serverType, threadNum);
        if (serverConfig.getRedisConfig() != null) {
            redisTemplate = new RedisTemplate(serverConfig.getRedisConfig());
        }
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }

    protected abstract void stop();

    @Override
    public void run() {
        Thread.currentThread().setName(serverConfig.getName() + serverConfig.getId());
        new Thread(new SocketInnerServer(this)).start();
        // 服务器守护线程
        Thread exitDaemon = new Thread(new ExitDaemon());
        exitDaemon.setName(serverConfig.getName() + serverConfig.getId() + "-Exit-Daemon");
        exitDaemon.start();
        // 注册服务器关闭线程
        Runtime.getRuntime().addShutdownHook(new Thread(new CloseByExit(serverConfig.getName())));
    }

    class CloseByExit implements Runnable {
        // 服务器名字
        private String serverName;

        public CloseByExit(String serverName) {
            this.serverName = serverName;
        }

        @Override
        public void run() {
            try {
                log.info("{} Stop! And {} seconds of service provided...", this.serverName, (System.currentTimeMillis() - AbsServer.getStartTime()) / 1000);
                // 执行关闭事件
                stop();
            } finally {
            }
        }
    }

    private class SocketInnerServer implements Runnable {

        private SocketServer server;

        public SocketInnerServer(SocketServer server) {
            this.server = server;
        }

        @Override
        public void run() {
            Thread.currentThread().setName(SocketInnerServer.class.getSimpleName());
            EventLoopGroup bossGroup = new NioEventLoopGroup(0, new MyThreadFactory("netty-parent"));
            EventLoopGroup workerGroup = new NioEventLoopGroup(0, new MyThreadFactory("netty-child"));
            try {
                ServerBootstrap b = new ServerBootstrap();
                b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 100).childOption(ChannelOption.SO_SNDBUF, 1024 * 1024)
                .handler(new LoggingHandler(LogLevel.INFO)).childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        // 这里使用自定义分隔符
                        ByteBuf delimiter = Unpooled.copiedBuffer("._-_.".getBytes());
                        ch.pipeline().addFirst(new DelimiterBasedFrameDecoder(1024 * 1024, delimiter));
                        ch.pipeline().addLast(new MyProtobufDecoder()).addLast(new MyProtobufEncoder()).addLast(new SocketChannelHandler(server));
                    }
                });
                ChannelFuture future = b.bind(getServerConfig().getPort()).sync();
                if (future.isSuccess()) {
                    log.info("{}{} bind socket port {} success...", getServerConfig().getName(), getServerConfig().getId(), getServerConfig().getPort());
                } else {
                    log.info("{}{} bind socket port {} fail...", getServerConfig().getName(), getServerConfig().getId(), getServerConfig().getPort());
                }
                future.channel().closeFuture().sync();
            } catch (Exception e) {
                log.error(Utility.getTraceString(e));
            } finally {
                workerGroup.shutdownGracefully();
                bossGroup.shutdownGracefully();
            }
        }
    }
}
