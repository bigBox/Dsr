package com.dj.bms.modules.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.util.CollectionUtils;
import com.dj.bms.common.util.StringUtils;
import com.dj.bms.modules.permission.dto.PermissionDTO;
import com.dj.bms.modules.role.dto.RoleDTO;
import com.dj.bms.modules.security.model.AuthenticationUser;
import com.dj.bms.modules.security.service.AuthenticationUserDetailsService;
import com.dj.bms.modules.user.dto.UserDTO;
import com.dj.bms.modules.user.model.User;
import com.dj.bms.modules.user.service.UserService;

/**
 * 认证 Service Impl
 * 
 * @author zcq
 * @date 2020-03-16
 */
@Service
public class AuthenticationUserDetailsServiceImpl implements AuthenticationUserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (StringUtils.isEmpty(username)) {
			throw new BadCredentialsException("登录名不能为空");
		}
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_name", username);
		UserDTO userDTO = userService.getOne(queryWrapper);
		if (userDTO == null) {
			throw new BadCredentialsException("用户不存在");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		List<RoleDTO> roles = userDTO.getRoleDTOs();
		if (CollectionUtils.isNotEmpty(roles)) {
			roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName())));
			roles.forEach(role -> {
				List<PermissionDTO> permissions = role.getPermissionDTOs();
				if (CollectionUtils.isNotEmpty(permissions)) {
					permissions.forEach(
							permission -> authorities.add(new SimpleGrantedAuthority(permission.getPermissionName())));
				}
			});
		}
		return new AuthenticationUser(userDTO, authorities);
	}

}
