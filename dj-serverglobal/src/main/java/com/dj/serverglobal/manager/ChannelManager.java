package com.dj.serverglobal.manager;

import com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp;
import com.dj.protobuf.forward.ForwardGlobalGuildRsp;
import com.dj.protobuf.forward.ForwardGlobalRankRsp;
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

	public boolean sendGlobalGuildToGate(int gateId, long roleID, GeneratedMessageV3 message) {
		ChannelHandlerContext channel = gateChannelMap.getIfPresent(gateId);
		if (gateId > 0 && channel != null) {
			ForwardGlobalGuildRsp.Builder builder = ForwardGlobalGuildRsp.newBuilder();
			builder.setRoleID(roleID);
			builder.setRspClz(message.getClass().getName());
			builder.setRsp(message.toByteString());
			channel.writeAndFlush(builder.build());
		}
		return false;
	}
	
	public boolean sendGlobalGuildBattleToGate(int gateId, long roleID, GeneratedMessageV3 message) {
		ChannelHandlerContext channel = gateChannelMap.getIfPresent(gateId);
		if (gateId > 0 && channel != null) {
			ForwardGlobalGuildBattleRsp.Builder builder = ForwardGlobalGuildBattleRsp.newBuilder();
			builder.setRoleID(roleID);
			builder.setRspClz(message.getClass().getName());
			builder.setRsp(message.toByteString());
			channel.writeAndFlush(builder.build());
		}
		return false;
	}
	
	public boolean sendGlobalRankToGate(int gateId, long roleID, GeneratedMessageV3 message) {
		ChannelHandlerContext channel = gateChannelMap.getIfPresent(gateId);
		if (gateId > 0 && channel != null) {
			ForwardGlobalRankRsp.Builder builder = ForwardGlobalRankRsp.newBuilder();
			builder.setRoleID(roleID);
			builder.setRspClz(message.getClass().getName());
			builder.setRsp(message.toByteString());
			channel.writeAndFlush(builder.build());
		}
		return false;
	}
}
