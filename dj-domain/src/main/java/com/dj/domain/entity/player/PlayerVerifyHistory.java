package com.dj.domain.entity.player;

import java.util.Date;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import com.dj.protobuf.common.BaseRoleInfo;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.verify.VerifyHistory;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerVerifyHistory extends BaseEntity implements Comparable<PlayerVerifyHistory> {
	private static final long serialVersionUID = -138621416927726478L;

	public PlayerVerifyHistory(long roleID) {
		super(roleID);
	}

	private int verifyID;

	/**
	 * 鉴定人
	 */
	private long verifyRoleID;

	/**
	 * 鉴定时间
	 */
	private Date verifyTime;
	/**
	 * 鉴定减少的时间(分钟)
	 */
	private int verifyCD;

	@Override
	public IEntity copy() {
		PlayerVerifyHistory item = new PlayerVerifyHistory();
		copySuper(item);
		item.setVerifyID(verifyID);
		item.setVerifyRoleID(getVerifyRoleID());
		item.setVerifyTime(verifyTime);
		item.setVerifyCD(verifyCD);
		return item;
	}
	
	@Override
	public int compareTo(PlayerVerifyHistory history) {
		return Long.valueOf(this.id - history.getId()).intValue();
	}

	public VerifyHistory toVerifyHistory(VerifyHistory.Builder history, BaseRoleInfo roleInfo) {
		history.setItemId(verifyID);
		history.setVerifyRoleInfo(roleInfo);
		history.setVerifyTime(DateTime.newBuilder().setValue(verifyTime.getTime()).build());
		history.setVerifyCD(verifyCD);
		return history.build();
	}
}