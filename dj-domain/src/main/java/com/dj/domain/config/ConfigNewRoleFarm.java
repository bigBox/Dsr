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
public class ConfigNewRoleFarm{
	
	/**
	 * @Field Id : Id序号
	 */
	protected int Id;

	/**
	 * @Field type : 类型:1:植物2:动物
	 */
	protected int type;

	/**
	 * @Field seedId : 种子ID 
	 */
	protected int seedId;

	/**
	 * @Field initState : 初始状态 1: 空地, 3:成熟
	 */
	protected int initState;

	/**
	 * @Field x : x坐标
	 */
	protected int x;

	/**
	 * @Field y : y坐标
	 */
	protected int y;



}
