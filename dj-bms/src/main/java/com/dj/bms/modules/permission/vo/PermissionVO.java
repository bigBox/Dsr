package com.dj.bms.modules.permission.vo;

import com.dj.bms.common.annotation.VO2DTO;
import com.dj.bms.common.enums.ConverPolicy;
import com.dj.bms.common.vo.BaseVO;

/**
 * @author zcq
 * @date 2020-02-29
 */
public class PermissionVO implements BaseVO {

	private static final long serialVersionUID = -7703641809887345703L;

	/**
	 * 权限ID
	 */
	private Integer permissionId;

	/**
	 * 权限名
	 */
	private String permissionName;

	/**
	 * 权限值
	 */
	private String permissionValue;
	
	/**
	 * 权限描述
	 */
	private String permissionDesc;
	
	/**
	 * 父级权限
	 */
	@VO2DTO(targets = {"parentPermissionDTO"}, policy = ConverPolicy.VO_CONVER_DTO)
	private PermissionVO parentPermissionVO;
	
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
		return permissionId;
	}

	@Override
	public void setPrimaryKey(Integer primaryKey) {
		this.permissionId = primaryKey;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionValue() {
		return permissionValue;
	}

	public void setPermissionValue(String permissionValue) {
		this.permissionValue = permissionValue;
	}

	public String getPermissionDesc() {
		return permissionDesc;
	}

	public void setPermissionDesc(String permissionDesc) {
		this.permissionDesc = permissionDesc;
	}

	public PermissionVO getParentPermissionVO() {
		return parentPermissionVO;
	}

	public void setParentPermissionVO(PermissionVO parentPermissionVO) {
		this.parentPermissionVO = parentPermissionVO;
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
		return "PermissionVO [permissionId=" + permissionId + ", permissionName=" + permissionName
				+ ", permissionValue=" + permissionValue + ", permissionDesc=" + permissionDesc
				+ ", parentPermissionVO=" + parentPermissionVO + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}

}
