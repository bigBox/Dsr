package com.dj.servercore.conf;

import java.util.List;
import java.util.Map;

import com.dj.domain.config.ConfigSundry;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.ListUtil;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigSundryConf extends BaseConfigConf<ConfigSundry> {

	public ConfigSundryConf() {
		super(IConfProvider.CONFIG_SUNDRY);
	}

	private ImmutableMap<String, ConfigSundry> sundryMap;

	/**
	 *	生态园地图大小
	 */
	public static int parkMapSize;
	/**
	 *	生态园鱼塘的池子大小
	 */
	public static int poolMapSize;
	/**
	 *	创建商会消耗钻石
	 */
	public static int guildCreateCostDiamod;
	/**
	 *	初始化商会任务数量
	 */
	public static int guildTaskCreateNum;
	/**
	 *	商会任务撕单冷却时间 秒
	 */
	public static int guildTaskTearSheet;
	/**
	 *	商会战斗报名消耗钻石
	 */
	public static int signUpGuildBattleCostDiamod;
	/**
	 *	古迹怪物碰撞消耗气力值
	 */
	public static int robMonsterOncollisionCostAction;
	/**
	 *	精灵派出获得邮件数量
	 */
	public static int summonMailCount;
	/**
	 *	正常包裹间隔时间（分钟）
	 */
	public static int summonPackageTime;
	/**
	 *	不在线的包裹数折算个/24小时
	 */
	public static int summonPackageNumber;

	/**
	 *	动物吃草周期(分钟)
	 */
	public static int parkAnimalEatPlantCycle;
	/**
	 *	可交易的前几名
	 */
	public static int tradeTop;
	/**
	 *	鱼塘的鱼数量上限
	 */
	public static int poolFishNumLimit;
	/**
	 *	接鸡蛋worker的心跳
	 */
	public static int meetEggWorkerHeartBeat;
	/**
	 *	商会战斗匹配worker的心跳
	 */
	public static int guildBattleMatchWorkerHeartBeat;
	/**
	 *	商会战斗机器人worker的心跳
	 */
	public static int guildBattleRobotWorkerHeartBeat;
	/**
	 *	接鸡蛋场景二分之一宽度（像素）
	 */
	public static int meetEggWidth;
	/**
	 *	接鸡蛋场景高度（像素）
	 */
	public static int meetEggHeight;
	/**
	 *	接鸡蛋飞行物出现速度（多少毫秒出现一个）
	 */
	public static int meetEggFlySpeed;
	/**
	 *	接鸡蛋飞行物移动速度（每秒移动多少像素）
	 */
	public static int meetEggFlyMoveSpeed;
	/**
	 *	接鸡蛋掉落物下落速度（每秒下落多少像素）
	 */
	public static int meetEggDropMoveSpeed;
	/**
	 *	接鸡蛋游戏时间（秒）
	 */
	public static int meetEggGameTime;
	/**
	 *	商会战斗房间时间（秒）
	 */
	public static int guildBattleRoomTime;
	/**
	 *	商会战斗接鸡蛋游戏时间（秒）
	 */
	public static int guildBattleMeetEggGameTime;
	/**
	 *	商会战斗挑战cd时间（秒）
	 */
	public static int guildBattleGameCD;
	/**
	 *	接鸡蛋建筑cd时间（秒）
	 */
	public static int meetEggBuildCD;
	/**
	 *	平底锅移动速度
	 */
	public static int meetEggPanSpeed;
	/**
	 *	金蛋积分翻倍时间(秒)
	 */
	public static int meetEggGoldEggDoubleTime;
	/**
	 *	生态园清除枯萎的动植物消耗道具id
	 */
	public static int parkClearWitherItemID;
	/**
	 *	清除获得经验
	 */
	public static int parkClearWitherRewardExp;
	/**
	 *	鉴定自动放入队列上限
	 */
	public static int verifyAutoEnqueueLimit;
	/**
	 *	每个类型任务对应的总数量
	 */
	public static Map<Integer, Integer> taskTypeTotalCount;
	/**
	 *	新手引导用的待鉴定
	 */
	public static List<Integer> guideVerified;
	/**
	 *	鉴定队列个数
	 */
	public static int verifyQueueCount;
	/**
	 *	送去鉴定的道具数量
	 */
	public static int verifyItemCount;
	/**
	 *	小寻的物品
	 */
	public static Map<Integer, Integer> xiaoxunItem;
	/**
	 *	记录特殊道具来源
	 */
	public static List<Integer> recordItemSource;
	/**
	 *	挖矿使用采集证id
	 */
	public static int mineUseSkillCostItemID;
	/**
	 *	挖矿空资源权重
	 */
	public static Map<Integer, Integer> mineLayerEmptyWeight;
	/**
	 *	挖矿非资源系数
	 */
	public static int mineLayerResourceRatio;
	/**
	 *	自己排名上下浮动排行数
	 */
	public static int rankSelfNearby;
	/**
	 *	交易历史记录倒序后显示数量
	 */
	public static int tradeHistoryDescTop;
	/**
	 *	月卡道具id
	 */
	public static int monthCardItemID;
	/**
	 *	蜂巢奖励
	 */
	public static Map<Integer, Integer> drawHoneyReward;
	/**
	 *	蜂巢奖励cd时间（分钟）
	 */
	public static int drawHoneyRewardCD;
	/**
	 *	馆藏值奖励比率
	 */
	public static int showTableRewardRate;
	/**
	 *	完成这个ID的成长任务后，开放其他任务。
	 */
	public static int newPlayerOpenDailyTask;
	/**
	 *	实名认证接口调用地址:游戏备案识别码(BizId) 应用标识 (AppId) 应用密钥 (Secret Key)
	 */
	public static String realNameAuthBizId;
	public static String realNameAuthAppId;
	public static String realNameAuthAppKey;
	public static String realNameAuthCheckUrl;
	public static String realNameAuthQueryUrl;
	public static String realNameAuthLoginUrl;
	/**
	 *	加速60分种消耗多少钻石。
	 */
	public static int accelerateConsumption;

	/**
	 *	小混混抢劫金币数量。
	 */
	public static int npcRobberyGoldNum;
	/**
	 *	玩家反抗抢劫失败损失金币数量。
	 */
	public static int npcRobberyFailGoldNum;

	@Override
	public void onLoadOver() {
		sundryMap = MapUtil.listToImmMap(dataList, obj -> {
			log.info("name {}, value {}, desc {}", obj.getName(), obj.getValue(), obj.getDesc());
			return obj.getName();
		});

		parkMapSize = Integer.parseInt(getString("parkMapSize", "12"));
		poolMapSize = Integer.parseInt(getString("poolMapSize", "4"));
		guildCreateCostDiamod = Integer.parseInt(getString("guildCreateCostDiamod", "50"));
		guildTaskCreateNum = Integer.parseInt(getString("guildTaskCreateNum", "6"));
		guildTaskTearSheet = Integer.parseInt(getString("guildTaskTearSheet", "600"));
		signUpGuildBattleCostDiamod = Integer.parseInt(getString("signUpGuildBattleCostDiamod", "50"));
		robMonsterOncollisionCostAction = Integer.parseInt(getString("robMonsterOncollisionCostAction", "1"));
		summonMailCount = Integer.parseInt(getString("summonMailCount", "3"));
		parkAnimalEatPlantCycle = Integer.parseInt(getString("parkAnimalEatPlantCycle", "1")) * 60 * 1000;
		tradeTop = Integer.parseInt(getString("tradeTop", "3"));
		poolFishNumLimit = Integer.parseInt(getString("poolFishNumLimit", "10"));
		meetEggWorkerHeartBeat = Integer.parseInt(getString("meetEggWorkerHeartBeat", "100"));
		guildBattleMatchWorkerHeartBeat = Integer.parseInt(getString("guildBattleMatchWorkerHeartBeat", "1000"));
		guildBattleRobotWorkerHeartBeat = Integer.parseInt(getString("guildBattleRobotWorkerHeartBeat", "5000"));
		meetEggWidth = Integer.parseInt(getString("meetEggWidth", "10"));
		meetEggHeight = Integer.parseInt(getString("meetEggHeight", "10"));
		meetEggFlySpeed = Integer.parseInt(getString("meetEggFlySpeed", "10"));
		meetEggFlyMoveSpeed = Integer.parseInt(getString("meetEggFlyMoveSpeed", "10"));
		meetEggDropMoveSpeed = Integer.parseInt(getString("meetEggDropMoveSpeed", "10"));
		meetEggGameTime = Integer.parseInt(getString("meetEggGameTime", "60"));
		guildBattleRoomTime = Integer.parseInt(getString("guildBattleRoomTime", "60"));
		guildBattleMeetEggGameTime = Integer.parseInt(getString("guildBattleMeetEggGameTime", "30"));
		guildBattleGameCD = Integer.parseInt(getString("guildBattleGameCD", "60"));
		meetEggBuildCD = Integer.parseInt(getString("meetEggBuildCD", "60"));
		meetEggPanSpeed = Integer.parseInt(getString("meetEggPanSpeed", "100"));
		meetEggGoldEggDoubleTime = Integer.parseInt(getString("meetEggGoldEggDoubleTime", "10"));
		parkClearWitherItemID = Integer.parseInt(getString("parkClearWitherItemID", "0"));
		parkClearWitherRewardExp = Integer.parseInt(getString("parkClearWitherRewardExp", "1"));
		verifyAutoEnqueueLimit = Integer.parseInt(getString("verifyAutoEnqueueLimit", "1"));
		taskTypeTotalCount = MapUtil.mapStringToMap1(getString("taskTypeTotalCount", ""));
		guideVerified = ListUtil.commaStringToList(getString("guideVerified", ""), "\\|");
		verifyQueueCount = Integer.parseInt(getString("verifyQueueCount", "10"));
		verifyItemCount = Integer.parseInt(getString("verifyItemCount", "50"));
		xiaoxunItem = MapUtil.mapStringToMap1(getString("xiaoxunItem", ""));
		recordItemSource = ListUtil.commaStringToList(getString("recordItemSource", ""), "\\|");
		mineUseSkillCostItemID = Integer.parseInt(getString("mineUseSkillCostItemID", "0"));
		mineLayerEmptyWeight = MapUtil.mapStringToMap1(getString("mineLayerEmptyWeight", ""));
		mineLayerResourceRatio = Integer.parseInt(getString("mineLayerResourceRatio", "5"));
		rankSelfNearby = Integer.parseInt(getString("rankSelfNearby", "3"));
		tradeHistoryDescTop = Integer.parseInt(getString("tradeHistoryDescTop", "1"));
		monthCardItemID = Integer.parseInt(getString("monthCardItemID", "0"));
		drawHoneyReward = MapUtil.mapStringToMap1(getString("drawHoneyReward", ""));
		drawHoneyRewardCD = Integer.parseInt(getString("drawHoneyRewardCD", "1"));
		showTableRewardRate = Integer.parseInt(getString("showTableRewardRate", "100"));
		newPlayerOpenDailyTask = Integer.parseInt(getString("newPlayerOpenDailyTask", "10027"));
		realNameAuthBizId = getString("realNameAuthBizId", "1108009471");
		realNameAuthAppId = getString("realNameAuthAppId", "3b461800c9614109a9bbda662365a1c6");
		realNameAuthAppKey = getString("realNameAuthAppKey", "cf1be9d5de938c6bc42353c61c9bb248");
		realNameAuthCheckUrl = getString("realNameAuthCheckUrl", "https://api.wlc.nppa.gov.cn/idcard/authentication/check");
		realNameAuthQueryUrl = getString("realNameAuthQueryUrl", "https://api2.wlc.nppa.gov.cn/idcard/authentication/query/");
		realNameAuthLoginUrl = getString("realNameAuthLoginUrl", "https://api2.wlc.nppa.gov.cn/behavior/collection/loginout/");
		accelerateConsumption = Integer.parseInt(getString("accelerateConsumption", "15"));
		summonPackageTime = Integer.parseInt(getString("summonPackageTime", "120"));
		summonPackageNumber = Integer.parseInt(getString("summonPackageNumber", "3"));
		npcRobberyGoldNum = Integer.parseInt(getString("npcRobberyGoldNum", "1000"));
		npcRobberyFailGoldNum = Integer.parseInt(getString("npcRobberyFailGoldNum", "2000"));
	}

	private String getString(String key, String defaultValue) {
		ConfigSundry config = sundryMap.get(key);
		if (config == null) {
			return defaultValue;
		}
		return config.getValue();
	}
}
