package com.dj.servergate.action.player;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardPlayerHomeReq;
import com.dj.protobuf.forward.ForwardPlayerHomeRsp;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergate.action.base.GatePlayerAction;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;
import lombok.extern.slf4j.Slf4j;

/**
 * @description 玩家主页
 * @author zcq
 * @date 2019年4月18日
 */
@Slf4j
@IActionModule(module = Module.PLAYER_HOME)
public class GatePlayerHomeAction extends GatePlayerAction {

	@IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_PLAYER_HOME_RSP)
	public void forwardPlayerHomeRsp(MyMsg msg) {
		ForwardPlayerHomeRsp forward = msg.getContent(ForwardPlayerHomeRsp.class);
		GeneratedMessageV3 rspContent = getForwardRsp(forward.getRspClz(), forward.getRsp());
		sendClient4Role(forward.getRoleID(), rspContent);
	}

	protected void sendForward2Player(long roleID, MessageLite content, String ps) {
		ForwardPlayerHomeReq.Builder builder = ForwardPlayerHomeReq.newBuilder();
		builder.setRoleID(roleID);
		builder.setReqClz(content.getClass().getName());
		builder.setReq(content.toByteString());
		builder.setPs(ps);
		sendMsg2Player(getServerID(roleID), builder.build());
	}
}
