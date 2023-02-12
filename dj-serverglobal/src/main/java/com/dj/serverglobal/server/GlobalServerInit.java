package com.dj.serverglobal.server;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.TableID;
import com.dj.domain.config.ConfigItems;
import com.dj.domain.config.ConfigTradeItems;
import com.dj.domain.constant.ConstantRank;
import com.dj.domain.entity.global.*;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.math.RandomUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.trade.TradeType;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.*;
import com.dj.serverapi.dao.task.GuildTaskDao;
import com.dj.servercore.conf.ConfigItemsConf;
import com.dj.servercore.conf.ConfigTradeItemsConf;
import com.dj.servercore.db.cache.CacheManager;
import com.dj.serverglobal.manager.ConfManager;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zcq
 * @ClassName: GlobalServerInit
 * @Description: 全局服务器初始化， 加载商会，交易等全局性数据
 * @date 2019年6月25日
 */
@Component
public class GlobalServerInit {

    @Autowired
    @Qualifier("guildCacheManager")
    public CacheManager guildCacheManager;
    //@Autowired
    //@Qualifier("tradeCacheManager")
    //public CacheManager tradeCacheManager;
    @Autowired
    public PlayerRoleDao playerRoleDao;
    @Autowired
    public GlobalGuildDao globalGuildDao;
    @Autowired
    public GuildTaskDao         guildTaskDao;
    @Autowired
    public GlobalTradeOrderDao  globalTradeOrderDao;
    //@Autowired
    //public GlobalTradeRecordDao globalTradeRecordDao;
    @Autowired
    public GlobalTradeStockDao  globalTradeStockDao;
    @Autowired
    public GlobalTradeHistoryDao globalTradeHistoryDao;
    @Autowired
    public GlobalTradeHistoryImportDao globalTradeHistoryImportDao;

    public String[] tradeImport = {"000813","000905","000982","001858","600519"};


