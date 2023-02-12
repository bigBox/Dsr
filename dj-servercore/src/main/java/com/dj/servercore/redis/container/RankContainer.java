package com.dj.servercore.redis.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.redisson.api.RBatch;
import org.redisson.client.codec.LongCodec;
import org.redisson.client.protocol.ScoredEntry;

import com.dj.servercore.redis.RedisTemplate;
import com.dj.domain.util.lib.DataPair;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RankContainer {
	
    /**
     * @Field redisTemplate : redis操作模版
     */
    private RedisTemplate redisTemplate;

    /**
     * @Field rankOperations : 排行操作
     */
    private List<RankOperation> rankOperations = new ArrayList<RankOperation>(2);

    /**
     *	积分缓存， 处理“获取积分是最新的，更新则有缓存” 的情况新增的
     */
    private Map<Long, Long> pointCache = null;

    /**
     * @return void
     * @Title save
     * @Description 保存排行操作
     */
    public void save() {
        RBatch batch = redisTemplate.getRedisson().createBatch();
        for (RankOperation op : this.rankOperations) {
            String key = redisTemplate.buildKey(op.getRankName());
            switch (op.getOperation()) {
                case RankOperation.SET:
                    batch.getScoredSortedSet(key, LongCodec.INSTANCE).addAsync(op.getValue(), op.getUid());
                    break;
                case RankOperation.INCREASE:
                    batch.getScoredSortedSet(key, LongCodec.INSTANCE).addScoreAsync(op.getUid(), op.getValue());
                    break;
                case RankOperation.REMOVE:
                    batch.getScoredSortedSet(key, LongCodec.INSTANCE).removeAsync(op.getUid());
                    break;
            }
        }
        batch.execute();
        getRankOperations().clear();
    }

    /**
     *	回退
     */
    public void rollBack() {
        getRankOperations().clear();
    }

    /**
     * @return void
     * @Title clear
     * @Description 清空
     */
    public void clear() {
        setRedisTemplate(null);
        getRankOperations().clear();
    }

    private static final int MAX_TIME = 999999999;
    private static final int TIME_DIV = 1000000000;
    private static final int TIME_UNIT = 1000000000;

    /**
     * @param score
     * @return double
     * @Title makeScore
     * @Description 因为redis的zset在分数相同时用element的字典序排序revrange(倒序)所以通过在分数的小数点后加上(MAX_TIME - 时间)来保证后来的用户比先来的小才能让先来的排前面
     */
    private static double makeScore(long score) {
        return score + (double) (MAX_TIME - (int) (System.currentTimeMillis() / 1000) % TIME_UNIT) / TIME_DIV;
    }

    /**
     * @param rankName
     * @param userId
     * @param score
     * @return void
     * @Title set
     * @Description 设置用户分数【受事务控制 需要save】
     */
    public void set(String rankName, long userId, long score) {
        getRankOperations().add(new RankOperation(RankOperation.SET, rankName, userId, makeScore(score)));
    }

    /**
     * @param rankName
     * @param userId
     * @return void
     * @Title remove
     * @Description 移除用户【受事务控制】
     */
    public void remove(String rankName, long userId) {
        getRankOperations().add(new RankOperation(RankOperation.REMOVE, rankName, userId));
    }

    /**
     * @param rankName
     * @param userId
     * @param inc
     * @return void
     * @Title increase
     * @Description 用户加分【受事务控制】
     */
    public void increase(String rankName, long userId, long inc) {
        getRankOperations().add(new RankOperation(RankOperation.INCREASE, rankName, userId, Double.valueOf(inc)));
    }

    /**
     * @param rankName
     * @param userId
     * @return Integer
     * @Title getRank
     * @Description 获取用户的降序排名 【从1起】 无则返回0
     */
    public Integer getRankDesc(String rankName, long userId) {
        Integer rank = redisTemplate.zRankDesc(rankName, userId);
        return (rank == null) ? -1 : rank.intValue() + 1;
    }

    /**
     * @param rankName
     * @param userId
     * @return Integer
     * @Title: getRankAsc
     * @Description: 获取用户的升序排名 【从1起】 无则返回0
     */
    public Integer getRankAsc(String rankName, long userId) {
        Integer rank = redisTemplate.zRankAsc(rankName, userId);
        return (rank == null) ? -1 : rank.intValue() + 1;
    }

    /**
     *	删除某个排行榜
     *
     * @param rankName
     */
    public void delRank(String rankName) {
        redisTemplate.delete(rankName);
    }

    /**
     *	重命名某个排行榜
     *
     * @param rankName
     */
    public void renameRank(String rankName, String newRankName) {
        redisTemplate.rename(rankName, newRankName);
    }

    /**
     * @param rankName
     * @param userId
     * @return Long
     * @Title getScore
     * @Description 获取用户的分数 无则返回null
     */
    public Long getScore(String rankName, long userId) {
        Double score = redisTemplate.zScore(rankName, Long.toString(userId));
        return (score == null) ? 0L : score.longValue();
    }

    /**
     * @param rankName
     * @param start    起始名次 eg.1
     * @param end      终止名次 eg.10
     * @return Map<Long, Long> playerId-score
     * @Title getRanksDesc
     * @Description 根据降序排名 获取降序排行榜用户列表 【从1起】 userId=>score
     */
    public Map<Long, Long> getRanksDesc(String rankName, int start, int end) {
        Map<Long, Long> map = Maps.newLinkedHashMapWithExpectedSize(end - start + 1);
        List<ScoredEntry<?>> set = redisTemplate.zRangeDesc(rankName, start - 1, end - 1);
        for (ScoredEntry<?> scoredEntry : set) {
            map.put((Long) scoredEntry.getValue(), scoredEntry.getScore().longValue());
        }
        return map;
    }

    /**
     * @param rankName
     * @param start    起始名次 eg.1
     * @param end      终止名次 eg.10
     * @return Map<Long, Long> playerId-score
     * @Title getRanksAsc
     * @Description 根据升序排名 获取升序排行榜用户列表 【从1起】 userId=>score
     */
    public Map<Long, Long> getRanksAsc(String rankName, int start, int end) {
        Map<Long, Long> map = Maps.newLinkedHashMapWithExpectedSize(end - start + 1);
        List<ScoredEntry<?>> set = redisTemplate.zRangeAsc(rankName, start - 1, end - 1);
        for (ScoredEntry<?> scoredEntry : set) {
            map.put((Long) scoredEntry.getValue(), scoredEntry.getScore().longValue());
        }
        return map;
    }

    /**
     * @param rankName
     * @param start    起始名次 eg.1
     * @param end      终止名次 eg.10
     * @return List<Long> playerIds
     * @Title getUserIdsByRank
     * @Description 根据降序排名 获取用户列表 【从1起】
     */
    public List<Long> getUserIdsByRankDesc(String rankName, int start, int end) {
        List<Long> users = Lists.newArrayListWithExpectedSize(end - start + 1);
        users.addAll(getRanksDesc(rankName, start, end).keySet());
        return users;
    }

    /**
     * @param rankName
     * @param start    起始名次 eg.1
     * @param end      终止名次 eg.10
     * @return List<Long> playerIds
     * @Title getUserIdsByRank
     * @Description 根据升序排名 获取用户列表 【从1起】
     */
    public List<Long> getUserIdsByRankAsc(String rankName, int start, int end) {
        List<Long> users = Lists.newArrayListWithExpectedSize(end - start + 1);
        users.addAll(getRanksAsc(rankName, start, end).keySet());
        return users;
    }

    /**
     * @param rankName
     * @param userId
     * @return DataPair<Long, Long> T1-rank T2-score
     * @Title: getRankAndScoreByUserIdDesc
     * @Description: 获取用户在某个排行榜中的降序排名以及分值
     */
    public DataPair<Long, Long> getRankAndScoreByUserIdDesc(String rankName, long userId) {
        long rank = getRankDesc(rankName, userId);
        long score = getScore(rankName, userId);
        return DataPair.fromTwo(rank, score);
    }

    /**
     * @param rankName
     * @param userId
     * @return DataPair<Long, Long> T1-rank T2-score
     * @Title: getRankAndScoreByUserIdAsc
     * @Description: 获取用户在某个排行榜中的升序排名以及分值
     */
    public DataPair<Long, Long> getRankAndScoreByUserIdAsc(String rankName, long userId) {
        long rank = getRankAsc(rankName, userId);
        long score = getScore(rankName, userId);
        return DataPair.fromTwo(rank, score);
    }

    /**
     * @param rankName
     * @param num      数量 eg.10 获取前10名排行榜数据
     * @return Map<Long, Long> playerId-score
     * @Title getTopDesc
     * @Description 获取降序排行榜前N名 userId=>score
     */
    public Map<Long, Long> getTopDesc(String rankName, int num) {
        return getRanksDesc(rankName, 1, num);
    }

    /**
     * @param rankName
     * @param num      数量 eg.10 获取前10名排行榜数据
     * @return Map<Long, Long> playerId-score
     * @Title getTopAsc
     * @Description 获取升序排行榜前N名 userId=>score
     */
    public Map<Long, Long> getTopAsc(String rankName, int num) {
        return getRanksAsc(rankName, 1, num);
    }

    /**
     * @param rankName
     * @return int
     * @Title getCount
     * @Description 获取排行榜用户总数
     */
    public int getCount(String rankName) {
        return redisTemplate.zCard(rankName);
    }

    // ** cache api
    // ** 这些api 一般用于 在一个service 流程里面既需要设置积分， 又需要拿出设置后积分进行使用的时候
    public Map<Long, Long> getPointCache() {
        if (pointCache == null) {
            pointCache = new HashMap<>(1);
        }
        return pointCache;
    }

    /**
     *	带有缓存的机制的， 获取一个玩家的当前积分
     *
     * @param rankName
     * @param uid
     * @return
     */
    public long cacheGetScore(String rankName, long uid) {
        Long p = getPointCache().get(uid);
        if (p == null) {
            p = getScore(rankName, uid);
            pointCache.put(p, uid);
        }
        return p.longValue();
    }

    /**
     *	带有缓存的机制的， 设置一个玩家的当前积分
     *
     * @param rankName
     * @param uid
     * @param score
     */
    public void cacheSet(String rankName, long uid, long score) {
        set(rankName, uid, score);
        getPointCache().put(uid, score);
    }

    /**
     *	带有缓存的机制的， 增加一个玩家的当前积分
     *
     * @param rankName
     * @param uid
     * @param score
     */
    public void cacheIncrease(String rankName, long uid, long score) {
        increase(rankName, uid, score);
        Map<Long, Long> map = getPointCache();
        long p = cacheGetScore(rankName, uid);
        map.put(uid, score + p);
    }

    /**
     * @Description 排行榜操作
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class RankOperation {
        /**
         *	操作 设置排行
         */
        public static final int SET = 1;
        /**
         *	操作 移除排行
         */
        public static final int REMOVE = 2;
        /**
         *	操作 自增排行
         */
        public static final int INCREASE = 3;
        /**
         * @Field operation : 操作类型
         */
        private int operation;
        /**
         * @Field rankName : 排行榜名称
         */
        private String rankName;
        /**
         * @Field uid : 唯一ID
         */
        private long uid;
        /**
         * @Field value : 操作值
         */
        private double value;

        public RankOperation(int operation, String rankName, long userId) {
            this.operation = operation;
            this.rankName = rankName;
            this.uid = userId;
        }
    }
}
