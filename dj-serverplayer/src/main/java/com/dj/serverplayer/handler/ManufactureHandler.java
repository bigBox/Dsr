package com.dj.serverplayer.handler;

import com.dj.domain.config.ConfigManufactureMakeData;
import com.dj.domain.config.ConfigTasks;
import com.dj.domain.entity.player.PlayerManufacture;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.util.DateUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.manufacture.*;
import com.dj.servercore.conf.ConfigManufactureMakeDataConf;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.EventManager;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zcq
 * @description 制作业务处理
 * @date 2019年4月25日
 */
@Component
@Slf4j
public class ManufactureHandler extends BaseHandler {

    /**
     *	获取制作列表
     *
     * @param roleID
     * @param builder
     */
    public void manufactureInfo(long roleID, ManufactureInfoRsp.Builder builder) {
        List<PlayerManufacture> manufactures = playerManufactureDao.cacheLoadAll(roleID);
        if (manufactures != null && manufactures.size() > 0) {
            Collections.sort(manufactures);
            long nowTime = System.currentTimeMillis();
            ManufactureState.Builder manufactureState = ManufactureState.newBuilder();
            for (PlayerManufacture playerManufacture : manufactures) {
                manufactureState.setRecipeId(playerManufacture.getRecipeID());
                manufactureState.setMakingTime(playerManufacture.getMakingTime());
                if (playerManufacture.getState() == EManufactureState.Finished_VALUE) {
                	// 完成
                    manufactureState.setCountDown(0);
                    manufactureState.setState(EManufactureState.Finished);
                } else {
                    Date endTime = DateUtil.plusTime(playerManufacture.getStartTime(), TimeUnit.SECONDS, playerManufacture.getMakingTime());
                    if (playerManufacture.getStartTime().getTime() >= nowTime) {
                        // 队列等待中
                        manufactureState.setState(EManufactureState.Queued);
                        manufactureState.setCountDown(playerManufacture.getMakingTime());
                    } else if (endTime.getTime() <= nowTime) {
                        // 制作完成
                        manufactureState.setState(EManufactureState.Finished);
                        manufactureState.setCountDown(0);
                    } else {
                        // 制作中
                        manufactureState.setState(EManufactureState.Making);
                        int countDown = (int) (endTime.getTime() - nowTime) / 1000;
                        manufactureState.setCountDown(countDown);
                    }
                    if (playerManufacture.getState() != manufactureState.getState().getNumber()) {
                        playerManufactureDao.cacheUpdate(playerManufacture, roleID);
                    }
                }
                builder.addItems(manufactureState.build());
            }
        }
    }

