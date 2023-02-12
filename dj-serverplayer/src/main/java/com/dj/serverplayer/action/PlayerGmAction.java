package com.dj.serverplayer.action;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.forward.ForwardPlayerGmReq;
import com.dj.protobuf.forward.ForwardPlayerGmRsp;
import com.dj.protobuf.gm.ReadItemReq;
import com.dj.protobuf.gm.ReadItemRsp;
import com.dj.protobuf.gm.ReadRoleReq;
import com.dj.protobuf.gm.ReadRoleRsp;
import com.dj.protobuf.gm.WriteRoleReq;
import com.dj.protobuf.gm.WriteRoleRsp;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.action.base.IFieldHandler;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.serverplayer.handler.GmHandler;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.google.protobuf.GeneratedMessageV3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: PlayerGmAction
 * @Description: 玩家GM
 * @author zcq
 * @date 2019年7月17日
 */
@Data
@Slf4j
@EqualsAndHashCode(callSuper = false)
@IActionModule(module = Module.PLAYER_GM)
public class PlayerGmAction extends BaseAction {

	@IFieldHandler
	private GmHandler gmHandler;

	@IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_PLAYER_GM_REQ)
	public Long forwardPlayerGmReq(MyMsg msg) {
		ForwardPlayerGmReq forward = msg.getContent(ForwardPlayerGmReq.class);
		try {
			GeneratedMessageV3 rspContent = doReqHandler(forward.getRoleID(), forward.getReqClz(), forward.getReq());
			if (rspContent != null) {
				ForwardPlayerGmRsp.Builder builder = msg.getResultBuilder(ForwardPlayerGmRsp.class);
				builder.setRoleID(forward.getRoleID());
				builder.setRsp(rspContent.toByteString());
				builder.setRspClz(rspContent.getClass().getName());
				log.debug("roleID 【{}】, rsp:{}, content:{}", forward.getRoleID(), rspContent.getClass().getSimpleName(), StringUtil.msg2Json(rspContent));
			}
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
		}
		return forward.getRoleID();
	}

	// 读取角色信息
	public GeneratedMessageV3 readRoleReq(long roleID, ReadRoleReq req) {
		ReadRoleRsp.Builder builder = ReadRoleRsp.newBuilder();
		ErrorID result = handleService(() -> {
			gmHandler.readRole(req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 写入角色信息
	public GeneratedMessageV3 writeRoleReq(long roleID, WriteRoleReq req) {
		WriteRoleRsp.Builder builder = WriteRoleRsp.newBuilder();
		ErrorID result = handleService(() -> {
			gmHandler.writeRole(req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 读取仓库信息
	public GeneratedMessageV3 readItemReq(long roleID, ReadItemReq req) {
		ReadItemRsp.Builder builder = ReadItemRsp.newBuilder();
		ErrorID result = handleService(() -> {
			gmHandler.readItem(req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}
}
