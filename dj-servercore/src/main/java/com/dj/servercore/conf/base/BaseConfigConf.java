package com.dj.servercore.conf.base;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.domain.util.GsonUtil;
import com.google.common.collect.ImmutableMap;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public abstract class BaseConfigConf<T> {

	private String config;
	
	protected final ReentrantReadWriteLock configRWLock = new ReentrantReadWriteLock();
	
	protected List<T> dataList;
	
	public BaseConfigConf(String config) {
		this.config = config;
	}
	
	public abstract void onLoadOver();

	protected <C> C getConfig(C c) {
		if (c == null) {
			return null;
		}
		ReentrantReadWriteLock.ReadLock rlock = configRWLock.readLock();
		try {
			rlock.lock();
			return c;
		} finally {
			rlock.unlock();
		}
	}
	
	protected <K, V> V getConfig(K k, ImmutableMap<K, V> map) {
		return getConfig(k, map, true);
	}
	
	protected <K, V> V getConfig(K k, ImmutableMap<K, V> map, boolean check) {
		if (map == null) {
			return null;
		}
		if(!map.containsKey(k) && check) {
			log.error(this.getClass().getName());
			log.error(GsonUtil.toJson(k));
			throw new CommonException(ErrorID.COMMON_CONFIG_ERROR);
		}
		ReentrantReadWriteLock.ReadLock rlock = configRWLock.readLock();
		try {
			rlock.lock();
			return map.get(k);
		} finally {
			rlock.unlock();
		}
	}
	
	protected <K, V> V getConfig(K k, Map<K, V> map) {
		return getConfig(k, map, true);
	}
	
	protected <K, V> V getConfig(K k, Map<K, V> map, boolean check) {
		if (map == null) {
			return null;
		}
		if(!map.containsKey(k) && check) {
			log.error(this.getClass().getName());
			log.error(GsonUtil.toJson(k));
			throw new CommonException(ErrorID.COMMON_CONFIG_ERROR);
		}
		ReentrantReadWriteLock.ReadLock rlock = configRWLock.readLock();
		try {
			rlock.lock();
			return map.get(k);
		} finally {
			rlock.unlock();
		}
	}
}
