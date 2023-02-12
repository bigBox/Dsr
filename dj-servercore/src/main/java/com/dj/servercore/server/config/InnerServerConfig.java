package com.dj.servercore.server.config;

import com.dj.protobuf.ServerType;
import com.dj.servercore.db.DbConfig;
import com.dj.servercore.redis.RedisConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InnerServerConfig extends ServerConfig {
	/**
	 * 端口
	 */
	private int port;
	/**
	 * http端口
	 */
	private int httpPort;
	/**
	 * 论坛url
	 */
	private String bbsUrl;
	/**
	 *	服务器类型
	 */
	private ServerType serverType;
	/**
	 *	Redis配置
	 */
	private RedisConfig redisConfig;
	/**
	 *	玩家数据库
	 */
	private DbConfig dbPlayer;
	/**
	 *	全局数据库
	 */
	private DbConfig dbGlobal;
	/**
	 *	全局数据库
	 */
	private DbConfig dbRobot;

	public DbConfig getDbConfig(String dbKey) {
		if(dbKey.equals("player")) {
			return dbPlayer;
		}else if(dbKey.equals("global")) {
			return dbGlobal;
		}else if(dbKey.equals("robot")) {
			return dbRobot;
		}
		return null;
	}
}
