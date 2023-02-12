package com.dj.servertool.module.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.servertool.core.common.node.MenuNode;
import com.dj.servertool.core.common.node.ZTreeNode;
import com.dj.servertool.module.entity.Menu;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 */
public interface MenuMapper extends BaseMapper<Menu> {

	/**
	 * 根据条件查询菜单
	 *
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Page<Map<String, Object>> selectMenus(@Param("page") Page page, @Param("condition") String condition,
			@Param("level") String level, @Param("menuId") Long menuId, @Param("code") String code);

	/**
	 * 根据条件查询菜单
	 *
	 * @return
	 */
	List<Long> getMenuIdsByRoleId(@Param("roleId") Long roleId);

	/**
	 * 获取菜单列表树
	 *
	 * @return
	 */
	List<ZTreeNode> menuTreeList();

	/**
	 * 获取菜单列表树
	 *
	 * @return
	 */
	List<ZTreeNode> menuTreeListByMenuIds(List<Long> menuIds);

	/**
	 * 删除menu关联的relation
	 *
	 * @param menuId
	 * @return
	 */
	int deleteRelationByMenu(@Param("menuId") Long menuId);

	/**
	 * 获取资源url通过角色id
	 *
	 * @param roleId
	 * @return
	 */
	List<String> getResUrlsByRoleId(@Param("roleId") Long roleId);

	/**
	 * 根据角色获取菜单
	 *
	 * @param roleIds
	 * @return
	 */
	List<MenuNode> getMenusByRoleIds(List<Long> roleIds);

	/**
	 * 查询菜单树形列表
	 */
	List<Map<String, Object>> selectMenuTree(@Param("condition") String condition, @Param("level") String level);

	/**
	 * 获取pcodes like某个code的菜单列表
	 */
	List<Menu> getMenusLikePcodes(@Param("code") String code);

}
