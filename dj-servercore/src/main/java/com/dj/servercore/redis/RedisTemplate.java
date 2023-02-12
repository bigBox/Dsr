package com.dj.servercore.redis;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.client.codec.ByteArrayCodec;
import org.redisson.client.codec.LongCodec;
import org.redisson.client.protocol.ScoredEntry;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.ReadMode;
import org.redisson.config.SingleServerConfig;
import org.redisson.config.SubscriptionMode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dj.domain.RedisKeys;
import com.dj.domain.ServerThread;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.servercore.server.SocketServer;
import com.dj.domain.util.GsonUtil;
import com.dj.domain.util.Utility;
import com.dj.domain.util.ZLibUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class RedisTemplate {

    private static final String separator = "_";
    private static final short separatorLength = (short) separator.length();

    protected Redisson redisson;

    private String prefix;

    private short prefixLength;

    private int connectionPoolSize;

    public RedisTemplate(RedisConfig redisConfig) {
        shutdown();
        prefix = redisConfig.getPrefix();
        prefixLength = (short) prefix.length();
        if (SocketServer.getServerConfig() != null) {
            connectionPoolSize = SocketServer.getThreadNum();
        } else {
            connectionPoolSize = ServerThread.SERVER_THREAD_NUM;
        }
        log.info("Redis config={},connectionPoolSize={}", GsonUtil.toJson(redisConfig), connectionPoolSize);
        Config config = new Config();
        if (redisConfig.isCluster()) {
            // 集群模式
            ClusterServersConfig csc = config.useClusterServers();
            csc.addNodeAddress(redisConfig.getRedisAddresses());
            csc.setScanInterval(5000);
            csc.setReadMode(ReadMode.MASTER);
            csc.setSubscriptionMode(SubscriptionMode.MASTER);
            // 设定连接数
            csc.setMasterConnectionPoolSize((int) (connectionPoolSize / 0.75F));
            csc.setMasterConnectionMinimumIdleSize(connectionPoolSize / 2);
        } else {
            // 单例模式
            SingleServerConfig ssc = config.useSingleServer();
            ssc.setAddress(redisConfig.getRedisAddresses()[0]);
            // 设定连接数
            ssc.setConnectionPoolSize((int) (connectionPoolSize / 0.75F));
            ssc.setConnectionMinimumIdleSize(connectionPoolSize / 2);
            ssc.setTimeout(redisConfig.getTimeout());
            if (!StringUtils.isEmpty(redisConfig.getPass())) {
                ssc.setPassword(redisConfig.getPass());
            }
        }
        redisson = (Redisson) Redisson.create(config);
        log.info("Start the Redisson template={}", this);
    }

    /**
     * @return void
     * @Title shutdown
     * @Description 关闭
     */
    public void shutdown() {
        try {
            if (redisson != null) {
                log.info("Shutdown the Redisson");
                redisson.shutdown();
            }
        } catch (Exception e) {
            log.error("Shutdown the redisson=> [Fail] cause={}", Utility.getTraceString(e));
        }
    }

    /**
     * @param nativeKey
     * @return String
     * @Title buildKey
     * @Description key加上通用配置前缀
     */
    public String buildKey(String nativeKey) {
        if (nativeKey == null || nativeKey.length() <= 0) {
            return nativeKey;
        }
        StringBuilder key = new StringBuilder(prefixLength + separatorLength + nativeKey.length());
        if (!nativeKey.contains(prefix)) {
            key.append(prefix);
            key.append(separator);
            key.append(nativeKey);
        }
        return key.toString().replaceAll(" ", separator);
    }

    /**
     * @param key
     * @return String
     * @Title buildLockKey
     * @Description 创建key的对应lockkey
     */
    public String buildLockKey(String key) {
        return MessageFormat.format(RedisKeys.LOCK_KEY_PREFIX, key);
    }

    /**
     * @param lockKey
     * @return boolean
     * @Title acquireFairLock
     * @Description 获取分布式公平锁-默认过期时间为 CoreConstant.REDIS_KEY_LOCK_TIME
     */
    public boolean acquireLock(String lockKey) {
        return acquireLock(lockKey, RedisKeys.REDIS_KEY_LOCK_TIME, TimeUnit.MILLISECONDS);
    }

    /**
     * @param lockKey 锁名
     * @param expire  过期时间
     * @param unit    时间单位
     * @return boolean
     * @Title acquireLock
     * @Description 获取分布式公平锁
     */
    public boolean acquireLock(String lockKey, long expire, TimeUnit unit) {
        redisson.getFairLock(lockKey).lock(expire, unit);
        return true;
    }

    /**
     *	获取分布式公平锁
     *
     * @param lockKey
     * @param waitTime
     * @param expire
     * @param unit
     * @return
     */
    public boolean tryLock(String lockKey, long waitTime, long expire, TimeUnit unit) {
        try {
            return redisson.getFairLock(lockKey).tryLock(waitTime, expire, unit);
        } catch (InterruptedException e) {
            log.error(Utility.getTraceString(e));
        }
        return false;
    }

    /**
     * @param lockKey 锁名
     * @return void
     * @Title releaseLock
     * @Description 释放分布式锁
     */
    public void releaseLock(String lockKey) {
        redisson.getFairLock(lockKey).unlock();
        // redisLog.info("releaseLock key={},thread={},time={}", lockKey,
        // Thread.currentThread().getName(),
        // System.currentTimeMillis());
    }

    /**
     * 异步释放掉锁
     *
     * @param lockKey
     */
    public void releaseLockAsync(String lockKey) {
        redisson.getFairLock(lockKey).unlockAsync();
        // redisLog.info("releaseLock key={},thread={},time={}", lockKey,
        // Thread.currentThread().getName(),
        // System.currentTimeMillis());
    }

    /**
     *	获取KEY 不反序列化
     */
    public Object get(String key) {
        try {
            return redisson.getBucket(buildKey(key)).get();
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	设置KEY
     */
    public void set(String key, Object value) {
        try {
            redisson.getBucket(buildKey(key)).setAsync(value);
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    public void set(String key, Object value, long timeToLive, TimeUnit timeUnit) {
        try {
            redisson.getBucket(buildKey(key)).setAsync(value, timeToLive, timeUnit);
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	删除KEY
     */
    public void delete(String key) {
        try {
            redisson.getBucket(buildKey(key)).delete();
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	删除key
     *
     * @param key
     */
    public void deleteByKey(String key) {
        try {
            redisson.getBucket(key).delete();
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	是否存在KEY
     */
    public boolean exits(String key) {
        try {
            RFuture<Boolean> future = redisson.getBucket(buildKey(key)).isExistsAsync();
            return future.get(250, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	设置key过期时间
     */
    public void expire(String key, long period, TimeUnit timeUnit) {
        try {
            redisson.getBucket(buildKey(key)).expireAsync(period, timeUnit);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	重命名某个key
     *
     * @param oldKey
     * @param newKey
     */
    public void rename(String oldKey, String newKey) {
        try {
            redisson.getBucket(buildKey(oldKey)).rename(buildKey(newKey));
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	自增KEY
     */
    public Long increment(String key) {
        try {
            return redisson.getAtomicLong(buildKey(key)).incrementAndGet();
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    public void listAdd(String key, Object value) {
        try {
            redisson.getList(buildKey(key)).add(value);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    public Object listGet(String key, int index) {
        try {
            RList<Object> list = redisson.getList(buildKey(key));
            if (list == null || list.size() < index + 1) {
                return null;
            }
            return list.get(index);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    public int listSize(String key) {
        try {
            RList<Object> list = redisson.getList(buildKey(key));
            if (list == null) {
                return 0;
            }
            return list.size();
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	设置HASH表的值 不序列化
     */
    public void hashSet(String key, Object field, Object value) {
        try {
            redisson.getMap(buildKey(key)).put(field, value);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	获取HASH表的值 不反序列化
     */
    public Object hashGet(String key, Object field) {
        try {
            return redisson.getMap(buildKey(key)).get(field);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	移除HASH表的值
     */
    public void hashDelete(String key, Object field) {
        try {
            redisson.getMap(buildKey(key)).remove(field);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	获取HASH表的所有的键和值 不反序列化
     */
    public Map<Object, Object> hashGetAll(String key) {
        try {
            return redisson.getMap(buildKey(key)).readAllMap();
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	批量获取HASH表的键和值 不反序列化
     */
    public Map<Object, Object> hashMultiGet(String key, Set<Object> fields) {
        if (fields.isEmpty())
            return Maps.newHashMap();
        try {
            return redisson.getMap(buildKey(key)).getAll(fields);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	批量设置HASH表的键和值 不序列化
     */
    public void hashMultiSet(String key, Map<Object, Object> keyValues) {
        try {
            redisson.getMap(buildKey(key)).putAllAsync(keyValues);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     * HASH表中是否存在key
     */
    public boolean hashExists(String key, Object field) {
        try {
            return redisson.getMap(buildKey(key)).containsKey(field);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     * HASH表中field数
     */
    public long hashLength(String key) {
        try {
            return redisson.getMap(buildKey(key)).size();
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     * @param pattern - match pattern
     * @return TreeSet<String>
     * @Title keys
     * @Description Find keys by key search pattern
     * <p>
     */
    public List<String> keys(String pattern) {
        try {
            RKeys keys = redisson.getKeys();
            if(keys != null) {
                return Lists.newArrayList(keys.getKeysByPattern(buildKey(pattern)));
            }
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
        return null;
    }

    /**
     *	有序集合 设置用户分数
     */
    public void zAdd(String key, double score, Object member) {
        try {
            redisson.getScoredSortedSet(buildKey(key), LongCodec.INSTANCE).addAsync(score, member);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	有序集合 设置用户分数
     */
    public void zAdd(String key, Map<Object, Double> scoreMembers) {
        try {
            redisson.getScoredSortedSet(buildKey(key), LongCodec.INSTANCE).addAllAsync(scoreMembers);
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	有序集合 用户分数自增
     */
    public double zIncrement(String key, double scoreIncr, Object member) {
        try {
            return redisson.getScoredSortedSet(buildKey(key), LongCodec.INSTANCE).addScore(member, scoreIncr);
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	有序集合 移除用户
     */
    public void zRemove(String key, Object member) {
        try {
            redisson.getScoredSortedSet(buildKey(key), LongCodec.INSTANCE).removeAsync(member);
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	有序集合 根据排行移除用户
     */
    public void zRemoveByRank(String key, int start, int end) {
        try {
            redisson.getScoredSortedSet(buildKey(key), LongCodec.INSTANCE).removeRangeByRankAsync(start, end);
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	有序集合 升序列表
     */
    public List<ScoredEntry<?>> zRangeAsc(String key, int start, int end) {
        try {
            return Lists.newArrayList(redisson.getScoredSortedSet(buildKey(key), LongCodec.INSTANCE).entryRange(start, end));
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	有序集合 降序列表
     */
    public List<ScoredEntry<?>> zRangeDesc(String key, int start, int end) {
        try {
            return Lists.newArrayList(redisson.getScoredSortedSet(buildKey(key), LongCodec.INSTANCE).entryRangeReversed(start, end));
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	有序集合 获取某用户排行 升序 无则返回null
     */
    public Integer zRankAsc(String key, Object member) {
        try {
            return redisson.getScoredSortedSet(buildKey(key), LongCodec.INSTANCE).rank(member);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	有序集合 获取某用户排行 降序 无则返回null
     */
    public Integer zRankDesc(String key, Object member) {
        try {
            return redisson.getScoredSortedSet(buildKey(key), LongCodec.INSTANCE).revRank(member);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	有序集合 获取某用户分数 无则返回null
     */
    public Double zScore(String key, Object member) {
        try {
            return redisson.getScoredSortedSet(buildKey(key), LongCodec.INSTANCE).getScore(member);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	有序集合 获取排行榜内用户总数
     */
    public Integer zCard(String key) {
        try {
            return redisson.getScoredSortedSet(buildKey(key), LongCodec.INSTANCE).size();
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	存储单个对象
     */
    public void setObject(String key, Object value) {
        try {
            redisson.getBucket(buildKey(key), ByteArrayCodec.INSTANCE).setAsync(serialize(value));
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	存储单个对象
     */
    public void setObjectSync(String key, Object value) {
        try {
            redisson.getBucket(buildKey(key), ByteArrayCodec.INSTANCE).set((serialize(value)));
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	存储单个对象-有超时时间-秒
     */
    public void setObject(String key, Object value, int expire, TimeUnit unit) {
        try {
            redisson.getBucket(buildKey(key), ByteArrayCodec.INSTANCE).setAsync(serialize(value), expire, unit);
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	存储列表对象
     */
    public void setObjectList(String key, List<?> value) {
        try {
            if (value == null || value.isEmpty()) {
                return;
            }
            redisson.getBucket(buildKey(key), ByteArrayCodec.INSTANCE).setAsync(serializeList(value));
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	存储多个对象 事务 objectMap:类名=>model
     */
    public void setObjectMap(HashMap<String, Object> objectMap) {
        if (!objectMap.isEmpty()) {
            try {
                RBatch batch = redisson.createBatch();
                for (Map.Entry<String, Object> entry : objectMap.entrySet()) {
                    batch.getBucket(buildKey(entry.getKey()), ByteArrayCodec.INSTANCE).setAsync(serialize(entry.getValue()));
                }
                batch.execute();
            } catch (Exception e) {
                log.error(Utility.getTraceString(e));
                throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
            } finally {
                objectMap.clear();
                // PoolableObjectFactory.getInstance().returnObject(objectMap);
            }
        }
    }

    /**
     *	获取单个对象
     */
    public <T> T getObject(String key, Class<T> clas) {
        T obj;
        try {
            RBucket<byte[]> bucket = redisson.getBucket(buildKey(key), ByteArrayCodec.INSTANCE);
            obj = unserialize(bucket.get(), clas);
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
        return obj;
    }

    /**
     *	获取单个对象
     */
    public <T> T getObjectNoBuild(String key, Class<T> clas) {
        T obj = null;
        try {
            RBucket<byte[]> bucket = redisson.getBucket(key, ByteArrayCodec.INSTANCE);
            obj = unserialize(bucket.get(), clas);
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
        return obj;
    }

    /**
     *	获取列表对象
     *
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> getObjectList(String key, Class<T> clas) {
        T obj = null;
        try {
            RBucket<byte[]> bucket = redisson.getBucket(buildKey(key), ByteArrayCodec.INSTANCE);
            obj = unserializeList(bucket.get(), clas);
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
        return (List<T>) obj;
    }

    /**
     *	添加对象到set集合
     *
     * @param key
     * @param obj
     * @return
     */
    public void setObjectSet(String key, Object obj) {
        try {
            redisson.getSet(buildKey(key)).add(obj);
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	获取set集合所有对象
     *
     * @param key
     * @return
     */
    public Set<Object> getObjectSet(String key) {
        try {
            return redisson.getSet(buildKey(key)).readAll();
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	移除对象从set集合
     *
     * @param key
     * @param obj
     * @return
     */
    public void removeObjectSet(String key, Object obj) {
        try {
            redisson.getSet(buildKey(key)).remove(obj);
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	获取set集合大小
     *
     * @param key
     * @return
     */
    public int sizeObjectSet(String key) {
        try {
            return redisson.getSet(buildKey(key)).size();
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	删除set集合
     *
     * @param key
     */
    public void delObjectSet(String key) {
        try {
            redisson.getSet(buildKey(key)).delete();
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	删除set集合
     *
     * @param key
     */
    public void delObjectSetByKey(String key) {
        try {
            redisson.getSet(key).delete();
        } catch (Exception e) {
        	log.error(Utility.getTraceString(e));
            throw new CommonException(ErrorID.SYSTEM_REDIS_ERROR, e.getMessage());
        }
    }

    /**
     *	序列化对象
     *
     * @throws IOException
     */
    public byte[] serialize(Object obj) {
        return ZLibUtil.compress(JSON.toJSONBytes(obj, SerializerFeature.WriteClassName));
    }

    /**
     *	序列化列表对象
     */
    private byte[] serializeList(List<?> obj) {
        return ZLibUtil.compress(JSON.toJSONBytes(obj, SerializerFeature.WriteClassName));
    }

    /**
     *	反序列化对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T unserialize(byte[] objBytes, Class<T> clas) {
        if (objBytes == null)
            return null;
        return (T) JSON.parseObject(ZLibUtil.decompress(objBytes), clas);
    }

    /**
     *	反序列化列表对象
     */
    @SuppressWarnings("unchecked")
    private <T> T unserializeList(byte[] objBytes, Class<T> clas) {
        if (objBytes == null)
            return null;
        return (T) JSON.parseObject(ZLibUtil.decompress(objBytes), clas);
    }
}
