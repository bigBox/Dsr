package com.dj.serverglobal.manager;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.config.ConfigGuildLevel;
import com.dj.domain.entity.global.GlobalGuild;
import com.dj.domain.entity.global.GlobalGuildMember;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.entity.player.task.GuildTask;
import com.dj.domain.enums.GuildAttrEnum;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.enums.TaskState;
import com.dj.domain.topic.*;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.ThreadUtil;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.guild.ChangeGuildNameNtf;
import com.dj.protobuf.guild.CreateGuildRsp;
import com.dj.protobuf.guild.EGuildPost;
import com.dj.protobuf.guild.GuildAttrClientNtf;
import com.dj.protobuf.guildBattle.GuildBattleMatchSucessNtf;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.GlobalGuildDao;
import com.dj.serverapi.dao.GlobalGuildMemberDao;
import com.dj.serverapi.dao.PlayerRoleDao;
import com.dj.serverapi.dao.task.GuildTaskDao;
import com.dj.serverapi.helper.MessageHelper;
import com.dj.serverapi.topic.TopicManager;
import com.dj.servercore.conf.ConfigGuildLevelConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.servercore.db.cache.CacheManager;
import com.dj.servercore.event.AbsEventManager;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverglobal.worker.GuildBattleGameWorker;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

/**
 * @author zcq
 * @ClassName: DataManager
 * @Description: 跨项目处理事件，作为redis的topic主题监听后续业务逻辑
 * @date 2019年6月25日
 */
@Slf4j
public enum DataManager {
    INSTANCE;

