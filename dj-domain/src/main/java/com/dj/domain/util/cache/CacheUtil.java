package com.dj.domain.util.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class CacheUtil {
	/**
	 * @Title: createCache
	 * @Description: 创建默认允许4个线程并发操作修改的缓存
	 * @return Cache
	 */
	public static <K, V> Cache<K, V> createCache() {
		return CacheBuilder.newBuilder().build();
	}

	/**
	 * @Title: createCache
	 * @Description: 创建默认允许4个线程并发操作修改并指明最大条目数的缓存
	 * @param maximumSize 缓存中的最大条目数
	 * @return Cache
	 */
	public static <K, V> Cache<K, V> createCache(int maximumSize) {
		return CacheBuilder.newBuilder().maximumSize(Math.max((int) (maximumSize / .75f) + 1, 16)).build();
	}

	/**
	 * @Title: createCache
	 * @Description: 创建默认允许4个线程并发操作修改并指明最大条目数和过期时间(分钟)的缓存
	 * @param maximumSize
	 * @param expireAfterAccess
	 * @return Cache
	 */
	public static <K, V> Cache<K, V> createCache(int maximumSize, int expireAfterAccess) {
		return createCache(maximumSize, 4, expireAfterAccess, TimeUnit.MINUTES);
	}

	/**
	 * @Title: createCacheWithExpire
	 * @Description: 创建默认允许4个线程并发操作修改并指明过期时间的缓存
	 * @param expireAfterAccess 最后一次访问后过期时间
	 * @param timeUnit          时间单位
	 * @return Cache
	 */
	public static <K, V> Cache<K, V> createCacheWithExpire(int expireAfterAccess, TimeUnit timeUnit) {
		return CacheBuilder.newBuilder().expireAfterAccess(expireAfterAccess, timeUnit).build();
	}

	/**
	 * @Title: createCacheWithExpire
	 * @Description: 创建默认允许4个线程并发操作修改并指明过期时间的缓存
	 * @param expireAfterAccess 最后一次写入后过期时间
	 * @param timeUnit          时间单位
	 * @return Cache
	 */
	public static <K, V> Cache<K, V> createCacheWithWriteExpire(int expireAfterAccess, TimeUnit timeUnit) {
		return CacheBuilder.newBuilder().expireAfterWrite(expireAfterAccess, timeUnit).build();
	}

	/**
	 * @Title: createCache
	 * @Description: 创建默认允许4个线程并发操作修改并指明最大条目数和过期时间的缓存
	 * @param maximumSize       缓存中的最大条目数
	 * @param expireAfterAccess 过期时间
	 * @param timeUnit          时间单位
	 * @return Cache
	 */
	public static <K, V> Cache<K, V> createCache(int maximumSize, int expireAfterAccess, TimeUnit timeUnit) {
		return createCache(maximumSize, 4, expireAfterAccess, timeUnit);
	}

	/**
	 * @Title: createCache
	 * @Description: 创建允许concurrencyLevel个线程并发操作修改并指明最大条目数和过期时间(分钟)的缓存
	 * @param maximumSize       缓存中的最大条目数
	 * @param concurrencyLevel  并发线程数
	 * @param expireAfterAccess 过期时间-分钟
	 * @return Cache
	 */
	public static <K, V> Cache<K, V> createCache(int maximumSize, int concurrencyLevel, int expireAfterAccess) {
		return createCache(maximumSize, concurrencyLevel, expireAfterAccess, TimeUnit.MINUTES);
	}

	/**
	 * @Title: createCache
	 * @Description: 创建允许concurrencyLevel个线程并发操作修改并指明最大条目数和过期时间的缓存
	 * @param maximumSize               缓存中的最大条目数
	 * @param concurrencyLevel          并发线程数
	 * @param expireAfterAccess         根据某个键值对最后一次访问之后多少时间后移除
	 * @param expireAfterAccessTimeUnit 过期时间单位
	 * @return Cache
	 */
	public static <K, V> Cache<K, V> createCache(int maximumSize, int concurrencyLevel, int expireAfterAccess, TimeUnit expireAfterAccessTimeUnit) {
		int max = Math.max((int) (maximumSize / .75f) + 1, 16);
		return CacheBuilder.newBuilder().initialCapacity((int) (max * .05f)).maximumSize(max).concurrencyLevel(concurrencyLevel).expireAfterAccess(expireAfterAccess, expireAfterAccessTimeUnit).build();
	}

}
