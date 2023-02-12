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
public class ConfigVerifyItems{
	
	/**
	 * @Field ID : 功能序号
	 */
	protected int ID;

	/**
	 * @Field itemA : 完美宝物ID
	 */
	protected int itemA;

	/**
	 * @Field itemB : 瑕疵宝物ID
	 */
	protected int itemB;

	/**
	 * @Field itemC : 破损宝物ID
	 */
	protected int itemC;

	/**
	 * @Field itemD : 残缺宝物ID
	 */
	protected int itemD;



}
