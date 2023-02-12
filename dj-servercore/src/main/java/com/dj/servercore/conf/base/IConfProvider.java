package com.dj.servercore.conf.base;

/**
 * @description 配置提供者
 * @author zcq
 * @date 2019年4月8日
 */
public interface IConfProvider {

	String CONFIG_FACTORY = "ConfigFactory.json";
	String CONFIG_ITEMS = "ConfigItems.json";
	String CONFIG_ITEM2COUNT = "ConfigItem2Count.json";
	String CONFIG_VERIFYFUNC = "ConfigVerifyFunc.json";
	String CONFIG_MINEINIT = "ConfigMineInit.json";
	String CONFIG_DIGGOLD = "ConfigDigGold.json";
	String CONFIG_MAPPIECE = "ConfigMapPiece.json";
	String CONFIG_NEWROLEITEM = "ConfigNewRoleItem.json";
	String CONFIG_NEWROLEFARM = "ConfigNewRoleFarm.json";
	String CONFIG_NEWROLEPARK = "ConfigNewRolePark.json";
	String CONFIG_NEWROLESHOWTABLEITEM = "ConfigNewRoleShowTableItem.json";

	String CONFIG_NEWROLESHOWTABLEINFO = "ConfigNewRoleShowTableInfo.json";
	String CONFIG_ROBCFG = "ConfigRobCfg.json";
	String CONFIG_ROBINIT = "ConfigRobInit.json";
	//String CONFIG_ROBEVENT = "ConfigRobEvent.json";
	String CONFIG_ROBFUNC = "ConfigRobFunc.json";
	String CONFIG_ROBTREASURE = "ConfigRobTreasure.json";
	String CONFIG_ROBTREASUREPOSITION = "ConfigRobTreasurePosition.json";
	String CONFIG_OUTSIDES = "ConfigOutsides.json";
	String CONFIG_OUTSIDESFUNC = "ConfigOutsidesFunc.json";
	String CONFIG_EVENTLIST = "ConfigEventList.json";
	String CONFIG_OBSTACLES = "ConfigObstacles.json";
	String CONFIG_OBSTACLECELL = "ConfigObstacleCell.json";
	String CONFIG_GUIDETASK = "ConfigGuideTask.json";
	String CONFIG_MANUFACTUREMAKEDATA = "ConfigManufactureMakeData.json";
	String CONFIG_EXPLEVELCFG = "ConfigExpLevelCfg.json";
	String CONFIG_ACHIEVEMENT = "ConfigAchievement.json";
	String CONFIG_TRADEITEMS = "ConfigTradeItems.json";
	String CONFIG_TRADEKLINE = "ConfigTradeKLine.json";
	String CONFIG_TASKS = "ConfigTasks.json";
	String CONFIG_SUMMONS = "ConfigSummons.json";
	String CONFIG_SUMMONMAIL = "ConfigSummonMail.json";
	String CONFIG_SUMMONSEXPLORE = "ConfigSummonExplore.json";
	//String CONFIG_SUMMONSOUTPUT = "ConfigSummonOutput.json";
	String CONFIG_SUMMONS_RATE = "ConfigSummonsRate.json";
	String CONFIG_SUMMON_PACKAGE_COUNT = "ConfigSummonPackageCount.json";

	String CONFIG_FARMPARKPLANT = "ConfigFarmParkPlant.json";
	String CONFIG_FARMPARKTREE = "ConfigFarmParkTree.json";
	String CONFIG_FARMPARKANIMAL = "ConfigFarmParkAnimal.json";
	String CONFIG_FARMZOOANIMAL = "ConfigFarmZooAnimal.json";
	String CONFIG_FARMCULTURE = "ConfigFarmCulture.json";
	String CONFIG_POOLFISHS = "ConfigPoolFishs.json";
	String CONFIG_STAMINACFG = "ConfigStaminaCfg.json";
	String CONFIG_MONTHCARD = "ConfigMonthCard.json";
	String CONFIG_MINIMALL = "ConfigMiniMall.json";
	String CONFIG_SUNDRY = "ConfigSundry.json";
	String CONFIG_REPUTATIONLEVEL = "ConfigReputationLevel.json";
	String CONFIG_SHOWTABLELEVEL   = "ConfigShowTableLevel.json";
	String CONFIG_MINIGAME         = "ConfigMiniGame.json";
	String CONFIG_MEETEGGDROPITEMS = "ConfigMeetEggDropItems.json";
	String CONFIG_MEETEGGGHOSTDATA = "ConfigMeetEggGhostData.json";
	String CONFIG_ANTIQUE          = "ConfigAntique.json";
	String CONFIG_GUILDLEVEL       = "ConfigGuildLevel.json";
	//String CONFIG_ROBDOOR = "ConfigRobDoor.json";
	String CONFIG_COLLECTIONDATA   = "ConfigCollectionData.json";
	String CONFIG_COLLECTIONITEMS  = "ConfigCollectionItems.json";
	String CONFIG_COLLECTION_EVENT = "ConfigCollectionEvent.json";
	String CONFIG_CITY_NPC         = "ConfigCityNpc.json";
	String CONFIG_CITY_NPC_EVENT   = "ConfigCityNpcEvent.json";
	String CONFIG_CITY_NPC_SKILL   = "ConfigCityNpcSkill.json";
	String CONFIG_CITY_LIST        = "ConfigCityList.json";
	String CONFIG_CITY_SCENE       = "ConfigCityScene.json";
	String CONFIG_CITY_SCENE_EVENT = "ConfigCitySceneEvent.json";
	String CONFIG_ONPOETRY         = "ConfigOnPoetry.json";
	String CONFIG_BOOK             = "ConfigBook.json";
	String CONFIG_VIRTUAL_ITEMS    = "ConfigVirtualItems.json";
	String CONFIG_TRAP_EVENT       = "ConfigTrapEvent.json";
	/**
	 * 获得一个特定配置索引
	 * 
	 * @return
	 */
	<X, T extends BaseConfigConf<X>> T getConfigConf(String name);

	/**
	 * @Title setConfigConf
	 * @Description 更新索引时，新建一个索引对象，直接替换原本的索引
	 * @param configName
	 * @param conf
	 * @return void
	 */
	<X, T extends BaseConfigConf<X>> void setConfigConf(String configName, T conf);
}
