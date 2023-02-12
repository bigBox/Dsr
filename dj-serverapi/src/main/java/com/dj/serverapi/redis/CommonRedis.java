package com.dj.serverapi.redis;

import com.dj.domain.RedisKeys;
import com.dj.serverapi.redis.base.AbsRedis;

public class CommonRedis extends AbsRedis {

    private static final CommonRedis INSTANCE = new CommonRedis();

    public static final CommonRedis getInstance() {
        return INSTANCE;
    }

    /**
     *	获取自动增长角色id
     *
     * @return
     */
    public long getAtomicRoleId() {
        String key = getRedisTemplate().buildKey(RedisKeys.ROLE_ID);
        long tempRoleId = getRedisTemplate().getRedisson().getAtomicLong(key).incrementAndGet();
        long roleId = tempRoleId + RedisKeys.ROLEID_BASE_NUM;
        return roleId;
    }

    /**
     *	获取模块自增主键id
     *
     * @param module
     * @return
     */
    public long readModuleID(String module) {
        String key = getRedisTemplate().buildKey(module);
        long id = getRedisTemplate().getRedisson().getAtomicLong(key).incrementAndGet();
        return id;
    }
}
