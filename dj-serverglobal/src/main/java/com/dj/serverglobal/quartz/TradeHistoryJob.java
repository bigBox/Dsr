package com.dj.serverglobal.quartz;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.TableID;
import com.dj.domain.config.ConfigItems;
import com.dj.domain.config.ConfigTradeItems;
import com.dj.domain.entity.global.GlobalTradeHistory;
import com.dj.domain.entity.global.GlobalTradeHistoryImport;
import com.dj.domain.entity.global.GlobalTradeOrder;
import com.dj.domain.entity.global.GlobalTradeStock;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.domain.util.math.RandomUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.trade.TradeType;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.GlobalTradeHistoryDao;
import com.dj.serverapi.dao.GlobalTradeHistoryImportDao;
import com.dj.serverapi.dao.GlobalTradeOrderDao;
import com.dj.serverapi.dao.GlobalTradeStockDao;
import com.dj.servercore.conf.ConfigItemsConf;
import com.dj.servercore.conf.ConfigTradeItemsConf;
import com.dj.servercore.quartz.AbstractQuartzJob;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverglobal.manager.ConfManager;
import com.dj.serverglobal.manager.QuartzManager;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.quartz.JobExecutionContext;

import java.util.Date;

@Slf4j
public class TradeHistoryJob extends AbstractQuartzJob {

    public TradeHistoryJob() {
        setName(TradeHistoryJob.class.getSimpleName());
        setDescription("交易历史");
        setNeedCancelAfterWork(false);
        setRetryAfter3MinOnError(false);
    }

