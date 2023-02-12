package com.dj.servertool.core.util;

import java.util.ArrayList;
import java.util.List;

import com.dj.servertool.config.properties.ToolProperties;
import com.dj.servertool.core.common.constant.Const;
import com.dj.servertool.core.common.node.MenuNode;

import cn.stylefeng.roses.core.util.SpringContextHolder;

/**
 * api接口文档显示过滤
 */
public class ApiMenuFilter extends MenuNode {

	private static final long serialVersionUID = 489782865867186797L;

	public static List<MenuNode> build(List<MenuNode> nodes) {

		// 如果关闭了接口文档,则不显示接口文档菜单
		ToolProperties toolProperties = SpringContextHolder.getBean(ToolProperties.class);
		if (!toolProperties.getSwaggerOpen()) {
			List<MenuNode> menuNodesCopy = new ArrayList<>();
			for (MenuNode menuNode : nodes) {
				if (Const.API_MENU_NAME.equals(menuNode.getName())) {
					continue;
				} else {
					menuNodesCopy.add(menuNode);
				}
			}
			nodes = menuNodesCopy;
		}

		return nodes;
	}
}
