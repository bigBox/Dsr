package com.dj.serverapi.redis.base;

import com.dj.domain.RedisKeys;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.servercore.redis.base.BaseModel;

public abstract class InitModel extends BaseModel {

	public InitModel(String key, Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
		super(key, roleID, lockTemplate, redisTemplate, lock);
	}

	public void initTime() {
		this.data.set(RedisKeys.KEY_INIT_TIME, 0l);
	}

	public void resetInitTime() {
		this.data.set(RedisKeys.KEY_INIT_TIME, System.currentTimeMillis());
	}

	public Long getInitTime() {
		return this.data.get(RedisKeys.KEY_INIT_TIME);
	}
}