    @Override
    protected void run(JobExecutionContext jobContext) {
        // 将昨天价格赋值到今天里
        Date nowTime = DateUtil.getCurrentDate();
        String nowDate = DateUtil.getNowDate();
        String yesterdayDate = DateUtil.getYesterDate();
        String tomorrowDate = DateUtil.getTomorrowDate();
        log.info("TradeHistoryJob start {} ...", nowDate);

        GlobalTradeStockDao globalTradeStockDao = SpringContext.getBean(GlobalTradeStockDao.class);
        GlobalTradeOrderDao globalTradeOrderDao = SpringContext.getBean(GlobalTradeOrderDao.class);
        GlobalTradeHistoryDao globalTradeHistoryDao = SpringContext.getBean(GlobalTradeHistoryDao.class);
        GlobalTradeHistoryImportDao globalTradeHistoryImportDao = SpringContext.getBean(GlobalTradeHistoryImportDao.class);

        ConfigTradeItemsConf conf = ConfManager.getInstance().getConfigTradeItemsConf();
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigItemsConf itemsConf = ConfManager.getInstance().getConfigItemsConf();
        if(itemsConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ImmutableMap<Integer, ConfigTradeItems> tradeItemsMap = conf.getTradeItemsMap();
        for (ConfigTradeItems config : tradeItemsMap.values()) {
            QueryParamMap queryParams = new QueryParamMap();
            queryParams.put("itemID", config.getID());
            queryParams.put("date",nowDate);
            GlobalTradeHistory history = globalTradeHistoryDao.cacheSelect(queryParams, config.getID());
            if (history == null) {
                history = new GlobalTradeHistory();
                history.setId(ServiceProvider.readModuleID(TableID.TABLE_TRADE_STOCK_HISTORY));
                history.setItemID(config.getID());
                history.setDate(nowDate);

                GlobalTradeStock tradeStock = globalTradeStockDao.cacheLoad("itemID", config.getID(), GlobalRoleID.get());
                if((tradeStock!= null) && StringUtil.isNotEmpty(tradeStock.getImportID())){
                    queryParams.put("itemID", tradeStock.getImportID());
                    queryParams.put("date",nowDate);
                    //查当天的导入记录
                    GlobalTradeHistoryImport historyImport = globalTradeHistoryImportDao.cacheSelect(queryParams, config.getID());
                    if(historyImport != null) {
                        history.setStartPrice(historyImport.getStartPrice());
                        history.setEndPrice(historyImport.getEndPrice());
                        history.setHighestPrice(historyImport.getHighestPrice());
                        history.setLowestPrice(historyImport.getLowestPrice());
                        history.setTurnover(historyImport.getTurnover());
                    } else {
                        //查第二天日期的导入记录
                        queryParams.put("itemID", tradeStock.getImportID());
                        queryParams.put("date",tomorrowDate);
                        GlobalTradeHistoryImport tomorrowImport = globalTradeHistoryImportDao.cacheSelect(queryParams, config.getID());
                        if(tomorrowImport != null) {
                            history.setStartPrice(tomorrowImport.getStartPrice());
                            history.setEndPrice(tomorrowImport.getEndPrice());
                            history.setHighestPrice(tomorrowImport.getHighestPrice());
                            history.setLowestPrice(tomorrowImport.getLowestPrice());
                            history.setTurnover(tomorrowImport.getTurnover());
                        }else{
                            //查前一天日期的导入记录
                            queryParams.put("itemID", tradeStock.getImportID());
                            queryParams.put("date",yesterdayDate);
                            GlobalTradeHistoryImport yesterImport = globalTradeHistoryImportDao.cacheSelect(queryParams, config.getID());
                            if (yesterImport != null) {
                                history.setStartPrice(yesterImport.getStartPrice());
                                history.setEndPrice(yesterImport.getEndPrice());
                                history.setHighestPrice(yesterImport.getHighestPrice());
                                history.setLowestPrice(yesterImport.getLowestPrice());
                                history.setTurnover(yesterImport.getTurnover());
                            }else {
                                //查前一天日期的历史记录
                                queryParams.put("itemID", config.getID());
                                queryParams.put("date",yesterdayDate);
                                GlobalTradeHistory yesterHistory = globalTradeHistoryDao.cacheSelect(queryParams, config.getID());
                                if (yesterHistory != null) {
                                    history.setStartPrice(yesterHistory.getStartPrice());
                                    history.setEndPrice(yesterHistory.getEndPrice());
                                    history.setHighestPrice(yesterHistory.getHighestPrice());
                                    history.setLowestPrice(yesterHistory.getLowestPrice());
                                    history.setTurnover(yesterHistory.getTurnover());
                                }else {
                                    //随机生成记录
                                    ConfigItems item = itemsConf.getItem(config.getID());
                                    if (ObjectUtils.isNotEmpty(item)) {
                                        history.setStartPrice(item.getGold());
                                        history.setEndPrice(item.getGold() + RandomUtil.random(0, (int)(item.getGold()*0.1)));
                                        history.setHighestPrice(item.getGold() + RandomUtil.random(0, (int)(item.getGold()*0.1)));
                                        history.setLowestPrice(item.getGold() - RandomUtil.random(0, (int)(item.getGold()*0.1)));
                                        history.setTurnover( RandomUtil.random(0, 1000));
                                    }
                                }
                            }
                        }
                    }
                    history.setCreateTime(nowTime);
                    globalTradeHistoryDao.cacheInsert(history, config.getID());
                    //globalTradeOrderDao.cacheDelete(config.getID(), GlobalRoleID.get());
                    addTradeOrder(globalTradeOrderDao, config.getID(), tradeStock);
                }
            }
        }
        log.info("end {} ...", nowDate);
    }

    public void addTradeOrder(GlobalTradeOrderDao globalTradeOrderDao, int itemID, GlobalTradeStock stock) {
        // 买一、二、三
        //for(int i=1; i<=3; i++) {
            GlobalTradeOrder globalTradeOrderBuy = new GlobalTradeOrder();
            globalTradeOrderBuy.setRoleID(GlobalRoleID.get());
            globalTradeOrderBuy.setItemID(itemID);
            globalTradeOrderBuy.setItemNum(1);
            globalTradeOrderBuy.setOrderID(System.currentTimeMillis());
            globalTradeOrderBuy.setOrderNum(100);
            globalTradeOrderBuy.setPrice(stock.getLastPrice() - ((stock.getLastPrice() - stock.getLowestPrice())*RandomUtil.random(1, 99)/100) );
            globalTradeOrderBuy.setType(TradeType.Buy.getNumber());
            globalTradeOrderBuy.setAmount(globalTradeOrderBuy.getPrice());
            globalTradeOrderDao.cacheInsert(globalTradeOrderBuy, GlobalRoleID.get());
            //ServiceProvider.getTradeService().addTradeOrder(globalTradeOrderBuy);
        //}
        // 卖一、二、三
        //for(int i=1; i<=3; i++) {
            GlobalTradeOrder globalTradeOrderSell = new GlobalTradeOrder();
            globalTradeOrderSell.setRoleID(GlobalRoleID.get());
            globalTradeOrderSell.setItemID(itemID);
            globalTradeOrderSell.setItemNum(1);
            globalTradeOrderSell.setOrderID(System.currentTimeMillis());
            globalTradeOrderSell.setOrderNum(100);
            globalTradeOrderSell.setPrice(stock.getLastPrice() + ((stock.getHighestPrice() - stock.getLastPrice())*RandomUtil.random(1, 99)/100) );
            globalTradeOrderSell.setType(TradeType.Sell.getNumber());
            globalTradeOrderSell.setAmount(globalTradeOrderSell.getPrice());
            globalTradeOrderDao.cacheInsert(globalTradeOrderSell, GlobalRoleID.get());
            //ServiceProvider.getTradeService().addTradeOrder(globalTradeOrderSell);
        //}
    }

    public static void init() {
        QuartzManager.getInstance().addJob("maintain_trade_history", "group_job_maintain", TradeHistoryJob.class, "0 0 */1 * * ? *");
        //QuartzManager.getInstance().addJob("maintain_trade_history", "group_job_maintain", TradeHistoryJob.class, "0 0 1 * * ? *");
    }
}
