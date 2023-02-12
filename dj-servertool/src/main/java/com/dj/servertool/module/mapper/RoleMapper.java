package com.dj.servertool.module.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.servertool.core.common.node.ZTreeNode;
import com.dj.servertool.module.entity.Role;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 */
public interface RoleMapper extends BaseMapper<Role> {

	/**
	 * 根据条件查询角色列表
	 */
	@SuppressWarnings("rawtypes")
	Page<Map<String, Object>> selectRoles(@Param("page") Page page, @Param("condition") String condition);

	/**
	 * 删除某个角色的所有权限
	 *
	 * @param roleId 角色id
	 */
	int deleteRolesById(@Param("roleId") Long roleId);

	/**
	 * 获取角色列表树
	 */
	List<ZTreeNode> roleTreeList();

	/**
	 * 获取角色列表树
	 */
	List<ZTreeNode> roleTreeListByRoleId(Long[] roleId);

}
