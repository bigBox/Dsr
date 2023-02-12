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
public class ConfigNewRolePark{
	
	/**
	 * @Field ID : ID序号
	 */
	protected int ID;

	/**
	 * @Field x : x坐标
	 */
	protected int x;

	/**
	 * @Field y : y坐标
	 */
	protected int y;

	/**
	 * @Field green : 默认绿化值
	 */
	protected int green;



}
