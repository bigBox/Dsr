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
public class ConfigShowTableCost{
	
	/**
	 * @Field Id : Id
	 */
	protected int Id;

	/**
	 * @Field index : 第几个展厅 
	 */
	protected int index;

	/**
	 * @Field cost : 金币费用
	 */
	protected int cost;

	/**
	 * @Field viewers : 参观人数
	 */
	protected int viewers;



}
