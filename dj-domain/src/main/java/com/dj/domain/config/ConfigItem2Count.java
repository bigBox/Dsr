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
public class ConfigItem2Count{
	
	/**
	 * @Field ID : 编号
	 */
	protected int ID;

	/**
	 * @Field name : 名称
	 */
	protected String name;

	/**
	 * @Field count : 次数
	 */
	protected int count;

	/**
	 * @Field itemID : 父物品id
	 */
	protected int itemID;

	/**
	 * @Field itemCount : 父物品数量
	 */
	protected int itemCount;



}
