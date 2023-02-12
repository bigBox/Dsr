package com.dj.servergate.action.player;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardPlayerGmReq;
import com.dj.protobuf.forward.ForwardPlayerGmRsp;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergate.action.base.GatePlayerAction;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;
import lombok.extern.slf4j.Slf4j;

/**
 * @description 玩家GM
 * @author zcq
 * @date 2019年7月17日
 */
@Slf4j
@IActionModule(module = Module.PLAYER_GM)
public class GatePlayerGmAction extends GatePlayerAction {

	
	@IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_PLAYER_GM_RSP)
	public void forwardPlayerGmRsp(MyMsg msg) {
		ForwardPlayerGmRsp forward = msg.getContent(ForwardPlayerGmRsp.class);
		GeneratedMessageV3 rspContent = getForwardRsp(forward.getRspClz(), forward.getRsp());
		sendClient4Role(forward.getRoleID(), rspContent);
	}

	protected void sendForward2Player(long roleID, MessageLite content, String ps) {
		ForwardPlayerGmReq.Builder builder = ForwardPlayerGmReq.newBuilder();
		builder.setRoleID(roleID);
		builder.setReqClz(content.getClass().getName());
		builder.setReq(content.toByteString());
		builder.setPs(ps);
		sendMsg2Player(getServerID(roleID), builder.build());
	}
}
