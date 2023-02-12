package com.dj.serverglobal.handler;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.TableID;
import com.dj.domain.constant.ConstantGame;
import com.dj.domain.entity.global.GlobalTradeHistory;
import com.dj.domain.entity.global.GlobalTradeOrder;
import com.dj.domain.entity.global.GlobalTradeRecord;
import com.dj.domain.entity.global.GlobalTradeStock;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.entity.player.item.PlayerItem;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.type.ItemType;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.trade.*;
import com.dj.serverapi.EventProvider;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.GlobalTradeHistoryDao;
import com.dj.serverapi.dao.GlobalTradeOrderDao;
import com.dj.serverapi.dao.GlobalTradeRecordDao;
import com.dj.serverapi.dao.GlobalTradeStockDao;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.item.*;
import com.dj.servercore.conf.ConfigItemsConf;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverglobal.manager.ChannelManager;
import com.dj.serverglobal.manager.ConfManager;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author zcq
 * @description 交易业务
 * @date 2019年4月29日
 */

@Slf4j
@Component
public class GlobalTradeHandler extends ServiceProvider {
    @Autowired
    public GlobalTradeOrderDao  globalTradeOrderDao;
    @Autowired
    public GlobalTradeRecordDao globalTradeRecordDao;
    @Autowired
    public GlobalTradeStockDao  globalTradeStockDao;
    @Autowired
    public GlobalTradeHistoryDao globalTradeHistoryDao;

    @Autowired
    public PlayerItem1Dao playerItem1Dao;
    @Autowired
    public PlayerItem2Dao playerItem2Dao;
    @Autowired
    public PlayerItem3Dao playerItem3Dao;
    @Autowired
    public PlayerItem4Dao playerItem4Dao;
    @Autowired
    public PlayerItem5Dao playerItem5Dao;
    @Autowired
    public PlayerItem6Dao playerItem6Dao;
    @Autowired
    public PlayerItem7Dao playerItem7Dao;
    @Autowired
    public PlayerItem100Dao playerItem100Dao;
    //@Autowired
    //@Qualifier("tradeCacheManager")
    //public CacheManager tradeCacheManager;

