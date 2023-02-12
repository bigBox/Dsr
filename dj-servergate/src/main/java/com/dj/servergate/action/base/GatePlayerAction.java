package com.dj.servergate.action.base;

import com.dj.protobuf.ServerType;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.servergate.manager.ChannelManager;
import com.google.protobuf.MessageLite;

public abstract class GatePlayerAction extends BaseGateAction {

	@Override
	public void sendForward2Logic(long roleID, MessageLite content) {
		sendForward2Player(roleID, content, "");
	}

	protected abstract void sendForward2Player(long roleID, MessageLite content, String ps);

	protected void sendForward2Player(String account, MessageLite content) {
		sendForward2Player(account, content, "");
	}

	protected void sendForward2Player(String account, MessageLite content, String ps) {

	}

	protected void sendMsg2Player(int serverID, MessageLite content) {
		ChannelManager.getInstance().sendToConnectServer(ServerType.PLAYER, serverID, content);
	}

	protected int getServerID(String account) {
		return super.getServerID(ServerType.PLAYER, account);
	}

	protected int getServerID(long roleID) {
		if (roleID == 0) {
			throw new CommonException(ErrorID.PLEASE_RELOGIN);
		}
		return super.getServerID(ServerType.PLAYER, roleID);
	}
}
