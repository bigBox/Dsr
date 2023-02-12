package com.dj.servergate.action.base;

import com.dj.protobuf.ServerType;
import com.dj.servergate.manager.ChannelManager;
import com.google.protobuf.MessageLite;

public abstract class GateGameAction extends BaseGateAction {
	
	@Override
	public void sendForward2Logic(long roleID, MessageLite content) {
		sendForward2Game(roleID, content, "");
	}
	protected abstract void sendForward2Game(long roleID, MessageLite content, String ps);

	protected void sendMsg2Game(int serverID, MessageLite content) {
		ChannelManager.getInstance().sendToConnectServer(ServerType.GAME, serverID, content);
	}

	protected int getServerID(long roleID) {
		return super.getServerID(ServerType.GAME, roleID);
	}
}
