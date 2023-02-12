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
public class ConfigSummonOutput{
	
	/**
	 * @Field ID : 编号 & 说明.第一个1无意义（让后面好出现001），101无，102金币，103奇遇，104陷阱，105奇珍，106植物，107兽，108鱼，109鸟，110异宝，111投资项目
	 */
	protected int ID;

	/**
	 * @Field itemGet : 古迹参数
	 */
	protected int itemGet;

	/**
	 * @Field type : 类型1、无；2、虚拟物品；3、奇遇； 4、陷阱；5、宝物；6、珍稀植物；7、珍稀动物；8、珍稀鱼；9、鸟；10-异宝;11-投资。
	 */
	protected int type;

	/**
	 * @Field exp : 经验奖励
	 */
	protected int exp;

	/**
	 * @Field weight : 概率
	 */
	protected int weight;



}
