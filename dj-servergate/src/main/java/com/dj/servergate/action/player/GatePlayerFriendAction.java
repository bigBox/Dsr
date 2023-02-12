package com.dj.servergate.action.player;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardPlayerFriendReq;
import com.dj.protobuf.forward.ForwardPlayerFriendRsp;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergate.action.base.GatePlayerAction;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;
import lombok.extern.slf4j.Slf4j;

/**
 * @description 玩家好友
 * @author zcq
 * @date 2019年4月18日
 */
@Slf4j
@IActionModule(module = Module.PLAYER_FRIEND)
public class GatePlayerFriendAction extends GatePlayerAction {

	@IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_PLAYER_FRIEND_RSP)
	public void forwardPlayerFriendRsp(MyMsg msg) {
		ForwardPlayerFriendRsp forward = msg.getContent(ForwardPlayerFriendRsp.class);
		GeneratedMessageV3 rspContent = getForwardRsp(forward.getRspClz(), forward.getRsp());
		sendClient4Role(forward.getRoleID(), rspContent);
	}

	protected void sendForward2Player(long roleID, MessageLite content, String ps) {
		ForwardPlayerFriendReq.Builder builder = ForwardPlayerFriendReq.newBuilder();
		builder.setRoleID(roleID);
		builder.setReqClz(content.getClass().getName());
		builder.setReq(content.toByteString());
		builder.setPs(ps);
		sendMsg2Player(getServerID(roleID), builder.build());
	}
}
