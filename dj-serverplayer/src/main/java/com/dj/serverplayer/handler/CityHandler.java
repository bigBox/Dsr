package com.dj.serverplayer.handler;

import com.alibaba.fastjson.JSONObject;
import com.dj.domain.config.*;
import com.dj.domain.data.CityRole;
import com.dj.domain.entity.player.item.PlayerItem5;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.util.lib.DataPair;
import com.dj.domain.util.math.RandomUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.city.*;
import com.dj.servercore.conf.*;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.EventManager;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: CityHandler  
 * @Description: city业务处理
 * @author zcq 
 * @date 2020年10月21日
 */
@Slf4j
@Component
public class CityHandler extends BaseHandler {

	private Map<Long, CityRole> cityRoleMap = Maps.newHashMap();
	
	private void addCityRoleNpc(long roleID, int npcID) {
		CityRole cityRole = cityRoleMap.get(roleID);
		if(cityRole == null) {
			cityRole = new CityRole(roleID, npcID, 0, 0, 0);
			cityRoleMap.put(roleID, cityRole);
		}else {
			cityRole.setNpcID(npcID);
		}
	}
	
	private int getCityRoleNpc(long roleID) {
		CityRole cityRole = cityRoleMap.get(roleID);
		if(cityRole == null) {
			return 0;
		}
		return cityRole.getNpcID();
	}
	
	private void addCityRoleQuestion(long roleID, int questionID) {
		CityRole cityRole = cityRoleMap.get(roleID);
		if(cityRole == null) {
			cityRole = new CityRole(roleID, 0, questionID, 0, 0);
			cityRoleMap.put(roleID, cityRole);
		}else {
			cityRole.setQuestionID(questionID);
		}
	}
	
	private int getCityRoleQuestion(long roleID) {
		CityRole cityRole = cityRoleMap.get(roleID);
		if(cityRole == null) {
			return 0;
		}
		return cityRole.getQuestionID();
	}

	private void addCityRoleWantThing(long roleID, int itemID, int itemCount) {
		CityRole cityRole = cityRoleMap.get(roleID);
		if(cityRole == null) {
			cityRole = new CityRole(roleID, 0, 0, itemID, itemCount);
			cityRoleMap.put(roleID, cityRole);
		}else {
			cityRole.setWantThing(itemID, itemCount);
		}
	}
	
	private DataPair<Integer, Integer> getCityRoleWantThing(long roleID) {
		CityRole cityRole = cityRoleMap.get(roleID);
		if(cityRole == null) {
			return null;
		}
		return cityRole.getWantThing();
	}
	
	/**
	 * 请求npc列表
	 * @param roleID
	 * @param req
	 * @param builder
	 */
	//public void npcList(long roleID, NpcListReq req, NpcListRsp.Builder builder) {
	//	ConfigCityNpcConf npcConf = ConfManager.getInstance().getConfigCityNpcConf();
	//	if(npcConf == null){
	//		throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
	//	}
	//	ImmutableMap<Integer, ConfigCityNpc> cityNpcMap = npcConf.getCityNpcMap();
	//	for(ConfigCityNpc cityNpc : cityNpcMap.values()) {
	//		if(cityNpc.getCityID() == req.getCityID()) {
	//			QueryParamMap queryParams = new QueryParamMap();
	//			queryParams.put("roleID",roleID);
	//			queryParams.put("npcID", cityNpc.getID());
	//			PlayerNpc playerNpc = playerNpcDao.cacheSelect(queryParams, roleID);
	//			if(playerNpc != null) {
	//				ConfigCityNpc npcConfig = npcConf.getCityNpc(cityNpc.getID());
	//				if(playerNpc.getVisitValue() >= npcConfig.getSkillVisit()) {
	//					// 清空人品值
	//					playerNpc.setVisitValue(0);
	//					playerNpcDao.cacheUpdate(playerNpc, roleID);
	//				}
	//				builder.putVisits(playerNpc.getNpcID(), playerNpc.getVisitValue());
	//			}else {
	//				builder.putVisits(cityNpc.getID(), 0);
	//			}
	//		}
	//	}
	//}

