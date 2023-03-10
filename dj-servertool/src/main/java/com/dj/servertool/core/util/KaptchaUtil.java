package com.dj.servertool.core.util;

import com.dj.servertool.config.properties.ToolProperties;

import cn.stylefeng.roses.core.util.SpringContextHolder;

/**
 * 验证码工具类
 */
public class KaptchaUtil {

	/**
	 * 获取验证码开关
	 */
	public static Boolean getKaptchaOnOff() {
		return SpringContextHolder.getBean(ToolProperties.class).getKaptchaOpen();
	}
}