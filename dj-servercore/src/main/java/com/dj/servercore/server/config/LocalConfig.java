package com.dj.servercore.server.config;

import com.dj.domain.util.FileUtil;
import com.dj.domain.util.Utility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalConfig {
	/**
	 *	是否使用远程连接配置
	 */
	public static boolean isUseRemoteConnect() {
		try {
			String content = FileUtil.readFile("/mnt/config/connect.txt");
			if(content != null) {
				log.info("【connect.txt】 {}", content);
				return "useRemoteConnect".equals(content);
			}
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
		}
		return false;
	}

	/**
	 *	是否使用远程配置
	 */
	public static boolean isUseRemoteJson() {
		try {
			String content = FileUtil.readFile("/mnt/config/json.txt");
			if(content != null){
				log.info("【json.txt】 {}", content);
				return "useRemoteJson".equals(content);
			}
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
		}
		return false;
	}
}
