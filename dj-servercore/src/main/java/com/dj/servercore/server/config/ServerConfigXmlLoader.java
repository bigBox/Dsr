package com.dj.servercore.server.config;

import org.apache.commons.configuration2.XMLConfiguration;

import com.dj.protobuf.ServerType;
import com.dj.servercore.db.DbConfig;
import com.dj.servercore.redis.RedisConfig;
import com.dj.domain.util.Utility;
import com.dj.domain.util.XmlUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @description 加载服务器配置文件信息
 * @author zcq
 * @date 2019年3月14日
 */
@Slf4j
public class ServerConfigXmlLoader {

	public static ConnectServerConfig loadClient(String file) {
		try {
			XMLConfiguration config = XmlUtil.getXMLConfiguration(file);
			return XmlUtil.getXMLConfigurationBean(config, ConnectServerConfig.class);
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
		}
		return null;
	}

	// 初始化服务器配置信息
	public static InnerServerConfig loadInner(String file) {
		try {
			XMLConfiguration localConfig = XmlUtil.getXMLConfiguration(file);
			InnerServerConfig innerServerConfig = XmlUtil.getXMLConfigurationBean(localConfig, InnerServerConfig.class);
			innerServerConfig.setServerType(ServerType.valueOf(innerServerConfig.getName().toUpperCase()));
			innerServerConfig.setRedisConfig(loadRedis(localConfig, "redis"));
			innerServerConfig.setDbPlayer(loadDb(localConfig, "dbPlayer"));
			innerServerConfig.setDbGlobal(loadDb(localConfig, "dbGlobal"));
			innerServerConfig.setDbRobot(loadDb(localConfig, "dbRobot"));
			return innerServerConfig;
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
		}
		return null;
	}

	// 初始化服务器配置信息
	public static NettyServerConfig loadNetty(String file) {
		try {
			XMLConfiguration config = XmlUtil.getXMLConfiguration(file);
			return XmlUtil.getXMLConfigurationBean(config, NettyServerConfig.class);
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
		}
		return null;
	}

	// 初始化redis配置信息
	public static RedisConfig loadRedis(XMLConfiguration config, String name) {
		try {
			if (config == null || !config.containsKey(name + ".host")) {
				return null;
			}
			String host = config.getString(name + ".host");
			int port = config.getInt(name + ".port");
			String pass = "";
			if (config.containsKey(name + ".pass")) {
				pass = config.getString(name + ".pass");
			}
			boolean isCluster = false;
			if (config.containsKey(name + ".isCluster")) {
				isCluster = config.getBoolean(name + ".isCluster");
			}
			String[] addresses = new String[] { "redis://" + host + ":" + port };
			return new RedisConfig(isCluster, pass, addresses, config.getInt(name + ".timeout"),
					config.getInt(name + ".poolMaxTotal"), config.getInt(name + ".poolMaxIdle"),
					config.getInt(name + ".maxRedirections"), config.getString(name + ".prefix"));
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
		}
		return null;
	}

	public static DbConfig loadDb(XMLConfiguration config, String dbName) {
		try {
			if (config == null || !config.containsKey(dbName + ".url")) {
				return null;
			}
			return new DbConfig(config.getString(dbName + ".url"), config.getString(dbName + ".user"),
					config.getString(dbName + ".password"), config.getString(dbName + ".driverClass"),
					config.getInt(dbName + ".initialPoolSize"), config.getInt(dbName + ".minPoolSize"),
					config.getInt(dbName + ".maxPoolSize"));
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
		}
		return null;
	}

//	public static void main(String[] args) {
//		//System.out.println(loadClient("http://192.168.1.7:8080/server/connect-server-config.xml"));
//	}
}
