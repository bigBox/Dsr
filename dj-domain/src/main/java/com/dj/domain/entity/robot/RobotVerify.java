package com.dj.domain.entity.robot;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.collection.ListUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RobotVerify extends BaseEntity implements Comparable<RobotVerify> {
	private static final long serialVersionUID = -138631416927726478L;

	public RobotVerify(long roleID) {
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
	private List<RobotVerifyHistory> historyList;

	@Override
	public IEntity copy() {
		RobotVerify item = new RobotVerify();
		copySuper(item);
		item.setVerifyID(verifyID);
		item.setVerifyRoleID(getVerifyRoleID());
		item.setVerifyFinishTime(verifyFinishTime);
		item.setResultItem(resultItem);
		item.setResultRep(resultRep);
		return item;
	}
	
	@Override
	public int compareTo(RobotVerify verify) {
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