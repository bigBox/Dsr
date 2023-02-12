package com.dj.servercore.server.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>服务器配置</p>
 * @author zcq
 * 2019年3月14日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ServerConfig {
	/**
	 * @Fields id : 服务器ID
	 */
	private int id;
	/**
	 * @Fields name : 服务器名称
	 */
	private String name;
	/**
	 * @Fields logPath : 日志文件保存路径
	 */
	private String logPath;
	/**
	 * @Fields jsonPath : 配置文件保存路径
	 */
	private String jsonPath;
	/**
	 * @Fields jsonUpdate : 是否需要把变更的配置文件更新到现有玩家身上
	 */
	private boolean jsonUpdate;
	/**
	 * @Fields serverCdnUrl : 配置文件的远程保存路径
	 */
	private String serverCdnUrl;
	/**
	 * @Fields isFormal : 是否是正式服
	 */
	private boolean isFormal;
	/**
	 * @Fields isFormal : 探险是否是密集版
	 */
	private boolean isDense;
	/**
	 * @Fields tag : 标识
	 */
	private String tag;

}
