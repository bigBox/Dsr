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
public class ConfigSummonMail{
	
	/**
	 * @Field ID : 招唤ID
	 */
	protected int ID;

	/**
	 * @Field name : 精灵
	 */
	protected String name;

	/**
	 * @Field investGold : 投资需求，金币
	 */
	protected int investGold;

	/**
	 * @Field rewardItem : 奖励物品
	 */
	protected String rewardItem;

	/**
	 * @Field rewardGold : 奖励金币
	 */
	protected int rewardGold;

	/**
	 * @Field title : 标题
	 */
	protected String title;

	/**
	 * @Field content : 内容1
	 */
	protected String content;

	/**
	 * @Field content2 : 内容2
	 */
	protected String content2;



}
