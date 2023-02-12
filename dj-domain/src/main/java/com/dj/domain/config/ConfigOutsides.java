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
public class ConfigOutsides{
	
	/**
	 * @Field ID : 编号 & 说明.类型1、无；2、虚拟物品；3、故事；4奇遇； 5地图碎片；6植物 7陆地动物8水动物9其它
	 */
	protected int ID;

	/**
	 * @Field itemGet : 探险参数
	 */
	protected int itemGet;

	/**
	 * @Field type : 类型1、无；2、虚拟物品；3、故事；4奇遇； 5地图碎片；6植物 7陆地动物8水动物
	 */
	protected int type;

	/**
	 * @Field exp : 经验奖励
	 */
	protected int exp;

	/**
	 * @Field weight : 概率权重
	 */
	protected int weight;



}
