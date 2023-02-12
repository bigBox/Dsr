package com.dj.serverplayer.handler;

import com.dj.domain.config.*;
import com.dj.domain.constant.ConstantGame;
import com.dj.domain.data.RobMap;
import com.dj.domain.data.game.SceneCellUnit;
import com.dj.domain.enums.AchievementActionEnum;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.util.math.RandomUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.common.SceneUpdateType;
import com.dj.protobuf.rob.*;
import com.dj.servercore.conf.*;
import com.dj.servercore.server.base.AbsServer;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.EventManager;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zcq
 * @description 盗墓业务处理
 * @date 2019年4月17日
 */
@Slf4j
@Component
public class RobHandler extends BaseHandler {

    private Map<Long, RobMap> roleRobMap = Maps.newHashMap();

    /**
     *	进入盗墓地图
     *
     * @param roleID
     * @param req
     * @param builder
     * @return
     */
    public void robJoinMap(long roleID, RobMapReq req, RobMapRsp.Builder builder) {
        ConfigRobCfgConf robCfgConf = ConfManager.getInstance().getConfigRobCfgConf();
        if(robCfgConf == null){
            log.error("robJoinMap ConfigRobCfgConf robCfgConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigRobCfg robCfg = robCfgConf.getCfg(req.getMapId());
        // 检查金币和道具是否足够
        checkGoldEnough(roleID, robCfg.getInputGoldNum());
        int itemID = robCfg.getInputItemId();
        int itemNum = robCfg.getInputItemNum();
        for (int i = 0; i < itemNum; i++) {
            checkItemEnough(roleID, itemID+i, 1);
        }
        // 扣除在异步处理见@class SingleEventListener @method listenRobMapEvent
        // 生成新的地图
        RobMap robMap = initRobMapNtf(roleID, req.getMapId(), req.getEnterCondition(), req.getFloor(), robCfg);
        // 携带的道具，可避免陷阱伤害
        robMap.getTrapItem().putAll(req.getTrapItemMap());
        builder.setActionValue(robMap.getActionValue());
        EventManager.postRobMapEvent(robMap, robCfg);
    }

    private Integer getNextCellId(int row , int col , int maxRow, int maxCol, Map<Integer, Map<Integer, Integer>> initMap){
        List<Integer> randomList = new ArrayList<>();
        randomList.clear();
        if(((row - 1) >= 0)&&((row - 1) < maxRow)){
            int newRow = row - 1;
            Map<Integer, Integer> newMap = initMap.get(newRow);
            if ((newMap != null) && (newMap.size() > 0)) {
                if (newMap.containsKey(col)) {
                    randomList.add(newMap.get(col));
                }
            }
        }
        if(((col - 1) >= 0)&&((col - 1) < maxCol)){
            int newCol = col - 1;
            Map<Integer, Integer> newMap = initMap.get(row);
            if ((newMap != null) && (newMap.size() > 0)) {
                if (newMap.containsKey(newCol)) {
                    randomList.add(newMap.get(newCol));
                }
            }
        }
        if(((row + 1) >= 0)&&((row + 1) < maxRow)){
            int newRow = row + 1;
            Map<Integer, Integer> newMap = initMap.get(newRow);
            if ((newMap != null) && (newMap.size() > 0)) {
                if (newMap.containsKey(col)) {
                    randomList.add(newMap.get(col));
                }
            }
        }
        if(((col + 1) >= 0)&&((col + 1) < maxCol)){
            int newCol = col -1;
            Map<Integer, Integer> newMap = initMap.get(row);
            if ((newMap != null) && (newMap.size() > 0)) {
                if (newMap.containsKey(newCol)) {
                    randomList.add(newMap.get(newCol));
                }
            }
        }
        if(((row - 1) >= 0)&&((row - 1) < maxRow)&&((col - 1) >= 0)&&((col - 1) < maxCol)){
            int newRow = row - 1;
            int newCol = col - 1;
            Map<Integer, Integer> newMap = initMap.get(newRow);
            if ((newMap != null) && (newMap.size() > 0)) {
                if (newMap.containsKey(newCol)) {
                    randomList.add(newMap.get(newCol));
                }
            }
        }
        if(((row - 1) >= 0)&&((row -1) < maxRow)&&((col + 1) >= 0)&&((col + 1) < maxCol)){
            int newRow = row - 1;
            int newCol = col + 1;
            Map<Integer, Integer> newMap = initMap.get(newRow);
            if ((newMap != null) && (newMap.size() > 0)) {
                if (newMap.containsKey(newCol)) {
                    randomList.add(newMap.get(newCol));
                }
            }
        }
        if(((row + 1) >= 0)&&((row + 1) < maxRow)&&((col - 1) >= 0)&&((col - 1) < maxCol)){
            int newRow = row + 1;
            int newCol = col - 1;
            Map<Integer, Integer> newMap = initMap.get(newRow);
            if ((newMap != null) && (newMap.size() > 0)) {
                if (newMap.containsKey(newCol)) {
                    randomList.add(newMap.get(newCol));
                }
            }
        }
        if(((row + 1) >= 0)&&((row + 1) < maxRow)&&((col + 1) >= 0)&&((col + 1) < maxCol)){
            int newRow = row + 1;
            int newCol = col + 1;
            Map<Integer, Integer> newMap = initMap.get(newRow);
            if ((newMap != null) && (newMap.size() > 0)) {
                if (newMap.containsKey(newCol)) {
                    randomList.add(newMap.get(newCol));
                }
            }
        }
        if(randomList.size() > 0) {
            int nextCellId = randomList.get(RandomUtil.nextInt(randomList.size()));
            return nextCellId;
        }
        return 0;
    }

    private boolean setNextCellUnit(int mapId, ConfigRobInit cell, CurCount curCount, Integer maxTreeCount, Integer maxGrassCount, Integer maxStoneCount, Integer maxRuinsCount, Integer maxWaterCount,
                                 ConfigRobCfg robCfg, RobMap robMap, Map<Integer, ConfigRobInit> cellMap, Map<Integer, Map<Integer, Integer>> initMap){
        SceneCellUnit cellUnit = robMap.getCellMap().get(cell.getCol(), cell.getRow());
        if((cellUnit != null)&&(cellUnit.getType() > ConstantGame.Unknown)&&(cellUnit.getType() < ConstantGame.Invalid)){
            Map<Integer, Integer> tempMap = initMap.get(cell.getRow());
            if(tempMap != null) {
                tempMap.remove(cell.getCol());
                if (tempMap.size() == 0) {
                    initMap.remove(cell.getRow());
                }
            }
            log.info("cellUnit is not empty! cellUnit.getType() = "+cellUnit.getType());
            return false;
        }
        int newCellType = ERobCellType.Empty_VALUE;
        if(cell.getType() == ConstantGame.Land) {
            if (curCount.getCurTreeCount() < maxTreeCount) {
                newCellType = ERobCellType.Wood_VALUE;
                curCount.setCurTreeCount(curCount.getCurTreeCount() + 1);
            }
            if ((curCount.getCurGrassCount() < maxGrassCount)&&(ERobCellType.Empty_VALUE == newCellType)) {
                newCellType = ERobCellType.Grass_VALUE;
                curCount.setCurGrassCount(curCount.getCurGrassCount() + 1);
            }
            if ((curCount.getCurStoneCount() < maxStoneCount)&&(ERobCellType.Empty_VALUE == newCellType)) {
                newCellType = ERobCellType.Stone_VALUE;
                curCount.setCurStoneCount(curCount.getCurStoneCount() + 1);
            }
            if ((curCount.getCurRuinsCount() < maxRuinsCount)&&(ERobCellType.Empty_VALUE == newCellType)) {
                newCellType = ERobCellType.Ruins_VALUE;
                curCount.setCurRuinsCount(curCount.getCurRuinsCount() + 1);
            }
            log.info("curCount curTreeCount="+curCount.getCurTreeCount()+" curGrassCount="+curCount.getCurGrassCount()+" curStoneCount="+curCount.getCurStoneCount()+" curRuinsCount="+curCount.getCurRuinsCount());
            if (ERobCellType.Empty_VALUE == newCellType){
                log.info("item.getType() == ConstantGame.Land is full!");
            }
        }
        else if (cell.getType() == ConstantGame.Water) {
            if (curCount.getCurWaterCount() < maxWaterCount) {
                newCellType = ERobCellType.Water_VALUE;
                curCount.setCurWaterCount(curCount.getCurWaterCount() + 1);
            }
            log.info("curCount curWaterCount="+curCount.getCurWaterCount());
            if (ERobCellType.Empty_VALUE == newCellType){
                log.info("item.getType() == ConstantGame.Water is full!");
            }
        }else{
            log.info("type is invalid! item.getType() = "+cell.getType());
            return false;
        }
        if (cellUnit == null) {
            cellUnit = new SceneCellUnit(cell.getCol(), cell.getRow(), newCellType, 0, true, cell.getMatrial1());
            cellUnit.setRobId(getRobID(mapId, newCellType));
            robMap.getCellMap().put(cell.getCol(), cell.getRow(), cellUnit);
        } else {
            cellUnit.setType(newCellType);
            cellUnit.setRobId(getRobID(mapId, newCellType));
        }
        Map<Integer, Integer> tempMap = initMap.get(cell.getRow());
        if(tempMap != null) {
            tempMap.remove(cell.getCol());
            if (tempMap.size() == 0) {
                initMap.remove(cell.getRow());
            }
        }
        log.info("cellUnit x=" + cellUnit.getX() + " y=" + cellUnit.getY() + " cellUnit type=" + cellUnit.getType() + " config cell id=" + cell.getID() + " type=" + cell.getType() );
        //
        if (RandomUtil.nextBoolean()) {
            int  nextCellId = getNextCellId(cell.getRow(), cell.getCol(), robCfg.getRow(), robCfg.getCol(), initMap);
            if(nextCellId > 0) {
                ConfigRobInit nextCell = cellMap.get(nextCellId);
                if (nextCell != null) {
                    setNextCellUnit(mapId, nextCell, curCount, maxTreeCount, maxGrassCount, maxStoneCount, maxRuinsCount, maxWaterCount,
                            robCfg, robMap, cellMap, initMap);
                }else {
                    log.error("nextCell == null is empty!");
                }
            }else{
                log.info("nextCellId == 0");
            }
        }
        return true;
    }
    /**
     *	初始化盗墓地图
     *
     * @param roleID
     * @param mapId
     * @param enterCondition
     * @param floor
     * @param robCfg
     * @return
     */
    private RobMap initRobMapNtf(long roleID, int mapId, int enterCondition, int floor, ConfigRobCfg robCfg) {
        RobMap robMap = roleRobMap.get(roleID);
        if (robMap == null) {
            robMap = new RobMap();
            robMap.setRoleID(roleID);
            robMap.setActionValue(robCfg.getActionValue());
            roleRobMap.put(roleID, robMap);
        }
        // 临时处理mapId
        //if(mapId > 2) {
        //	mapId = mapId%2+1;
        //}
        // 地图重置
        robMap.reset(mapId, enterCondition, floor, robCfg.getActionValue());
        if(enterCondition == 2) {
            robMap.setLastDis(0);
        }
        try{
        Map<Integer, Integer> featureMap = new HashMap<>();
        String[] featureArray = robCfg.getFeature().split(";");
        for (String feature : featureArray) {
            String[] array = feature.split("-");
            if(array.length == 2) {
                featureMap.put(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
            }
        }
        int featureId = 1;
        if(featureMap.size() > 0) {
            featureId = RandomUtil.weightedRandom(featureMap);
        }
        // 根据盗墓地图初始化配置生成基础数据
        ConfigRobInitConf robInitConf = ConfManager.getInstance().getConfigRobInitConf();
        if(robInitConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }

        if (AbsServer.getServerConfig().isDense()) {
            int maxTreeCount = 0;
            int maxGrassCount = 0;
            int maxStoneCount = 0;
            int maxWaterCount = 0;
            int maxRuinsCount = 0;

            int maxLandEmptyCount  = 0;
            int maxWaterEmptyCount = 0;

            int allLandValidCount = 0;
            int allWaterValidCount = 0;

            CurCount curCount = new CurCount();

            Map<Integer,Map<Integer,Integer>> initMap = new ConcurrentHashMap<>();
            Map<Integer, ConfigRobInit> cellMap = robInitConf.getCellMap();
            for (ConfigRobInit item : cellMap.values()) {
                if (item.getMapID() != mapId) {
                    continue;
                }
                if (item.getEnterCondtion() != 1 && item.getEnterCondtion() != enterCondition) {
                    continue;
                }
                int type = item.getType();
                if (type != ConstantGame.Invalid) {
                    if(type == ConstantGame.Land) {
                        allLandValidCount++;
                    }else if(type == ConstantGame.Water){
                        allWaterValidCount++;
                    }
                    int col  = item.getCol();//列号x
                    int row  = item.getRow();//行号y
                    Map<Integer,Integer> tempMap = initMap.get(row);
                    if(tempMap == null) {
                        tempMap = new ConcurrentHashMap<>();
                    }
                    tempMap.put(col, item.getID());
                    initMap.put(row, tempMap);
                }
            }
            String[] weightArray = robCfg.getWeight().split(";");
            for (String weight : weightArray) {
                String[] array = weight.split("-");
                if (array.length == 3) {
                    if (featureId == 1) {//1-均衡版
                        if (array[0].equalsIgnoreCase("1")) {
                            if (array[1].equalsIgnoreCase("1")) {
                                maxTreeCount = Integer.parseInt(array[2]);
                            }else if (array[1].equalsIgnoreCase("2")) {
                                maxGrassCount = Integer.parseInt(array[2]);
                            }else if (array[1].equalsIgnoreCase("3")) {
                                maxStoneCount = Integer.parseInt(array[2]);
                            }else if (array[1].equalsIgnoreCase("5")) {
                                maxRuinsCount = Integer.parseInt(array[2]);
                            }else{
                                maxLandEmptyCount = Integer.parseInt(array[2]);
                            }
                        }else if (array[0].equalsIgnoreCase("2")) {
                            if (array[1].equalsIgnoreCase("4")) {
                                maxWaterCount = Integer.parseInt(array[2]);
                            }else {
                                maxWaterEmptyCount = Integer.parseInt(array[2]);
                            }
                        }
                    } else if (featureId == 2) {//2-密林版
                        if (array[0].equalsIgnoreCase("1")) {
                            if (array[1].equalsIgnoreCase("1")) {
                                maxTreeCount = Integer.parseInt(array[2])*2;
                            }else if (array[1].equalsIgnoreCase("2")) {
                                maxGrassCount = Integer.parseInt(array[2]);
                            }else if (array[1].equalsIgnoreCase("3")) {
                                maxStoneCount = Integer.parseInt(array[2]);
                            }else if (array[1].equalsIgnoreCase("5")) {
                                maxRuinsCount = Integer.parseInt(array[2]);
                            }else{
                                maxLandEmptyCount = Integer.parseInt(array[2]);
                            }
                        }else if (array[0].equalsIgnoreCase("2")) {
                            if (array[1].equalsIgnoreCase("4")) {
                                maxWaterCount =Integer.parseInt(array[2]);
                            }else {
                                maxWaterEmptyCount = Integer.parseInt(array[2]);
                            }
                        }
                    } else if (featureId == 3) {//3-草地版
                        if (array[0].equalsIgnoreCase("1")) {
                            if (array[1].equalsIgnoreCase("1")) {
                                maxTreeCount = Integer.parseInt(array[2]);
                            }else if (array[1].equalsIgnoreCase("2")) {
                                maxGrassCount = Integer.parseInt(array[2])*2;
                            }else if (array[1].equalsIgnoreCase("3")) {
                                maxStoneCount = Integer.parseInt(array[2]);
                            }else if (array[1].equalsIgnoreCase("5")) {
                                maxRuinsCount = Integer.parseInt(array[2]);
                            }else{
                                maxLandEmptyCount = Integer.parseInt(array[2]);
                            }
                        }else if (array[0].equalsIgnoreCase("2")) {
                            if (array[1].equalsIgnoreCase("4")) {
                                maxWaterCount = Integer.parseInt(array[2]);
                            }else {
                                maxWaterEmptyCount = Integer.parseInt(array[2]);
                            }
                        }
                    } else if (featureId == 4) {//4-石林版
                        if (array[0].equalsIgnoreCase("1")) {
                            if (array[1].equalsIgnoreCase("1")) {
                                maxTreeCount = Integer.parseInt(array[2]);
                            }else if (array[1].equalsIgnoreCase("2")) {
                                maxGrassCount = Integer.parseInt(array[2]);
                            }else if (array[1].equalsIgnoreCase("3")) {
                                maxStoneCount = Integer.parseInt(array[2])*2;
                            }else if (array[1].equalsIgnoreCase("5")) {
                                maxRuinsCount = Integer.parseInt(array[2]);
                            }else{
                                maxLandEmptyCount = Integer.parseInt(array[2]);
                            }
                        }else if (array[0].equalsIgnoreCase("2")) {
                            if (array[1].equalsIgnoreCase("4")) {
                                maxWaterCount = Integer.parseInt(array[2]);
                            }else {
                                maxWaterEmptyCount = Integer.parseInt(array[2]);
                            }
                        }
                    } else if (featureId == 5) {//5-废墟版
                        if (array[0].equalsIgnoreCase("1")) {
                            if (array[1].equalsIgnoreCase("1")) {
                                maxTreeCount = Integer.parseInt(array[2]);
                            }else if (array[1].equalsIgnoreCase("2")) {
                                maxGrassCount = Integer.parseInt(array[2]);
                            }else if (array[1].equalsIgnoreCase("3")) {
                                maxStoneCount = Integer.parseInt(array[2]);
                            }else if (array[1].equalsIgnoreCase("5")) {
                                maxRuinsCount = Integer.parseInt(array[2])*2;
                            }else{
                                maxLandEmptyCount = Integer.parseInt(array[2]);
                            }
                        }else if (array[0].equalsIgnoreCase("2")) {
                            if (array[1].equalsIgnoreCase("4")) {
                                maxWaterCount = Integer.parseInt(array[2]);
                            }else {
                                maxWaterEmptyCount = Integer.parseInt(array[2]);
                            }
                        }
                    }
                }
            }
            log.info("allLandValidCount="+allLandValidCount+" allWaterValidCount="+allWaterValidCount);
            log.info("maxLandEmptyCount="+maxLandEmptyCount+" maxWaterEmptyCount="+maxWaterEmptyCount);
            log.info("featureId="+featureId+" maxTreeCount="+maxTreeCount+" maxGrassCount="+maxGrassCount+" maxStoneCount="+maxStoneCount+" maxRuinsCount="+maxRuinsCount+" maxWaterCount="+maxWaterCount);
            int allCount = maxTreeCount + maxGrassCount + maxStoneCount + maxRuinsCount + maxLandEmptyCount;
            if(maxTreeCount > 0){
                maxTreeCount = (maxTreeCount*allLandValidCount)/allCount;
            }
            if(maxGrassCount > 0){
                maxGrassCount = (maxGrassCount*allLandValidCount)/allCount;
            }
            if(maxStoneCount > 0){
                maxStoneCount = (maxStoneCount*allLandValidCount)/allCount;
            }
            if(maxRuinsCount > 0){
                maxRuinsCount = (maxRuinsCount*allLandValidCount)/allCount;
            }

            if(maxWaterCount > 0){
                maxWaterCount = (maxWaterCount*allWaterValidCount)/(maxWaterCount + maxWaterEmptyCount);
            }
            log.info("final maxTreeCount="+maxTreeCount+" maxGrassCount="+maxGrassCount+" maxStoneCount="+maxStoneCount+" maxRuinsCount="+maxRuinsCount+" maxWaterCount="+maxWaterCount);
            while (initMap.size() > 0){
                int rowIndex = RandomUtil.nextInt(initMap.size());
                List<Integer> rowList = new ArrayList<>(initMap.keySet());
                int row = rowList.get(rowIndex);
                Map<Integer,Integer> tempMap = initMap.get(row);
                if((tempMap != null) && (tempMap.size() > 0)){
                    int colIndex = RandomUtil.nextInt(tempMap.size());
                    List<Integer> colList = new ArrayList<>(tempMap.keySet());
                    int col = colList.get(colIndex);
                    int nextCellId = tempMap.get(col);
                    ConfigRobInit cellUnit = cellMap.get(nextCellId);
                    if(cellUnit != null) {
                        setNextCellUnit(mapId, cellUnit, curCount, maxTreeCount, maxGrassCount, maxStoneCount, maxRuinsCount, maxWaterCount,
                                robCfg, robMap, cellMap, initMap);
                    }else{
                        log.error("cellUnit == null is empty!");
                    }
                }else{
                    log.error("tempMap is empty!");
                }
            }
        }else{
            Map<Integer, ConfigRobInit> cellMap = robInitConf.getCellMap();
            for (ConfigRobInit item : cellMap.values()) {
                if (item.getMapID() != mapId) {
                    continue;
                }
                if (item.getEnterCondtion() != 1 && item.getEnterCondtion() != enterCondition) {
                    continue;
                }
                int type = item.getType();
                int col  = item.getCol();
                int row  = item.getRow();
                log.info("initRobMapNtf col=%d row=%d type=%d", col, row, type);
                if (type == ConstantGame.Land) {
                    Map<Integer, Integer> weightMap   = new HashMap<>();
                    String[]              weightArray = robCfg.getWeight().split(";");
                    for (String weight : weightArray) {
                        String[] array = weight.split("-");
                        if (array.length == 3) {
                            if (featureId == 1) {//1-均衡版
                                if (array[0].equalsIgnoreCase("1")) {
                                    weightMap.put(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
                                }
                            } else if (featureId == 2) {//2-密林版
                                if (array[0].equalsIgnoreCase("1")) {
                                    if (array[1].equalsIgnoreCase("1")) {
                                        weightMap.put(Integer.parseInt(array[1]), Integer.parseInt(array[2]) * 2);
                                    } else {
                                        weightMap.put(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
                                    }
                                }
                            } else if (featureId == 3) {//3-草地版
                                if (array[0].equalsIgnoreCase("1")) {
                                    if (array[1].equalsIgnoreCase("2")) {
                                        weightMap.put(Integer.parseInt(array[1]), Integer.parseInt(array[2]) * 2);
                                    } else {
                                        weightMap.put(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
                                    }
                                }
                            } else if (featureId == 4) {//4-石林版
                                if (array[0].equalsIgnoreCase("1")) {
                                    if (array[1].equalsIgnoreCase("3")) {
                                        weightMap.put(Integer.parseInt(array[1]), Integer.parseInt(array[2]) * 2);
                                    } else {
                                        weightMap.put(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
                                    }
                                }
                            } else if (featureId == 5) {//5-废墟版
                                if (array[0].equalsIgnoreCase("1")) {
                                    if (array[1].equalsIgnoreCase("5")) {
                                        weightMap.put(Integer.parseInt(array[1]), Integer.parseInt(array[2]) * 2);
                                    } else {
                                        weightMap.put(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
                                    }
                                }
                            }
                        }
                    }
                    int cellType = 0;
                    if (weightMap.size() > 0) {
                        cellType = RandomUtil.weightedRandom(weightMap);
                    }
                    SceneCellUnit cell = robMap.getCellMap().get(col, row);
                    if (cell == null) {
                        cell = new SceneCellUnit(col, row, cellType, 0, true, item.getMatrial1());
                        cell.setRobId(getRobID(mapId, cellType));
                        robMap.getCellMap().put(col, row, cell);
                    } else {
                        cell.setType(cellType);
                        cell.setRobId(getRobID(mapId, cellType));
                    }
                } else if (type == ConstantGame.Water) {
                    Map<Integer, Integer> weightMap   = new HashMap<>();
                    String[]              weightArray = robCfg.getWeight().split(";");
                    for (String weight : weightArray) {
                        String[] array = weight.split("-");
                        if (array.length == 3) {
                            if (array[0].equalsIgnoreCase("2")) {
                                weightMap.put(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
                            }
                        }
                    }
                    int cellType = 0;
                    if (weightMap.size() > 0) {
                        cellType = RandomUtil.weightedRandom(weightMap);
                    }
                    SceneCellUnit cell = robMap.getCellMap().get(col, row);
                    if (cell == null) {
                        cell = new SceneCellUnit(col, row, cellType, 0, true, item.getMatrial1());
                        cell.setRobId(getRobID(mapId, cellType));
                        robMap.getCellMap().put(col, row, cell);
                    } else {
                        cell.setType(cellType);
                        cell.setRobId(getRobID(mapId, cellType));
                    }
                } else {
                    SceneCellUnit cell = robMap.getCellMap().get(col, row);
                    if (cell == null) {
                        cell = new SceneCellUnit(col, row, type, 0, false, 0);
                        //cell.setRobId(0);
                        robMap.getCellMap().put(col, row, cell);
                    } else {
                        cell.setType(type);
                        cell.setRobId(getRobID(mapId, type));
                    }
                }
            }
        }
        // 没找到配置大宝，则随机生成大宝
        if (robMap.getTreasureCell() == null) {
            Map<Integer, ConfigRobTreasurePosition> treasurePositionMap  = ConfManager.getInstance().getConfigRobTreasurePositionConf().getCellMap();
            List<ConfigRobTreasurePosition>         treasurePositionList = Lists.newArrayList();
            List<ConfigRobTreasurePosition>         birthPositionList    = Lists.newArrayList();
            for (ConfigRobTreasurePosition item : treasurePositionMap.values()) {
                if (item.getMapID() == mapId) {
                    if (item.getBirth() == 1) {
                        birthPositionList.add(item);
                    }
                    treasurePositionList.add(item);
                }
            }
            //TODO: 远近任务的出生点
            ConfigTasks configTasksTreasure = taskHandler.checkTaskAction(roleID, TaskActionEnum.ROB_TREASURE);
            if (configTasksTreasure != null) {
                SceneCellUnit treasureCell = robMap.getCellMap().get(18, 15);
                if (treasureCell != null) {
                    treasureCell.setType(ERobCellType.Birth_VALUE);
                    robMap.setBirthX(18);
                    robMap.setBirthY(15);
                }else{
                    treasureCell = new SceneCellUnit(18, 15, ERobCellType.Birth_VALUE, 0, false, 0);
                    robMap.getCellMap().put(18, 15, treasureCell);
                }
            }else {
                if (birthPositionList.size() > 0) {
                    int index = RandomUtil.nextInt(birthPositionList.size());
                    ConfigRobTreasurePosition configRobTreasurePosition = birthPositionList.get(index);
                    if (configRobTreasurePosition != null) {
                        SceneCellUnit treasureCell = robMap.getCellMap().get(configRobTreasurePosition.getCol(), configRobTreasurePosition.getRow());
                        if (treasureCell != null) {
                            treasureCell.setType(ERobCellType.Birth_VALUE);
                            robMap.setBirthX(treasureCell.getX());
                            robMap.setBirthY(treasureCell.getX());
                        }else{
                            treasureCell = new SceneCellUnit(configRobTreasurePosition.getCol(), configRobTreasurePosition.getRow(), ERobCellType.Birth_VALUE, 0, false, 0);
                            robMap.getCellMap().put(configRobTreasurePosition.getCol(), configRobTreasurePosition.getRow(), treasureCell);
                        }
                    }
                }
            }
            if (treasurePositionList.size() > 0) {
                boolean treasureSuccess = false;
                do {
                    int index = RandomUtil.nextInt(treasurePositionList.size());
                    ConfigRobTreasurePosition configRobTreasurePosition = treasurePositionList.get(index);
                    if (configRobTreasurePosition != null) {
                        SceneCellUnit treasureCell = robMap.getCellMap().get(configRobTreasurePosition.getCol(), configRobTreasurePosition.getRow());
                        if ((treasureCell != null)
                                && (treasureCell.getType() != ERobCellType.Birth_VALUE)
                                && (treasureCell.getType() != ERobCellType.Empty_VALUE)
                                && (treasureCell.getType() != ERobCellType.Invalid_VALUE)) {
                            ConfigCollectionEventConf collectionEventConf = ConfManager.getInstance().getConfigCollectionEventConf();
                            if (collectionEventConf == null) {
                                throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
                            }
                            Map<Integer, Integer> allWeightMap = collectionEventConf.getWeighted(mapId,10);
                            if(allWeightMap == null || allWeightMap.size() == 0){
                                log.error("initRobMapNtf allWeightMap == null");
                            }
                            int robId = RandomUtil.weightedRandom(allWeightMap);
                            treasureCell.setRobId(robId);
                            robMap.setTreasureCell(treasureCell);
                            int dis = getDistance(robMap.getBirthX(), robMap.getBirthY(), treasureCell.getX(), treasureCell.getY());
                            robMap.setLastDis(dis);
                            treasureSuccess = true;
                        }
                    }
                } while (!treasureSuccess);
            }
        }
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("roleID:{}, treasureCell ({},{}), type:{}, robId:{}", roleID, robMap.getTreasureCell().getY(), robMap.getTreasureCell().getX(), robMap.getTreasureCell().getType(), robMap.getTreasureCell().getRobId());
        return robMap;
    }

    /**
     *	生成地图格子数据
     * @param mapId
     * @param type
     */
    private int getRobID(int mapId, int type) {
        ConfigRobFuncConf robFuncConf = ConfManager.getInstance().getConfigRobFuncConf();
        if(robFuncConf == null){
            log.error("getRobID ConfigRobFuncConf robFuncConf == null mapId:{} type:{}", mapId, type);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        // 随机材料
        Map<Integer, Integer> weighted = robFuncConf.getMatrialWeighted(type);
        if (weighted == null || weighted.size() == 0) {
            log.error("getRobID weighted == null mapId:{} type:{}", mapId, type);
            return 0;
        }
        int robType = RandomUtil.weightedRandom(weighted);
        if(robType > 1) {
            ConfigCollectionEventConf collectionEventConf = ConfManager.getInstance().getConfigCollectionEventConf();
            if (collectionEventConf == null) {
                log.error("getRobID ConfigCollectionEventConf collectionEventConf == null mapId:{} type:{}", mapId, type);
                throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
            // 随机产出
            Map<Integer, Integer> weighted1 = collectionEventConf.getWeighted(mapId, robType);
            if (weighted1 == null || weighted1.size() == 0) {
                log.error("getRobID weighted1 == null || weighted1.size() == 0 mapId:{} type:{}", mapId, type);
                return 0;
            }
            return RandomUtil.weightedRandom(weighted1);
        }
        return robType;
    }

    public void robLookItem(long roleID, int x, int y, RobLookItemRsp.Builder builder) {
    	RobMap robMap = roleRobMap.get(roleID);
        if(robMap == null) {
        	return;
        }
        x = x / ConstantGame.CELL_SIZE;
        y = y / ConstantGame.CELL_SIZE;
        SceneCellUnit updateCell = robMap.getCellMap().get(x, y);
//        int type = updateCell.getType();
//        if (type == ERobCellType.Door1_VALUE || type == ERobCellType.Door2_VALUE || updateCell.getCellTypeLandforms().startsWith("mq")) {
//        	if(buffService.getNpcSkill(roleID).getSkillID() == 3) {
//        		 // 额外奖励
//                ConfigRobTreasureConf treasureConf = ConfManager.getInstance().getConfigRobTreasureConf();
//                ConfigRobEventConf conf = ConfManager.getInstance().getConfigRobEventConf();
//                int rewardCount = RandomUtil.nextInt(6)+3;
//                for (int i = 0; i < rewardCount; i++) {
//                	int robId = RandomUtil.weightedRandom(treasureConf.getWeighted901(robMap.getMapId(), robMap.getFloor()));
//    				ConfigRobEvent rob901 = conf.getRob(robId);
//    				addItem(roleID, rob901.getItemGet(), 1, ResourceBillEnum.npcSkill3, true);
//    			}
//                buffService.setNpcSkill(roleID, 0, 0);
//            }else {
//            	ConfigRobDoorConf conf = ConfManager.getInstance().getConfigRobDoorConf();
//        		ConfigRobDoor config = conf.getRobDoor(type);
//        		// 检测消耗材料是否足够
//        		checkItemEnough(roleID, config.getMatrial1(), config.getNum1());
//        		checkItemEnough(roleID, config.getMatrial2(), config.getNum2());
//        		checkItemEnough(roleID, config.getMatrial3(), config.getNum3());
//        		checkItemEnough(roleID, config.getMatrial4(), config.getNum4());
//        		checkItemEnough(roleID, config.getMatrial5(), config.getNum5());
//        		// 扣除消耗材料
//        		costItem(roleID, config.getMatrial1(), config.getNum1(), ResourceBillEnum.robDoorOpen);
//        		costItem(roleID, config.getMatrial2(), config.getNum2(), ResourceBillEnum.robDoorOpen);
//        		costItem(roleID, config.getMatrial3(), config.getNum3(), ResourceBillEnum.robDoorOpen);
//        		costItem(roleID, config.getMatrial4(), config.getNum4(), ResourceBillEnum.robDoorOpen);
//        		costItem(roleID, config.getMatrial5(), config.getNum5(), ResourceBillEnum.robDoorOpen);
//            }
//        	if (type == ERobCellType.Door1_VALUE) {
//        		updateCell.setType(ERobCellType.DoorOpen1_VALUE);
//        	}else if (type == ERobCellType.Door2_VALUE){
//        		updateCell.setType(ERobCellType.DoorOpen2_VALUE);
//        	}
//        	updateCell.setStage(1);
//        	//EventManager.postTaskActionEvent(roleID, TaskActionEnum.OPEN_DOOR, 1);
//        }else {
        	updateCell.setType(ERobCellType.Empty_VALUE);
//        }
        builder.setType(updateCell.getType());
        robMap.setUpdateCell(updateCell);
        robMap.setType(SceneUpdateType.Update_VALUE);
        //ThreadUtil.sleep(20);
        EventManager.postRobMapEvent(robMap, null, 20);
	}
    
    public void robUseSkill(long roleID, int x, int y, boolean robFlag, RobUseSkillRsp.Builder builder) {
        if(!robFlag) {
            return;
        }
        RobMap robMap = roleRobMap.get(roleID);
        if(robMap == null) {
            log.error("robUseSkill robMap == null roleID:{} x:{} y:{} robFlag:{}", roleID, x, y, robFlag);
        	return;
        }
        ConfigRobFuncConf robFuncConf = ConfManager.getInstance().getConfigRobFuncConf();
        if(robFuncConf == null){
            log.error("robUseSkill ConfigRobFuncConf robFuncConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigCollectionEventConf collectionEventConf = ConfManager.getInstance().getConfigCollectionEventConf();
        if(collectionEventConf == null){
            log.error("robUseSkill ConfigCollectionEventConf collectionEventConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigTrapEventConf trapEventConf = ConfManager.getInstance().getConfigTrapEventConf();
        if(trapEventConf == null){
            log.error("robUseSkill ConfigTrapEventConf trapEventConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        x = x / ConstantGame.CELL_SIZE;
        y = y / ConstantGame.CELL_SIZE;
        SceneCellUnit updateCell = robMap.getCellMap().get(x, y);
        if(updateCell == null || updateCell.getType() == ERobCellType.Invalid_VALUE || updateCell.getStage() == 1) {
            return;
        }
        robMap.setGuideCount(robMap.getGuideCount() + 1);
        // 检查是不是大宝
        if ((updateCell.getX() == robMap.getTreasureCell().getX()) && (updateCell.getY() == robMap.getTreasureCell().getY())) {
            robMap.getTreasureCell().setStage(1);
            robMap.setLastDis(0);
            builder.setTreasure(1);
            builder.setResult(-1);
            int rewardCount = RandomUtil.nextInt(6)+3;
            Map<Integer, Integer> allWeightMap = collectionEventConf.getWeighted(robMap.getMapId());
            if(allWeightMap == null || allWeightMap.size() == 0){
                log.error("npcWantThing allWeightMap == null");
            }
            for (int i = 0; i < rewardCount; i++) {
                int collectionId = RandomUtil.weightedRandom(allWeightMap);
                ConfigCollectionEvent collectionEvent = collectionEventConf.getCollection(collectionId);
                //产出物品1、无；2、虚拟物品；3、奇遇；5、宝物；6、珍稀植物；7、珍稀动物；8、珍稀鱼；9、鸟（原标本）；10、稀有宝物、宝贝；11、火陷阱；12、落石陷阱；13、水陷阱；14、毒陷阱;15、毒虫陷阱;16、大火、大落石、大水、大毒、大虫。
                if((collectionEvent.getType()!=1)&&(collectionEvent.getType()!=2)&&(collectionEvent.getType()!=3)
                        &&(collectionEvent.getType()!=11)&&(collectionEvent.getType()!=12)&&(collectionEvent.getType()!=13)
                        &&(collectionEvent.getType()!=14)&&(collectionEvent.getType()!=15)&&(collectionEvent.getType()!=16)) {
                    addItem(roleID, collectionId, 1, ResourceBillEnum.robUseSkill, false);
                    builder.addItemId(collectionId);
                }
            }
            ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.ROB_GUIDE);
            if ((configTasks != null) && (configTasks.getExtraParam() > 0)) {
                // 第3步 写死成大宝点 虽然此处代码像SHI一样，但这非我本意
                if ((robMap.getGuideCount() == 3) && (configTasks.getExtraParam() > 0)) {
                    ConfigCollectionEvent collectionEvent = collectionEventConf.getCollection(configTasks.getExtraParam());
                    //产出物品1、无；2、虚拟物品；3、奇遇；5、宝物；6、珍稀植物；7、珍稀动物；8、珍稀鱼；9、鸟（原标本）；10、稀有宝物、宝贝；11、火陷阱；12、落石陷阱；13、水陷阱；14、毒陷阱;15、毒虫陷阱;16、大火、大落石、大水、大毒、大虫。
                    if ((collectionEvent != null) && (collectionEvent.getType() != 1) && (collectionEvent.getType() != 2) && (collectionEvent.getType() != 3)
                            && (collectionEvent.getType() != 11) && (collectionEvent.getType() != 12) && (collectionEvent.getType() != 13)
                            && (collectionEvent.getType() != 14) && (collectionEvent.getType() != 15) && (collectionEvent.getType() != 16)) {
                        addItem(roleID, configTasks.getExtraParam(), 1, ResourceBillEnum.robUseSkill, false);
                        builder.addItemId(configTasks.getExtraParam());
                    }
                    EventManager.postTaskActionEvent(roleID, TaskActionEnum.ROB_GUIDE, 1);
                    EventManager.commitRoleEvent(roleID);
                }
                //
                //if (((robMap.getGuideCount() == 1)||(robMap.getGuideCount() == 3))
                //        && (StringUtil.isNotEmpty(configTasks.getExtraParam()))) {
                //    Map<Integer, Integer> itemMap = MapUtil.mapStringToMap1(configTasks.getExtraParam());
                //    if(itemMap.size() > 0) {
                //        int index = 0;
                //        for(Integer collectionId : itemMap.keySet()) {
                //            index++;
                //            if((robMap.getGuideCount() == 1)&&(index == 1)) {
                //                ConfigCollectionEvent collectionEvent = collectionEventConf.getCollection(collectionId);
                //                //产出物品1、无；2、虚拟物品；3、奇遇；5、宝物；6、珍稀植物；7、珍稀动物；8、珍稀鱼；9、鸟（原标本）；10、稀有宝物、宝贝；11、火陷阱；12、落石陷阱；13、水陷阱；14、毒陷阱;15、毒虫陷阱;16、大火、大落石、大水、大毒、大虫。
                //                if ((collectionEvent != null) && (collectionEvent.getType() != 1) && (collectionEvent.getType() != 2) && (collectionEvent.getType() != 3)
                //                        && (collectionEvent.getType() != 11) && (collectionEvent.getType() != 12) && (collectionEvent.getType() != 13)
                //                        && (collectionEvent.getType() != 14) && (collectionEvent.getType() != 15) && (collectionEvent.getType() != 16)) {
                //                    addItem(roleID, collectionId, itemMap.get(collectionId), ResourceBillEnum.robUseSkill, false);
                //                    builder.addItemId(collectionId);
                //                }
                //                EventManager.postTaskActionEvent(roleID, TaskActionEnum.ROB_GUIDE, 1);
                //                EventManager.commitRoleEvent(roleID);
                //                break;
                //            }
                //            if((robMap.getGuideCount() == 3)&&(index == 2)) {
                //                ConfigCollectionEvent collectionEvent = collectionEventConf.getCollection(collectionId);
                //                //产出物品1、无；2、虚拟物品；3、奇遇；5、宝物；6、珍稀植物；7、珍稀动物；8、珍稀鱼；9、鸟（原标本）；10、稀有宝物、宝贝；11、火陷阱；12、落石陷阱；13、水陷阱；14、毒陷阱;15、毒虫陷阱;16、大火、大落石、大水、大毒、大虫。
                //                if ((collectionEvent != null) && (collectionEvent.getType() != 1) && (collectionEvent.getType() != 2) && (collectionEvent.getType() != 3)
                //                        && (collectionEvent.getType() != 11) && (collectionEvent.getType() != 12) && (collectionEvent.getType() != 13)
                //                        && (collectionEvent.getType() != 14) && (collectionEvent.getType() != 15) && (collectionEvent.getType() != 16)) {
                //                    addItem(roleID, collectionId, itemMap.get(collectionId), ResourceBillEnum.robUseSkill, false);
                //                    builder.addItemId(collectionId);
                //                }
                //                EventManager.postTaskActionEvent(roleID, TaskActionEnum.ROB_GUIDE, 1);
                //                EventManager.commitRoleEvent(roleID);
                //                break;
                //            }
                //        }
                //    }
                //}
            }
            ConfigTasks configTasksTreasure = taskHandler.checkTaskAction(roleID, TaskActionEnum.ROB_TREASURE);
            if (configTasksTreasure != null) {
                EventManager.postTaskActionEvent(roleID, TaskActionEnum.ROB_TREASURE, 1);
                EventManager.commitRoleEvent(roleID);
            }
        }else {
            //zcq 成长任务
            ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.ROB_GUIDE);
            if ((robMap.getGuideCount() == 3) && (configTasks != null) && (configTasks.getExtraParam() > 0)) {
                // 第3步 写死成大宝点
                ConfigCollectionEvent collectionEvent = collectionEventConf.getCollection(configTasks.getExtraParam());
                if (collectionEvent != null) {
                    updateCell.setRobId(collectionEvent.getID());
                    updateCell.setType(collectionEvent.getType());
                }
                //Map<Integer, Integer> itemMap = MapUtil.mapStringToMap1(configTasks.getExtraParam());
                //if(itemMap.size() > 0) {
                //    int index = 0;
                //    for(Integer collectionId : itemMap.keySet()) {
                //        index++;
                //        if((robMap.getGuideCount() == 1)&&(index == 1)) {
                //            ConfigCollectionEvent collectionEvent = collectionEventConf.getCollection(collectionId);
                //            updateCell.setRobId(collectionEvent.getID());
                //            updateCell.setType(collectionEvent.getType());
                //            break;
                //        }
                //        if((robMap.getGuideCount() == 3)&&(index == 2)) {
                //            ConfigCollectionEvent collectionEvent = collectionEventConf.getCollection(collectionId);
                //            updateCell.setRobId(collectionEvent.getID());
                //            updateCell.setType(collectionEvent.getType());
                //            break;
                //        }
                //    }
                //}
                EventManager.postTaskActionEvent(roleID, TaskActionEnum.ROB_GUIDE, 1);
                EventManager.commitRoleEvent(roleID);
            }
        }
        // 检查离大宝距离
        if ((robMap.getTreasureCell().getStage() == 0)||(robMap.getGuideCount() < 3)) {
            int result = 0;
            int dis = 0;
            if (robMap.getLastDis() == 0) {
                result = 1;
            } else {
                dis = getDistance(updateCell.getX(), updateCell.getY(), robMap.getTreasureCell().getX(), robMap.getTreasureCell().getY());
                if (dis > robMap.getLastDis()) {
                    result = 1;
                } else if (dis < robMap.getLastDis()) {
                    result = -1;
                }
            }
            robMap.setLastDis(dis);
            builder.setResult(result);
        }
        // 扣除行动值
        int type = updateCell.getType();
        int costAction = 0;
        if (updateCell.getRobId() > 0) {
            ConfigCollectionEvent collection = collectionEventConf.getCollection(updateCell.getRobId());
            if(collection != null) {
                log.info("roleID:{}, position:({},{}), type:{}, robId:{}, name:{}",
                        roleID, x, y, type, updateCell.getRobId(), collection.getName());
                // 避免陷阱伤害，道具起效果
                if((collection.getType()==3)||(collection.getType()==11)||(collection.getType()==12)
                        ||(collection.getType()==13)||(collection.getType()==14)||(collection.getType()==15)
                        || collection.getType()==16) {
                    ConfigTrapEvent trap = trapEventConf.getTrap(updateCell.getRobId());
                    if(trap.getTrapItem() > 0 && robMap.getTrapItem().containsKey(trap.getTrapItem())){
                        if (RandomUtil.nextInt(100) < 50) {
                            ConfigRobFunc func = robFuncConf.getFunc(type);
                            if (func != null) {
                                costAction = func.getCost();
                            }
                            builder.setTrapItem(trap.getTrapItem());
                        }
                    }else{
                        costAction = Math.abs(trap.getActionValue());
                        ConfigRobFunc func = robFuncConf.getFunc(type);
                        if(func != null) {
                            costAction = costAction + func.getCost();
                        }
                    }
                }else {
                    ConfigRobFunc func = robFuncConf.getFunc(type);
                    if(func != null) {
                        costAction = func.getCost();
                    }
                }
                // 气力值判断
                if (robMap.getActionValue() < costAction) {
                    throw new CommonException(ErrorID.COMMON_PLAYER_ACTION_LESS);
                }
                // 3、奇遇； 4、陷阱
                if ((collection.getType() != 1) && (collection.getType() != 3) && (collection.getType() != 4)
                        && (collection.getType() != 11) && (collection.getType() != 12) && (collection.getType() != 13)
                        && (collection.getType() != 14) && (collection.getType() != 15) && (collection.getID() >= 1)) {
                    if (collection.getID() == 2) {
                        addGold(roleID, 1000, ResourceBillEnum.robUseSkill);
                        builder.addItemId(collection.getID());
                    } else {
                        addItem(roleID, collection.getID(), 1, ResourceBillEnum.robUseSkill, false);
                        builder.addItemId(collection.getID());
                        if(robMap.getGuideCount() < 3) {
                            ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.ROB_GUIDE);
                            if ((configTasks != null) && (configTasks.getExtraParam() == collection.getID())) {
                                EventManager.postTaskActionEvent(roleID, TaskActionEnum.ROB_GUIDE, 1);
                                EventManager.commitRoleEvent(roleID);
                            }
                        }
                    }
                }
            }
        }

        robMap.setActionValue(robMap.getActionValue() - costAction);
        updateCell.setStage(1);
        robMap.setUpdateCell(updateCell);
        robMap.setType(SceneUpdateType.Update_VALUE);
        // 返回数据
        builder.setActionChange(costAction);
        builder.setType(type);
        builder.setRobId(updateCell.getRobId());
        builder.setActionValue(robMap.getActionValue());

        //ThreadUtil.sleep(20);
        EventManager.postRobMapEvent(robMap, null, 20);
        addAchievement(roleID, AchievementActionEnum.ROB, 1, ResourceBillEnum.robUseSkill);
    }

    private int getDistance(int x1, int y1, int x2, int y2) {
        int disX = Math.abs(x1 - x2);
        int disY = Math.abs(y1 - y2);
        int dis = disX * disX + disY * disY;
        //double dis = Math.sqrt(st);
        return dis;
    }

    /**
     *	玩家与怪物碰撞了
     *
     * @param roleID
     * @param builder
     */
    public void robMonsterOnCollision(long roleID, RobMonsterOnCollisionRsp.Builder builder) {
        RobMap robMap = roleRobMap.get(roleID);
        robMap.setActionValue(robMap.getActionValue() - ConfigSundryConf.robMonsterOncollisionCostAction);
        if (robMap.getActionValue() < 0) {
        	robMap.setActionValue(0);
        }
        builder.setActionValue(robMap.getActionValue());
        builder.setActionChange(ConfigSundryConf.robMonsterOncollisionCostAction);
    }

    public void robCompleteGuide(long roleID) {
        ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.ROB_TREASURE_HELP);
        if (configTasks != null) {
            EventManager.postTaskActionEvent(roleID, TaskActionEnum.ROB_TREASURE_HELP, 1);
            EventManager.commitRoleEvent(roleID);
        }
    }
}