    /**
     * 创建商会
     *
     * @param event
     */
    public void guildCreate(GuildCreateEvent event) {
        // 创建商会基本信息
        try {
            log.info("guildCreate event={}", event.getTopic());
            QueryParamMap queryParams = new QueryParamMap();
            queryParams.put("chairman", event.getRoleID());
            queryParams.put("name", event.getName());
            GlobalGuild guild = SpringContext.getBean(GlobalGuildDao.class).cacheSelect(queryParams, event.getRoleID());
            if (guild != null) {
                log.info("guild == %s", guild);
                // 同步玩家
                CreateGuildRsp.Builder builder = CreateGuildRsp.newBuilder();
                builder.setErrorID(ErrorID.GUILD_NAME_HAS_EXIT);
                PlayerRole playerRole = ServiceProvider.getPlayerService().setRoleGuild(event.getRoleID(), guild.getId());
                ChannelManager.getInstance().sendGlobalGuildToGate(playerRole.getGateServerID(), event.getRoleID(), builder.build());
                return;
            }
            QueryParamMap queryParams1 = new QueryParamMap();
            queryParams1.put("roleID", event.getRoleID());
            GlobalGuildMember guildMember = SpringContext.getBean(GlobalGuildMemberDao.class).cacheSelect(queryParams1, event.getRoleID());
            if (guildMember != null) {
                log.info("guildMember == %s", guildMember);
                // 同步玩家
                CreateGuildRsp.Builder builder = CreateGuildRsp.newBuilder();
                builder.setErrorID(ErrorID.GUILD_HAS_JOIN);
                PlayerRole playerRole = ServiceProvider.getPlayerService().setRoleGuild(event.getRoleID(), guildMember.getGuildID());
                ChannelManager.getInstance().sendGlobalGuildToGate(playerRole.getGateServerID(), event.getRoleID(), builder.build());
                return;
            }
            GlobalGuild globalGuild = new GlobalGuild(event.getRoleID());
            globalGuild.setName(event.getName());
            globalGuild.setSummary("商会说明");
            globalGuild.setInnerSummary("商会内部说明");
            //globalGuild.setAutoApproval(event.getAutoApproval());
            globalGuild.setAutoApproval(1);
            SpringContext.getBean(GlobalGuildDao.class).cacheInsert(globalGuild, event.getRoleID());
            QueryParamMap queryParams2 = new QueryParamMap();
            queryParams2.put("chairman", event.getRoleID());
            guild = SpringContext.getBean(GlobalGuildDao.class).cacheSelect(queryParams2, event.getRoleID());
            if (guild == null || guild.getId() == 0) {
                // 同步玩家
                CreateGuildRsp.Builder builder = CreateGuildRsp.newBuilder();
                builder.setErrorID(ErrorID.GUILD_NOT_EXIT);
                PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(event.getRoleID());
                ChannelManager.getInstance().sendGlobalGuildToGate(playerRole.getGateServerID(), event.getRoleID(), builder.build());
                return;
            } else {
                // 更新guild到redis
                ServiceProvider.getGuildService().setGuild(guild);
            }
            // 创建会长
            GlobalGuildMember member = new GlobalGuildMember(event.getRoleID());
            member.setGuildID(guild.getId());
            member.setPost(EGuildPost.GuildPostChairMan_VALUE);
            SpringContext.getBean(GlobalGuildMemberDao.class).cacheInsert(member, guild.getId());
            QueryParamMap queryParams3 = new QueryParamMap();
            queryParams3.put("roleID", event.getRoleID());
            queryParams3.put("guildID", guild.getId());
            guildMember = SpringContext.getBean(GlobalGuildMemberDao.class).cacheSelect(queryParams3, event.getRoleID());
            if (guildMember == null || guildMember.getId() == 0) {
                // 同步玩家
                CreateGuildRsp.Builder builder = CreateGuildRsp.newBuilder();
                builder.setErrorID(ErrorID.SYSTEM_MYSQL_ERROR);
                PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(event.getRoleID());
                ChannelManager.getInstance().sendGlobalGuildToGate(playerRole.getGateServerID(), event.getRoleID(), builder.build());
                return;
            }
            // 更新排行榜
            ServiceProvider.getRankService().updateGuildRank(guild.getId(), guild.getScore());
            ServiceProvider.getRankService().updateGuildLevelRank(guild.getId(), guild.getLevel());
            ServiceProvider.getRankService().updateGuildMemberRank(guild.getId(), guild.getCurMemberNums());
            // 同步玩家
            CreateGuildRsp.Builder builder = CreateGuildRsp.newBuilder();
            builder.setErrorID(ErrorID.OK);
            builder.setGuildBaseInfo(MessageHelper.toGuildBaseInfo(guild));
            PlayerRole playerRole = ServiceProvider.getPlayerService().setRoleGuild(event.getRoleID(), guild.getId());
            playerRole.setPost(EGuildPost.GuildPostChairMan_VALUE);
            SpringContext.getBean(PlayerRoleDao.class).cacheUpdate(playerRole, event.getRoleID());
            ChannelManager.getInstance().sendGlobalGuildToGate(playerRole.getGateServerID(), event.getRoleID(), builder.build());
            // 消耗令牌
            ServiceProvider.getItemService().addItemBill(event.getRoleID(), event.getTokenId(), -event.getTokenCount(), ResourceBillEnum.createGuild, true, false);
            EventManager.postSyncItemEvent(event.getRoleID());
            // 初始化商会任务
            SpringContext.getBean(GuildTaskDao.class).flushLevelTask(event.getRoleID(), guild.getId(), guild.getLevel());
            // 激活缓存
            SpringContext.getBean("guildCacheManager", CacheManager.class).activateCache(guild.getId());

            EventManager.postTaskActionEvent(event.getRoleID(), TaskActionEnum.CREATE_GUILD, 1);
            EventManager.postTaskActionEvent(event.getRoleID(), TaskActionEnum.HAS_GUILD, 1);
            EventManager.commitRoleEvent(event.getRoleID());
        } catch (Exception e) {
            log.error(e.getMessage());
            return;
        }
    }

