package com.dj.servercore.db.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dj.domain.base.IEntity;
import com.dj.servercore.db.cache.model.EntityCacheModel;
import com.dj.servercore.db.cache.model.EntityCacheModelFactory;

/**
 * @author zcq
 * @description 缓存
 * @date 2019年3月29日
 */
public class EntityCache implements IEntityCache, IEntityCacheReader {

    /**
     *	唯一标志
     */
    private long identity;

    /**
     *	模块集合
     */
    private Map<Class<? extends IEntity>, EntityCacheModel> cacheModel = new HashMap<>();

    /**
     * @param identity 角色身份(userRoleId角色唯一标志)
     */
    public EntityCache(long identity) {
        this.identity = identity;
    }

    @Override
    public long getIdentity() {
        return identity;
    }

    public synchronized void addModelData(List<? extends IEntity> entitys, Class<? extends IEntity> clazz) {
        EntityCacheModel model = cacheModel.get(clazz);
        if (model == null) {
            model = EntityCacheModelFactory.getInstance().create(entitys);
            cacheModel.put(clazz, model);
        } else {
            model.insertBatch(entitys);
        }
    }

    public synchronized EntityCacheModel getModel(Class<? extends IEntity> clazz) {
        return cacheModel.get(clazz);
    }

    @Override
    public void addModelData(IEntity entity, Class<? extends IEntity> clazz) {
        if (entity == null) {
            return;
        }
        EntityCacheModel model = cacheModel.get(clazz);
        if (model == null) {
            List<IEntity> entitys = new ArrayList<>(1);
            entitys.add(entity);
            model = EntityCacheModelFactory.getInstance().create(entitys);
            cacheModel.put(clazz, model);
        } else {
            model.insert(entity);
        }
    }
}
