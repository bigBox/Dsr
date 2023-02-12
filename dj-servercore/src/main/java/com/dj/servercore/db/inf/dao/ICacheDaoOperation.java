package com.dj.servercore.db.inf.dao;

import java.util.List;

import com.dj.domain.base.IEntity;
import com.dj.domain.util.lib.QueryParamMap;

@SuppressWarnings({"rawtypes"})
public interface ICacheDaoOperation<P extends IEntity> {
	/**
	 *	插入单条记录
	 * @param pojo 对应表结构实体类对象
	 * @return 主键
	 */
	int cacheInsert(P pojo, long identity);

	/**
	 *	更新单条记录
	 * @param pojo 对应表结构实体类对象
	 * @return
	 */
	int cacheUpdate(P pojo, long identity);

	/**
	 *	删除单条记录
	 * @param primaryKey 主键
	 * @return
	 */
	int cacheDelete(Object primaryKey, long identity);
	/**
	 *	根据主键读取单条记录
	 * @param primaryKey 主键
	 * @return
	 */
    P cacheQuery(Object primaryKey, long identity);
	P cacheLoad(String key, Object value, long identity);
	/**
	 *	根据主键读取单条记录
	 * @param queryParams 主键
	 * @return
	 */
	P cacheSelect(QueryParamMap queryParams, long identity);
	/**
	 *	获取表与userRoleId相关的所有记录
	 * @param identity
	 * @return
	 */
    List<P> cacheLoadAll(long identity);
	
	/**
	 *	获取表与userRoleId相关的所有记录
	 * @param key
	 * @param identity
	 */
    List<P> cacheLoadAll(String key, Object value, long identity);
	List<P> cacheLoadAll(QueryParamMap queryParams, long identity);

}
