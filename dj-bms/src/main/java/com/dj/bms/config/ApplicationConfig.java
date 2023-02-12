package com.dj.bms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author zcq
 * 2018年8月29日
 * 下午3:17:20
 * TODO
 */
@Component
public class ApplicationConfig {

	@Autowired
	private CookieConfig cookieConfig;
	@Value("${bms.intro}")
	private String intro;
	@Value("${bms.theme}")
	private String theme;
	
	@Value("${bms.site.name}")
	private String siteName;
	
	public CookieConfig getCookieConfig() {
		return cookieConfig;
	}

	public void setCookieConfig(CookieConfig cookieConfig) {
		this.cookieConfig = cookieConfig;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
}
