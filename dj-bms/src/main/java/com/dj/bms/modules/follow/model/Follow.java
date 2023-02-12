package com.dj.bms.modules.follow.model;

import java.util.Date;

import com.dj.bms.common.dao.mapper.annotation.Id;
import com.dj.bms.common.dao.mapper.annotation.Table;
import com.dj.bms.common.entity.BaseDO;

/**
 * 关注实体
 * @author zcq
 * 2018年7月1日
 * 下午8:28:39
 * TODO
 */
@Table("follow")
public class Follow implements BaseDO {

	private static final long serialVersionUID = -7347985930759632454L;

	/**
	 * 关注ID
	 */
	@Id("follow_id")
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
	private Date createDate;

	/**
	 * 更新时间
	 */
	private Date updateDate;

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Follow {followId=" + followId + ", sourceId=" + sourceId + ", targetId=" + targetId + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "}";
	}

}