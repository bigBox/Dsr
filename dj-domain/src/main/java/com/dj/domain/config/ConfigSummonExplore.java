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
public class ConfigSummonExplore{
	
	/**
	 * @Field ID : 功能序号
	 */
	protected int ID;

	/**
	 * @Field funcName : 功能名称
	 */
	protected String funcName;

	/**
	 * @Field matrial1 : 产出物品1、无；2、虚拟物品；3、奇遇； 4、陷阱；5、奇珍（原宝物）；6、珍稀植物；7、珍稀动物；8、珍稀鱼；9、鸟（原标本）；10-稀有宝物。
	 */
	protected String matrial1;

	/**
	 * @Field pro : 出现概率
	 */
	protected int pro;

	/**
	 * @Field invest : 是否投资事件.0-非投资，1-投资。
	 */
	protected int invest;

	/**
	 * @Field investTime : 倒计时时长（秒）
	 */
	protected int investTime;

	/**
	 * @Field investGold : 投资金币
	 */
	protected int investGold;



}
