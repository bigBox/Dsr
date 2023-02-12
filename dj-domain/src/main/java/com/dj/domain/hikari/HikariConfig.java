package com.dj.domain.hikari;

import org.apache.commons.configuration2.XMLConfiguration;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HikariConfig {
	private String url;
	private String user;
	private String password;
	private String driverClass;
	private int initialPoolSize;
	private int minPoolSize;
	private int maxPoolSize;
	private int acquireIncrement;
	private int maxIdleTime;
	private int maxStatements;
	private int maxStatementsPerConnection;
	private String preferredTestQuery;

	public boolean isEmpty() {
        return url == null || user == null;
    }

	public HikariConfig(String url, String user, String password, String driverClass, int initialPoolSize, int minPoolSize, int maxPoolSize) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
		this.driverClass = driverClass;
		this.initialPoolSize = initialPoolSize;
		this.minPoolSize = minPoolSize;
		this.maxPoolSize = maxPoolSize;
	}

	public static HikariConfig loadDb(XMLConfiguration config, String dbName) {
		try {
			if (config == null || !config.containsKey(dbName + ".url")) {
				return null;
			}
			return new HikariConfig(config.getString(dbName + ".url"), config.getString(dbName + ".user"),
					config.getString(dbName + ".password"), config.getString(dbName + ".driverClass"),
					config.getInt(dbName + ".initialPoolSize"), config.getInt(dbName + ".minPoolSize"),
					config.getInt(dbName + ".maxPoolSize"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
