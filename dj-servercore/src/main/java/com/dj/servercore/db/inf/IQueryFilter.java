package com.dj.servercore.db.inf;

import com.dj.domain.base.IEntity;

public interface IQueryFilter<T extends IEntity> {

    /**
     *	验证指定实体是否满足条件
     *
     * @param entity 实体
     */
    boolean check(T entity);

    /**
     *	是否停止查询,用于控制查询数量所需
     *
     * @param
     */
    boolean stopped();
}
