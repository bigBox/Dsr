package com.dj.servertool.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dj.servertool.core.shiro.ShiroKit;
import com.dj.servertool.core.shiro.ShiroUser;
import com.dj.servertool.core.util.DefaultImages;

/**
 * 自动渲染当前用户信息登录属性 的过滤器
 */
public class AttributeSetInteceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		// 没有视图的直接跳过过滤器
		if (modelAndView == null || modelAndView.getViewName() == null) {
			return;
		}

		// 视图结尾不是html的直接跳过
		if (!modelAndView.getViewName().endsWith("html")) {
			return;
		}

		ShiroUser user = ShiroKit.getUser();

		if (user == null) {
			throw new AuthenticationException("当前没有登录账号！");
		} else {
			modelAndView.addObject("name", user.getName());
			modelAndView.addObject("avatar", DefaultImages.defaultAvatarUrl());
			modelAndView.addObject("email", user.getEmail());
		}
	}
}