    /**
     * 修改商会名称
     *
     * @param event
     */
    public void guildChangeName(GuildChangeNameEvent event) {
        log.info("guildChangeName event={}", event.getTopic());
        GlobalGuild guild = SpringContext.getBean(GlobalGuildDao.class).cacheQuery(event.getGuildID(), event.getRoleID());
        if (guild == null) {
            // 同步玩家
            CreateGuildRsp.Builder builder = CreateGuildRsp.newBuilder();
            builder.setErrorID(ErrorID.GUILD_NOT_EXIT);
            PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(event.getRoleID());
            ChannelManager.getInstance().sendGlobalGuildToGate(playerRole.getGateServerID(), event.getRoleID(), builder.build());
            return;
        }
        guild.setName(event.getName());
        SpringContext.getBean(GlobalGuildDao.class).cacheUpdate(guild, event.getGuildID());
        // 推送商会新名称
        ChangeGuildNameNtf.Builder ntfBuilder = ChangeGuildNameNtf.newBuilder();
        ntfBuilder.setName(name());
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(event.getRoleID());
        ChannelManager.getInstance().sendGlobalGuildToGate(playerRole.getGateServerID(), event.getRoleID(), ntfBuilder.build());
    }

    /**
     * 商会战斗报名
     *
     * @param event
     */
    public void guildBattleSingUp(GuildBattleSingUpEvent event) {
        log.info("guildBattleSingUp event={}", event.getTopic());
        // 3秒钟后，自动匹配到大寻，进行战斗
        ThreadUtil.sleep(3000);
        // 创建房间
        GuildBattleGameWorker.getWorker().createRoom(event.getRoleID(), GlobalRoleID.getXiaoXun());
        // 商会战斗匹配成功推送
        GuildBattleMatchSucessNtf.Builder guildBattleMatchSucessNtf = GuildBattleMatchSucessNtf.newBuilder();
        PlayerRole matchPlayerRole = ServiceProvider.getPlayerService().getPlayer(GlobalRoleID.getXiaoXun());
        if(!ObjectUtils.isEmpty(matchPlayerRole)){
            guildBattleMatchSucessNtf.setMatchRoleInfo(matchPlayerRole.toBaseRoleInfo());
        }
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(event.getRoleID());
        ChannelManager.getInstance().sendGlobalGuildBattleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), guildBattleMatchSucessNtf.build());
    }

    /**
     * 商会等级
     *
     * @param roleID
     */
    public GlobalGuild addGuildExp(long roleID, long guildID, int guildScore, boolean post2Client) {
        log.info("addGuildExp roleID={} guildID={} guildScore={} post2Client={}", roleID, guildID, guildScore, post2Client);
        if (guildID == 0) {
            return null;
        }
        GlobalGuild guild = SpringContext.getBean(GlobalGuildDao.class).cacheQuery(guildID, roleID);
        if (guild == null) {
            return null;
        }
        guild.setExperience(guild.getExperience() + guildScore);
        // 等级
        ConfigGuildLevelConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_GUILDLEVEL);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        int level = guild.getLevel();
        while (true) {
            ConfigGuildLevel config = conf.getGuildLevel(level);
            if (config == null) {
                break;
            }
            if (guild.getExperience() < config.getUpLevelExp() + config.getUpLevelTotalExp()) {
                break;
            }
            level++;
        }
        GuildAttrClientNtf.Builder ntf = GuildAttrClientNtf.newBuilder();
        ntf.putIntDic(GuildAttrEnum.Experience.getKey(), guild.getExperience());
        if (level > guild.getLevel()) {
            guild.setLevel(level);
            ntf.putIntDic(GuildAttrEnum.LEVEL.getKey(), level);
        }
        SpringContext.getBean(GlobalGuildDao.class).cacheUpdate(guild, guildID);
        // 推送商会属性
        if (post2Client) {
            PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
            ChannelManager.getInstance().sendGlobalGuildToGate(playerRole.getGateServerID(), roleID, ntf.build());
        }
        return guild;
    }

    public void guildComplete(GuildTaskCompleteEvent event) {
        log.info("guildComplete event={}", event.getTopic());
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("taskID", event.getTaskID());
        queryParams.put("index", event.getIndex());
        GuildTask guildTask = SpringContext.getBean(GuildTaskDao.class).cacheSelect(queryParams, event.getGuildID());
        if ((guildTask == null) || (guildTask.getState() != TaskState.accept.getState())) return;
        guildTask.setState(TaskState.award.getState());
        guildTask.setActionTime(event.getActionTime());
        guildTask.setCurItem(event.getCurItem());
        if (StringUtil.isNotEmpty0Null(guildTask.getNeedItem())) {
            guildTask.setNeedItemMap(MapUtil.stringToMap(guildTask.getNeedItem(), ";", "-"));
        } else {
            guildTask.setNeedItemMap(Maps.newHashMapWithExpectedSize(0));
        }
        if (StringUtil.isNotEmpty0Null(guildTask.getCurItem())) {
            guildTask.setCurItemMap(MapUtil.stringToMap(guildTask.getCurItem(), ";", "-"));
        } else {
            guildTask.setCurItemMap(Maps.newHashMapWithExpectedSize(0));
        }
        SpringContext.getBean(GuildTaskDao.class).cacheUpdate(guildTask, event.getGuildID());

        // 为商会添加经验
        GuildLevelEvent guildLevelEvent = EventManager.borrowEvent(GuildLevelEvent.class);
        guildLevelEvent.setRoleID(event.getRoleID());
        guildLevelEvent.setGuildID(event.getGuildID());
        guildLevelEvent.setGuildScore(event.getGuildScore());
        TopicManager.getInstance().publishTopic(guildLevelEvent);

        GuildTaskUpdateEvent updateEvent = AbsEventManager.borrowEvent(GuildTaskUpdateEvent.class);
        updateEvent.setGuildID(guildTask.getGuildID());
        updateEvent.setTaskInfo(guildTask.toTaskInfo());
        EventManager.postAsyncEvent(updateEvent);
        GuildTask newGuildTask = (GuildTask) SpringContext.getBean(GuildTaskDao.class).flushTask(guildTask);
        if (newGuildTask != null) {
            //通知商会成员有任务更新
            GuildTaskUpdateEvent newUpdateEvent = AbsEventManager.borrowEvent(GuildTaskUpdateEvent.class);
            newUpdateEvent.setGuildID(newGuildTask.getGuildID());
            newUpdateEvent.setTaskInfo(newGuildTask.toTaskInfo());
            EventManager.postAsyncEvent(newUpdateEvent);
        }
    }

    /**
     * 交易挂单
     *
     * @param event
     */
