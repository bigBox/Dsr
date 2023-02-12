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
public class ConfigItemEffect{
	
	/**
	 * @Field ID : 编号 & 说明 （头两位大类型，第3-5位主要来源）10矿产，11普通种子，12珍稀种子，13、其它植物，16农田植物，17生态园植物，22普通幼崽23水产种24普通动物收成25水产收成26珍稀动物27观赏鱼30食材31菜品32乳制品33饮品34面点（工业）40非食品制作基材41装备42饲料43服饰44工艺品（宝物）50-宝物（非字画），51字画，52标本（化石），60消耗道具61碎片（字）62特效道具（密阁），998其它,999商店70虚拟物品71地图碎片72地图碎片的子碎片80-宝贝90-消耗性道具。
	 */
	protected int ID;

	/**
	 * @Field name : 名字。普通宝物为仓库排版方便，空增了不使用的普通宝物的瑕、残品相物品。
	 */
	protected String name;

	/**
	 * @Field prop1 : 闪避落石概率
	 */
	protected int prop1;

	/**
	 * @Field prop2 : 落石减伤
	 */
	protected int prop2;

	/**
	 * @Field prop3 : 闪避火概率
	 */
	protected int prop3;

	/**
	 * @Field prop4 : 火减伤
	 */
	protected int prop4;

	/**
	 * @Field prop5 : 闪避水概率
	 */
	protected int prop5;

	/**
	 * @Field prop6 : 水减伤
	 */
	protected int prop6;

	/**
	 * @Field prop7 : 闪避毒概率
	 */
	protected int prop7;

	/**
	 * @Field prop8 : 毒减伤
	 */
	protected int prop8;

	/**
	 * @Field prop9 : 展厅结算Y/N
	 */
	protected int prop9;

	/**
	 * @Field prop10 : 恢复体力Y/N
	 */
	protected int prop10;

	/**
	 * @Field prop11 : 恢复气力Y/N
	 */
	protected int prop11;

	/**
	 * @Field prop12 : 产量增加%
	 */
	protected int prop12;

	/**
	 * @Field prop13 : 制作CD减小
	 */
	protected int prop13;



}
