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
public class ConfigBook{
	
	/**
	 * @Field bookID : 图鉴ID
	 */
	protected int bookID;

	/**
	 * @Field name : 图鉴物品名称
	 */
	protected String name;

	/**
	 * @Field type : 图鉴类型、1植物，2动物，4鱼类，5宝物，10稀有宝物
	 */
	protected int type;



}
