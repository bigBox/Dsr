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
public class ConfigExchangeMall{
	
	/**
	 * @Field ID : 编号 & 说明
	 */
	protected int ID;

	/**
	 * @Field inputItemId : 消耗物品ID
	 */
	protected int inputItemId;

	/**
	 * @Field inputItemNum : 消耗物品数量
	 */
	protected int inputItemNum;

	/**
	 * @Field targetItemId : 兑换目标物品ID
	 */
	protected int targetItemId;

	/**
	 * @Field targetItemNum : 兑换目标物品数量
	 */
	protected int targetItemNum;



}
