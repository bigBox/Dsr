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
public class ConfigMiniMall{
	
	/**
	 * @Field Id : 编号：1钻石商店，2积分商店
	 */
	protected int Id;

	/**
	 * @Field ItemId : 道具模板id
	 */
	protected int ItemId;

	/**
	 * @Field NumPerPackage : 物品数量
	 */
	protected int NumPerPackage;

	/**
	 * @Field Price : 价格(钻石)
	 */
	protected int Price;

	/**
	 * @Field guildScore : 价格（商会积分）
	 */
	protected int guildScore;

	/**
	 * @Field money : 价格(RMB)
	 */
	protected int money;

	/**
	 * @Field payment : 支付方式(0钻石1人民币2商户积分)
	 */
	protected String payment;



}
