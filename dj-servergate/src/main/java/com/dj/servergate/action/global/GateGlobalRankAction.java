package com.dj.servergate.action.global;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardGlobalRankReq;
import com.dj.protobuf.forward.ForwardGlobalRankRsp;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergate.action.base.GateGlobalAction;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;

/**
 * @description 排行榜
 * @author zcq
 * @date 2019年4月18日
 */
@IActionModule(module = Module.GLOBAL_RANK)
public class GateGlobalRankAction extends GateGlobalAction {

	@IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_GLOBALRANK_RSP)
	public void forwardGlobalRankRsp(MyMsg msg) {
		ForwardGlobalRankRsp forward = msg.getContent(ForwardGlobalRankRsp.class);
		GeneratedMessageV3 rspContent = getForwardRsp(forward.getRspClz(), forward.getRsp());
		sendClient4Role(forward.getRoleID(), rspContent);
	}

	protected void sendForward2Global(long roleID, MessageLite content, String ps) {
		ForwardGlobalRankReq.Builder builder = ForwardGlobalRankReq.newBuilder();
		builder.setRoleID(roleID);
		builder.setReqClz(content.getClass().getName());
		builder.setReq(content.toByteString());
		builder.setPs(ps);
		sendMsg2Global(getServerID(roleID), builder.build());
	}
}
