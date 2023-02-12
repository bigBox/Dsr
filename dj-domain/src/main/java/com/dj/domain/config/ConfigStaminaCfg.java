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
public class ConfigStaminaCfg{
	
	/**
	 * @Field Id : Id
	 */
	protected int Id;

	/**
	 * @Field Level : 等级
	 */
	protected int Level;

	/**
	 * @Field RecoverMax : 体力上限
	 */
	protected int RecoverMax;



}
