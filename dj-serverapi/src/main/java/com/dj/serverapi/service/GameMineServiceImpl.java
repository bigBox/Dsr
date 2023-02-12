package com.dj.serverapi.service;

import com.dj.domain.config.ConfigDigGold;
import com.dj.domain.config.ConfigTasks;
import com.dj.domain.constant.ConstantGame;
import com.dj.domain.data.game.SceneCellUnit;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.entity.player.task.ITask;
import com.dj.domain.entity.player.task.PlayerTask1;
import com.dj.domain.enums.FiveEle2Produce;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.enums.TaskState;
import com.dj.domain.util.collection.MapSubMap;
import com.dj.domain.util.math.RandomUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.serverapi.EventProvider;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.task.PlayerTask1Dao;
import com.dj.serverapi.redis.model.GameMineModel;
import com.dj.serverapi.service.inf.IGameMineService;
import com.dj.servercore.conf.ConfigDigGoldConf;
import com.dj.servercore.conf.ConfigMapPieceConf;
import com.dj.servercore.conf.ConfigTasksConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.servercore.redis.base.BaseService;
import com.dj.servercore.spring.SpringContext;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class GameMineServiceImpl extends BaseService implements IGameMineService {

    @Autowired
    public PlayerTask1Dao playerTask1Dao;

    @Override
    public long resetMine(long roleID) {
    	// 角色的五行属性
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        GameMineModel model = getWriteModel(roleID, GameMineModel.class);
        ConfigTasks configTasks = checkTaskAction(roleID, TaskActionEnum.COLLECT_MAP_FRAGMENT);
        if(configTasks != null) {
            return model.resetMine(playerRole.getFiveEle(), true);
        }else{
            return model.resetMine(playerRole.getFiveEle(), false);
        }
    }

    @Override
    public List<SceneCellUnit> getMineCellList(long roleID) {
        GameMineModel model = getReadModel(roleID, GameMineModel.class);
        return model.getMineCell().allValues();
    }

    @Override
    public List<SceneCellUnit> getMineCellXXList(long roleID) {
        GameMineModel model = getReadModel(roleID, GameMineModel.class);
        return model.getMineCellXX().allValues();
    }

    @Override
    public void userSkillStart(long roleID, long mapOwner, boolean isXX, int x, int y) {
        x = x / ConstantGame.CELL_SIZE;
        y = y / ConstantGame.CELL_SIZE;
        GameMineModel model;
        MapSubMap<Integer, Integer, SceneCellUnit> mineCells;
        if (isXX) {
            model = getReadModel(roleID, GameMineModel.class);
            mineCells = model.getMineCellXX();
        } else {
            model = getReadModel(mapOwner, GameMineModel.class);
            mineCells = model.getMineCell();
        }
        SceneCellUnit cell = mineCells.get(x, y);
        int type = cell.getType();
        if (type == ConstantGame.DigUp) {
            return;
        }
        ConfigDigGoldConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_DIGGOLD);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigDigGold digGold = conf.getDigGold(type);
        if (cell.getStage() >= digGold.getDigNum()) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
    }

    @Override
    public List<SceneCellUnit> userSkillCancel(long roleID, long mapOwner, boolean isXX, int x, int y) {
        x = x / ConstantGame.CELL_SIZE;
        y = y / ConstantGame.CELL_SIZE;
        GameMineModel model;
        MapSubMap<Integer, Integer, SceneCellUnit> mineCells;
        if (isXX) {
            model = getWriteModel(roleID, GameMineModel.class);
            mineCells = model.getMineCellXX();
        } else {
            model = getWriteModel(mapOwner, GameMineModel.class);
            mineCells = model.getMineCell();
        }
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        SceneCellUnit cell = mineCells.get(x, y);
        int type = cell.getType();
        if (type == ConstantGame.DigUp) {
            return null;
        }
        ConfigDigGoldConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_DIGGOLD);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigDigGold digGold = conf.getDigGold(type);
        // 扣除体力
        if (playerRole.getStamina() < digGold.getCost()) {
            throw new CommonException(ErrorID.COMMON_PLAYER_STAMINA_LESS);
        }
        // 属性变化
        ServiceProvider.getCommonService().changeAttrDigGold(roleID, digGold);
        // 挖矿
        cell.setStage(cell.getStage() + 1);
        if (cell.getStage() >= digGold.getDigNum()) {
            cell.setType(ConstantGame.DigUp);
        }
        log.info("roleID {}, mapOwner {}, ({}, {}), digNum {}, stage {}, type {}", roleID, mapOwner, x, y, digGold.getDigNum(), cell.getStage(), cell.getType());
        // 获得道具
        if (digGold.getType() == 104001) {
            ConfigMapPieceConf mapPieceConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_MAPPIECE);
            int itemID = mapPieceConf.getMapPiece();
            ServiceProvider.getItemService().addItemBill(roleID, itemID, 1, ResourceBillEnum.mineReward, true, false);
            EventProvider.postSyncItemEvent(roleID);
        }
        else if (digGold.getItemGet() > 0) {
            ServiceProvider.getItemService().addItemBill(roleID, digGold.getItemGet(), 1, ResourceBillEnum.mineReward, true, false);
            EventProvider.postSyncItemEvent(roleID);
        }
        List<SceneCellUnit> list = Lists.newArrayListWithExpectedSize(8);
        list.add(cell);
        // 非小寻角色的五行属性
        FiveEle2Produce fiveEle2Produce = FiveEle2Produce.getFiveEle2Produce(RandomUtil.nextInt(1, 5));
        List<SceneCellUnit> updateList = model.updateAroundCell(cell, mineCells, fiveEle2Produce);
        if (updateList != null) {
            list.addAll(updateList);
        }
        EventProvider.postSyncAttrEvent(roleID);
        return list;
    }

	@Override
	public void triggerNpcSkill(long roleID) {
		GameMineModel model = getWriteModel(roleID, GameMineModel.class);
		model.triggerNpcSkill();
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
