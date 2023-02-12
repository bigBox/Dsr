package com.dj.servertool.core.shiro.service.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dj.servertool.core.listener.ConfigListener;
import com.dj.servertool.core.shiro.ShiroKit;
import com.dj.servertool.core.shiro.ShiroUser;
import com.dj.servertool.core.shiro.service.PermissionCheckService;

import cn.hutool.core.collection.CollectionUtil;
import cn.stylefeng.roses.core.util.HttpContext;

/**
 * 权限自定义检查
 */
@Service
@Transactional(readOnly = true)
public class PermissionCheckServiceServiceImpl implements PermissionCheckService {

	@Override
	public boolean check(Object[] permissions) {
		ShiroUser user = ShiroKit.getUser();
		if (null == user) {
			return false;
		}
		ArrayList<Object> objects = CollectionUtil.newArrayList(permissions);
		String join = CollectionUtil.join(objects, ",");
        return ShiroKit.hasAnyRoles(join);
    }

	@Override
	public boolean checkAll() {
		HttpServletRequest request = HttpContext.getRequest();
		ShiroUser user = ShiroKit.getUser();
		if (null == user) {
			return false;
		}
		String requestURI = request.getRequestURI().replaceFirst(ConfigListener.getConf().get("contextPath"), "");
		String[] str = requestURI.split("/");
		if (str.length > 3) {
			requestURI = "/" + str[1] + "/" + str[2];
		}
        return ShiroKit.hasPermission(requestURI);
    }

}
