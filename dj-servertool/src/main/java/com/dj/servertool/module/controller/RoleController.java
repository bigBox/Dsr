package com.dj.servertool.module.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.servertool.core.common.annotion.BussinessLog;
import com.dj.servertool.core.common.annotion.Permission;
import com.dj.servertool.core.common.constant.Const;
import com.dj.servertool.core.common.constant.dictmap.DeleteDict;
import com.dj.servertool.core.common.constant.dictmap.RoleDict;
import com.dj.servertool.core.common.constant.factory.ConstantFactory;
import com.dj.servertool.core.common.exception.BizExceptionEnum;
import com.dj.servertool.core.common.node.ZTreeNode;
import com.dj.servertool.core.common.page.LayuiPageFactory;
import com.dj.servertool.core.log.LogObjectHolder;
import com.dj.servertool.module.entity.Role;
import com.dj.servertool.module.entity.User;
import com.dj.servertool.module.model.RoleDto;
import com.dj.servertool.module.service.RoleService;
import com.dj.servertool.module.service.UserService;
import com.dj.servertool.module.warpper.RoleWrapper;

import cn.hutool.core.bean.BeanUtil;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;

/**
 * 角色控制器
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

	private static String PREFIX = "/modular/system/role";

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	/**
	 * 跳转到角色列表页面
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "/role.html";
	}

	/**
	 * 跳转到添加角色
	 */
	@RequestMapping(value = "/role_add")
	public String roleAdd() {
		return PREFIX + "/role_add.html";
	}

	/**
	 * 跳转到修改角色
	 */
	@Permission
	@RequestMapping(value = "/role_edit")
	public String roleEdit(@RequestParam Long roleId) {
		if (ToolUtil.isEmpty(roleId)) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		Role role = this.roleService.getById(roleId);
		LogObjectHolder.me().set(role);
		return PREFIX + "/role_edit.html";
	}

	/**
	 * 跳转到权限分配
	 */
	@Permission
	@RequestMapping(value = "/role_assign/{roleId}")
	public String roleAssign(@PathVariable("roleId") Long roleId, Model model) {
		if (ToolUtil.isEmpty(roleId)) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		model.addAttribute("roleId", roleId);
		return PREFIX + "/role_assign.html";
	}

	/**
	 * 获取角色列表
	 */
	@Permission
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(@RequestParam(value = "roleName", required = false) String roleName) {
		Page<Map<String, Object>> roles = this.roleService.selectRoles(roleName);
		Page<Map<String, Object>> wrap = new RoleWrapper(roles).wrap();
		return LayuiPageFactory.createPageInfo(wrap);
	}

	/**
	 * 角色新增
	 */
	@RequestMapping(value = "/add")
	@BussinessLog(value = "添加角色", key = "name", dict = RoleDict.class)
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public ResponseData add(Role role) {
		this.roleService.addRole(role);
		return SUCCESS_TIP;
	}

	/**
	 * 角色修改
	 */
	@RequestMapping(value = "/edit")
	@BussinessLog(value = "修改角色", key = "name", dict = RoleDict.class)
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public ResponseData edit(RoleDto roleDto) {
		this.roleService.editRole(roleDto);
		return SUCCESS_TIP;
	}

	/**
	 * 删除角色
	 */
	@RequestMapping(value = "/remove")
	@BussinessLog(value = "删除角色", key = "roleId", dict = DeleteDict.class)
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public ResponseData remove(@RequestParam Long roleId) {
		// 缓存被删除的部门名称
		LogObjectHolder.me().set(ConstantFactory.me().getDeptName(roleId));
		this.roleService.delRoleById(roleId);
		return SUCCESS_TIP;
	}

	/**
	 * 查看角色
	 */
	@RequestMapping(value = "/view/{roleId}")
	@ResponseBody
	public ResponseData view(@PathVariable Long roleId) {
		if (ToolUtil.isEmpty(roleId)) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		Role role = this.roleService.getById(roleId);
		Map<String, Object> roleMap = BeanUtil.beanToMap(role);
		Long pid = role.getPid();
		String pName = ConstantFactory.me().getSingleRoleName(pid);
		roleMap.put("pName", pName);
		return ResponseData.success(roleMap);
	}

	/**
	 * 配置权限
	 */
	@RequestMapping("/setAuthority")
	@BussinessLog(value = "配置权限", key = "roleId,ids", dict = RoleDict.class)
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public ResponseData setAuthority(@RequestParam("roleId") Long roleId, @RequestParam("ids") String ids) {
		if (ToolUtil.isOneEmpty(roleId)) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		this.roleService.setAuthority(roleId, ids);
		return SUCCESS_TIP;
	}

	/**
	 * 获取角色列表
	 */
	@RequestMapping(value = "/roleTreeList")
	@ResponseBody
	public List<ZTreeNode> roleTreeList() {
		List<ZTreeNode> roleTreeList = this.roleService.roleTreeList();
		roleTreeList.add(ZTreeNode.createParent());
		return roleTreeList;
	}

	/**
	 * 获取角色列表，通过用户id
	 */
	@RequestMapping(value = "/roleTreeListByUserId/{userId}")
	@ResponseBody
	public List<ZTreeNode> roleTreeListByUserId(@PathVariable Long userId) {
		User theUser = this.userService.getById(userId);
		String roleId = theUser.getRoleId();
		if (ToolUtil.isEmpty(roleId)) {
			return this.roleService.roleTreeList();
		} else {
			String[] strArray = roleId.split(",");
			// 转化成Long[]
			Long[] longArray = new Long[strArray.length];
			for (int i = 0; i < strArray.length; i++) {
				longArray[i] = Long.valueOf(strArray[i]);
			}
			return this.roleService.roleTreeListByRoleId(longArray);
		}
	}

}
