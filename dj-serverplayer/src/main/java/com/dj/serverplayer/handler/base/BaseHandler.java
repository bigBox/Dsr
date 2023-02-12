package com.dj.serverplayer.handler.base;

import com.dj.domain.base.IEntity;
import com.dj.domain.config.ConfigAchievement;
import com.dj.domain.config.ConfigItem2Count;
import com.dj.domain.config.ConfigItems;
import com.dj.domain.config.ConfigTasks;
import com.dj.domain.data.MonthCard;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.entity.player.item.*;
import com.dj.domain.entity.robot.item.*;
import com.dj.domain.enums.*;
import com.dj.domain.type.ItemType;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.buffer.MonthCardNtf;
import com.dj.protobuf.item.GridItem;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.*;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.item.*;
import com.dj.serverapi.dao.task.*;
import com.dj.serverapi.helper.OnlineHelper;
import com.dj.servercore.conf.ConfigAchievementConf;
import com.dj.servercore.conf.ConfigItemsConf;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverplayer.handler.TaskHandler;
import com.dj.serverplayer.manager.ChannelManager;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.EventManager;
import com.dj.serverplayer.manager.ServiceManager;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zcq
 * @description 基础业务处理器，提供玩家资源增加扣除接口
 * @date 2019年4月17日
 */
@Slf4j
@SuppressWarnings({"rawtypes", "unchecked"})
public class BaseHandler extends ServiceProvider {
    @Autowired
    public GlobalGuildDao globalGuildDao;
    @Autowired
    public PlayerAccountDao playerAccountDao;
    @Autowired
    public PlayerRoleDao playerRoleDao;
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
    @Autowired
    public PlayerVerifyDao playerVerifyDao;
    @Autowired
    public PlayerVerifyHistoryDao playerVerifyHistoryDao;
    @Autowired
    public PlayerFriendDao playerFriendDao;
    @Autowired
    public PlayerFactoryDao playerFactoryDao;
    @Autowired
    public PlayerObstacleDao playerObstacleDao;
    @Autowired
    public PlayerCollectionDao playerCollectionDao;
    @Autowired
    public PlayerFarmDao playerFarmDao;
    @Autowired
    public PlayerShowTableDao playerShowTableDao;
    @Autowired
    public PlayerShowTableInfoDao playerShowTableInfoDao;
    @Autowired
    public PlayerShowTableMoneyDao playerShowTableMoneyDao;
    @Autowired
    public PlayerItemInteractHistoryDao playerItemInteractHistoryDao;
    @Autowired
    public PlayerUserInfoDao playerUserInfoDao;
    @Autowired
    public PlayerManufactureDao playerManufactureDao;
    @Autowired
    public PlayerBookDao playerBookDao;
    @Autowired
    public PlayerLeaveHistoryDao playerLeaveHistoryDao;
    @Autowired
    public PlayerTask1Dao playerTask1Dao;
    @Autowired
    public PlayerTask2Dao playerTask2Dao;
    @Autowired
    public PlayerTask3Dao playerTask3Dao;
    @Autowired
    public PlayerTask4Dao playerTask4Dao;
    @Autowired
    public GuildTaskDao guildTaskDao;
    @Autowired
    public SmsCodeDao  smsCodeDao;
    @Autowired
    public WxPayDao  wxPayDao;
    @Autowired
    public AliPayDao aliPayDao;

    @Autowired
    public RobotRoleDao robotRoleDao;
    @Autowired
    public RobotItem1Dao robotItem1Dao;
    @Autowired
    public RobotItem2Dao robotItem2Dao;
    @Autowired
    public RobotItem3Dao robotItem3Dao;
    @Autowired
    public RobotItem4Dao robotItem4Dao;
    @Autowired
    public RobotItem5Dao robotItem5Dao;
    @Autowired
    public RobotItem6Dao robotItem6Dao;
    @Autowired
    public RobotItem7Dao robotItem7Dao;
    @Autowired
    public RobotItem100Dao robotItem100Dao;
    @Autowired
    public TaskHandler taskHandler;
    /**
     *	检查玩家等级是否满足条件
     */
    public boolean checkLevelEnough(long roleID, int level) {
        PlayerRole playerRole = playerService.getPlayer(roleID);
        if (playerRole.getLevel() < level) {
            throw new CommonException(ErrorID.COMMON_PLAYER_LEVEL_LESS);
        }
        return true;
    }

    /**
     *	检查玩家金币是否足够
     */
    public boolean checkGoldEnough(long roleID, int gold) {
        PlayerRole playerRole = playerService.getPlayer(roleID);
        if (playerRole.getGold() < gold) {
            throw new CommonException(ErrorID.COMMON_PLAYER_GOLD_LESS);
        }
        return true;
    }

