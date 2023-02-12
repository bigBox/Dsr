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
public class ConfigMiniGame{
	
	/**
	 * @Field ID : 编号
	 */
	protected int ID;

	/**
	 * @Field name : 名称
	 */
	protected String name;

	/**
	 * @Field needLevel : 需要玩家等级
	 */
	protected int needLevel;



}
