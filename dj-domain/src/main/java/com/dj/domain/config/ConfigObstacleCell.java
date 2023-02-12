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
public class ConfigObstacleCell{
	
	/**
	 * @Field ID : 序列
	 */
	protected int ID;

	/**
	 * @Field itemCost : 开启消耗
	 */
	protected int itemCost;

	/**
	 * @Field costNum : 消耗数量
	 */
	protected int costNum;



}
