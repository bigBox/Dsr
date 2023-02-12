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
public class ConfigPoolFishs{
	
	/**
	 * @Field ID : 种子ID
	 */
	protected int ID;

	/**
	 * @Field costType : 消耗类型1、消耗金币2、消耗种子
	 */
	protected int costType;

	/**
	 * @Field type : 类型1农田2牧场3渔场
	 */
	protected int type;

	/**
	 * @Field level : 开放等级
	 */
	protected int level;

	/**
	 * @Field seedNum : 种子数量或金币数量
	 */
	protected int seedNum;

	/**
	 * @Field cookingTime : 生成时间(分钟)
	 */
	protected int cookingTime;

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



}
