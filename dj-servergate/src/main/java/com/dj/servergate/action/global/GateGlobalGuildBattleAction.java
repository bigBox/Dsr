package com.dj.servergate.action.global;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardGlobalGuildBattleReq;
import com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergate.action.base.GateGlobalAction;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;

/**
 * @description 商会战斗
 * @author zcq
 * @date 2020年7月31日
 */
@IActionModule(module = Module.GLOBAL_GUILD_BATTLE)
public class GateGlobalGuildBattleAction extends GateGlobalAction {

	@IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_GLOBALGUILDBATTLE_RSP)
	public void forwardGlobalGuildBattleRsp(MyMsg msg) {
		ForwardGlobalGuildBattleRsp forward = msg.getContent(ForwardGlobalGuildBattleRsp.class);
		GeneratedMessageV3 rspContent = getForwardRsp(forward.getRspClz(), forward.getRsp());
		sendClient4Role(forward.getRoleID(), rspContent);
	}

	public void sendForward2Global(long roleID, MessageLite content, String ps) {
		ForwardGlobalGuildBattleReq.Builder builder = ForwardGlobalGuildBattleReq.newBuilder();
		builder.setRoleID(roleID);
		builder.setReqClz(content.getClass().getName());
		builder.setReq(content.toByteString());
		builder.setPs(ps);
		sendMsg2Global(getServerID(roleID), builder.build());
	}
}
