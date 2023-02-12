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
public class ConfigRobTreasure{
	
	/**
	 * @Field ID : 编号 & 说明。第一个1无意义（让后面好出现001），001塞外江南，002茶马古道。。。，第一个01表示第二层，再一个05表示出宝，后面是指定地图指定层的具体产出编号.101:第一轮必出稀有概率。第二轮（出2-8个宝物 ）901出所有宝物概率。
	 */
	protected String ID;

	/**
	 * @Field mapID : 所属古迹ID
	 */
	protected int mapID;

	/**
	 * @Field floor : 地图层数
	 */
	protected int floor;

	/**
	 * @Field itemGet : 产出ID
	 */
	protected int itemGet;

	/**
	 * @Field weight : 概率
	 */
	protected int weight;



}
