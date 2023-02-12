package com.dj.bms.modules.visit.model;

import java.util.Date;

import com.dj.bms.common.dao.mapper.annotation.Id;
import com.dj.bms.common.dao.mapper.annotation.Table;
import com.dj.bms.common.dao.mapper.enums.IdType;
import com.dj.bms.common.entity.BaseDO;

/**
 * 访问记录
 * @author zcq
 * 2018年8月4日
 * 上午11:28:01
 * TODO
 */
@Table(value = "visit")
public class Visit implements BaseDO {

	private static final long serialVersionUID = 160283767535840192L;
	/**
	 * 主键ID
	 */
	private Integer id;

	/**
	 * 访问者ID
	 */
	private Integer sourceId;

	/**
	 * 被访问者ID
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "Visit {id=" + id + ", sourceId=" + sourceId + ", targetId=" + targetId + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "}";
	}

}