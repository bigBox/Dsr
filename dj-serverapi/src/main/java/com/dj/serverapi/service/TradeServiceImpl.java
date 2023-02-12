package com.dj.serverapi.service;

import com.dj.serverapi.service.inf.ITradeService;
import com.dj.servercore.redis.base.BaseService;
import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public class TradeServiceImpl extends BaseService implements ITradeService {

    @Getter
    public Set<Long> tradeRoleIDSet = Sets.newHashSet();

//    @Override
//    public void addTradeOrder(GlobalTradeOrder trade) {
//        TradeOrderModel model = getWriteModel(trade.getItemID(), TradeOrderModel.class);
//        if(model != null) {
//            Map<Long, GlobalTradeOrder> tradeMap = model.getTradeOrder(trade.getType());
//            if(tradeMap == null){
//                tradeMap = new HashMap<>();
//            }
//            tradeMap.put(trade.getOrderID(), trade);
//        }
//    }

//    @Override
//    public void delTradeOrder(GlobalTradeOrder trade) {
//        TradeOrderModel model = getWriteModel(trade.getItemID(), TradeOrderModel.class);
//        if(model != null) {
//            Map<Long, GlobalTradeOrder> tradeMap = model.getTradeOrder(trade.getType());
//            if(tradeMap != null) {
//                tradeMap.remove(trade.getOrderID());
//            }
//        }
//    }

//    @Override
//    public GlobalTradeOrder getTradeOrder(long itemId, long orderId, int type) {
//        TradeOrderModel model = getReadModel(itemId, TradeOrderModel.class);
//        if(model != null) {
//            Map<Long, GlobalTradeOrder> tradeMap = model.getTradeOrder(type);
//            if(tradeMap != null) {
//                return tradeMap.get(orderId);
//            }
//        }
//        return null;
//    }

//    @Override
//    public Map<Long, GlobalTradeOrder> getAllTradeOrder(long itemId, int type) {
//        TradeOrderModel model = getReadModel(itemId, TradeOrderModel.class);
//        if(model != null) {
//            Map<Long, GlobalTradeOrder> tradeMap = model.getTradeOrder(type);
//            return tradeMap;
//        }
//        return new HashMap<>();
//    }

//    @Override
//    public void addTradeRecord(GlobalTradeRecord trade) {
//        TradeRecordModel model = getWriteModel(trade.getItemID(), TradeRecordModel.class);
//        if(model != null) {
//            Map<Long, GlobalTradeRecord> tradeMap = model.getTradeRecord();
//            if(tradeMap == null){
//                tradeMap = new HashMap<>();
//            }
//            tradeMap.put(trade.getOrderID(), trade);
//        }
//    }

//    @Override
//    public void delTradeRecord(GlobalTradeRecord trade) {
//        TradeRecordModel model = getWriteModel(trade.getItemID(), TradeRecordModel.class);
//        if(model != null) {
//            Map<Long, GlobalTradeRecord> tradeMap = model.getTradeRecord();
//            if(tradeMap != null) {
//                tradeMap.remove(trade.getOrderID());
//            }
//        }
//    }

//    @Override
//    public GlobalTradeRecord getTradeRecord(long itemId, long orderId) {
//        TradeRecordModel model = getReadModel(itemId, TradeRecordModel.class);
//        if(model != null) {
//            Map<Long, GlobalTradeRecord> tradeMap = model.getTradeRecord();
//            if(tradeMap != null) {
//                return tradeMap.get(orderId);
//            }
//        }
//        return null;
//    }

//    @Override
//    public Map<Long, GlobalTradeRecord> getAllTradeRecord(long itemId) {
//        TradeRecordModel model = getReadModel(itemId, TradeRecordModel.class);
//        if(model != null) {
//            Map<Long, GlobalTradeRecord> tradeMap = model.getTradeRecord();
//            return tradeMap;
//        }
//        return new HashMap<>();
//    }

//    @Override
//    public synchronized void tradeEnqueue(long roleID, TradeEnqueueReq req) {
//
//    }

    public void addTradeRoleId(long roleId){
        tradeRoleIDSet.add(roleId);
    }

    public void removeTradeRoleId(long roleId){
        tradeRoleIDSet.remove(roleId);
    }

    public Set<Long> getTradeRoleIds(){
        return  tradeRoleIDSet;
    }
}
