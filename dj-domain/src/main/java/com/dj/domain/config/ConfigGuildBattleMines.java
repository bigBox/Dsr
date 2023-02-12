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
public class ConfigGuildBattleMines{
	
	/**
	 * @Field ID : ID
	 */
	protected int ID;

	/**
	 * @Field Level : 矿产等级 
	 */
	protected int Level;

	/**
	 * @Field Name : 名称
	 */
	protected String Name;

	/**
	 * @Field Score : 每秒产生积分
	 */
	protected double Score;

	/**
	 * @Field Count : 初始数量
	 */
	protected int Count;



}
