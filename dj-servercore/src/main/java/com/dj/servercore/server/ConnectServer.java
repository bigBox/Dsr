package com.dj.servercore.server;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.dj.protobuf.ServerType;
import com.dj.servercore.pool.MyThreadFactory;
import com.dj.servercore.server.base.AbsServer;
import com.dj.servercore.server.base.IServer;
import com.dj.servercore.server.base.ServerAttribute;
import com.dj.servercore.server.base.ServerInfo;
import com.dj.servercore.server.config.ConnectServerConfig;
import com.dj.servercore.server.config.ServerConfigXmlLoader;
import com.dj.servercore.server.netty.coder.MyProtobufDecoder;
import com.dj.servercore.server.netty.coder.MyProtobufEncoder;
import com.dj.servercore.server.netty.handler.SocketChannelHandler;
import com.dj.domain.util.Utility;
import com.google.common.collect.Maps;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@EqualsAndHashCode(callSuper = false)
public abstract class ConnectServer extends AbsServer implements IServer {

    @Setter
    @Getter
    protected static ConnectServerConfig connectServerConfig;

    // 服务器连接
    protected ConcurrentHashMap<ServerType, Map<Integer, Channel>> serverChannels = new ConcurrentHashMap<>();

    protected static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    public static boolean serverPlayerReady = false;
    public static boolean serverGameReady = false;
    public static boolean serverGlobalReady = false;

    public static CountDownLatch cdl;

    protected ConnectServer(String serverConfig) {
        connectServerConfig = ServerConfigXmlLoader.loadClient(serverConfig);
        log.info(serverConfig);
        int connectCount = connectServerConfig.getPlayerServers().size() + connectServerConfig.getGameServers().size() + connectServerConfig.getGlobalServers().size();
        log.info("connectCount {}", connectCount);
        cdl = new CountDownLatch(connectCount);
    }

    @Override
    protected void init() {
        super.init();
    }

    /**
     *	检测服务器配置是否连接过
     *
     * @param id
     * @param type
     * @return
     */
    private boolean checkConnected(int id, ServerType type) {
        Map<Integer, Channel> typeMap = serverChannels.get(type);
        if (typeMap == null) {
            return false;
        }
        return typeMap.containsKey(id);
    }

    private synchronized void addChannel(Channel channel, int id, ServerType type) {
        try {
            Map<Integer, Channel> typeMap = serverChannels.get(type);
            if (typeMap == null) {
                typeMap = Maps.newHashMapWithExpectedSize(3);
                serverChannels.put(type, typeMap);
            }
            channel.attr(ServerAttribute.serverID).set(id);
            channel.attr(ServerAttribute.serverType).set(type);
            typeMap.put(id, channel);
            addServer(type, id);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }
    }

    public abstract void addServer(ServerType type, int serverID);

    public abstract void removeServer(ServerType type, int serverID);

    // 执行 ，链接其他服务器线程
    @Override
    public void run() {
        try {
            connectServers(connectServerConfig.getPlayerServers(), ServerType.PLAYER);
            connectServers(connectServerConfig.getGameServers(), ServerType.GAME);
            connectServers(connectServerConfig.getGlobalServers(), ServerType.GLOBAL);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }
    }
    // 构造函数
    public void connectServers(List<ServerInfo> servers, ServerType type) {
        ConnectServer connectServer = this;
        for (ServerInfo serverInfo : servers) {
            if (checkConnected(serverInfo.getId(), type)) {
                log.info("serverID {}, type {} connected", serverInfo.getId(), type);
                continue;
            }
            cachedThreadPool.execute(() -> {
                EventLoopGroup workerGroup = new NioEventLoopGroup(0, new MyThreadFactory("connect-parent"));
                try {
                    Bootstrap bootstrap = new Bootstrap();
                    bootstrap.group(workerGroup).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).option(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000).handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            // 这里使用自定义分隔符
                            ByteBuf delimiter = Unpooled.copiedBuffer("._-_.".getBytes());
                            ch.pipeline().addFirst(new DelimiterBasedFrameDecoder(1024 * 1024, delimiter));
                            ch.pipeline().addLast(new IdleStateHandler(0, 0, 5)).addLast(new MyProtobufDecoder())
                            .addLast(new MyProtobufEncoder()).addLast(new SocketChannelHandler(connectServer));
                        }
                    });
                    ChannelFuture channelFuture = bootstrap.connect(serverInfo.getIp(), serverInfo.getPort());
                    channelFuture.awaitUninterruptibly(10000); // 最多等待10秒，如果服务器一直未开启情况下，防止阻塞当前线程
                    channelFuture.addListener(future -> {
                        if (future.isSuccess()) {
                            addChannel(channelFuture.channel(), serverInfo.getId(), type);
                            register(channelFuture.channel(), type);
                            log.info("连接[{}]服务器{}【 {}:{}】success.", type.toString(), serverInfo.getId(), serverInfo.getIp(), serverInfo.getPort());
                        } else {
                            log.info("连接[{}]服务器{}【 {}:{}】fail.", type.toString(), serverInfo.getId(), serverInfo.getIp(), serverInfo.getPort());
                        }
                    });
                    channelFuture.channel().closeFuture().sync();
                } catch (Exception e) {
                    log.error(Utility.getTraceString(e));
                } finally {
                    workerGroup.shutdownGracefully();
                }
            });
        }
    }

    public abstract void register(Channel ctx, ServerType type);

    public static boolean isReady() {
        return serverPlayerReady && serverGameReady && serverGlobalReady;
    }
}
