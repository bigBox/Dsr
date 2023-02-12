package com.dj.bms.modules.security.vo;

import com.dj.bms.common.annotation.VO2DTO;
import com.dj.bms.common.enums.ConverPolicy;
import com.dj.bms.common.vo.BaseVO;

/**
 * 资源类别 VO
 * 
 * @author zcq
 * @date 2020-03-13
 */
public class ResourceCategoryVO implements BaseVO {

	private static final long serialVersionUID = -4489042601325330174L;

	/**
	 * 资源类别ID
	 */
	private Integer resourceCategoryId;
	
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
	 * 资源类别名称
	 */
	private String resourceCategoryName;

	/**
	 * 创建时间
	 */
	@VO2DTO(targets = {"createDate"}, policy = ConverPolicy.STRING_CONVER_DATE)
	private String createDate;

	/**
	 * 更新时间
	 */
	@VO2DTO(targets = {"updateDate"}, policy = ConverPolicy.STRING_CONVER_DATE)
	private String updateDate;
	
	@Override
	public Integer getPrimaryKey() {
		return resourceCategoryId;
	}

	@Override
	public void setPrimaryKey(Integer primaryKey) {
		this.resourceCategoryId = primaryKey;
	}

	public Integer getResourceCategoryId() {
		return resourceCategoryId;
	}

	public void setResourceCategoryId(Integer resourceCategoryId) {
		this.resourceCategoryId = resourceCategoryId;
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

	public String getResourceCategoryName() {
		return resourceCategoryName;
	}

	public void setResourceCategoryName(String resourceCategoryName) {
		this.resourceCategoryName = resourceCategoryName;
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
		return "ResourceCategoryVO [resourceCategoryId=" + resourceCategoryId + ", userId=" + userId + ", userName="
				+ userName + ", resourceCategoryName=" + resourceCategoryName + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}

}
