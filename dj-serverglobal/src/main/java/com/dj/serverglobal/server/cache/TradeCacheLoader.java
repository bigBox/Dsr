//package com.dj.serverglobal.server.cache;
//
//import com.dj.domain.entity.global.GlobalTradeHistory;
//import com.dj.domain.entity.global.GlobalTradeOrder;
//import com.dj.domain.entity.global.GlobalTradeStock;
//import com.dj.domain.util.lib.QueryParamMap;
//import com.dj.serverapi.dao.GlobalTradeHistoryDao;
//import com.dj.serverapi.dao.GlobalTradeOrderDao;
//import com.dj.serverapi.dao.GlobalTradeRecordDao;
//import com.dj.serverapi.dao.GlobalTradeStockDao;
//import com.dj.servercore.db.cache.IEntityCache;
//import com.dj.servercore.db.cache.IEntityCacheLoader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * @author zcq
// * @ClassName: TradeCacheLoader
// * @Description: 交易缓存加载器， 订单id作为唯一标识
// * @date 2019年6月25日
// */
//@Component("tradeCacheLoader")
//public class TradeCacheLoader implements IEntityCacheLoader {
//
//    @Autowired
//    public GlobalTradeStockDao   globalTradeStockDao;
//    @Autowired
//    public GlobalTradeOrderDao   globalTradeOrderDao;
//    @Autowired
//    public GlobalTradeRecordDao  globalTradeRecordDao;
//    @Autowired
//    public GlobalTradeHistoryDao globalTradeHistoryDao;
//
//    @Override
//    public void loadEntityCache(long identity, IEntityCache entityCache) {
//        QueryParamMap queryParams = new QueryParamMap();
//        queryParams.put("itemID",identity);
//        GlobalTradeStock tradeStock = globalTradeStockDao.cacheSelect(queryParams, identity);
//        if (tradeStock == null) {
//            return;
//        	// 初始化交易库存列表
//            //ConfigItemsConf conf = ConfManager.getInstance().getConfigItemsConf();
//            //if(conf == null){
//            //    throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
//            //}
//            //ConfigItems item = conf.getItem((int) identity, false);
//            //if (ObjectUtils.isNotEmpty(item)) {
//            //    tradeStock = new GlobalTradeStock();
//            //    tradeStock.setId(ServiceProvider.readModuleID(TableID.TABLE_TRADE_STOCK));
//            //    tradeStock.setItemID((int) identity);
//            //    if(RandomUtil.nextBoolean()) {
//            //        tradeStock.setStartPrice(item.getGold() + RandomUtil.nextInt(item.getGold()));
//            //        tradeStock.setEndPrice(item.getGold() + RandomUtil.nextInt(item.getGold()));
//            //        tradeStock.setLastPrice(item.getGold() + RandomUtil.nextInt(item.getGold()));
//            //        tradeStock.setHighestPrice(item.getGold() + RandomUtil.nextInt(2000));
//            //        tradeStock.setLowestPrice(item.getGold() - RandomUtil.nextInt(item.getGold()) + 1);
//            //        if(tradeStock.getHighestPrice() < tradeStock.getLastPrice()){
//            //            tradeStock.setHighestPrice(tradeStock.getLastPrice());
//            //        }
//            //    }else {
//            //        tradeStock.setStartPrice(item.getGold() - RandomUtil.nextInt(item.getGold()) + 1);
//            //        tradeStock.setEndPrice(item.getGold() - RandomUtil.nextInt(item.getGold()) + 1);
//            //        tradeStock.setLastPrice(item.getGold() - RandomUtil.nextInt(item.getGold()) + 1);
//            //        tradeStock.setHighestPrice(item.getGold() + RandomUtil.nextInt(item.getGold()));
//            //        tradeStock.setLowestPrice(item.getGold() - RandomUtil.nextInt(item.getGold()) + 1);
//            //        if(tradeStock.getLowestPrice() > tradeStock.getLastPrice()){
//            //            tradeStock.setLowestPrice(tradeStock.getLastPrice());
//            //        }
//            //    }
//            //    long score = (long) Math.floor((tradeStock.getLastPrice() - tradeStock.getEndPrice() / (float) tradeStock.getEndPrice() * 100));
//            //    long score = (long) Math.floor((float)(tradeStock.getLastPrice() - tradeStock.getEndPrice())/tradeStock.getEndPrice() * 100);
//            //    tradeStock.setScore(score);
//            //    tradeStock.setCreateTime(DateUtil.getCurrentDate());
//            //    tradeStock.setUpdateTime(DateUtil.getCurrentDate());
//            //    globalTradeStockDao.cacheInsert(tradeStock, identity);
//            //}
//        }
//        // 将库存加入缓存
//        entityCache.addModelData(tradeStock, GlobalTradeStock.class);
//        // 将交易加入库存
//        List<GlobalTradeOrder> trades = globalTradeOrderDao.readDbData(identity);
//        if(trades != null && trades.size() > 0) {
//            entityCache.addModelData(trades, GlobalTradeOrder.class);
//        }
//        // 将历史记录加入缓存
//        List<GlobalTradeHistory> tradeHistorys = globalTradeHistoryDao.readDbData(identity);
//        if(tradeHistorys != null && tradeHistorys.size() > 0) {
//            entityCache.addModelData(tradeHistorys, GlobalTradeHistory.class);
//        }
//    }
//}
