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
public class ConfigObstacles{
	
	/**
	 * @Field ID : 序列
	 */
	protected int ID;

	/**
	 * @Field type : 类型
	 */
	protected int type;

	/**
	 * @Field isOpen : 默认是否开启
	 */
	protected int isOpen;



}
