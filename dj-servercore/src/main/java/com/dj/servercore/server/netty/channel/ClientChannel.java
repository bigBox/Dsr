package com.dj.servercore.server.netty.channel;

import com.google.protobuf.MessageLite;

import io.netty.channel.ChannelHandlerContext;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: ClientChannel
 * @Description: 客户端通道
 * @author zcq
 * @date 2019年8月26日
 */
@Slf4j
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class ClientChannel extends BaseChannel {

	public ClientChannel(String key, ChannelHandlerContext channel) {
		super(channel);
		this.key = key;
	}

	@Override
	public void sendMsg(MessageLite msg) {
		if (channel != null) {
			channel.writeAndFlush(msg);
		} else {
			log.error("send msg fail,channel is null");
		}
	}
}