//    public void tradeEnqueue(TradeEnqueueEvent event) {
//        log.info("tradeEnqueue event={}", event.getTopic());
//        GlobalTrade trade = new GlobalTrade(event.getRoleID());
//        trade.setId(ServiceProvider.readModuleID(TableID.TABLE_TRADE));
//        trade.setType(event.getType());
//        trade.setOrderID(event.getOrderID());
//        trade.setPrice(event.getPrice());
//        trade.setOrderNum(event.getOrderNum());
//        SpringContext.getBean(GlobalTradeDao.class).cacheInsert(trade, event.getOrderID());
//        // 即时入db，方便查个人订单
//        SpringContext.getBean("tradeCacheManager", CacheManager.class).flushSyncAllData(event.getOrderID(), false);
//        ServiceProvider.getTradeService().addTrade(trade);
//    }

    /**
     * 交易买卖
     *
     * @param event
     */
//    public void tradeUse(TradeUseEvent event) {
//        log.info("tradeUse event={}", event.getTopic());
//        QueryParamMap queryParams = new QueryParamMap();
//        queryParams.put("id", event.getId());
//        queryParams.put("orderID", event.getOrderID());
//        GlobalTrade trade = SpringContext.getBean(GlobalTradeDao.class).cacheSelect(queryParams, event.getOrderID());
//        if (event.getType() == TradeType.Sale_VALUE) {
//            // 卖
//            // 本人扣物品
//            if (event.getOrderID() == ConstantGame.DIAMOND) { // 钻石
//                PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(event.getRoleID());
//                if (playerRole.getDiamond() < event.getNum()) {
//                    throw new CommonException(ErrorID.COMMON_PLAYER_DIAMOND_LESS);
//                }
//                ServiceProvider.getCommonService().addAttrBill(event.getRoleID(), PlayerAttrEnum.DIAMOND.getKey(), -event.getNum(), ResourceBillEnum.tradeUseSaleCost);
//            } else {
//                ServiceProvider.getItemService().addItemBill(event.getRoleID(), event.getOrderID(), -event.getNum(), ResourceBillEnum.tradeUseSaleCost, true, true);
//                EventManager.postSyncItemEvent(event.getRoleID());
//            }
//            // 本人获得金币
//            ServiceProvider.getCommonService().addAttrBill(event.getRoleID(), PlayerAttrEnum.GOLD.getKey(), event.getNum() * trade.getPrice(), ResourceBillEnum.tradeUseSaleReward);
//            EventManager.postSyncAttrEvent(event.getRoleID());
//            // 他人获得物品
//            ServiceProvider.getItemService().addItemBill(trade.getRoleID(), event.getOrderID(), event.getNum(), ResourceBillEnum.tradeUseSaleReward, true, true);
//            EventManager.postSyncItemEvent(trade.getRoleID());
//        } else {
//            // 买
//            // 本人获得物品
//            if (event.getOrderID() == ConstantGame.DIAMOND) { // 钻石
//                ServiceProvider.getCommonService().addAttrBill(event.getRoleID(), PlayerAttrEnum.DIAMOND.getKey(), event.getNum(), ResourceBillEnum.tradeUsePurchaseReward);
//            } else {
//                ServiceProvider.getItemService().addItemBill(event.getRoleID(), event.getOrderID(), event.getNum(), ResourceBillEnum.tradeUsePurchaseReward, true, true);
//                EventManager.postSyncItemEvent(event.getRoleID());
//            }
//            // 本人扣金币
//            ServiceProvider.getCommonService().addAttrBill(event.getRoleID(), PlayerAttrEnum.GOLD.getKey(), -event.getNum() * trade.getPrice(), ResourceBillEnum.tradeUsePurchaseCost);
//            EventManager.postSyncAttrEvent(event.getRoleID());
//            // 他人获得金币
//            ServiceProvider.getCommonService().addAttrBill(trade.getRoleID(), PlayerAttrEnum.GOLD.getKey(), event.getNum() * trade.getPrice(), ResourceBillEnum.tradeUsePurchaseReward);
//            EventManager.postSyncAttrEvent(trade.getRoleID());
//        }
//        // 更新交易记录
//        trade.setOrderUsed(trade.getOrderUsed() + event.getNum());
//        if (trade.getOrderUsed() >= trade.getOrderNum()) {
//            SpringContext.getBean(GlobalTradeDao.class).cacheDelete(trade.getId(), trade.getOrderID());
//        } else {
//            SpringContext.getBean(GlobalTradeDao.class).cacheUpdate(trade, trade.getOrderID());
//        }
//        log.info("orderID {}, price {}", event.getOrderID(), trade.getPrice());
//        // 更新成交价
//        GlobalTradeStock tradeStock = SpringContext.getBean(GlobalTradeStockDao.class).cacheLoad("orderID", event.getOrderID(), event.getRoleID());
//        if (tradeStock != null) {
//            // 涨跌 = (交易价格-最新价格) / 最新价格 * 10000 (万分比)
//            int score = (int) Math.floor((trade.getPrice() - tradeStock.getLastPrice()) / (float) tradeStock.getLastPrice() * 10000);
//            tradeStock.setScore(score);
//            // 最新价格
//            tradeStock.setLastPrice(trade.getPrice());
//            // 最低价格
//            if (trade.getPrice() < tradeStock.getLowestPrice() || tradeStock.getLowestPrice() == 0) {
//                tradeStock.setLowestPrice(trade.getPrice());
//            }
//            // 最高价格
//            if (trade.getPrice() > tradeStock.getHighestPrice() || tradeStock.getHighestPrice() == 0) {
//                tradeStock.setHighestPrice(trade.getPrice());
//            }
//        }
//        SpringContext.getBean(GlobalTradeStockDao.class).cacheUpdate(tradeStock, event.getOrderID());
//        // 更新历史价 ， 每天最后一笔成交价
//        Date nowTime = DateUtil.getCurrentDate();
//        String date = DateUtil.getNowDate();
//        QueryParamMap queryParams1 = new QueryParamMap();
//        queryParams1.put("orderID", event.getOrderID());
//        queryParams1.put("date", date);
//        GlobalTradeHistory history = SpringContext.getBean(GlobalTradeHistoryDao.class).cacheSelect(queryParams1, event.getRoleID());
//        if (history == null) {
//            history = new GlobalTradeHistory(event.getRoleID());
//            history.setId(ServiceProvider.readModuleID(TableID.TABLE_TRADE_STOCK_HISTORY));
//            history.setOrderID(event.getOrderID());
//            history.setDate(date);
//            history.setStartPrice(trade.getPrice());
//            history.setEndPrice(trade.getPrice());
//            history.setHighestPrice(trade.getPrice());
//            history.setLowestPrice(trade.getPrice());
//            history.setTurnover(history.getTurnover() + 1);
//            history.setCreateTime(nowTime);
//            SpringContext.getBean(GlobalTradeHistoryDao.class).cacheInsert(history, event.getOrderID());
//        } else {
//            if (history.getUpdateTime() == null) {
//                history.setStartPrice(trade.getPrice());
//            }
//            history.setEndPrice(trade.getPrice());
//            if (history.getHighestPrice() < trade.getPrice()) {
//                history.setHighestPrice(trade.getPrice());
//            }
//            if (history.getLowestPrice() > trade.getPrice()) {
//                history.setLowestPrice(trade.getPrice());
//            }
//            history.setTurnover(history.getTurnover() + event.getNum());
//            history.setUpdateTime(nowTime);
//            SpringContext.getBean(GlobalTradeHistoryDao.class).cacheUpdate(history, event.getOrderID());
//        }
//        // 即时入db，方便查个人订单
//        SpringContext.getBean("tradeCacheManager", CacheManager.class).flushSyncAllData(event.getOrderID(), false);
//        // 提交交易的双方玩家事件
//        EventManager.commitRoleEvent(event.getRoleID());
//        EventManager.commitRoleEvent(trade.getRoleID());
//        // 交易推送
//        GlobalTradeHandler tradeHandler = SpringContext.getBean(GlobalTradeHandler.class);
//        Set<Long> tradeRoleIDSet = tradeHandler.getTradeRoleIDSet();
//        if (tradeRoleIDSet.size() > 0) {
//            TradeUseNtf.Builder tradeUseNtf = TradeUseNtf.newBuilder();
//            HistoryInfo.Builder historyInfo = HistoryInfo.newBuilder();
//            historyInfo.setDate(history.getDate());
//            historyInfo.setStartPrice(history.getStartPrice());
//            historyInfo.setEndPrice(history.getEndPrice());
//            historyInfo.setHighestPrice(history.getHighestPrice());
//            historyInfo.setLowestPrice(history.getLowestPrice());
//            historyInfo.setTurnover(history.getTurnover());
//            // 1号的月份，非1号的为0
//            String[] arr = history.getDate().split("-");
//            if (Integer.parseInt(arr[2]) == 1) {
//                historyInfo.setMonth(Integer.parseInt(arr[1]));
//            } else {
//                historyInfo.setMonth(0);
//            }
//            tradeUseNtf.setOrderId(history.getOrderID());
//            tradeUseNtf.setInfo(historyInfo.build());
//            TradeUseNtf ntf = tradeUseNtf.build();
//            Iterator<Long> it = tradeRoleIDSet.iterator();
//            while (it.hasNext()) {
//                PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(it.next());
//                if (playerRole.isOnline()) {
//                    ChannelManager.getInstance().sendGlobalRankToGate(playerRole.getGateServerID(), playerRole.getRoleID(), ntf);
//                } else {
//                    it.remove();
//                }
//            }
//        }
//    }

}
