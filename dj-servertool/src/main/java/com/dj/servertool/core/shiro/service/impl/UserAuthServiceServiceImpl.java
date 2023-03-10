package com.dj.servertool.core.shiro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dj.servertool.core.common.constant.factory.ConstantFactory;
import com.dj.servertool.core.common.constant.state.ManagerStatus;
import com.dj.servertool.core.shiro.ShiroKit;
import com.dj.servertool.core.shiro.ShiroUser;
import com.dj.servertool.core.shiro.service.UserAuthService;
import com.dj.servertool.module.entity.User;
import com.dj.servertool.module.mapper.MenuMapper;
import com.dj.servertool.module.mapper.UserMapper;
import com.dj.servertool.module.service.UserService;

import cn.hutool.core.convert.Convert;
import cn.stylefeng.roses.core.util.SpringContextHolder;

@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class UserAuthServiceServiceImpl implements UserAuthService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private MenuMapper menuMapper;

	@SuppressWarnings("unused")
	@Autowired
	private UserService userService;

	public static UserAuthService me() {
		return SpringContextHolder.getBean(UserAuthService.class);
	}

	@Override
	public User user(String account) {

		User user = userMapper.getByAccount(account);

		// 账号不存在
		if (null == user) {
			throw new CredentialsException();
		}
		// 账号被冻结
		if (!user.getStatus().equals(ManagerStatus.OK.getCode())) {
			throw new LockedAccountException();
		}
		return user;
	}

	@Override
	public ShiroUser shiroUser(User user) {

		ShiroUser shiroUser = ShiroKit.createShiroUser(user);

		// 用户角色数组
		Long[] roleArray = Convert.toLongArray(user.getRoleId());

		// 获取用户角色列表
		List<Long> roleList = new ArrayList<>();
		List<String> roleNameList = new ArrayList<>();
		for (Long roleId : roleArray) {
			roleList.add(roleId);
			roleNameList.add(ConstantFactory.me().getSingleRoleName(roleId));
		}
		shiroUser.setRoleList(roleList);
		shiroUser.setRoleNames(roleNameList);

		return shiroUser;
	}

	@Override
	public List<String> findPermissionsByRoleId(Long roleId) {
		return menuMapper.getResUrlsByRoleId(roleId);
	}

	@Override
	public String findRoleNameByRoleId(Long roleId) {
		return ConstantFactory.me().getSingleRoleTip(roleId);
	}

	@Override
	public SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName) {
		String credentials = user.getPassword();

		// 密码加盐处理
		String source = user.getSalt();
		ByteSource credentialsSalt = new Md5Hash(source);
		return new SimpleAuthenticationInfo(shiroUser, credentials, credentialsSalt, realmName);
	}

}
