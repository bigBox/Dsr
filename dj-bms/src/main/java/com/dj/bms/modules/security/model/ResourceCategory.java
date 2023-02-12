package com.dj.bms.modules.security.model;

import java.util.Date;

import com.dj.bms.common.annotation.DO2DTO;
import com.dj.bms.common.dao.mapper.annotation.Id;
import com.dj.bms.common.dao.mapper.annotation.Table;
import com.dj.bms.common.dao.mapper.enums.IdType;
import com.dj.bms.common.entity.BaseDO;
import com.dj.bms.common.enums.ConverPolicy;

/**
 * 资源类别实体类
 * 
 * @author zcq
 * @date 2020-03-13
 */
@Table(value = "resource_category")
public class ResourceCategory implements BaseDO {

	private static final long serialVersionUID = 666295338495228528L;

	/**
	 * 资源类别ID
	 */
	@Id(value = "resource_category_id")
	private Integer resourceCategoryId;
	
	/**
	 * 创建人ID
	 */
	@DO2DTO(targets = {"userDTO"}, policy = ConverPolicy.ID_CONVER_DTO, service = "userServiceImpl")
	private Integer userId;

	/**
	 * 资源类别名称
	 */
	private String resourceCategoryName;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 更新时间
	 */
	private Date updateDate;

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

	public String getResourceCategoryName() {
		return resourceCategoryName;
	}

	public void setResourceCategoryName(String resourceCategoryName) {
		this.resourceCategoryName = resourceCategoryName;
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
		return "ResourceCategory [resourceCategoryId=" + resourceCategoryId + ", userId=" + userId
				+ ", resourceCategoryName=" + resourceCategoryName + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}

}
