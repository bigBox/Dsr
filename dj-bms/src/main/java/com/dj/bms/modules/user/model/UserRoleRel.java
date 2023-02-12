package com.dj.bms.modules.user.model;

import java.util.Date;

import com.dj.bms.common.entity.BaseDO;

/**
 * 用户和角色多对多关联实体类
 * 
 * @author zcq
 * @date 2020-02-23
 */
public class UserRoleRel implements BaseDO {

	private static final long serialVersionUID = -5789421283890332085L;

	private Integer userRoleRelId;

	private Integer userId;

	private Integer roleId;

	private Date createDate;

	private Date updateDate;

	public Integer getUserRoleRelId() {
		return userRoleRelId;
	}

	public void setUserRoleRelId(Integer userRoleRelId) {
		this.userRoleRelId = userRoleRelId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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
		return "UserRoleRel [userRoleRelId=" + userRoleRelId + ", userId=" + userId + ", roleId=" + roleId
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

}
