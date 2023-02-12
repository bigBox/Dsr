package com.dj.serverapi.redis.model;

import com.dj.domain.RedisKeys;
import com.dj.domain.entity.global.GlobalTradeRecord;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.servercore.redis.base.BaseModel;

import java.util.Map;

/**
 * @author zcq
 * @ClassName: TradeModel
 * @Description: 交易
 * @date 2019年8月7日
 */
public class TradeRecordModel extends BaseModel {

    public TradeRecordModel(Long itemId, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_TRADE, itemId, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
        this.data.initNewSubMap(RedisKeys.KEY_TRADE_RECORD);
    }

    public Map<Long, GlobalTradeRecord> getTradeRecord() {
        return this.data.getSubMap(RedisKeys.KEY_TRADE_RECORD);
    }
}
