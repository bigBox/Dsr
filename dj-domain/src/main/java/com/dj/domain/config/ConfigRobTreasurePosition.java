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
public class ConfigRobTreasurePosition{
	
	/**
	 * @Field ID : 编号
	 */
	protected int ID;

	/**
	 * @Field mapID : 所属古迹ID
	 */
	protected int mapID;

	/**
	 * @Field floor : 地图层数
	 */
	protected int floor;

	/**
	 * @Field Row : 行号y
	 */
	protected int Row;

	/**
	 * @Field Col : 列号x
	 */
	protected int Col;

	/**
	 * @Field Birth : 是否可以作为出生点 0不可以 1 可以
	 */
	protected int Birth;



}