    /**
     *	扣除玩家金币
     */
    public long costGold(long roleID, long gold, ResourceBillEnum bill) {
        PlayerRole playerRole = playerService.costGold(roleID, gold);
        playerRoleDao.cacheUpdate(playerRole);
        if (bill.isCommitEvent()) {
            EventManager.postCommitPlayerAttrEvent(roleID, PlayerAttrEnum.GOLD, playerRole.getGold());
        } else {
            EventManager.postPlayerAttrEvent(roleID, PlayerAttrEnum.GOLD, playerRole.getGold());
        }
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.GOLD.getKey(), PlayerAttrEnum.GOLD.getKey(), "金币", playerRole.getGold(), -gold, bill, bill.getDesc());
        return playerRole.getGold();
    }

    /**
     *	增加玩家金币
     */
    public long addGold(long roleID, long gold, ResourceBillEnum bill) {
        if(gold <= 0){
            return 0;
        }
        PlayerRole playerRole = playerService.addGold(roleID, gold);
        playerRoleDao.cacheUpdate(playerRole);
        EventManager.postPlayerAttrEvent(roleID, PlayerAttrEnum.GOLD, playerRole.getGold());
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.GOLD.getKey(), PlayerAttrEnum.GOLD.getKey(), "金币", playerRole.getGold(), gold, bill, bill.getDesc());
        return playerRole.getGold();
    }

    /**
     *	检查玩家钻石是否足够
     */
    public boolean checkDiamondEnough(long roleID, int diamond) {
        PlayerRole playerRole = playerService.getPlayer(roleID);
        if (playerRole.getDiamond() < diamond) {
            throw new CommonException(ErrorID.COMMON_PLAYER_DIAMOND_LESS);
        }
        return true;
    }

    /**
     *	扣除玩家钻石
     */
    public long costDiamond(long roleID, long diamond, ResourceBillEnum bill) {
        PlayerRole playerRole = playerService.costDiamond(roleID, diamond);
        playerRoleDao.cacheUpdate(playerRole);
        EventManager.postPlayerAttrEvent(roleID, PlayerAttrEnum.DIAMOND, playerRole.getDiamond());
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.DIAMOND.getKey(), PlayerAttrEnum.DIAMOND.getKey(), "钻石", playerRole.getDiamond(), -diamond, bill, bill.getDesc());
        return playerRole.getDiamond();
    }

    /**
     *	增加玩家钻石
     */
    public long addDiamond(long roleID, long diamond, ResourceBillEnum bill) {
        if(diamond <= 0){
            return 0;
        }
        PlayerRole playerRole = playerService.addDiamond(roleID, diamond);
        playerRoleDao.cacheUpdate(playerRole);
        EventManager.postPlayerAttrEvent(roleID, PlayerAttrEnum.DIAMOND, playerRole.getDiamond());
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.DIAMOND.getKey(), PlayerAttrEnum.DIAMOND.getKey(), "钻石", playerRole.getDiamond(), diamond, bill, bill.getDesc());
        return playerRole.getDiamond();
    }

    /**
     *	检查玩家体力是否足够
     */
    public boolean checkStaminaEnough(long roleID, int stamina) {
        PlayerRole playerRole = playerService.getPlayer(roleID);
        if (playerRole.getStamina() < stamina) {
            throw new CommonException(ErrorID.COMMON_PLAYER_STAMINA_LESS);
        }
        return true;
    }

    /**
     *	扣除玩家体力
     */
    public long costStamina(long roleID, long stamina, ResourceBillEnum bill) {
        PlayerRole playerRole = playerService.costStamina(roleID, stamina);
        playerRoleDao.cacheUpdate(playerRole);
        EventManager.postPlayerAttrEvent(roleID, PlayerAttrEnum.STAMINA, playerRole.getStamina());
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.STAMINA.getKey(), PlayerAttrEnum.STAMINA.getKey(), "体力", playerRole.getStamina(), -stamina, bill, bill.getDesc());
        return playerRole.getStamina();
    }

    /**
     *	增加玩家体力
     */
    public long addStamina(long roleID, long stamina, ResourceBillEnum bill) {
        if(stamina <= 0){
            return 0;
        }
        PlayerRole playerRole = playerService.addStamina(roleID, stamina);
        playerRoleDao.cacheUpdate(playerRole);
        EventManager.postPlayerAttrEvent(roleID, PlayerAttrEnum.STAMINA, playerRole.getStamina());
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.STAMINA.getKey(), PlayerAttrEnum.STAMINA.getKey(), "体力", playerRole.getStamina(), stamina, bill, bill.getDesc());
        return playerRole.getStamina();
    }

    /**
     *	检测并消耗玩家物品
     *
     * @param roleID 角色id
     * @param cost   例如 510030091-1;510030096-1
     * @param bill   流通类型
     */
    public boolean checkCostItem(long roleID, String cost, ResourceBillEnum bill) {
        if (StringUtil.isNotEmpty0Null(cost)) {
            Map<Integer, Integer> map = MapUtil.mapStringToMap1(cost);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                checkItemEnough(roleID, entry.getKey(), entry.getValue());
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                costItem(roleID, entry.getKey(), entry.getValue(), bill);
            }
        }
        return true;
    }

    /**
     *	检查玩家物品是否足够
     */
    public boolean checkItemEnough(long roleID, Map<Integer, Integer> costMap) {
        for (Map.Entry<Integer, Integer> entry : costMap.entrySet()) {
            checkItemEnough(roleID, entry.getKey(), entry.getValue());
        }
        return true;
    }

    /**
     *	检查玩家物品是否足够
     */
    public boolean checkItemEnough(long roleID, int itemID, long count) {
        if (itemID == 0 && count == 0) {
            return false;
        }
        long itemCount = ServiceManager.getItemService().getItemCount(roleID , itemID);
        if (itemCount < count) {
        	throw new CommonException(ErrorID.COMMON_PLAYER_ITEM_LESS, "roleID:" + roleID + ", costItem:" + itemID + ", count:" + count);
        }
        ConfigItemsConf conf = ConfManager.getInstance().getConfigItemsConf();
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        int itemType = conf.getItemType(itemID);
        if (itemType == 0) {
            throw new CommonException(ErrorID.COMMON_CONFIG_ERROR, "checkItemEnough:" + itemID);
        }
        BaseCacheDao  itemDao = getPlayerItemDao(itemType);
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("roleID",roleID);
        queryParams.put("itemID",itemID);
        PlayerItem   playerItem = (PlayerItem) itemDao.cacheSelect(queryParams, roleID);
        if (playerItem == null || playerItem.getItemCount() < count) {
        	throw new CommonException(ErrorID.COMMON_PLAYER_ITEM_LESS, "roleID:" + roleID + ", costItem:" + itemID + ", count:" + count);
        }
        return true;
    }

    /**
     *	扣除玩家物品
     *
     * @param roleID 角色id
     * @param itemID 道具id
     * @param count  道具数量
     * @param bill   流通类型
     */
    public long costItem(long roleID, int itemID, long count, ResourceBillEnum bill) {
        return costItem(roleID, itemID, count, bill, true, true);
    }
    
    /**
     *	扣除玩家物品
     *
     * @param roleID 	角色id
     * @param itemID 	道具id
     * @param count  	道具数量
     * @param bill   	流通类型
     * @param visible   是否显示
     */
    public long costItem(long roleID, int itemID, long count, ResourceBillEnum bill, boolean visible) {
    	return costItem(roleID, itemID, count, bill, true, visible);
    }

    /**
     *	扣除玩家物品
     *
     * @param roleID      角色id
     * @param itemID      道具id
     * @param changeCount       道具数量
     * @param bill        流通类型
     * @param post2Client 是否推送给前端
     */
    public long costItem(long roleID, int itemID, long changeCount, ResourceBillEnum bill, boolean post2Client, boolean visible) {
        if (itemID == 0 && changeCount == 0) {
            return 0;
        }
        long itemCount = ServiceManager.getItemService().getItemCount(roleID , itemID);
        if (itemCount < changeCount) {
            throw new CommonException(ErrorID.COMMON_PLAYER_ITEM_LESS, "roleID:" + roleID + ", costItem:" + itemID + ", changeCount:" + changeCount);
        }
        ConfigItemsConf conf = ConfManager.getInstance().getConfigItemsConf();
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        int itemType = conf.getItemType(itemID);
        if (itemType == 0) {
            throw new CommonException(ErrorID.COMMON_CONFIG_ERROR, "roleID:" + roleID + ", costItem:" + itemID);
        }
        BaseCacheDao itemDao = getPlayerItemDao(itemType);
        QueryParamMap  queryParams = new QueryParamMap();
        queryParams.put("roleID",roleID);
        queryParams.put("itemID",itemID);
        PlayerItem playerItem = (PlayerItem) itemDao.cacheSelect(queryParams, roleID);
        if (playerItem == null || playerItem.getItemCount() < changeCount) {
        	throw new CommonException(ErrorID.COMMON_PLAYER_ITEM_LESS, "roleID:" + roleID + ", costItem:" + itemID + ", changeCount:" + changeCount);
        }
        ConfigItems config = conf.getItem(itemID);
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, itemType, itemID, config.getName(), playerItem.getItemCount(), -changeCount, bill, bill.getDesc());
        long count = playerItem.getItemCount() - changeCount;
        if (count > 0) {
            playerItem.setItemCount(count);
            itemDao.cacheUpdate((IEntity) playerItem, roleID);

        } else {
            count = 0;
            playerItem.setItemCount(0);
            itemDao.cacheDelete(playerItem.getId(), roleID);
        }
        ServiceManager.getItemService().setItemCount(roleID , itemID, count);
        // 更新未鉴定的宝物到待鉴定区
        if (bill != ResourceBillEnum.verifyItem) {
            if (itemType == ItemType.type5 && config.getColor() == ItemColor.color1.getColor()) {
                verifyService.delVerify(roleID, (PlayerItem5) playerItem, changeCount);
            }
        }
        // 道具变更推送
        EventManager.postPlayerItemEvent(roleID, itemType, config.getColor(), playerItem, visible, post2Client, false);
        // 做任务
        taskHandler.doTaskUseItem(roleID, itemID, changeCount);
        return count;
    }
    /**
     *	扣除玩家小寻物品
     *
     * @param roleID      角色id
     * @param itemID      道具id
     * @param changeCount       道具数量
     * @param bill        流通类型
     * @param post2Client 是否推送给前端
     */
    public long costRobotItem(long roleID, int itemID, long changeCount, ResourceBillEnum bill, boolean post2Client, boolean visible) {
        if (itemID == 0 && changeCount == 0) {
            return 0;
        }
        ConfigItemsConf conf = ConfManager.getInstance().getConfigItemsConf();
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        int itemType = conf.getItemType(itemID);
        if (itemType == 0) {
            throw new CommonException(ErrorID.COMMON_CONFIG_ERROR, "roleID:" + roleID + ", costItem:" + itemID);
        }
        BaseCacheDao itemDao = getPlayerItemDao(itemType);
        QueryParamMap  queryParams = new QueryParamMap();
        queryParams.put("roleID",roleID);
        queryParams.put("itemID",itemID);
        RobotItem robotItem = (RobotItem) itemDao.cacheSelect(queryParams, roleID);
        if (robotItem == null || robotItem.getItemCount() < changeCount) {
            throw new CommonException(ErrorID.COMMON_PLAYER_ITEM_LESS, "roleID:" + roleID + ", costItem:" + itemID + ", changeCount:" + changeCount);
        }
        if (robotItem.getItemCount() < changeCount) {
            throw new CommonException(ErrorID.COMMON_PLAYER_ITEM_LESS, "roleID:" + roleID + ", costItem:" + itemID + ", changeCount:" + changeCount);
        }
        ConfigItems config = conf.getItem(itemID);
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, itemType, itemID, config.getName(), robotItem.getItemCount(), -changeCount, bill, bill.getDesc());
        long count = robotItem.getItemCount() - changeCount;
        if (count > 0) {
            robotItem.setItemCount(count);
            itemDao.cacheUpdate((IEntity) robotItem, roleID);

        } else {
            count = 0;
            robotItem.setItemCount(0);
            itemDao.cacheDelete(robotItem.getId(), roleID);
        }
        // 更新未鉴定的宝物到待鉴定区
        if (bill != ResourceBillEnum.verifyItem) {
            if (itemType == ItemType.type5 && config.getColor() == ItemColor.color1.getColor()) {
                verifyService.delRobotVerify(roleID, (RobotItem5) robotItem, changeCount);
            }
        }
        return count;
    }
    /**
     *	扣除玩家物品
     */
    public void costItem(long roleID, Map<Integer, Integer> costMap, ResourceBillEnum bill) {
        for (Map.Entry<Integer, Integer> entry : costMap.entrySet()) {
            costItem(roleID, entry.getKey(), entry.getValue(), bill);
        }
    }

    /**
     *	增加玩家物品
     *
     * @param roleID 角色id
     * @param item   例如 510030091-1;510030096-1
     * @param bill   流通类型
     */
    public void addItem(long roleID, String item, ResourceBillEnum bill, boolean visible) {
        if (StringUtil.isNotEmpty0Null(item)) {
            Map<Integer, Integer> map = MapUtil.mapStringToMap1(item);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getKey() == 1) {//金币
                    addGold(roleID, entry.getValue(), ResourceBillEnum.taskReward);
                }else if(entry.getKey() == 2){//钻石
                    addDiamond(roleID, entry.getValue(), ResourceBillEnum.taskReward);
                }else if(entry.getKey() == 3){//体力
                    addStamina(roleID, entry.getValue(), ResourceBillEnum.taskReward);
                }else if(entry.getKey() == 4){//经验
                    addExp(roleID,  entry.getValue(), ResourceBillEnum.taskReward);
                }
                else if(entry.getKey() == 39){//声望
                    addRenown(roleID, entry.getValue(), ResourceBillEnum.taskReward);
                }
                else {//物品
                    addItem(roleID, entry.getKey(), entry.getValue(), bill, true, visible);
                }
            }
        }
    }

    /**
     *	增加玩家物品
     *
     * @param roleID  角色id
     * @param itemID  道具id
     * @param count   道具数量
     * @param bill    流通类型
     * @param visible 前端动画显示
     */
    public long addItem(long roleID, int itemID, int count, ResourceBillEnum bill, boolean visible) {
        return addItem(roleID, itemID, count, bill, true, visible);
    }

    /**
     *	增加玩家物品
     *
     * @param roleID      角色id
     * @param itemID      道具id
     * @param count       道具数量
     * @param bill        流通类型
     * @param post2Client 是否推送给前端
     * @param visible     前端动画显示
     */
    public long addItem(long roleID, int itemID, long count, ResourceBillEnum bill, boolean post2Client, boolean visible) {
        // 月卡 就直接使用
        if (itemID == ConfigSundryConf.monthCardItemID) {
            return addMonthCard(roleID, count, bill);
        }
        ConfigItemsConf conf = ConfManager.getInstance().getConfigItemsConf();
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        int itemType = conf.getItemType(itemID);
        if (itemType == 0) {
            log.error("roleID:{}, resourceID:{}, count:{}, bill:{}, desc:{}", roleID, itemID, count, bill, bill.getDesc());
            return 0;
        }
        BaseCacheDao itemDao = getPlayerItemDao(itemType);
        QueryParamMap  queryParams = new QueryParamMap();
        queryParams.put("roleID",roleID);
        queryParams.put("itemID",itemID);
        PlayerItem playerItem = (PlayerItem) itemDao.cacheSelect(queryParams, roleID);
        if (playerItem == null) {
            playerItem = createPlayerItem(roleID, itemType);
            playerItem.setItemID(itemID);
            playerItem.setItemCount(count);
            itemDao.cacheInsert((IEntity) playerItem, roleID);
        } else {
            playerItem.setItemCount(playerItem.getItemCount() + count);
            itemDao.cacheUpdate((IEntity) playerItem, roleID);
        }

        ServiceManager.getItemService().setItemCount(roleID , itemID, playerItem.getItemCount());

        ConfigItems config = conf.getItem(itemID);
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, itemType, itemID, config.getName(), playerItem.getItemCount(), count, bill, bill.getDesc());
        // 是否是子物品
        ConfigItem2Count item2Count = ConfManager.getInstance().getConfigItem2CountConf().getItem2Count(playerItem.getItemID());
        if(item2Count != null) {
        	//子物品数量可以生成父物品
        	if(playerItem.getItemCount() >= item2Count.getCount()) {
        		// 父物品数量
        		long pCount = playerItem.getItemCount() / item2Count.getCount() * item2Count.getItemCount();
        		addItem(roleID, item2Count.getItemID(), pCount, bill, post2Client, visible);
        		// 子物品数量
                long cCount = playerItem.getItemCount()- playerItem.getItemCount() % item2Count.getCount();

        		costItem(roleID, itemID, cCount, bill, post2Client, visible);
        		return cCount;
        	}
        }
        
        // 玩家出生时就有的物品, 后续特殊处理 @ItemHandler.initNewRoleItem
        if (bill != ResourceBillEnum.initNewRoleItem) {
            // 更新未鉴定的宝物到待鉴定区
            if (itemType == ItemType.type5 && config.getColor() == ItemColor.color1.getColor()) {
                verifyService.addVerify(roleID, (PlayerItem5) playerItem, count, bill);
            }
        }
        // 需要记录来源
        if (ConfigSundryConf.recordItemSource.contains(itemID)) {
            itemService.recordItemSource(roleID, itemID, count, bill.getSource());
        }
        // 道具变更推送
        EventManager.postPlayerItemEvent(roleID, itemType, config.getColor(), playerItem, visible, post2Client, true);
        // 做任务
        ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.COLLECT_MAP_FRAGMENT);
        if(configTasks != null) {
            if((itemID >= 700101001)&&(itemID <= 700600001)) {
                EventManager.postTaskActionEvent(roleID, TaskActionEnum.COLLECT_MAP_FRAGMENT, 1);
                EventManager.commitRoleEvent(roleID);
            }
        }
        taskHandler.doTaskNeedItem(roleID, itemID, count);
        return count;
    }

    /**
     *	增加玩家小寻的物品
     *
     * @param roleID      角色id
     * @param itemID      道具id
     * @param count       道具数量
     * @param bill        流通类型
     * @param post2Client 是否推送给前端
     * @param visible     前端动画显示
     */
    public long addRobotItem(long roleID, int itemID, long count, ResourceBillEnum bill, boolean post2Client, boolean visible) {
        // 月卡 就直接使用
        ConfigItemsConf conf = ConfManager.getInstance().getConfigItemsConf();
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        int itemType = conf.getItemType(itemID);
        if (itemType == 0) {
            log.error("roleID:{}, resourceID:{}, count:{}, bill:{}, desc:{}", roleID, itemID, count, bill, bill.getDesc());
            return 0;
        }
        BaseCacheDao itemDao = getRobotItemDao(itemType);
        QueryParamMap  queryParams = new QueryParamMap();
        queryParams.put("roleID",roleID);
        queryParams.put("itemID",itemID);
        RobotItem robotItem = (RobotItem) itemDao.cacheSelect(queryParams, roleID);
        if (robotItem == null) {
            robotItem = createRobotItem(roleID, itemType);
            robotItem.setItemID(itemID);
            robotItem.setItemCount(count);
            itemDao.cacheInsert((IEntity) robotItem, roleID);
        } else {
            robotItem.setItemCount(robotItem.getItemCount() + count);
            itemDao.cacheUpdate((IEntity) robotItem, roleID);
        }

        ConfigItems config = conf.getItem(itemID);
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, itemType, itemID, config.getName(), robotItem.getItemCount(), count, bill, bill.getDesc());
        // 是否是子物品
        ConfigItem2Count item2Count = ConfManager.getInstance().getConfigItem2CountConf().getItem2Count(robotItem.getItemID());
        if(item2Count != null) {
            //子物品数量可以生成父物品
            if(robotItem.getItemCount() >= item2Count.getCount()) {
                // 父物品数量
                long pCount = robotItem.getItemCount() / item2Count.getCount() * item2Count.getItemCount();
                addRobotItem(roleID, item2Count.getItemID(), pCount, bill, post2Client, visible);
                // 子物品数量
                long cCount = robotItem.getItemCount()- robotItem.getItemCount() % item2Count.getCount();

                costRobotItem(roleID, itemID, cCount, bill, post2Client, visible);
                return cCount;
            }
        }

        // 玩家出生时就有的物品, 后续特殊处理 @ItemHandler.initNewRoleItem
        //if (bill != ResourceBillEnum.initXiaoXunItem) {
            // 更新未鉴定的宝物到待鉴定区
            if ((itemType == ItemType.type5) && (config.getColor() == ItemColor.color1.getColor())) {
                verifyService.addRobotVerify(roleID, (RobotItem5) robotItem, count, bill);
            }
        //}
        return count;
    }
    /**
     *	添加月卡
     *
     * @param roleID 角色id
     * @param count  月卡数量
     */
    private long addMonthCard(long roleID, long count, ResourceBillEnum bill) {
        // 更新月卡时间
    	MonthCard monthCard = buffService.updateMonthCardTime(roleID, count);
        // 推送最新月卡时间给前端
        int leftSeconds = DateUtil.secondsBetween(DateUtil.getCurrentDate(), new Date(monthCard.getEndTime()));
        MonthCardNtf.Builder builder = MonthCardNtf.newBuilder();
        builder.setLeftSeconds(leftSeconds);
        builder.setIsDrawedToday(monthCard.isDrawedToday());
        int gateID = OnlineHelper.getInstance().getOnlineGateID(roleID);
        ChannelManager.getInstance().sendPlayerBasicToGate(gateID, roleID, builder.build());
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, ConfigSundryConf.monthCardItemID, ConfigSundryConf.monthCardItemID, "月卡", monthCard.getCount(), count, bill, bill.getDesc());
        EventManager.postTaskActionEvent(roleID, TaskActionEnum.BUY_MONTH_CARD, 1);
        EventManager.commitRoleEvent(roleID);
        return monthCard.getCount();
    }

    /**
     *	添加经验
     *
     * @param roleID
     * @param exp
     */
    public long addExp(long roleID, long exp, ResourceBillEnum bill) {
        if(exp <= 0){
            return 0;
        }
        PlayerRole playerRole = playerService.addExp(roleID, exp);
        playerRoleDao.cacheUpdate(playerRole);
        EventManager.postPlayerAttrEvent(roleID, PlayerAttrEnum.EXP, playerRole.getExperience());
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.EXP.getKey(), PlayerAttrEnum.EXP.getKey(), "经验", playerRole.getExperience(), exp, bill, bill.getDesc());
        return playerRole.getExperience();
    }

    /**
     *	添加声望
     *
     * @param roleID
     * @param renown
     */
    public long addRenown(long roleID, long renown, ResourceBillEnum bill) {
        if(renown <= 0){
            return 0;
        }
        PlayerRole playerRole = playerService.addRenown(roleID, renown);
        playerRoleDao.cacheUpdate(playerRole);
        EventManager.postPlayerAttrEvent(roleID, PlayerAttrEnum.RENOWN, playerRole.getRenown());
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.RENOWN.getKey(), PlayerAttrEnum.RENOWN.getKey(), "声望", playerRole.getRenown(), renown, bill, bill.getDesc());
        return playerRole.getRenown();
    }

    /**
     *	添加馆藏
     *
     * @param roleID
     * @param showTable
     */
    public long addShowTable(long roleID, long showTable, ResourceBillEnum bill) {
        if(showTable <= 0){
            return 0;
        }
        PlayerRole playerRole = playerService.addShowTable(roleID, showTable);
        playerRoleDao.cacheUpdate(playerRole);
        EventManager.postPlayerAttrEvent(roleID, PlayerAttrEnum.SHOWTABLE, playerRole.getShowTable());
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.SHOWTABLE.getKey(), PlayerAttrEnum.SHOWTABLE.getKey(), "馆藏", playerRole.getShowTable(), showTable, bill, bill.getDesc());
        return playerRole.getShowTable();
    }

    /**
     *	扣除馆藏
     *
     * @param roleID
     * @param showTable
     */
    public long costShowTable(long roleID, long showTable, ResourceBillEnum bill) {
        PlayerRole playerRole = playerService.costShowTable(roleID, showTable);
        playerRoleDao.cacheUpdate(playerRole);
        EventManager.postPlayerAttrEvent(roleID, PlayerAttrEnum.SHOWTABLE, playerRole.getShowTable());
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.SHOWTABLE.getKey(), PlayerAttrEnum.SHOWTABLE.getKey(), "馆藏",playerRole.getShowTable(), -showTable, bill, bill.getDesc());
        return playerRole.getShowTable();
    }

    /**
     *	修改玩家生态值
     */
    public long changeEcology(long roleID, long change, ResourceBillEnum bill) {
        if(change <= 0){
            return 0;
        }
        PlayerRole playerRole = playerService.changeEcology(roleID, change);
        playerRoleDao.cacheUpdate(playerRole);
        EventManager.postPlayerAttrEvent(roleID, PlayerAttrEnum.ECOLOGY, playerRole.getEcology());
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.ECOLOGY.getKey(), PlayerAttrEnum.ECOLOGY.getKey(), "生态值", playerRole.getEcology(), change, bill, bill.getDesc());
        return playerRole.getEcology();
    }

    /**
     *	修改玩家繁荣度
     */
    public long changeBoom(long roleID, long change, ResourceBillEnum bill) {
        if(change <= 0){
            return 0;
        }
        PlayerRole playerRole = playerService.changeBoom(roleID, change);
        playerRoleDao.cacheUpdate(playerRole);
        EventManager.postPlayerAttrEvent(roleID, PlayerAttrEnum.BOOM, playerRole.getBoom());
        log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.BOOM.getKey(), PlayerAttrEnum.BOOM.getKey(), "繁荣度", playerRole.getBoom(), change, bill, bill.getDesc());
        return playerRole.getBoom();
    }

    /**
     *	修改玩家商会积分
     */
    public long changeGuildScore(long roleID, long change, ResourceBillEnum bill) {
    	if(change <= 0){
    		return 0;
    	}
    	PlayerRole playerRole = playerService.changeGuildScore(roleID, change);
    	playerRoleDao.cacheUpdate(playerRole);
        EventManager.postPlayerAttrEvent(roleID, PlayerAttrEnum.GUILDSCORE, playerRole.getGuildScore());
    	log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.GUILDSCORE.getKey(), PlayerAttrEnum.GUILDSCORE.getKey(), "商会积分", playerRole.getGuildScore(), change, bill, bill.getDesc());
        return playerRole.getGuildScore();
    }
    
    /**
     * 添加成就
     * @param roleID
     * @param action
     * @param count
     * @param bill
     */
    public long addAchievement(long roleID, AchievementActionEnum action, long count, ResourceBillEnum bill) {
    	PlayerRole playerRole = playerService.getPlayer(roleID);
    	ConfigAchievementConf conf = ConfManager.getInstance().getConfigAchievementConf();
    	ConfigAchievement configAchievement = conf.getAchievement(playerRole.getAchievementLevel());
    	if(configAchievement == null || configAchievement.getAction() != action.getType()) {
    		return 0;
    	}
    	playerRole = playerService.addAchievement(roleID, count, configAchievement, bill);
    	playerRoleDao.cacheUpdate(playerRole);
        EventManager.postPlayerAttrEvent(roleID, PlayerAttrEnum.ACHIEVEMENT, playerRole.getAchievement());
        return playerRole.getAchievement();
    }

    public void removeAllItems(long roleID) {
        List<PlayerItem1> list1 = playerItem1Dao.cacheLoadAll(roleID);
        if(list1 != null && list1.size() > 0){
            list1.forEach(playerItem1 -> {
                playerItem1.setItemCount(0);
                playerItem1Dao.cacheDelete(playerItem1.getId(), roleID);
                ServiceManager.getItemService().setItemCount(roleID, playerItem1.getItemID(), playerItem1.getItemCount());
            });
        }
        List<PlayerItem2> list2 = playerItem2Dao.cacheLoadAll(roleID);
        if(list2 != null && list2.size() > 0){
            list2.forEach(playerItem2 -> {
                playerItem2.setItemCount(0);
                playerItem2Dao.cacheDelete(playerItem2.getId(), roleID);
                ServiceManager.getItemService().setItemCount(roleID, playerItem2.getItemID(), playerItem2.getItemCount());
            });
        }
        List<PlayerItem3> list3 = playerItem3Dao.cacheLoadAll(roleID);
        if(list3 != null && list3.size() > 0){
            list3.forEach(playerItem3 -> {
                playerItem3.setItemCount(0);
                playerItem3Dao.cacheDelete(playerItem3.getId(), roleID);
                ServiceManager.getItemService().setItemCount(roleID, playerItem3.getItemID(), playerItem3.getItemCount());
            });
        }
        List<PlayerItem4> list4 = playerItem4Dao.cacheLoadAll(roleID);
        if(list4 != null && list4.size() > 0){
            list4.forEach(playerItem4 -> {
                playerItem4.setItemCount(0);
                playerItem4Dao.cacheDelete(playerItem4.getId(), roleID);
                ServiceManager.getItemService().setItemCount(roleID, playerItem4.getItemID(), playerItem4.getItemCount());
            });
        }
        List<PlayerItem5> list5 = playerItem5Dao.cacheLoadAll(roleID);
        if(list5 != null && list5.size() > 0){
            list5.forEach(playerItem5 -> {
                playerItem5.setItemCount(0);
                playerItem5Dao.cacheDelete(playerItem5.getId(), roleID);
                ServiceManager.getItemService().setItemCount(roleID, playerItem5.getItemID(), playerItem5.getItemCount());
            });
        }
        List<PlayerItem6> list6 = playerItem6Dao.cacheLoadAll(roleID);
        if(list6 != null && list6.size() > 0){
            list6.forEach(playerItem6 -> {
                playerItem6.setItemCount(0);
                playerItem6Dao.cacheDelete(playerItem6.getId(), roleID);
                ServiceManager.getItemService().setItemCount(roleID, playerItem6.getItemID(), playerItem6.getItemCount());
            });
        }
        List<PlayerItem7> list7 = playerItem7Dao.cacheLoadAll(roleID);
        if(list7 != null && list7.size() > 0){
            list7.forEach(playerItem7 -> {
                playerItem7.setItemCount(0);
                playerItem7Dao.cacheDelete(playerItem7.getId(), roleID);
                ServiceManager.getItemService().setItemCount(roleID, playerItem7.getItemID(), playerItem7.getItemCount());
            });
        }
        List<PlayerItem100> list100 = playerItem100Dao.cacheLoadAll(roleID);
        if(list100 != null && list100.size() > 0){
            list100.forEach(playerItem100 -> {
                playerItem100.setItemCount(0);
                playerItem100Dao.cacheDelete(playerItem100.getId(), roleID);
                ServiceManager.getItemService().setItemCount(roleID, playerItem100.getItemID(), playerItem100.getItemCount());
            });
        }
    }

    public void addAllItems(long roleID,int count) {
        List<PlayerItem1> list1 = playerItem1Dao.cacheLoadAll(roleID);
        if(list1 != null && list1.size() > 0){
            list1.forEach(playerItem1 -> {
                playerItem1.setItemCount(playerItem1.getItemCount() + count);
                playerItem1Dao.cacheUpdate(playerItem1, roleID);
                ServiceManager.getItemService().setItemCount(roleID, playerItem1.getItemID(), playerItem1.getItemCount());
            });
        }
        List<PlayerItem2> list2 = playerItem2Dao.cacheLoadAll(roleID);
        if(list2 != null && list2.size() > 0){
            list2.forEach(playerItem2 -> {
                playerItem2.setItemCount(playerItem2.getItemCount() + count);
                playerItem2Dao.cacheUpdate(playerItem2, roleID);
                ServiceManager.getItemService().setItemCount(roleID , playerItem2.getItemID(), playerItem2.getItemCount());
            });
        }
        List<PlayerItem3> list3 = playerItem3Dao.cacheLoadAll(roleID);
        if(list3 != null && list3.size() > 0){
            list3.forEach(playerItem3 -> {
                playerItem3.setItemCount(playerItem3.getItemCount() + count);
                playerItem3Dao.cacheUpdate(playerItem3, roleID);
                ServiceManager.getItemService().setItemCount(roleID , playerItem3.getItemID(), playerItem3.getItemCount());
            });
        }
        List<PlayerItem4> list4 = playerItem4Dao.cacheLoadAll(roleID);
        if(list4 != null && list4.size() > 0){
            list4.forEach(playerItem4 -> {
                playerItem4.setItemCount(playerItem4.getItemCount() + count);
                playerItem4Dao.cacheUpdate(playerItem4, roleID);
                ServiceManager.getItemService().setItemCount(roleID , playerItem4.getItemID(), playerItem4.getItemCount());
            });
        }
        List<PlayerItem5> list5 = playerItem5Dao.cacheLoadAll(roleID);
        if(list5 != null && list5.size() > 0){
            list5.forEach(playerItem5 -> {
                playerItem5.setItemCount(playerItem5.getItemCount() + count);
                playerItem5Dao.cacheUpdate(playerItem5, roleID);
                ServiceManager.getItemService().setItemCount(roleID , playerItem5.getItemID(), playerItem5.getItemCount());
            });
        }
        List<PlayerItem6> list6 = playerItem6Dao.cacheLoadAll(roleID);
        if(list6 != null && list6.size() > 0){
            list6.forEach(playerItem6 -> {
                playerItem6.setItemCount(playerItem6.getItemCount() + count);
                playerItem6Dao.cacheUpdate(playerItem6, roleID);
                ServiceManager.getItemService().setItemCount(roleID , playerItem6.getItemID(), playerItem6.getItemCount());
            });
        }
        List<PlayerItem7> list7 = playerItem7Dao.cacheLoadAll(roleID);
        if(list7 != null && list7.size() > 0){
            list7.forEach(playerItem7 -> {
                playerItem7.setItemCount(playerItem7.getItemCount() + count);
                playerItem7Dao.cacheUpdate(playerItem7, roleID);
                ServiceManager.getItemService().setItemCount(roleID , playerItem7.getItemID(), playerItem7.getItemCount());
            });
        }
        List<PlayerItem100> list100 = playerItem100Dao.cacheLoadAll(roleID);
        if(list100 != null && list100.size() > 0){
            list100.forEach(playerItem100 -> {
                playerItem100.setItemCount(playerItem100.getItemCount() + count);
                playerItem100Dao.cacheUpdate(playerItem100, roleID);
                ServiceManager.getItemService().setItemCount(roleID , playerItem100.getItemID(), playerItem100.getItemCount());
            });
        }
        EventManager.commitRoleEvent(roleID);
    }

    public List<GridItem> getItemList(long roleID, int type) {
        List<?> lists = getPlayerItemList(roleID, type);
        List<GridItem> resultList = Lists.newArrayListWithExpectedSize(lists.size());
        GridItem.Builder builder = GridItem.newBuilder();
        for (Object obj : lists) {
            IPlayerItem item = (IPlayerItem) obj;
            resultList.add(item.toGridItem(builder));
        }
        return resultList;
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

    public PlayerItem createPlayerItem(long roleID, int itemType){
        PlayerItem playerItem;
        switch (itemType) {
            case ItemType.type1:
                playerItem = new PlayerItem1(roleID);
                break;
            case ItemType.type2:
                playerItem = new PlayerItem2(roleID);
                break;
            case ItemType.type3:
                playerItem = new PlayerItem3(roleID);
                break;
            case ItemType.type4:
                playerItem = new PlayerItem4(roleID);
                break;
            case ItemType.type5:
                playerItem = new PlayerItem5(roleID);
                break;
            case ItemType.type6:
                playerItem = new PlayerItem6(roleID);
                break;
            case ItemType.type7:
                playerItem = new PlayerItem7(roleID);
                break;
            case ItemType.type100:
            default:
                playerItem = new PlayerItem100(roleID);
                break;
        }
        return playerItem;
    }

    public List<?> getPlayerItemList(long roleID, int type) {
        List<?> lists = new ArrayList<>();
        switch (type) {
            case ItemType.type1:
                lists = SpringContext.getBean(PlayerItem1Dao.class).cacheLoadAll(roleID);
                break;
            case ItemType.type2:
                lists = SpringContext.getBean(PlayerItem2Dao.class).cacheLoadAll(roleID);
                break;
            case ItemType.type3:
                lists = SpringContext.getBean(PlayerItem3Dao.class).cacheLoadAll(roleID);
                break;
            case ItemType.type4:
                lists = SpringContext.getBean(PlayerItem4Dao.class).cacheLoadAll(roleID);
                break;
            case ItemType.type5:
                lists = SpringContext.getBean(PlayerItem5Dao.class).cacheLoadAll(roleID);
                break;
            case ItemType.type6:
                lists = SpringContext.getBean(PlayerItem6Dao.class).cacheLoadAll(roleID);
                break;
            case ItemType.type7:
                lists = SpringContext.getBean(PlayerItem7Dao.class).cacheLoadAll(roleID);
                break;
            case ItemType.type100:
                lists = SpringContext.getBean(PlayerItem100Dao.class).cacheLoadAll(roleID);
                break;
        }
        return lists;
    }

    public BaseCacheDao getRobotItemDao(int itemType) {
        BaseCacheDao itemDao = null;
        switch (itemType) {
            case ItemType.type1:
                itemDao = SpringContext.getBean(RobotItem1Dao.class);
                break;
            case ItemType.type2:
                itemDao = SpringContext.getBean(RobotItem2Dao.class);;
                break;
            case ItemType.type3:
                itemDao = SpringContext.getBean(RobotItem3Dao.class);;
                break;
            case ItemType.type4:
                itemDao = SpringContext.getBean(RobotItem4Dao.class);;
                break;
            case ItemType.type5:
                itemDao = SpringContext.getBean(RobotItem5Dao.class);;
                break;
            case ItemType.type6:
                itemDao = SpringContext.getBean(RobotItem6Dao.class);;
                break;
            case ItemType.type7:
                itemDao = SpringContext.getBean(RobotItem7Dao.class);;
                break;
            case ItemType.type100:
            default:
                itemDao = SpringContext.getBean(RobotItem100Dao.class);;
                break;
        }
        return itemDao;
    }

    public RobotItem createRobotItem(long roleID, int itemType){
        RobotItem robotItem;
        switch (itemType) {
            case ItemType.type1:
                robotItem = new RobotItem1(roleID);
                break;
            case ItemType.type2:
                robotItem = new RobotItem2(roleID);
                break;
            case ItemType.type3:
                robotItem = new RobotItem3(roleID);
                break;
            case ItemType.type4:
                robotItem = new RobotItem4(roleID);
                break;
            case ItemType.type5:
                robotItem = new RobotItem5(roleID);
                break;
            case ItemType.type6:
                robotItem = new RobotItem6(roleID);
                break;
            case ItemType.type7:
                robotItem = new RobotItem7(roleID);
                break;
            case ItemType.type100:
            default:
                robotItem = new RobotItem100(roleID);
                break;
        }
        return robotItem;
    }

    public List<?> getRobotItemList(long roleID, int type) {
        List<?> lists = new ArrayList<>();
        switch (type) {
            case ItemType.type1:
                lists = SpringContext.getBean(RobotItem1Dao.class).cacheLoadAll(roleID);
                break;
            case ItemType.type2:
                lists = SpringContext.getBean(RobotItem2Dao.class).cacheLoadAll(roleID);
                break;
            case ItemType.type3:
                lists = SpringContext.getBean(RobotItem3Dao.class).cacheLoadAll(roleID);
                break;
            case ItemType.type4:
                lists = SpringContext.getBean(RobotItem4Dao.class).cacheLoadAll(roleID);
                break;
            case ItemType.type5:
                lists = SpringContext.getBean(RobotItem5Dao.class).cacheLoadAll(roleID);
                break;
            case ItemType.type6:
                lists = SpringContext.getBean(RobotItem6Dao.class).cacheLoadAll(roleID);
                break;
            case ItemType.type7:
                lists = SpringContext.getBean(RobotItem7Dao.class).cacheLoadAll(roleID);
                break;
            case ItemType.type100:
            default:
                lists = SpringContext.getBean(RobotItem100Dao.class).cacheLoadAll(roleID);
                break;
        }
        return lists;
    }
}