    /**
     *	交易挂单
     *
     * @param roleID
     * @param req
     */
    public void tradeEnqueue(long roleID, TradeEnqueueReq req) {
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        if (req.getType() == TradeType.Sell) {
            // 卖
            if(req.getItemID() == ConstantGame.DIAMOND){ // 钻石
                if (playerRole.getDiamond() < req.getItemNum()) {
                    throw new CommonException(ErrorIDOuterClass.ErrorID.COMMON_PLAYER_DIAMOND_LESS);
                }
            }else {
                //long itemCount = ServiceProvider.getItemService().getItemCount(roleID , req.getItemID());
                ConfigItemsConf conf = ConfManager.getInstance().getConfigItemsConf();
                if(conf == null){
                    throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
                }
                int itemType = conf.getItemType(req.getItemID());
                if (itemType == 0) {
                    throw new CommonException(ErrorIDOuterClass.ErrorID.COMMON_CONFIG_ERROR, "roleID:" + roleID + ", costItem:" + req.getItemID());
                }
                BaseCacheDao itemDao = getPlayerItemDao(itemType);
                QueryParamMap  queryParams = new QueryParamMap();
                queryParams.put("roleID",roleID);
                queryParams.put("itemID",req.getItemID());
                PlayerItem playerItem = (PlayerItem) itemDao.cacheSelect(queryParams, roleID);
                if (playerItem == null || playerItem.getItemCount() < req.getItemNum()) {
                    throw new CommonException(ErrorIDOuterClass.ErrorID.COMMON_PLAYER_ITEM_LESS, "roleID:" + roleID + ", costItem:" + req.getItemID() + ", changeCount:" + req.getItemNum());
                }
            }
        } else {
            // 买
            long gold = req.getItemNum() * req.getPrice();
            if (playerRole.getGold() < gold) {
                throw new CommonException(ErrorIDOuterClass.ErrorID.COMMON_PLAYER_GOLD_LESS);
            }
        }

        if (req.getType() == TradeType.Buy) {
            // 买
            long remainNum = req.getOrderNum();
            //Map<Long, GlobalTradeOrder> sellOrderMap = ServiceProvider.getTradeService().getAllTradeOrder(req.getItemID(), TradeType.Sell_VALUE);
            List<GlobalTradeOrder> sellOrderList = globalTradeOrderDao.readDbData(req.getItemID(), TradeType.Sell);
            if(sellOrderList != null){//卖，价格正序，取价格小的
                Collections.sort(sellOrderList);
                for(GlobalTradeOrder globalTradeOrder : sellOrderList){
                    if((remainNum > 0)&&(globalTradeOrder.getPrice() <= req.getPrice())){
                        long tradeNum = 0;
                        if((globalTradeOrder.getOrderNum()-globalTradeOrder.getTradeNum()) < remainNum){
                            tradeNum = globalTradeOrder.getOrderNum()-globalTradeOrder.getTradeNum();
                            GlobalTradeRecord tradeRecord = new GlobalTradeRecord();
                            tradeRecord.setBuyRoleID(roleID);
                            tradeRecord.setSellRoleID(globalTradeOrder.getRoleID());
                            tradeRecord.setItemID(globalTradeOrder.getItemID());
                            tradeRecord.setItemNum(globalTradeOrder.getItemNum());
                            tradeRecord.setOrderID(globalTradeOrder.getOrderID());
                            tradeRecord.setOrderNum(tradeNum);
                            tradeRecord.setPrice(globalTradeOrder.getPrice());
                            tradeRecord.setAmount(tradeNum*globalTradeOrder.getPrice());
                            globalTradeRecordDao.cacheInsert(tradeRecord, roleID);
                            globalTradeOrder.setTradeNum(globalTradeOrder.getOrderNum());
                            globalTradeOrder.setIsDelete(1);
                            globalTradeOrderDao.cacheUpdate(globalTradeOrder, roleID);
                            //ServiceProvider.getTradeService().delTradeOrder(globalTradeOrder);
                            remainNum = remainNum - tradeNum;
                        }
                        else if((globalTradeOrder.getOrderNum()-globalTradeOrder.getTradeNum()) == remainNum){
                            tradeNum = remainNum;
                            GlobalTradeRecord tradeRecord = new GlobalTradeRecord();
                            tradeRecord.setBuyRoleID(roleID);
                            tradeRecord.setSellRoleID(globalTradeOrder.getRoleID());
                            tradeRecord.setItemID(globalTradeOrder.getItemID());
                            tradeRecord.setItemNum(globalTradeOrder.getItemNum());
                            tradeRecord.setOrderID(globalTradeOrder.getOrderID());
                            tradeRecord.setOrderNum(tradeNum);
                            tradeRecord.setPrice(globalTradeOrder.getPrice());
                            tradeRecord.setAmount(tradeNum*globalTradeOrder.getPrice());
                            globalTradeRecordDao.cacheInsert(tradeRecord, roleID);
                            globalTradeOrder.setTradeNum(globalTradeOrder.getOrderNum());
                            globalTradeOrder.setIsDelete(1);
                            globalTradeOrderDao.cacheUpdate(globalTradeOrder, roleID);
                            //ServiceProvider.getTradeService().delTradeOrder(globalTradeOrder);
                            remainNum = 0;
                        }
                        else if((globalTradeOrder.getOrderNum()-globalTradeOrder.getTradeNum()) > remainNum){
                            tradeNum = remainNum;
                            GlobalTradeRecord tradeRecord = new GlobalTradeRecord();
                            tradeRecord.setBuyRoleID(roleID);
                            tradeRecord.setSellRoleID(globalTradeOrder.getRoleID());
                            tradeRecord.setItemID(globalTradeOrder.getItemID());
                            tradeRecord.setItemNum(globalTradeOrder.getItemNum());
                            tradeRecord.setOrderID(globalTradeOrder.getOrderID());
                            tradeRecord.setOrderNum(tradeNum);
                            tradeRecord.setPrice(globalTradeOrder.getPrice());
                            tradeRecord.setAmount(tradeNum*globalTradeOrder.getPrice());
                            globalTradeRecordDao.cacheInsert(tradeRecord, roleID);
                            globalTradeOrder.setTradeNum(globalTradeOrder.getTradeNum() + tradeNum);
                            globalTradeOrderDao.cacheUpdate(globalTradeOrder, roleID);
                            //ServiceProvider.getTradeService().addTradeOrder(globalTradeOrder);
                            remainNum = 0;
                        }
                        // 本人获得物品
                        if (req.getItemID() == ConstantGame.DIAMOND) { // 钻石
                            ServiceProvider.getCommonService().addAttrBill(roleID, PlayerAttrEnum.DIAMOND.getKey(), tradeNum, ResourceBillEnum.tradeUseBuyReward);
                        } else {
                            ServiceProvider.getItemService().addItemBill(roleID, req.getItemID(), tradeNum, ResourceBillEnum.tradeUseBuyReward, true, true);
                            EventProvider.postSyncItemEvent(roleID);
                        }
                        // 本人扣金币
                        ServiceProvider.getCommonService().addAttrBill(roleID, PlayerAttrEnum.GOLD.getKey(), -tradeNum * globalTradeOrder.getPrice() , ResourceBillEnum.tradeUseBuyCost);
                        EventProvider.postSyncAttrEvent(roleID);
                        // 他人获得金币
                        if(globalTradeOrder.getRoleID() != GlobalRoleID.get()) {
                            ServiceProvider.getCommonService().addAttrBill(globalTradeOrder.getRoleID(), PlayerAttrEnum.GOLD.getKey(), tradeNum * globalTradeOrder.getPrice(), ResourceBillEnum.tradeUseSellReward);
                            EventProvider.postSyncAttrEvent(globalTradeOrder.getRoleID());
                        }
                        // 更新成交价
                        GlobalTradeStock tradeStock = globalTradeStockDao.cacheLoad("itemID", req.getItemID(), roleID);
                        if (tradeStock != null) {
                            long score = 0;
                            if(tradeStock.getEndPrice() > 0) {
                                // 涨跌 = (交易价格-昨日收盘价格) / 昨日收盘价格 * 100 (百分比)
                                score = (long) Math.floor((globalTradeOrder.getPrice() - tradeStock.getEndPrice() / (float) tradeStock.getEndPrice() * 100));
                            }else {
                                if(tradeStock.getStartPrice() > 0) {
                                    // 涨跌 = (交易价格-最新价格) / 最新价格 * 100 (百分比)
                                    score = (long) Math.floor((globalTradeOrder.getPrice() - tradeStock.getStartPrice() / (float) tradeStock.getStartPrice() * 100));
                                }else{
                                    score = (long) Math.floor((globalTradeOrder.getPrice() - tradeStock.getLastPrice() / (float) tradeStock.getLastPrice() * 100));
                                }
                            }
                            tradeStock.setScore(score);
                            tradeStock.setTurnover(tradeStock.getTurnover() + tradeNum);
                            // 最新价格
                            tradeStock.setLastPrice(globalTradeOrder.getPrice());
                            // 最低价格
                            if (globalTradeOrder.getPrice() < tradeStock.getLowestPrice() || tradeStock.getLowestPrice() == 0) {
                                tradeStock.setLowestPrice(globalTradeOrder.getPrice());
                            }
                            // 最高价格
                            if (globalTradeOrder.getPrice() > tradeStock.getHighestPrice() || tradeStock.getHighestPrice() == 0) {
                                tradeStock.setHighestPrice(globalTradeOrder.getPrice());
                            }
                        }
                        globalTradeStockDao.cacheUpdate(tradeStock, roleID);

                        // 更新历史价 ， 每天最后一笔成交价
                        Date nowTime = DateUtil.getCurrentDate();
                        String date = DateUtil.getNowDate();
                        QueryParamMap queryParams1 = new QueryParamMap();
                        queryParams1.put("itemID", req.getItemID());
                        queryParams1.put("date", date);
                        GlobalTradeHistory tradeHistory = globalTradeHistoryDao.cacheSelect(queryParams1, roleID);
                        if (tradeHistory == null) {
                            tradeHistory = new GlobalTradeHistory();
                            tradeHistory.setId(ServiceProvider.readModuleID(TableID.TABLE_TRADE_STOCK_HISTORY));
                            tradeHistory.setItemID(req.getItemID());
                            tradeHistory.setDate(date);
                            tradeHistory.setStartPrice(globalTradeOrder.getPrice());
                            tradeHistory.setEndPrice(globalTradeOrder.getPrice());
                            tradeHistory.setHighestPrice(globalTradeOrder.getPrice());
                            tradeHistory.setLowestPrice(globalTradeOrder.getPrice());
                            tradeHistory.setTurnover(tradeNum);
                            tradeHistory.setCreateTime(nowTime);
                            globalTradeHistoryDao.cacheInsert(tradeHistory, req.getItemID());
                        } else {
                            if (tradeHistory.getUpdateTime() == null) {
                                tradeHistory.setStartPrice(globalTradeOrder.getPrice());
                            }
                            tradeHistory.setEndPrice(globalTradeOrder.getPrice());
                            if (tradeHistory.getHighestPrice() < globalTradeOrder.getPrice()) {
                                tradeHistory.setHighestPrice(globalTradeOrder.getPrice());
                            }
                            if (tradeHistory.getLowestPrice() > globalTradeOrder.getPrice()) {
                                tradeHistory.setLowestPrice(globalTradeOrder.getPrice());
                            }
                            tradeHistory.setTurnover(tradeHistory.getTurnover() + tradeNum);
                            tradeHistory.setUpdateTime(nowTime);
                            globalTradeHistoryDao.cacheUpdate(tradeHistory, req.getItemID());
                        }

                        // 即时入db，方便查个人订单
                        //SpringContext.getBean("tradeCacheManager", CacheManager.class).flushSyncAllData(req.getItemID(), false);
                        // 提交交易的双方玩家事件
                        EventProvider.commitRoleEvent(roleID);
                        if(globalTradeOrder.getRoleID() != GlobalRoleID.get()) {
                            EventProvider.commitRoleEvent(globalTradeOrder.getRoleID());
                        }
                        // 交易推送
                        if (tradeService.getTradeRoleIds().size() > 0) {
                            TradeUseNtf.Builder tradeUseNtf = TradeUseNtf.newBuilder();
                            HistoryInfo.Builder historyInfo = HistoryInfo.newBuilder();
                            historyInfo.setDate(tradeHistory.getDate());
                            historyInfo.setStartPrice(tradeHistory.getStartPrice());
                            historyInfo.setEndPrice(tradeHistory.getEndPrice());
                            historyInfo.setHighestPrice(tradeHistory.getHighestPrice());
                            historyInfo.setLowestPrice(tradeHistory.getLowestPrice());
                            historyInfo.setTurnover(tradeHistory.getTurnover());
                            // 1号的月份，非1号的为0
                            String[] arr = tradeHistory.getDate().split("-");
                            if (Integer.parseInt(arr[2]) == 1) {
                                historyInfo.setMonth(Integer.parseInt(arr[1]));
                            } else {
                                historyInfo.setMonth(0);
                            }
                            tradeUseNtf.setItemID(tradeHistory.getItemID());
                            tradeUseNtf.setInfo(historyInfo.build());
                            TradeUseNtf ntf = tradeUseNtf.build();
                            Iterator<Long> it = tradeService.getTradeRoleIds().iterator();
                            while (it.hasNext()) {
                                PlayerRole playerRoleNext = ServiceProvider.getPlayerService().getPlayer(it.next());
                                if (playerRoleNext.isOnline()) {
                                    ChannelManager.getInstance().sendGlobalRankToGate(playerRole.getGateServerID(), playerRole.getRoleID(), ntf);
                                } else {
                                    it.remove();
                                }
                            }
                        }
                    }
                }
            }
            if(remainNum > 0){
                GlobalTradeOrder tradeOrder = new GlobalTradeOrder();
                tradeOrder.setRoleID(roleID);
                tradeOrder.setItemID(req.getItemID());
                tradeOrder.setItemNum(req.getItemNum());
                tradeOrder.setOrderID(System.currentTimeMillis());
                tradeOrder.setOrderNum(remainNum);
                tradeOrder.setPrice(req.getPrice());
                tradeOrder.setType(req.getType().getNumber());
                tradeOrder.setAmount(remainNum * req.getPrice());
                globalTradeOrderDao.cacheInsert(tradeOrder, roleID);
                //ServiceProvider.getTradeService().addTradeOrder(tradeOrder);
            }
        }else {
            //卖
            long remainNum = req.getOrderNum();
            //Map<Long, GlobalTradeOrder> buyOrderMap = ServiceProvider.getTradeService().getAllTradeOrder(req.getItemID(), TradeType.Buy_VALUE);
            List<GlobalTradeOrder> buyOrderList = globalTradeOrderDao.readDbData(req.getItemID(), TradeType.Buy);
            if(buyOrderList != null) {
                Collections.sort(buyOrderList);
                for (GlobalTradeOrder globalTradeOrder : buyOrderList) {
                    if ((remainNum > 0) && (globalTradeOrder.getPrice() >= req.getPrice())) {
                        long tradeNum = 0;
                        if ((globalTradeOrder.getOrderNum() - globalTradeOrder.getTradeNum()) < remainNum) {
                            tradeNum = globalTradeOrder.getOrderNum() - globalTradeOrder.getTradeNum();
                            GlobalTradeRecord tradeRecord = new GlobalTradeRecord();
                            tradeRecord.setBuyRoleID(globalTradeOrder.getRoleID());
                            tradeRecord.setSellRoleID(roleID);
                            tradeRecord.setItemID(globalTradeOrder.getItemID());
                            tradeRecord.setItemNum(globalTradeOrder.getItemNum());
                            tradeRecord.setOrderID(globalTradeOrder.getOrderID());
                            tradeRecord.setOrderNum(tradeNum);
                            tradeRecord.setPrice(globalTradeOrder.getPrice());
                            tradeRecord.setAmount(tradeNum * globalTradeOrder.getPrice());
                            globalTradeRecordDao.cacheInsert(tradeRecord, roleID);
                            globalTradeOrder.setTradeNum(globalTradeOrder.getOrderNum());
                            globalTradeOrder.setIsDelete(1);
                            globalTradeOrderDao.cacheUpdate(globalTradeOrder, roleID);
                            //ServiceProvider.getTradeService().delTradeOrder(globalTradeOrder);
                            remainNum = remainNum - tradeNum;
                        } else if ((globalTradeOrder.getOrderNum() - globalTradeOrder.getTradeNum()) == remainNum) {
                            tradeNum = remainNum;
                            GlobalTradeRecord tradeRecord = new GlobalTradeRecord();
                            tradeRecord.setBuyRoleID(globalTradeOrder.getRoleID());
                            tradeRecord.setSellRoleID(roleID);
                            tradeRecord.setItemID(globalTradeOrder.getItemID());
                            tradeRecord.setItemNum(globalTradeOrder.getItemNum());
                            tradeRecord.setOrderID(globalTradeOrder.getOrderID());
                            tradeRecord.setOrderNum(tradeNum);
                            tradeRecord.setPrice(globalTradeOrder.getPrice());
                            tradeRecord.setAmount(tradeNum * globalTradeOrder.getPrice());
                            globalTradeRecordDao.cacheInsert(tradeRecord, roleID);
                            globalTradeOrder.setTradeNum(globalTradeOrder.getOrderNum());
                            globalTradeOrder.setIsDelete(1);
                            globalTradeOrderDao.cacheUpdate(globalTradeOrder, roleID);
                            //ServiceProvider.getTradeService().delTradeOrder(globalTradeOrder);
                            remainNum = 0;
                        } else if ((globalTradeOrder.getOrderNum() - globalTradeOrder.getTradeNum()) > remainNum) {
                            tradeNum = remainNum;
                            GlobalTradeRecord tradeRecord = new GlobalTradeRecord();
                            tradeRecord.setBuyRoleID(globalTradeOrder.getRoleID());
                            tradeRecord.setSellRoleID(roleID);
                            tradeRecord.setItemID(globalTradeOrder.getItemID());
                            tradeRecord.setItemNum(globalTradeOrder.getItemNum());
                            tradeRecord.setOrderID(globalTradeOrder.getOrderID());
                            tradeRecord.setOrderNum(tradeNum);
                            tradeRecord.setPrice(globalTradeOrder.getPrice());
                            tradeRecord.setAmount(tradeNum * globalTradeOrder.getPrice());
                            globalTradeRecordDao.cacheInsert(tradeRecord, roleID);
                            globalTradeOrder.setTradeNum(globalTradeOrder.getTradeNum() + tradeNum);
                            globalTradeOrderDao.cacheUpdate(globalTradeOrder, roleID);
                            //ServiceProvider.getTradeService().addTradeOrder(globalTradeOrder);
                            remainNum = 0;
                        }
                        // 本人扣掉物品
                        if (req.getItemID() == ConstantGame.DIAMOND) { // 钻石
                            ServiceProvider.getCommonService().addAttrBill(roleID, PlayerAttrEnum.DIAMOND.getKey(), -tradeNum, ResourceBillEnum.tradeUseSellCost);
                        } else {
                            ServiceProvider.getItemService().addItemBill(roleID, req.getItemID(), -tradeNum, ResourceBillEnum.tradeUseSellCost, true, true);
                            EventProvider.postSyncItemEvent(roleID);
                        }
                        // 本人获得金币
                        ServiceProvider.getCommonService().addAttrBill(roleID, PlayerAttrEnum.GOLD.getKey(), tradeNum * globalTradeOrder.getPrice(), ResourceBillEnum.tradeUseSellReward);
                        EventProvider.postSyncAttrEvent(roleID);
                        // 他人获得物品
                        if(globalTradeOrder.getRoleID() != GlobalRoleID.get()) {
                            if (req.getItemID() == ConstantGame.DIAMOND) { // 钻石
                                ServiceProvider.getCommonService().addAttrBill(globalTradeOrder.getRoleID(), PlayerAttrEnum.DIAMOND.getKey(), tradeNum, ResourceBillEnum.tradeUseBuyReward);
                            } else {
                                ServiceProvider.getItemService().addItemBill(globalTradeOrder.getRoleID(), req.getItemID(), tradeNum, ResourceBillEnum.tradeUseBuyReward, true, true);
                                EventProvider.postSyncItemEvent(globalTradeOrder.getRoleID());
                            }
                            // 他人扣掉金币
                            ServiceProvider.getCommonService().addAttrBill(globalTradeOrder.getRoleID(), PlayerAttrEnum.GOLD.getKey(), -tradeNum * globalTradeOrder.getPrice(), ResourceBillEnum.tradeUseBuyCost);
                            EventProvider.postSyncAttrEvent(globalTradeOrder.getRoleID());
                        }
                        // 更新成交价
                        GlobalTradeStock tradeStock = globalTradeStockDao.cacheLoad("itemID", req.getItemID(), roleID);
                        if (tradeStock != null) {
                            long score = 0;
                            if(tradeStock.getEndPrice() > 0) {
                                // 涨跌 = (交易价格-最新价格) / 最新价格 * 100 (百分比)
                                score = (long) Math.floor((globalTradeOrder.getPrice() - tradeStock.getEndPrice() / (float) tradeStock.getEndPrice() * 100));
                            }else {
                                if(tradeStock.getStartPrice() > 0) {
                                    // 涨跌 = (交易价格-最新价格) / 最新价格 * 100 (百分比)
                                    score = (long) Math.floor((globalTradeOrder.getPrice() - tradeStock.getStartPrice() / (float) tradeStock.getStartPrice() * 100));
                                }else{
                                    score = (long) Math.floor((globalTradeOrder.getPrice() - tradeStock.getLastPrice() / (float) tradeStock.getLastPrice() * 100));
                                }
                            }
                            tradeStock.setScore(score);
                            tradeStock.setTurnover(tradeStock.getTurnover() + tradeNum);
                            // 最新价格
                            tradeStock.setLastPrice(globalTradeOrder.getPrice());
                            // 最低价格
                            if (globalTradeOrder.getPrice() < tradeStock.getLowestPrice() || tradeStock.getLowestPrice() == 0) {
                                tradeStock.setLowestPrice(globalTradeOrder.getPrice());
                            }
                            // 最高价格
                            if (globalTradeOrder.getPrice() > tradeStock.getHighestPrice() || tradeStock.getHighestPrice() == 0) {
                                tradeStock.setHighestPrice(globalTradeOrder.getPrice());
                            }
                        }
                        globalTradeStockDao.cacheUpdate(tradeStock, roleID);

                        // 更新历史价 ， 每天最后一笔成交价
                        Date nowTime = DateUtil.getCurrentDate();
                        String date = DateUtil.getNowDate();
                        QueryParamMap queryParams1 = new QueryParamMap();
                        queryParams1.put("itemID", req.getItemID());
                        queryParams1.put("date", date);
                        GlobalTradeHistory tradeHistory = globalTradeHistoryDao.cacheSelect(queryParams1, roleID);
                        if (tradeHistory == null) {
                            tradeHistory = new GlobalTradeHistory();
                            tradeHistory.setId(ServiceProvider.readModuleID(TableID.TABLE_TRADE_STOCK_HISTORY));
                            tradeHistory.setItemID(req.getItemID());
                            tradeHistory.setDate(date);
                            tradeHistory.setStartPrice(globalTradeOrder.getPrice());
                            tradeHistory.setEndPrice(globalTradeOrder.getPrice());
                            tradeHistory.setHighestPrice(globalTradeOrder.getPrice());
                            tradeHistory.setLowestPrice(globalTradeOrder.getPrice());
                            tradeHistory.setTurnover(tradeNum);
                            tradeHistory.setCreateTime(nowTime);
                            globalTradeHistoryDao.cacheInsert(tradeHistory, req.getItemID());
                        } else {
                            if (tradeHistory.getUpdateTime() == null) {
                                tradeHistory.setStartPrice(globalTradeOrder.getPrice());
                            }
                            tradeHistory.setEndPrice(globalTradeOrder.getPrice());
                            if (tradeHistory.getHighestPrice() < globalTradeOrder.getPrice()) {
                                tradeHistory.setHighestPrice(globalTradeOrder.getPrice());
                            }
                            if (tradeHistory.getLowestPrice() > globalTradeOrder.getPrice()) {
                                tradeHistory.setLowestPrice(globalTradeOrder.getPrice());
                            }
                            tradeHistory.setTurnover(tradeHistory.getTurnover() + tradeNum);
                            tradeHistory.setUpdateTime(nowTime);
                            globalTradeHistoryDao.cacheUpdate(tradeHistory, req.getItemID());
                        }

                        // 即时入db，方便查个人订单
                        //SpringContext.getBean("tradeCacheManager", CacheManager.class).flushSyncAllData(req.getItemID(), false);
                        // 提交交易的双方玩家事件
                        EventProvider.commitRoleEvent(roleID);
                        if(globalTradeOrder.getRoleID() != GlobalRoleID.get()) {
                            EventProvider.commitRoleEvent(globalTradeOrder.getRoleID());
                        }
                        // 交易推送
                        if (tradeService.getTradeRoleIds().size() > 0) {
                            TradeUseNtf.Builder tradeUseNtf = TradeUseNtf.newBuilder();
                            HistoryInfo.Builder historyInfo = HistoryInfo.newBuilder();
                            historyInfo.setDate(tradeHistory.getDate());
                            historyInfo.setStartPrice(tradeHistory.getStartPrice());
                            historyInfo.setEndPrice(tradeHistory.getEndPrice());
                            historyInfo.setHighestPrice(tradeHistory.getHighestPrice());
                            historyInfo.setLowestPrice(tradeHistory.getLowestPrice());
                            historyInfo.setTurnover(tradeHistory.getTurnover());
                            // 1号的月份，非1号的为0
                            String[] arr = tradeHistory.getDate().split("-");
                            if (Integer.parseInt(arr[2]) == 1) {
                                historyInfo.setMonth(Integer.parseInt(arr[1]));
                            } else {
                                historyInfo.setMonth(0);
                            }
                            tradeUseNtf.setItemID(tradeHistory.getItemID());
                            tradeUseNtf.setInfo(historyInfo.build());
                            TradeUseNtf ntf = tradeUseNtf.build();
                            Iterator<Long> it = tradeService.getTradeRoleIds().iterator();
                            while (it.hasNext()) {
                                PlayerRole playerRoleNext = ServiceProvider.getPlayerService().getPlayer(it.next());
                                if (playerRoleNext.isOnline()) {
                                    ChannelManager.getInstance().sendGlobalRankToGate(playerRole.getGateServerID(), playerRole.getRoleID(), ntf);
                                } else {
                                    it.remove();
                                }
                            }
                        }
                    }
                }
            }
            if (remainNum > 0) {
                GlobalTradeOrder tradeOrder = new GlobalTradeOrder();
                tradeOrder.setRoleID(roleID);
                tradeOrder.setItemID(req.getItemID());
                tradeOrder.setItemNum(req.getItemNum());
                tradeOrder.setOrderID(System.currentTimeMillis());
                tradeOrder.setOrderNum(remainNum);
                tradeOrder.setPrice(req.getPrice());
                tradeOrder.setType(req.getType().getNumber());
                tradeOrder.setAmount(remainNum * req.getPrice());
                globalTradeOrderDao.cacheInsert(tradeOrder, roleID);
                //ServiceProvider.getTradeService().addTradeOrder(tradeOrder);
                // 本人扣掉物品
                if (req.getItemID() == ConstantGame.DIAMOND) { // 钻石
                    ServiceProvider.getCommonService().addAttrBill(roleID, PlayerAttrEnum.DIAMOND.getKey(), -remainNum, ResourceBillEnum.tradeUseSellCost);
                } else {
                    ServiceProvider.getItemService().addItemBill(roleID, req.getItemID(), -remainNum, ResourceBillEnum.tradeUseSellCost, true, true);
                    EventProvider.postSyncItemEvent(roleID);
                }
            }
        }
        EventProvider.postTaskActionEvent(roleID, TaskActionEnum.TRADE, 1);
        EventProvider.commitRoleEvent(roleID);
    }

