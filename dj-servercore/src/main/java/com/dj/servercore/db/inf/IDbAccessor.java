package com.dj.servercore.db.inf;

import java.sql.SQLException;
import java.util.List;
import com.dj.domain.base.IEntity;
import com.dj.domain.util.lib.QueryParamMap;

public interface IDbAccessor {

    /**
     *	插入数据
     *
     * @param entity   实体
     * @param identity 访问身份
     */
    int insert(IEntity entity, long identity, Class<? extends IEntity> clazz);

    /**
     *	删除数据
     *
     * @param primaryKey 主键
     * @param clazz      实体类型
     * @param identity   访问身份
     */
    int delete(Object primaryKey, Class<? extends IEntity> clazz, long identity);

    /**
     *	更新数据
     *
     * @param entity   实体
     * @param identity 访问身份
     */
    int update(IEntity entity, long identity);

    /**
     *	查询
     *
     * @param primaryKey 主键
     * @param clazz      实体类型
     * @param identity   访问身份
     */
    IEntity query(Object primaryKey, Class<? extends IEntity> clazz, long identity);

    /**
     *	根据指定参数查询
     *
     * @param
     * @throws SQLException
     */
    IEntity select(QueryParamMap<String, Object> map, Class<? extends IEntity> clazz, long identity);

    /**
     *	查询多条记录
     *
     * @param indexName  索引名称(对应实体中变量)
     * @param indexValue 索引值
     * @param identity   访问身份
     */
    List<IEntity> queryList(String indexName, Object indexValue, Class<? extends IEntity> clazz, long identity);

    /**
     *	根据指定参数查询
     *
     * @param
     * @throws SQLException
     */
    List<IEntity> selectList(QueryParamMap<String, Object> map, Class<? extends IEntity> clazz, long identity);

    /**
     *	查询多个记录
     *
     * @param
     * @throws SQLException
     */
    List<IEntity> queryAll(Class<? extends IEntity> clazz, long identity);

    /**
     *	自定义查询
     *
     * @param
     */
    //@SuppressWarnings("rawtypes")
    //List<IEntity> query(String indexName, Object indexValue, IQueryFilter filter, Class<? extends IEntity> clazz, long identity);

    /**
     *	自定义查询
     *
     * @param
     * @throws SQLException
     */
    //List<IEntity> customQuery(String statement, QueryParamMap parameters, Class<? extends IEntity> clazz, long identity);

    /**
     *	自定义更新
     *
     * @param
     */
    //void customUpdate(String statement, QueryParamMap parameters, Class<? extends IEntity> clazz, long identity);

    /**
     *	自定义查询(count)
     *
     * @param
     * @throws SQLException
     */
    //Object customQueryOne(String statement, QueryParamMap<String, Object> parameters, Class<? extends IEntity> clazz, long identity);

}
