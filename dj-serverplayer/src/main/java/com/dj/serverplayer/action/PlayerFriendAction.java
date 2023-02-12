package com.dj.serverplayer.action;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.forward.ForwardPlayerFriendReq;
import com.dj.protobuf.forward.ForwardPlayerFriendRsp;
import com.dj.protobuf.friend.*;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.action.base.IFieldHandler;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.serverplayer.handler.FriendHandler;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.google.protobuf.GeneratedMessageV3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: PlayerFriendAction
 * @Description: 玩家好友
 * @author zcq
 * @date 2019年6月25日
 */
@Data
@Slf4j
@EqualsAndHashCode(callSuper = false)
@IActionModule(module = Module.PLAYER_FRIEND)
public class PlayerFriendAction extends BaseAction {
	@IFieldHandler
	private FriendHandler friendHandler;

	@IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_PLAYER_FRIEND_REQ)
	public Long forwardPlayerFriendReq(MyMsg msg) {
		ForwardPlayerFriendReq forward = msg.getContent(ForwardPlayerFriendReq.class);
		try {
			GeneratedMessageV3 rspContent = doReqHandler(forward.getRoleID(), forward.getReqClz(), forward.getReq());
			if (rspContent != null) {
				ForwardPlayerFriendRsp.Builder builder = msg.getResultBuilder(ForwardPlayerFriendRsp.class);
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

	// 好友列表
	public GeneratedMessageV3 friendListReq(long roleID, FriendListReq req) {
		FriendListRsp.Builder builder = FriendListRsp.newBuilder();
		ErrorID result = handleService(() -> {
			friendHandler.getFriends(roleID, builder);
			friendHandler.getApplies(roleID, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 好友申请
	public GeneratedMessageV3 friendApplyReq(long roleID, FriendApplyReq req) {
		FriendApplyRsp.Builder builder = FriendApplyRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			friendHandler.friendApply(req.getRoleIdList(), roleID, req.getApplyType());
			builder.addAllRoleId(req.getRoleIdList());
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 好友批准
	public GeneratedMessageV3 friendApproveReq(long roleID, FriendApproveReq req) {
		FriendApproveRsp.Builder builder = FriendApproveRsp.newBuilder();
		builder.setReq(req);
		ErrorID result = handleService(() -> {
			friendHandler.friendApproveList(req.getTargetRoleIdList(), roleID, req.getAgree());
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 好友移除
	public GeneratedMessageV3 removeFriendReq(long roleID, RemoveFriendReq req) {
		RemoveFriendRsp.Builder builder = RemoveFriendRsp.newBuilder();
		ErrorID result = handleService(() -> {
			builder.setRoleId(req.getRoleId());
			builder.setRemovedByRole(roleID);
			friendHandler.removeFriend(req.getRoleId(), roleID);
		});
		builder.setErrorID(result);
		return builder.build();
	}
	
	// 好友查找
	public GeneratedMessageV3 friendSearchReq(long roleID, FriendSearchReq req) {
		FriendSearchRsp.Builder builder = FriendSearchRsp.newBuilder();
		ErrorID result = handleService(() -> {
			friendHandler.friendSearch(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}

	// 好友查找
	public GeneratedMessageV3 friendRecommendReq(long roleID, FriendRecommendReq req) {
		FriendRecommendRsp.Builder builder = FriendRecommendRsp.newBuilder();
		ErrorID result = handleService(() -> {
			friendHandler.friendRecommend(roleID, req, builder);
		});
		builder.setErrorID(result);
		return builder.build();
	}
}
