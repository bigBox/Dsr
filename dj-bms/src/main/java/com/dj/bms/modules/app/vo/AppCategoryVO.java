package com.dj.bms.modules.app.vo;

import com.dj.bms.common.annotation.VO2DTO;
import com.dj.bms.common.enums.ConverPolicy;
import com.dj.bms.common.vo.BaseVO;

/**
 * 应用类别 VO
 * 
 * @author zcq
 * @date 2020-03-08
 */
public class AppCategoryVO implements BaseVO {

	private static final long serialVersionUID = -7554545252945989179L;

	/**
	 * 应用类别ID
	 */
	private Integer appCategoryId;

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
	@VO2DTO(targets = {"createDate"}, policy = ConverPolicy.STRING_CONVER_DATE)
	private String createDate;

	/**
	 * 更新时间
	 */
	@VO2DTO(targets = {"createDate"}, policy = ConverPolicy.STRING_CONVER_DATE)
	private String updateDate;

	@Override
	public Integer getPrimaryKey() {
		return appCategoryId;
	}

	@Override
	public void setPrimaryKey(Integer primaryKey) {
		this.appCategoryId = primaryKey;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	public String toString() {
		return "AppCategoryVO [appCategoryId=" + appCategoryId + ", userId=" + userId + ", userName=" + userName
				+ ", appCategoryName=" + appCategoryName + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
	}

}
