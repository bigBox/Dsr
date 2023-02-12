package com.dj.bms.modules.security.service.impl;

import com.dj.bms.modules.security.service.AuthenticationMd5PasswordEncoderService;
import org.springframework.security.crypto.password.AbstractPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 认证密码处理器实现类
 * 
 * @author zcq
 * @date 2020-03-16
 */
@Service
public class AuthenticationMd5PasswordEncoderServiceImpl extends AbstractPasswordEncoder
		implements AuthenticationMd5PasswordEncoderService {

	@Override
	public String encodePassword(String password, Object salt) {
		return null;
	}

	@Override
	protected byte[] encode(CharSequence charSequence, byte[] bytes) {
		return new byte[0];
	}
}
