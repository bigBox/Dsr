package com.dj.serverplayer.handler;

import com.dj.domain.config.ConfigGuideTask;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.guide.GuideInfoRsp;
import com.dj.protobuf.guide.UpdateGuideProcessReq;
import com.dj.serverapi.dao.PlayerRoleDao;
import com.dj.servercore.conf.ConfigGuideTaskConf;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.ServiceManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description 新手引导业务处理
 * @author zcq
 * @date 2019年4月18日 
 * 
 * GotoGuide FinishGuide
 */
@Component
@Slf4j
public class GuideHandler extends BaseHandler {
	/**
	 *	更新新手引导进度
	 * 
	 * @param roleID
	 * @param req
	 */
	public void updateGuideProcess(long roleID, UpdateGuideProcessReq req) {
		PlayerRoleDao playerRoleDao = SpringContext.getBean(PlayerRoleDao.class);
		if(req.getGuideId() > 0) {
			PlayerRole playerRole = playerService.updateGuideId(roleID, req.getGuideId());
			playerRoleDao.cacheUpdate(playerRole);
		}
		if(req.getState() > 0) {
			PlayerRole playerRole = playerService.updateGuideState(roleID, req.getState());
			playerRoleDao.cacheUpdate(playerRole);
		}
	}

	/**
	 *	获取玩家新手引导信息
	 * 
	 * @param roleID
	 * @param builder
	 */
	public void guideInfo(long roleID, GuideInfoRsp.Builder builder) {
//		List<PlayerGuide> guides = playerGuideDao.cacheLoadAll(roleID);
//		if (guides != null && guides.size() > 0) {
//			GuideInfo.Builder guideBuilder = GuideInfo.newBuilder();
//			guides.forEach(value->{
//				builder.putCommon(value.getKey(), value.toGuideInfo(guideBuilder));
//				if (value.getBuildingK() > 0) {
//					builder.putBuilding(value.getBuildingK(), value.getBuildingV());
//				}
//			});
//		}
	}

	/**
	 *	获取新手引导奖励
	 * 
	 * @param roleID
	 * @param groupId
	 */
	public void getGuideReward(long roleID, int groupId) {
		ConfigGuideTaskConf conf = ConfManager.getInstance().getConfigGuideTaskConf();
		if(conf == null){
			log.error("getGuideReward ConfigGuideTaskConf conf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigGuideTask configGuideTask = conf.getGuideTask(groupId);
//		List<Integer> needsList = ListUtil.commaStringToList(configGuideTask.getNeeds_3(), ";");
//		for (int itemID : needsList) {
//			checkItemEnough(roleID, itemID, 1);
//		}
		if (ServiceManager.getTaskService().getGuideRewardCheckFinish(roleID, configGuideTask)) {
			addExp(roleID, configGuideTask.getReward(), ResourceBillEnum.getGuideReward);
			addGold(roleID, configGuideTask.getRewardGold(), ResourceBillEnum.getGuideReward);
			return;
		}
		throw new CommonException(ErrorID.REWARD_RECEIVED, "roleID:" + roleID + ", guideID:" + configGuideTask.getID());
	}
}
