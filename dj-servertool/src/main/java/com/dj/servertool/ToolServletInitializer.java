package com.dj.servertool;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @ClassName: ToolServletInitializer
 * @Description: Web程序启动类
 * @author zcq
 * @date 2019年6月25日
 */
public class ToolServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ToolApplication.class);
	}
}
