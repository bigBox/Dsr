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
public class ConfigMeetEggDropItems{
	
	/**
	 * @Field ID : 物品ID
	 */
	protected int ID;

	/**
	 * @Field subType : 掉落物类型(（0）炸弹：小炸弹 大炸弹)（1）火：陶瓷类（2）水：鱼类（3）金：杂项类（雕刻、把玩件）（4）木：稀有动物植物类（5）土：玉器类)
	 */
	protected int subType;

	/**
	 * @Field score : 分数
	 */
	protected int score;

	/**
	 * @Field time : 时间 秒/s
	 */
	protected int time;

	/**
	 * @Field blood : 扣除血量 %
	 */
	protected int blood;



}
