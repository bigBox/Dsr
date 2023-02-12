package com.dj.serverapi.service;

import com.dj.domain.config.*;
import com.dj.domain.constant.ConstantGame;
import com.dj.domain.data.game.ParkAnimalUnit;
import com.dj.domain.data.game.ParkCellUnit;
import com.dj.domain.data.game.ParkFishUnit;
import com.dj.domain.data.game.ZooAnimalUnit;
import com.dj.domain.entity.player.PlayerFarm;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.entity.player.task.ITask;
import com.dj.domain.entity.player.task.PlayerTask1;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.enums.TaskState;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.collection.MapSubMap;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.inf.IArgumentKeyValueRunnable;
import com.dj.domain.util.inf.IArgumentRunnable;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.park.*;
import com.dj.serverapi.EventProvider;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.PlayerFarmDao;
import com.dj.serverapi.dao.PlayerRoleDao;
import com.dj.serverapi.dao.task.PlayerTask1Dao;
import com.dj.serverapi.redis.model.CommonModel;
import com.dj.serverapi.redis.model.ParkModel;
import com.dj.serverapi.service.inf.IParkService;
import com.dj.servercore.conf.*;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.servercore.redis.base.BaseService;
import com.dj.servercore.server.netty.channel.BaseLogicChannelManager;
import com.dj.servercore.spring.SpringContext;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ParkServiceImpl extends BaseService implements IParkService {

    @Autowired
    PlayerFarmDao playerFarmDao;

    @Autowired
    PlayerRoleDao playerRoleDao;

    @Override
    public MapSubMap<Integer, Integer, ParkCellUnit> getCellMap(long roleID) {
        return getReadModel(roleID, ParkModel.class).getCellMap();
    }

    @Override
    public Map<String, ParkAnimalUnit> getParkAnimalMap(long roleID) {
        return getReadModel(roleID, ParkModel.class).getParkAnimalMap();
    }

    @Override
    public Map<String, ZooAnimalUnit> getZooAnimalMap(long roleID) {
        return getReadModel(roleID, ParkModel.class).getZooAnimalMap();
    }

    @Override
    public Map<Integer, ParkFishUnit> getFishMap(long roleID) {
        return getReadModel(roleID, ParkModel.class).getFishMap();
    }

    @Override
    public ParkCellUnit parkPlaceCrops(long roleID, int x, int y, int plantID, ConfigFarmCulture config) {
        ParkModel model = getWriteModel(roleID, ParkModel.class);
        MapSubMap<Integer, Integer, ParkCellUnit> cellMap = model.getCellMap();
        ParkCellUnit cell = cellMap.get(x, y);
        if (cell.getPlantID() > 0) {
            // 当前格子已经有植物了
            throw new CommonException(ErrorID.PARK_CELL_HAS_PLANT);
        }
        if ((config.getNeedGreen() > 0)&&(cell.getGreen() < config.getNeedGreen())) {
            // 绿化值不够
            throw new CommonException(ErrorID.PARK_GREEN_NOT_ENOUGH);
        }
        // 种植
        cell.setPlantID(plantID);
        long currTime = System.currentTimeMillis();
        cell.setPlaceTime(currTime);
        cell.setBirthTime(currTime);
        cell.setCookingTime(config.getCookingTime() * 60000L);
        cell.setHarvestNum(0);
        if(config.getFeedId() > 0) {
            cell.setFeedID(config.getFeedId());
        }else{
            cell.setFeedID(0);
        }
        if(config.getFeedNum() > 0) {
            cell.setFeedNum(config.getFeedNum());
        }else{
            cell.setFeedNum(0);
        }
        //添加到数据库
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("roleID",roleID);
        queryParams.put("x",x);
        queryParams.put("y",y);
        if(ObjectUtils.isEmpty(playerFarmDao)){
            playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
        }
        PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
        if (playerFarm == null) {
            playerFarm = new PlayerFarm(roleID);
            playerFarm.setSeed(plantID);
            playerFarm.setX(x);
            playerFarm.setY(y);
            playerFarm.setPlaintTime(DateUtil.getCurrentDate());
            playerFarmDao.cacheInsert(playerFarm, roleID);
        }else {
            playerFarm.setSeed(plantID);
            playerFarm.setX(x);
            playerFarm.setY(y);
            playerFarm.setPlaintTime(DateUtil.getCurrentDate());
            playerFarmDao.cacheUpdate(playerFarm, roleID);
        }
        return cell;
    }

    @Override
    public ParkCellUnit parkPlacePlant(long roleID, int x, int y, int plantID, ConfigFarmParkPlant config) {
        ParkModel model = getWriteModel(roleID, ParkModel.class);
        MapSubMap<Integer, Integer, ParkCellUnit> cellMap = model.getCellMap();
        ParkCellUnit cell = cellMap.get(x, y);
        if (cell.getPlantID() > 0) {
            // 当前格子已经有植物了
            throw new CommonException(ErrorID.PARK_CELL_HAS_PLANT);
        }
        if ((config.getNeedGreen() > 0)&&(cell.getGreen() < config.getNeedGreen())) {
            // 绿化值不够
            throw new CommonException(ErrorID.PARK_GREEN_NOT_ENOUGH);
        }
        // 种植
        cell.setPlantID(plantID);
        long currTime = System.currentTimeMillis();
        cell.setPlaceTime(currTime);
        cell.setBirthTime(currTime);
        long cookingTime = config.getCookingTime() * 60000L;
        ConfigTasks configTasks = checkTaskAction(roleID, TaskActionEnum.PARK_PLANT_GREEN);
        if((configTasks != null)&&(configTasks.getExtraParam() == plantID)) {
            cookingTime = 3000;
        }
        cell.setCookingTime(cookingTime);
        cell.setHarvestNum(0);
        if(config.getFeedId() > 0) {
            cell.setFeedID(config.getFeedId());
        }else{
            cell.setFeedID(0);
        }
        if(config.getFeedNum() > 0) {
            cell.setFeedNum(config.getFeedNum());
        }else{
            cell.setFeedNum(0);
        }
        //添加到数据库
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("roleID",roleID);
        queryParams.put("x",x);
        queryParams.put("y",y);
        if(ObjectUtils.isEmpty(playerFarmDao)){
            playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
        }
        PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
        if (playerFarm == null) {
            playerFarm = new PlayerFarm(roleID);
            playerFarm.setSeed(plantID);
            playerFarm.setX(x);
            playerFarm.setY(y);
            playerFarm.setPlaintTime(DateUtil.getCurrentDate());
            playerFarmDao.cacheInsert(playerFarm, roleID);
        }else {
            playerFarm.setSeed(plantID);
            playerFarm.setX(x);
            playerFarm.setY(y);
            playerFarm.setPlaintTime(DateUtil.getCurrentDate());
            playerFarmDao.cacheUpdate(playerFarm, roleID);
        }
        return cell;
    }

    @Override
    public ParkCellUnit parkPlaceTree(long roleID, int x, int y, int plantID, ConfigFarmParkTree config) {
        ParkModel model = getWriteModel(roleID, ParkModel.class);
        MapSubMap<Integer, Integer, ParkCellUnit> cellMap = model.getCellMap();
        ParkCellUnit cell = cellMap.get(x, y);
        if (cell.getPlantID() > 0) {
            // 当前格子已经有植物了
            throw new CommonException(ErrorID.PARK_CELL_HAS_PLANT);
        }
        if ((config.getNeedGreen() > 0)&&(cell.getGreen() < config.getNeedGreen())) {
            // 绿化值不够
            throw new CommonException(ErrorID.PARK_GREEN_NOT_ENOUGH);
        }
        // 种植
        cell.setPlantID(plantID);
        long currTime = System.currentTimeMillis();
        cell.setPlaceTime(currTime);
        cell.setBirthTime(currTime);
        cell.setCookingTime(config.getCookingTime() * 60000L);
        cell.setHarvestNum(0);
        if(config.getFeedId() > 0) {
            cell.setFeedID(config.getFeedId());
        }else{
            cell.setFeedID(0);
        }
        if(config.getFeedNum() > 0) {
            cell.setFeedNum(config.getFeedNum());
        }else{
            cell.setFeedNum(0);
        }
        //添加到数据库
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("roleID",roleID);
        queryParams.put("x",x);
        queryParams.put("y",y);
        if(ObjectUtils.isEmpty(playerFarmDao)){
            playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
        }
        PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
        if (playerFarm == null) {
            playerFarm = new PlayerFarm(roleID);
            playerFarm.setSeed(plantID);
            playerFarm.setX(x);
            playerFarm.setY(y);
            playerFarm.setPlaintTime(DateUtil.getCurrentDate());
            playerFarmDao.cacheInsert(playerFarm, roleID);
        }else {
            playerFarm.setSeed(plantID);
            playerFarm.setX(x);
            playerFarm.setY(y);
            playerFarm.setPlaintTime(DateUtil.getCurrentDate());
            playerFarmDao.cacheUpdate(playerFarm, roleID);
        }
        return cell;
    }

    @Override
    public ParkAnimalUnit parkPlaceAnimal(long roleID, int animalID, ConfigFarmParkAnimal config, int source) {
        ParkModel model = getWriteModel(roleID, ParkModel.class);
        Map<Integer, Integer> parkCountMap = model.getParkCount();
        if ((config.getPlaceLimit() > 0)&&(source > 0)) {
            int parkCount = MapUtils.getIntValue(parkCountMap, animalID);
            if (parkCount >= config.getPlaceLimit()) {
                // 放置动物上限
                throw new CommonException(ErrorID.PARK_PLACE_LIMIT);
            }
        }
        // 放置动物
        MapUtil.fundInt(parkCountMap, animalID, 1);
        long currTime = System.currentTimeMillis();
        ParkAnimalUnit parkAnimalUnit = new ParkAnimalUnit();
        parkAnimalUnit.setAnimalTimeID(DateUtil.formatDate(new Date(), DateUtil.STYLE20));
        parkAnimalUnit.setAnimalID(animalID);
        parkAnimalUnit.setHarvestNum(0);
        parkAnimalUnit.setStatus(ParkStatus.Normal_VALUE);
        parkAnimalUnit.setSource(source);
        parkAnimalUnit.setX(0);
        parkAnimalUnit.setY(0);
        parkAnimalUnit.setCookingTime(config.getCookingTime() * 60000L);
        parkAnimalUnit.setNtfFlag(false);
        if (source > 0){
            parkAnimalUnit.setPlaceTime(currTime);
            parkAnimalUnit.setBirthTime(currTime);
            parkAnimalUnit.setEatTime(currTime);
            parkAnimalUnit.setEatNum(0);
        }else{
            parkAnimalUnit.setPlaceTime(currTime - config.getCookingTime() * 60000L);
            parkAnimalUnit.setBirthTime(currTime - config.getCookingTime() * 60000L);
            parkAnimalUnit.setEatTime(currTime - config.getCookingTime() * 60000L);
            parkAnimalUnit.setEatNum(config.getEatNum());
        }
        model.getParkAnimalMap().put(parkAnimalUnit.getAnimalTimeID(), parkAnimalUnit);
        // 更新动物占用的人口
        if(config.getCostEcology() > 0) {
            model.changeUseEcology(config.getCostEcology());
        }
        return parkAnimalUnit;
    }

    @Override
    public ZooAnimalUnit zooPlaceAnimal(long roleID, int animalID, ConfigFarmZooAnimal config, int source) {
        ParkModel model = getWriteModel(roleID, ParkModel.class);
        Map<Integer, Integer> parkCountMap = model.getParkCount();
        if(config.getPlaceLimit() > 0) {
            int parkCount = MapUtils.getIntValue(parkCountMap, animalID);
            if (parkCount >= config.getPlaceLimit()) {
                // 放置动物上限
                throw new CommonException(ErrorID.PARK_PLACE_LIMIT);
            }
        }
        // 放置动物
        MapUtil.fundInt(parkCountMap, animalID, 1);
        long currTime = System.currentTimeMillis();
        ZooAnimalUnit zooAnimalUnit = new ZooAnimalUnit(DateUtil.formatDate(new Date(), DateUtil.STYLE20), animalID, currTime, currTime, 0, currTime, 0, ParkStatus.Normal_VALUE, source, 0, 0,false, config.getCookingTime() * 60000L);
        model.getZooAnimalMap().put(zooAnimalUnit.getAnimalTimeID(), zooAnimalUnit);
        // 更新动物占用的人口
        if(config.getCostEcology() > 0) {
            model.changeUseEcology(config.getCostEcology());
        }
        return zooAnimalUnit;
    }

    @Override
    public List<CellPoint> parkHarvestCorps(long roleID, List<CellPoint> points, IArgumentRunnable<ConfigFarmCulture> configRun, IArgumentRunnable<Integer> ecologyRun) {
        ParkModel model = getWriteModel(roleID, ParkModel.class);
        MapSubMap<Integer, Integer, ParkCellUnit> cellMap = model.getCellMap();
        List<CellPoint> successPoints = Lists.newArrayListWithExpectedSize(points.size());
        List<ParkCell> cells = Lists.newArrayList();
        ConfigFarmCultureConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMCULTURE);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        int ecology = 0;
        for (CellPoint p : points) {
            int x = p.getX();
            int y = p.getY();
            ParkCellUnit cell = cellMap.get(x, y);
            if (cell.getPlantID() <= 0 || cell.getStatus() == ParkStatus.Wither_VALUE) {
                cells.add(cell.toParkCell());
                continue;
            }
            cell.setHarvestNum(cell.getHarvestNum() + 1);
            ConfigFarmCulture config = conf.getPlant(cell.getPlantID());
            if(ObjectUtils.isEmpty(config)){
                throw new CommonException(ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
            configRun.run(config);
            successPoints.add(p);
            if (config.getHarvestNum() <= cell.getHarvestNum()) {
                ecology += changeCellGreen(cell, config.getHarvestGreenTo());
                if(config.getProductId() == 1) {
                    cell.setPlantID(0);
                    cell.setPlaceTime(0);
                    cell.setBirthTime(0);
                    cell.setCookingTime(0);
                    cell.setHarvestNum(0);
                    cell.setFeedID(0);
                    cell.setFeedNum(0);
                    cell.setStatus(ParkStatus.Normal_VALUE);
                    cells.add(cell.toParkCell());
                    QueryParamMap queryParams = new QueryParamMap();
                    queryParams.put("roleID",roleID);
                    queryParams.put("x",cell.getX());
                    queryParams.put("y",cell.getY());
                    if(ObjectUtils.isEmpty(playerFarmDao)){
                        playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
                    }
                    PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
                    if (playerFarm != null) {
                        playerFarm.setSeed(0);
                        playerFarmDao.cacheUpdate(playerFarm, roleID);
                    }
                }else {
                    cell.setPlantID(0);
                    cell.setPlaceTime(0);
                    cell.setBirthTime(0);
                    cell.setCookingTime(0);
                    cell.setHarvestNum(0);
                    cell.setFeedID(0);
                    cell.setFeedNum(0);
                    cell.setStatus(ParkStatus.Normal_VALUE);
                    cells.add(cell.toParkCell());
                    QueryParamMap queryParams = new QueryParamMap();
                    queryParams.put("roleID",roleID);
                    queryParams.put("x",cell.getX());
                    queryParams.put("y",cell.getY());
                    if(ObjectUtils.isEmpty(playerFarmDao)){
                        playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
                    }
                    PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
                    if (playerFarm != null) {
                        playerFarm.setSeed(0);
                        playerFarmDao.cacheUpdate(playerFarm, roleID);
                    }
                }
                // 左
                if (x - 1 >= 0 && !ConstantGame.checkInvalid(x - 1, y)) {
                    cell = cellMap.get(x - 1, y);
                    int change = changeCellGreen(cell, config.getGreenTo());
                    if (change > 0) {
                        ecology += change;
                        cells.add(cell.toParkCell());
                    }
                }
                // 右
                if (x + 1 < ConfigSundryConf.parkMapSize && !ConstantGame.checkInvalid(x + 1, y)) {
                    cell = cellMap.get(x + 1, y);
                    int change = changeCellGreen(cell, config.getGreenTo());
                    if (change > 0) {
                        ecology += change;
                        cells.add(cell.toParkCell());
                    }
                }
                // 上
                if (y - 1 >= 0 && !ConstantGame.checkInvalid(x, y - 1)) {
                    cell = cellMap.get(x, y - 1);
                    int change = changeCellGreen(cell, config.getGreenTo());
                    if (change > 0) {
                        ecology += change;
                        cells.add(cell.toParkCell());
                    }
                }
                // 下
                if (y + 1 < ConfigSundryConf.parkMapSize && !ConstantGame.checkInvalid(x, y + 1)) {
                    cell = cellMap.get(x, y + 1);
                    int change = changeCellGreen(cell, config.getGreenTo());
                    if (change > 0) {
                        ecology += change;
                        cells.add(cell.toParkCell());
                    }
                }
            } else {
                cell.setBirthTime(System.currentTimeMillis());
                cells.add(cell.toParkCell());
            }
        }
        // 生态值变化
        if (ecology > 0) {
            ecologyRun.run(ecology);
        }
        if (cells.size() > 0) {
            // 生态园地图变化推送
            ParkCellNtf.Builder parkCellNtf = ParkCellNtf.newBuilder();
            parkCellNtf.addAllCells(cells);
            PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
            BaseLogicChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), parkCellNtf.build());
        }
        return successPoints;
    }

    @Override
    public List<CellPoint> parkHarvestPlant(long roleID, List<CellPoint> points, IArgumentRunnable<ConfigFarmParkPlant> configRun, IArgumentRunnable<Integer> ecologyRun) {
        ParkModel model = getWriteModel(roleID, ParkModel.class);
        MapSubMap<Integer, Integer, ParkCellUnit> cellMap = model.getCellMap();
        List<CellPoint> successPoints = Lists.newArrayListWithExpectedSize(points.size());
        List<ParkCell> cells = Lists.newArrayList();
        ConfigFarmParkPlantConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMPARKPLANT);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        int ecology = 0;
        for (CellPoint p : points) {
            int x = p.getX();
            int y = p.getY();
            ParkCellUnit cell = cellMap.get(x, y);
            if (cell.getPlantID() <= 0 || cell.getStatus() == ParkStatus.Wither_VALUE) {
                cells.add(cell.toParkCell());
                continue;
            }
            cell.setHarvestNum(cell.getHarvestNum() + 1);
            ConfigFarmParkPlant config = conf.getPlant(cell.getPlantID());
            if(ObjectUtils.isEmpty(config)){
                throw new CommonException(ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
            configRun.run(config);
            successPoints.add(p);
            if (config.getHarvestNum() <= cell.getHarvestNum()) {
                ecology += changeCellGreen(cell, config.getHarvestGreenTo());
                if(config.getProductId() == 1) {
            		cell.setPlantID(0);
                    cell.setPlaceTime(0);
                    cell.setBirthTime(0);
                    cell.setCookingTime(0);
                    cell.setHarvestNum(0);
                    cell.setFeedID(0);
                    cell.setFeedNum(0);
                    cell.setStatus(ParkStatus.Normal_VALUE);
                    cells.add(cell.toParkCell());
                    QueryParamMap queryParams = new QueryParamMap();
                    queryParams.put("roleID",roleID);
                    queryParams.put("x",cell.getX());
                    queryParams.put("y",cell.getY());
                    if(ObjectUtils.isEmpty(playerFarmDao)){
                        playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
                    }
                    PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
                    if (playerFarm != null) {
                        playerFarm.setSeed(0);
                        playerFarmDao.cacheUpdate(playerFarm, roleID);
                    }
            	}else {
            		cell.setPlantID(0);
                    cell.setPlaceTime(0);
                    cell.setBirthTime(0);
                    cell.setCookingTime(0);
                    cell.setHarvestNum(0);
                    cell.setFeedID(0);
                    cell.setFeedNum(0);
            		cell.setStatus(ParkStatus.Normal_VALUE);
            		cells.add(cell.toParkCell());
                    QueryParamMap queryParams = new QueryParamMap();
                    queryParams.put("roleID",roleID);
                    queryParams.put("x",cell.getX());
                    queryParams.put("y",cell.getY());
                    if(ObjectUtils.isEmpty(playerFarmDao)){
                        playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
                    }
                    PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
                    if (playerFarm != null) {
                        playerFarm.setSeed(0);
                        playerFarmDao.cacheUpdate(playerFarm, roleID);
                    }
				}
                // 左
                if (x - 1 >= 0 && !ConstantGame.checkInvalid(x - 1, y)) {
                    cell = cellMap.get(x - 1, y);
                    int change = changeCellGreen(cell, config.getGreenTo());
                    if (change > 0) {
                        ecology += change;
                        cells.add(cell.toParkCell());
                    }
                }
                // 右
                if (x + 1 < ConfigSundryConf.parkMapSize && !ConstantGame.checkInvalid(x + 1, y)) {
                    cell = cellMap.get(x + 1, y);
                    int change = changeCellGreen(cell, config.getGreenTo());
                    if (change > 0) {
                        ecology += change;
                        cells.add(cell.toParkCell());
                    }
                }
                // 上
                if (y - 1 >= 0 && !ConstantGame.checkInvalid(x, y - 1)) {
                    cell = cellMap.get(x, y - 1);
                    int change = changeCellGreen(cell, config.getGreenTo());
                    if (change > 0) {
                        ecology += change;
                        cells.add(cell.toParkCell());
                    }
                }
                // 下
                if (y + 1 < ConfigSundryConf.parkMapSize && !ConstantGame.checkInvalid(x, y + 1)) {
                    cell = cellMap.get(x, y + 1);
                    int change = changeCellGreen(cell, config.getGreenTo());
                    if (change > 0) {
                        ecology += change;
                        cells.add(cell.toParkCell());
                    }
                }
            } else {
                cell.setBirthTime(System.currentTimeMillis());
                cells.add(cell.toParkCell());
            }
        }
        // 生态值变化
        if (ecology > 0) {
            ecologyRun.run(ecology);
        }
        if (cells.size() > 0) {
            // 生态园地图变化推送
            ParkCellNtf.Builder parkCellNtf = ParkCellNtf.newBuilder();
            parkCellNtf.addAllCells(cells);
            PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
            BaseLogicChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), parkCellNtf.build());
        }
        return successPoints;
    }

    @Override
    public List<CellPoint> parkHarvestTree(long roleID, List<CellPoint> points, IArgumentRunnable<ConfigFarmParkTree> configRun, IArgumentRunnable<Integer> ecologyRun) {
        ParkModel model = getWriteModel(roleID, ParkModel.class);
        MapSubMap<Integer, Integer, ParkCellUnit> cellMap = model.getCellMap();
        List<CellPoint> successPoints = Lists.newArrayListWithExpectedSize(points.size());
        List<ParkCell>         cells   = Lists.newArrayList();
        ConfigFarmParkTreeConf conf    = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMPARKTREE);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }

        int ecology = 0;
        for (CellPoint p : points) {
            int x = p.getX();
            int y = p.getY();
            ParkCellUnit cell = cellMap.get(x, y);
            if (cell.getPlantID() <= 0 || cell.getStatus() == ParkStatus.Wither_VALUE) {
                cells.add(cell.toParkCell());
                continue;
            }
            cell.setHarvestNum(cell.getHarvestNum() + 1);
            ConfigFarmParkTree config = conf.getPlant(cell.getPlantID());
            if(ObjectUtils.isEmpty(config)){
                throw new CommonException(ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
            configRun.run(config);
            successPoints.add(p);
            if (config.getHarvestNum() <= cell.getHarvestNum()) {
                ecology += changeCellGreen(cell, config.getHarvestGreenTo());
                if(config.getProductId() == 1) {
                    cell.setPlantID(0);
                    cell.setPlaceTime(0);
                    cell.setBirthTime(0);
                    cell.setCookingTime(0);
                    cell.setHarvestNum(0);
                    cell.setFeedID(0);
                    cell.setFeedNum(0);
                    cell.setStatus(ParkStatus.Normal_VALUE);
                    cells.add(cell.toParkCell());
                    QueryParamMap queryParams = new QueryParamMap();
                    queryParams.put("roleID",roleID);
                    queryParams.put("x",cell.getX());
                    queryParams.put("y",cell.getY());
                    if(ObjectUtils.isEmpty(playerFarmDao)){
                        playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
                    }
                    PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
                    if (playerFarm != null) {
                        playerFarm.setSeed(0);
                        playerFarmDao.cacheUpdate(playerFarm, roleID);
                    }
                }else {
                    cell.setPlantID(0);
                    cell.setPlaceTime(0);
                    cell.setBirthTime(0);
                    cell.setCookingTime(0);
                    cell.setHarvestNum(0);
                    cell.setFeedID(0);
                    cell.setFeedNum(0);
                    cell.setStatus(ParkStatus.Normal_VALUE);
                    cells.add(cell.toParkCell());
                    QueryParamMap queryParams = new QueryParamMap();
                    queryParams.put("roleID",roleID);
                    queryParams.put("x",cell.getX());
                    queryParams.put("y",cell.getY());
                    if(ObjectUtils.isEmpty(playerFarmDao)){
                        playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
                    }
                    PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
                    if (playerFarm != null) {
                        playerFarm.setSeed(0);
                        playerFarmDao.cacheUpdate(playerFarm, roleID);
                    }
                }
                // 左
                if (x - 1 >= 0 && !ConstantGame.checkInvalid(x - 1, y)) {
                    cell = cellMap.get(x - 1, y);
                    int change = changeCellGreen(cell, config.getGreenTo());
                    if (change > 0) {
                        ecology += change;
                        cells.add(cell.toParkCell());
                    }
                }
                // 右
                if (x + 1 < ConfigSundryConf.parkMapSize && !ConstantGame.checkInvalid(x + 1, y)) {
                    cell = cellMap.get(x + 1, y);
                    int change = changeCellGreen(cell, config.getGreenTo());
                    if (change > 0) {
                        ecology += change;
                        cells.add(cell.toParkCell());
                    }
                }
                // 上
                if (y - 1 >= 0 && !ConstantGame.checkInvalid(x, y - 1)) {
                    cell = cellMap.get(x, y - 1);
                    int change = changeCellGreen(cell, config.getGreenTo());
                    if (change > 0) {
                        ecology += change;
                        cells.add(cell.toParkCell());
                    }
                }
                // 下
                if (y + 1 < ConfigSundryConf.parkMapSize && !ConstantGame.checkInvalid(x, y + 1)) {
                    cell = cellMap.get(x, y + 1);
                    int change = changeCellGreen(cell, config.getGreenTo());
                    if (change > 0) {
                        ecology += change;
                        cells.add(cell.toParkCell());
                    }
                }
            } else {
                cell.setBirthTime(System.currentTimeMillis());
                cells.add(cell.toParkCell());
            }
        }
        // 生态值变化
        if (ecology > 0) {
            ecologyRun.run(ecology);
        }
        if (cells.size() > 0) {
            // 生态园地图变化推送
            ParkCellNtf.Builder parkCellNtf = ParkCellNtf.newBuilder();
            parkCellNtf.addAllCells(cells);
            PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
            BaseLogicChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), parkCellNtf.build());
        }
        return successPoints;
    }

    /**
     * 改变格子的绿化值
     * @param cell
     * @param green
     * @return
     */
    private int changeCellGreen(ParkCellUnit cell, int green) {
        int change = 0;
        if (green > cell.getGreen()) {
            change = green - cell.getGreen();
            cell.setGreen(green);
        }
        return change;
    }

    @Override
    public List<AnimalPoint> parkHarvestAnimal(long roleID, List<AnimalPoint> points, IArgumentKeyValueRunnable<ConfigFarmParkAnimal, Boolean> configRun) {
        ParkModel model = getWriteModel(roleID, ParkModel.class);
        List<String> animalClearIDs = Lists.newArrayListWithExpectedSize(0);
        Map<String, ParkAnimalUnit> parkAnimalMap = model.getParkAnimalMap();
        List<AnimalPoint> successPoints = Lists.newArrayListWithExpectedSize(points.size());
        List<ParkAnimal> animals = Lists.newArrayListWithExpectedSize(points.size());
        ConfigFarmParkAnimalConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMPARKANIMAL);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        Date nowTime = DateUtil.getCurrentDate();
        for (AnimalPoint p : points) {
            ParkAnimalUnit animal = parkAnimalMap.get(p.getAnimalTimeID());
            if (animal == null || animal.getStatus() == ParkStatus.Wither_VALUE) {
                animalClearIDs.add(p.getAnimalTimeID());
                continue;
            }
            animal.setHarvestNum(animal.getHarvestNum() + 1);
            animal.setX(p.getX());
            animal.setY(p.getY());
            ConfigFarmParkAnimal config = conf.getAnimal(animal.getAnimalID());
            if (config.getHarvestCount() > 0 && config.getHarvestCount() <= animal.getHarvestNum()) {
                // 收获次数上限
                animal.setStatus(ParkStatus.Wither_VALUE);
                animalClearIDs.add(p.getAnimalTimeID());
            } else if (config.getLifeTime() > 0) {
                Date liveTime = new Date(animal.getPlaceTime() + config.getLifeTime() * 1000);
                if (nowTime.getTime() >= liveTime.getTime()) {
                    // 生存时间上限
                    animal.setStatus(ParkStatus.Wither_VALUE);
                    animalClearIDs.add(p.getAnimalTimeID());
                }
            }
            if (animal.getStatus() == ParkStatus.Wither_VALUE) {
                // 更新动物占用的人口
                model.changeUseEcology(-config.getCostEcology());
                //MapUtil.fundInt(model.getParkCount(), animal.getAnimalID(), -1);
                configRun.run(config, true);
            } else {
                // 还没有枯萎，重新吃植物
                animal.setBirthTime(nowTime.getTime());
                animal.setEatTime(nowTime.getTime());
                animal.setNtfFlag(false);
                animal.setEatNum(0);
                configRun.run(config, false);
            }
            successPoints.add(p);
            animals.add(animal.toParkAnimal(config));
        }
        if (animals.size() > 0) {
            // 生态园动物变化推送
            ParkAnimalNtf.Builder parkAnimalNtf = ParkAnimalNtf.newBuilder();
            parkAnimalNtf.addAllAnimals(animals);
            PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
            BaseLogicChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), parkAnimalNtf.build());
        }
        //zcq 动物收获之后，直接删掉，不产生屎
        for (String animalTimeID : animalClearIDs) {
            ParkAnimalUnit parkAnimalUnit = parkAnimalMap.get(animalTimeID);
            if(parkAnimalUnit != null) {
                MapUtil.fundInt(model.getParkCount(), parkAnimalUnit.getAnimalID(), -1);
                parkAnimalMap.remove(animalTimeID);
            }
        }
        return successPoints;
    }

    @Override
    public ParkFishUnit parkPlaceFish(long roleID, int fishID, int  index, ConfigPoolFishs config) {
        ParkModel model = getWriteModel(roleID, ParkModel.class);
        Map<Integer, ParkFishUnit> fishMap = model.getFishMap();
        if (fishMap != null && fishMap.containsKey(index)) {
            throw new CommonException(ErrorID.PARK_PLACE_LIMIT);
        }
        long currTime = System.currentTimeMillis();
        long cookingTime = config.getCookingTime() * 60000L;
        ConfigTasks configTasks = checkTaskAction(roleID, TaskActionEnum.PARK_FISH_TASK);
        if((configTasks != null)&&(configTasks.getExtraParam() == fishID)) {
            cookingTime = 3000L;
        }
        ParkFishUnit fish = new ParkFishUnit(index, fishID, currTime, currTime, 0, cookingTime);
        model.getFishMap().put(index, fish);
        return fish;
    }

    @Override
    public List<Integer> parkHarvestFish(long roleID, List<Integer> indexList, IArgumentRunnable<ConfigPoolFishs> configRun) {
        ParkModel model = getWriteModel(roleID, ParkModel.class);
        Map<Integer, ParkFishUnit> fishMap = model.getFishMap();
        ConfigPoolFishsConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_POOLFISHS);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        List<Integer> successIndexList = Lists.newArrayListWithExpectedSize(indexList.size());
        for (Integer index : indexList) {
            if (fishMap != null && fishMap.containsKey(index)) {
                ParkFishUnit fish = fishMap.get(index);
                if (fish != null) {
                    ConfigPoolFishs config = conf.getPoolFish(fish.getFishID());
                    configRun.run(config);
                    model.getFishMap().remove(index);
                    successIndexList.add(index);
                }
            }
        }
        return successIndexList;
    }

    @Override
    public boolean animalEatPlant(long roleID, IArgumentRunnable<List<ParkCell>> cellRun, IArgumentRunnable<ParkAnimalUnit> animalRun, IArgumentRunnable<Integer> ecologyRun, IArgumentRunnable<ParkAnimal> animalLeave) {
    	ParkModel model = getWriteModel(roleID, ParkModel.class);
    	Map<String, ParkAnimalUnit> parkAnimalMap = model.getParkAnimalMap();
    	if(parkAnimalMap.size() <= 0) {
    		return false;
    	}
    	Date nowTime = DateUtil.getCurrentDate();
    	ConfigFarmParkAnimalConf animalConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMPARKANIMAL);
        if(animalConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        // 稀有动物离开
    	for (Iterator<Entry<String, ParkAnimalUnit>> it = parkAnimalMap.entrySet().iterator(); it.hasNext();){
    		Map.Entry<String, ParkAnimalUnit> animal = it.next();
            ConfigFarmParkAnimal configAnimal = animalConf.getAnimal(animal.getValue().getAnimalID());
    		if(configAnimal.getUncommon() == 1){
            	// 放置时间
                Date placeDate = new Date(animal.getValue().getPlaceTime());
            	Date leaveTime = DateUtil.plusTime(placeDate, TimeUnit.DAYS, 1);
            	if (nowTime.getTime() >= leaveTime.getTime()) {
            		log.info("roleID {} animalID {} auto leave", roleID, configAnimal.getID());
            		animalLeave.run(animal.getValue().toParkAnimal(configAnimal));
            		it.remove();
                }
    		}
    	}
    	if(parkAnimalMap.size() == 0) {
    		return false;
    	}
        MapSubMap<Integer, Integer, ParkCellUnit> cellMap = model.getCellMap();
        List<ParkCellUnit> cells = cellMap.allValues();
        List<ParkCell> cellList = Lists.newArrayList();
        boolean hasAnimal = false;
        for (Entry<String, ParkAnimalUnit> animal : parkAnimalMap.entrySet()) {
            ConfigFarmParkAnimal configAnimal = animalConf.getAnimal(animal.getValue().getAnimalID());
            //TODO 老王定的什么都可以吃 2022-10-28
            //if ((configAnimal.getEatPlantID() == 0) && (configAnimal.getEatPlantType() == 0)) {
            //    // 不需要吃草
            //    continue;
            //}
            if ((configAnimal.getLifeTime() > 0) && (nowTime.getTime() > animal.getValue().getPlaceTime() + configAnimal.getLifeTime() * 60000L)
                    && (animal.getValue().getEatNum() >= configAnimal.getEatNum())) {
                // 动物生存时间到了 并且吃饱了
                continue;
            }
            if ((configAnimal.getHarvestCount() >= 0) && (animal.getValue().getHarvestNum() >= configAnimal.getHarvestCount())) {
                // 已收获最大次数
                continue;
            }
            // 以下动物都需要吃草
            hasAnimal = true;
            // 吃草周期没到
            if (nowTime.getTime() < animal.getValue().getEatTime() + configAnimal.getLifeTime() * 60000L) {
                continue;
            }
            // 本来就已经饱了
            if (animal.getValue().getEatNum() >= configAnimal.getEatNum()) {
                if (!animal.getValue().isNtfFlag()) {// 未推送成熟
                    Date animalCookingTimeDate = new Date(animal.getValue().getBirthTime() + animal.getValue().getCookingTime());
                    if (nowTime.getTime() >= animalCookingTimeDate.getTime()) {// 成熟时间到了
                        animalRun.run(animal.getValue());
                        animal.getValue().setNtfFlag(true);
                    }
                }
                continue;
            }
            // 吃植物
            ConfigFarmParkPlantConf plantConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMPARKPLANT);
            if(plantConf == null){
                throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
            ConfigFarmCultureConf cultureConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMCULTURE);
            if(cultureConf == null){
                throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
            for (ParkCellUnit cell : cells) {
                if (cell.getPlantID() == 0 || cell.getFeedID() == 0 || cell.getFeedNum() == 0) {
                    continue;
                }
                ConfigFarmParkPlant plantConfig = plantConf.getPlant(cell.getPlantID());
                if (ObjectUtils.isNotEmpty(plantConfig)) {
                    //TODO 老王定的什么都可以吃
                    //if ((cell.getFeedID() == configAnimal.getEatPlantID()) && (configAnimal.getEatPlantType() == plantConfig.getEatType())) {
                        Date plantCookingTime = new Date(cell.getBirthTime() + cell.getCookingTime());
                        if (nowTime.getTime() < plantCookingTime.getTime()) {
                            // 植物未成熟
                            continue;
                        }
                        if (configAnimal.getEatNum() > animal.getValue().getEatNum() + cell.getFeedNum()) {
                            // 没吃饱
                            log.info("roleID {} animal {} <<eat>> plant {} ", roleID, animal.getValue().toString(), cell.toString());
                            animal.getValue().setEatNum(animal.getValue().getEatNum() + cell.getFeedNum());
                            //animal.getValue().setEatTime(animal.getValue().getEatTime() + ConfigSundryConf.parkAnimalEatPlantCycle);
                            QueryParamMap queryParams = new QueryParamMap();
                            queryParams.put("roleID", roleID);
                            queryParams.put("x", cell.getX());
                            queryParams.put("y", cell.getY());
                            if (ObjectUtils.isEmpty(playerFarmDao)) {
                                playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
                            }
                            PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
                            if (playerFarm != null) {
                                playerFarm.setSeed(0);
                                playerFarmDao.cacheUpdate(playerFarm, roleID);
                            }
                            cell.setPlantID(0);
                            cell.setPlaceTime(0);
                            cell.setBirthTime(0);
                            cell.setCookingTime(0);
                            cell.setHarvestNum(0);
                            cell.setFeedID(0);
                            cell.setFeedNum(0);
                            int ecology = cell.getGreen() - plantConfig.getEatGreenTo();
                            cell.setGreen(plantConfig.getEatGreenTo());
                            //cellMap.put(cell.getX(), cell.getY(), cell);
                            cellList.add(cell.toParkCell());
                            ecologyRun.run(ecology);
                            if(animal.getValue().getStatus() == ParkStatus.Hunger_VALUE) {
                                animal.getValue().setStatus(ParkStatus.Normal_VALUE);
                                animalRun.run(animal.getValue());
                            }
                        } else {
                            // 吃饱了
                            log.info("roleID {} animal {} <<eat>> plant {} ", roleID, animal.getValue().toString(), cell.toString());
                            cell.setFeedNum(cell.getFeedNum() - (configAnimal.getEatNum() - animal.getValue().getEatNum()));
                            animal.getValue().setEatNum(configAnimal.getEatNum());
                            if(animal.getValue().getStatus() == ParkStatus.Hunger_VALUE) {
                                animal.getValue().setStatus(ParkStatus.Normal_VALUE);
                            }
                            Date animalCookingTimeDate = new Date(animal.getValue().getBirthTime() + animal.getValue().getCookingTime());
                            if (nowTime.getTime() >= animalCookingTimeDate.getTime()) { // 成熟时间到了
                                animalRun.run(animal.getValue());
                                animal.getValue().setNtfFlag(true);
                            }
                            if (cell.getFeedNum() == 0) {
                                QueryParamMap queryParams = new QueryParamMap();
                                queryParams.put("roleID", roleID);
                                queryParams.put("x", cell.getX());
                                queryParams.put("y", cell.getY());
                                if (ObjectUtils.isEmpty(playerFarmDao)) {
                                    playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
                                }
                                PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
                                if (playerFarm != null) {
                                    playerFarm.setSeed(0);
                                    playerFarmDao.cacheUpdate(playerFarm, roleID);
                                }
                                cell.setPlantID(0);
                                cell.setPlaceTime(0);
                                cell.setBirthTime(0);
                                cell.setCookingTime(0);
                                cell.setHarvestNum(0);
                                cell.setFeedID(0);
                                int ecology = cell.getGreen() - plantConfig.getEatGreenTo();
                                cell.setGreen(plantConfig.getEatGreenTo());
                                cellList.add(cell.toParkCell());
                                ecologyRun.run(ecology);
                            }
                            break;
                        }
                    //}
                }
                ConfigFarmCulture cultureConfig = cultureConf.getPlant(cell.getPlantID());
                if (ObjectUtils.isNotEmpty(cultureConfig)) {
                    //if ((cell.getFeedID() == configAnimal.getEatPlantID()) && (configAnimal.getEatPlantType() == cultureConfig.getEatType())) {
                        Date plantCookingTime = new Date(cell.getBirthTime() + cell.getCookingTime());
                        if (nowTime.getTime() < plantCookingTime.getTime()) {
                            // 植物未成熟
                            continue;
                        }
                        if (configAnimal.getEatNum() > animal.getValue().getEatNum() + cell.getFeedNum()) {
                            // 没吃饱
                            log.info("roleID {} animal {} <<eat>> plant {} ", roleID, animal.getValue().toString(), cell.toString());
                            animal.getValue().setEatNum(animal.getValue().getEatNum() + cell.getFeedNum());
                            QueryParamMap queryParams = new QueryParamMap();
                            queryParams.put("roleID",roleID);
                            queryParams.put("x",cell.getX());
                            queryParams.put("y",cell.getY());
                            if(ObjectUtils.isEmpty(playerFarmDao)){
                                playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
                            }
                            PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
                            if (playerFarm != null) {
                                playerFarm.setSeed(0);
                                playerFarmDao.cacheUpdate(playerFarm, roleID);
                            }
                            cell.setPlantID(0);
                            cell.setPlaceTime(0);
                            cell.setBirthTime(0);
                            cell.setCookingTime(0);
                            cell.setHarvestNum(0);
                            cell.setFeedID(0);
                            cell.setFeedNum(0);
                            int ecology = cell.getGreen() - cultureConfig.getEatGreenTo();
                            cell.setGreen(cultureConfig.getEatGreenTo());
                            cellList.add(cell.toParkCell());
                            ecologyRun.run(ecology);
                            if(animal.getValue().getStatus() == ParkStatus.Hunger_VALUE) {
                                animal.getValue().setStatus(ParkStatus.Normal_VALUE);
                                animalRun.run(animal.getValue());
                            }
                        } else {
                            // 吃饱了
                            log.info("roleID {} animal {} <<eat>> plant {} ", roleID, animal.getValue().toString(), cell.toString());
                            cell.setFeedNum(cell.getFeedNum() - (configAnimal.getEatNum() - animal.getValue().getEatNum()));
                            animal.getValue().setEatNum(configAnimal.getEatNum());
                            if(animal.getValue().getStatus() == ParkStatus.Hunger_VALUE) {
                                animal.getValue().setStatus(ParkStatus.Normal_VALUE);
                            }
                            Date animalCookingTimeDate = new Date(animal.getValue().getBirthTime() + animal.getValue().getCookingTime());
                            if (nowTime.getTime() >= animalCookingTimeDate.getTime()) { // 成熟时间到了
                                animalRun.run(animal.getValue());
                                animal.getValue().setNtfFlag(true);
                            }
                            if (cell.getFeedNum() == 0) {
                                QueryParamMap queryParams = new QueryParamMap();
                                queryParams.put("roleID",roleID);
                                queryParams.put("x",cell.getX());
                                queryParams.put("y",cell.getY());
                                if(ObjectUtils.isEmpty(playerFarmDao)){
                                    playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
                                }
                                PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
                                if (playerFarm != null) {
                                    playerFarm.setSeed(0);
                                    playerFarmDao.cacheUpdate(playerFarm, roleID);
                                }
                                cell.setPlantID(0);
                                cell.setPlaceTime(0);
                                cell.setBirthTime(0);
                                cell.setCookingTime(0);
                                cell.setHarvestNum(0);
                                cell.setFeedID(0);
                                int ecology = cell.getGreen() - cultureConfig.getEatGreenTo();
                                cell.setGreen(cultureConfig.getEatGreenTo());
                                cellList.add(cell.toParkCell());
                                ecologyRun.run(ecology);
                            }
                            break;
                        }
                    //}
                }
            }
            if (animal.getValue().getEatNum() >= configAnimal.getEatNum()) {// 吃饱了
                if(animal.getValue().getStatus() == ParkStatus.Hunger_VALUE) {
                    animal.getValue().setStatus(ParkStatus.Normal_VALUE);
                }
                Date animalCookingTimeDate = new Date(animal.getValue().getBirthTime() + animal.getValue().getCookingTime());
                if (nowTime.getTime() >= animalCookingTimeDate.getTime()) { // 成熟时间到了
                    animalRun.run(animal.getValue());
                    animal.getValue().setNtfFlag(true);
                }
            } else {
                //zcq 动物处于饥饿状态
                if(animal.getValue().getStatus() != ParkStatus.Hunger_VALUE) {
                    animal.getValue().setStatus(ParkStatus.Hunger_VALUE);
                    animalRun.run(animal.getValue());
                }
            }
        }
        // 被吃掉的格子同步给前端
        if (cellList.size() > 0) {
            cellRun.run(cellList);
        }
        // 没有需要吃草的动物
        if(!hasAnimal) {
        	return hasAnimal;
        }
        // 检查是否还有没吃完的植物
        for (ParkCellUnit cell : cells) {
            if (cell.getPlantID() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getUseEcology(long roleID) {
        return getReadModel(roleID, ParkModel.class).getUseEcology();
    }

    @Override
    public int changeUseEcology(long roleID, int change) {
        return getWriteModel(roleID, ParkModel.class).changeUseEcology(change);
    }

    @Override
    public int getHoneyCD(long roleID) {
        long honeyDrawTime = getReadModel(roleID, ParkModel.class).getHoneyDrawTime();
        if (honeyDrawTime == 0) {
            return 0;
        }
        int cd = DateUtil.secondsBetween(new Date(), new Date(honeyDrawTime));
        if (cd <= 0) {
            return 0;
        }
        return cd;
    }

    @Override
    public int parkDrawHoney(long roleID) {
        ParkModel model = getWriteModel(roleID, ParkModel.class);
        long honeyDrawTime = model.getHoneyDrawTime();
        if (honeyDrawTime == 0 || System.currentTimeMillis() >= honeyDrawTime) {
            Date date = DateUtil.plusNow(TimeUnit.MINUTES, ConfigSundryConf.drawHoneyRewardCD);
            model.setHoneyDrawTime(date.getTime());
            return ConfigSundryConf.drawHoneyRewardCD * 60;
        }
        throw new CommonException(ErrorID.PARK_HONEY_DRAW_CD);
    }

    @Override
    public ParkAnimalUnit parkAnimalFeed(ParkAnimalFeedReq req) {
        ParkModel model = getWriteModel(req.getRoleId(), ParkModel.class);
        Map<String, ParkAnimalUnit> parkAnimalMap = model.getParkAnimalMap();
        ParkAnimalUnit parkAnimalUnit = parkAnimalMap.get(req.getAnimalTimeID());
        if (parkAnimalUnit == null) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR, req.getAnimalTimeID());
        }
        parkAnimalUnit.setEatNum(parkAnimalUnit.getEatNum() + req.getFoodCount());
        ConfigFarmParkAnimalConf farmParkAnimalConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMPARKANIMAL);
        if(farmParkAnimalConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigFarmParkAnimal farmParkAnimal = farmParkAnimalConf.getAnimal(parkAnimalUnit.getAnimalID());
        // 喂饱了
        if (parkAnimalUnit.getEatNum() >= farmParkAnimal.getEatNum()) {
            Date cookingTime = new Date(parkAnimalUnit.getBirthTime() + farmParkAnimal.getCookingTime() * 60000L);
            // 成熟时间到了
            if (System.currentTimeMillis() >= cookingTime.getTime()) {
                // 生态园动物成熟变化推送
                ParkAnimalMatureNtf.Builder builder = ParkAnimalMatureNtf.newBuilder();
                builder.setAnimalTimeID(parkAnimalUnit.getAnimalTimeID());
                builder.setAnimalID(parkAnimalUnit.getAnimalID());
                PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(req.getRoleId());
                BaseLogicChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), builder.build());
            }
        }
        return parkAnimalUnit;
    }

	@Override
	public int parkDrawPrize(long roleID) {
		CommonModel commonModel = getWriteModel(roleID, CommonModel.class);
		if(commonModel.getParkDrawPrize()) {
            throw new CommonException(ErrorID.REWARD_RECEIVED);
		}
		ParkModel model = getReadModel(roleID, ParkModel.class);
		Map<String, ParkAnimalUnit> parkAnimalMap = model.getParkAnimalMap();
		if(parkAnimalMap == null || parkAnimalMap.size() == 0) {
			return 0;
		}
		int goldNum = 0;
		ConfigItemsConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_ITEMS);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigFarmParkAnimalConf farmParkAnimalConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMPARKANIMAL);
        if(farmParkAnimalConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        for(Map.Entry<String, ParkAnimalUnit> entry : parkAnimalMap.entrySet()) {
			ConfigFarmParkAnimal animalConfig = farmParkAnimalConf.getAnimal(entry.getValue().getAnimalID());
			if(animalConfig.getUncommon() == 1) {
				ConfigItems config = conf.getItem(entry.getValue().getAnimalID());
                if(ObjectUtils.isNotEmpty(config)){
                    goldNum += config.getGold();
                }
			}
		}
		commonModel.setParkDrawPrize(true);
		return goldNum;
	}

