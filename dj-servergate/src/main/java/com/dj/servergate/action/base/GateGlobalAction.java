package com.dj.servergate.action.base;

import com.dj.protobuf.ServerType;
import com.dj.servergate.manager.ChannelManager;
import com.google.protobuf.MessageLite;

public abstract class GateGlobalAction extends BaseGateAction {
	
	@Override
	public void sendForward2Logic(long roleID, MessageLite content) {
		sendForward2Global(roleID, content, "");
	}
	
	protected abstract void sendForward2Global(long roleID, MessageLite content, String ps);

	protected void sendMsg2Global(int serverID, MessageLite content) {
		ChannelManager.getInstance().sendToConnectServer(ServerType.GLOBAL, serverID, content);
	}

	protected int getServerID(long roleID) {
		return super.getServerID(ServerType.GLOBAL, roleID);
	}
}