    public void tradeDequeue(long roleID, TradeDequeueReq req) {
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("orderID", req.getOrderID());
        queryParams.put("roleID", roleID);
        GlobalTradeOrder tradeOrder = globalTradeOrderDao.cacheSelect(queryParams, req.getOrderID());
        if(tradeOrder == null){
            return;
        }
        if (req.getType() == TradeType.Sell) {
            // 卸下挂卖的订单，返回剩下的物品
            ServiceProvider.getItemService().addItemBill(roleID, tradeOrder.getItemID(), tradeOrder.getItemNum() - tradeOrder.getTradeNum(), ResourceBillEnum.tradeDequeueSale, true, true);
        } else {
            // 卸下挂买的订单，返回剩下的金币
            ServiceProvider.getCommonService().addAttrBill(roleID, PlayerAttrEnum.GOLD.getKey(), (tradeOrder.getItemNum() - tradeOrder.getTradeNum()) * tradeOrder.getPrice(), ResourceBillEnum.tradeDequeuePurchase);
        }
        EventProvider.postSyncItemEvent(roleID);
        EventProvider.commitRoleEvent(roleID);
        globalTradeOrderDao.cacheDelete("id", tradeOrder.getId());
        //ServiceProvider.getTradeService().delTradeOrder(tradeOrder);
        // 即时入db，方便查个人订单
        //tradeCacheManager.flushSyncAllData(req.getOrderID(), false);
    }

