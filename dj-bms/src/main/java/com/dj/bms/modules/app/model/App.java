package com.dj.bms.modules.app.model;

import java.util.Date;

import com.dj.bms.common.annotation.DO2DTO;
import com.dj.bms.common.dao.mapper.annotation.Id;
import com.dj.bms.common.dao.mapper.annotation.Table;
import com.dj.bms.common.dao.mapper.enums.IdType;
import com.dj.bms.common.entity.BaseDO;
import com.dj.bms.common.enums.ConverPolicy;
import com.dj.bms.modules.app.enums.AppStatusEnum;

/**
 * 应用实体类
 * 
 * @author zcq
 * @date 2020-03-08
 */
@Table(value = "app")
public class App implements BaseDO {

	private static final long serialVersionUID = 6035941037333055293L;

	/**
	 * 应用ID
	 */
	@Id(value = "app_id")
	private Integer appId;

	/**
	 * 应用类别ID
	 */
	@DO2DTO(targets = {"appCategoryDTO"}, policy = ConverPolicy.ID_CONVER_DTO, service = "appCategoryServiceImpl")
	private Integer appCategoryId;

	/**
	 * 创建人ID
	 */
	@DO2DTO(targets = {"userDTO"}, policy = ConverPolicy.ID_CONVER_DTO, service = "userServiceImpl")
	private Integer userId;

	/**
	 * 应用名称
	 */
	private String appName;

	/**
	 * 应用描述
	 */
	private String appDesc;

	/**
	 * 应用图标
	 */
	private String appIcon;

	/**
	 * 应用首页
	 */
	private String appIndex;

	/**
	 * 应用状态
	 */
	@DO2DTO(targets = {"appStatusEnum"}, policy = ConverPolicy.CODE_CONVER_ENUM, enumClass = AppStatusEnum.class)
	private Integer appStatus;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 更新时间
	 */
	private Date updateDate;

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

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

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppDesc() {
		return appDesc;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

	public String getAppIcon() {
		return appIcon;
	}

	public void setAppIcon(String appIcon) {
		this.appIcon = appIcon;
	}

	public String getAppIndex() {
		return appIndex;
	}

	public void setAppIndex(String appIndex) {
		this.appIndex = appIndex;
	}

	public Integer getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(Integer appStatus) {
		this.appStatus = appStatus;
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
		return "App [appId=" + appId + ", appCategoryId=" + appCategoryId + ", userId=" + userId + ", appName="
				+ appName + ", appDesc=" + appDesc + ", appIcon=" + appIcon + ", appIndex=" + appIndex + ", appStatus="
				+ appStatus + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

}
