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
public class ConfigEventList{
	
	/**
	 * @Field ID : 编号 & 说明
	 */
	protected int ID;

	/**
	 * @Field type : 类型：30故事； 40奇遇（神仙）；50（鬼怪）；60陷阱； 
	 */
	protected int type;

	/**
	 * @Field weight : 概率
	 */
	protected int weight;



}
