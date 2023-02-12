package com.dj.serverapi.service;

import com.dj.domain.config.ConfigSummonExplore;
import com.dj.domain.config.ConfigSummons;
import com.dj.domain.constant.ConstantGame;
import com.dj.domain.data.summon.SummonData;
import com.dj.domain.data.summon.SummonInvest;
import com.dj.domain.data.summon.SummonPackage;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.GsonUtil;
import com.dj.domain.util.inf.IArgumentRunnable;
import com.dj.domain.util.math.RandomUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.summon.*;
import com.dj.serverapi.EventProvider;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.PlayerRoleDao;
import com.dj.serverapi.helper.MessageHelper;
import com.dj.serverapi.redis.model.SummonModel;
import com.dj.serverapi.service.inf.ISummonService;
import com.dj.servercore.conf.*;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.servercore.redis.base.BaseService;
import com.dj.servercore.spring.SpringContext;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SummonServiceImpl extends BaseService implements ISummonService {

    @Override
    public SummonData getSummonResetMail(long roleID) {
        SummonModel model = getWriteModel(roleID, SummonModel.class);
        if(model != null){
            Map<Integer, SummonData> summonDataMap = model.getSummonMap();
            if(ObjectUtils.isNotEmpty(summonDataMap) && (summonDataMap.size() > 0)) {
                for (SummonData summonData : summonDataMap.values()) {
                    if((summonData.isCanInvest())||
                            ((summonData.getSendTime() > 0)&&
                                    (!summonData.isTourEnd()))){
                        if (summonData.getPackages().size() > 0) {
                            long nowTime = System.currentTimeMillis();
                            for (SummonPackage summonPackage : summonData.getPackages()) {
                                // 邮件未发放
                                summonPackage.setNtfFlag(summonPackage.getTime() < nowTime);
                            }
                            model.setSummon(summonData);
                        }
                        return summonData;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Map<Integer, SummonData> getSummonMap(long roleID) {
        SummonModel model = getWriteModel(roleID, SummonModel.class);
        if(model != null){
            return model.getSummonMap();
        }
        return null;
    }

    @Override
    public void setSummonMap(long roleID, Map<Integer, SummonData> summonDataMap) {
        SummonModel model = getWriteModel(roleID, SummonModel.class);
        if(model != null){
            model.clearSummonMap();
            if((summonDataMap != null) && (summonDataMap.size() > 0)) {
                for(SummonData summonData : summonDataMap.values()) {
                    model.setSummon(summonData);
                }
            }
        }
    }

    @Override
    public SummonData getSummon(long roleID) {
        SummonModel model = getWriteModel(roleID, SummonModel.class);
        if(model != null){
            Map<Integer, SummonData> summonDataMap = model.getSummonMap();
            if(ObjectUtils.isNotEmpty(summonDataMap) && (summonDataMap.size() > 0)) {
                    for (SummonData summonData : summonDataMap.values()) {
                        if((summonData.isCanInvest())||
                                ((summonData.getSendTime() > 0) && (!summonData.isTourEnd()))) {
                        return summonData;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Integer getCurSummonId(long roleID){
        SummonModel model = getWriteModel(roleID, SummonModel.class);
        if(model != null){
            Map<Integer, SummonData> summonDataMap = model.getSummonMap();
            if(ObjectUtils.isNotEmpty(summonDataMap) && (summonDataMap.size() > 0)){
                for (SummonData summonData : summonDataMap.values()) {
                    if((summonData.isCanInvest())||
                            ((summonData.getSendTime() > 0)&&
                                    (!summonData.isTourEnd()))){
                        return summonData.getSummonID();
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public void setSummon(long roleID, SummonData summonData) {
        SummonModel model = getWriteModel(roleID, SummonModel.class);
        if(model != null) {
            model.setSummon(summonData);
        }
    }

    @Override
    public void removeSummon(long roleID, Integer summonId) {
        SummonModel model = getWriteModel(roleID, SummonModel.class);
        if(model != null) {
            model.removeSummon(summonId);
        }
    }

    @Override
    public SummonData callSummon(long roleID, ConfigSummons configSummon) {
        SummonModel model = getWriteModel(roleID, SummonModel.class);
        if(model == null){
            return null;
        }
        SummonData summonData = model.getSummon(configSummon.getID());
        if(summonData != null){
            return null;
        }
        boolean isDefSummon = true;
        Map<Integer, SummonData> summonDataMap = model.getSummonMap();
        if((ObjectUtils.isNotEmpty(summonDataMap)) && (summonDataMap.size() > 0)) {
            for (Integer summonId : summonDataMap.keySet()) {
                summonData = summonDataMap.get(summonId);
                if ((summonData.getElement() == configSummon.getElement())
                        &&(summonData.getLevel() == configSummon.getLevel())) {
                    return null;
                }
                if(!summonData.isTourEnd()){
                    isDefSummon = false;
                }
            }
        }
        summonData = new SummonData();
        summonData.setRoleID(roleID);
        summonData.setSummonID(configSummon.getID());
        summonData.setElement(configSummon.getElement());
        summonData.setLevel(configSummon.getLevel());
        summonData.setPackages(Lists.newArrayList());
        summonData.setCanInvest(false);
        summonData.setTourEnd(false);
        summonData.setDefUsed(isDefSummon);
        model.setSummon(summonData);
        return summonData;
    }

    @Override
    public void summonSend(long roleID, int summonID, SummonSendRsp.Builder builder, int packageID, int packageCount) {
        ConfigSummonsConf summonsConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_SUMMONS);
        if(summonsConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigSummonsExploreConf summonsExploreConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_SUMMONSEXPLORE);
        if(summonsExploreConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigCollectionEventConf collectionEventConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_COLLECTION_EVENT);
        if(collectionEventConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        SummonModel model = getWriteModel(roleID, SummonModel.class);
        if(model == null){
            return;
        }
        SummonData summonData = model.getSummon(summonID);
        if (summonData == null) {
            throw new CommonException(ErrorID.SUMMON_NOT_EXIT);
        }
        if (summonData.getSendTime() > 0) {
            throw new CommonException(ErrorID.SUMMON_SENDING);
        }
        summonData.setAllPackageCount(packageCount);
        // 派出时间
        long time = System.currentTimeMillis();
        summonData.setSendTime(time);
        // 清除上一轮邮件
        summonData.getPackages().clear();
        // 清除投资
        if(summonData.getInvestReward() != null) {
            summonData.getInvestReward().clear();
        }
        // 生成邮件
        // 邮件周期 = 正常包裹间隔时间（分钟）(分钟) * 60
        long mailCycle = ((long) ConfigSundryConf.summonPackageTime * DateUtil.ONEMINUTE_2_SECOND * 1000);
        for (int i = 0; i < packageCount; i++) {
            SummonPackage summonPackage = new SummonPackage();
            summonPackage.setConfigMailID(0);
            summonPackage.setProcessed(false);
            summonPackage.setRewardItem(Maps.newHashMapWithExpectedSize(3));
            summonPackage.setIndex(i+1);
            summonPackage.setTime(time + summonPackage.getIndex() * mailCycle);
            summonPackage.setSummonID(summonID);
            summonPackage.setReturnTime(time + (summonPackage.getIndex()+1) * mailCycle);
            summonPackage.setPositionX(RandomUtil.nextInt(-ConstantGame.WORLD_MAP_WEIGHT, ConstantGame.WORLD_MAP_WEIGHT));
            summonPackage.setPositionY(RandomUtil.nextInt(-ConstantGame.WORLD_MAP_HEIGHT, ConstantGame.WORLD_MAP_HEIGHT));
            // 投资事件
            boolean isInvestPackage = false;
            if((packageCount < 10)&&(packageCount == i+1)&&(summonData.getInvestPackageCount() == 0)){
                //投资规则1：如果到最后一个邮件都没有出投资的话，最后一个必须是投资。
                isInvestPackage = true;
                summonData.setInvestPackageCount(1);
            }
            if((packageCount >= 10)&&(summonData.getCommonPackageCount() >= 9)){
                //投资规则2：出过投资后，重新计数。如果连续9次未出投资，则第10次必出投资。
                isInvestPackage = true;
                summonData.setCommonPackageCount(0);
            }
            // 处理事件
            Map<Integer, Integer> allWeightMap = summonsExploreConf.getAllWeightMap();
            if(allWeightMap != null && allWeightMap.size() > 0){
                ConfigSummonExplore exploreConfig = summonsExploreConf.getSummonExplore(RandomUtil.weightedRandom(allWeightMap));
                if(exploreConfig.getInvest() == 1) {
                    // 投资事件
                    isInvestPackage = true;
                    summonData.setInvestPackageCount(summonData.getInvestPackageCount() + 1);
                    summonData.setCommonPackageCount(0);
                }
            }
            if(!isInvestPackage) {
                // 普通事件
                Map<Integer, Integer> eventWeightMap = summonsExploreConf.getEventWeightMap();
                if(eventWeightMap == null || eventWeightMap.size() == 0) {
                    continue;
                }
                int exploreId = RandomUtil.weightedRandom(eventWeightMap);
                summonPackage.setTerrainId(exploreId);
                Map<Integer, Integer> matrialWeightedMap = summonsExploreConf.getMatrialWeighted(exploreId);
                if(matrialWeightedMap == null || matrialWeightedMap.size() == 0){
                    log.error("summonSend matrialWeightedMap == null exploreId = {}", exploreId);
                    continue;
                }
                int rewardType = RandomUtil.weightedRandom(matrialWeightedMap);
                int senceId = 200 + summonData.getLevel()*10 + summonData.getElement();
                log.info("roleID {}, senceId:{}", roleID, senceId);
                Map<Integer, Integer> weightedMap = collectionEventConf.getWeighted(senceId, rewardType);
                if(weightedMap == null || weightedMap.size() == 0){
                    log.error("summonSend weightedMap == null senceId = {} rewardType = {}", senceId, rewardType);
                    continue;
                }
                int outputId = RandomUtil.weightedRandom(weightedMap);
                if (rewardType != 3 && rewardType != 4 && outputId >= 1) {
                    if (outputId == 10) {
                        summonPackage.setRewardGold(1);
                    } else {
                        summonPackage.getRewardItem().put(outputId, 1);
                    }
                }
                summonPackage.setRewardType(rewardType);
                summonData.setCommonPackageCount(summonData.getCommonPackageCount()+1);
            }else {
                Map<Integer, Integer> investWeightMap = summonsExploreConf.getInvestWeightMap();
                if(investWeightMap == null || investWeightMap.size() == 0) {
                    continue;
                }
                int exploreId = RandomUtil.weightedRandom(investWeightMap);
                summonPackage.setTerrainId(exploreId);
                summonPackage.setRewardType(ConstantGame.SUMMON_INVEST_EVENT);
            }
            summonData.getPackages().add(summonPackage);
        }
        model.setSummon(summonData);
        // 精灵寻宝任务
        EventProvider.postTaskActionEvent(roleID, TaskActionEnum.SUMMON_TREASURE, 1);
        EventProvider.commitRoleEvent(roleID);
        builder.setSummonID(summonID);
        builder.setCountDown(ConfigSundryConf.summonPackageTime * DateUtil.ONEMINUTE_2_SECOND);
        builder.setMailCount(packageCount);
        builder.setCurLevel(0);
        PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        if(playerRole != null){
            playerRole.setSummonLevel(0);
            PlayerRoleDao playerRoleDao = SpringContext.getBean(PlayerRoleDao.class);
            if(playerRoleDao != null) {
                playerRoleDao.cacheUpdate(playerRole);
            }
            ServiceProvider.getPlayerService().setPlayer(roleID, playerRole);
        }
    }

    @Override
    public void summonMailReward(long roleID, int index, SummonMailRewardRsp.Builder builder, IArgumentRunnable<SummonPackage> mailRun) {
        SummonModel model = getWriteModel(roleID, SummonModel.class);
        if(model != null) {
            Map<Integer, SummonData> summonDataMap = model.getSummonMap();
            if(ObjectUtils.isNotEmpty(summonDataMap) && (summonDataMap.size() > 0)) {
                for (SummonData summonData : summonDataMap.values()) {
                    if ((summonData.isCanInvest()) ||
                            ((summonData.getSendTime() > 0) &&
                                    (!summonData.isTourEnd()))) {
                        boolean hasNewMail = model.mailReward(index, summonData.getSummonID(), mailRun);
                        builder.setHasNewMail(hasNewMail);
                    }else {
                        if (summonData.getPackages().size() >= index) {
                            boolean hasNewMail = model.mailReward(index, summonData.getSummonID(), mailRun);
                            builder.setHasNewMail(hasNewMail);
                            boolean mailsAllProcessed = true;
                            for (SummonPackage summonPackage : summonData.getPackages()) {
                                if (!summonPackage.isProcessed()) {
                                    mailsAllProcessed = false;
                                    break;
                                }
                            }
                            if ((mailsAllProcessed) && (summonData.getRevPackageCount() >= summonData.getAllPackageCount())) {
                                // 旅行结束
                                tourEnd(roleID, summonData.getSummonID());
                            }
                            boolean mailsAllRewarded = true;
                            for (SummonPackage summonPackage : summonData.getPackages()) {
                                if (!summonPackage.isReward()) {
                                    mailsAllRewarded = false;
                                    break;
                                }
                            }
                            if (mailsAllRewarded) {
                                model.removeSummon(summonData.getSummonID());
                                summonMailReward(roleID, index, builder, mailRun);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public SummonPackage summonMailRefresh(long roleID, int index) {
        SummonModel model = getWriteModel(roleID, SummonModel.class);
        if(model != null){
            Map<Integer, SummonData> summonDataMap = model.getSummonMap();
            if(ObjectUtils.isNotEmpty(summonDataMap) && (summonDataMap.size() > 0)) {
                for (SummonData summonData : summonDataMap.values()) {
                    if((summonData.isCanInvest())||
                            ((summonData.getSendTime() > 0)&&
                                    (!summonData.isTourEnd()))){
                        if (summonData.getPackages().size() > 0) {
                            long nowTime = System.currentTimeMillis();
                            for (int i = summonData.getPackages().size() - 1; i >= 0; i--) {
                                SummonPackage summonPackage = summonData.getPackages().get(i);
                                if (summonPackage.getTime() < nowTime) {
                                    summonPackage.setIndex(index);
                                    return summonPackage;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public SummonData tourEnd(long roleID, int summonId) {
        SummonModel model = getWriteModel(roleID, SummonModel.class);
        if(model == null)return null;
        SummonData summonData = model.getSummon(summonId);
        if(summonData != null) {
            summonData.setSendTime(0);
            summonData.setDefUsed(false);
            summonData.setTourEnd(true);
            model.setSummon(summonData);
        }
        return summonData;
    }

    @Override
    public void summonMailFirst(long roleID, int index) {
        SummonModel model = getWriteModel(roleID, SummonModel.class);
        if(model != null){
            Map<Integer, SummonData> summonDataMap = model.getSummonMap();
            if(ObjectUtils.isNotEmpty(summonDataMap) && (summonDataMap.size() > 0)) {
                for (SummonData summonData : summonDataMap.values()) {
                    if((summonData.isCanInvest())||
                            ((summonData.getSendTime() > 0)&&
                                    (!summonData.isTourEnd()))){
                        SummonPackage summonPackage = summonData.getPackages().get(index);
                        summonPackage.setFirst(1);
                        model.setSummon(summonData);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void summonInvest(long roleID, SummonInvestReq req, SummonInvestRsp.Builder builder, IArgumentRunnable<ConfigSummonExplore> costGoldRun) {
        ConfigSummonsExploreConf exploreConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_SUMMONSEXPLORE);
        if(exploreConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        SummonModel model = getWriteModel(roleID, SummonModel.class);
        if(model != null){
            Map<Integer, SummonData> summonDataMap = model.getSummonMap();
            if(ObjectUtils.isNotEmpty(summonDataMap) && (summonDataMap.size() > 0)) {
                for (SummonData summonData : summonDataMap.values()) {
                    if((!summonData.isTourEnd())&&(summonData.getSendTime() > 0)||(summonData.isCanInvest())){
                        for(SummonPackage summonPackage : summonData.getPackages()) {
                            if((summonPackage.getRewardType() ==  ConstantGame.SUMMON_INVEST_EVENT) && (summonPackage.getIndex() == req.getIndex())) {
                                summonData.setCanInvest(false);
                                if(req.getGaveUp()) {
                                    summonPackage.setReward(true);
                                    summonPackage.setProcessed(true);
                                }else {
                                    ConfigSummonExplore exploreConfig = exploreConf.getSummonExplore(summonPackage.getTerrainId());
                                    if(exploreConfig.getInvest() != 1) {
                                        throw new CommonException(ErrorID.COMMON_PARAM_ERROR, roleID);
                                    }
                                    costGoldRun.run(exploreConfig);
                                    summonPackage.setInvestDate(DateUtil.plusNow(TimeUnit.SECONDS, exploreConfig.getInvestTime()));
                                    summonPackage.setProcessed(true);
                                    // 投资捡漏奖励
                                    SummonInvest investReward = new SummonInvest();
                                    investReward.setMailIndex(summonPackage.getIndex());
                                    investReward.setTerrainId(summonPackage.getTerrainId());
                                    investReward.setRewardTime(DateUtil.plusNow(TimeUnit.SECONDS, exploreConfig.getInvestTime()));
                                    investReward.setPositionX(summonPackage.getPositionX());
                                    investReward.setPositionY(summonPackage.getPositionY());
                                    investReward.setFriendRoleIDList(Lists.newArrayListWithCapacity(3));
                                    summonData.getInvestReward().add(investReward);
                                    builder.setInvestCountDown(exploreConfig.getInvestTime());
                                    builder.setInvestReward(investReward.toSummonInvestReward(roleID));
                                }
                                break;
                            }
                        }
                        boolean mailsAllReward = true;
                        boolean mailsAllProcessed = true;
                        for(SummonPackage summonPackage : summonData.getPackages()) {
                            if (!summonPackage.isReward()) {
                                mailsAllReward = false;
                            }
                            if(!summonPackage.isProcessed()){
                                if(summonPackage.getRewardType() == ConstantGame.SUMMON_INVEST_EVENT) {
                                    // 可以投资了
                                    summonData.setCanInvest(true);
                                }
                                mailsAllProcessed = false;
                            }
                        }
                        if(mailsAllProcessed) {
                            summonData.setSendTime(0);
                            summonData.setDefUsed(false);
                            summonData.setTourEnd(true);
                            builder.setCountDown(0);
                        }else{
                            if(summonData.getRevPackageCount() < summonData.getAllPackageCount()) {
                                long countDown = (long)(summonData.getAllPackageCount() - summonData.getRevPackageCount()) * ConfigSundryConf.summonPackageTime * DateUtil.ONEMINUTE_2_SECOND;
                                builder.setCountDown((int)countDown);
                            }else {
                                builder.setCountDown(0);
                            }
                        }
                        if(mailsAllReward) {
                            model.removeSummon(summonData.getSummonID());
                        }else{
                            model.setSummon(summonData);
                        }
                    }
                }
            }
        }
    }

	@Override
	public void summonPickupInvestReward(long roleID, SummonPickupInvestRewardReq req, SummonPickupInvestRewardRsp.Builder builder) {
        long friendID = roleID;
        if(req.getRoleId() > 0){
            friendID = req.getRoleId();
        }
        // 投资产出
        ConfigSummonsExploreConf exploreConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_SUMMONSEXPLORE);
        if(exploreConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigCollectionEventConf collectionEventConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_COLLECTION_EVENT);
        if(collectionEventConf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
		SummonModel model = getWriteModel(friendID, SummonModel.class);
        if(model == null) return;
        SummonData investSummonData = null;
        SummonInvest investData = null;
        Map<Integer, SummonData> summonDataMap = model.getSummonMap();
        if(ObjectUtils.isNotEmpty(summonDataMap) && (summonDataMap.size() > 0)) {
            for (SummonData summonData : summonDataMap.values()) {
                if((summonData.getInvestReward() != null)&&(summonData.getInvestReward().size() > 0)){
                    for(SummonInvest summonInvest : summonData.getInvestReward()) {
                    if((summonInvest.getMailIndex() == req.getIndex())
                            &&(!summonInvest.getFriendRoleIDList().contains(roleID))) {
                        investSummonData = summonData;
                        investData = summonInvest;
                    }
                    }
                }
            }
        }
		if(investData == null) {
            return;
		}
		if(!investData.getFriendRoleIDList().contains(roleID)) {
		//	throw new CommonException(ErrorID.SUMMON_PICKUP_ED_INVEST_REWARD);
		//}else {
            investData.getFriendRoleIDList().add(roleID);
        }
        Map<Integer, Integer> matrialWeightedMap = exploreConf.getMatrialWeighted(investData.getTerrainId());
        if(matrialWeightedMap == null || matrialWeightedMap.size() == 0){
            log.info("summonPickupInvestReward matrialWeightedMap == null roleID = {} terrainId = {}", roleID, investData.getTerrainId());
            return;
        }
        int outputType = RandomUtil.weightedRandom(matrialWeightedMap);
        int senceId = 200 + investSummonData.getLevel()*10 + investSummonData.getElement();
        log.info("roleID {}, senceId:{}", roleID, senceId);
        Map<Integer, Integer> weightedMap = collectionEventConf.getWeighted(senceId, outputType);
        if(weightedMap == null || weightedMap.size() == 0){
            log.info("summonPickupInvestReward weightedMap == null senceId = {} outputType = {}", senceId, outputType);
            return;
        }
        //for (int i = 0; i < rewardCount; i++) {
            int outputId = RandomUtil.weightedRandom(weightedMap);
            //log.info("roleID {}, rewardCount {}, terrainId {}, outputType {}, outputId {}", roleID, rewardCount, investData.getTerrainId(), outputType, outputId);
            ServiceProvider.getItemService().addItemBill(roleID, outputId, 1, ResourceBillEnum.summonPickupInvestReward, true, false);
            EventProvider.postSyncItemEvent(roleID);
            builder.putReward(outputId, 1);
        //}
		// 自己捡漏 ，要修改当前邮件状态
		if(roleID == friendID) {
            for (SummonData summonData : summonDataMap.values()) {
                for (SummonPackage summonPackage : summonData.getPackages()) {
                    if (summonPackage.getIndex() == investData.getMailIndex()) {
                        summonPackage.setReward(true);
                        builder.setIndex(investData.getMailIndex());
                        model.setSummon(summonData);
                    }
                }
                boolean mailsAllReward = true;
                for(SummonPackage summonPackage : summonData.getPackages()) {
                    if (!summonPackage.isProcessed()) {
                        if (summonPackage.getRewardType() == ConstantGame.SUMMON_INVEST_EVENT) {
                            // 可以投资了
                            summonData.setCanInvest(true);
                        }
                    }
                    if (!summonPackage.isReward()) {
                        mailsAllReward = false;
                    }
                }
                if(mailsAllReward) {
                    model.removeSummon(summonData.getSummonID());
                    break;
                }
            }
		}
		EventProvider.postSyncAttrEvent(roleID);
        //zcq 精灵投资任务
        EventProvider.postTaskActionEvent(roleID, TaskActionEnum.SUMMON_INVEST, 1);
        EventProvider.commitRoleEvent(roleID);
	}

    @Override
    public void summonFastMail(long roleID, SummonFastMailReq req, SummonFastMailRsp.Builder builder) {
        Map<Integer, SummonData> summonMap = getSummonMap(roleID);
        if(summonMap != null) {
            for (Integer summonId : summonMap.keySet()) {
                SummonData summonData = summonMap.get(summonId);
                if(summonData.isTourEnd()){
                    continue;
                }
                // 精灵旅行途中获得邮件
                SummonMailInfo.Builder mailBuilder = SummonMailInfo.newBuilder();
                for (SummonPackage summonPackage : summonData.getPackages()) {
                    if (summonPackage.isNtfFlag()) {
                        continue;
                    }
                    long nowTime = System.currentTimeMillis();
                    //long mailTime = summonPackage.getTime();
                    //if ((mailTime >= summonData.getLastMailTime()) && (mailTime > nowTime)) {
                        summonData.setLastMailTime(nowTime);
                        summonPackage.setNtfFlag(true);
                        if(summonPackage.getRewardType() == ConstantGame.SUMMON_INVEST_EVENT) { // 可以投资了
                            summonData.setCanInvest(true);
                        }
                        summonData.setRevPackageCount(summonData.getRevPackageCount()+1);
                        // 推送邮件给前端
                        builder.addMailList(MessageHelper.toSummonMailInfo(mailBuilder, summonPackage));
                        log.info("roleID {} 获得邮件 mail {}", roleID, GsonUtil.toJson(summonPackage));
                        setSummon(roleID, summonData);
                    //}
                }
                boolean mailsAllProcessed = true;
                for (SummonPackage summonPackage : summonData.getPackages()) {
                    if (!summonPackage.isProcessed()) {
                        if(summonPackage.getRewardType() == ConstantGame.SUMMON_INVEST_EVENT) {
                            // 可以投资了
                            summonData.setCanInvest(true);
                        }
                        mailsAllProcessed = false;
                    }
                }
                // 旅行结束
                if((mailsAllProcessed) && (summonData.getRevPackageCount() >= summonData.getAllPackageCount())) {
                    tourEnd(roleID, summonId);
                }
            }
        }
    }

    @Override
    public void summonAllMailReward(long roleID, SummonAllMailRewardReq req, SummonAllMailRewardRsp.Builder builder, IArgumentRunnable<SummonPackage> mailRun) {
        SummonModel model = getWriteModel(roleID, SummonModel.class);
        if(model != null) {
            Map<Integer, SummonData> summonDataMap = model.getSummonMap();
            if(ObjectUtils.isNotEmpty(summonDataMap) && (summonDataMap.size() > 0)) {
                for (SummonData summonData : summonDataMap.values()) {
                    if (summonData.getPackages().size() > 0) {
                        for (SummonPackage summonPackage : summonData.getPackages()) {
                            if((!summonPackage.isReward())&&(summonPackage.getRewardType() != ConstantGame.SUMMON_INVEST_EVENT)) {
                                model.mailReward(summonPackage.getIndex(), summonData.getSummonID(), mailRun);
                            }
                        }
                        boolean mailsAllProcessed = true;
                        for (SummonPackage summonPackage : summonData.getPackages()) {
                            if (!summonPackage.isProcessed()) {
                                mailsAllProcessed = false;
                                break;
                            }
                        }
                        if ((mailsAllProcessed) && (summonData.getRevPackageCount() >= summonData.getAllPackageCount())) {
                            // 旅行结束
                            tourEnd(roleID, summonData.getSummonID());
                        }
                        boolean mailsAllRewarded = true;
                        for (SummonPackage summonPackage : summonData.getPackages()) {
                            if (!summonPackage.isReward()) {
                                mailsAllRewarded = false;
                                break;
                            }
                        }
                        if (mailsAllRewarded) {
                            model.removeSummon(summonData.getSummonID());
                            return;
                        }
                    }
                }
            }
        }
    }

}