//    @Override
//    public Integer parkHarvestFishSpeedup(long roleID, Integer index, IArgumentRunnable<ConfigPoolFishs> configRun) {
//        ParkModel model = getWriteModel(roleID, ParkModel.class);
//        Map<Integer, ParkFishUnit> fishMap = model.getFishMap();
//        ConfigPoolFishsConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_POOLFISHS);
//        if(conf == null){
//            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
//        }
//
//        if (fishMap != null && fishMap.containsKey(index)) {
//            ParkFishUnit fish = fishMap.get(index);
//            if(fish != null){
//                Date nowTime = new Date();
//                Date cookingTimeDate = new Date(fish.getBirthTime() + fish.getCookingTime());
//                if (nowTime.getTime() < cookingTimeDate.getTime()) {
//                    long count;
//                    int countDown = DateUtil.minutesBetween(nowTime, cookingTimeDate);
//                    if(countDown%ConfigSundryConf.accelerateConsumption > 0){
//                        count = (countDown/ConfigSundryConf.accelerateConsumption + 1);
//                    }else{
//                        count = (countDown/ConfigSundryConf.accelerateConsumption);
//                    }
//                    PlayerRole playerRole = ServiceProvider.getPlayerService().costDiamond(roleID, count);
//                    if(ObjectUtils.isEmpty(playerRoleDao)){
//                        playerRoleDao = SpringContext.getBean(PlayerRoleDao.class);
//                    }
//                    playerRoleDao.cacheUpdate(playerRole);
//                    EventProvider.postPlayerAttrEvent(roleID, PlayerAttrEnum.DIAMOND, playerRole.getDiamond());
//                    log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.DIAMOND.getKey(), PlayerAttrEnum.DIAMOND.getKey(), "钻石", playerRole.getDiamond(), -count, ResourceBillEnum.mallBuy, ResourceBillEnum.mallBuy.getDesc());
//                }
//
//                ConfigPoolFishs config = conf.getPoolFish(fish.getFishID());
//                configRun.run(config);
//                model.getFishMap().remove(index);
//                return index;
//            }
//        }
//        return 0;
//    }
//
//    @Override
//    public AnimalPoint parkHarvestAnimalSpeedup(long roleID, AnimalPoint point, IArgumentKeyValueRunnable<ConfigFarmParkAnimal, Boolean> configRun) {
//        ParkModel model = getWriteModel(roleID, ParkModel.class);
//        List<String> animalClearIDs = Lists.newArrayList();
//        Map<String, ParkAnimalUnit> parkAnimalMap = model.getParkAnimalMap();
//        List<ParkAnimal> animals = Lists.newArrayList();
//        ConfigFarmParkAnimalConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMPARKANIMAL);
//        if(conf == null){
//            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
//        }
//        Date nowTime = DateUtil.getCurrentDate();
//        ParkAnimal.Builder animalBuilder = ParkAnimal.newBuilder();
//
//        ParkAnimalUnit animal = parkAnimalMap.get(point.getAnimalTimeID());
//        if (animal == null || animal.getStatus() != ParkStatus.Normal_VALUE) {
//            return null;
//        }
//
//        Date cookingTimeDate = new Date(animal.getBirthTime() + animal.getCookingTime());
//        if (nowTime.getTime() < cookingTimeDate.getTime()) {
//            long count;
//            int countDown = DateUtil.minutesBetween(nowTime, cookingTimeDate);
//            if(countDown%ConfigSundryConf.accelerateConsumption > 0){
//                count = (countDown/ConfigSundryConf.accelerateConsumption + 1);
//            }else{
//                count = (countDown/ConfigSundryConf.accelerateConsumption);
//            }
//            PlayerRole playerRole = ServiceProvider.getPlayerService().costDiamond(roleID, count);
//            if(ObjectUtils.isEmpty(playerRoleDao)){
//                playerRoleDao = SpringContext.getBean(PlayerRoleDao.class);
//            }
//            playerRoleDao.cacheUpdate(playerRole);
//            EventProvider.postPlayerAttrEvent(roleID, PlayerAttrEnum.DIAMOND, playerRole.getDiamond());
//            log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.DIAMOND.getKey(), PlayerAttrEnum.DIAMOND.getKey(), "钻石", playerRole.getDiamond(), -count, ResourceBillEnum.mallBuy, ResourceBillEnum.mallBuy.getDesc());
//        }
//
//        animal.setHarvestNum(animal.getHarvestNum() + 1);
//        animal.setX(point.getX());
//        animal.setY(point.getY());
//        ConfigFarmParkAnimal config = conf.getAnimal(animal.getAnimalID());
//        if (config.getHarvestCount() > 0 && config.getHarvestCount() <= animal.getHarvestNum()) {
//            // 收获次数上限
//            animal.setStatus(ParkStatus.Wither_VALUE);
//            animalClearIDs.add(point.getAnimalTimeID());
//        } else if (config.getLifeTime() > 0) {
//            Date liveTime = new Date(animal.getPlaceTime() + config.getLifeTime() * 1000);
//            if (nowTime.getTime() >= liveTime.getTime()) {
//                // 生存时间上限
//                animal.setStatus(ParkStatus.Wither_VALUE);
//                animalClearIDs.add(point.getAnimalTimeID());
//            }
//        }
//        if (animal.getStatus() == ParkStatus.Wither_VALUE) {
//            // 更新动物占用的人口
//            model.changeUseEcology(-config.getCostEcology());
//            //MapUtil.fundInt(model.getParkCount(), animal.getAnimalID(), -1);
//            configRun.run(config, true);
//        } else {
//            // 还没有枯萎，重新吃植物
//            animal.setBirthTime(nowTime.getTime());
//            animal.setEatTime(nowTime.getTime());
//            animal.setNtfFlag(false);
//            animal.setEatNum(0);
//            configRun.run(config, false);
//        }
//        animals.add(animal.toParkAnimal(animalBuilder, nowTime, config));
//
//        if (animals.size() > 0) {
//            // 生态园动物变化推送
//            ParkAnimalNtf.Builder parkAnimalNtf = ParkAnimalNtf.newBuilder();
//            parkAnimalNtf.addAllAnimals(animals);
//            PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
//            BaseLogicChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), parkAnimalNtf.build());
//        }
//        //zcq 动物收获之后，直接删掉，不产生屎
//        for (String animalTimeID : animalClearIDs) {
//            ParkAnimalUnit parkAnimalUnit = parkAnimalMap.get(animalTimeID);
//            if(parkAnimalUnit != null) {
//                MapUtil.fundInt(model.getParkCount(), parkAnimalUnit.getAnimalID(), -1);
//                parkAnimalMap.remove(animalTimeID);
//            }
//        }
//        return point;
//    }
//
//    @Override
//    public CellPoint parkHarvestPlantSpeedup(long roleID, CellPoint point, IArgumentRunnable<Integer> ecologyRun) {
//        ParkModel model = getWriteModel(roleID, ParkModel.class);
//        MapSubMap<Integer, Integer, ParkCellUnit> cellMap = model.getCellMap();
//        List<ParkCell> cells = Lists.newArrayList();
//        Date nowTime = DateUtil.getCurrentDate();
//        int ecology = 0;
//
//        int x = point.getX();
//        int y = point.getY();
//        ParkCellUnit cell = cellMap.get(x, y);
//        if (cell.getPlantID() <= 0 || cell.getStatus() == ParkStatus.Wither_VALUE) {
//            return null;
//        }
//
//        Date cookingTimeDate = new Date(cell.getBirthTime() + cell.getCookingTime());
//        if (nowTime.getTime() < cookingTimeDate.getTime()) {
//            long count;
//            int countDown = DateUtil.minutesBetween(nowTime, cookingTimeDate);
//            if(countDown%ConfigSundryConf.accelerateConsumption > 0){
//                count = (countDown/ConfigSundryConf.accelerateConsumption + 1);
//            }else{
//                count = (countDown/ConfigSundryConf.accelerateConsumption);
//            }
//            PlayerRole playerRole = ServiceProvider.getPlayerService().costDiamond(roleID, count);
//            if(ObjectUtils.isEmpty(playerRoleDao)){
//                playerRoleDao = SpringContext.getBean(PlayerRoleDao.class);
//            }
//            playerRoleDao.cacheUpdate(playerRole);
//            EventProvider.postPlayerAttrEvent(roleID, PlayerAttrEnum.DIAMOND, playerRole.getDiamond());
//            log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.DIAMOND.getKey(), PlayerAttrEnum.DIAMOND.getKey(), "钻石", playerRole.getDiamond(), -count, ResourceBillEnum.mallBuy, ResourceBillEnum.mallBuy.getDesc());
//        }
//
//        cell.setHarvestNum(cell.getHarvestNum() + 1);
//        ConfigFarmCultureConf cultureConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMCULTURE);
//        if(cultureConf == null){
//            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
//        }
//        ConfigFarmParkTreeConf parkTreeConf    = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMPARKTREE);
//        if(parkTreeConf == null){
//            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
//        }
//        ConfigFarmParkPlantConf parkPlantConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMPARKPLANT);
//        if(parkPlantConf == null){
//            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
//        }
//
//        ConfigFarmCulture farmCultureConfig = cultureConf.getPlant(cell.getPlantID());
//        if(ObjectUtils.isNotEmpty(farmCultureConfig)){
//            if (farmCultureConfig.getProductId() == 1) {
//                ServiceProvider.getCommonService().addAttrBill(roleID, PlayerAttrEnum.GOLD.getKey(), farmCultureConfig.getProductNum(), ResourceBillEnum.parkHarvestTree);
//                EventProvider.postSyncAttrEvent(roleID);
//            } else if (farmCultureConfig.getProductId() == 2) {
//                ServiceProvider.getCommonService().addAttrBill(roleID, PlayerAttrEnum.DIAMOND.getKey(), farmCultureConfig.getProductNum(), ResourceBillEnum.parkHarvestTree);
//                EventProvider.postSyncAttrEvent(roleID);
//            } else {
//                ServiceProvider.getItemService().addItemBill(roleID, farmCultureConfig.getProductId(), farmCultureConfig.getProductNum(), ResourceBillEnum.parkHarvestTree, true, false);
//                EventProvider.postSyncItemEvent(roleID);
//            }
//            if(farmCultureConfig.getProductExp() > 0) {
//                ServiceProvider.getCommonService().addAttrBill(roleID, PlayerAttrEnum.EXP.getKey(), farmCultureConfig.getProductExp(), ResourceBillEnum.parkHarvestTree);
//                EventProvider.postSyncAttrEvent(roleID);
//            }
//
//            if (farmCultureConfig.getHarvestNum() <= cell.getHarvestNum()) {
//                ecology += changeCellGreen(cell, farmCultureConfig.getHarvestGreenTo());
//                if(farmCultureConfig.getProductId() == 1) {
//                    cell.setPlantID(0);
//                    cell.setPlaceTime(0);
//                    cell.setBirthTime(0);
//                    cell.setCookingTime(0);
//                    cell.setHarvestNum(0);
//                    cell.setFeedID(0);
//                    cell.setFeedNum(0);
//                    cell.setStatus(ParkStatus.Normal_VALUE);
//                    cells.add(cell.toParkCropsCell());
//                    QueryParamMap queryParams = new QueryParamMap();
//                    queryParams.put("roleID",roleID);
//                    queryParams.put("x",cell.getX());
//                    queryParams.put("y",cell.getY());
//                    if(ObjectUtils.isEmpty(playerFarmDao)){
//                        playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
//                    }
//                    PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
//                    if (playerFarm != null) {
//                        playerFarm.setSeed(0);
//                        playerFarmDao.cacheUpdate(playerFarm, roleID);
//                    }
//                }else {
//                    cell.setPlantID(0);
//                    cell.setPlaceTime(0);
//                    cell.setBirthTime(0);
//                    cell.setCookingTime(0);
//                    cell.setHarvestNum(0);
//                    cell.setFeedID(0);
//                    cell.setFeedNum(0);
//                    cell.setStatus(ParkStatus.Normal_VALUE);
//                    cells.add(cell.toParkCropsCell());
//                    QueryParamMap queryParams = new QueryParamMap();
//                    queryParams.put("roleID",roleID);
//                    queryParams.put("x",cell.getX());
//                    queryParams.put("y",cell.getY());
//                    if(ObjectUtils.isEmpty(playerFarmDao)){
//                        playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
//                    }
//                    PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
//                    if (playerFarm != null) {
//                        playerFarm.setSeed(0);
//                        playerFarmDao.cacheUpdate(playerFarm, roleID);
//                    }
//                }
//                // 左
//                if (x - 1 >= 0 && !ConstantGame.checkInvalid(x - 1, y)) {
//                    cell = cellMap.get(x - 1, y);
//                    int change = changeCellGreen(cell, farmCultureConfig.getGreenTo());
//                    if (change > 0) {
//                        ecology += change;
//                        cells.add(cell.toParkCropsCell());
//                    }
//                }
//                // 右
//                if (x + 1 < ConfigSundryConf.parkMapSize && !ConstantGame.checkInvalid(x + 1, y)) {
//                    cell = cellMap.get(x + 1, y);
//                    int change = changeCellGreen(cell, farmCultureConfig.getGreenTo());
//                    if (change > 0) {
//                        ecology += change;
//                        cells.add(cell.toParkCropsCell());
//                    }
//                }
//                // 上
//                if (y - 1 >= 0 && !ConstantGame.checkInvalid(x, y - 1)) {
//                    cell = cellMap.get(x, y - 1);
//                    int change = changeCellGreen(cell, farmCultureConfig.getGreenTo());
//                    if (change > 0) {
//                        ecology += change;
//                        cells.add(cell.toParkCropsCell());
//                    }
//                }
//                // 下
//                if (y + 1 < ConfigSundryConf.parkMapSize && !ConstantGame.checkInvalid(x, y + 1)) {
//                    cell = cellMap.get(x, y + 1);
//                    int change = changeCellGreen(cell, farmCultureConfig.getGreenTo());
//                    if (change > 0) {
//                        ecology += change;
//                        cells.add(cell.toParkCropsCell());
//                    }
//                }
//            } else {
//                cell.setBirthTime(System.currentTimeMillis());
//                cells.add(cell.toParkCropsCell());
//            }
//        }
//
//        ConfigFarmParkPlant parkPlantConfig = parkPlantConf.getPlant(cell.getPlantID());
//        if(ObjectUtils.isNotEmpty(parkPlantConfig)){
//            if (parkPlantConfig.getProductId() == 1) {
//                ServiceProvider.getCommonService().addAttrBill(roleID, PlayerAttrEnum.GOLD.getKey(), parkPlantConfig.getProductNum(), ResourceBillEnum.parkHarvestTree);
//                EventProvider.postSyncAttrEvent(roleID);
//            } else if (parkPlantConfig.getProductId() == 2) {
//                ServiceProvider.getCommonService().addAttrBill(roleID, PlayerAttrEnum.DIAMOND.getKey(), parkPlantConfig.getProductNum(), ResourceBillEnum.parkHarvestTree);
//                EventProvider.postSyncAttrEvent(roleID);
//            } else {
//                ServiceProvider.getItemService().addItemBill(roleID, parkPlantConfig.getProductId(), parkPlantConfig.getProductNum(), ResourceBillEnum.parkHarvestTree, true, false);
//                EventProvider.postSyncItemEvent(roleID);
//            }
//            if(parkPlantConfig.getProductExp() > 0) {
//                ServiceProvider.getCommonService().addAttrBill(roleID, PlayerAttrEnum.EXP.getKey(), parkPlantConfig.getProductExp(), ResourceBillEnum.parkHarvestTree);
//                EventProvider.postSyncAttrEvent(roleID);
//            }
//
//            if (parkPlantConfig.getHarvestNum() <= cell.getHarvestNum()) {
//                ecology += changeCellGreen(cell, parkPlantConfig.getHarvestGreenTo());
//                if(parkPlantConfig.getProductId() == 1) {
//                    cell.setPlantID(0);
//                    cell.setPlaceTime(0);
//                    cell.setBirthTime(0);
//                    cell.setCookingTime(0);
//                    cell.setHarvestNum(0);
//                    cell.setFeedID(0);
//                    cell.setFeedNum(0);
//                    cell.setStatus(ParkStatus.Normal_VALUE);
//                    cells.add(cell.toParkCropsCell());
//                    QueryParamMap queryParams = new QueryParamMap();
//                    queryParams.put("roleID",roleID);
//                    queryParams.put("x",cell.getX());
//                    queryParams.put("y",cell.getY());
//                    if(ObjectUtils.isEmpty(playerFarmDao)){
//                        playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
//                    }
//                    PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
//                    if (playerFarm != null) {
//                        playerFarm.setSeed(0);
//                        playerFarmDao.cacheUpdate(playerFarm, roleID);
//                    }
//                }else {
//                    cell.setPlantID(0);
//                    cell.setPlaceTime(0);
//                    cell.setBirthTime(0);
//                    cell.setCookingTime(0);
//                    cell.setHarvestNum(0);
//                    cell.setFeedID(0);
//                    cell.setFeedNum(0);
//                    cell.setStatus(ParkStatus.Normal_VALUE);
//                    cells.add(cell.toParkCropsCell());
//                    QueryParamMap queryParams = new QueryParamMap();
//                    queryParams.put("roleID",roleID);
//                    queryParams.put("x",cell.getX());
//                    queryParams.put("y",cell.getY());
//                    if(ObjectUtils.isEmpty(playerFarmDao)){
//                        playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
//                    }
//                    PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
//                    if (playerFarm != null) {
//                        playerFarm.setSeed(0);
//                        playerFarmDao.cacheUpdate(playerFarm, roleID);
//                    }
//                }
//                // 左
//                if (x - 1 >= 0 && !ConstantGame.checkInvalid(x - 1, y)) {
//                    cell = cellMap.get(x - 1, y);
//                    int change = changeCellGreen(cell, parkPlantConfig.getGreenTo());
//                    if (change > 0) {
//                        ecology += change;
//                        cells.add(cell.toParkCropsCell());
//                    }
//                }
//                // 右
//                if (x + 1 < ConfigSundryConf.parkMapSize && !ConstantGame.checkInvalid(x + 1, y)) {
//                    cell = cellMap.get(x + 1, y);
//                    int change = changeCellGreen(cell, parkPlantConfig.getGreenTo());
//                    if (change > 0) {
//                        ecology += change;
//                        cells.add(cell.toParkCropsCell());
//                    }
//                }
//                // 上
//                if (y - 1 >= 0 && !ConstantGame.checkInvalid(x, y - 1)) {
//                    cell = cellMap.get(x, y - 1);
//                    int change = changeCellGreen(cell, parkPlantConfig.getGreenTo());
//                    if (change > 0) {
//                        ecology += change;
//                        cells.add(cell.toParkCropsCell());
//                    }
//                }
//                // 下
//                if (y + 1 < ConfigSundryConf.parkMapSize && !ConstantGame.checkInvalid(x, y + 1)) {
//                    cell = cellMap.get(x, y + 1);
//                    int change = changeCellGreen(cell, parkPlantConfig.getGreenTo());
//                    if (change > 0) {
//                        ecology += change;
//                        cells.add(cell.toParkCropsCell());
//                    }
//                }
//            } else {
//                cell.setBirthTime(System.currentTimeMillis());
//                cells.add(cell.toParkCropsCell());
//            }
//        }
//
//        ConfigFarmParkTree parkTreeConfig = parkTreeConf.getPlant(cell.getPlantID());
//        if(ObjectUtils.isNotEmpty(parkTreeConfig)){
//            if (parkTreeConfig.getProductId() == 1) {
//                ServiceProvider.getCommonService().addAttrBill(roleID, PlayerAttrEnum.GOLD.getKey(), parkTreeConfig.getProductNum(), ResourceBillEnum.parkHarvestTree);
//                EventProvider.postSyncAttrEvent(roleID);
//            } else if (parkTreeConfig.getProductId() == 2) {
//                ServiceProvider.getCommonService().addAttrBill(roleID, PlayerAttrEnum.DIAMOND.getKey(), parkTreeConfig.getProductNum(), ResourceBillEnum.parkHarvestTree);
//                EventProvider.postSyncAttrEvent(roleID);
//            } else {
//                ServiceProvider.getItemService().addItemBill(roleID, parkTreeConfig.getProductId(), parkTreeConfig.getProductNum(), ResourceBillEnum.parkHarvestTree, true, false);
//                EventProvider.postSyncItemEvent(roleID);
//            }
//            if(parkTreeConfig.getProductExp() > 0) {
//                ServiceProvider.getCommonService().addAttrBill(roleID, PlayerAttrEnum.EXP.getKey(), parkTreeConfig.getProductExp(), ResourceBillEnum.parkHarvestTree);
//                EventProvider.postSyncAttrEvent(roleID);
//            }
//            if (parkTreeConfig.getHarvestNum() <= cell.getHarvestNum()) {
//                ecology += changeCellGreen(cell, parkTreeConfig.getHarvestGreenTo());
//                if(parkTreeConfig.getProductId() == 1) {
//                    cell.setPlantID(0);
//                    cell.setPlaceTime(0);
//                    cell.setBirthTime(0);
//                    cell.setCookingTime(0);
//                    cell.setHarvestNum(0);
//                    cell.setFeedID(0);
//                    cell.setFeedNum(0);
//                    cell.setStatus(ParkStatus.Normal_VALUE);
//                    cells.add(cell.toParkCropsCell());
//                    QueryParamMap queryParams = new QueryParamMap();
//                    queryParams.put("roleID",roleID);
//                    queryParams.put("x",cell.getX());
//                    queryParams.put("y",cell.getY());
//                    if(ObjectUtils.isEmpty(playerFarmDao)){
//                        playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
//                    }
//                    PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
//                    if (playerFarm != null) {
//                        playerFarm.setSeed(0);
//                        playerFarmDao.cacheUpdate(playerFarm, roleID);
//                    }
//                }else {
//                    cell.setPlantID(0);
//                    cell.setPlaceTime(0);
//                    cell.setBirthTime(0);
//                    cell.setCookingTime(0);
//                    cell.setHarvestNum(0);
//                    cell.setFeedID(0);
//                    cell.setFeedNum(0);
//                    cell.setStatus(ParkStatus.Normal_VALUE);
//                    cells.add(cell.toParkCropsCell());
//                    QueryParamMap queryParams = new QueryParamMap();
//                    queryParams.put("roleID",roleID);
//                    queryParams.put("x",cell.getX());
//                    queryParams.put("y",cell.getY());
//                    if(ObjectUtils.isEmpty(playerFarmDao)){
//                        playerFarmDao = SpringContext.getBean(PlayerFarmDao.class);
//                    }
//                    PlayerFarm playerFarm = playerFarmDao.cacheSelect(queryParams, roleID);
//                    if (playerFarm != null) {
//                        playerFarm.setSeed(0);
//                        playerFarmDao.cacheUpdate(playerFarm, roleID);
//                    }
//                }
//                // 左
//                if (x - 1 >= 0 && !ConstantGame.checkInvalid(x - 1, y)) {
//                    cell = cellMap.get(x - 1, y);
//                    int change = changeCellGreen(cell, parkPlantConfig.getGreenTo());
//                    if (change > 0) {
//                        ecology += change;
//                        cells.add(cell.toParkCropsCell());
//                    }
//                }
//                // 右
//                if (x + 1 < ConfigSundryConf.parkMapSize && !ConstantGame.checkInvalid(x + 1, y)) {
//                    cell = cellMap.get(x + 1, y);
//                    int change = changeCellGreen(cell, parkPlantConfig.getGreenTo());
//                    if (change > 0) {
//                        ecology += change;
//                        cells.add(cell.toParkCropsCell());
//                    }
//                }
//                // 上
//                if (y - 1 >= 0 && !ConstantGame.checkInvalid(x, y - 1)) {
//                    cell = cellMap.get(x, y - 1);
//                    int change = changeCellGreen(cell, parkPlantConfig.getGreenTo());
//                    if (change > 0) {
//                        ecology += change;
//                        cells.add(cell.toParkCropsCell());
//                    }
//                }
//                // 下
//                if (y + 1 < ConfigSundryConf.parkMapSize && !ConstantGame.checkInvalid(x, y + 1)) {
//                    cell = cellMap.get(x, y + 1);
//                    int change = changeCellGreen(cell, parkPlantConfig.getGreenTo());
//                    if (change > 0) {
//                        ecology += change;
//                        cells.add(cell.toParkCropsCell());
//                    }
//                }
//            } else {
//                cell.setBirthTime(System.currentTimeMillis());
//                cells.add(cell.toParkCropsCell());
//            }
//        }
//
//        // 生态值变化
//        if (ecology > 0) {
//            ecologyRun.run(ecology);
//        }
//        if (cells.size() > 0) {
//            // 生态园地图变化推送
//            ParkCellNtf.Builder parkCellNtf = ParkCellNtf.newBuilder();
//            parkCellNtf.addAllCells(cells);
//            PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
//            BaseLogicChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), parkCellNtf.build());
//        }
//        return point;
//    }

    @Override
    public CellPoint parkHarvestPlantSpeedup(long roleID, CellPoint point) {
        ParkModel model = getWriteModel(roleID, ParkModel.class);
        MapSubMap<Integer, Integer, ParkCellUnit> cellMap = model.getCellMap();
        List<ParkCell> cells = Lists.newArrayList();
        Date nowTime = DateUtil.getCurrentDate();

        int x = point.getX();
        int y = point.getY();
        ParkCellUnit cell = cellMap.get(x, y);
        if (cell.getPlantID() <= 0 || cell.getStatus() == ParkStatus.Wither_VALUE) {
            return null;
        }

        Date cookingTimeDate = new Date(cell.getBirthTime() + cell.getCookingTime());
        if (nowTime.getTime() < cookingTimeDate.getTime()) {
            long count;
            int countDown = DateUtil.minutesBetween(nowTime, cookingTimeDate);
            if(countDown%ConfigSundryConf.accelerateConsumption > 0){
                count = (countDown/ConfigSundryConf.accelerateConsumption + 1);
            }else{
                count = (countDown/ConfigSundryConf.accelerateConsumption);
            }
            PlayerRole playerRole = ServiceProvider.getPlayerService().costDiamond(roleID, count);
            if(ObjectUtils.isEmpty(playerRoleDao)){
                playerRoleDao = SpringContext.getBean(PlayerRoleDao.class);
            }
            playerRoleDao.cacheUpdate(playerRole);
            EventProvider.postPlayerAttrEvent(roleID, PlayerAttrEnum.DIAMOND, playerRole.getDiamond());
            log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.DIAMOND.getKey(), PlayerAttrEnum.DIAMOND.getKey(), "钻石", playerRole.getDiamond(), -count, ResourceBillEnum.mallBuy, ResourceBillEnum.mallBuy.getDesc());
            cell.setBirthTime(cell.getBirthTime() - DateUtil.secondsBetween(nowTime, cookingTimeDate)*1000);
            cellMap.put(x, y, cell);
        }

        // 生态园地图变化推送
        ParkCellNtf.Builder parkCellNtf = ParkCellNtf.newBuilder();
        parkCellNtf.addCells(cell.toParkCell());
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        BaseLogicChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), parkCellNtf.build());

        return point;
    }
    @Override
    public AnimalPoint parkHarvestAnimalSpeedup(long roleID, AnimalPoint point) {
        ParkModel model = getWriteModel(roleID, ParkModel.class);
        Map<String, ParkAnimalUnit> parkAnimalMap = model.getParkAnimalMap();
        ParkAnimalUnit parkAnimalUnit = parkAnimalMap.get(point.getAnimalTimeID());
        if (parkAnimalUnit == null || parkAnimalUnit.getStatus() == ParkStatus.Wither_VALUE) {
            return null;
        }
        Date nowTime = DateUtil.getCurrentDate();
        Date cookingTimeDate = new Date(parkAnimalUnit.getBirthTime() + parkAnimalUnit.getCookingTime());
        if (nowTime.getTime() < cookingTimeDate.getTime()) {
            long count;
            int countDown = DateUtil.minutesBetween(nowTime, cookingTimeDate);
            if(countDown%ConfigSundryConf.accelerateConsumption > 0){
                count = (countDown/ConfigSundryConf.accelerateConsumption + 1);
            }else{
                count = (countDown/ConfigSundryConf.accelerateConsumption);
            }
            PlayerRole playerRole = ServiceProvider.getPlayerService().costDiamond(roleID, count);
            if(ObjectUtils.isEmpty(playerRoleDao)){
                playerRoleDao = SpringContext.getBean(PlayerRoleDao.class);
            }
            playerRoleDao.cacheUpdate(playerRole);
            EventProvider.postPlayerAttrEvent(roleID, PlayerAttrEnum.DIAMOND, playerRole.getDiamond());
            log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.DIAMOND.getKey(), PlayerAttrEnum.DIAMOND.getKey(), "钻石", playerRole.getDiamond(), -count, ResourceBillEnum.mallBuy, ResourceBillEnum.mallBuy.getDesc());
            ConfigFarmParkAnimalConf animalConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMPARKANIMAL);
            if(animalConf == null){
                throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
            ConfigFarmParkAnimal configAnimal = animalConf.getAnimal(parkAnimalUnit.getAnimalID());
            parkAnimalUnit.setPlaceTime(nowTime.getTime() - parkAnimalUnit.getCookingTime());
            parkAnimalUnit.setBirthTime(nowTime.getTime() - parkAnimalUnit.getCookingTime());
            parkAnimalUnit.setEatTime(nowTime.getTime() - parkAnimalUnit.getCookingTime());
            parkAnimalUnit.setEatNum(configAnimal.getEatNum());
            parkAnimalUnit.setStatus(ParkStatus.Normal_VALUE);
            parkAnimalUnit.setNtfFlag(true);
            parkAnimalMap.put(point.getAnimalTimeID(), parkAnimalUnit);
        }

        ParkAnimalMatureNtf.Builder builder = ParkAnimalMatureNtf.newBuilder();
        builder.setAnimalTimeID(parkAnimalUnit.getAnimalTimeID());
        builder.setAnimalID(parkAnimalUnit.getAnimalID());
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        BaseLogicChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), builder.build());
        return point;
    }

    @Override
    public Integer parkHarvestFishSpeedup(long roleID, Integer index) {
        ParkModel model = getWriteModel(roleID, ParkModel.class);
        Map<Integer, ParkFishUnit> fishMap = model.getFishMap();
        ConfigPoolFishsConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_POOLFISHS);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }

        if (fishMap != null && fishMap.containsKey(index)) {
            ParkFishUnit fish = fishMap.get(index);
            if(fish != null){
                Date nowTime = new Date();
                Date cookingTimeDate = new Date(fish.getBirthTime() + fish.getCookingTime());
                if (nowTime.getTime() < cookingTimeDate.getTime()) {
                    long count;
                    int countDown = DateUtil.minutesBetween(nowTime, cookingTimeDate);
                    if(countDown%ConfigSundryConf.accelerateConsumption > 0){
                        count = (countDown/ConfigSundryConf.accelerateConsumption + 1);
                    }else{
                        count = (countDown/ConfigSundryConf.accelerateConsumption);
                    }
                    PlayerRole playerRole = ServiceProvider.getPlayerService().costDiamond(roleID, count);
                    if(ObjectUtils.isEmpty(playerRoleDao)){
                        playerRoleDao = SpringContext.getBean(PlayerRoleDao.class);
                    }
                    playerRoleDao.cacheUpdate(playerRole);
                    EventProvider.postPlayerAttrEvent(roleID, PlayerAttrEnum.DIAMOND, playerRole.getDiamond());
                    log.info("roleID:{}, type:{}, resourceID:{}, resourceName:{}, count:{}, change:{}, bill:{}, desc:{}", roleID, PlayerAttrEnum.DIAMOND.getKey(), PlayerAttrEnum.DIAMOND.getKey(), "钻石", playerRole.getDiamond(), -count, ResourceBillEnum.mallBuy, ResourceBillEnum.mallBuy.getDesc());
                    fish.setBirthTime(fish.getBirthTime()-DateUtil.secondsBetween(nowTime, cookingTimeDate)*1000);
                    fishMap.put(index, fish);

                    ParkFishNtf.Builder builder = ParkFishNtf.newBuilder();
                    builder.addFishs(fish.toParkFish());
                    BaseLogicChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), builder.build());
                }
                return index;
            }
        }
        return 0;
    }

    /**
     * 检查是否有已接受的指定行为成长任务
     * @param roleID
     * @param actionEnum
     * @return
     */
    public ConfigTasks checkTaskAction(long roleID, TaskActionEnum actionEnum) {
        ConfigTasksConf conf  = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_TASKS);
        List<? extends ITask> tasks = SpringContext.getBean(PlayerTask1Dao.class).cacheLoadAll(roleID);
        if((tasks != null)&&(tasks.size() > 0)) {
            for (int i = 0; i < tasks.size(); i++) {
                PlayerTask1 task = (PlayerTask1) tasks.get(i);
                // 任务没有接受
                if (task.getState() != TaskState.accept.getState()) {
                    continue;
                }
                // 不是对应的行为任务
                if ((task.getActionType() == actionEnum.getType())
                        ||(task.getActionType1() == actionEnum.getType())) {
                    ConfigTasks config = conf.getTask(task.getTaskID());
                    if (config != null) {
                        return config;
                    }
                }
            }
        }
        return null;
    }
}