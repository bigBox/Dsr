package com.dj.bms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author zcq
 * 2018年8月29日
 * 下午3:20:55
 * TODO
 */
@Component
public class CookieConfig {
	
	@Value("${bms.cookie.name}")
	private String name;

	@Value("${bms.cookie.maxAge}")
	private int maxAge;
	
	@Value("${bms.cookie.path}")
	private String path;
	
	@Value("${bms.cookie.httpOnly}")
	private boolean httpOnly;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isHttpOnly() {
		return httpOnly;
	}

	public void setHttpOnly(boolean httpOnly) {
		this.httpOnly = httpOnly;
	}
	
}
