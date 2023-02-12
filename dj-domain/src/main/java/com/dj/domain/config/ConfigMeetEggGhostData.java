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
public class ConfigMeetEggGhostData{
	
	/**
	 * @Field ID : 动物ID
	 */
	protected int ID;

	/**
	 * @Field name : 名称
	 */
	protected String name;

	/**
	 * @Field prob : 概率
	 */
	protected int prob;

	/**
	 * @Field subType : 掉落物类型（0）炸弹：小炸弹 大炸弹)（1）火：陶瓷类（2）水：鱼类（3）金：杂项类（雕刻、把玩件）（4）木：稀有动物植物类（5）土：玉器类)
	 */
	protected int subType;

	/**
	 * @Field dropLimit : 掉落数量上线
	 */
	protected int dropLimit;



}