	/**
	 * 拜访npc
	 * @param roleID
	 * @param req
	 * @param builder
	 */
	public void npcVisit(long roleID, NpcVisitReq req, NpcVisitRsp.Builder builder) {
		ConfigCitySceneConf configCitySceneConf = ConfManager.getInstance().getConfigCitySceneConf();
		if(configCitySceneConf == null){
			log.error("npcVisit ConfigCitySceneConf configCitySceneConf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigCityScene configCityScene = configCitySceneConf.getCityScene(req.getSceneID());
		if(configCityScene == null){
			log.error("npcVisit ConfigCityScene configCityScene == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigCityListConf cityListConf = ConfManager.getInstance().getConfigCityListConf();
		if(cityListConf == null){
			log.error("npcVisit ConfigCityListConf cityListConf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigCityList cityList = cityListConf.getCityNpc(configCityScene.getCityID());
		checkLevelEnough(roleID, cityList.getLevelLimit());

		ConfigCitySceneEventConf configCitySceneEventConf = ConfManager.getInstance().getConfigCitySceneEventConf();
		if(configCitySceneEventConf == null){
			log.error("npcVisit ConfigCitySceneEventConf configCitySceneEventConf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigCityNpcEventConf cityNpcEventConf = ConfManager.getInstance().getConfigCityNpcEventConf();
		if(cityNpcEventConf == null){
			log.error("npcVisit cityNpcEventConf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		Map<Integer, Integer> configCitySceneEventWeightedMap = configCitySceneEventConf.getCitySceneEventWeightedMap(req.getSceneID());
		if(configCitySceneEventWeightedMap == null){
			log.error("npcVisit configCitySceneEventWeightedMap == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		int npcID = 0;
		int eventType = 0;
		int sceneEventId = 0;
		// npc拜访任务
		ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.TRIGGER_NPC_SKILL);
		if(configTasks != null) {
			//PlayerRole playerRole = playerRoleDao.cacheQuery(roleID, roleID);
			//if((playerRole.getGuideTaskId() == configTasks.getID()) && (playerRole.getGuideState() < TaskState.complete.getState())) {
				npcID = configTasks.getExtraParam();
				for(Integer key : configCitySceneEventWeightedMap.keySet()){
					if(npcID == cityNpcEventConf.getCityEventNpcId(key)){
						sceneEventId = key;
						eventType = cityNpcEventConf.getCityNpcEventId(key);
					}
				}
				EventManager.postTaskActionEvent(roleID, TaskActionEnum.TRIGGER_NPC_SKILL, 1);
				EventManager.commitRoleEvent(roleID);
			//}
		}
		if(npcID == 0) {
			sceneEventId = RandomUtil.weightedRandom(configCitySceneEventWeightedMap);
			if (sceneEventId == 0) {
				log.error("npcVisit sceneEventId == null");
				throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
			}
			npcID = cityNpcEventConf.getCityEventNpcId(sceneEventId);
			eventType = cityNpcEventConf.getCityNpcEventId(sceneEventId);
		}
		builder.setEventID(sceneEventId);
		builder.setNpcID(npcID);
		addCityRoleNpc(roleID, npcID);
		// 随机事件类型
		builder.setEventType(CityEventType.forNumber(eventType));
		// 事件内容
		JSONObject jsonObject = new JSONObject();
		if(eventType == CityEventType.On_Poetry_VALUE) {
			// 对诗
			ConfigOnPoetryConf onPoetryConf = ConfManager.getInstance().getConfigOnPoetryConf();
			if(onPoetryConf == null){
				log.error("npcVisit ConfigOnPoetryConf onPoetryConf == null");
				throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
			}
			List<ConfigOnPoetry> onPoetryList = onPoetryConf.getDataList();
			int index = RandomUtil.nextInt(onPoetryList.size());
			jsonObject.put("questionID", onPoetryList.get(index).getID());
			addCityRoleQuestion(roleID, onPoetryList.get(index).getID());
		}
		else if(eventType == CityEventType.Race_Horses_VALUE) {
			ConfigCollectionEventConf collectionEventConf = ConfManager.getInstance().getConfigCollectionEventConf();
			if (collectionEventConf == null) {
				log.error("npcVisit ConfigCollectionEventConf collectionEventConf == null");
				throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
			}
			boolean isWin = RandomUtil.nextBoolean();
			if(isWin) {
				jsonObject.put("winOrLose", 1);
				Map<Integer, Integer> itemMaps = collectionEventConf.getWeighted(105);
				while ((itemMaps != null) && (itemMaps.size() > 0)) {
					int collectionId = RandomUtil.weightedRandom(itemMaps);
					ConfigCollectionEvent collectionEvent = collectionEventConf.getCollection(collectionId);
					//产出物品1、无；2、虚拟物品；3、奇遇；5、宝物；6、珍稀植物；7、珍稀动物；8、珍稀鱼；9、鸟（原标本）；10、稀有宝物、宝贝；11、火陷阱；12、落石陷阱；13、水陷阱；14、毒陷阱;15、毒虫陷阱;16、大火、大落石、大水、大毒、大虫。
					if((collectionEvent.getType()!=1)&&(collectionEvent.getType()!=2)&&(collectionEvent.getType()!=3)
							&&(collectionEvent.getType()!=11)&&(collectionEvent.getType()!=12)&&(collectionEvent.getType()!=13)
							&&(collectionEvent.getType()!=14)&&(collectionEvent.getType()!=15)&&(collectionEvent.getType()!=16)) {
						jsonObject.put("itemID", collectionId);
						jsonObject.put("itemCount", 1);
						addItem(roleID, collectionId + "-1", ResourceBillEnum.npcVisit, false);
						break;
					}
				}
			}else {
				jsonObject.put("winOrLose", 0);
				jsonObject.put("itemID", 0);
				jsonObject.put("itemCount", 0);
			}
		}
		else if(eventType == CityEventType.Want_Money_VALUE){
			// 要东西,暂时是金币
			int itemID = 1;
			int itemCount = 1000;
			jsonObject.put("itemID", itemID);
			jsonObject.put("itemCount", itemCount);
			jsonObject.put("yes", 1);
			jsonObject.put("no", 0);
			addCityRoleWantThing(roleID, itemID, itemCount);
		}
		else if(eventType == CityEventType.Want_Thing_VALUE){
			// 要东西,暂时是金币
			List<PlayerItem5> playerItems = playerItem5Dao.cacheLoadAll(roleID);
			if(CollectionUtils.isNotEmpty(playerItems)){
				PlayerItem5 playerItem5 = playerItems.get(RandomUtil.nextInt(playerItems.size()));
				if(playerItem5 != null){
					int itemID = playerItem5.getItemID();
					int itemCount = 1;
					jsonObject.put("itemID", itemID);
					jsonObject.put("itemCount", itemCount);
					addCityRoleWantThing(roleID, itemID, itemCount);
				}
			}
			//int itemID = 1;
			//int itemCount = 1000;
			//jsonObject.put("itemID", itemID);
			//jsonObject.put("itemCount", itemCount);
			//jsonObject.put("yes", 1);
			//jsonObject.put("no", 0);
			//addCityRoleWantThing(roleID, itemID, itemCount);
		}
		else if(eventType == CityEventType.Robbery_NPC_VALUE){
			jsonObject.put("itemID", 1);
			jsonObject.put("itemCount", ConfigSundryConf.npcRobberyGoldNum);
		}
		else {
			log.info("npcVisit roleId:{} npcId:{} eventType:{}", roleID, npcID, eventType);
		}
		builder.setEventContent(jsonObject.toJSONString());
		//addItem(roleID, cityNpc.getRewardItem(), ResourceBillEnum.npcVisit, true);
		//addDiamond(roleID, 2, ResourceBillEnum.npcVisit);
	}

	/**
	 * 此处协议方法已合并到npcVisit
	 * @deprecated
	 * npc触发事件
	 * @param roleID
	 * @param req
	 * @param builder
	 */
	//public void npcTriggerEvent(long roleID, NpcTriggerEventReq req, NpcTriggerEventRsp.Builder builder) {
	//	ConfigCityNpcEventConf conf = ConfManager.getInstance().getConfigCityNpcEventConf();
	//	if(conf == null){
	//		throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
	//	}
	//	Map<Integer, Integer> eventMap = conf.getNpcEventWeightedMap(req.getNpcID());
	//	int eventType = RandomUtil.weightedRandom(eventMap);
	//	builder.setEventType(CityEventType.forNumber(eventType));
	//}

	/**
	 * 此处协议方法已合并到npcVisit
	 * @deprecated
	 * 请求对诗信息，获取第一道题
	 * @param roleID
	 * @param builder
	 */
	//public void npcOnPoetryInfo(long roleID, NpcOnPoetryInfoRsp.Builder builder) {
	//	int questionID = 1;
	//	builder.setQuestionID(questionID);
	//	addCityRoleQuestion(roleID, questionID);
	//}

	/**
	 * 对诗，并获取后续题目
	 * @param roleID
	 * @param req
	 * @param builder
	 */
	public void npcOnPoetry(long roleID, NpcOnPoetryReq req, NpcOnPoetryRsp.Builder builder) {
		int questionID = getCityRoleQuestion(roleID);
		ConfigOnPoetryConf conf = ConfManager.getInstance().getConfigOnPoetryConf();
		if(conf == null){
			log.error("npcOnPoetry ConfigOnPoetryConf conf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigOnPoetry config = conf.getOnPoetry(questionID);
		int isRight = 0;
		if((req.getAnswer() == AnswerOption.Answer_A)&&(config.getTRUEA() == 1)) {
			isRight = 1;
		} else if((req.getAnswer() == AnswerOption.Answer_B)&&(config.getTRUEB() == 1)) {
			isRight = 1;
		} else if((req.getAnswer() == AnswerOption.Answer_C)&&(config.getTRUEC() == 1)){
			isRight = 1;
		}
		if(isRight == 1){
			//addDiamond(roleID, 2, ResourceBillEnum.npcVisit);
			ConfigCollectionEventConf collectionEventConf = ConfManager.getInstance().getConfigCollectionEventConf();
			if (collectionEventConf == null) {
				log.error("npcOnPoetry ConfigCollectionEventConf collectionEventConf == null");
				throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
			}
			Map<Integer, Integer> allWeightMap = collectionEventConf.getWeighted(100+getCityRoleNpc(roleID));
			if(allWeightMap == null || allWeightMap.size() == 0){
				log.error("npcOnPoetry allWeightMap == null");
			}
			int collectionId = RandomUtil.weightedRandom(allWeightMap);
			ConfigCollectionEvent collectionEvent = collectionEventConf.getCollection(collectionId);
			//产出物品1、无；2、虚拟物品；3、奇遇；5、宝物；6、珍稀植物；7、珍稀动物；8、珍稀鱼；9、鸟（原标本）；10、稀有宝物、宝贝；11、火陷阱；12、落石陷阱；13、水陷阱；14、毒陷阱;15、毒虫陷阱;16、大火、大落石、大水、大毒、大虫。
			if((collectionEvent.getType()!=1)&&(collectionEvent.getType()!=2)&&(collectionEvent.getType()!=3)
					&&(collectionEvent.getType()!=11)&&(collectionEvent.getType()!=12)&&(collectionEvent.getType()!=13)
					&&(collectionEvent.getType()!=14)&&(collectionEvent.getType()!=15)&&(collectionEvent.getType()!=16)) {
				addItem(roleID, collectionId + "-1", ResourceBillEnum.npcVisit, false);
				builder.setItemId(collectionId);
				builder.setItemCount(1);
			}
		}
		builder.setRight(isRight);
		questionID = 1;
		builder.setQuestionID(questionID);
		addCityRoleQuestion(roleID, questionID);
		//增加人品
		//int visitValue = addVisit(roleID);
		//builder.setVisitValue(visitValue);
	}

	/**
	 * 增加人品
	 * @param roleID
	 * @return
	 */
	//private int addVisit(long roleID) {
	//	int                    npcID   = getCityRoleNpc(roleID);
	//	ConfigCityNpcEventConf npcConf = ConfManager.getInstance().getConfigCityNpcEventConf();
	//	if(npcConf == null){
	//		throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
	//	}
	//	ConfigCityNpc npcConfig = npcConf.getCityNpc(npcID);
	//	QueryParamMap queryParams = new QueryParamMap();
	//	queryParams.put("roleID",roleID);
	//	queryParams.put("npcID", npcID);
	//	PlayerNpc playerNpc = playerNpcDao.cacheSelect(queryParams, roleID);
	//	if(playerNpc != null) {
	//		playerNpc.setVisitValue(playerNpc.getVisitValue() + npcConfig.getVisitValue());
	//		playerNpcDao.cacheUpdate(playerNpc, roleID);
	//	}else {
	//		playerNpc = new PlayerNpc(roleID);
	//		//playerNpc.setId(readModuleID(TableID.TABLE_NPC));
	//		playerNpc.setNpcID(npcID);
	//		playerNpc.setVisitValue(npcConfig.getVisitValue());
	//		playerNpcDao.cacheInsert(playerNpc, roleID);
	//	}
	//	// npc人品满了触发技能
	//	//if(playerNpc.getVisitValue() >= npcConfig.getSkillVisit()) {
	//	//	ConfigCityNpcSkillConf skillConf = ConfManager.getInstance().getConfigCityNpcSkillConf();
	//	//	if(skillConf == null){
	//	//		throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
	//	//	}
	//	//	int skillID = 1;
	//	//	// 测试
	//	//	//skillID = RandomUtil.weightedRandom(skillConf.getNpcSkillWeightedMap());
	//	//	EventManager.postNpcSkillEvent(roleID, npcID, skillID);
	//	//}
	//
	//	// npc拜访任务
	//	//ConfigTasks configTasks = taskHandler.checkTaskAction(roleID, TaskActionEnum.TRIGGER_NPC_SKILL);
	//	//if(configTasks != null && npcID == configTasks.getExtraParam()) {
	//	//	EventManager.postTaskActionEvent(roleID, TaskActionEnum.TRIGGER_NPC_SKILL, 1);
	//	//	//EventManager.commitRoleEvent(roleID);
	//	//}
	//	return playerNpc.getVisitValue();
	//}
	
	/**
	 * 要东西
	 * @param roleID
	 * @param req
	 */
	public void npcWantThing(long roleID, NpcWantThingReq req) {
		DataPair<Integer, Integer> wantThing = getCityRoleWantThing(roleID);
		if(wantThing == null || req.getAnswer() == 0) {
			return;
		}
		if(wantThing.getObj1() == PlayerAttrEnum.GOLD.getVirtualItemID()) {
			costGold(roleID, wantThing.getObj2(), ResourceBillEnum.npcWantThing);
		}else{
			costItem(roleID,wantThing.getObj1(), wantThing.getObj2(), ResourceBillEnum.npcWantThing);
		}
		ConfigCollectionEventConf collectionEventConf = ConfManager.getInstance().getConfigCollectionEventConf();
		if (collectionEventConf == null) {
			log.error("npcWantThing ConfigCollectionEventConf collectionEventConf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		Map<Integer, Integer> allWeightMap = collectionEventConf.getWeighted(100+getCityRoleNpc(roleID));
		if(allWeightMap == null || allWeightMap.size() == 0){
			log.error("npcWantThing allWeightMap == null");
		}
		int collectionId = RandomUtil.weightedRandom(allWeightMap);
		ConfigCollectionEvent collectionEvent = collectionEventConf.getCollection(collectionId);
		//产出物品1、无；2、虚拟物品；3、奇遇；5、宝物；6、珍稀植物；7、珍稀动物；8、珍稀鱼；9、鸟（原标本）；10、稀有宝物、宝贝；11、火陷阱；12、落石陷阱；13、水陷阱；14、毒陷阱;15、毒虫陷阱;16、大火、大落石、大水、大毒、大虫。
		if((collectionEvent.getType()!=1)&&(collectionEvent.getType()!=2)&&(collectionEvent.getType()!=3)
				&&(collectionEvent.getType()!=11)&&(collectionEvent.getType()!=12)&&(collectionEvent.getType()!=13)
				&&(collectionEvent.getType()!=14)&&(collectionEvent.getType()!=15)&&(collectionEvent.getType()!=16)) {
			addItem(roleID, collectionId + "-1", ResourceBillEnum.npcVisit, true);
		}
		//addVisit(roleID);
	}
	/**
	 * 要东西
	 * @param roleID
	 * @param req
	 */
	public void npcRaceHorses(long roleID, NpcRaceHorsesReq req, NpcRaceHorsesRsp.Builder builder) {
		ConfigCollectionEventConf collectionEventConf = ConfManager.getInstance().getConfigCollectionEventConf();
		if (collectionEventConf == null) {
			log.error("npcRaceHorses ConfigCollectionEventConf collectionEventConf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		boolean isWin = RandomUtil.nextBoolean();
		if(isWin) {
			builder.setWinOrLose(1);
			Map<Integer, Integer> itemMaps = collectionEventConf.getWeighted(105);
			while ((itemMaps != null) && (itemMaps.size() > 0)) {
				int collectionId = RandomUtil.weightedRandom(itemMaps);
				ConfigCollectionEvent collectionEvent = collectionEventConf.getCollection(collectionId);
				//产出物品1、无；2、虚拟物品；3、奇遇；5、宝物；6、珍稀植物；7、珍稀动物；8、珍稀鱼；9、鸟（原标本）；10、稀有宝物、宝贝；11、火陷阱；12、落石陷阱；13、水陷阱；14、毒陷阱;15、毒虫陷阱;16、大火、大落石、大水、大毒、大虫。
				if((collectionEvent.getType()!=1)&&(collectionEvent.getType()!=2)&&(collectionEvent.getType()!=3)
						&&(collectionEvent.getType()!=11)&&(collectionEvent.getType()!=12)&&(collectionEvent.getType()!=13)
						&&(collectionEvent.getType()!=14)&&(collectionEvent.getType()!=15)&&(collectionEvent.getType()!=16)) {
					builder.setItemId(collectionId);
					builder.setItemCount(1);
					addItem(roleID, collectionId + "-1", ResourceBillEnum.npcVisit, false);
					break;
				}
			}
		}else {
			builder.setWinOrLose(0);
			builder.setItemId(0);
			builder.setItemCount(0);
		}
	}

	public void npcRobbery(long roleID, NpcRobberyReq req, NpcRobberyRsp.Builder builder) {
		if(req.getIsAgree()==1){
			costGold(roleID, ConfigSundryConf.npcRobberyGoldNum, ResourceBillEnum.npcVisit);
			builder.setIsSuccess(1);
			builder.setItemId(1);
			builder.setItemCount(ConfigSundryConf.npcRobberyGoldNum);
			return;
		}
		boolean isWin = RandomUtil.nextBoolean();
		if (isWin) {
			builder.setIsSuccess(1);
			ConfigCollectionEventConf collectionEventConf = ConfManager.getInstance().getConfigCollectionEventConf();
			if (collectionEventConf == null) {
				log.error("npcRaceHorses ConfigCollectionEventConf collectionEventConf == null");
				throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
			}
			Map<Integer, Integer> itemMaps = collectionEventConf.getWeighted(107);
			while ((itemMaps != null) && (itemMaps.size() > 0)) {
				int collectionId = RandomUtil.weightedRandom(itemMaps);
				ConfigCollectionEvent collectionEvent = collectionEventConf.getCollection(collectionId);
				//产出物品1、无；2、虚拟物品；3、奇遇；5、宝物；6、珍稀植物；7、珍稀动物；8、珍稀鱼；9、鸟（原标本）；10、稀有宝物、宝贝；11、火陷阱；12、落石陷阱；13、水陷阱；14、毒陷阱;15、毒虫陷阱;16、大火、大落石、大水、大毒、大虫。
				if((collectionEvent.getType()!=1)&&(collectionEvent.getType()!=2)&&(collectionEvent.getType()!=3)
						&&(collectionEvent.getType()!=11)&&(collectionEvent.getType()!=12)&&(collectionEvent.getType()!=13)
						&&(collectionEvent.getType()!=14)&&(collectionEvent.getType()!=15)&&(collectionEvent.getType()!=16)) {
					builder.setItemId(collectionId);
					builder.setItemCount(1);
					addItem(roleID, collectionId + "-1", ResourceBillEnum.npcVisit, false);
					break;
				}
			}
		} else {
			builder.setIsSuccess(0);
			costGold(roleID, ConfigSundryConf.npcRobberyFailGoldNum, ResourceBillEnum.npcVisit);
			builder.setItemId(1);
			builder.setItemCount(ConfigSundryConf.npcRobberyFailGoldNum);
		}
	}

	public void npcPraise(long roleID, NpcPraiseReq req, NpcPraiseRsp.Builder builder) {
		ConfigCollectionEventConf collectionEventConf = ConfManager.getInstance().getConfigCollectionEventConf();
		if (collectionEventConf == null) {
			log.error("npcRaceHorses ConfigCollectionEventConf collectionEventConf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		boolean isWin = RandomUtil.nextBoolean();
		if(isWin) {
			builder.setIsSuccess(1);
			Map<Integer, Integer> itemMaps = collectionEventConf.getWeighted(100+req.getNpcId());
			while ((itemMaps != null) && (itemMaps.size() > 0)) {
				int collectionId = RandomUtil.weightedRandom(itemMaps);
				ConfigCollectionEvent collectionEvent = collectionEventConf.getCollection(collectionId);
				//产出物品1、无；2、虚拟物品；3、奇遇；5、宝物；6、珍稀植物；7、珍稀动物；8、珍稀鱼；9、鸟（原标本）；10、稀有宝物、宝贝；11、火陷阱；12、落石陷阱；13、水陷阱；14、毒陷阱;15、毒虫陷阱;16、大火、大落石、大水、大毒、大虫。
				if ((collectionEvent.getType() != 1) && (collectionEvent.getType() != 2) && (collectionEvent.getType() != 3)
						&& (collectionEvent.getType() != 11) && (collectionEvent.getType() != 12) && (collectionEvent.getType() != 13)
						&& (collectionEvent.getType() != 14) && (collectionEvent.getType() != 15) && (collectionEvent.getType() != 16)) {
					builder.setItemId(collectionId);
					builder.setItemCount(1);
					addItem(roleID, collectionId + "-1", ResourceBillEnum.npcVisit, false);
					break;
				}
			}
		}else {
			builder.setIsSuccess(0);
			builder.setItemId(0);
			builder.setItemCount(0);
		}
	}
}
