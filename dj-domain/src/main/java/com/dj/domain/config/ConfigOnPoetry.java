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
public class ConfigOnPoetry{
	
	/**
	 * @Field ID : ID
	 */
	protected int ID;

	/**
	 * @Field talk : 上联
	 */
	protected String talk;

	/**
	 * @Field talkA : 下联A
	 */
	protected String talkA;

	/**
	 * @Field TRUEA : 正误（1正确0错误）
	 */
	protected int TRUEA;

	/**
	 * @Field talkB : 下联B
	 */
	protected String talkB;

	/**
	 * @Field TRUEB : 正误（1正确2错误）
	 */
	protected int TRUEB;

	/**
	 * @Field talkC : 下联C
	 */
	protected String talkC;

	/**
	 * @Field TRUEC : 正误（1正确3错误）
	 */
	protected int TRUEC;



}
