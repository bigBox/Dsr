package com.dj.servergate.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.dj.protobuf.ServerType;
import com.dj.servercore.server.netty.channel.BaseChannel;
import com.dj.servercore.server.netty.channel.BaseGateChannelManager;
import com.dj.servergate.server.GateServer;
import com.google.protobuf.MessageLite;

import io.netty.channel.Channel;

public final class ChannelManager extends BaseGateChannelManager {

	private List<Integer> playerServer = Collections.synchronizedList(new ArrayList<Integer>(3));
	private List<Integer> gameServer = Collections.synchronizedList(new ArrayList<Integer>(3));
	private List<Integer> globalServer = Collections.synchronizedList(new ArrayList<Integer>(3));

	private static final ChannelManager INSTANCE = new ChannelManager();

	public static final ChannelManager getInstance() {
		return INSTANCE;
	}

	@Override
	public Map<Integer, Channel> getServerChannelMap(ServerType type) {
		return GateServer.getInstance().getServerChannelMap(type);
	}

	@Override
	public List<Integer> getServerList(ServerType type) {
		if (type == ServerType.PLAYER) {
			return playerServer;
		} else if (type == ServerType.GAME) {
			return gameServer;
		} else if (type == ServerType.GLOBAL) {
			return globalServer;
		}
		return null;
	}

	public void addServer(ServerType type, int serverID) {
		if (type == ServerType.PLAYER) {
			playerServer.add(serverID);
		} else if (type == ServerType.GAME) {
			gameServer.add(serverID);
		} else if (type == ServerType.GLOBAL) {
			globalServer.add(serverID);
		}
	}

	public void removeServer(ServerType type, int serverID) {
		if (type == ServerType.PLAYER) {
			playerServer.remove((Integer) serverID);
		} else if (type == ServerType.GAME) {
			gameServer.remove((Integer) serverID);
		} else if (type == ServerType.GLOBAL) {
			globalServer.remove((Integer) serverID);
		}
	}

	public void sendClient4AllRole(MessageLite msg) {
		Collection<BaseChannel> list = roleChannelMap.asMap().values();
		for (BaseChannel channel : list) {
			channel.sendMsg(msg);
		}
	}
}
