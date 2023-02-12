package com.dj.servergate.action.base;

import com.dj.protobuf.ServerType;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.server.netty.channel.BaseChannel;
import com.dj.servergate.manager.ChannelManager;
import com.dj.domain.util.Utility;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseGateAction extends BaseAction {

	protected GeneratedMessageV3 getForwardRsp(String rspClz, ByteString rspByte) {
		try {
			GeneratedMessageV3 rspContent = (GeneratedMessageV3) Class.forName(rspClz).getMethod("parseFrom", ByteString.class).invoke(null, rspByte);
			return rspContent;
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
		}
		return null;
	}

	public abstract void sendForward2Logic(long roleID, MessageLite content);

	protected void sendClient4Player(String key, MessageLite msg) {
		String keyString = key.toLowerCase();
		BaseChannel clientChannel = ChannelManager.getInstance().getAccountChannel(keyString);
		if (clientChannel != null) {
			clientChannel.sendMsg(msg);
		}else {
			log.error("error channel key {}", keyString);
		}
	}

	protected void sendClient4Role(long roleID, MessageLite msg) {
		BaseChannel clientChannel = ChannelManager.getInstance().getChannel(roleID);
		if (clientChannel != null) {
			clientChannel.sendMsg(msg);
		}
	}

	protected int getServerID(ServerType serverType, String account) {
		String keyString = account.toLowerCase();
		BaseChannel clientChannel = ChannelManager.getInstance().getAccountChannel(keyString);
		int serverID = clientChannel.getServerID(serverType);
		return serverID;
	}

	protected int getServerID(ServerType serverType, long roleID) {
		if (roleID == 0) {
			return 0;
		}
		BaseChannel clientChannel = ChannelManager.getInstance().getChannel(roleID);
		if (clientChannel == null) {
			log.error("roleID {}, serverType {}", roleID, serverType);
			return 0;
		}
		int serverID = clientChannel.getServerID(serverType);
		return serverID;
	}
}
