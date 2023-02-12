package com.dj.serverapi.redis.model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.dj.domain.RedisKeys;
import com.dj.domain.config.ConfigTasks;
import com.dj.domain.constant.ConstantGame;
import com.dj.domain.enums.FiveEle2Produce;
import com.dj.domain.config.ConfigMineInit;
import com.dj.domain.data.game.SceneCellUnit;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.serverapi.redis.base.InitModel;
import com.dj.servercore.conf.ConfigDigGoldConf;
import com.dj.servercore.conf.ConfigMineInitConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.collection.MapSubMap;
import com.dj.domain.util.math.RandomUtil;
import com.google.common.collect.Lists;

/**
 * @author zcq
 * @ClassName: GameMineModel
 * @Description: 游戏-挖矿
 * @date 2019年8月7日
 */
public class GameMineModel extends InitModel {

    public GameMineModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_GAME_MINE, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
        this.data.set(RedisKeys.KEY_GAME_MINE_RESET, 0l);
        this.data.set(RedisKeys.KEY_NPCSKILL_IN, false);
    }

    /**
     *	重置矿区
     */
    public long resetMine(int fiveEle, boolean isTaskAccept) {
        long resetTime = this.data.get(RedisKeys.KEY_GAME_MINE_RESET);
        if (resetTime < System.currentTimeMillis()) {
        	if(this.data.isExists(RedisKeys.KEY_NPCSKILL_IN)) {
        		if(!((boolean) this.data.get(RedisKeys.KEY_NPCSKILL_IN))) {
        			this.data.set(RedisKeys.KEY_NPCSKILLMAPPIECEMULTIPLE, 1);
        		}
        	}
        	this.data.set(RedisKeys.KEY_NPCSKILL_IN, false);
            // 8小时重置
            resetTime = DateUtil.plusNow(TimeUnit.HOURS, 8).getTime();
            this.data.set(RedisKeys.KEY_GAME_MINE_RESET, resetTime);
            // 本人的矿区
            MapSubMap<Integer, Integer, SceneCellUnit> mineCells = initMineCell(FiveEle2Produce.getFiveEle2Produce(fiveEle), isTaskAccept);
            this.data.set(RedisKeys.KEY_GAME_MINE_CELL, mineCells);
            // 小寻的矿区
            MapSubMap<Integer, Integer, SceneCellUnit> xxMineCells = initMineCell(FiveEle2Produce.getFiveEle2Produce(RandomUtil.nextInt(1,5)), false);
            this.data.set(RedisKeys.KEY_GAME_MINE_CELL_XX, xxMineCells);
        }
        return resetTime;
    }

    /**
     *	初始化矿地图
     *
     * @return
     */
    private MapSubMap<Integer, Integer, SceneCellUnit> initMineCell(FiveEle2Produce fiveEle2Produce, boolean isTaskAccept) {
        // 初始化地图
        MapSubMap<Integer, Integer, SceneCellUnit> mineCells = new MapSubMap<Integer, Integer, SceneCellUnit>();
        for (int x = 0; x < ConstantGame.MINE_X; x++) {
            for (int y = 0; y < ConstantGame.MINE_Y; y++) {
                SceneCellUnit cell = mineCells.get(x, y);
                if (cell == null) {
                    cell = new SceneCellUnit(x, y, ConstantGame.Unknown, 0, true, 0);
                    mineCells.put(cell.getX(), cell.getY(), cell);
                }
            }
        }
        // 矿产初始化
        ConfigMineInitConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_MINEINIT);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        Map<Integer, ConfigMineInit> cellMap = conf.getCellMap();
        for (ConfigMineInit item : cellMap.values()) {
            int type = item.getType();
            if (conf.isFriendPosition(type)) { //109-功能
                type = ConstantGame.DigUp;
            }
            SceneCellUnit cell = mineCells.get(item.getRow(), item.getCol());
            cell.setType(type);
            mineCells.put(cell.getX(), cell.getY(), cell);
            updateAroundCell(cell, mineCells, fiveEle2Produce);
        }
        if(isTaskAccept){
            SceneCellUnit cell1 = mineCells.get(23, 3);
            cell1.setType(104001);
            cell1.setShow(false);
            mineCells.put(23, 3, cell1);

            SceneCellUnit cell2 = mineCells.get(23, 2);
            cell2.setType(102001);
            cell2.setShow(false);
            mineCells.put(23, 2, cell2);

            SceneCellUnit cell3 = mineCells.get(23, 4);
            cell3.setType(102001);
            cell3.setShow(false);
            mineCells.put(23, 4, cell3);

            SceneCellUnit cell4 = mineCells.get(24, 2);
            cell4.setType(104001);
            cell4.setShow(true);
            mineCells.put(24, 2, cell4);

            SceneCellUnit cell5 = mineCells.get(24, 3);
            cell5.setType(102001);
            cell5.setShow(true);
            mineCells.put(24, 3, cell5);

            SceneCellUnit cell6 = mineCells.get(24, 4);
            cell6.setType(104001);
            cell6.setShow(true);
            mineCells.put(24, 4, cell6);
        }
        return mineCells;
    }

    /**
     *	更新格子的四周格子矿
     *
     * @param cell
     * @param mineCells
     * @return
     */
    public List<SceneCellUnit> updateAroundCell(SceneCellUnit cell, MapSubMap<Integer, Integer, SceneCellUnit> mineCells, FiveEle2Produce fiveEle2Produce) {
        if (cell.getType() != ConstantGame.DigUp) {
            return null;
        }
        List<SceneCellUnit> list = Lists.newArrayListWithExpectedSize(8);
        int x = cell.getX();
        int y = cell.getY();
        SceneCellUnit aroundCell;
        // 左
        if (x - 1 >= 0) {
            aroundCell = mineCells.get(x - 1, y);
            if (aroundCell.getType() == ConstantGame.Unknown) {
                aroundCell.setType(randomMineType(y, fiveEle2Produce));
                list.add(aroundCell);
            }
        }
        // 右
        if (x + 1 < ConstantGame.MINE_X) {
            aroundCell = mineCells.get(x + 1, y);
            if (aroundCell.getType() == ConstantGame.Unknown) {
                aroundCell.setType(randomMineType(y, fiveEle2Produce));
                list.add(aroundCell);
            }
        }
        // 上
        if (y - 1 >= 0) {
            aroundCell = mineCells.get(x, y - 1);
            if (aroundCell.getType() == ConstantGame.Unknown) {
                aroundCell.setType(randomMineType(y - 1, fiveEle2Produce));
                list.add(aroundCell);
            }
        }
        // 下
        if (y + 1 < ConstantGame.MINE_Y) {
            aroundCell = mineCells.get(x, y + 1);
            if (aroundCell.getType() == ConstantGame.Unknown) {
                aroundCell.setType(randomMineType(y + 1, fiveEle2Produce));
                list.add(aroundCell);
            }
        }
        // 左上
        if (x - 1 >= 0 && y - 1 >= 0) {
            aroundCell = mineCells.get(x - 1, y - 1);
            if (aroundCell.getType() == ConstantGame.Unknown) {
                aroundCell.setType(randomMineType(y - 1, fiveEle2Produce));
                list.add(aroundCell);
            }
        }
        // 左下
        if (x - 1 >= 0 && y + 1 < ConstantGame.MINE_Y) {
            aroundCell = mineCells.get(x - 1, y + 1);
            if (aroundCell.getType() == ConstantGame.Unknown) {
                aroundCell.setType(randomMineType(y + 1, fiveEle2Produce));
                list.add(aroundCell);
            }
        }
        // 右上
        if (x + 1 < ConstantGame.MINE_X && y - 1 >= 0) {
            aroundCell = mineCells.get(x + 1, y - 1);
            if (aroundCell.getType() == ConstantGame.Unknown) {
                aroundCell.setType(randomMineType(y - 1, fiveEle2Produce));
                list.add(aroundCell);
            }
        }
        // 右下
        if (x + 1 < ConstantGame.MINE_X && y + 1 < ConstantGame.MINE_Y) {
            aroundCell = mineCells.get(x + 1, y + 1);
            if (aroundCell.getType() == ConstantGame.Unknown) {
                aroundCell.setType(randomMineType(y + 1, fiveEle2Produce));
                list.add(aroundCell);
            }
        }
        return list;
    }

    private int randomMineType(int layer, FiveEle2Produce fiveEle2Produce) {
        ConfigDigGoldConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_DIGGOLD);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        Map<Integer, Integer> weightMap = conf.getLayerWeight(layer);
        // 触发npc技能 地图碎片倍数
        //if(weightMap.containsKey(ConstantGame.DIGGOLD_MAPPIECE)) {
        //    int mapPiece = weightMap.get(ConstantGame.DIGGOLD_MAPPIECE);
        //    weightMap.put(ConstantGame.DIGGOLD_MAPPIECE, mapPiece * 100 * (int) this.data.get(RedisKeys.KEY_NPCSKILLMAPPIECEMULTIPLE));
        //}
        // 随机类型
        int type = RandomUtil.weightedRandom(weightMap);
        // 指定玩家五行元素
        //if(fiveEle2Produce != null && FiveEle2Produce.checkIsDigGold(type)) {
        //	type = fiveEle2Produce.getDigGold();
        //}
        return type;
    }

    public MapSubMap<Integer, Integer, SceneCellUnit> getMineCell() {
        return this.data.get(RedisKeys.KEY_GAME_MINE_CELL);
    }

    public MapSubMap<Integer, Integer, SceneCellUnit> getMineCellXX() {
        return this.data.get(RedisKeys.KEY_GAME_MINE_CELL_XX);
    }
    
    /**
     * 触发npc技能
     */
    public void triggerNpcSkill() {
    	this.data.set(RedisKeys.KEY_GAME_MINE_RESET, System.currentTimeMillis());
    	this.data.set(RedisKeys.KEY_NPCSKILLMAPPIECEMULTIPLE, 10);
    	this.data.set(RedisKeys.KEY_NPCSKILL_IN, true);
    }
}
