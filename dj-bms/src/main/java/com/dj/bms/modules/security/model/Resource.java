package com.dj.bms.modules.security.model;

import java.util.Date;

import com.dj.bms.common.annotation.DO2DTO;
import com.dj.bms.common.dao.mapper.annotation.Id;
import com.dj.bms.common.dao.mapper.annotation.Table;
import com.dj.bms.common.dao.mapper.enums.IdType;
import com.dj.bms.common.entity.BaseDO;
import com.dj.bms.common.enums.ConverPolicy;

/**
 * 资源实体类
 * 
 * @author zcq
 * @date 2020-03-13
 */
@Table(value = "resource")
public class Resource implements BaseDO {

	private static final long serialVersionUID = 248310394613977823L;

	/**
	 * 资源ID
	 */
	@Id(value = "resource_id")
	private Integer resourceId;

	/**
	 * 资源类型ID
	 */
	@DO2DTO(targets = {"resourceTypeDTO"}, policy = ConverPolicy.ID_CONVER_DTO, service = "resourceTypeServiceImpl")
	private Integer resourceTypeId;

	/**
	 * 资源类别ID
	 */
	@DO2DTO(targets = {
			"resourceCategoryDTO"}, policy = ConverPolicy.ID_CONVER_DTO, service = "resourceCategoryServiceImpl")
	private Integer resourceCategoryId;

	/**
	 * 创建人ID
	 */
	@DO2DTO(targets = {"userDTO"}, policy = ConverPolicy.ID_CONVER_DTO, service = "userServiceImpl")
	private Integer userId;

	/**
	 * 资源名称
	 */
	private String resourceName;

	/**
	 * 资源值
	 */
	private String resourceValue;

	/**
	 * 资源描述
	 */
	private String resourceDesc;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 更新时间
	 */
	private Date updateDate;

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public Integer getResourceTypeId() {
		return resourceTypeId;
	}

	public void setResourceTypeId(Integer resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
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

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceValue() {
		return resourceValue;
	}

	public void setResourceValue(String resourceValue) {
		this.resourceValue = resourceValue;
	}

	public String getResourceDesc() {
		return resourceDesc;
	}

	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc;
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
		return "Resource [resourceId=" + resourceId + ", resourceTypeId=" + resourceTypeId + ", resourceCategoryId="
				+ resourceCategoryId + ", userId=" + userId + ", resourceName=" + resourceName + ", resourceValue="
				+ resourceValue + ", resourceDesc=" + resourceDesc + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}

}
