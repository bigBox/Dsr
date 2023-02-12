package com.dj.servercore.db.inf.dao;

import com.dj.domain.base.IEntity;
import com.dj.domain.util.lib.QueryParamMap;

import java.util.List;

public interface IDaoOperation<P extends IEntity> {

    /**
     *	根据主键读取单条记录
     *
     * @param primaryKey 主键
     * @return
     */
    P query(Object primaryKey, long identity, String accessType);
    /**
     *	插入单条记录
     *
     * @param pojo 对应表结构实体类对象
     * @return 主键
     */
    int insert(P pojo, long identity, String accessType);

    /**
     *	更新单条记录
     *
     * @param pojo 对应表结构实体类对象
     * @return
     */
    int update(P pojo, long identity, String accessType);

    /**
     *	删除单条记录
     *
     * @param primaryKey 主键
     * @return
     */
    int delete(Object primaryKey, long identity, String accessType);
    /**
     *	获取多条记录(无分页)
     *
     * @param key
     * @param value
     * @return
     */
    List<P> queryList(String key, Object value, long identity, String accessType);
    /**
     *	获取所有记录(无分页)
     *
     * @param
     */
    List<P> getAll(long identity, String accessType);
    /**
     *	根据条件读取单条记录
     *
     * @param queryParams 主键
     * @return
     */
    P select(QueryParamMap queryParams, long identity, String accessType);
    /**
     *	获取多条记录(无分页)
     *
     * @param queryParams
     * @return
     */
    List<P> selectList(QueryParamMap queryParams, long identity, String accessType);
}
