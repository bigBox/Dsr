package com.dj.servergate.action.game;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardGameHomeReq;
import com.dj.protobuf.forward.ForwardGameHomeRsp;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergate.action.base.GateGameAction;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;

/**
 * @description 游戏主页
 * @author zcq
 * @date 2019年4月18日
 */
@IActionModule(module = Module.GAME_HOME)
public class GateGameHomeAction extends GateGameAction {

	@IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_GAMEHOME_RSP)
	public void forwardGameHomeRsp(MyMsg msg) {
		ForwardGameHomeRsp forward = msg.getContent(ForwardGameHomeRsp.class);
		GeneratedMessageV3 rspContent = getForwardRsp(forward.getRspClz(), forward.getRsp());
		sendClient4Role(forward.getRoleID(), rspContent);
	}

	public void sendForward2Game(long roleID, MessageLite content, String ps) {
		ForwardGameHomeReq.Builder builder = ForwardGameHomeReq.newBuilder();
		builder.setRoleID(roleID);
		builder.setReqClz(content.getClass().getName());
		builder.setReq(content.toByteString());
		builder.setPs(ps);
		sendMsg2Game(getServerID(roleID), builder.build());
	}
}
