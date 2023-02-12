package com.dj.bms.modules.tag.model;

import com.dj.bms.common.dao.mapper.annotation.Id;
import com.dj.bms.common.dao.mapper.annotation.Table;
import com.dj.bms.common.dao.mapper.enums.IdType;
import com.dj.bms.common.entity.BaseDO;

import java.util.Date;

/**
 * 标签实体
 * @author zcq
 * 2018年6月3日
 * 下午8:09:32
 * TODO
 */
@Table(value = "tag")
public class Tag implements BaseDO {

	/**
	 * 标签ID
	 */
	@Id(value = "tag_id")
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
	private Date createDate;

	/**
	 * 更新时间
	 */
	private Date updateDate;

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
		return "Tag {tagId=" + tagId + ", tagName=" + tagName + ", tagState=" + tagState + ", tagAvatar=" + tagAvatar
				+ ", tagContent=" + tagContent + ", createDate=" + createDate + ", updateDate=" + updateDate + "}";
	}

}
