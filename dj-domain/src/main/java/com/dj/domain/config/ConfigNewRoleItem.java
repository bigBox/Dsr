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
public class ConfigNewRoleItem{
	
	/**
	 * @Field Id : Id
	 */
	protected int Id;

	/**
	 * @Field ItemId : 编号 & 说明
	 */
	protected int ItemId;

	/**
	 * @Field Count : 物品数量
	 */
	protected int Count;

	/**
	 * @Field Equip : 是否装备
	 */
	protected int Equip;



}
