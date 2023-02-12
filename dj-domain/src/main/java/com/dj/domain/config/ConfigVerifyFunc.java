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
public class ConfigVerifyFunc{
	
	/**
	 * @Field ID : 功能序号
	 */
	protected int ID;

	/**
	 * @Field resume : 类型5普通10稀有
	 */
	protected int resume;

	/**
	 * @Field verifyTime : 鉴定时间
	 */
	protected int verifyTime;

	/**
	 * @Field exp : 增加经验
	 */
	protected int exp;

	/**
	 * @Field pro_A : 完美概率
	 */
	protected int pro_A;

	/**
	 * @Field pro_B : 破损概率
	 */
	protected int pro_B;

	/**
	 * @Field pro_C : 残破概率
	 */
	protected int pro_C;



}
