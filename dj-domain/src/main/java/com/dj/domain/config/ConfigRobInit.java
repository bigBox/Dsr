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
public class ConfigRobInit{
	
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
	 * @Field Col : 列号x
	 */
	protected int Col;

	/**
	 * @Field Row : 行号y
	 */
	protected int Row;

	/**
	 * @Field type : 地图类型(100=陆地；200=水；99-不可探险)
	 */
	protected int type;

	/**
	 * @Field cellTypeLandforms : 特殊type类型的地貌
	 */
	protected String cellTypeLandforms;

	/**
	 * @Field matrial1 : 古迹产出ID
	 */
	protected int matrial1;

	/**
	 * @Field enterCondtion : 进入条件。1老玩家出生点；2鱼任务；3蝴蝶、上河图、盆景综合
	 */
	protected int enterCondtion;

	/**
	 * @Field isTreasurePos : 是否大宝点：1是0不是
	 */
	protected int isTreasurePos;



}
