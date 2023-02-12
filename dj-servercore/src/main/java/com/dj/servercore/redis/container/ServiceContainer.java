package com.dj.servercore.redis.container;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.servercore.pool.PooledObjectFactory;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.servercore.redis.base.AbsService;
import com.dj.domain.util.Utility;
import com.dj.domain.util.cache.CacheUtil;
import com.dj.domain.util.inf.IArgumentRunnable;
import com.google.common.cache.Cache;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class ServiceContainer {

    /**
     * @Field redisTemplate: redis操作模版
     */
    private RedisTemplate redisTemplate;

    /**
     * @Field lockTemplate: lock操作模版
     */
    private RedisTemplate lockTemplate;

    /**
     * @Field rankContainer: 排行榜容器
     */
    private RankContainer rankContainer;

    /**
     * @Field modelContainer: 数据模型容器
     */
    private ModelContainer modelContainer;

    /**
     * @Field serviceMap: 业务map
     */
    private Cache<String, AbsService> serviceMap = CacheUtil.createCache();

    /**
     * @Field onSaveOver: 在保存结束之后会调用这个 | 每次设置后仅有效一次
     */
    private IArgumentRunnable<Object> onSaveOver = null;

    /**
     * @Field onSaveError: 保存失败会调用这个方法
     */
    private IArgumentRunnable<Object> onSaveError = null;

    /**
     * @Field onSaveOverParam: onSaveOver 的参数属性
     */
    private Object onSaveOverParam = null;

    /**
     *	初始化
     */
    public void init(RedisTemplate lockTemplate, RedisTemplate redisTemplate) {
        try {
            setLockTemplate(lockTemplate);
            setRedisTemplate(redisTemplate);
            setRankContainer((RankContainer) PooledObjectFactory.getInstance().borrowObject(RankContainer.class));
            getRankContainer().setRedisTemplate(redisTemplate);
            setModelContainer((ModelContainer) PooledObjectFactory.getInstance().borrowObject(ModelContainer.class));
            getModelContainer().setLockTemplate(lockTemplate);
            getModelContainer().setRedisTemplate(redisTemplate);
            getServiceMap().invalidateAll();
            clearOnSave();
            //setNoCacheAndNoSave(true);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }
    }

    /**
     * @return void
     * @Title dispose
     * @Description 清空属性
     */
    public void dispose() {
        setLockTemplate(null);
        setRedisTemplate(null);
        getRankContainer().clear();
        PooledObjectFactory.getInstance().returnObject(getRankContainer());
        setRankContainer(null);
        getModelContainer().clear();
        PooledObjectFactory.getInstance().returnObject(getModelContainer());
        setModelContainer(null);
        ConcurrentMap<String, AbsService> maps = getServiceMap().asMap();
        if (maps != null) {
            for (Map.Entry<String, AbsService> entry : maps.entrySet()) {
                PooledObjectFactory.getInstance().returnObject(entry.getValue());
            }
        }
        getServiceMap().invalidateAll();
    }

    /**
     *	保存更改
     */
    public void save() {
        try {
            // 保存排行数据
            rankContainer.save();
            // 保存Model数据
            modelContainer.save();
            if (onSaveOver != null) {
                onSaveOver.run(onSaveOverParam);
            }
        } catch (Exception e) {
            if (onSaveError != null) {
                onSaveError.run(onSaveOverParam);
            }
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_SAVE_ERROR);
        } finally {
            clearOnSave();
        }
    }

    /**
     *	执行 保存结束的工作 | 此方法并不会保存model 和 rank
     */
    public void execSaveOverWork() {
        try {
            if (onSaveOver != null) {
                onSaveOver.run(onSaveOverParam);
            }
        } catch (Exception e) {
            if (onSaveError != null) {
                onSaveError.run(onSaveOverParam);
            }
            log.error(Utility.getTraceString(e));
        } finally {
            clearOnSave();
        }
    }

    /**
     *	设置 container 保存完成后的回调函数
     *
     * @param onSaveOver
     */
    public void setOnSaveOver(IArgumentRunnable<Object> onSaveOver) {
        if (this.onSaveOver != null && onSaveOver != null) {
            throw new CommonException(ErrorID.SYSTEM_SAVE_ERROR);
        }
        this.onSaveOver = onSaveOver;
    }

    /**
     * @param onSaveError
     */
    public void setOnSaveError(IArgumentRunnable<Object> onSaveError) {
        if (this.onSaveError != null && onSaveError != null) {
            throw new CommonException(ErrorID.SYSTEM_SAVE_ERROR, "onSaveError set twice ...");
        }
        this.onSaveError = onSaveError;
    }

    private void clearOnSave() {
        onSaveError = null;
        onSaveOver = null;
        onSaveOverParam = null;
    }

    /**
     *	回退 解锁
     */
    public void rollBack() {
        rankContainer.rollBack();
        modelContainer.rollBack();
    }

    /**
     *	设置无缓存 不保存
     */
    public void setNoCacheAndNoSave(boolean noCacheAndNoSave) {
        modelContainer.setNoCacheAndNoSave(noCacheAndNoSave);
    }

    /**
     * @param clz
     * @return T
     * @Title getService
     * @Description 获取service实例
     */
    @SuppressWarnings("unchecked")
    public <T extends AbsService> T getService(Class<T> clz) {
        AbsService ret = null;
        try {
            ret = serviceMap.get(clz.getName(), (Callable<T>) () -> (T) PooledObjectFactory.getInstance().borrowObject(clz));
            ret.setServiceContainer(this);
        } catch (ExecutionException e) {
            log.error(Utility.getTraceString(e));
        }
        return (T) ret;
    }
}
