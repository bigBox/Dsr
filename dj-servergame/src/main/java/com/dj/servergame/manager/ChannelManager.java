package com.dj.servergame.manager;

import com.dj.protobuf.forward.ForwardGameMiniRsp;
import com.dj.protobuf.forward.ForwardGameMultiRsp;
import com.dj.servercore.server.netty.channel.BaseLogicChannelManager;
import com.google.protobuf.GeneratedMessageV3;

import io.netty.channel.ChannelHandlerContext;

public final class ChannelManager extends BaseLogicChannelManager {
	private static final ChannelManager INSTANCE = new ChannelManager();

	public ChannelManager() {
		setInstance(this);
	}

	public static final ChannelManager getInstance() {
		return INSTANCE;
	}

	public boolean sendGameMultiToGate(int gateId, long roleID, GeneratedMessageV3 message) {
		ChannelHandlerContext channel = gateChannelMap.getIfPresent(gateId);
		if (gateId > 0 && channel != null) {
			ForwardGameMultiRsp.Builder builder = ForwardGameMultiRsp.newBuilder();
			builder.setRoleID(roleID);
			builder.setRspClz(message.getClass().getName());
			builder.setRsp(message.toByteString());
			channel.writeAndFlush(builder.build());
		}
		return false;
	}

	public boolean sendGameMiniToGate(int gateId, long roleID, GeneratedMessageV3 message) {
		ChannelHandlerContext channel = gateChannelMap.getIfPresent(gateId);
		if (gateId > 0 && channel != null) {
			ForwardGameMiniRsp.Builder builder = ForwardGameMiniRsp.newBuilder();
			builder.setRoleID(roleID);
			builder.setRspClz(message.getClass().getName());
			builder.setRsp(message.toByteString());
			channel.writeAndFlush(builder.build());
		}
		return false;
	}
}