    public void init() {
        long globalRoleID = GlobalRoleID.getXiaoXun();
        // 商会缓存
        List<GlobalGuild> guilds = globalGuildDao.getAll(globalRoleID, AccessType.DIRECT_DB);
        if((guilds != null)&&(guilds.size() > 0)){
            guilds.forEach(value -> {
                // 初始化商会任务
                guildTaskDao.flushLevelTask(value.getChairman(), value.getId(), value.getLevel());
                // 激活商会缓存
                guildCacheManager.activateCache(value.getId());
                // 更新排行榜
                ServiceProvider.getRankService().updateGuildRank(value.getId(), value.getScore());
                ServiceProvider.getRankService().updateGuildLevelRank(value.getId(), value.getLevel());
                ServiceProvider.getRankService().updateGuildMemberRank(value.getId(), value.getCurMemberNums());
            });
        }else {
            //ServiceProvider.getRankService().rankContainerClear();
        }

        List<PlayerRole> roles = playerRoleDao.getAll(globalRoleID, AccessType.DIRECT_DB);
        // 玩家排行榜更新排行榜
        if((roles != null)&&(roles.size() > 0)) {
            roles.forEach(value -> {
                ServiceProvider.getRankService().setRankInfo(ConstantRank.LEVEL, value.getRoleID(), value.getLevel());
                ServiceProvider.getRankService().setRankInfo(ConstantRank.RENOWN_LEVEL, value.getRoleID(), value.getRenownLevel());
                ServiceProvider.getRankService().setRankInfo(ConstantRank.SHOWTABLE, value.getRoleID(), value.getShowTableLevel());
            });
        }
        // 交易缓存
        ConfigItemsConf itemsConf = ConfManager.getInstance().getConfigItemsConf();
        if(itemsConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        // 可交易的物品
        ConfigTradeItemsConf conf = ConfManager.getInstance().getConfigTradeItemsConf();
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ImmutableMap<Integer, ConfigTradeItems> tradeItemsMap = conf.getTradeItemsMap();
        Date nowTime = DateUtil.getCurrentDate();
        // 模拟走势图数据
        Date yearBeginDate = DateUtil.plusTime(nowTime, TimeUnit.DAYS, -365);
        for (ConfigTradeItems config : tradeItemsMap.values()) {
        	ConfigItems item = itemsConf.getItem(config.getID(), false);
        	if(ObjectUtils.isNotEmpty(item)) {
        		List<GlobalTradeHistory> tradeHistoryList = globalTradeHistoryDao.readDbData(config.getID());
        		if(tradeHistoryList == null || tradeHistoryList.size() == 0) {
                    int index = RandomUtil.nextInt(5);
                    String importID = tradeImport[index];
                    if(StringUtil.isNotEmpty(importID)){
                        List<GlobalTradeHistoryImport> tradeHistoryImportList = globalTradeHistoryImportDao.readDbData(importID);
                        if(CollectionUtils.isNotEmpty(tradeHistoryImportList)) {
                            Collections.sort(tradeHistoryImportList);
                            for (int i = 0; i < 365; i++) {
                                GlobalTradeHistoryImport historyImport = tradeHistoryImportList.get(i);
                                Date date = DateUtil.plusTime(yearBeginDate, TimeUnit.DAYS, i);
                                // 补充对应天数的历史纪录
                                GlobalTradeHistory tradeHistory = new GlobalTradeHistory();
                                tradeHistory.setId(ServiceProvider.readModuleID(TableID.TABLE_TRADE_STOCK_HISTORY));
                                tradeHistory.setItemID(config.getID());
                                tradeHistory.setDate(DateUtil.formatDate(date));
                                tradeHistory.setStartPrice(historyImport.getStartPrice());
                                tradeHistory.setEndPrice(historyImport.getEndPrice());
                                tradeHistory.setHighestPrice(historyImport.getHighestPrice());
                                tradeHistory.setLowestPrice(historyImport.getLowestPrice());
                                tradeHistory.setTurnover(historyImport.getTurnover());
                                tradeHistory.setCreateTime(nowTime);
                                tradeHistory.setUpdateTime(nowTime);
                                globalTradeHistoryDao.cacheInsert(tradeHistory, tradeHistory.getId());
                            }

                            GlobalTradeStock tradeStock = globalTradeStockDao.cacheLoad("itemID", config.getID(), GlobalRoleID.get());
                            if (tradeStock == null) {
                                GlobalTradeHistoryImport historyImport = tradeHistoryImportList.get(365);
                                tradeStock = new GlobalTradeStock();
                                tradeStock.setId(ServiceProvider.readModuleID(TableID.TABLE_TRADE_STOCK));
                                tradeStock.setItemID(config.getID());
                                tradeStock.setStartPrice(historyImport.getStartPrice());
                                tradeStock.setEndPrice(historyImport.getEndPrice());
                                tradeStock.setHighestPrice(historyImport.getHighestPrice());
                                tradeStock.setLowestPrice(historyImport.getLowestPrice());
                                tradeStock.setLastPrice(RandomUtil.random((int)tradeStock.getLowestPrice(), (int)tradeStock.getHighestPrice()));
                                long score = (long) Math.floor((float)(tradeStock.getLastPrice() - tradeStock.getEndPrice())/tradeStock.getEndPrice() * 100);
                                tradeStock.setScore(score);
                                tradeStock.setTurnover(historyImport.getTurnover());
                                tradeStock.setCreateTime(nowTime);
                                tradeStock.setUpdateTime(nowTime);
                                tradeStock.setImportID(importID);
                                globalTradeStockDao.cacheInsert(tradeStock, config.getID());
                                addTradeOrder(config.getID(), tradeStock);
                            }else {
                                tradeStock.setImportID(importID);
                                globalTradeStockDao.cacheUpdate(tradeStock, GlobalRoleID.get());
                            }
                        }
                    }
        		}
        		//tradeCacheManager.activateCache(config.getID());
        	}
        }
    }
    
    public void addTradeOrder(int itemID, GlobalTradeStock stock) {
        // 买一、二、三
        for(int i=1; i<=3; i++) {
            GlobalTradeOrder tradeOrderBuy = new GlobalTradeOrder();
            tradeOrderBuy.setRoleID(GlobalRoleID.get());
            tradeOrderBuy.setItemID(itemID);
            tradeOrderBuy.setItemNum(1);
            tradeOrderBuy.setOrderID(System.currentTimeMillis());
            tradeOrderBuy.setOrderNum(100);
            tradeOrderBuy.setPrice(stock.getLastPrice() - ((stock.getLastPrice() - stock.getLowestPrice())*RandomUtil.random(1, 99)/100) );
            tradeOrderBuy.setType(TradeType.Buy.getNumber());
            tradeOrderBuy.setAmount(tradeOrderBuy.getPrice());
            globalTradeOrderDao.cacheInsert(tradeOrderBuy, GlobalRoleID.get());
            //ServiceProvider.getTradeService().addTradeOrder(tradeOrderBuy);
        }
        // 卖一、二、三
        for(int i=1; i<=3; i++) {
            GlobalTradeOrder tradeOrderSell = new GlobalTradeOrder();
            tradeOrderSell.setRoleID(GlobalRoleID.get());
            tradeOrderSell.setItemID(itemID);
            tradeOrderSell.setItemNum(1);
            tradeOrderSell.setOrderID(System.currentTimeMillis());
            tradeOrderSell.setOrderNum(100);
            tradeOrderSell.setPrice(stock.getLastPrice() + ((stock.getHighestPrice() - stock.getLastPrice())*RandomUtil.random(1, 99)/100) );
            tradeOrderSell.setType(TradeType.Sell.getNumber());
            tradeOrderSell.setAmount(tradeOrderSell.getPrice());
            globalTradeOrderDao.cacheInsert(tradeOrderSell, GlobalRoleID.get());
            //ServiceProvider.getTradeService().addTradeOrder(tradeOrderSell);
        }
    }
}
