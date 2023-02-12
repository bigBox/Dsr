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
public class ConfigFarmParkAnimal{
	
	/**
	 * @Field ID : 种子ID
	 */
	protected int ID;

	/**
	 * @Field costGold : 消耗金币
	 */
	protected int costGold;

	/**
	 * @Field needLevel : 需要玩家等级
	 */
	protected int needLevel;

	/**
	 * @Field costEcology : 消耗生态值
	 */
	protected int costEcology;

	/**
	 * @Field addBoom : 增加繁荣度
	 */
	protected int addBoom;

	/**
	 * @Field placeLimit : 放置上限
	 */
	protected int placeLimit;

	/**
	 * @Field eatPlantID : 吃的植物ID
	 */
	protected int eatPlantID;

	/**
	 * @Field eatPlantType : 吃的植物类型(和植物表的 被吃类型 字段对应)
	 */
	protected int eatPlantType;

	/**
	 * @Field eatNum : 食草量
	 */
	protected int eatNum;

	/**
	 * @Field harvestCount : 收获次数
	 */
	protected int harvestCount;

	/**
	 * @Field cookingTime : 成熟时间（分钟）
	 */
	protected int cookingTime;

	/**
	 * @Field lifeTime : 生存时间（分钟）
	 */
	protected int lifeTime;

	/**
	 * @Field productId : 产出物品id
	 */
	protected int productId;

	/**
	 * @Field productNum : 产出物品数量
	 */
	protected int productNum;

	/**
	 * @Field productExp : 产出经验
	 */
	protected int productExp;

	/**
	 * @Field productRenown : 产出声望
	 */
	protected int productRenown;

	/**
	 * @Field uncommon : 是否稀有
	 */
	protected int uncommon;



}
