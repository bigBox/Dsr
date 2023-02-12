package com.dj.bms.modules.app.vo;

import com.dj.bms.common.annotation.VO2DTO;
import com.dj.bms.common.enums.ConverPolicy;
import com.dj.bms.common.vo.BaseVO;
import com.dj.bms.modules.app.enums.AppStatusEnum;

/**
 * 应用 VO
 * 
 * @author zcq
 * @date 2020-03-08
 */
public class AppVO implements BaseVO {

	private static final long serialVersionUID = 6736289104641833670L;

	/**
	 * 应用ID
	 */
	private Integer appId;

	/**
	 * 应用类别ID
	 */
	@VO2DTO(targets = {"appCategoryDTO"}, policy = ConverPolicy.ID_CONVER_DTO, service = "appCategoryServiceImpl")
	private Integer appCategoryId;

	/**
	 * 应用类别名称
	 */
	private String appCategoryName;

	/**
	 * 创建人ID
	 */
	@VO2DTO(targets = {"userDTO"}, policy = ConverPolicy.ID_CONVER_DTO, service = "userServiceImpl")
	private Integer userId;

	/**
	 * 创建人名称
	 */
	private String userName;

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
	@VO2DTO(targets = {"appStatusEnum"}, policy = ConverPolicy.DESC_CONVER_ENUM, enumClass = AppStatusEnum.class)
	private Integer appStatus;

	/**
	 * 创建时间
	 */
	@VO2DTO(targets = {"createDate"}, policy = ConverPolicy.STRING_CONVER_DATE)
	private String createDate;

	/**
	 * 更新时间
	 */
	@VO2DTO(targets = {"createDate"}, policy = ConverPolicy.STRING_CONVER_DATE)
	private String updateDate;

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

	public String getAppCategoryName() {
		return appCategoryName;
	}

	public void setAppCategoryName(String appCategoryName) {
		this.appCategoryName = appCategoryName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return appId;
	}

	@Override
	public void setPrimaryKey(Integer primaryKey) {
		this.appId = primaryKey;
	}

	@Override
	public String toString() {
		return "AppVO [appId=" + appId + ", appCategoryId=" + appCategoryId + ", appCategoryName=" + appCategoryName
				+ ", userId=" + userId + ", userName=" + userName + ", appName=" + appName + ", appDesc=" + appDesc
				+ ", appIcon=" + appIcon + ", appIndex=" + appIndex + ", appStatus=" + appStatus + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}

}
