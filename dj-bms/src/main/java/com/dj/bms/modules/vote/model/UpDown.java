package com.dj.bms.modules.vote.model;

import java.util.Date;

/**
 * 点赞
 * @author zcq
 * 2018年8月11日
 * 上午10:31:00
 * TODO
 */
public class UpDown {

	/**
	 * 主键ID
	 */
	private Integer id;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	
	/**
	 * 话题ID
	 */
	private Integer topicId;
	
	/**
	 * true:up false:down
	 */
	private boolean upDown;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 是否删除 true:否  false:是
	 */
	private boolean isDelete;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer uid) {
		this.userId = uid;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer tid) {
		this.topicId = tid;
	}

	public boolean isUpDown() {
		return upDown;
	}

	public void setUpDown(boolean upDown) {
		this.upDown = upDown;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "UpDown [id=" + id + ", userId=" + userId + ", topicId=" + topicId + ", upDown=" + upDown + ", createDate="
				+ createDate + ", isDelete=" + isDelete + "]";
	}
	
}
