package com.dj.serverapi.redis.model;

import com.dj.domain.RedisKeys;
import com.dj.domain.config.ConfigFarmParkAnimal;
import com.dj.domain.config.ConfigFarmZooAnimal;
import com.dj.domain.config.ConfigNewRolePark;
import com.dj.domain.data.game.ParkAnimalUnit;
import com.dj.domain.data.game.ParkCellUnit;
import com.dj.domain.data.game.ParkFishUnit;
import com.dj.domain.data.game.ZooAnimalUnit;
import com.dj.domain.util.collection.MapSubMap;
import com.dj.domain.util.collection.MapUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.servercore.conf.ConfigFarmParkAnimalConf;
import com.dj.servercore.conf.ConfigFarmZooAnimalConf;
import com.dj.servercore.conf.ConfigNewRoleParkConf;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.servercore.redis.base.BaseModel;
import com.google.common.collect.ImmutableMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author zcq
 * @ClassName: ParkModel
 * @Description: 生态园
 * @date 2019年8月7日
 */
public class ParkModel extends BaseModel {

    public ParkModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_PARK, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
        initParkCell();
        this.data.set(RedisKeys.KEY_PARK_USE_ECOLOGY, 0);
        this.data.initNewSubMap(RedisKeys.KEY_PARK_COUNT);
        this.data.initNewSubMap(RedisKeys.KEY_PARK_ANIMAL);
        this.data.initNewSubMap(RedisKeys.KEY_ZOO_ANIMAL);
        this.data.initNewSubMap(RedisKeys.KEY_PARK_POOL_FISH);
        this.data.set(RedisKeys.KEY_PARK_HONEY_DRAW_TIME, 0l);
    }

    @Override
    protected void onLoadOver() {
        // 占用的人口数
            int useEcology = 0;
            Map<String, ParkAnimalUnit> parkAnimalUnitMap = this.data.get(RedisKeys.KEY_PARK_ANIMAL);
            if (parkAnimalUnitMap != null && parkAnimalUnitMap.size() > 0) {
                ConfigFarmParkAnimalConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMPARKANIMAL);
                if(conf == null){
                    throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
                }
                for (Iterator<Entry<String, ParkAnimalUnit>> it = parkAnimalUnitMap.entrySet().iterator(); it.hasNext();){
                    Map.Entry<String, ParkAnimalUnit> animal = it.next();
                    if (animal.getValue().getAnimalID() > 0) {
                        ConfigFarmParkAnimal config = conf.getAnimal(animal.getValue().getAnimalID());
                        if(config != null) {
                        	useEcology += config.getCostEcology();
                        }
                    }
                }
            }
            Map<String, ZooAnimalUnit> zooAnimalUnitMap = this.data.get(RedisKeys.KEY_ZOO_ANIMAL);
            if (zooAnimalUnitMap != null && zooAnimalUnitMap.size() > 0) {
                ConfigFarmZooAnimalConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMZOOANIMAL);
                if(conf == null){
                    throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
                }
                for (Iterator<Entry<String, ZooAnimalUnit>> it = zooAnimalUnitMap.entrySet().iterator(); it.hasNext();){
                    Map.Entry<String, ZooAnimalUnit> animal = it.next();
                    if (animal.getValue().getAnimalID() > 0) {
                        ConfigFarmZooAnimal config = conf.getAnimalByProId(animal.getValue().getAnimalID());
                        if(config != null) {
                            useEcology += config.getCostEcology();
                        }
                    }
                }
            }
            this.data.set(RedisKeys.KEY_PARK_USE_ECOLOGY, useEcology);
        // 物种数量
        if (!this.data.isExists(RedisKeys.KEY_PARK_COUNT)) {
            this.data.initNewSubMap(RedisKeys.KEY_PARK_COUNT);
        } else {
            // 重置物种数量
            Map<Integer, Integer> parkCount = this.data.get(RedisKeys.KEY_PARK_COUNT);
            parkCount.clear();
            // 生态园动物数量
            Map<String, ParkAnimalUnit> parkAnimalMap = this.data.get(RedisKeys.KEY_PARK_ANIMAL);
            for (Map.Entry<String, ParkAnimalUnit> parkAnimal : parkAnimalMap.entrySet()) {
                MapUtil.fundInt(parkCount, parkAnimal.getValue().getAnimalID(), 1);
            }
            // 动物园动物数量
            Map<String, ZooAnimalUnit> zooAnimalMap = this.data.get(RedisKeys.KEY_ZOO_ANIMAL);
            for (Map.Entry<String, ZooAnimalUnit> zooAnimal : zooAnimalMap.entrySet()) {
                MapUtil.fundInt(parkCount, zooAnimal.getValue().getAnimalID(), 1);
            }
            // 鱼数量
            Map<Integer, ParkFishUnit> fishMap = this.data.get(RedisKeys.KEY_PARK_POOL_FISH);
            for (Map.Entry<Integer, ParkFishUnit> fish : fishMap.entrySet()) {
                MapUtil.fundInt(parkCount, fish.getValue().getFishID(), 1);
            }
        }
        if (!this.data.isExists(RedisKeys.KEY_PARK_HONEY_DRAW_TIME)) {
            this.data.set(RedisKeys.KEY_PARK_HONEY_DRAW_TIME, 0l);
        }
    }

    private void initParkCell() {
        int parkMapSize = ConfigSundryConf.parkMapSize;
        MapSubMap<Integer, Integer, ParkCellUnit> parkCells = new MapSubMap<Integer, Integer, ParkCellUnit>();
        for (int x = 0; x < parkMapSize; x++) {
            for (int y = 0; y < parkMapSize; y++) {
                ParkCellUnit unit = new ParkCellUnit(x, y, 0, 0, 0, 1, 0, 0, 0, 0,0);
                parkCells.put(x, y, unit);
            }
        }
        //玩家出生时生态园初始化
        ConfigNewRoleParkConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_NEWROLEPARK);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ImmutableMap<Integer, ConfigNewRolePark> newRoleParkMap = conf.getNewRoleParkMap();
        for (ConfigNewRolePark config : newRoleParkMap.values()) {
            ParkCellUnit unit = parkCells.get(config.getX(), config.getY());
            unit.setGreen(config.getGreen());
        }
        this.data.set(RedisKeys.KEY_PARK_CELL, parkCells);
    }

    public MapSubMap<Integer, Integer, ParkCellUnit> getCellMap() {
        return this.data.get(RedisKeys.KEY_PARK_CELL);
    }

    public Map<String, ParkAnimalUnit> getParkAnimalMap() {
        return this.data.get(RedisKeys.KEY_PARK_ANIMAL);
    }

    public Map<String, ZooAnimalUnit> getZooAnimalMap() {
        return this.data.get(RedisKeys.KEY_ZOO_ANIMAL);
    }
    public Map<Integer, ParkFishUnit> getFishMap() {
        return this.data.get(RedisKeys.KEY_PARK_POOL_FISH);
    }

    public int getUseEcology() {
        return this.data.get(RedisKeys.KEY_PARK_USE_ECOLOGY);
    }

    public int changeUseEcology(int change) {
        int useEcology = this.data.get(RedisKeys.KEY_PARK_USE_ECOLOGY);
        useEcology += change;
        if (useEcology < 0) {
            useEcology = 0;
        }
        this.data.set(RedisKeys.KEY_PARK_USE_ECOLOGY, useEcology);
        return useEcology;
    }

    public Map<Integer, Integer> getParkCount() {
        return this.data.get(RedisKeys.KEY_PARK_COUNT);
    }

    public long getHoneyDrawTime() {
        return this.data.get(RedisKeys.KEY_PARK_HONEY_DRAW_TIME);
    }

    public void setHoneyDrawTime(long time) {
        this.data.set(RedisKeys.KEY_PARK_HONEY_DRAW_TIME, time);
    }
}
