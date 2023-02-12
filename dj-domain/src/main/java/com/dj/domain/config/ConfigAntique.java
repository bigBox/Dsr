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
public class ConfigAntique{
	
	/**
	 * @Field Id : 套装ID50-宝物（非字画），51字画，52观赏鱼，53珍稀动物（陆地），54化石，55标本
	 */
	protected int Id;

	/**
	 * @Field num : 套装子图数量
	 */
	protected int num;

	/**
	 * @Field composeID : 合成物ID,类型为3时用
	 */
	protected int composeID;

	/**
	 * @Field composeName : 合成物名称
	 */
	protected String composeName;

	/**
	 * @Field sub1 : 子图1ID
	 */
	protected int sub1;

	/**
	 * @Field sub2 : 子图2ID
	 */
	protected int sub2;

	/**
	 * @Field sub3 : 子图3ID
	 */
	protected int sub3;

	/**
	 * @Field sub4 : 子图4ID
	 */
	protected int sub4;

	/**
	 * @Field sub5 : 子图5ID
	 */
	protected int sub5;

	/**
	 * @Field sub6 : 子图6ID
	 */
	protected int sub6;

	/**
	 * @Field sub7 : 子图7ID
	 */
	protected int sub7;



}
