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
public class ConfigSundry{
	
	/**
	 * @Field name : 名称
	 */
	protected String name;

	/**
	 * @Field value : 值
	 */
	protected String value;

	/**
	 * @Field talk : 对话
	 */
	protected String talk;

	/**
	 * @Field desc : 说明
	 */
	protected String desc;



}
