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
public class ConfigReputationLevel{
	
	/**
	 * @Field Id : 等级
	 */
	protected int Id;

	/**
	 * @Field UpLevelExp : 该等级升级下一级所需声望,1级初始经验80
	 */
	protected long UpLevelExp;

	/**
	 * @Field UpLevelTotalExp : 升级到当前等级所需总声望
	 */
	protected long UpLevelTotalExp;



}
