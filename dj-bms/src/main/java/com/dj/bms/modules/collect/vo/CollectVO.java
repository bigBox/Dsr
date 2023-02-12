package com.dj.bms.modules.collect.vo;

import com.dj.bms.common.vo.BaseVO;

/**
 * @author zcq
 * @date 2020-02-07
 */
public class CollectVO implements BaseVO {

	private static final long serialVersionUID = -3971022078121882212L;

	/**
	 * 收藏ID
	 */
	private Integer collectId;

	/**
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * 主题ID
	 */
	private Integer topicId;

	/**
	 * 创建时间
	 */
	private String createDate;

	/**
	 * 更新时间
	 */
	private String updateDate;


	public Integer getCollectId() {
		return collectId;
	}


	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getTopicId() {
		return topicId;
	}


	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
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
		return collectId;
	}

	@Override
	public void setPrimaryKey(Integer primaryKey) {
		this.collectId = primaryKey;
	}

	@Override
	public String toString() {
		return "CollectVO {collectId=" + collectId + ", userId=" + userId + ", topicId=" + topicId + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "}";
	}

}