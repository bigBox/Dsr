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
public class ConfigMineInit{
	
	/**
	 * @Field ID : 编号 & 说明
	 */
	protected int ID;

	/**
	 * @Field Row : X（列号） 
	 */
	protected int Row;

	/**
	 * @Field Col : Y(行号) 
	 */
	protected int Col;

	/**
	 * @Field type : 矿产类型(0=出生点,-1:挖完,编号 & 说明101、矿；102五行石矿；103化石；104-地图碎片；09-功能）。109001,109003,109005右边去好友，109002,109004,109006左边去好友。
	 */
	protected int type;



}
