package com.dj.servercore.server.base;

import com.dj.servercore.task.msg.MyMsg;

import io.netty.channel.ChannelHandlerContext;

public interface IServer {

	void doMsgHandler(MyMsg msg);

	void channelInactive(ChannelHandlerContext ctx);
}
