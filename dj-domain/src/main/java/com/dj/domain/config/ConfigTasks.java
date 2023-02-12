package com.dj.domain.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 此类由工具生成，请勿手动改写
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ConfigTasks{
	
	/**
	 * @Field ID : ID
	 */
	protected int ID;

	/**
	 * @Field type : 任务类型。1、成长；2、日常；3、月度；4、节日
	 */
	protected int type;

	/**
	 * @Field conditionLevel : 条件：等级
	 */
	protected int conditionLevel;

	/**
	 * @Field actionType : (1,"宝藏任务-新手引导"),(2,"鉴定宝物"),(3,"帮助（好友）鉴定宝物"),(4,"展示宝物"),(5,"精灵寻宝"),(6,"沙漠绿化"),(7,"精灵投资"),(8,"宝藏寻宝"),(9,"套装兑奖"),(10,"点亮宝物"),(11,"收集地图碎片"),(12,"扩充营地"),(13,"添加好友"),(14,"完成交易"),(15,"建立商会"),(16,"加入商会"),(17,"完成商会任务"),(18,"参加商会比赛"),(19,"结交NPC"),(20,"购买月卡"),(21,"遇到动物"),(22,"召唤动物"),(23,"饲养动物"),(24,"生产物品"),(25,"玩小游戏超过多少分"),(26,"玩某款小游戏超过多少分"),(27,"玩小游戏多少次"),(28,"玩某款小游戏多少次"),(29,"看两个探险玩法帮助"),(900,"活跃天数", "doActionActiveDay"),(910,"接任务之后，找到物品，进背包", null),(920,"接任务之后，使用物品", null);
	 */
	protected int actionType;

	/**
	 * @Field actionTime : 行为次数
	 */
	protected int actionTime;

	/**
	 * @Field actionType1 : (1,"宝藏任务-新手引导"),(2,"鉴定宝物"),(3,"帮助（好友）鉴定宝物"),(4,"展示宝物"),(5,"精灵寻宝"),(6,"沙漠绿化"),(7,"精灵投资"),(8,"宝藏寻宝"),(9,"套装兑奖"),(10,"点亮宝物"),(11,"收集地图碎片"),(12,"扩充营地"),(13,"添加好友"),(14,"完成交易"),(15,"建立商会"),(16,"加入商会"),(17,"完成商会任务"),(18,"参加商会比赛"),(19,"结交NPC"),(20,"购买月卡"),(21,"遇到动物"),(22,"召唤动物"),(23,"饲养动物"),(24,"生产物品"),(25,"玩小游戏超过多少分"),(26,"玩某款小游戏超过多少分"),(27,"玩小游戏多少次"),(28,"玩某款小游戏多少次"),(29,"看两个探险玩法帮助"),(900,"活跃天数", "doActionActiveDay"),(910,"接任务之后，找到物品，进背包", null),(920,"接任务之后，使用物品", null);
	 */
	protected int actionType1;

	/**
	 * @Field actionTime1 : 行为次数
	 */
	protected int actionTime1;

	/**
	 * @Field extraParam : 特殊参数
	 */
	protected int extraParam;

	/**
	 * @Field needItem : 所需物品
	 */
	protected String needItem;

	/**
	 * @Field addItem : 添加物品
	 */
	protected String addItem;

	/**
	 * @Field rewardItem : 奖励
	 */
	protected String rewardItem;

	/**
	 * @Field guildScore : 奖励商会积分
	 */
	protected int guildScore;



}
