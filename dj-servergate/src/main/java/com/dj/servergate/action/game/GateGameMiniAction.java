package com.dj.servergate.action.game;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardGameMiniReq;
import com.dj.protobuf.forward.ForwardGameMiniRsp;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergate.action.base.GateGameAction;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;

/**
 * @description 小游戏
 * @author zcq
 * @date 2019年5月24日
 */
@IActionModule(module = Module.GAME_MINI)
public class GateGameMiniAction extends GateGameAction {

	@IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_GAMEMINI_RSP)
	public void forwardGameMiniRsp(MyMsg msg) {
		ForwardGameMiniRsp forward = msg.getContent(ForwardGameMiniRsp.class);
		GeneratedMessageV3 rspContent = getForwardRsp(forward.getRspClz(), forward.getRsp());
		sendClient4Role(forward.getRoleID(), rspContent);
	}

	protected void sendForward2Game(long roleID, MessageLite content, String ps) {
		ForwardGameMiniReq.Builder builder = ForwardGameMiniReq.newBuilder();
		builder.setRoleID(roleID);
		builder.setReqClz(content.getClass().getName());
		builder.setReq(content.toByteString());
		builder.setPs(ps);
		sendMsg2Game(getServerID(roleID), builder.build());
	}
}
