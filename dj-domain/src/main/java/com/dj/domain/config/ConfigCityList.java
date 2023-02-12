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
public class ConfigCityList{
	
	/**
	 * @Field ID : 序号。100苏州府
	 */
	protected int ID;

	/**
	 * @Field name : 建筑名
	 */
	protected String name;

	/**
	 * @Field levelLimit : 等级限制
	 */
	protected int levelLimit;



}
