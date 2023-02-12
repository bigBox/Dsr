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
public class ConfigTradeKLine{
	
	/**
	 * @Field ID : 编号 & 说明.类型1、无；2、虚拟物品；3、故事；4奇遇； 5地图碎片；6植物 7陆地动物8水动物9其它
	 */
	protected int ID;

	/**
	 * @Field date : 第几天
	 */
	protected String date;

	/**
	 * @Field startPrice : 开盘价
	 */
	protected int startPrice;

	/**
	 * @Field endPrice : 收盘价
	 */
	protected int endPrice;

	/**
	 * @Field highestPrice : 最高价
	 */
	protected int highestPrice;

	/**
	 * @Field lowestPrice : 最低价
	 */
	protected int lowestPrice;

	/**
	 * @Field turnover : 成交量
	 */
	protected int turnover;



}
