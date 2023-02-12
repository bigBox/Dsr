package com.dj.servercore.db.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.dj.servercore.db.cache.write.AsyncWriteManager;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @description 缓存管理器
 * @date 2019年3月29日
 */
@Slf4j
public class CacheManager {

    private ConcurrentMap<Long, IEntityCache> cacheMap = new ConcurrentHashMap<>();

    private IEntityCacheLoader entityCacheLoader;

    @Getter
    private AsyncWriteManager asyncWriteManager;

    public void init() {
    }

    public void setEntityCacheLoader(IEntityCacheLoader entityCacheLoader) {
        this.entityCacheLoader = entityCacheLoader;
    }

    public void setAsyncWriteManager(AsyncWriteManager asyncWriteManager) {
        this.asyncWriteManager = asyncWriteManager;
    }

    /**
     *	激活指定id缓存对象
     *
     * @param identity
     */
    public void activateCache(long identity) {
        log.info("-- identity {}", identity);
        flushSyncAllData(identity, false);
        IEntityCache cache = getIdentityCache(identity);
        entityCacheLoader.loadEntityCache(identity, cache);
    }

    /**
     *	检测并激活指定id缓存对象
     *
     * @param identity
     */
    public void checkActivateCache(long identity) {
        log.info("identity {}", identity);
        IEntityCache cache = cacheMap.get(identity);
        if (null == cache) {
            cache = getIdentityCache(identity);
            entityCacheLoader.loadEntityCache(identity, cache);
        }
    }

    /**
     *	刷新同步指定id数据
     *
     * @param identity
     * @param removeFlag
     */
    public void flushSyncAllData(long identity, boolean removeFlag) {
        log.info("identity {}", identity);
        if (null != asyncWriteManager) {
            asyncWriteManager.flushSyncAllData(identity);
            if (removeFlag) {
                cacheMap.remove(identity);
            }
        }
    }

    /**
     *	获取指定id缓存
     *
     * @param
     */
    public IEntityCache getIdentityCache(long identity) {
        IEntityCache cache = cacheMap.get(identity);
        if (null == cache) {
            cache = new EntityCache(identity);
            cacheMap.put(identity, cache);
        }
        return cache;
    }
}
