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
public class ConfigCollectionData{
	
	/**
	 * @Field ID : 序号。
	 */
	protected int ID;

	/**
	 * @Field num : 套装内个数
	 */
	protected int num;

	/**
	 * @Field type : （暂时用全部）套装一级菜单ID.附注：1、玩具1；2、其它；
	 */
	protected int type;

	/**
	 * @Field rewardExp : 奖励经验
	 */
	protected int rewardExp;

	/**
	 * @Field rewardGold : 奖励金币
	 */
	protected int rewardGold;



}
