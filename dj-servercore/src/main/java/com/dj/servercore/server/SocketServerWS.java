package com.dj.servercore.server;

import java.util.List;

import com.dj.servercore.server.base.AbsServer;
import com.dj.servercore.server.base.IServer;
import com.dj.servercore.server.config.NettyServerConfig;
import com.dj.servercore.server.config.ServerConfigXmlLoader;
import com.dj.servercore.server.netty.coder.MyProtobufDecoder4Client;
import com.dj.servercore.server.netty.coder.MyProtobufEncoder4Client;
import com.dj.servercore.server.netty.handler.SocketChannelHandler;
import com.dj.domain.util.Utility;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class SocketServerWS extends AbsServer implements IServer {

    private int port;

    protected SocketServerWS(String serverConfig) {
        super(ServerConfigXmlLoader.loadNetty(serverConfig));
        setStartTime(System.currentTimeMillis());
    }

    @Override
    protected void init() {
        super.init();
        this.port = ((NettyServerConfig) serverConfig).getPort();
    }

    @Override
    public void run() {
        new Thread(new SocketOuterServer(this)).start();
    }

    private class SocketOuterServer implements Runnable {

        private SocketServerWS server;

        public SocketOuterServer(SocketServerWS server) {
            this.server = server;
        }

        @Override
        public void run() {
            Thread.currentThread().setName(SocketOuterServer.class.getSimpleName());
            EventLoopGroup bossGroup = new NioEventLoopGroup();
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            ServerBootstrap bootstrap = new ServerBootstrap();
            try {
                bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        // HTTP????????????????????????
                        pipeline.addLast(new HttpServerCodec());
                        // ???????????????????????????????????????FullHttpRequest??????FullHttpResponse???
                        // ?????????HTTP?????????????????????HTTP?????????????????????????????????HttpRequest/HttpResponse,HttpContent,LastHttpContent
                        pipeline.addLast(new HttpObjectAggregator(65536));
                        // ?????????????????????????????????????????????1G???????????????????????????????????????????????????jvm?????????; ??????????????????????????????????????????
                        pipeline.addLast(new ChunkedWriteHandler());
                        // WebSocket????????????
                        pipeline.addLast(new WebSocketServerCompressionHandler());
                        // ?????????????????????
                        pipeline.addLast(new WebSocketServerProtocolHandler("/", null, true, Integer.MAX_VALUE));
                        // ???????????????
                        pipeline.addLast(new MessageToMessageDecoder<WebSocketFrame>() {
                            @Override
                            protected void decode(ChannelHandlerContext ctx, WebSocketFrame frame, List<Object> objs) throws Exception {
                                ByteBuf buf = frame.content();
                                objs.add(buf);
                                buf.retain();
                            }
                        });
                        pipeline.addLast(new IdleStateHandler(60, 40, 0));
                        pipeline.addLast(new MyProtobufDecoder4Client()).addLast(new MyProtobufEncoder4Client()).addLast(new SocketChannelHandler(server));
                    }
                });
                ChannelFuture future = bootstrap.bind(port).sync();
                Channel channel = future.channel();
                future.addListener((ChannelFutureListener) future1 -> {
                    if (future1.isSuccess()) {
                        log.info("{} bind ws port {} success...", getServerConfig().getName(), port);
                    } else {
                        log.info("{} bind ws port {} fail...", getServerConfig().getName(), port);
                        System.exit(1);
                    }
                });
                channel.closeFuture().sync();
            } catch (Exception e) {
                log.error(Utility.getTraceString(e));
            } finally {
                workerGroup.shutdownGracefully();
                bossGroup.shutdownGracefully();
            }
        }
    }
}
