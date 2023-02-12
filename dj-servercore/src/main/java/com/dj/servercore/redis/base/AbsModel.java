package com.dj.servercore.redis.base;

import java.util.concurrent.TimeUnit;

import com.dj.domain.RedisKeys;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.servercore.redis.RedisTemplate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class AbsModel {
	/**
	 *	数据Key
	 */
	private String key;

	/**
	 *	数据锁Lock Key
	 */
	private String lockKey;

	/**
	 *	唯一id
	 */
	protected long uniqueId;

	/**
	 *	数据
	 */
	protected ModelData data;

	/**
	 *	数据摘要
	 */
	protected String dataDigest = "";

	/**
	 *	加锁
	 */
	protected boolean isLocked = false;

	/**
	 *	加锁时间
	 */
	protected long lockedTime;

	/**
	 * lock操作模版
	 */
	protected RedisTemplate lockTemplate;

	/**
	 * redis操作模版
	 */
	protected RedisTemplate redisTemplate;

	/**
	 *	初始化数据结构
	 */
	protected abstract void init();

	/**
	 *	加载结束之后会调用这个方法。 本方法会在 构造函数的最后执行。
	 * <p>
	 *	按需重写就好了。
	 */
	protected void onLoadOver() {
	}

	/**
	 * @Title: lock
	 * @Description: Model加锁
	 */
	public void lock() {
		if (lockTemplate.acquireLock(getLockKey(), RedisKeys.REDIS_KEY_LOCK_TIME, TimeUnit.MILLISECONDS)) {
			setLocked(true);
			setLockedTime(System.currentTimeMillis());
		} else {
			// 已被其他请求加锁
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_LOCK_FAILED);
		}
	}

	/**
	 * @Title: unLock
	 * @Description: model释放锁
	 */
	public void unLock() {
		lockTemplate.releaseLockAsync(getLockKey());
		setLocked(false);
	}
}
