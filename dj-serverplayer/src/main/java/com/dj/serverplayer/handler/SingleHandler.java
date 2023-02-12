package com.dj.serverplayer.handler;

import java.util.List;
import java.util.Map;

import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.config.ConfigEventList;
import com.dj.domain.config.ConfigOutsides;
import com.dj.domain.config.ConfigOutsidesFunc;
import com.dj.protobuf.outside.OutSideProduct;
import com.dj.protobuf.outside.OutSideProductInfo;
import com.dj.protobuf.outside.OutsideBatchReq;
import com.dj.protobuf.outside.OutsideBatchRsp;
import com.dj.protobuf.outside.OutsideGuideReq;
import com.dj.protobuf.outside.OutsideGuideRsp;
import com.dj.protobuf.outside.OutsideReq;
import com.dj.protobuf.outside.OutsideRsp;
import com.dj.servercore.conf.ConfigEventListConf;
import com.dj.servercore.conf.ConfigOutsidesConf;
import com.dj.servercore.conf.ConfigOutsidesFuncConf;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.math.RandomUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author zcq
 * @description 单机业务处理
 * @date 2019年4月19日
 */
@Component
@Slf4j
public class SingleHandler extends BaseHandler {

    /**
     *	采集
     *
     * @param roleID
     * @param req
     * @param builder
     */
    public void outside(long roleID, OutsideReq req, OutsideRsp.Builder builder) {
        ConfigOutsidesFuncConf funcConf = ConfManager.getInstance().getConfigOutsidesFuncConf();
        if(funcConf == null){
            log.error("outside ConfigOutsidesFuncConf funcConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigOutsidesFunc func = funcConf.getFunc(req.getEventId());
//        costItem(roleID, func.getCostId_4(), req.getCount() * func.getCost_3(), ResourceBillEnum.outsideCost);
        costStamina(roleID, req.getCount()*func.getCost(), ResourceBillEnum.outsideCost);
        
        // 单次采集
        ConfigOutsidesConf conf = ConfManager.getInstance().getConfigOutsidesConf();
        if(conf == null){
            log.error("outside ConfigOutsidesConf conf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigEventListConf eventConf = ConfManager.getInstance().getConfigEventListConf();
        if(eventConf == null){
            log.error("outside ConfigEventListConf eventConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        List<OutSideProductInfo> infos = Lists.newArrayListWithExpectedSize(req.getCount());
        Map<Integer, Integer> weightedMap = funcConf.getWeighted(req.getEventId());
        if(weightedMap == null || weightedMap.size() == 0){
            log.error("outside weightedMap == null");
        }
        OutSideProductInfo.Builder outSideProductInfo = OutSideProductInfo.newBuilder();
        OutSideProduct.Builder outSideProduct = OutSideProduct.newBuilder();
        for (int i = 0; i < req.getCount(); i++) {
            int eventType = RandomUtil.weightedRandom(weightedMap);
            outSideProductInfo.setProductType(eventType);
            outSideProductInfo.clear();
            ConfigOutsides configOutsides = RandomUtil.weightedRandom(conf.getWeightedMap(eventType));
            if (eventType == 1) {
                // 无发现
            } else if (3 == eventType || 4 == eventType) {
                // 3、故事；4奇遇；
            	ConfigEventList configEventList = RandomUtil.weightedRandom(eventConf.getWeightedMap(eventType));
                outSideProduct.setProductId(configEventList.getID());
                outSideProduct.setCount(1);
                outSideProductInfo.addProducts(outSideProduct.build());
            } else {
            	outSideProduct.setProductId(configOutsides.getItemGet());
                outSideProduct.setCount(1);
                outSideProductInfo.addProducts(outSideProduct.build());
                if (configOutsides.getItemGet() == 1) {
                	// 金币
                    addGold(roleID, 1, ResourceBillEnum.outsideReward);
                } else {
	            	addItem(roleID, configOutsides.getItemGet(), 1, ResourceBillEnum.outsideReward, false);
	            }
            }
            infos.add(outSideProductInfo.build());
            addExp(roleID, configOutsides.getExp(), ResourceBillEnum.outsideReward);
        }
        builder.addAllProducts(infos);
    }

    /**
     *	新手引导采集
     *
     * @param roleID
     * @param req
     * @param builder
     */
    public void outsideGuide(long roleID, OutsideGuideReq req, OutsideGuideRsp.Builder builder) {
        ConfigOutsidesFuncConf funcConf = ConfManager.getInstance().getConfigOutsidesFuncConf();
        if(funcConf == null){
            log.error("outside ConfigOutsidesFuncConf funcConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigOutsidesFunc func = funcConf.getFunc(req.getEventId());
        costItem(roleID, func.getCostId(), req.getCount() * func.getCost(), ResourceBillEnum.outsideGuideCost);
        int eventType = 8;
        int selectedId = 520020001;
        if (2 == req.getEventId()) {
            eventType = 9;
            selectedId = 550020001;
        }
        List<OutSideProductInfo> infos = Lists.newArrayListWithExpectedSize(req.getCount());
        for (int i = 0; i < req.getCount(); i++) {
            addItem(roleID, selectedId, 1, ResourceBillEnum.outsideGuideReward, true);
            List<OutSideProduct> products = Lists.newArrayListWithExpectedSize(1);
            OutSideProduct.Builder outSideProduct = OutSideProduct.newBuilder();
            outSideProduct.setProductId(selectedId);
            outSideProduct.setCount(1);
            products.add(outSideProduct.build());
            OutSideProductInfo.Builder outSideProductInfo = OutSideProductInfo.newBuilder();
            outSideProductInfo.addAllProducts(products);
            outSideProductInfo.setProductType(eventType);
            infos.add(outSideProductInfo.build());
        }
        builder.addAllProducts(infos);
    }

    /**
     *	批量采集
     *
     * @param roleID
     * @param req
     * @param builder
     */
    public void outsideBatch(long roleID, OutsideBatchReq req, OutsideBatchRsp.Builder builder) {
        ConfigOutsidesFuncConf funcConf = ConfManager.getInstance().getConfigOutsidesFuncConf();
        if(funcConf == null){
            log.error("outsideBatch ConfigOutsidesFuncConf funcConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigOutsidesFunc func1 = funcConf.getFunc(1);
        ConfigOutsidesFunc func2 = funcConf.getFunc(2);
        ConfigOutsidesFunc func3 = funcConf.getFunc(3);
        
        costStamina(roleID, req.getCount1()*func1.getCost()+req.getCount2()*func2.getCost()+req.getCount3()*func3.getCost(), ResourceBillEnum.outsideBatchCost);
        
        // 检查道具是否足够
//        checkItemEnough(roleID, func1.getCostId_4(), req.getCount1() * func1.getCost_3());
//        checkItemEnough(roleID, func2.getCostId_4(), req.getCount2() * func1.getCost_3());
//        checkItemEnough(roleID, func3.getCostId_4(), req.getCount3() * func1.getCost_3());
        // 奖励
        Map<Integer, Integer> reward = Maps.newHashMap();
        // 植物
        if (req.getCount1() > 0) {
//            costItem(roleID, func1.getCostId_4(), req.getCount1() * func1.getCost_3(), ResourceBillEnum.outsideBatchCost);
            doOutsideBatch(roleID, 1, req.getCount1(), reward);
        }
        // 动物
        if (req.getCount2() > 0) {
//            costItem(roleID, func2.getCostId_4(), req.getCount2() * func2.getCost_3(), ResourceBillEnum.outsideBatchCost);
            doOutsideBatch(roleID, 2, req.getCount2(), reward);
        }
        // 水
        if (req.getCount3() > 0) {
//            costItem(roleID, func3.getCostId_4(), req.getCount3() * func3.getCost_3(), ResourceBillEnum.outsideBatchCost);
            doOutsideBatch(roleID, 3, req.getCount3(), reward);
        }
        builder.putAllRewardMap(reward);
    }

    /**
     *	批量采集
     *
     * @param roleID
     * @param eventID
     * @param count
     * @return
     */
    private void doOutsideBatch(long roleID, int eventID, int count, Map<Integer, Integer> reward) {
        ConfigOutsidesConf conf = ConfManager.getInstance().getConfigOutsidesConf();
        if(conf == null){
            log.error("doOutsideBatch ConfigOutsidesConf conf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigEventListConf eventConf = ConfManager.getInstance().getConfigEventListConf();
        if(eventConf == null){
            log.error("doOutsideBatch ConfigEventListConf eventConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        ConfigOutsidesFuncConf funcConf = ConfManager.getInstance().getConfigOutsidesFuncConf();
        if(funcConf == null){
            log.error("doOutsideBatch ConfigOutsidesFuncConf funcConf == null roleID:{}", roleID);
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        Map<Integer, Integer> weightedMap = funcConf.getWeighted(eventID);
        if(weightedMap == null || weightedMap.size() == 0){
            log.error("doOutsideBatch weightedMap == null");
        }
        for (int i = 0; i < count; i++) {
            int eventType = RandomUtil.weightedRandom(weightedMap);
            ConfigOutsides configOutsides = RandomUtil.weightedRandom(conf.getWeightedMap(eventType));
            if (eventType == 1) {
                // 无发现
            } else if (3 == eventType || 4 == eventType) {
                 // 3故事；4奇遇；
            	 ConfigEventList configEventList = RandomUtil.weightedRandom(eventConf.getWeightedMap(eventType));
                 MapUtil.fundInt(reward, configEventList.getID(), 1);
            } else {
            	if (configOutsides.getItemGet() == 1) {
            		// 金币
                    addGold(roleID, 1, ResourceBillEnum.outsideBatchReward);
                } else {
                    addItem(roleID, configOutsides.getItemGet(), 1, ResourceBillEnum.outsideBatchReward, false);
                    MapUtil.fundInt(reward, configOutsides.getItemGet(), 1);
                }
            }
            addExp(roleID, configOutsides.getExp(), ResourceBillEnum.outsideBatchReward);
        }
    }
}