    public Map<Integer, StockInfo> stockList(long roleID, List<Integer> itemIds) {
        tradeService.addTradeRoleId(roleID);
        Map<Integer, StockInfo> stocks = Maps.newHashMap();
        StockInfo.Builder stockInfo = StockInfo.newBuilder();
        for (Integer itemId : itemIds) {
            stockInfo.setItemID(itemId);
            // 最新价格
            GlobalTradeStock tradeStock = globalTradeStockDao.cacheLoad("itemID", itemId, roleID);
            if(tradeStock != null) {
                stockInfo.setLastPrice(tradeStock.getLastPrice());
                stockInfo.setHighestPrice(tradeStock.getHighestPrice());
                stockInfo.setLowestPrice(tradeStock.getLowestPrice());
                stockInfo.setScore(tradeStock.getScore());
                stockInfo.setTurnover(tradeStock.getTurnover());
                stocks.put(itemId, stockInfo.build());
            }
        }
        return stocks;
    }

    public List<TradeOrderInfo> tradeTopN(long roleID, int orderID, TradeType type) {
    	List<GlobalTradeOrder> trades = null;
    	if(type == TradeType.All) {
    		trades = Lists.newArrayListWithExpectedSize(ConfigSundryConf.tradeTop*2);
    		List<GlobalTradeOrder> tmpList = getTradeTopN(roleID, orderID, TradeType.Sell, ConfigSundryConf.tradeTop);
    		if (tmpList != null && tmpList.size() > 0) {
    			trades.addAll(tmpList);
    		}
    		tmpList = getTradeTopN(roleID, orderID, TradeType.Buy, ConfigSundryConf.tradeTop);
    		if (tmpList != null && tmpList.size() > 0) {
    			trades.addAll(tmpList);
    		}
    	}else {
    		trades = getTradeTopN(roleID, orderID, type, ConfigSundryConf.tradeTop);
    	}

        if (trades != null && trades.size() > 0) {
            List<TradeOrderInfo> info = Lists.newArrayListWithExpectedSize(trades.size());
            TradeOrderInfo.Builder builder = TradeOrderInfo.newBuilder();
            trades.forEach(value->{
                info.add(value.toTradeOrderInfo(builder));
            });
            return info;
        }
        return null;
    }

