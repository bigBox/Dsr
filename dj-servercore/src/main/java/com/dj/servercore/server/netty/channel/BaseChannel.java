package com.dj.servercore.server.netty.channel;

import com.dj.protobuf.ServerType;
import com.google.protobuf.MessageLite;

import io.netty.channel.ChannelHandlerContext;
import lombok.Data;

@Data
public abstract class BaseChannel {
	protected String key;

	protected long roleID;
	
	protected ChannelHandlerContext channel;
	private String channelID;

	/**
	 *	玩家服id
	 */
	private int serverPlayerID;

	/**
	 *	游戏服id
	 */
	private int serverGameID;

	/**
	 *	全局服id
	 */
	private int serverGlobalID;

	public BaseChannel(ChannelHandlerContext channel) {
		super();
		this.channel = channel;
	}

	public void bind(long roleID, String key) {
		this.roleID = roleID;
		this.key = key;
	}

	public abstract void sendMsg(MessageLite msg);

	public void setServerID(ServerType serverType, int serverID) {
		if (serverType == ServerType.PLAYER) {
			setServerPlayerID(serverID);
		} else if (serverType == ServerType.GAME) {
			setServerGameID(serverID);
		} else if (serverType == ServerType.GLOBAL) {
			setServerGlobalID(serverID);
		}
	}
	
	public int getServerID(ServerType serverType) {
		if (serverType == ServerType.PLAYER) {
			return serverPlayerID;
		} else if (serverType == ServerType.GAME) {
			return serverGameID;
		} else if (serverType == ServerType.GLOBAL) {
			return serverGlobalID;
		}
		return 0;
	}
}
