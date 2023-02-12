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
public class ConfigOutsidesFunc{
	
	/**
	 * @Field ID : 功能序号
	 */
	protected int ID;

	/**
	 * @Field matrial1 : 产出物品
	 */
	protected String matrial1;

	/**
	 * @Field cost : 单次行动值消耗
	 */
	protected int cost;

	/**
	 * @Field costId : 单次行动值消耗的物品
	 */
	protected int costId;



}
