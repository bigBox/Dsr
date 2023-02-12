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
public class ConfigRobCfg{
	
	/**
	 * @Field ID : 编号 & 说明
	 */
	protected int ID;

	/**
	 * @Field name : 古墓名称
	 */
	protected String name;

	/**
	 * @Field levelLimit : 等级限制
	 */
	protected int levelLimit;

	/**
	 * @Field row : 行数
	 */
	protected int row;

	/**
	 * @Field col : 列数
	 */
	protected int col;

	/**
	 * @Field nameItemID : 大图名字
	 */
	protected int nameItemID;

	/**
	 * @Field inputItemId : 需要地图碎片ID1塞外江南2茶马古道3龟兹古迹4楼兰古城5西夏皇陵6蒙古王庭
	 */
	protected int inputItemId;

	/**
	 * @Field inputItemNum : 地图碎片消耗的数量区间 例如从700101001~700101006
	 */
	protected int inputItemNum;

	/**
	 * @Field inputGoldNum : 需消耗金币
	 */
	protected int inputGoldNum;

	/**
	 * @Field actionValue : 初始气力（行动值）
	 */
	protected int actionValue;

	/**
	 * @Field weight : 0-空 1-树 2-草 3-石 4-水草 5-废墟 均衡版配置
	 */
	protected String weight;

	/**
	 * @Field feature : 1-均衡版 2-密林版 3-草地版 4-石林版 5-废墟版
	 */
	protected String feature;

	/**
	 * @Field RobID : 初始表ID初始位置
	 */
	protected int RobID;



}
