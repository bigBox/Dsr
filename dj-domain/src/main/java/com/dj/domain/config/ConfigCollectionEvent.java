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
public class ConfigCollectionEvent{
	
	/**
	 * @Field ID : 20220831简化定义：500001宝物，510001字画，520001珍稀花草，530001珍稀动物，编号 & 说明 （头两位大类型，第3-5位主要来源）10矿产，11普通种子，12珍稀种子，13、其它植物，16农田植物，17生态园植物，22普通幼崽23水产种24普通动物收成25水产收成26珍稀动物27观赏鱼30食材31菜品32乳制品33饮品34面点（工业）40非食品制作基材41装备42饲料43服饰44工艺品（宝物）50-宝物（非字画），51字画，52标本（化石），60消耗道具61碎片（字），62特效道具（密阁），998其它,999商店70虚拟物品7001塞外江南，70011塞外江南子地图孙碎片70012孙碎片73整张地图80-宝贝90-消耗性道具。
	 */
	protected int ID;

	/**
	 * @Field name : 游戏名称
	 */
	protected String name;

	/**
	 * @Field type : 产出物品1、无；2、虚拟物品；3、奇遇；5、宝物；6、珍稀植物；7、珍稀动物；8、珍稀鱼；9、鸟（原标本）；10、稀有宝物、宝贝；11、火陷阱；12、落石陷阱；13、水陷阱；14、毒陷阱;15、毒虫陷阱;16、大火、大落石、大水、大毒、大虫。
	 */
	protected int type;

	/**
	 * @Field scene_1 : 塞外江南
	 */
	protected int scene_1;

	/**
	 * @Field scene_2 : 茶马古道
	 */
	protected int scene_2;

	/**
	 * @Field scene_3 : 西夏风光
	 */
	protected int scene_3;

	/**
	 * @Field scene_4 : 楼兰古图
	 */
	protected int scene_4;

	/**
	 * @Field scene_101 : 秋香
	 */
	protected int scene_101;

	/**
	 * @Field scene_102 : 唐百虎
	 */
	protected int scene_102;

	/**
	 * @Field scene_103 : 石榴姐
	 */
	protected int scene_103;

	/**
	 * @Field scene_104 : 胡蝶
	 */
	protected int scene_104;

	/**
	 * @Field scene_105 : 杜约申
	 */
	protected int scene_105;

	/**
	 * @Field scene_106 : 李书童
	 */
	protected int scene_106;

	/**
	 * @Field scene_107 : 小混混
	 */
	protected int scene_107;

	/**
	 * @Field scene_108 : 沈万山
	 */
	protected int scene_108;

	/**
	 * @Field scene_109 : 西施
	 */
	protected int scene_109;

	/**
	 * @Field scene_110 : 建文帝
	 */
	protected int scene_110;

	/**
	 * @Field scene_211 : 低金精灵
	 */
	protected int scene_211;

	/**
	 * @Field scene_212 : 低木精灵
	 */
	protected int scene_212;

	/**
	 * @Field scene_213 : 低水精灵
	 */
	protected int scene_213;

	/**
	 * @Field scene_214 : 低火精灵
	 */
	protected int scene_214;

	/**
	 * @Field scene_215 : 低土精灵
	 */
	protected int scene_215;

	/**
	 * @Field scene_221 : 初金精灵
	 */
	protected int scene_221;

	/**
	 * @Field scene_222 : 初木精灵
	 */
	protected int scene_222;

	/**
	 * @Field scene_223 : 初水精灵
	 */
	protected int scene_223;

	/**
	 * @Field scene_224 : 初火精灵
	 */
	protected int scene_224;

	/**
	 * @Field scene_225 : 初土精灵
	 */
	protected int scene_225;

	/**
	 * @Field scene_231 : 中金精灵
	 */
	protected int scene_231;

	/**
	 * @Field scene_232 : 中木精灵
	 */
	protected int scene_232;

	/**
	 * @Field scene_233 : 中水精灵
	 */
	protected int scene_233;

	/**
	 * @Field scene_234 : 中火精灵
	 */
	protected int scene_234;

	/**
	 * @Field scene_235 : 中土精灵
	 */
	protected int scene_235;

	/**
	 * @Field scene_241 : 高金精灵
	 */
	protected int scene_241;

	/**
	 * @Field scene_242 : 高木精灵
	 */
	protected int scene_242;

	/**
	 * @Field scene_243 : 高水精灵
	 */
	protected int scene_243;

	/**
	 * @Field scene_244 : 高火精灵
	 */
	protected int scene_244;

	/**
	 * @Field scene_245 : 高土精灵
	 */
	protected int scene_245;



}
