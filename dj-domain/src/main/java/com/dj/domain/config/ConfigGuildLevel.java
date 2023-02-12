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
public class ConfigGuildLevel{
	
	/**
	 * @Field Level : 等级
	 */
	protected int Level;

	/**
	 * @Field UpLevelExp : 该等级升级下一级所需经验,1级初始经验80
	 */
	protected double UpLevelExp;

	/**
	 * @Field UpLevelTotalExp : 升级到当前等级所需总经验
	 */
	protected double UpLevelTotalExp;

	/**
	 * @Field memberLimit : 人口上限
	 */
	protected int memberLimit;



}
