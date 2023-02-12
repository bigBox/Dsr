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
public class ConfigTrapEvent{
	
	/**
	 * @Field ID : ID
	 */
	protected int ID;

	/**
	 * @Field name : 名字
	 */
	protected String name;

	/**
	 * @Field type : 类型1、无；2、虚拟物品；3、奇遇； 4、陷阱；5、宝物；6、珍稀植物；7、珍稀兽；8、珍稀鱼；9、珍稀鸟；10、宝贝；11-火陷阱；12-荣誉感陷阱；13-水陷阱；14-毒陷阱。
	 */
	protected int type;

	/**
	 * @Field exp : 经验奖励
	 */
	protected double exp;

	/**
	 * @Field weight : 概率
	 */
	protected int weight;

	/**
	 * @Field actionValue : 气力伤害
	 */
	protected int actionValue;

	/**
	 * @Field trapItem : 避免陷阱伤害道具
	 */
	protected int trapItem;



}
