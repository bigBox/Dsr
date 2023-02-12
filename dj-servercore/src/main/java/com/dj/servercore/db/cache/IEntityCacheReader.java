package com.dj.servercore.db.cache;

import com.dj.domain.base.IEntity;
import com.dj.servercore.db.cache.model.EntityCacheModel;

/**
 * @author zcq
 * @description 角色缓存读取接口
 * @date 2019年3月29日
 */
public interface IEntityCacheReader {

    /**
     *	获取模块
     *
     * @param modelEntityClass 模块对应实体类型
     */
    EntityCacheModel getModel(Class<? extends IEntity> modelEntityClass);
}
