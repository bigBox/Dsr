package com.dj.bms.modules.follow.vo;

import com.dj.bms.common.vo.BaseVO;

/**
 * @author zcq
 * @date 2020-02-07
 */
public class FollowVO implements BaseVO {

	private static final long serialVersionUID = -8919635128894048822L;

	/**
	 * 关注ID
	 */
	private Integer followId;

	/**
	 * 关注者ID
	 */
	private Integer sourceId;

	/**
	 * 被关注者ID
	 */
	private Integer targetId;

	/**
	 * 创建时间
	 */
	private String createDate;

	/**
	 * 更新时间
	 */
	private String updateDate;

	public Integer getFollowId() {
		return followId;
	}


	public void setFollowId(Integer followId) {
		this.followId = followId;
	}


	public Integer getSourceId() {
		return sourceId;
	}


	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}


	public Integer getTargetId() {
		return targetId;
	}


	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public String getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}


	@Override
	public Integer getPrimaryKey() {
		return followId;
	}

	@Override
	public void setPrimaryKey(Integer primaryKey) {
		this.followId = primaryKey;
	}

	@Override
	public String toString() {
		return "FollowVO {followId=" + followId + ", sourceId=" + sourceId + ", targetId=" + targetId + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "}";
	}

}