package com.dj.servercore.db.cache.model;

import com.dj.domain.base.IEntity;
import com.dj.servercore.db.inf.IQueryFilter;
import com.dj.domain.util.lib.QueryParamMap;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author zcq
 * @description 默认缓存模型
 * @date 2019年3月29日
 */
public class EntityCacheModel {

    private Map<Object, IEntity> entitys = new HashMap<Object, IEntity>();

    public EntityCacheModel(List<? extends IEntity> entityData) {
        if (null != entityData) {
            for (IEntity entity : entityData) {
                this.entitys.put(entity.getPrimaryKeyValue(), entity);
            }
        }
    }

    public synchronized IEntity load(Object primaryKey) {
        return this.entitys.get(primaryKey);
    }

    public synchronized IEntity load(QueryParamMap<String, Object> map) {
        try {
            if (null != entitys && entitys.size() > 0) {
                for (IEntity tmp : entitys.values()) {
                    for (String key : map.keySet()) {
                        Field field  = tmp.getClass().getDeclaredField(key);
                        if(field.get(key) != map.get(key)){
                            continue;
                        }
                    }
                    return tmp;
                }
            }
        }catch (Exception e){

        }
        return null;
    }

    public synchronized boolean insert(IEntity entity) {
        IEntity result = this.entitys.get(entity.getPrimaryKeyValue());
        if (null != result) {
            return false;
        }
        this.entitys.put(entity.getPrimaryKeyValue(), entity);
        return true;
    }

    public synchronized void insertBatch(List<? extends IEntity> entitys) {
        for (IEntity entity : entitys) {
            IEntity result = this.entitys.get(entity.getPrimaryKeyValue());
            if (null == result) {
                this.entitys.put(entity.getPrimaryKeyValue(), entity);
            }
        }
    }

    public synchronized boolean update(IEntity entity) {
        IEntity result = this.entitys.get(entity.getPrimaryKeyValue());
        if (null == result) {
            return false;
        }
        this.entitys.put(entity.getPrimaryKeyValue(), entity);
        return true;
    }

    public synchronized IEntity delete(Object primaryKey) {
        IEntity result = entitys.remove(primaryKey);
        return result;
    }

    public synchronized List<IEntity> loadAll() {
        return new LinkedList<>(entitys.values());
    }

    public synchronized List<IEntity> loadAll(QueryParamMap<String, Object> map) {
        try {
            if (null != entitys && entitys.size() > 0) {
                List<IEntity> result = new ArrayList<>();
                for (IEntity tmp : entitys.values()) {
                    for (String key : map.keySet()) {
                        Field field  = tmp.getClass().getDeclaredField(key);
                        if(field.get(key) != map.get(key)){
                            continue;
                        }
                    }
                    result.add(tmp);
                }
                return result;
            }
        }catch (Exception e){

        }
        return null;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public synchronized List<IEntity> loadAll(IQueryFilter filter) {
        if (null != entitys && entitys.size() > 0) {
            List<IEntity> result = new ArrayList<>();
            for (IEntity tmp : entitys.values()) {
                if (!filter.stopped() && filter.check(tmp)) {
                    result.add(tmp);
                }
            }
            return result;
        }
        return null;
    }
}
