package com.dj.servertool.core.metadata;

import org.springframework.stereotype.Component;

import com.dj.servertool.core.shiro.ShiroKit;

import cn.stylefeng.roses.core.metadata.CustomMetaObjectHandler;

/**
 * 字段填充器
 */
@Component
public class ToolMpFieldHandler extends CustomMetaObjectHandler {

	@Override
	protected Object getUserUniqueId() {
		try {

			return ShiroKit.getUser().getId();

		} catch (Exception e) {

			// 如果获取不到当前用户就存空id
			return "";
		}
	}
}
