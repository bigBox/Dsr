package com.dj.bms.modules.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.dj.bms.modules.user.dto.UserDTO;

/**
 * 已经认证过的用户
 * 
 * @author zcq
 * @date 2020-03-18
 */
public class AuthenticationUser extends User {

	private static final long serialVersionUID = 8186131563710796749L;

	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 用户UID
	 */
	private String userUid;

	public AuthenticationUser(UserDTO user, Collection<? extends GrantedAuthority> authorities) {
		super(user.getUserName(), user.getPassword(), true, true, true, true, authorities);
		this.userId = user.getUserId();
		this.userUid = user.getUserUid();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserUid() {
		return userUid;
	}

	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
}
