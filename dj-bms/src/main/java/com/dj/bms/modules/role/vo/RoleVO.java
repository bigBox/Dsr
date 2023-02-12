package com.dj.bms.modules.role.vo;

import com.dj.bms.common.annotation.VO2DTO;
import com.dj.bms.common.enums.ConverPolicy;
import com.dj.bms.common.vo.BaseVO;

/**
 * 角色 VO
 * @author zcq
 * @date 2020-02-23
 */
public class RoleVO implements BaseVO {

	private static final long serialVersionUID = -8313103767808600801L;

	private Integer roleId;

	private String roleName;

	private String roleDesc;

	@VO2DTO(targets = {"createDate"}, policy = ConverPolicy.STRING_CONVER_DATE)
	private String createDate;

	@VO2DTO(targets = {"updateDate"}, policy = ConverPolicy.STRING_CONVER_DATE)
	private String updateDate;

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
		return roleId;
	}
	
	@Override
	public void setPrimaryKey(Integer primaryKey) {
		this.roleId = primaryKey;
	}
	
	@Override
	public String toString() {
		return "RoleVO [roleId=" + roleId + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}

}
