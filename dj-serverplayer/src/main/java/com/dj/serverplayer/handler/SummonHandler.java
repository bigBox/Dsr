package com.dj.serverplayer.handler;

import com.dj.domain.config.ConfigSummonPackageCount;
import com.dj.domain.config.ConfigSummons;
import com.dj.domain.config.ConfigTasks;
import com.dj.domain.data.summon.SummonData;
import com.dj.domain.data.summon.SummonInvest;
import com.dj.domain.data.summon.SummonPackage;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.math.RandomUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.summon.*;
import com.dj.serverapi.helper.MessageHelper;
import com.dj.servercore.conf.ConfigSummonPackageCountConf;
import com.dj.servercore.conf.ConfigSummonsConf;
import com.dj.servercore.conf.ConfigSummonsRateConf;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.helper.QueueHelper;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.EventManager;
import com.dj.serverplayer.manager.ServiceManager;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author zcq
 * @description 精灵业务处理
 * @date 2019年10月28日
 */
@Component
@Slf4j
public class SummonHandler extends BaseHandler {

    /**
     *	召唤精灵
     */
    public void summonReq(long roleID, SummonReq req, SummonRsp.Builder builder) {
        int curLevel = req.getLevel();
        PlayerRole playerRole = ServiceManager.getPlayerService().getPlayer(roleID);
        if(playerRole == null){
            return;
        }
//        int curLevel = playerRole.getSummonLevel();
//        if(curLevel < 1){
//            curLevel = 1;
//        }
        SummonData summonData = summonService.getSummon(roleID);
        if (summonData != null) {
            throw new CommonException(ErrorID.SUMMON_SENDING);
        }
        ConfigSummonsConf summonsConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_SUMMONS);
        if(summonsConf == null){
            log.error("summonReq ConfigSummonsConf summonsConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        Map<Integer, Integer> configSummonWeights = summonsConf.getWeighted(curLevel);
        if(configSummonWeights == null || configSummonWeights.size() == 0){
            log.info("summonReq weightedMap == null roleID = {} curLevel = {}", roleID, curLevel);
            return;
        }
        int summonID = RandomUtil.weightedRandom(configSummonWeights);
        ConfigSummons configSummon = summonsConf.getSummon(summonID);
        if(configSummon != null) {
            checkGoldEnough(roleID, configSummon.getMoney());
            checkItemEnough(roleID, configSummon.getMatrial1(), configSummon.getNum1());
            checkItemEnough(roleID, configSummon.getMatrial2(), configSummon.getNum2());
            checkItemEnough(roleID, configSummon.getMatrial3(), configSummon.getNum3());
            checkItemEnough(roleID, configSummon.getMatrial4(), configSummon.getNum4());
            checkItemEnough(roleID, configSummon.getMatrial5(), configSummon.getNum5());
            // 扣除消耗材料
            costGold(roleID, configSummon.getMoney(), ResourceBillEnum.summonCost);
            costItem(roleID, configSummon.getMatrial1(), configSummon.getNum1(), ResourceBillEnum.summonCost);
            costItem(roleID, configSummon.getMatrial2(), configSummon.getNum2(), ResourceBillEnum.summonCost);
            costItem(roleID, configSummon.getMatrial3(), configSummon.getNum3(), ResourceBillEnum.summonCost);
            costItem(roleID, configSummon.getMatrial4(), configSummon.getNum4(), ResourceBillEnum.summonCost);
            costItem(roleID, configSummon.getMatrial5(), configSummon.getNum5(), ResourceBillEnum.summonCost);
            // 添加声望
            //addRenown(roleID, configSummon.getRenown(), ResourceBillEnum.summonReward);
            ConfigSummonsRateConf summonsRateConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_SUMMONS_RATE);
            if(summonsRateConf == null){
                log.error("summonReq ConfigSummonsRateConf summonsRateConf == null roleID:{}", roleID);
                throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
            boolean isSuccess = false;
            int rate = summonsRateConf.getRate(curLevel);
            if (RandomUtil.shakeIn100(rate)) {
                isSuccess = true;
            }
            if(isSuccess) {
                summonData = summonService.callSummon(roleID, configSummon);
                if (summonData != null) {
                    builder.setSummonID(summonData.getSummonID());
                    builder.setElement(summonData.getElement());
                    builder.setLevel(summonData.getLevel());
                    builder.setSendTime(DateTime.newBuilder().setValue(0));
                    builder.setCountDown(-1);
                    builder.setCurLevel(summonData.getLevel());
                    playerRole.setSummonLevel(summonData.getLevel());
                    playerRoleDao.cacheUpdate(playerRole);
                    ServiceManager.getPlayerService().setPlayer(roleID, playerRole);
                    // 精灵寻宝任务
                    EventManager.postTaskActionEvent(roleID, TaskActionEnum.SUMMON_TREASURE, 1);
                    EventManager.commitRoleEvent(roleID);
                    return;
                }
            }
        }
        builder.setSummonID(0);
        builder.setCurLevel(0);
        playerRole.setSummonLevel(0);
        playerRoleDao.cacheUpdate(playerRole);
        ServiceManager.getPlayerService().setPlayer(roleID, playerRole);
    }

    /**
     *	保留精灵
     */
    public void summonRetainReq(long roleID, SummonRetainReq req, SummonRetainRsp.Builder builder) {
        Map<Integer, SummonData> summonMap = ServiceManager.getSummonService().getSummonMap(roleID);
        if((summonMap != null)&&(summonMap.size() > 0)) {
            if(req.getIsRetain()){
                for (Integer summonId : summonMap.keySet()) {
                    if(req.getSummonID() == summonId){
                        SummonData summonData = summonMap.get(summonId);
                        summonData.setDefUsed(true);
                        ServiceManager.getSummonService().setSummon(roleID, summonData);
                    }else {
                        ServiceManager.getSummonService().removeSummon(roleID, summonId);
                    }
                }
            } else {
                for (Integer summonId : summonMap.keySet()) {
                    if(req.getSummonID() == summonId){
                        ServiceManager.getSummonService().removeSummon(roleID, summonId);
                    }
                }
            }
        }
    }

    /**
     *	获取精灵信息
     */
    public void summonInfoReq(long roleID, long friendID, SummonInfoRsp.Builder builder) {
        if((friendID > 0)&&(friendID != roleID)){
            roleID = friendID;
        }
        PlayerRole playerRole = ServiceManager.getPlayerService().getPlayer(roleID);
        if(playerRole == null){
            return;
        }
        builder.setCurLevel(playerRole.getSummonLevel());
        // 获取精灵信息并且重置邮件
        Map<Integer, SummonData> summonMap = ServiceManager.getSummonService().getSummonMap(roleID);
        if((summonMap != null)&&(summonMap.size() > 0)) {
            for (Integer summonId : summonMap.keySet()) {
                SummonData summonData = summonMap.get(summonId);
                SummonInfo.Builder summonInfo = SummonInfo.newBuilder();
                summonInfo.setSummonID(summonData.getSummonID());
                summonInfo.setElement(summonData.getElement());
                summonInfo.setLevel(summonData.getLevel());
                if(summonData.isTourEnd()){
                    // 旅行结束
                    summonInfo.setSendTime(DateTime.newBuilder().setValue(0));
                    summonInfo.setCountDown(0);
                }else{
                    if(summonData.getSendTime() > 0) {
                        summonInfo.setSendTime(DateTime.newBuilder().setValue(summonData.getSendTime()));
                        builder.setCurSummonID(summonInfo.getSummonID());
                        builder.setCurElement(summonInfo.getElement());
                    }else {
                        summonInfo.setCountDown(-1);
                    }
                    if(summonData.getRevPackageCount() < summonData.getAllPackageCount()) {
                        long countDown = (long) (summonData.getAllPackageCount() - summonData.getRevPackageCount()) * ConfigSundryConf.summonPackageTime * DateUtil.ONEMINUTE_2_SECOND;
                        summonInfo.setCountDown((int) countDown);
                    }else{
                        summonInfo.setCountDown(0);
                    }
                    if(summonData.isDefUsed()){
                        builder.setDefSummonID(summonData.getSummonID());
                    }
                }
                if ((summonData.getInvestReward() != null)&&(summonData.getInvestReward().size() > 0)) {
                    for(SummonInvest summonInvest : summonData.getInvestReward()) {
                        summonInfo.addInvestReward(summonInvest.toSummonInvestReward(roleID));
                    }
                }
                if (summonData.getPackages().size() > 0) {
                    List<SummonMailInfo> mails = Lists.newArrayListWithExpectedSize(summonData.getPackages().size());
                    int mailCount = 0;
                    SummonMailInfo.Builder mailBuilder = SummonMailInfo.newBuilder();
                    Collections.sort(summonData.getPackages());
                    for (SummonPackage summonPackage : summonData.getPackages()) {
                        if ((summonPackage.isNtfFlag()) && (!summonPackage.isReward())) { // 邮件已发放 并且邮件奖励未领取
                            mails.add(MessageHelper.toSummonMailInfo(mailBuilder, summonPackage));
                            mailCount++;
                        }
                    }
                    summonInfo.addAllMails(mails);
                    summonInfo.setMailCount(mailCount);
                }
                builder.addSummons(summonInfo);
            }
        }
    }

    /**
     *	派出精灵
     */
    public void summonSend(long roleID, int summonId, SummonSendRsp.Builder builder) {
    	int packageID = 0;
        ConfigSummonPackageCountConf configSummonPackageCountConf = ConfManager.getInstance().getConfigSummonPackageCountConf();
        Map<Integer, Integer> allWeightedMap = configSummonPackageCountConf.getWeighted();
        if(allWeightedMap == null || allWeightedMap.size() == 0){
            log.info("summonSend allWeightedMap == null roleID = {} summonId = {}", roleID, summonId);
            return;
        }
        Integer packageCountId = RandomUtil.weightedRandom(allWeightedMap);
        ConfigSummonPackageCount summonPackageCount = configSummonPackageCountConf.getSummonPackageCount(packageCountId);
        int packageCount = summonPackageCount.getCount();
    	//if(buffService.getNpcSkill(roleID).getSkillID() == 8) {
    		//精灵的信息量加一倍（精灵的事件发生时间减半）
            //packageCount = packageCount*2;
    		//buffService.setNpcSkill(roleID, 0, 0);
    	//}
    	// 精灵寻宝任务
    	//ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.SUMMON_INVEST);
    	//if(configTasks != null) {
        //    if(configTasks.getExtraParam() != 0) {
        //        packageID = configTasks.getExtraParam();
        //    }
    	//}
        ServiceManager.getSummonService().summonSend(roleID, summonId, builder, packageID, packageCount);
        QueueHelper.getInstance().addTravelQueue(roleID);
    }

    /**
     *	领取精灵邮件奖励
     *
     * @param roleID
     * @param req
     */
    public void summonMailReward(long roleID, SummonMailRewardReq req, SummonMailRewardRsp.Builder builder) {
        ServiceManager.getSummonService().summonMailReward(roleID, req.getIndex(), builder, mail -> {
            addGold(roleID, mail.getRewardGold(), ResourceBillEnum.summonMailReward);
            if (mail.getRewardItem() != null && mail.getRewardItem().size() > 0) {
                for (Map.Entry<Integer, Integer> entry : mail.getRewardItem().entrySet()) {
                    addItem(roleID, entry.getKey(), entry.getValue(), ResourceBillEnum.summonMailReward, false);
                }
            }
        });
    }
    /**
     *	领取精灵邮件奖励
     *
     * @param roleID
     * @param req
     */
    public void summonAllMailReward(long roleID, SummonAllMailRewardReq req, SummonAllMailRewardRsp.Builder builder) {
        ServiceManager.getSummonService().summonAllMailReward(roleID, req, builder, mail -> {
            addGold(roleID, mail.getRewardGold(), ResourceBillEnum.summonMailReward);
            if (mail.getRewardItem() != null && mail.getRewardItem().size() > 0) {
                for (Map.Entry<Integer, Integer> entry : mail.getRewardItem().entrySet()) {
                    addItem(roleID, entry.getKey(), entry.getValue(), ResourceBillEnum.summonMailReward, false);
                }
            }
        });
    }
    /**
     *	刷新精灵邮件
     *
     * @param roleID
     * @param req
     * @param builder
     */
    public void summonMailRefresh(long roleID, SummonMailRefreshReq req, SummonMailRefreshRsp.Builder builder) {
        SummonPackage mail = ServiceManager.getSummonService().summonMailRefresh(roleID, req.getIndex());
        if (mail == null) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
        SummonMailInfo.Builder mailBuilder = SummonMailInfo.newBuilder();
        builder.setMail(MessageHelper.toSummonMailInfo(mailBuilder, mail));
    }

    /**
     *	首次打开精灵邮件
     *
     * @param roleID
     * @param req
     */
    public void summonMailFirst(long roleID, SummonMailFirstReq req) {
        ServiceManager.getSummonService().summonMailFirst(roleID, req.getIndex());
    }

    /**
     *	投资精灵
     *
     * @param roleID
     * @param req
     * @param builder
     */
    public void summonInvest(long roleID, SummonInvestReq req, SummonInvestRsp.Builder builder) {
        ServiceManager.getSummonService().summonInvest(roleID, req, builder, config->{
        	costGold(roleID, config.getInvestGold(), ResourceBillEnum.summonInvest);
        });
    }
    
    /**
     *	请求精灵新邮件
     *
     * @param roleID
     * @param builder
     */
    public void summonNewMail(long roleID, SummonNewMailRsp.Builder builder) {
        // 精灵旅行途中获得新邮件
        SummonMailInfo.Builder mailBuilder = SummonMailInfo.newBuilder();
    	SummonData summonData = ServiceManager.getSummonService().getSummon(roleID);
		if ((summonData != null) && (summonData.getPackages().size() > 0)) {
            for (SummonPackage summonPackage : summonData.getPackages()) {
                if (summonPackage.isNtfFlag()) {
                    continue;
                }
                long mailTime = summonPackage.getTime();
                if ((mailTime >= summonData.getLastMailTime() )&& (mailTime - 1000 <= System.currentTimeMillis())) {
                    summonData.setLastMailTime(mailTime);
                    summonPackage.setNtfFlag(true);
                    // 推送邮件给前端
                    builder.setMail(MessageHelper.toSummonMailInfo(mailBuilder, summonPackage));
                    ServiceManager.getSummonService().setSummon(roleID, summonData);
                    break;
                }
            }
		}
    }

    /**
     * 精灵投资奖励
     * @param roleID
     * @param builder
     */
    public void summonPickupInvestReward(long roleID, SummonPickupInvestRewardReq req, SummonPickupInvestRewardRsp.Builder builder) {
        summonService.summonPickupInvestReward(roleID, req, builder);
    }

    /**
     * 精灵一件回家
     * @param roleID
     * @param builder
     */
    public void summonFastMail(long roleID, SummonFastMailReq req, SummonFastMailRsp.Builder builder) {
        // 精灵寻宝任务
        ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.SUMMON_INVEST);
        if(configTasks == null) {
            if(req.getCostItemID() == 1) {
                checkGoldEnough(roleID, req.getCostItemCount());
                costGold(roleID, req.getCostItemCount(), ResourceBillEnum.summonCost);
            }
            else if(req.getCostItemID() == 2) {
                checkDiamondEnough(roleID, req.getCostItemCount());
                costDiamond(roleID, req.getCostItemCount(), ResourceBillEnum.summonCost);
            }else {
                checkItemEnough(roleID, req.getCostItemID(), req.getCostItemCount());
                // 扣除消耗材料
                costItem(roleID, req.getCostItemID(), req.getCostItemCount(), ResourceBillEnum.summonCost);
            }
        }
        summonService.summonFastMail(roleID, req, builder);
        // 推送邮件给前端
        //if(builder.getMailList() != null) {
        //    SummonMailNtf.Builder mailNtfBuilder = SummonMailNtf.newBuilder();
        //    mailNtfBuilder.setMail(builder.getMail());
        //    int gateID = OnlineHelper.getInstance().getOnlineGateID(roleID);
        //    ChannelManager.getInstance().sendPlayerBasicToGate(gateID, roleID, builder.build());
        //}
    }

}
