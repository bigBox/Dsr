package com.dj.bms.modules.security.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理认证失败的实现类
 * 
 * @author zcq
 * @date 2020-03-16
 */
@Service
public class AuthenticationSuccessServiceImpl implements AuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessServiceImpl.class);
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
		logger.info(authentication.toString());
		request.setAttribute("success", "登录成功");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
