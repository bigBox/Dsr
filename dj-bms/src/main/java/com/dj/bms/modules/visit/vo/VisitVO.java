package com.dj.bms.modules.visit.vo;

import com.dj.bms.common.vo.BaseVO;

/**
 * @author zcq
 * @date 2020-02-07
 */
public class VisitVO implements BaseVO {

	private static final long serialVersionUID = -5653061817547475903L;

	/**
	 * 访问ID
	 */
	private Integer visitId;

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
	private String createDate;

	/**
	 * 更新时间
	 */
	private String updateDate;


	public Integer getVisitId() {
		return visitId;
	}


	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
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
		return visitId;
	}

	@Override
	public void setPrimaryKey(Integer primaryKey) {
		this.visitId = primaryKey;
	}

	@Override
	public String toString() {
		return "VisitVO {visitId=" + visitId + ", sourceId=" + sourceId + ", targetId=" + targetId + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "}";
	}

}