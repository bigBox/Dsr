package com.dj.servertool.module.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.servertool.core.common.exception.BizExceptionEnum;
import com.dj.servertool.core.common.node.TreeviewNode;
import com.dj.servertool.core.common.node.ZTreeNode;
import com.dj.servertool.core.common.page.LayuiPageFactory;
import com.dj.servertool.module.entity.Dept;
import com.dj.servertool.module.mapper.DeptMapper;

import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 */
@Service
public class DeptService extends ServiceImpl<DeptMapper, Dept> {

	@Resource
	private DeptMapper deptMapper;

	/**
	 * 新增部门
	 */
	@Transactional(rollbackFor = Exception.class)
	public void addDept(Dept dept) {

		if (ToolUtil.isOneEmpty(dept, dept.getSimpleName(), dept.getFullName(), dept.getPid(), dept.getDescription())) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}

		// 完善pids,根据pid拿到pid的pids
		this.deptSetPids(dept);

		this.save(dept);
	}

	/**
	 * 修改部门
	 */
	@Transactional(rollbackFor = Exception.class)
	public void editDept(Dept dept) {

		if (ToolUtil.isOneEmpty(dept, dept.getDeptId(), dept.getSimpleName(), dept.getFullName(), dept.getPid(),
				dept.getDescription())) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}

		// 完善pids,根据pid拿到pid的pids
		this.deptSetPids(dept);

		this.updateById(dept);
	}

	/**
	 * 删除部门
	 */
	@Transactional
	public void deleteDept(Long deptId) {
		Dept dept = deptMapper.selectById(deptId);

		// 根据like查询删除所有级联的部门
		List<Dept> subDepts = deptMapper.likePids(dept.getDeptId());

		for (Dept temp : subDepts) {
			this.removeById(temp.getDeptId());
		}

		this.removeById(dept.getDeptId());
	}

	/**
	 * 获取ztree的节点列表
	 */
	public List<ZTreeNode> tree() {
		return this.baseMapper.tree();
	}

	/**
	 * 获取ztree的节点列表
	 */
	public List<TreeviewNode> treeviewNodes() {
		return this.baseMapper.treeviewNodes();
	}

	/**
	 * 获取所有部门列表
	 */
	@SuppressWarnings("rawtypes")
	public Page<Map<String, Object>> list(String condition, Long deptId) {
		Page page = LayuiPageFactory.defaultPage();
		return this.baseMapper.list(page, condition, deptId);
	}

	/**
	 * 设置部门的父级ids
	 */
	private void deptSetPids(Dept dept) {
		if (ToolUtil.isEmpty(dept.getPid()) || dept.getPid().equals(0L)) {
			dept.setPid(0L);
			dept.setPids("[0],");
		} else {
			Long pid = dept.getPid();
			Dept temp = this.getById(pid);
			String pids = temp.getPids();
			dept.setPid(pid);
			dept.setPids(pids + "[" + pid + "],");
		}
	}
}
