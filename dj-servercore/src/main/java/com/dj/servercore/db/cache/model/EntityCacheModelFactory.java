package com.dj.servercore.db.cache.model;

import java.util.List;

import com.dj.domain.base.IEntity;

public class EntityCacheModelFactory{

	private static EntityCacheModelFactory factory = new EntityCacheModelFactory();

	/**
	 *	获取工厂实例
	 * @param
	 */
	public static EntityCacheModelFactory getInstance(){
		return factory;
	}

	/**
	 * @param data 实体集合
	 */
	public EntityCacheModel create(List<? extends IEntity> data) {
		return new EntityCacheModel(data);
	}
}
