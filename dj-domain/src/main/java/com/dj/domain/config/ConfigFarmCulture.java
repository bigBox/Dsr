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
public class ConfigFarmCulture{
	
	/**
	 * @Field ID : 种子ID
	 */
	protected int ID;

	/**
	 * @Field costGold : 消耗金币
	 */
	protected int costGold;

	/**
	 * @Field needLevel : 开放等级
	 */
	protected int needLevel;

	/**
	 * @Field needGreen : 种植绿化要求
	 */
	protected int needGreen;

	/**
	 * @Field greenTo : 周边绿化加成到几级
	 */
	protected int greenTo;

	/**
	 * @Field harvestGreenTo : 最终收获后绿化加到值
	 */
	protected int harvestGreenTo;

	/**
	 * @Field eatGreenTo : 被吃（砍）掉后退化到绿化值
	 */
	protected int eatGreenTo;

	/**
	 * @Field harvestNum : 收获次数
	 */
	protected int harvestNum;

	/**
	 * @Field seedNum : 种子数量
	 */
	protected int seedNum;

	/**
	 * @Field cookingTime : 生成时间(分钟)
	 */
	protected int cookingTime;

	/**
	 * @Field growStep : 进程数
	 */
	protected int growStep;

	/**
	 * @Field eatType : 被吃类型(1.家畜吃,2.熊猫吃,0不能吃)
	 */
	protected int eatType;

	/**
	 * @Field productId : 产出物品id
	 */
	protected int productId;

	/**
	 * @Field productNum : 产出物品数量
	 */
	protected int productNum;

	/**
	 * @Field productExp : 产出1（收获）经验
	 */
	protected int productExp;

	/**
	 * @Field feedId : 产出2（饲养）-物品id
	 */
	protected int feedId;

	/**
	 * @Field feedNum : 产出物2（饲养）数量
	 */
	protected int feedNum;



}
