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
public class ConfigNewRoleShowTableInfo{
	
	/**
	 * @Field Id : Id(保证唯一就行)
	 */
	protected int Id;

	/**
	 * @Field page : 分页
	 */
	protected int page;

	/**
	 * @Field info : 数据
	 */
	protected String info;



}
