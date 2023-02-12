package com.dj.bms.modules.security.model;

import java.util.Date;

import com.dj.bms.common.dao.mapper.annotation.Id;
import com.dj.bms.common.dao.mapper.annotation.Table;
import com.dj.bms.common.dao.mapper.enums.IdType;
import com.dj.bms.common.entity.BaseDO;

/**
 * 权限与资源多对多关联关系实体类
 * 
 * @author zcq
 * @date 2020-03-18
 */
@Table(value = "permission_resource_rel")
public class PermissionResourceRel implements BaseDO {

	private static final long serialVersionUID = 828362395209822648L;

	/**
	 * 主键
	 */
	@Id(value = "permission_resource_rel_id")
	private Integer permissionResourceRelId;

	/**
	 * 权限ID
	 */
	private Integer permissionId;
	
	/**
	 * 资源ID
	 */
	private Integer resourceId;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 更新时间
	 */
	private Date updateDate;

	public Integer getPermissionResourceRelId() {
		return permissionResourceRelId;
	}

	public void setPermissionResourceRelId(Integer permissionResourceRelId) {
		this.permissionResourceRelId = permissionResourceRelId;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
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
		return "PermissionResourceRel {permissionResourceRelId=" + permissionResourceRelId + ", permissionId="
				+ permissionId + ", resourceId=" + resourceId + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "}";
	}

}