    /**
     *	制作或领取
     *
     * @param roleID
     * @param req
     * @param builder
     */
    public void manufactureAction(long roleID, ManufactureActionReq req, ManufactureActionRsp.Builder builder) {
        ConfigManufactureMakeDataConf conf = ConfManager.getInstance().getConfigManufactureMakeDataConf();
        if(conf == null){
            log.error("manufactureAction ConfigManufactureMakeDataConf conf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigManufactureMakeData data = null;
        int factoryID;
        // 1:制作; 0:领取
        if (req.getEnqueued() == 0) {
            factoryID = req.getRecipeId();
        } else {
        	data = conf.getManufactureMakeData(req.getRecipeId());
            factoryID = data.getFactory();
        }
        // 获取当前建筑的队列
        List<PlayerManufacture> factoryQueue = Lists.newArrayList();
        List<PlayerManufacture> lists = playerManufactureDao.cacheLoadAll(roleID);
        if(lists != null && lists.size() > 0) {
            for (PlayerManufacture tmp : lists) {
                if (tmp.getFactoryID() == factoryID) {
                    factoryQueue.add(tmp);
                }
            }
        }
        Collections.sort(factoryQueue);
        // 0:领取
        if (req.getEnqueued() == 0) {
            PlayerManufacture playerManufacture0 = null;
            long nowTime = System.currentTimeMillis();
            for (PlayerManufacture tmp : factoryQueue) {
                Date endTime = DateUtil.plusTime(tmp.getStartTime(), TimeUnit.SECONDS, tmp.getMakingTime());
                if ((endTime.getTime() > nowTime)&&(tmp.getState() != EManufactureState.Finished_VALUE)) {
                    continue;
                }
                playerManufacture0 = tmp;
                break;
            }
            if (playerManufacture0 == null) {
                throw new CommonException(ErrorID.COMMON_PARAM_ERROR, roleID);
            }
            builder.setProduceItemId(playerManufacture0.getRecipeID());
            builder.setProduceItemCount(1);
            // 制作获得成品
            addItem(roleID, playerManufacture0.getRecipeID(), 1, ResourceBillEnum.manufactureAction, false);
            // 获得经验
            data = conf.getManufactureMakeData(playerManufacture0.getRecipeID());
            addExp(roleID, data.getExp(), ResourceBillEnum.manufactureActionReward);
            playerManufactureDao.cacheDelete(playerManufacture0.getPrimaryKeyValue(), roleID);
            ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.PRODUCE_GOODS);
            if (configTasks != null) {
                EventManager.postTaskActionEvent(roleID, TaskActionEnum.PRODUCE_GOODS, 1);
            }
            EventManager.commitRoleEvent(roleID);
            return;
        }
        // 1:制作消耗材料
        checkLevelEnough(roleID, data.getLevelRequire());
        checkItemEnough(roleID, data.getMatrial1(), data.getNum1());
        checkItemEnough(roleID, data.getMatrial2(), data.getNum2());
        checkItemEnough(roleID, data.getMatrial3(), data.getNum3());
        checkItemEnough(roleID, data.getMatrial4(), data.getNum4());
        checkItemEnough(roleID, data.getMatrial5(), data.getNum5());
        costItem(roleID, data.getMatrial1(), data.getNum1(), ResourceBillEnum.manufactureActionCost, false);
        costItem(roleID, data.getMatrial2(), data.getNum2(), ResourceBillEnum.manufactureActionCost, false);
        costItem(roleID, data.getMatrial3(), data.getNum3(), ResourceBillEnum.manufactureActionCost, false);
        costItem(roleID, data.getMatrial4(), data.getNum4(), ResourceBillEnum.manufactureActionCost, false);
        costItem(roleID, data.getMatrial5(), data.getNum5(), ResourceBillEnum.manufactureActionCost, false);
        // 添加到制作队列里
        PlayerManufacture playerManufacture1 = new PlayerManufacture(roleID);
        //playerManufacture1.setId(readModuleID(TableID.TABLE_MANUFACTURE));
        playerManufacture1.setFactoryID(data.getFactory());
        playerManufacture1.setRecipeID(req.getRecipeId());
        playerManufacture1.setMakingTime(data.getCookingTime() * DateUtil.ONEMINUTE_2_SECOND);
        if (factoryQueue.size() == 0) {
            // 当前队列为空
            playerManufacture1.setStartTime(DateUtil.getCurrentDate());
            playerManufacture1.setState(EManufactureState.Making_VALUE);
        } else {
            // 设置新增的开始时间为最后一个制作队列的结束时间
            PlayerManufacture lastQueue = factoryQueue.get(factoryQueue.size() - 1);
            Date startTime = DateUtil.plusTime(lastQueue.getStartTime(), TimeUnit.SECONDS, lastQueue.getMakingTime());
            if (startTime.getTime() < System.currentTimeMillis()) {
                startTime = DateUtil.getCurrentDate();
            }
            playerManufacture1.setStartTime(startTime);
            playerManufacture1.setState(EManufactureState.Queued_VALUE);
        }
        playerManufactureDao.cacheInsert(playerManufacture1, roleID);
        builder.setProduceItemId(req.getRecipeId());
        builder.setProduceItemCount(1);
    }

    /**
     *	制作加速
     *
     * @param roleID
     * @param req
     * @param builder
     */
    public void manufactureSpeedup(long roleID, ManufactureSpeedupReq req, ManufactureSpeedupRsp.Builder builder) {
        // 获取当前建筑的队列
        List<PlayerManufacture> factoryQueue = Lists.newArrayList();
        List<PlayerManufacture> lists = playerManufactureDao.cacheLoadAll(roleID);
        if(lists != null && lists.size() > 0) {
            for (PlayerManufacture tmp : lists) {
                if (tmp.getFactoryID() == req.getBuildingId()) {
                    factoryQueue.add(tmp);
                }
            }
        }
        Collections.sort(factoryQueue);
        if (factoryQueue.size() <= req.getIndex()) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR, roleID + ":" + req.getIndex());
        }
        PlayerManufacture queue = factoryQueue.get(req.getIndex());
        long nowTime = System.currentTimeMillis();
        Date endTime = DateUtil.plusTime(queue.getStartTime(), TimeUnit.SECONDS, queue.getMakingTime());
        if (nowTime < queue.getStartTime().getTime()) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR, roleID + ":" + req.getIndex());
        }
        // 剩余时间
        int countDown = (int) ((endTime.getTime() - nowTime) / 60000);
        // 离结束时间还有10秒以上
        //if (countDown < 1) {
        //    throw new CommonException(ErrorID.COMMON_PARAM_ERROR, roleID + ":" + req.getIndex());
        //}
        int count = 0;
        ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.PRODUCE_GOODS);
        if (configTasks == null) {
            if(countDown%ConfigSundryConf.accelerateConsumption > 0){
                count = (countDown/ConfigSundryConf.accelerateConsumption + 1);
            }else{
                count = (countDown/ConfigSundryConf.accelerateConsumption);
            }
            checkDiamondEnough(roleID, count);
            costDiamond(roleID, count, ResourceBillEnum.manufactureSpeedup);
        }
        // 设置结束
        queue.setStartTime(DateUtil.plusTime(queue.getStartTime(), TimeUnit.SECONDS, -countDown*60));
        queue.setState(EManufactureState.Finished_VALUE);
        playerManufactureDao.cacheUpdate(queue, roleID);
        // 封装返回信息
        ManufactureInfo.Builder manufactureInfo = ManufactureInfo.newBuilder();
        manufactureInfo.setStartTime(DateTime.newBuilder().setValue(queue.getStartTime().getTime()));
        List<ManufactureState> makingQueue = Lists.newArrayListWithExpectedSize(factoryQueue.size());
        // 遍历剩下队列
        Date startTime = DateUtil.getCurrentDate();
        for (PlayerManufacture tmp : factoryQueue) {
            if (tmp.getState() == EManufactureState.Queued_VALUE) {
                tmp.setStartTime(startTime);
                tmp.setState(EManufactureState.Making_VALUE);
                playerManufactureDao.cacheUpdate(tmp, roleID);
                break;
            }
        }
        for (PlayerManufacture tmp : factoryQueue) {
            ManufactureState.Builder manufactureState = ManufactureState.newBuilder();
            manufactureState.setRecipeId(tmp.getRecipeID());
            manufactureState.setState(EManufactureState.forNumber(tmp.getState()));
            manufactureState.setMakingTime(tmp.getMakingTime());
            manufactureState.setCountDown(tmp.getMakingTime());
            makingQueue.add(manufactureState.build());
        }
        manufactureInfo.addAllMakingQueue(makingQueue);
        builder.setInfo(manufactureInfo.build());
    }

    /**
     *	批量拾取制作物品
     *
     * @param roleID
     * @param req
     */
    public List<Integer> manufactureBatchPickup(long roleID, ManufactureBatchPickupReq req) {
        List<Integer> successIndex = Lists.newArrayList();
        long nowTime = System.currentTimeMillis();
        List<PlayerManufacture> factoryQueue = Lists.newArrayList();
        // 获取当前建筑的队列
        List<PlayerManufacture> list = playerManufactureDao.cacheLoadAll(roleID);
        if(list != null && list.size() > 0) {
            for (PlayerManufacture tmp : list) {
                if (tmp.getFactoryID() == req.getBuildingId()) {
                    factoryQueue.add(tmp);
                }
            }
        }
        Collections.sort(factoryQueue);
        ConfigManufactureMakeDataConf conf = ConfManager.getInstance().getConfigManufactureMakeDataConf();
        if(conf == null){
            log.error("manufactureBatchPickup ConfigManufactureMakeDataConf conf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        for (int i = 0; i < factoryQueue.size(); i++) {
            PlayerManufacture playerManufacture = factoryQueue.get(i);
            Date endTime = DateUtil.plusTime(playerManufacture.getStartTime(), TimeUnit.SECONDS, playerManufacture.getMakingTime());
            if (endTime.getTime() > nowTime + 5000) {
                continue;
            }
            addItem(roleID, playerManufacture.getRecipeID(), 1, ResourceBillEnum.manufactureBatchPickup, false);
            // 获得经验
            ConfigManufactureMakeData data = conf.getManufactureMakeData(playerManufacture.getRecipeID());
            addExp(roleID, data.getExp(), ResourceBillEnum.manufactureActionReward);
            playerManufactureDao.cacheDelete(playerManufacture.getId(), roleID);
            successIndex.add(i);
        }
        return successIndex;
    }
}