    /**
     *	获取交易top排行
     *
     * @param itemId
     * @param type
     * @param top
     * @return
     */
    public List<GlobalTradeOrder> getTradeTopN(long roleID, int itemId, TradeType type, int top) {
        List<GlobalTradeOrder> tradeOrderList = globalTradeOrderDao.readDbData(itemId, type);
        if (tradeOrderList == null || tradeOrderList.size() == 0) {
            return null;
        }
        if (type == TradeType.Sell) {//卖，价格正序，取价格小的
            Collections.sort(tradeOrderList);
        } else if(type == TradeType.Buy) {//买，价格倒序，取价格大的
            Collections.sort(tradeOrderList);
        }
        List<GlobalTradeOrder> list = Lists.newArrayListWithExpectedSize(top);
        for (GlobalTradeOrder trade : tradeOrderList) {
            //if (type.getNumber() == trade.getType()) {
            boolean add = true;
            for(GlobalTradeOrder trade1 : list) {
                if (trade1.getPrice() == trade.getPrice()) {
                    add = false;
                    break;
                }
            }
            if(add) {
                list.add(trade);
                if (list.size() >= top) {
                    break;
                }
            }
            //}
        }
        return list;
    }

    public List<TradeOrderInfo> tradeRole(long roleID, TradeRoleReq req) {
        List<GlobalTradeOrder> trades = globalTradeOrderDao.getRoleTradeOrder(roleID, req.getType());
        if (trades != null && trades.size() > 0) {
            Collections.sort(trades);
            List<TradeOrderInfo> info = Lists.newArrayListWithExpectedSize(trades.size());
            TradeOrderInfo.Builder builder = TradeOrderInfo.newBuilder();
            trades.forEach(value->{
                info.add(value.toTradeOrderInfo(builder));
            });
            return info;
        }
        return null;
    }

