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
public class ConfigManufactureMakeData{
	
	/**
	 * @Field ID : 清单ID4-工业品，3-食品
	 */
	protected int ID;

	/**
	 * @Field name : 加工品名称
	 */
	protected String name;

	/**
	 * @Field factory : 所属建筑ID
	 */
	protected int factory;

	/**
	 * @Field exp : 获得经验
	 */
	protected int exp;

	/**
	 * @Field cookingTime : 制作时间（分）
	 */
	protected int cookingTime;

	/**
	 * @Field levelRequire : 激活等级
	 */
	protected int levelRequire;

	/**
	 * @Field matrial1 : 材料1
	 */
	protected int matrial1;

	/**
	 * @Field num1 : 数量1
	 */
	protected int num1;

	/**
	 * @Field matrial2 : 材料2
	 */
	protected int matrial2;

	/**
	 * @Field num2 : 数量2
	 */
	protected int num2;

	/**
	 * @Field matrial3 : 材料3
	 */
	protected int matrial3;

	/**
	 * @Field num3 : 数量3
	 */
	protected int num3;

	/**
	 * @Field matrial4 : 材料4
	 */
	protected int matrial4;

	/**
	 * @Field num4 : 数量4
	 */
	protected int num4;

	/**
	 * @Field matrial5 : 材料5
	 */
	protected int matrial5;

	/**
	 * @Field num5 : 数量5
	 */
	protected int num5;



}
