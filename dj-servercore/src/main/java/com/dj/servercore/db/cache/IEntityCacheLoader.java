package com.dj.servercore.db.cache;

public interface IEntityCacheLoader {

    /**
     *	初始化装载指定id的缓存对象
     *
     * @param identity
     * @return
     */
    void loadEntityCache(long identity, IEntityCache entityCache);
}
