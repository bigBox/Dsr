package com.dj.serverapi.redis.base;

import com.dj.servercore.redis.RedisTemplate;
import com.dj.servercore.server.SocketServer;

import lombok.Getter;

public abstract class AbsRedis {
	@Getter
	private static RedisTemplate redisTemplate = SocketServer.getRedisTemplate();
}
