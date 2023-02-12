package com.dj.serverapi.service.inf;

import java.util.Map;

import com.dj.domain.data.FriendAction;
import com.dj.domain.data.FriendApply;
import com.dj.protobuf.friend.EFriendApplyType;
import com.dj.domain.util.inf.IArgumentRunnable;

public interface IFriendService {

	/**
	 *	好友申请
	 */
	FriendApply friendApply(long targetRoleID, long srcRoleID, EFriendApplyType applyType);

	/**
	 *	好友批准
	 */
	void friendApprove(long targetRoleID, long srcRoleID, IArgumentRunnable<FriendApply> run);

	/**
	 *	获取好友申请列表
	 * 
	 * @param roleID
	 * @return
	 */
	Map<Long, FriendApply> getApply(long roleID);

	/**
	 *	添加好友行为
	 * @param roleID
	 * @param action
	 */
	void addAction(long roleID, FriendAction action);

	/**
	 *	处理好友行为
	 * @param roleID
	 */
	void doAction(long roleID, IArgumentRunnable<FriendAction> run);
}
