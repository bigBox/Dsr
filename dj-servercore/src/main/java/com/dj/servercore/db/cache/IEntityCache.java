package com.dj.servercore.db.cache;

import java.util.List;

import com.dj.domain.base.IEntity;

/**
 * @author zcq
 * @description 角色缓存
 * @date 2019年3月29日
 */
public interface IEntityCache {

    /**
     *	唯一标志
     *
     * @param
     */
    long getIdentity();

    /**
     *	初始化模块数据<br/>
     *
     * @param entitys 单表对应的实体集合
     * @param clazz   实体类型
     */
    void addModelData(List<? extends IEntity> entitys, Class<? extends IEntity> clazz);

    /**
     *	初始化模块数据
     *
     * @param entity 单表对应的实体
     * @param clazz  实体类型
     */
    void addModelData(IEntity entity, Class<? extends IEntity> clazz);
}
