package com.dj.bms.modules.security.service;

/**
 * 认证密码处理器接口
 * 
 * @author zcq
 * @date 2020-03-16
 */
public interface AuthenticationMd5PasswordEncoderService {

	/**
	 * 将密码加密
	 * 
	 * @param password 密码
	 * @param salt 盐值
	 * @return String
	 */
	String encodePassword(String password, Object salt);
}
