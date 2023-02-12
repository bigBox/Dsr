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
public class ConfigGuideTask{
	
	/**
	 * @Field ID : ID
	 */
	protected int ID;

	/**
	 * @Field reward : 奖励经验
	 */
	protected int reward;

	/**
	 * @Field rewardGold : 奖励金币
	 */
	protected int rewardGold;

	/**
	 * @Field finishTag : 新手任务结束标记
	 */
	protected int finishTag;



}
