package com.dj.bms.modules.app.dto;

import java.util.Date;

import com.dj.bms.common.annotation.DTO2DO;
import com.dj.bms.common.annotation.DTO2VO;
import com.dj.bms.common.dto.BaseDTO;
import com.dj.bms.common.enums.ConverPolicy;
import com.dj.bms.modules.user.dto.UserDTO;

/**
 * 应用类别 DTO
 * 
 * @author zcq
 * @date 2020-03-08
 */
public class AppCategoryDTO implements BaseDTO {

	private static final long serialVersionUID = 7366648015139963292L;

	/**
	 * 应用类别ID
	 */
	private String appCategoryId;

	/**
	 * 创建人
	 */
	@DTO2DO(sources = {"userDTO.userId"}, targets = "userId", policy = ConverPolicy.COPY_PROPERTIES)
	@DTO2VO(sources = {"userDTO.userId", "userDTO.userName"}, targets = {"userId", "userName"}, policy = ConverPolicy.COPY_PROPERTIES)
	private UserDTO userDTO;

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
	@DTO2VO(targets = {"createDate"}, policy = ConverPolicy.DATE_CONVER_STRING)
	private Date createDate;

	/**
	 * 更新时间
	 */
	@DTO2VO(targets = {"createDate"}, policy = ConverPolicy.DATE_CONVER_STRING)
	private Date updateDate;

	public String getAppCategoryId() {
		return appCategoryId;
	}

	public void setAppCategoryId(String appCategoryId) {
		this.appCategoryId = appCategoryId;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
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
		return "AppCategoryDTO [appCategoryId=" + appCategoryId + ", userDTO=" + userDTO + ", appCategoryName="
				+ appCategoryName + ", appCategoryDesc=" + appCategoryDesc + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}

}
