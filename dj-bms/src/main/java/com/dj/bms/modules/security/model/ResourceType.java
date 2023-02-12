package com.dj.bms.modules.security.model;

import com.dj.bms.common.dao.mapper.annotation.Id;
import com.dj.bms.common.dao.mapper.annotation.Table;
import com.dj.bms.common.dao.mapper.enums.IdType;
import com.dj.bms.common.entity.BaseDO;

/**
 * 资源类型实体类
 * 
 * @author zcq
 * @date 2020-03-14
 */
@Table(value = "resource_type")
public class ResourceType implements BaseDO {
	
	private static final long serialVersionUID = -8169653026249954652L;

	/**
	 * 资源类型ID
	 */
	@Id(value = "resource_type_id")
	private Integer resourceTypeId;

	/**
	 * 资源类型编码
	 */
	private Integer resourceTypeCode;
	
	/**
	 * 资源类型名称
	 */
	private String resourceTypeName;

	public Integer getResourceTypeId() {
		return resourceTypeId;
	}

	public void setResourceTypeId(Integer resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}
	
	public Integer getResourceTypeCode() {
		return resourceTypeCode;
	}

	public void setResourceTypeCode(Integer resourceTypeCode) {
		this.resourceTypeCode = resourceTypeCode;
	}

	public String getResourceTypeName() {
		return resourceTypeName;
	}

	public void setResourceTypeName(String resourceTypeName) {
		this.resourceTypeName = resourceTypeName;
	}

	@Override
	public String toString() {
		return "ResourceType [resourceTypeId=" + resourceTypeId + ", resourceTypeCode=" + resourceTypeCode
				+ ", resourceTypeName=" + resourceTypeName + "]";
	}

}
