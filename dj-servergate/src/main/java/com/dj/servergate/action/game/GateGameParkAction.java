package com.dj.servergate.action.game;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardGameParkReq;
import com.dj.protobuf.forward.ForwardGameParkRsp;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergate.action.base.GateGameAction;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;

/**
 * @description 生态园
 * @author zcq
 * @date 2019年5月15日
 */
@IActionModule(module = Module.GAME_PARK)
public class GateGameParkAction extends GateGameAction {

	@IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_GAMEPARK_RSP)
	public void forwardGameParkRsp(MyMsg msg) {
		ForwardGameParkRsp forward = msg.getContent(ForwardGameParkRsp.class);
		GeneratedMessageV3 rspContent = getForwardRsp(forward.getRspClz(), forward.getRsp());
		sendClient4Role(forward.getRoleID(), rspContent);
	}

	protected void sendForward2Game(long roleID, MessageLite content, String ps) {
		ForwardGameParkReq.Builder builder = ForwardGameParkReq.newBuilder();
		builder.setRoleID(roleID);
		builder.setReqClz(content.getClass().getName());
		builder.setReq(content.toByteString());
		builder.setPs(ps);
		sendMsg2Game(getServerID(roleID), builder.build());
	}
}
