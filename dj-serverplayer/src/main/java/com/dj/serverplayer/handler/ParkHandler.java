package com.dj.serverplayer.handler;

import com.dj.domain.config.*;
import com.dj.domain.constant.ConstantGame;
import com.dj.domain.data.game.ParkAnimalUnit;
import com.dj.domain.data.game.ParkCellUnit;
import com.dj.domain.data.game.ParkFishUnit;
import com.dj.domain.data.game.ZooAnimalUnit;
import com.dj.domain.entity.player.PlayerFarm;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.park.*;
import com.dj.serverapi.dao.PlayerFarmDao;
import com.dj.servercore.conf.*;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.helper.QueueHelper;
import com.dj.serverplayer.manager.ChannelManager;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.EventManager;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zcq
 * @description 生态园业务处理
 * @date 2019年5月14日
 */
@Component
@Slf4j
public class ParkHandler extends BaseHandler {
    /**
     *	放置庄稼
     *
     * @param roleID
     * @param req
     */
    public void parkPlaceCrops(long roleID, ParkPlaceCropsReq req) {
        if (ConstantGame.checkInvalid(req.getX(), req.getY())) {
            throw new CommonException(ErrorID.PARK_CANT_PLACE_INVALID);
        }
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("roleID",roleID);
        queryParams.put("x",req.getX());
        queryParams.put("y",req.getY());
        if(ObjectUtils.isEmpty(playerFarmDao)){
            playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
        }
        PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
        if (playerFarm != null && playerFarm.getSeed() > 0) {
            log.error("parkPlaceCrops PlayerFarm playerFarm == null roleID:{}", roleID);
            throw new CommonException(ErrorID.FARM_NOT_CLEARING);
        }
        // 检查玩家等级
        ConfigFarmCultureConf farmCultureConf = ConfManager.getInstance().getConfigFarmCultureConf();
        if(farmCultureConf == null){
            log.error("parkPlaceCrops ConfigFarmCultureConf farmCultureConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigFarmCulture config = farmCultureConf.getPlant(req.getPlantID());
        if(ObjectUtils.isEmpty(config)){
            log.error("parkPlaceCrops ConfigFarmCulture config == null roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_CONFIG_ERROR);
        }
        checkLevelEnough(roleID, config.getNeedLevel());
        // 检查金币或者植物是否足够
        ConfigItemsConf itemsConf = ConfManager.getInstance().getConfigItemsConf();
        if(itemsConf == null){
            log.error("parkPlaceCrops ConfigItemsConf itemsConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigItems item = itemsConf.getItem(req.getPlantID());
        if(ObjectUtils.isEmpty(item)){
            log.error("parkPlaceCrops ConfigItems item == null roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_CONFIG_ERROR);
        }
        if(config.getCostGold() > 0) {
            checkGoldEnough(roleID, config.getCostGold());
            // 扣除金币或植物
            costGold(roleID, config.getCostGold(), ResourceBillEnum.parkPlaceCrops);
        }
        // 放置庄稼
        ParkCellUnit cell = parkService.parkPlaceCrops(roleID, req.getX(), req.getY(), req.getPlantID(), config);
        // 添加动物吃草队列
        QueueHelper.getInstance().addGrazeQueue(roleID);
        // 生态园地图变化推送
        List<ParkCell> cells = Lists.newArrayListWithExpectedSize(1);
        cells.add(cell.toParkCell());
        ParkCellNtf.Builder builder = ParkCellNtf.newBuilder();
        builder.addAllCells(cells);
        PlayerRole playerRole = playerService.getPlayer(roleID);
        ChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), builder.build());
    }

    /**
     *	放置植物
     *
     * @param roleID
     * @param req
     */
    public void parkPlacePlant(long roleID, ParkPlacePlantReq req) {
        if (ConstantGame.checkInvalid(req.getX(), req.getY())) {
            throw new CommonException(ErrorID.PARK_CANT_PLACE_INVALID);
        }
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("roleID",roleID);
        queryParams.put("x",req.getX());
        queryParams.put("y",req.getY());
        if(ObjectUtils.isEmpty(playerFarmDao)){
            playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
        }
        PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
        if (playerFarm != null && playerFarm.getSeed() > 0) {
            log.error("parkPlacePlant PlayerFarm playerFarm == null roleID:{}", roleID);
            throw new CommonException(ErrorID.FARM_NOT_CLEARING);
        }
        // 检查玩家等级
        ConfigFarmParkPlantConf plantConf = ConfManager.getInstance().getConfigFarmParkPlantConf();
        if(plantConf == null){
            log.error("parkPlacePlant ConfigFarmParkPlantConf plantConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigFarmParkPlant config = plantConf.getPlant(req.getPlantID());
        if(ObjectUtils.isEmpty(config)){
            log.error("parkPlacePlant ConfigFarmParkPlant config == null roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_CONFIG_ERROR);
        }
        checkLevelEnough(roleID, config.getNeedLevel());
        // 检查金币或者植物是否足够
        ConfigItemsConf itemsConf = ConfManager.getInstance().getConfigItemsConf();
        if(itemsConf == null){
            log.error("parkPlacePlant ConfigItemsConf itemsConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigItems item = itemsConf.getItem(req.getPlantID());
        if(ObjectUtils.isEmpty(item)){
            log.error("parkPlacePlant ConfigItems item == null roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_CONFIG_ERROR);
        }
        if(config.getCostGold() > 0) {
            checkGoldEnough(roleID, config.getCostGold());
            // 扣除金币或植物
            costGold(roleID, config.getCostGold(), ResourceBillEnum.parkPlacePlant);
        }
        if(config.getSeedNum() > 0) {
            checkItemEnough(roleID, req.getPlantID(), config.getSeedNum());
            costItem(roleID, req.getPlantID(), config.getSeedNum(), ResourceBillEnum.parkPlacePlant);
        }
        // 放置植物
        ParkCellUnit cell = parkService.parkPlacePlant(roleID, req.getX(), req.getY(), req.getPlantID(), config);
        // 添加动物吃草队列
        QueueHelper.getInstance().addGrazeQueue(roleID);
        // 生态园地图变化推送
        List<ParkCell> cells = Lists.newArrayListWithExpectedSize(1);
        cells.add(cell.toParkCell());
        ParkCellNtf.Builder builder = ParkCellNtf.newBuilder();
        builder.addAllCells(cells);
        PlayerRole playerRole = playerService.getPlayer(roleID);
        ChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), builder.build());
    }
    /**
     *	放置树木
     *
     * @param roleID
     * @param req
     */
    public void parkPlaceTree(long roleID, ParkPlaceTreeReq req) {
        if (ConstantGame.checkInvalid(req.getX(), req.getY())) {
            throw new CommonException(ErrorID.PARK_CANT_PLACE_INVALID);
        }
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("roleID",roleID);
        queryParams.put("x",req.getX());
        queryParams.put("y",req.getY());
        if(ObjectUtils.isEmpty(playerFarmDao)){
            playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
        }
        PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
        if (playerFarm != null && playerFarm.getSeed() > 0) {
            log.error("parkPlaceTree PlayerFarm playerFarm != null roleID:{}", roleID);
            throw new CommonException(ErrorID.FARM_NOT_CLEARING);
        }
        // 检查玩家等级
        ConfigFarmParkTreeConf treeConf = ConfManager.getInstance().getConfigFarmParkTreeConf();
        if(treeConf == null){
            log.error("parkPlaceTree ConfigFarmParkTreeConf treeConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigFarmParkTree config = treeConf.getPlant(req.getPlantID());
        if(ObjectUtils.isEmpty(config)){
            log.error("parkPlaceTree ConfigFarmParkTree config == null roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_CONFIG_ERROR);
        }
        checkLevelEnough(roleID, config.getNeedLevel());
        // 检查金币或者植物是否足够
        ConfigItemsConf itemsConf = ConfManager.getInstance().getConfigItemsConf();
        if(itemsConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigItems item = itemsConf.getItem(req.getPlantID());
        if(ObjectUtils.isEmpty(item)){
            log.error("parkPlaceTree ConfigItems item == null roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_CONFIG_ERROR);
        }
        if(config.getCostGold() > 0) {
            checkGoldEnough(roleID, config.getCostGold());
            // 扣除金币或植物
            costGold(roleID, config.getCostGold(), ResourceBillEnum.parkPlaceTree);
        }
        // 放置树木
        ParkCellUnit cell = parkService.parkPlaceTree(roleID, req.getX(), req.getY(), req.getPlantID(), config);
        // 添加动物吃草队列
        //QueueHelper.getInstance().addGrazeQueue(roleID);
        // 生态园地图变化推送
        List<ParkCell> cells = Lists.newArrayListWithExpectedSize(1);
        cells.add(cell.toParkCell());
        ParkCellNtf.Builder builder = ParkCellNtf.newBuilder();
        builder.addAllCells(cells);
        PlayerRole playerRole = playerService.getPlayer(roleID);
        ChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), builder.build());
    }

    /**
     *	放置动物
     *
     * @param roleID
     * @param req
     */
    public void parkPlaceAnimal(long roleID, ParkPlaceAnimalReq req, ParkPlaceAnimalRsp.Builder builder) {
        ConfigFarmParkAnimalConf animalConf = ConfManager.getInstance().getConfigFarmParkAnimalConf();
        ConfigFarmParkAnimal config = animalConf.getAnimal(req.getAnimalID());
        // 检查玩家等级
        if(config.getNeedLevel() > 0) {
            checkLevelEnough(roleID, config.getNeedLevel());
        }
        // 检查动物需要的人口
        if (config.getCostEcology() > 0) {
            int useEcology = parkService.getUseEcology(roleID);
            PlayerRole playerRole = playerService.getPlayer(roleID);
            if (useEcology + config.getCostEcology() > playerRole.getEcology()) {
                throw new CommonException(ErrorID.COMMON_PLAYER_ECOLOGY_LESS);
            }
        }
        // 检查金币或动物是否足够
        ConfigItemsConf conf = ConfManager.getInstance().getConfigItemsConf();
        ConfigItems item = conf.getItem(req.getAnimalID());
        if (ObjectUtils.isEmpty(item) || item.getWarehouseType() == 100) {
            checkGoldEnough(roleID, config.getCostGold());
        } else {
            checkItemEnough(roleID, req.getAnimalID(), 1);
        }
        // 动物来源
        int source = 1;
//        if (ConfigSundryConf.recordItemSource.contains(req.getAnimalID())) {
//            source = itemService.getItemSource(roleID, req.getAnimalID());
//        }
        // 放置动物
        ParkAnimalUnit animal = parkService.parkPlaceAnimal(roleID, req.getAnimalID(), config, source);
        // 扣除金币或动物
        if (item == null || item.getWarehouseType() == 100) {
            costGold(roleID, config.getCostGold(), ResourceBillEnum.parkPlaceAnimal);
        } else {
            costItem(roleID, req.getAnimalID(), 1, ResourceBillEnum.parkPlaceAnimal);
        }
        // 增加繁荣度
        if (config.getAddBoom() > 0) {
            changeBoom(roleID, config.getAddBoom(), ResourceBillEnum.parkPlaceAnimal);
        }
        ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.PARK_ANIMALS);
        if (configTasks != null) {
            EventManager.postTaskActionEvent(roleID, TaskActionEnum.PARK_ANIMALS, 1);
            EventManager.commitRoleEvent(roleID);
        }
        // 添加动物吃草队列
        QueueHelper.getInstance().addGrazeQueue(roleID);
        // 返回数据给前端
        ParkAnimal parkAnimal = animal.toParkAnimal(config);
        builder.setAnimal(parkAnimal);
        if (config.getCostEcology() > 0) {
            int useEcology = parkService.getUseEcology(roleID);
            builder.setUseEcology(useEcology);
        }
    }

    public void zooPlaceAnimal(long roleID, ZooPlaceAnimalReq req, ZooPlaceAnimalRsp.Builder builder) {
        ConfigFarmZooAnimalConf animalConf = ConfManager.getInstance().getConfigFarmZooAnimalConf();
        ConfigFarmZooAnimal config = animalConf.getAnimal(req.getAnimalID());
        // 检查玩家等级
        if(config.getNeedLevel() > 0) {
            checkLevelEnough(roleID, config.getNeedLevel());
        }
        // 检查动物需要的人口
        if (config.getCostEcology() > 0){
            int useEcology = parkService.getUseEcology(roleID);
            PlayerRole playerRole = playerService.getPlayer(roleID);
            if (useEcology + config.getCostEcology() > playerRole.getEcology()) {
                throw new CommonException(ErrorID.COMMON_PLAYER_ECOLOGY_LESS);
            }
        }
        // 检查金币或动物是否足够
        ConfigItemsConf conf = ConfManager.getInstance().getConfigItemsConf();
        ConfigItems item = conf.getItem(req.getAnimalID());
        if (ObjectUtils.isEmpty(item) || item.getWarehouseType() == 100) {
            checkGoldEnough(roleID, config.getCostGold());
        } else {
            checkItemEnough(roleID, req.getAnimalID(), 1);
        }
        // 动物来源
        int source = 0;
        if (ConfigSundryConf.recordItemSource.contains(req.getAnimalID())) {
            source = itemService.getItemSource(roleID, req.getAnimalID());
        }
        // 放置动物
        ZooAnimalUnit zooAnimalUnit = parkService.zooPlaceAnimal(roleID, config.getProductId(), config, source);
        // 扣除金币或动物
        if (item == null || item.getWarehouseType() == 100) {
            costGold(roleID, config.getCostGold(), ResourceBillEnum.parkPlaceAnimal);
        } else {
            costItem(roleID, req.getAnimalID(), 1, ResourceBillEnum.parkPlaceAnimal);
        }
        addItem(roleID, config.getProductId()+"-"+config.getProductNum(),  ResourceBillEnum.parkPlaceAnimal, false);
        // 增加繁荣度
        if (config.getAddBoom() > 0) {
            changeBoom(roleID, config.getAddBoom(), ResourceBillEnum.parkPlaceAnimal);
        }
        ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.CONJURE_ANIMALS);
        if (configTasks != null) {
            taskHandler.doTaskNeedItem(roleID, req.getAnimalID(), 1);
            EventManager.postTaskActionEvent(roleID, TaskActionEnum.CONJURE_ANIMALS, 1);
            EventManager.commitRoleEvent(roleID);
        }
        // 添加动物吃草队列
        // QueueHelper.getInstance().addGrazeQueue(roleID);
        // 返回数据给前端
        ZooAnimal.Builder animalBuilder = ZooAnimal.newBuilder();
        ZooAnimal zooAnimal = zooAnimalUnit.toZooAnimal(animalBuilder, DateUtil.getCurrentDate(), config);
        builder.setAnimal(zooAnimal);
        if (config.getCostEcology() > 0){
            int useEcology = parkService.getUseEcology(roleID);
            builder.setUseEcology(useEcology);
        }
    }

    /**
     *	农场收获
     *
     * @param roleID
     * @param successPoints
     * @return
     */
    public void farmActionHarvest(long roleID,List<CellPoint>  successPoints) {
        Date nowDate = DateUtil.getCurrentDate();
        for(CellPoint cellPoint : successPoints){
            QueryParamMap queryParams = new QueryParamMap();
            queryParams.put("roleID",roleID);
            queryParams.put("x",cellPoint.getX());
            queryParams.put("y",cellPoint.getY());
            if(ObjectUtils.isEmpty(playerFarmDao)){
                playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
            }
            PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
            if (playerFarm != null && playerFarm.getSeed() > 0) {
                Date endDate = new Date();
                ConfigFarmCultureConf cropsConf = ConfManager.getInstance().getConfigFarmCultureConf();
                ConfigFarmCulture cropsConfig = cropsConf.getPlant(playerFarm.getSeed());
                if(ObjectUtils.isNotEmpty(cropsConfig)){
                    checkLevelEnough(roleID, cropsConfig.getNeedLevel());
                    endDate = DateUtil.plusTime(playerFarm.getPlaintTime(), TimeUnit.SECONDS, cropsConfig.getCookingTime() * DateUtil.ONEMINUTE_2_SECOND);
                }
                ConfigFarmParkPlantConf plantConf = ConfManager.getInstance().getConfigFarmParkPlantConf();
                ConfigFarmParkPlant plantConfig = plantConf.getPlant(playerFarm.getSeed());
                if(ObjectUtils.isNotEmpty(plantConfig)){
                    checkLevelEnough(roleID, plantConfig.getNeedLevel());
                    endDate = DateUtil.plusTime(playerFarm.getPlaintTime(), TimeUnit.SECONDS, plantConfig.getCookingTime() * DateUtil.ONEMINUTE_2_SECOND);
                }
                ConfigFarmParkTreeConf treeConf = ConfManager.getInstance().getConfigFarmParkTreeConf();
                ConfigFarmParkTree treeConfig = treeConf.getPlant(playerFarm.getSeed());
                if(ObjectUtils.isNotEmpty(treeConfig)){
                    checkLevelEnough(roleID, treeConfig.getNeedLevel());
                    endDate = DateUtil.plusTime(playerFarm.getPlaintTime(), TimeUnit.SECONDS, treeConfig.getCookingTime() * DateUtil.ONEMINUTE_2_SECOND);
                }
                // 结束时间小于等于当前时间
                if (endDate.getTime() <= nowDate.getTime()) {
                    // 成熟了就收获
                    playerFarm.setSeed(0);
                    playerFarmDao.cacheUpdate(playerFarm, roleID);
                }
            }
        }
        // 更新到redis
        //List<PlayerFarm> farms = playerFarmDao.cacheLoadAll(roleID);
        //if(farms != null && farms.size() > 0) {
        //    parkService.setFarm(roleID, farms);
        //}
        return;
    }
    /**
     *	收获庄稼
     *
     * @param roleID
     * @param req
     */
    public void parkHarvestCrops(long roleID, ParkHarvestCropsReq req, ParkHarvestCropsRsp.Builder builder) {
        List<CellPoint> successPoints = parkService.parkHarvestCorps(roleID, req.getPointsList(), config -> {
            if (config.getProductId() == 1) {
                addGold(roleID, config.getProductNum(), ResourceBillEnum.parkHarvestCrops);
            } else {
                addItem(roleID, config.getProductId(), config.getProductNum(), ResourceBillEnum.parkHarvestCrops, false);
            }
            addExp(roleID, config.getProductExp(), ResourceBillEnum.parkHarvestCrops);
        }, ecology -> {
            // 增长生态值
            changeEcology(roleID, ecology, ResourceBillEnum.parkHarvestCrops);
            EventManager.postTaskActionEvent(roleID, TaskActionEnum.PARK_PLANT_GREEN, ecology);
            EventManager.commitRoleEvent(roleID);
        });
        farmActionHarvest(roleID, successPoints);
        builder.addAllSuccessPoints(successPoints);
    }
    /**
     *	收获植物
     *
     * @param roleID
     * @param req
     */
    public void parkHarvestPlant(long roleID, ParkHarvestPlantReq req, ParkHarvestPlantRsp.Builder builder) {
        List<CellPoint> successPoints = parkService.parkHarvestPlant(roleID, req.getPointsList(), config -> {
            if (config.getProductId() == 1) {
                addGold(roleID, config.getProductNum(), ResourceBillEnum.parkHarvestPlant);
            } else {
                addItem(roleID, config.getProductId(), config.getProductNum(), ResourceBillEnum.parkHarvestPlant, false);
            }
            addExp(roleID, config.getProductExp(), ResourceBillEnum.parkHarvestPlant);
        }, ecology -> {
            // 增长生态值
            changeEcology(roleID, ecology, ResourceBillEnum.parkHarvestPlant);
            EventManager.postTaskActionEvent(roleID, TaskActionEnum.PARK_PLANT_GREEN, ecology);
            EventManager.commitRoleEvent(roleID);
        });
        farmActionHarvest(roleID, successPoints);
        builder.addAllSuccessPoints(successPoints);
    }
    /**
     *	收获树木
     *
     * @param roleID
     * @param req
     */
    public void parkHarvestTree(long roleID, ParkHarvestTreeReq req, ParkHarvestTreeRsp.Builder builder) {
        List<CellPoint> successPoints = parkService.parkHarvestTree(roleID, req.getPointsList(), config -> {
            if (config.getProductId() == 1) {
                addGold(roleID, config.getProductNum(), ResourceBillEnum.parkHarvestTree);
            } else {
                addItem(roleID, config.getProductId(), config.getProductNum(), ResourceBillEnum.parkHarvestTree, false);
            }
            addExp(roleID, config.getProductExp(), ResourceBillEnum.parkHarvestTree);
        }, ecology -> {
            // 增长生态值
            changeEcology(roleID, ecology, ResourceBillEnum.parkHarvestTree);
            EventManager.postTaskActionEvent(roleID, TaskActionEnum.PARK_PLANT_GREEN, ecology);
            EventManager.commitRoleEvent(roleID);
        });
        farmActionHarvest(roleID, successPoints);
        builder.addAllSuccessPoints(successPoints);
    }
    /**
     *	收获动物
     *
     * @param roleID
     * @param req
     */
    public void parkHarvestAnimal(long roleID, ParkHarvestAnimalReq req, ParkHarvestAnimalRsp.Builder builder) {
        List<AnimalPoint> successPoints = parkService.parkHarvestAnimal(roleID, req.getPointsList(), (config, wither) -> {
            if (config.getProductId() == 1) {
                addGold(roleID, config.getProductNum(), ResourceBillEnum.parkHarvestAnimal);
            } else {
                addItem(roleID, config.getProductId(), config.getProductNum(), ResourceBillEnum.parkHarvestAnimal, false);
            }
            addExp(roleID, config.getProductExp(), ResourceBillEnum.parkHarvestAnimal);
            //addRenown(roleID, config.getProductRenown(), ResourceBillEnum.parkHarvestAnimal);
            if (wither && config.getAddBoom() > 0) {
                //便便状态就减少繁荣度
                changeBoom(roleID, -config.getAddBoom(), ResourceBillEnum.parkHarvestAnimal);
            }
        });
        builder.addAllSuccessPoints(successPoints);
        int useEcology = parkService.getUseEcology(roleID);
        builder.setUseEcology(useEcology);
    }

    /**
     *	鱼塘放置鱼
     *
     * @param roleID
     * @param req
     */
    @SuppressWarnings("rawtypes")
	public void parkPlaceFish(long roleID, ParkPlaceFishReq req, ParkPlaceFishRsp.Builder builder) {
        int itemID = req.getFishID();
        int index = req.getIndex();

        ConfigPoolFishsConf conf = ConfManager.getInstance().getConfigPoolFishsConf();
        ConfigPoolFishs config = conf.getPoolFish(req.getFishID());
        // 检查玩家等级
        checkLevelEnough(roleID, config.getLevel());
        // 消耗类型1、消耗金币2、消耗种子
        if (config.getCostType() == 1) {
            checkGoldEnough(roleID, config.getSeedNum());
        } else {
            checkItemEnough(roleID, itemID, config.getSeedNum());
        }
        // 放置鱼
        ParkFishUnit fish = parkService.parkPlaceFish(roleID, itemID, index, config);
        // 扣除金币或种子
        if (config.getCostType() == 1) {
            costGold(roleID, config.getSeedNum(), ResourceBillEnum.parkPlaceFish);
        } else {
            long count = costItem(roleID, itemID, config.getSeedNum(), ResourceBillEnum.parkPlaceFish);
            builder.setFishCount((int)count);
            // 鱼数量
            //ConfigItemsConf itemsConf = ConfManager.getInstance().getConfigItemsConf();
            //int itemType = itemsConf.getItemType(itemID);
            //if (itemType > 0) {
            //    BaseCacheDao itemDao = getItemDao(itemType);
            //    QueryParamMap  queryParams = new QueryParamMap();
            //    queryParams.put("roleID",roleID);
            //    queryParams.put("itemID",itemID);
            //    PlayerItem playerItem = (PlayerItem) itemDao.cacheSelect(queryParams, roleID);
            //    if(playerItem != null) {
            //        //taskHandler.doTaskAction(roleID, TaskActionEnum.CONJURE_ANIMALS, 1);
            //        //taskHandler.doTaskNeedItem(roleID, itemID, playerItem.getItemCount());
            //        builder.setFishCount(playerItem.getItemCount());
            //    }
            //}
        }
        ParkFish parkFish = fish.toParkFish();
        builder.setFish(parkFish);
    }

    /**
     *	鱼塘收获鱼
     *
     * @param roleID
     * @param req
     */
    public void parkHarvestFish(long roleID, ParkHarvestFishReq req, ParkHarvestFishRsp.Builder builder) {
        EventManager.postTaskActionEvent(roleID, TaskActionEnum.PARK_FISH_TASK, 1);
        List<Integer> successIndexList = parkService.parkHarvestFish(roleID, req.getIndexList(), config -> {
            addItem(roleID, config.getProductId(), config.getProductNum(), ResourceBillEnum.parkHarvestFish, false);
            addExp(roleID, config.getProductExp(), ResourceBillEnum.parkHarvestFish);
        });
        builder.addAllSuccessIndex(successIndexList);
    }

    /**
     *	清除枯萎植物
     *
     * @param roleID
     * @param req
     * @param builder
     */
    //public void parkClearWitherPlant(long roleID, ParkClearWitherPlantReq req, ParkClearWitherPlantRsp.Builder builder) {
    //    List<CellPoint> successPoints = parkService.parkClearWitherPlant(roleID, req.getPointsList(), () -> {
    //        try {
    //            costItem(roleID, ConfigSundryConf.parkClearWitherItemID, 1, ResourceBillEnum.parkClearWitherPlant, true, false);
    //            addExp(roleID, ConfigSundryConf.parkClearWitherRewardExp, ResourceBillEnum.parkClearWitherPlant);
    //            return true;
    //        } catch (CommonException e) {
    //            return false;
    //        }
    //    });
    //    builder.addAllSuccessPoints(successPoints);
    //}

    /**
     *	清除枯萎动物
     *
     * @param roleID
     * @param req
     * @param builder
     */
//    public void parkClearWitherAnimal(long roleID, ParkClearWitherAnimalReq req, ParkClearWitherAnimalRsp.Builder builder) {
//        List<String> successAnimalTimeIDs = parkService.parkClearWitherAnimal(roleID, req.getAnimalTimeIDsList(),
//	        () -> {
//	            try {
//	                costItem(roleID, ConfigSundryConf.parkClearWitherItemID, 1, ResourceBillEnum.parkClearWitherAnimal, true, false);
//	                addExp(roleID, ConfigSundryConf.parkClearWitherRewardExp, ResourceBillEnum.parkClearWitherPlant);
//	                return true;
//	            } catch (CommonException e) {
//	                return false;
//	            }
//	        });
//        builder.addAllSuccessAnimalTimeIDs(successAnimalTimeIDs);
//        int useEcology = parkService.getUseEcology(roleID);
//        builder.setUseEcology(useEcology);
//    }

    /**
     *	领取蜂蜜
     *
     * @param roleID
     * @param builder
     */
    public void parkDrawHoney(long roleID, ParkDrawHoneyRsp.Builder builder) {
        int honeyCD = parkService.parkDrawHoney(roleID);
        for (Map.Entry<Integer, Integer> entry : ConfigSundryConf.drawHoneyReward.entrySet()) {
            addItem(roleID, entry.getKey(), entry.getValue(), ResourceBillEnum.parkDrawHoney, true);
        }
        builder.setHoneyCD(honeyCD);
    }

    /**
     *	生态园动物喂食
     *
     * @param req
     */
    public void parkAnimalFeed(long roleID, ParkAnimalFeedReq req) {
        checkItemEnough(roleID, req.getFoodID(), req.getFoodCount());
        parkService.parkAnimalFeed(req);
        costItem(roleID, req.getFoodID(), req.getFoodCount(), ResourceBillEnum.parkAnimalFeed);
    }

    /**
     * 结算
     * @param roleID
     */
	public void parkDrawPrize(long roleID, ParkDrawPrizeRsp.Builder builder) {
		int goldNum = parkService.parkDrawPrize(roleID);
		addGold(roleID, goldNum, ResourceBillEnum.parkDrawPrize);
		builder.setGoldNum(goldNum);
	}
    /* 加速收获
    public void parkAnimalSpeedup(long roleID, ParkAnimalSpeedupReq req, ParkAnimalSpeedupRsp.Builder builder) {
        AnimalPoint successPoint = parkService.parkHarvestAnimalSpeedup(roleID, req.getPoints(), (config, wither) -> {
            if (config.getProductId() == 1) {
                addGold(roleID, config.getProductNum(), ResourceBillEnum.parkHarvestAnimal);
            } else {
                addItem(roleID, config.getProductId(), config.getProductNum(), ResourceBillEnum.parkHarvestAnimal, false);
            }
            addExp(roleID, config.getProductExp(), ResourceBillEnum.parkHarvestAnimal);
            //addRenown(roleID, config.getProductRenown(), ResourceBillEnum.parkHarvestAnimal);
            if (wither && config.getAddBoom() > 0) {
                //便便状态就减少繁荣度
                changeBoom(roleID, -config.getAddBoom(), ResourceBillEnum.parkHarvestAnimal);
            }
        });
        builder.setSuccessPoints(successPoint);
        int useEcology = parkService.getUseEcology(roleID);
        builder.setUseEcology(useEcology);
    }
    */

    public void parkAnimalSpeedup(long roleID, ParkAnimalSpeedupReq req, ParkAnimalSpeedupRsp.Builder builder) {
        AnimalPoint successPoint = parkService.parkHarvestAnimalSpeedup(roleID, req.getPoints());
        if(successPoint != null) {
            builder.setSuccessPoints(successPoint);
        }
    }

    public void parkFishSpeedup(long roleID, ParkFishSpeedupReq req, ParkFishSpeedupRsp.Builder builder) {
        int index = req.getIndex();
        Integer successIndex = parkService.parkHarvestFishSpeedup(roleID, index);
        builder.setSuccessIndex(successIndex);
    }

    public void parkPlantSpeedup(long roleID, ParkPlantSpeedupReq req, ParkPlantSpeedupRsp.Builder builder) {
        CellPoint successPoint = parkService.parkHarvestPlantSpeedup(roleID, req.getPoints());
        if(successPoint != null) {
            builder.setSuccessPoints(successPoint);
        }
    }
}