    public void tradeHistory(long roleID, int itemId, TradeHistoryRsp.Builder builder) {
        GlobalTradeStock tradeStock = globalTradeStockDao.cacheLoad("itemID", itemId, roleID);
        builder.setLastPrice(tradeStock.getLastPrice());
        builder.setLowestPrice(tradeStock.getLowestPrice());
        builder.setHighestPrice(tradeStock.getHighestPrice());
        // 历史价格
        List<GlobalTradeHistory> tradeHistoryList = globalTradeHistoryDao.cacheLoadAll("itemID", itemId, roleID);
        if (tradeHistoryList != null && tradeHistoryList.size() > 0) {
            Collections.sort(tradeHistoryList);
            List<HistoryInfo> historyPrices = Lists.newArrayListWithExpectedSize(tradeHistoryList.size());
            HistoryInfo.Builder historyInfo = HistoryInfo.newBuilder();
            for (GlobalTradeHistory history : tradeHistoryList) {
                historyInfo.setDate(history.getDate());
                historyInfo.setStartPrice(history.getStartPrice());
                historyInfo.setEndPrice(history.getEndPrice());
                historyInfo.setHighestPrice(history.getHighestPrice());
                historyInfo.setLowestPrice(history.getLowestPrice());
                historyInfo.setTurnover(history.getTurnover());
                // 1号的月份，非1号的为0
                String[] arr = history.getDate().split("-");
                if (Integer.parseInt(arr[2]) == 1) {
                    historyInfo.setMonth(Integer.parseInt(arr[1]));
                } else {
                    historyInfo.setMonth(0);
                }
                historyPrices.add(historyInfo.build());
            }
            builder.addAllHistoryPrices(historyPrices);
        }
        return;
    }

	public void tradeClose(long roleID) {
        tradeService.removeTradeRoleId(roleID);
	}

    public BaseCacheDao getPlayerItemDao(int itemType) {
        BaseCacheDao itemDao = null;
        switch (itemType) {
            case ItemType.type1:
                itemDao = SpringContext.getBean(PlayerItem1Dao.class);
                break;
            case ItemType.type2:
                itemDao = SpringContext.getBean(PlayerItem2Dao.class);
                break;
            case ItemType.type3:
                itemDao = SpringContext.getBean(PlayerItem3Dao.class);
                break;
            case ItemType.type4:
                itemDao = SpringContext.getBean(PlayerItem4Dao.class);
                break;
            case ItemType.type5:
                itemDao = SpringContext.getBean(PlayerItem5Dao.class);
                break;
            case ItemType.type6:
                itemDao = SpringContext.getBean(PlayerItem6Dao.class);
                break;
            case ItemType.type7:
                itemDao = SpringContext.getBean(PlayerItem7Dao.class);
                break;
            case ItemType.type100:
            default:
                itemDao = SpringContext.getBean(PlayerItem100Dao.class);
                break;
        }
        return itemDao;
    }

}