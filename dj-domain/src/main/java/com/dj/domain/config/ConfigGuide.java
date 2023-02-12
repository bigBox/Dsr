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
public class ConfigGuide{
	
	/**
	 * @Field ID : 工厂ID
	 */
	protected int ID;

	/**
	 * @Field name : 工厂名字
	 */
	protected String name;

	/**
	 * @Field type : 类型关键字
	 */
	protected String type;

	/**
	 * @Field filePath : 资源路径
	 */
	protected String filePath;

	/**
	 * @Field prefabFile : 预建体路径
	 */
	protected String prefabFile;

	/**
	 * @Field guideKey : 关键字
	 */
	protected String guideKey;

	/**
	 * @Field arg : 参数
	 */
	protected int arg;

	/**
	 * @Field guideTip : 提示
	 */
	protected String guideTip;

	/**
	 * @Field dec : 描述
	 */
	protected String dec;



}
