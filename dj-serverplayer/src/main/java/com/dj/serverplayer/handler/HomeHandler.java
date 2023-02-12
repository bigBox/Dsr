package com.dj.serverplayer.handler;

import com.dj.domain.config.*;
import com.dj.domain.entity.player.PlayerCollection;
import com.dj.domain.entity.player.PlayerFactory;
import com.dj.domain.entity.player.PlayerObstacle;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.collection.CollectionInfo;
import com.dj.protobuf.collection.CollectionItem;
import com.dj.protobuf.collection.CollectionListReq;
import com.dj.protobuf.collection.CollectionState;
import com.dj.protobuf.mall.BuyType;
import com.dj.protobuf.mall.GoodDescription;
import com.dj.protobuf.mall.MallBuyReq;
import com.dj.protobuf.mall.MallListReq;
import com.dj.protobuf.scene.ScenePosUpdateReq;
import com.dj.servercore.conf.*;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.EventManager;
import com.dj.serverplayer.manager.ServiceManager;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author zcq
 * @description 主页业务处理
 * @date 2019年4月19日
 */
@Slf4j
@Component
public class HomeHandler extends BaseHandler {
    /**
     *	更新建筑位置
     *
     * @param roleID
     * @param req
     */
    public void scenePosUpdate(long roleID, ScenePosUpdateReq req) {
        ConfigFactoryConf conf = ConfManager.getInstance().getConfigFactoryConf();
		if(conf == null){
			log.error("scenePosUpdate ConfigFactoryConf conf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
        ConfigFactory configFactory = conf.getFactory(req.getId());
		if(configFactory == null){
			log.error("scenePosUpdate ConfigFactoryConf configFactory == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		checkLevelEnough(roleID, configFactory.getLevelRequire());
		QueryParamMap queryParams = new QueryParamMap();
		queryParams.put("roleID",roleID);
		queryParams.put("factoryID", req.getId());
        PlayerFactory playerFactory = playerFactoryDao.cacheSelect(queryParams, roleID);
        if (playerFactory == null) {
            playerFactory = new PlayerFactory(roleID);
            playerFactory.setFactoryID(req.getId());
            playerFactory.setShowLevel(configFactory.getShowLevel());
            playerFactory.setPointX(req.getX());
            playerFactory.setPointY(req.getY());
            playerFactoryDao.cacheInsert(playerFactory, roleID);
        } else {
            playerFactory.setPointX(req.getX());
            playerFactory.setPointY(req.getY());
            playerFactoryDao.cacheUpdate(playerFactory, roleID);
        }
		List<PlayerFactory> playerFactories = playerFactoryDao.cacheLoadAll(roleID);
		if(playerFactories != null && playerFactories.size() > 0) {
			gameService.setFactory(roleID, playerFactories);
		}
		if(configFactory.getID()==3020) {
			ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.PRODUCE_GOODS);
			if (configTasks != null) {
				EventManager.postTaskActionEvent(roleID, TaskActionEnum.PRODUCE_GOODS, 1);
			}
		}

    }

    /**
     *	开垦荒地
     *
     * @param roleID
     * @param index
     */
    public void obstaclesOpenup(long roleID, int index) {
        ConfigObstaclesConf conf = ConfManager.getInstance().getConfigObstaclesConf();
		if(conf == null){
			log.error("obstaclesOpenup ConfigObstaclesConf conf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
        ConfigObstacleCellConf cellConf = ConfManager.getInstance().getConfigObstacleCellConf();
		if(cellConf == null){
			log.error("scenePosUpdate ConfigObstacleCellConf cellConf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
        ConfigObstacles obstacles = conf.getObstacles(index);
        ConfigObstacleCell cell = cellConf.getCell(obstacles.getType());
        // 消耗道具
        costItem(roleID, cell.getItemCost(), cell.getCostNum(), ResourceBillEnum.obstaclesOpenup);
        PlayerObstacle playerObstacle = new PlayerObstacle(roleID);
        playerObstacle.setObstacleID(index);
        playerObstacle.setIsOpen(obstacles.getIsOpen());
        playerObstacleDao.cacheInsert(playerObstacle, roleID);
		List<PlayerObstacle> playerObstacles = playerObstacleDao.cacheLoadAll(roleID);
		if(playerObstacles != null && playerObstacles.size() > 0) {
			gameService.setObstacle(roleID, playerObstacles);
		}
		EventManager.postTaskActionEvent(roleID, TaskActionEnum.EXPAND_CAMP, 1);
		EventManager.commitRoleEvent(roleID);
    }

    /**
     *	获取宝贝列表
     *
     * @param roleID
     * @return
     */
    public Map<Integer, CollectionInfo> collectionList(long roleID, CollectionListReq req) {
    	Map<Integer, CollectionInfo> infos = Maps.newHashMapWithExpectedSize(10);
    	CollectionInfo.Builder infoBuilder = CollectionInfo.newBuilder();
    	CollectionItem.Builder itemBuilder = CollectionItem.newBuilder();
    	// 配置
    	ConfigCollectionDataConf dataConf = ConfManager.getInstance().getConfigCollectionDataConf();
		if(dataConf == null){
			log.error("collectionList ConfigCollectionDataConf dataConf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
    	ConfigCollectionItemsConf itemsConf = ConfManager.getInstance().getConfigCollectionItemsConf();
		if(itemsConf == null){
			log.error("collectionList ConfigCollectionItemsConf itemsConf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
    	Map<Integer, Map<Integer, ConfigCollectionItems>> antiqueMap = itemsConf.getAntiqueMap();
		if((ObjectUtils.isEmpty(req.getRoleId()))||(roleID == req.getRoleId())){
			if (buffService.getNpcSkill(roleID).getSkillID() == 12) {
				//给玩家的宝贝套装补齐两套
				ImmutableMap<Integer, ConfigCollectionItems> collectionItemMap = itemsConf.getCollectionItemsMap();
				for (Map.Entry<Integer, ConfigCollectionItems> entry : collectionItemMap.entrySet()) {
					addItem(roleID, entry.getKey(), 2, ResourceBillEnum.npcSkill12, true);
				}
				buffService.setNpcSkill(roleID, 0, 0);
			}
		}else {
			roleID = req.getRoleId();
		}

    	for (Map.Entry<Integer, Map<Integer, ConfigCollectionItems>> entry : antiqueMap.entrySet()) {
    		//ConfigCollectionData dataConfig = dataConf.getCollectionData(entry.getKey());
    		//if(dataConfig.getType() == type) {
    			infoBuilder.clear();
    			infoBuilder.setState(CollectionState.Gather_All);
    			infoBuilder.setId(entry.getKey());
    			infoBuilder.setReward(0);
			    long antiqueCount = 0;
    			for(Map.Entry<Integer, ConfigCollectionItems> itemEntry : entry.getValue().entrySet()) {
    				long itemCount = setCollectionItem(roleID, itemEntry.getValue().getID(), infoBuilder, itemBuilder);
    				log.info("itemID {}, itemCount {}", itemEntry.getValue().getID(), itemCount);
    				if(itemCount > 0 && (antiqueCount == 0 || itemCount < antiqueCount)) {
    	    			antiqueCount = itemCount;
    	    		}
    			}
    			log.info("{} antiqueCount {}", entry.getKey(), antiqueCount);
    			// 集齐
    			if(infoBuilder.getState() == CollectionState.Gather_All) {
    				infoBuilder.setReward((int)antiqueCount);
    			}
    			infos.put(entry.getKey(), infoBuilder.build());
    		//}
		}
        return infos;
    }
    
    public long setCollectionItem(long roleID, int itemID, CollectionInfo.Builder infoBuilder, CollectionItem.Builder itemBuilder) {
    	if(itemID > 0) {
    		itemBuilder.setId(itemID);
    		long itemCount = ServiceManager.getItemService().getItemCount(roleID, itemID);
    		itemBuilder.setCount((int)itemCount);
    		if(itemCount <= 0) {
    			infoBuilder.setState(CollectionState.Gray);
    		}
    		infoBuilder.putItems(itemID, itemBuilder.build());
    		return itemCount;
    	}
    	return 0;
    }
    
    /**
     * 兑换宝贝收集奖励
     * @param roleID
     * @param id
     */
    public void collectionExchangeReward(long roleID, int id) {
    	// 是否收集齐
    	ConfigCollectionItemsConf itemsConf = ConfManager.getInstance().getConfigCollectionItemsConf();
		if(itemsConf == null){
			log.error("collectionExchangeReward ConfigCollectionItemsConf itemsConf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
    	Map<Integer, ConfigCollectionItems> antique = itemsConf.getAntique(id);
    	for(Map.Entry<Integer, ConfigCollectionItems> itemEntry : antique.entrySet()) {
    		checkCollectionItem(roleID, itemEntry.getValue().getID());
		}
    	// 扣减收集个数
    	for(Map.Entry<Integer, ConfigCollectionItems> itemEntry : antique.entrySet()) {
    		costItem(roleID, itemEntry.getValue().getID(), 1, ResourceBillEnum.collectionExchangeReward, false);
    	}
    	// 获取奖励
    	ConfigCollectionDataConf conf = ConfManager.getInstance().getConfigCollectionDataConf();
		if(conf == null){
			log.error("collectionExchangeReward ConfigCollectionDataConf conf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
    	ConfigCollectionData config = conf.getCollectionData(id);
    	addGold(roleID, config.getRewardGold(), ResourceBillEnum.collectionExchangeReward);
    	// 更新领奖次数
		QueryParamMap queryParams = new QueryParamMap();
		queryParams.put("roleID",roleID);
		queryParams.put("collectionID", id);
    	PlayerCollection playerCollection = playerCollectionDao.cacheSelect(queryParams, roleID);
    	if(playerCollection != null) {
    		playerCollection.setReward(playerCollection.getReward()+1);
    		playerCollectionDao.cacheUpdate(playerCollection, roleID);
    	}else {
    		playerCollection = new PlayerCollection(roleID);
    		//playerCollection.setId(readModuleID(TableID.TABLE_COLLECTION));
    		playerCollection.setCollectionID(id);
    		playerCollection.setReward(1);
    		playerCollectionDao.cacheInsert(playerCollection, roleID);
    	}
		EventManager.postTaskActionEvent(roleID, TaskActionEnum.COLLECTION_REWARD, 1);
		EventManager.commitRoleEvent(roleID);
	}
    
    private long checkCollectionItem(long roleID, int itemID) {
    	if(itemID > 0) {
			long itemCount = ServiceManager.getItemService().getItemCount(roleID, itemID);
    		if(itemCount <= 0) {
    			throw new CommonException(ErrorID.COLLECTION_NOT_GATHER_ALL);
    		}
    		return itemCount;
    	}
    	return 0;
    }
    
    /**
     *	商城列表
     *
     * @param roleID
     * @param req
     * @return
     */
    public Map<Integer, GoodDescription> mallList(long roleID, MallListReq req) {
        ConfigMiniMallConf conf = ConfManager.getInstance().getConfigMiniMallConf();
		if(conf == null){
			log.error("mallList ConfigMiniMallConf conf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
        ImmutableMap<Integer, ConfigMiniMall> miniMallMap = conf.getMiniMallMap();
        Map<Integer, GoodDescription> goodInfos = Maps.newHashMapWithExpectedSize(miniMallMap.size());
        GoodDescription.Builder goodDescription = GoodDescription.newBuilder();
        for (ConfigMiniMall item : miniMallMap.values()) {
            goodDescription.setId(item.getId());
            goodInfos.put(item.getId(), goodDescription.build());
        }
        return goodInfos;
    }

    /**
     *	商城购买
     *
     * @param roleID
     * @param req
     */
    public void mallBuy(long roleID, MallBuyReq req) {
        ConfigMiniMallConf conf = ConfManager.getInstance().getConfigMiniMallConf();
		if(conf == null){
			log.error("mallBuy ConfigMiniMallConf conf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
        for (Map.Entry<Integer, Integer> entry : req.getItemsMap().entrySet()) {
            ConfigMiniMall config = conf.getMiniMall(entry.getKey());
            if(req.getBuyType() == BuyType.Diamond ) {
            	// 钻石购买
            	costDiamond(roleID, config.getPrice(), ResourceBillEnum.mallBuy);
            } else {
            	// 商会积分兑换
            	if(config.getGuildScore() == 0) {
            		throw new CommonException(ErrorID.COMMON_CONFIG_ERROR);
            	}
            	PlayerRole playerRole = playerService.getPlayer(roleID);
            	if(playerRole.getGuildScore() >= config.getGuildScore()) {
            		changeGuildScore(roleID, -config.getGuildScore(), ResourceBillEnum.mallBuy);
            	} else {
            		throw new CommonException(ErrorID.COMMON_PLAYER_GUILD_SCORE_LESS);
            	}
            }
            addItem(roleID, config.getItemId(), config.getNumPerPackage()*entry.getValue(), ResourceBillEnum.mallBuy, false);
        }
    }
}
