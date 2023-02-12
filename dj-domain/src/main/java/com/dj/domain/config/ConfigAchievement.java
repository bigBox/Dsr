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
public class ConfigAchievement{
	
	/**
	 * @Field id : 等级
	 */
	protected int id;

	/**
	 * @Field action : 成就行为  1:宝藏探险
	 */
	protected int action;

	/**
	 * @Field count : 成就次数
	 */
	protected int count;

	/**
	 * @Field name : 成就名称
	 */
	protected String name;



}
