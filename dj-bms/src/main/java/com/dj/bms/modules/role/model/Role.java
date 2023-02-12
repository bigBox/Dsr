package com.dj.bms.modules.role.model;

import java.util.Date;

import com.dj.bms.common.dao.mapper.annotation.Id;
import com.dj.bms.common.dao.mapper.annotation.Table;
import com.dj.bms.common.dao.mapper.enums.IdType;
import com.dj.bms.common.entity.BaseDO;

/**
 * 角色实体类
 * 
 * @author zcq
 * @date 2020-02-23
 */
@Table(value = "role")
public class Role implements BaseDO {

	private static final long serialVersionUID = -6603188377095625503L;
	
	@Id(value = "role_id")
	private Integer roleId;
	
	private String roleName;
	
	private String roleDesc;
	
	private Date createDate;
	
	private Date updateDate;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
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
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}

}
