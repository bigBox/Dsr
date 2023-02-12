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
public class ConfigNewRoleShowTableItem{
	
	/**
	 * @Field Id : Id(保证唯一就行)
	 */
	protected int Id;

	/**
	 * @Field ItemId : 编号 & 说明
	 */
	protected int ItemId;

	/**
	 * @Field index : 存放位置
	 */
	protected int index;

	/**
	 * @Field type : 展架类型 0:宝物; 1:水族馆; 2:标本;3:字画
	 */
	protected int type;

	/**
	 * @Field page : 分页
	 */
	protected int page;

	/**
	 * @Field x : 水平位移
	 */
	protected int x;

	/**
	 * @Field y : 垂直位移
	 */
	protected int y;



}
