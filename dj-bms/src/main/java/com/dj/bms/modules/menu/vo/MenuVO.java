package com.dj.bms.modules.menu.vo;

import com.dj.bms.common.annotation.VO2DTO;
import com.dj.bms.common.enums.ConverPolicy;
import com.dj.bms.common.vo.BaseVO;

/**
 * 菜单 VO
 * 
 * @author zcq
 * @date 2020-03-06
 */
public class MenuVO implements BaseVO {

	private static final long serialVersionUID = 5736009149025063660L;

	/**
	 * 菜单ID
	 */
	private Integer menuId;

	/**
	 * 父级菜单
	 */
	@VO2DTO(targets = {"parentMenuDTO"}, policy = ConverPolicy.VO_CONVER_DTO)
	private MenuVO parentMenuVO;

	/**
	 * 权限ID
	 */
	@VO2DTO(targets = {"permissionDTO"}, policy = ConverPolicy.ID_CONVER_DTO, service = "permissionServiceImpl")
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
	 * 创建人ID
	 */
	@VO2DTO(targets = {"userDTO"}, policy = ConverPolicy.ID_CONVER_DTO, service = "userServiceImpl")
	private Integer userId;

	/**
	 * 创建人名称
	 */
	private String userName;

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
	@VO2DTO(targets = {"createDate"}, policy = ConverPolicy.STRING_CONVER_DATE)
	private String createDate;

	/**
	 * 更新时间
	 */
	@VO2DTO(targets = {"updateDate"}, policy = ConverPolicy.STRING_CONVER_DATE)
	private String updateDate;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public MenuVO getParentMenuVO() {
		return parentMenuVO;
	}

	public void setParentMenuVO(MenuVO parentMenuVO) {
		this.parentMenuVO = parentMenuVO;
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
		return menuId;
	}

	@Override
	public void setPrimaryKey(Integer primaryKey) {
		this.menuId = primaryKey;
	}

	@Override
	public String toString() {
		return "MenuVO {menuId=" + menuId + ", parentMenuVO=" + parentMenuVO + ", permissionId=" + permissionId
				+ ", permissionName=" + permissionName + ", permissionValue=" + permissionValue + ", userId=" + userId
				+ ", userName=" + userName + ", menuName=" + menuName + ", menuUrl=" + menuUrl + ", menuIcon="
				+ menuIcon + ", menuSort=" + menuSort + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "}";
	}

}
