package com.dj.servertool.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.servertool.core.common.constant.Const;
import com.dj.servertool.core.common.constant.state.ManagerStatus;
import com.dj.servertool.core.common.exception.BizExceptionEnum;
import com.dj.servertool.core.common.node.MenuNode;
import com.dj.servertool.core.common.page.LayuiPageFactory;
import com.dj.servertool.core.shiro.ShiroKit;
import com.dj.servertool.core.shiro.ShiroUser;
import com.dj.servertool.core.shiro.service.UserAuthService;
import com.dj.servertool.core.util.ApiMenuFilter;
import com.dj.servertool.module.entity.User;
import com.dj.servertool.module.factory.UserFactory;
import com.dj.servertool.module.mapper.UserMapper;
import com.dj.servertool.module.model.UserDto;

import cn.hutool.core.bean.BeanUtil;
import cn.stylefeng.roses.core.datascope.DataScope;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

	@Autowired
	private MenuService menuService;

	@Autowired
	private UserAuthService userAuthService;

	/**
	 * 添加用戶
	 */
	public void addUser(UserDto user) {

		// 判断账号是否重复
		User theUser = this.getByAccount(user.getAccount());
		if (theUser != null) {
			throw new ServiceException(BizExceptionEnum.USER_ALREADY_REG);
		}

		// 完善账号信息
		String salt = ShiroKit.getRandomSalt(5);
		String password = ShiroKit.md5(user.getPassword(), salt);

		this.save(UserFactory.createUser(user, password, salt));
	}

	/**
	 * 修改用户
	 */
	public void editUser(UserDto user) {
		User oldUser = this.getById(user.getUserId());

		if (ShiroKit.hasRole(Const.ADMIN_NAME)) {
			this.updateById(UserFactory.editUser(user, oldUser));
		} else {
			this.assertAuth(user.getUserId());
			ShiroUser shiroUser = ShiroKit.getUserNotNull();
			if (shiroUser.getId().equals(user.getUserId())) {
				this.updateById(UserFactory.editUser(user, oldUser));
			} else {
				throw new ServiceException(BizExceptionEnum.NO_PERMITION);
			}
		}
	}

	/**
	 * 删除用户
	 */
	public void deleteUser(Long userId) {

		// 不能删除超级管理员
		if (userId.equals(Const.ADMIN_ID)) {
			throw new ServiceException(BizExceptionEnum.CANT_DELETE_ADMIN);
		}
		this.assertAuth(userId);
		this.setStatus(userId, ManagerStatus.DELETED.getCode());
	}

	/**
	 * 修改用户状态
	 */
	public int setStatus(Long userId, String status) {
		return this.baseMapper.setStatus(userId, status);
	}

	/**
	 * 修改密码
	 */
	public void changePwd(String oldPassword, String newPassword) {
		Long userId = ShiroKit.getUserNotNull().getId();
		User user = this.getById(userId);

		String oldMd5 = ShiroKit.md5(oldPassword, user.getSalt());

		if (user.getPassword().equals(oldMd5)) {
			String newMd5 = ShiroKit.md5(newPassword, user.getSalt());
			user.setPassword(newMd5);
			this.updateById(user);
		} else {
			throw new ServiceException(BizExceptionEnum.OLD_PWD_NOT_RIGHT);
		}
	}

	/**
	 * 根据条件查询用户列表
	 */
	@SuppressWarnings("rawtypes")
	public Page<Map<String, Object>> selectUsers(DataScope dataScope, String name, String beginTime, String endTime,
			Long deptId) {
		Page page = LayuiPageFactory.defaultPage();
		return this.baseMapper.selectUsers(page, dataScope, name, beginTime, endTime, deptId);
	}

	/**
	 * 设置用户的角色
	 */
	public int setRoles(Long userId, String roleIds) {
		return this.baseMapper.setRoles(userId, roleIds);
	}

	/**
	 * 通过账号获取用户
	 */
	public User getByAccount(String account) {
		return this.baseMapper.getByAccount(account);
	}

	/**
	 * 获取用户菜单列表
	 */
	public List<MenuNode> getUserMenuNodes(List<Long> roleList) {
		if (roleList == null || roleList.size() == 0) {
			return new ArrayList<>();
		} else {
			List<MenuNode> menus = menuService.getMenusByRoleIds(roleList);
			List<MenuNode> titles = MenuNode.buildTitle(menus);
			return ApiMenuFilter.build(titles);
		}

	}

	/**
	 * 判断当前登录的用户是否有操作这个用户的权限
	 */
	public void assertAuth(Long userId) {
		if (ShiroKit.isAdmin()) {
			return;
		}
		List<Long> deptDataScope = ShiroKit.getDeptDataScope();
		User user = this.getById(userId);
		Long deptId = user.getDeptId();
		if (deptDataScope.contains(deptId)) {
			return;
		} else {
			throw new ServiceException(BizExceptionEnum.NO_PERMITION);
		}

	}

	/**
	 * 刷新当前登录用户的信息
	 */
	public void refreshCurrentUser() {
		ShiroUser user = ShiroKit.getUserNotNull();
		Long id = user.getId();
		User currentUser = this.getById(id);
		ShiroUser shiroUser = userAuthService.shiroUser(currentUser);
		ShiroUser lastUser = ShiroKit.getUser();
		BeanUtil.copyProperties(shiroUser, lastUser);
	}

}
