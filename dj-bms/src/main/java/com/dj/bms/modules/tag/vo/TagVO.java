package com.dj.bms.modules.tag.vo;

import com.dj.bms.common.vo.BaseVO;

/**
 * @author zcq
 * @date 2020-01-04
 */
public class TagVO implements BaseVO {

	private static final long serialVersionUID = 2297537422753323536L;

	/**
	 * 标签ID
	 */
	private Integer tagId;

	/**
	 * 标签名称
	 */
	private String tagName;

	/**
	 * 标签状态
	 */
	private String tagState;

	/**
	 * 标签图标
	 */
	private String tagAvatar;

	/**
	 * 标签简介
	 */
	private String tagContent;

	/**
	 * 创建时间
	 */
	private String createDate;

	/**
	 * 更新时间
	 */
	private String updateDate;

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagState() {
		return tagState;
	}

	public void setTagState(String tagState) {
		this.tagState = tagState;
	}

	public String getTagAvatar() {
		return tagAvatar;
	}

	public void setTagAvatar(String tagAvatar) {
		this.tagAvatar = tagAvatar;
	}

	public String getTagContent() {
		return tagContent;
	}

	public void setTagContent(String tagContent) {
		this.tagContent = tagContent;
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
		return tagId;
	}
	
	@Override
	public void setPrimaryKey(Integer primaryKey) {
		this.tagId = primaryKey;
	}
	
	@Override
	public String toString() {
		return "TagVO {tagId=" + tagId + ", tagName=" + tagName + ", tagState=" + tagState + ", tagAvatar=" + tagAvatar
				+ ", tagContent=" + tagContent + ", createDate=" + createDate + ", updateDate=" + updateDate + "}";
	}

}
