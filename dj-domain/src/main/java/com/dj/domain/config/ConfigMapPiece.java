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
public class ConfigMapPiece{
	
	/**
	 * @Field ID : 编号
	 */
	protected int ID;

	/**
	 * @Field itemGet : 获得物品
	 */
	protected int itemGet;

	/**
	 * @Field weight : 权重
	 */
	protected int weight;



}
