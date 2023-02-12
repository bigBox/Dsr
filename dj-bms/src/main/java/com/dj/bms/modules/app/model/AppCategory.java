package com.dj.bms.modules.app.model;

import java.util.Date;

import com.dj.bms.common.annotation.DO2DTO;
import com.dj.bms.common.dao.mapper.annotation.Id;
import com.dj.bms.common.dao.mapper.annotation.Table;
import com.dj.bms.common.dao.mapper.enums.IdType;
import com.dj.bms.common.entity.BaseDO;
import com.dj.bms.common.enums.ConverPolicy;

/**
 * 应用类别实体类
 * 
 * @author zcq
 * @date 2020-03-08
 */
@Table(value = "app_category")
public class AppCategory implements BaseDO {

	private static final long serialVersionUID = 6044295797141106342L;

	/**
	 * 应用类别ID
	 */
	@Id(value = "app_category_id")
	private Integer appCategoryId;

	/**
	 * 创建人ID
	 */
	@DO2DTO(targets = {"userDTO"}, policy = ConverPolicy.ID_CONVER_DTO, service = "userServiceImpl")
	private Integer userId;

	/**
	 * 应用类别名称
	 */
	private String appCategoryName;
	
	/**
	 * 应用类别描述
	 */
	private String appCategoryDesc;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 更新时间
	 */
	private Date updateDate;

	public Integer getAppCategoryId() {
		return appCategoryId;
	}

	public void setAppCategoryId(Integer appCategoryId) {
		this.appCategoryId = appCategoryId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAppCategoryName() {
		return appCategoryName;
	}

	public void setAppCategoryName(String appCategoryName) {
		this.appCategoryName = appCategoryName;
	}

	public String getAppCategoryDesc() {
		return appCategoryDesc;
	}

	public void setAppCategoryDesc(String appCategoryDesc) {
		this.appCategoryDesc = appCategoryDesc;
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
		return "AppCategory [appCategoryId=" + appCategoryId + ", userId=" + userId + ", appCategoryName="
				+ appCategoryName + ", appCategoryDesc=" + appCategoryDesc + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}

}
