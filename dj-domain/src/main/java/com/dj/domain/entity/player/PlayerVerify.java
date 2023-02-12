package com.dj.domain.entity.player;

import java.util.Date;
import java.util.List;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.collection.ListUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerVerify extends BaseEntity implements Comparable<PlayerVerify> {
	private static final long serialVersionUID = -138621416927726478L;

	public PlayerVerify(long roleID) {
		super(roleID);
	}

	private int verifyID;

	/**
	 * 鉴定人(多个)
	 */
	private String verifyRoleID;
	private List<Long> verifyRoleIDList;

	/**
	 * 鉴定完成时间
	 */
	private Date verifyFinishTime;
	/**
	 *	获得宝物
	 */
	private int resultItem;
	/**
	 *	获得声望
	 */
	private int resultRep;
	
	/**
	 * 历史记录
	 */
	private List<PlayerVerifyHistory> historyList;

//	@Override
//	public String getPrimaryKeyName() {
//		return "verifyID";
//	}
//
//	@Override
//	public Object getPrimaryKeyValue() {
//		return verifyID;
//	}

	@Override
	public IEntity copy() {
		PlayerVerify item = new PlayerVerify();
		copySuper(item);
		item.setVerifyID(verifyID);
		item.setVerifyRoleID(getVerifyRoleID());
		item.setVerifyFinishTime(verifyFinishTime);
		item.setResultItem(resultItem);
		item.setResultRep(resultRep);
		return item;
	}
	
	@Override
	public int compareTo(PlayerVerify verify) {
		return Long.valueOf(this.id - verify.getId()).intValue();
	}
	
	public String getVerifyRoleID() {
		if(verifyRoleIDList != null) {
			verifyRoleID = ListUtil.listLongToCommaString(verifyRoleIDList);
		}
		return verifyRoleID;
	}
	
	public List<Long> getVerifyRoleIDList() {
		if(verifyRoleIDList == null && StringUtil.isNotEmpty(verifyRoleID)) {
			verifyRoleIDList = ListUtil.commaStringToLongList(verifyRoleID);
		}
		return verifyRoleIDList;
	}
}