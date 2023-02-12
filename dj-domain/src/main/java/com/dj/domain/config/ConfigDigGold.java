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
public class ConfigDigGold{
	
	/**
	 * @Field ID : 编号
	 */
	protected int ID;

	/**
	 * @Field type : 类型 & 说明100钻石；101、矿；102五行石矿；103化石；104地图孙碎片；109-功能
	 */
	protected int type;

	/**
	 * @Field itemGet : 获得物品
	 */
	protected int itemGet;

	/**
	 * @Field digNum : 储量
	 */
	protected int digNum;

	/**
	 * @Field digPerTime : 单次挖掘时间（毫秒）
	 */
	protected int digPerTime;

	/**
	 * @Field weight : 权重
	 */
	protected int weight;

	/**
	 * @Field exp : 经验奖励
	 */
	protected double exp;

	/**
	 * @Field cost : 单次体力消耗
	 */
	protected int cost;



}
