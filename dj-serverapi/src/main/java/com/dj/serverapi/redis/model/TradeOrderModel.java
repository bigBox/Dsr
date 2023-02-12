package com.dj.serverapi.redis.model;

import com.dj.domain.RedisKeys;
import com.dj.domain.entity.global.GlobalTradeOrder;
import com.dj.protobuf.trade.TradeType;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.servercore.redis.base.BaseModel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zcq
 * @ClassName: TradeModel
 * @Description: 交易
 * @date 2019年8月7日
 */
public class TradeOrderModel extends BaseModel {

    public TradeOrderModel(Long itemId, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_TRADE, itemId, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
        this.data.initNewSubMap(RedisKeys.KEY_TRADE_ORDER_BUY);
        this.data.initNewSubMap(RedisKeys.KEY_TRADE_ORDER_SELL);
    }
    // 全部 All = 0;
    // 买 Buy = 1;
    // 卖 Sell = 2;
    public Map<Long, GlobalTradeOrder> getTradeOrder(int  type) {
        if(type == TradeType.Buy_VALUE) {
            return this.data.getSubMap(RedisKeys.KEY_TRADE_ORDER_BUY);
        }else if(type == TradeType.Sell_VALUE) {
            return this.data.getSubMap(RedisKeys.KEY_TRADE_ORDER_SELL);
        }else {
            Map<Long, GlobalTradeOrder> tradeOrderMap = new HashMap<>();
            tradeOrderMap.putAll(this.data.getSubMap(RedisKeys.KEY_TRADE_ORDER_BUY));
            tradeOrderMap.putAll(this.data.getSubMap(RedisKeys.KEY_TRADE_ORDER_SELL));
            return tradeOrderMap;
        }
    }
}
