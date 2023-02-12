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
public class ConfigExpLevelCfg{
	
	/**
	 * @Field Level : 等级
	 */
	protected int Level;

	/**
	 * @Field UpLevelExp : 该等级升级下一级所需经验,1级初始经验80
	 */
	protected double UpLevelExp;

	/**
	 * @Field UpLevelTotalExp : 当前等级所需总经验
	 */
	protected double UpLevelTotalExp;



}
