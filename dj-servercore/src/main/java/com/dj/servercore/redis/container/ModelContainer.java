package com.dj.servercore.redis.container;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;

import org.redisson.api.RBatch;
import org.redisson.client.codec.ByteArrayCodec;

import com.dj.domain.GlobalRoleID;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.servercore.redis.base.AbsModel;
import com.dj.servercore.redis.base.ModelData;
import com.dj.domain.util.Utility;
import com.dj.domain.util.cache.CacheUtil;
import com.google.common.cache.Cache;
import com.google.common.hash.Hashing;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class ModelContainer {
    
    /**
     * @Field noCacheAndNoSave : model无缓存并且不保存
     */
    private boolean noCacheAndNoSave = false;

    /**
     * @Field lockTemplate : lock操作模版
     */
    private RedisTemplate lockTemplate;

    /**
     * @Field redisTemplate : redis操作模版
     */
    private RedisTemplate redisTemplate;

    /**
     * @Field singletonMap : 单例Map roleID=>map{className=>Model}
     */
    private Cache<Object, Cache<String, AbsModel>> singletonMap = CacheUtil.createCache();

    public ModelContainer() {
        this.reset();
    }

    /**
     *	初始化 重置单例map
     */
    public final void reset() {
        singletonMap.invalidateAll();
    }

    public final void clear() {
        setLockTemplate(null);
        setRedisTemplate(null);
        getSingletonMap().invalidateAll();
    }

    /**
     *	获取单例
     */
    public final <T extends AbsModel> T getModel(long roleID, Class<T> clas, boolean lock) {
        return this.noCacheAndNoSave ? newModel(roleID, clas, false) : this.getCachedModel(roleID, clas, lock);
    }

    public final <T extends AbsModel> T getGlobalModel(Class<T> clas, boolean lock) {
        return this.noCacheAndNoSave ? newGlobalModel(GlobalRoleID.getRobot(), clas, false) : this.getCachedGlobalModel(GlobalRoleID.getRobot(), clas, lock);
    }

    /**
     *	获取缓存单例
     */
    @SuppressWarnings("unchecked")
    private final <T extends AbsModel> T getCachedModel(long roleID, Class<T> clas, boolean lock) {
        String className = clas.getName();
        T model = null;
        try {
            Cache<String, AbsModel> modelMap = getSingletonMap().get(roleID, () -> CacheUtil.createCache(10));
            model = (T) modelMap.getIfPresent(className);
            // 无实例 或者写操作时未加锁 则新建实例 未加锁时可以不新建实例但有可能使用的是脏数据
            if (model == null || (lock && !model.isLocked())) {
                model = newModel(roleID, clas, lock);
                modelMap.put(className, model);
            }
        } catch (ExecutionException e) {
            log.error(Utility.getTraceString(e));
        }
        return model;
    }

    @SuppressWarnings("unchecked")
    private final <T extends AbsModel> T getCachedGlobalModel(long roleID, Class<T> clas, boolean lock) {
        String className = clas.getName();
        T model = null;
        try {
            Cache<String, AbsModel> modelMap = getSingletonMap().get(roleID, () -> CacheUtil.createCache(10));
            model = (T) modelMap.getIfPresent(className);
            // 无实例 或者写操作时未加锁 则新建实例 未加锁时可以不新建实例但有可能使用的是脏数据
            if (model == null || (lock && !model.isLocked())) {
                model = newGlobalModel(roleID, clas, lock);
                modelMap.put(className, model);
            }
        } catch (ExecutionException e) {
            log.error(Utility.getTraceString(e));
        }
        return model;
    }

    /**
     *	新建model实例
     */
    public final <T extends AbsModel> T newModel(long roleID, Class<T> clas, Boolean lock) {
        T model;
        try {
            model = clas.getConstructor(new Class[]{Long.class, RedisTemplate.class, RedisTemplate.class, Boolean.class}).newInstance(roleID, lockTemplate, redisTemplate, lock);
        } catch (Exception e) {
            throw new CommonException(ErrorID.SYSTEM_GET_MODEL_ERROR);
        }
        return model;
    }

    public final <T extends AbsModel> T newGlobalModel(long roleID, Class<T> clas, Boolean lock) {
        T model;
        try {
            model = clas.getConstructor(new Class[]{Long.class, RedisTemplate.class, RedisTemplate.class, Boolean.class}).newInstance(roleID, lockTemplate, redisTemplate, lock);
        } catch (Exception e) {
            throw new CommonException(ErrorID.SYSTEM_GET_MODEL_ERROR);
        }
        return model;
    }

    /**
     *	保存更改到redis
     */
    public final void save() {
        if (singletonMap != null && singletonMap.size() > 0) {
            long currentTime = System.currentTimeMillis();
            try {
                RBatch batch = null;
                for (Entry<Object, Cache<String, AbsModel>> userModelEntry : singletonMap.asMap().entrySet()) {
                    for (Entry<String, AbsModel> modelEntry : userModelEntry.getValue().asMap().entrySet()) {
                        AbsModel model = modelEntry.getValue();
                        // 加锁的model才需要持久化
                        if (model.isLocked()) {
                            ModelData modelData = model.getData();
                            byte[] modelDataBytes = redisTemplate.serialize(modelData);
                            // 比较数据md5码 如果与初始md5码不一致则保存数据
                            String sourceDigest = model.getDataDigest();
                            String targetDigest = Hashing.md5().newHasher(modelDataBytes.length).putBytes(modelDataBytes).hash().toString();
                            if (sourceDigest.equals(targetDigest)) {
                                continue;
                            }
                            if (batch == null) {
                                batch = redisTemplate.getRedisson().createBatch();
                            }
                            modelData.setModified(currentTime);
                            batch.getBucket(redisTemplate.buildKey(model.getKey()), ByteArrayCodec.INSTANCE).setAsync(modelDataBytes);
                        }
                    }
                }
                if (batch != null) {
                    batch.execute();
                }
            } catch (Exception e) {
                log.error(Utility.getTraceString(e));
            } finally {
                this.unLockAll();
                this.reset();
            }
        }
    }

    /**
     *	解锁所有
     */
    protected final void unLockAll() {
        for (Entry<Object, Cache<String, AbsModel>> modelMapEntry : this.singletonMap.asMap().entrySet()) {
            for (Entry<String, AbsModel> modelEntry : modelMapEntry.getValue().asMap().entrySet()) {
                AbsModel model = modelEntry.getValue();
                // 解锁
                if (model.isLocked()) {
                    model.unLock();
                }
            }
        }
    }


    /**
     *	获取所有
     */
    public final List<AbsModel> getAllModels(Class<?> clz) {
        List<AbsModel> allModels = new ArrayList<AbsModel>();
        for (Entry<Object, Cache<String, AbsModel>> modelMapEntry : this.singletonMap.asMap().entrySet()) {
            for (Entry<String, AbsModel> modelEntry : modelMapEntry.getValue().asMap().entrySet()) {
                AbsModel model = modelEntry.getValue();
                allModels.add(model);
            }
        }
        return allModels;
    }

    /**
     *	回退解锁所有
     */
    public final void rollBack() {
        this.unLockAll();
        this.reset();
    }

    /**
     * model无缓存并且不保存
     */
    public void setNoCacheAndNoSave(boolean noCacheAndNoSave) {
        this.noCacheAndNoSave = noCacheAndNoSave;
    }
}
