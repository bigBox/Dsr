package com.dj.servertool.module.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.servertool.core.common.node.TreeviewNode;
import com.dj.servertool.core.common.node.ZTreeNode;
import com.dj.servertool.module.entity.Dept;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 */
public interface DeptMapper extends BaseMapper<Dept> {

	/**
	 * 获取ztree的节点列表
	 */
	List<ZTreeNode> tree();

	/**
	 * 获取所有部门列表
	 */
	@SuppressWarnings("rawtypes")
	Page<Map<String, Object>> list(@Param("page") Page page, @Param("condition") String condition,
			@Param("deptId") Long deptId);

	/**
	 * 获取所有部门树列表
	 */
	List<TreeviewNode> treeviewNodes();

	/**
	 * where pids like ''
	 */
	List<Dept> likePids(@Param("deptId") Long deptId);
}
