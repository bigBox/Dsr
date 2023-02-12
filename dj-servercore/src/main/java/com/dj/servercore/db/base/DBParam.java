package com.dj.servercore.db.base;

import org.springframework.core.io.Resource;

import lombok.Setter;


@Setter
public class DBParam {
	public Resource configLocation;
	
	public String driverClassName;
	public int initialSize;
	public int maxActive;
	public int minIdle;
	public long maxWait;
	public boolean removeAbandoned;
	public int removeAbandonedTimeout;
	public String connectionProperties;
}
