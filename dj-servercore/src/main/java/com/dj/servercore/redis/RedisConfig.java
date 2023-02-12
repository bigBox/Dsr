package com.dj.servercore.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisConfig {
	private boolean isCluster;

	private String pass;

	private String[] redisAddresses;

	private int timeout;

	private int poolMaxTotal;

	private int poolMaxIdle;

	private int maxRedirections;

	private String prefix;
}
