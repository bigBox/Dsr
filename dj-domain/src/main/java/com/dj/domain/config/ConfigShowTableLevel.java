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
public class ConfigShowTableLevel{
	
	/**
	 * @Field Id : 等级
	 */
	protected int Id;

	/**
	 * @Field UpLevelTotalExp : 升所需静态馆藏值
	 */
	protected long UpLevelTotalExp;



}
