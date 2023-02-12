package com.dj.bms.modules.menu.model;

import java.util.Date;

import com.dj.bms.common.annotation.DO2DTO;
import com.dj.bms.common.dao.mapper.annotation.Id;
import com.dj.bms.common.dao.mapper.annotation.Table;
import com.dj.bms.common.dao.mapper.enums.IdType;
import com.dj.bms.common.entity.BaseDO;
import com.dj.bms.common.enums.ConverPolicy;

/**
 * 菜单实体类
 * 
 * @author zcq
 * @date 2020-03-06
 */
@Table(value = "menu")
public class Menu implements BaseDO {
	
	private static final long serialVersionUID = -4251615965305941108L;
	
	/**
	 * 菜单ID
	 */
	@Id(value = "menu_id")
	private Integer menuId;
	
	/**
	 * 父级菜单ID
	 */
	@DO2DTO(targets = {"parentMenuDTO"}, policy = ConverPolicy.ID_CONVER_DTO, service = "menuServiceImpl")
	private Integer parentMenuId;
	
	/**
	 * 权限ID
	 */
	@DO2DTO(targets = {"permissionDTO"}, policy = ConverPolicy.ID_CONVER_DTO, service = "permissionServiceImpl")
	private Integer permissionId;
	
	/**
	 * 创建人ID
	 */
	@DO2DTO(targets = {"userDTO"}, policy = ConverPolicy.ID_CONVER_DTO, service = "userServiceImpl")
	private Integer userId;
	
	/**
	 * 菜单的名称
	 */
	private String menuName;
	
	/**
	 * 点击菜单时发送的请求URL
	 */
	private String menuUrl;
	
	/**
	 * 菜单的图标
	 */
	private String menuIcon;
	
	/**
	 * 排序
	 */
	private Integer menuSort;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 更新时间
	 */
	private Date updateDate;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(Integer parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Integer getMenuSort() {
		return menuSort;
	}

	public void setMenuSort(Integer menuSort) {
		this.menuSort = menuSort;
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
		return "Menu {menuId=" + menuId + ", parentMenuId=" + parentMenuId + ", permissionId=" + permissionId
				+ ", userId=" + userId + ", menuName=" + menuName + ", menuUrl=" + menuUrl + ", menuIcon=" + menuIcon
				+ ", menuSort=" + menuSort + ", createDate=" + createDate + ", updateDate=" + updateDate + "}";
	}

}
