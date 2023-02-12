package com.dj.domain.entity.player;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import com.dj.protobuf.common.BaseRoleInfo;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.friend.EFriendApplyType;
import com.dj.protobuf.friend.FriendInfo;
import com.dj.protobuf.friend.FriendRedDot;
import com.dj.protobuf.friend.FriendType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerFriend extends BaseEntity {
	private static final long serialVersionUID = -2235262471881600566L;

	public PlayerFriend(long roleID) {
		super(roleID);
	}

	private long friendID;

	private int friendType;

//	@Override
//	public String getPrimaryKeyName() {
//		return "friendID";
//	}
//
//	@Override
//	public Object getPrimaryKeyValue() {
//		return friendID;
//	}

	@Override
	public IEntity copy() {
		PlayerFriend playerFriend = new PlayerFriend();
		copySuper(playerFriend);
		playerFriend.setFriendID(friendID);
		playerFriend.setFriendType(friendType);
		return playerFriend;
	}

	@SuppressWarnings("deprecation")
	public FriendInfo toFriendInfo(FriendInfo.Builder builder, BaseRoleInfo roleInfo, FriendRedDot redDot) {
		builder.setRoleInfo(roleInfo);
		builder.setSendGiftTime(DateTime.newBuilder());
		builder.setReceiveGift(0);
		builder.setFriendType(FriendType.valueOf(friendType));
		builder.setApplyDate(DateTime.newBuilder());
		builder.setApplyType(EFriendApplyType.FAT_Normal);
		builder.setRedDot(redDot);
		return builder.build();
	}
}