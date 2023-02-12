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
public class ConfigTradeItems{
	
	/**
	 * @Field ID : 编号 & 说明
	 */
	protected int ID;

	/**
	 * @Field itemName : 物品名
	 */
	protected String itemName;

	/**
	 * @Field name : 内部文件名
	 */
	protected String name;

	/**
	 * @Field type : 归类1植物2动物3食品4工业5宝物6道具
	 */
	protected int type;

	/**
	 * @Field placeType : 交易所类型1宝物2珍稀物品3道具
	 */
	protected int placeType;



}
