package com.dj.serverplayer.handler;

import com.dj.domain.config.ConfigTasks;
import com.dj.domain.config.ConfigVerifyFunc;
import com.dj.domain.data.Verify;
import com.dj.domain.entity.player.PlayerVerify;
import com.dj.domain.entity.player.PlayerVerifyHistory;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.util.DateUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.verify.*;
import com.dj.serverapi.helper.MessageHelper;
import com.dj.servercore.conf.ConfigItemsConf;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.servercore.conf.ConfigVerifyFuncConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.manager.EventManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zcq
 * @description 鉴定业务处理
 * @date 2019年4月3日
 */
@Component
@Slf4j
public class VerifyHandler extends BaseHandler {
	
    /**
     *	本人-获取待揭晓队列
     *
     * @param roleID
     * @param builder
     */
    public void verifiedQueue(long roleID, VerifiedQueueRsp.Builder builder) {
        // 鉴定队列
        List<Integer> queuesList = new ArrayList<>();
        List<PlayerVerify> verifyList = playerVerifyDao.cacheLoadAll(roleID);
        if(verifyList != null && verifyList.size() > 0) {
            ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.VERIFY_ME);
            if ((configTasks != null) && (configTasks.getExtraParam() > 0)) {
                for(PlayerVerify playerVerify : verifyList){
                    if(playerVerify.getVerifyID() == configTasks.getExtraParam()) {
                        verifyList.remove(playerVerify);
                    }
                }
            }
            //if ((configTasks != null) && (StringUtil.isNotEmpty(configTasks.getExtraParam()))) {
            //    Map<Integer, Integer> itemMap = MapUtil.mapStringToMap1(configTasks.getExtraParam());
            //    for(PlayerVerify playerVerify: verifyList){
            //        if((itemMap.size() > 0)&&(!itemMap.containsKey(playerVerify.getVerifyID()))) {
            //            verifyList.remove(playerVerify);
            //        }
            //    }
            //}
            if(verifyList.size() > 0) {
                MessageHelper.toVerifyQueues(verifyList, queue -> builder.addQueues(queue));
                for(PlayerVerify playerVerify: verifyList){
                    queuesList.add(playerVerify.getVerifyID());
                }
            }
        }else {
            log.error("verifiedQueue verifyList == null roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        // 鉴定道具(选择用)
        List<Verify> items = verifyService.getVerifyList(roleID);
        if(items != null && items.size() > 0) {
            MessageHelper.toVerifyItem(items, item -> builder.addItems(item), queuesList);
        }
        // 小寻今天鉴定次数
        builder.setVerifyCount(otherService.getVerifyCount(roleID));
        // 鉴定历史记录
        List<PlayerVerifyHistory> histories = playerVerifyHistoryDao.cacheLoadAll(roleID);
        if(histories != null && histories.size() > 0) {
            MessageHelper.toVerifyHistories(histories, builder);
        }
    }

    /**
     *	将仓库物品放入待鉴定队列
     * @param roleID
     * @param req
     */
    public void verifyEnqueue(long roleID, VerifyEnqueueReq req, VerifyEnqueueRsp.Builder builder) {
        List<Integer> queuesList = new ArrayList<>();
        List<PlayerVerify> verifyList = playerVerifyDao.cacheLoadAll(roleID);
        if(verifyList != null && verifyList.size() > 0) {
            for(PlayerVerify playerVerify: verifyList){
                queuesList.add(playerVerify.getVerifyID());
            }
        }else {
            log.error("verifyEnqueue verifyList == null roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }

        if(req.getIndex() >= verifyList.size()){
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        Collections.sort(verifyList);
        PlayerVerify playerVerify = verifyList.get(req.getIndex());
        if(playerVerify.getVerifyID() != 0){
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        costItem(roleID, req.getItemId(), 1, ResourceBillEnum.verifyEequeue);
        // 更新鉴定
        playerVerify.setVerifyID(req.getItemId());
        playerVerify.setVerifyRoleID(roleID+"");
        playerVerify.setVerifyRoleIDList(null);
        ConfigVerifyFuncConf verifyFuncConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_VERIFYFUNC);
        if(verifyFuncConf == null){
            log.error("verifyEnqueue ConfigVerifyFuncConf verifyFuncConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigVerifyFunc verifyFunc = verifyFuncConf.getConfigVerifyFunc(playerVerify.getVerifyID());
        if(verifyFunc == null){
            log.error("verifyEnqueue ConfigVerifyFunc verifyFunc == null roleID:{}", roleID);
            throw new CommonException(ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigItemsConf itemsConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_ITEMS);
        if(itemsConf == null){
            log.error("verifyEnqueue ConfigItemsConf itemsConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        playerVerify.setVerifyFinishTime(DateUtil.plusNow(TimeUnit.MINUTES, verifyFunc.getVerifyTime()));
        // 先出鉴定结果，后续再用
        ConfigVerifyFuncConf verifyFuncConf1 = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_VERIFYFUNC);
        if(verifyFuncConf1 == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        Integer color = verifyFuncConf.getProResult(playerVerify.getVerifyID());
        Integer exp = verifyFuncConf.getProExp(playerVerify.getVerifyID());
        ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.VERIFY_ME);
        if ((configTasks != null) && (configTasks.getExtraParam() > 0)) {
            playerVerify.setResultItem(configTasks.getExtraParam());
        }else{
            int newItemId = itemsConf.getItemIdByType(playerVerify.getVerifyID(), color);
            playerVerify.setResultItem(newItemId);
        }
        playerVerify.setResultRep(exp);
        // 身上有鉴定任务
//        if(taskHandler.checkHashActionTask(roleID, TaskActionEnum.VERIFY_ME) != null) {
//        	playerVerify.setVerifyRoleID(roleID+"");
//        	playerVerify.setVerifyFinishTime(DateUtil.getCurrentDate());
//        }
        playerVerifyDao.cacheUpdate(playerVerify, roleID);
        verifyService.setVerifyQueue(roleID, verifyList);
        // 鉴定道具(选择用)
        List<Verify> items = verifyService.getVerifyList(roleID);
        if(items != null && items.size() > 0) {
            MessageHelper.toVerifyItem(items, item -> builder.addItems(item), queuesList);
        }
        // 鉴定剩余时间(秒数)
        int verifyCD = DateUtil.secondsBetween(DateUtil.getCurrentDate(), playerVerify.getVerifyFinishTime());
    	builder.setVerifyCD(verifyCD);
    }

    /**
     *	将物品从待揭晓队列放入仓库
     *
     * @param roleID
     * @param index
     */
    public void verifyDequeue(long roleID, int index, VerifyDequeueRsp.Builder builder) {
        List<PlayerVerify> verifyList = playerVerifyDao.cacheLoadAll(roleID);
        if(verifyList == null || verifyList.size() == 0) {
            log.error("verifyDequeue verifyList == null roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        if(index >= verifyList.size()){
            log.error("verifyDequeue index >= verifyList.size() roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        Collections.sort(verifyList);
        PlayerVerify playerVerify = verifyList.get(index);
        // 鉴定时间未结束
        Date verifyFinishTime = playerVerify.getVerifyFinishTime();
        if((verifyFinishTime != null)&&(verifyFinishTime.getTime() > System.currentTimeMillis())) {
            log.error("verifyDequeue verifyFinishTime != null roleID:{}", roleID);
        	throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        addItem(roleID, playerVerify.getResultItem(), 1, ResourceBillEnum.verifyDequeue, false);
        if(playerVerify.getVerifyRoleID().equals(roleID+"")) {
            ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.VERIFY_ME);
            if ((configTasks != null) && ( configTasks.getExtraParam() > 0)) {
                if(playerVerify.getResultItem() == configTasks.getExtraParam()) {
                    EventManager.postTaskActionEvent(roleID, TaskActionEnum.VERIFY_ME, 1);
                    EventManager.commitRoleEvent(roleID);
                }
            }
            //if ((configTasks != null) && (StringUtil.isNotEmpty(configTasks.getExtraParam()))) {
            //    Map<Integer, Integer> itemMap = MapUtil.mapStringToMap1(configTasks.getExtraParam());
            //    if((itemMap.size() > 0)&&(itemMap.containsKey(playerVerify.getVerifyID()))) {
            //        EventManager.postTaskActionEvent(roleID, TaskActionEnum.VERIFY_ME, 1);
            //        EventManager.commitRoleEvent(roleID);
            //    }
            //}
        }
        builder.setResultItem(playerVerify.getResultItem());
        // 更新鉴定
        playerVerify.setVerifyID(0);
        playerVerify.setVerifyRoleID("");
        playerVerify.setVerifyRoleIDList(null);
        playerVerify.setVerifyFinishTime(null);
        playerVerify.setResultItem(0);
        playerVerifyDao.cacheUpdate(playerVerify, roleID);
        verifyService.setVerifyQueue(roleID, verifyList);
    }

    /**
     * 使用鉴定卡鉴定
     * @param roleID
     * @param req
     * @param builder
     */
	public void verifyUseCard(long roleID, VerifyUseCardReq req, VerifyUseCardRsp.Builder builder) {
		// 获取指定目标位
		List<PlayerVerify> verifyList = playerVerifyDao.cacheLoadAll(roleID);
        if(verifyList == null || verifyList.size() == 0) {
            log.error("verifyUseCard verifyList == null roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        if(req.getIndex() >= verifyList.size()){
            log.error("verifyDequeue req.getIndex() >= verifyList.size() roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        Collections.sort(verifyList);
        PlayerVerify playerVerify = verifyList.get(req.getIndex());
        // 鉴定结果
        addItem(roleID, playerVerify.getResultItem(), 1, ResourceBillEnum.verifyUseCard, false);
        //addRenown(roleID, playerVerify.getResultRep(), ResourceBillEnum.verifyUseCard);
        //addExp(roleID, playerVerify.getResultRep(), ResourceBillEnum.verifyUseCard);
        // 更新鉴定
        playerVerify.setVerifyID(0);
        playerVerify.setVerifyRoleID("");
        playerVerify.setResultItem(0);
        playerVerify.setResultRep(0);
        playerVerifyDao.cacheUpdate(playerVerify, roleID);
        verifyService.setVerifyQueue(roleID, verifyList);
        // 扣除鉴定卡
        costItem(roleID, req.getCardID(), req.getCardCount(), ResourceBillEnum.verifyUseCard);
	}
    
    /**
     * 鉴定加速
     * @param roleID
     * @param req
     * @param builder
     */
	public void verifySpeedup(long roleID, VerifySpeedupReq req, VerifySpeedupRsp.Builder builder) {
		List<PlayerVerify> verifyList = playerVerifyDao.cacheLoadAll(roleID);
        if(verifyList == null || verifyList.size() == 0) {
            log.error("verifySpeedup verifyList == null roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        if(req.getIndex() >= verifyList.size()){
            log.error("verifyDequeue req.getIndex() >= verifyList.size() roleID:{}", roleID);
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        Collections.sort(verifyList);
        PlayerVerify playerVerify = verifyList.get(req.getIndex());
        // 鉴定时间已结束
        long nowTime = System.currentTimeMillis();
        Date verifyFinishTime = playerVerify.getVerifyFinishTime();
        if((verifyFinishTime == null)||(verifyFinishTime.getTime() <= nowTime)) {
            log.error("verifyDequeue verifyFinishTime == null roleID:{}", roleID);
        	throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        // 检查加速卡数量是否足够
        //checkItemEnough(roleID, req.getSpeedupCard(), req.getCardCount());
        //ConfigItemsConf conf = ConfManager.getInstance().getConfigItemsConf();
        //if(conf == null){
        //    throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        //}
        //ConfigItems item = conf.getItem(req.getSpeedupCard());
        //if(ObjectUtils.isEmpty(item)){
        //    throw new CommonException(ErrorID.COMMON_CONFIG_ERROR);
        //}
        //int i = 1;
        //Date nowDate = DateUtil.getCurrentDate();
        //for (; i <= req.getCardCount(); i++) {
		//	verifyFinishTime = DateUtil.plusTime(verifyFinishTime, TimeUnit.MINUTES, -item.getSpeedUp());
		//	if(verifyFinishTime.getTime() <= nowDate.getTime()) {
		//		verifyFinishTime = nowDate;
		//		break;
		//	}
		//}
        int count = 0;
        ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.VERIFY_ME);
        if (configTasks == null) {
            int countDown = (int) ((verifyFinishTime.getTime() - nowTime) / 60000);
            if (countDown % ConfigSundryConf.accelerateConsumption > 0) {
                count = (countDown / ConfigSundryConf.accelerateConsumption + 1);
            } else {
                count = (countDown / ConfigSundryConf.accelerateConsumption);
            }
        }
        //costItem(roleID, req.getSpeedupCard(), i, ResourceBillEnum.verifySpeedup);
        checkDiamondEnough(roleID, count);
        //更新鉴定结束时间
        playerVerify.setVerifyFinishTime(new Date());
        playerVerifyDao.cacheUpdate(playerVerify, roleID);
        verifyService.setVerifyQueue(roleID, verifyList);
        // 返回数据
        //if(verifyFinishTime.getTime() <= System.currentTimeMillis()) {
        	// 鉴定结束
        	builder.setVerifyCD(0);
        	builder.setResultItem(playerVerify.getResultItem());
        //}else {
        //	// 鉴定中
        //	int verifyCD = DateUtil.secondsBetween(DateUtil.getCurrentDate(), verifyFinishTime);
        //	builder.setVerifyCD(verifyCD);
        //    builder.setResultItem(0);
        //}
        costDiamond(roleID, count, ResourceBillEnum.manufactureSpeedup);
	}
}
