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
public class ConfigItems{
	
	/**
	 * @Field ID : 20220831简化定义：500001宝物，510001字画，520001珍稀花草，530001珍稀动物，编号&说明（头两位大类型，第3-5位主要来源）10矿产，11普通种子，12珍稀种子，13、其它植物，16农田植物，17生态园植物，22普通幼崽23水产种24普通动物收成25水产收成26珍稀动物27观赏鱼30食材31菜品32乳制品33饮品34面点（工业）40非食品制作基材41装备42饲料43服饰44工艺品（宝物）50-宝物（非字画），51字画，52标本（化石），60消耗道具61碎片（字），62特效道具（密阁），998其它,999商店70虚拟物品7001塞外江南，70011塞外江南子地图孙碎片70012孙碎片73整张地图80-宝贝90-消耗性道具。
	 */
	protected int ID;

	/**
	 * @Field name : 游戏名称
	 */
	protected String name;

	/**
	 * @Field resume : 内部名称。普通宝物为仓库排版方便，空增了不使用的普通宝物的瑕、残品相物品。
	 */
	protected String resume;

	/**
	 * @Field isRare : 是否稀有2
	 */
	protected int isRare;

	/**
	 * @Field color : 品相（1未鉴定2完美3瑕疵4破损5残破）
	 */
	protected int color;

	/**
	 * @Field verify : 对应未鉴定
	 */
	protected int verify;

	/**
	 * @Field isSeed : 是否种子/幼崽1是
	 */
	protected int isSeed;

	/**
	 * @Field warehouseType : 存放1：1植物，2动物，3食品，4工业，5收集品，6道具，7宝贝，31没有数量基础物品,100不进仓库的物品
	 */
	protected int warehouseType;

	/**
	 * @Field subType : 存放2UI-（植物）01种子02普通（作物）（主农田+水果）03稀有植物（动物）06畜产07陆地08飞行10水（食品）11食材12菜品13饮品14甜品（工业）16基材17工具（含饲料）18服饰19工艺品20装备（宝物）21陶瓷22玉石23金朩24杂（字画）25字画（道具）26元素（字、五行石等）27秘效（秘阁）28消耗（月卡加速卡等）29装饰（含装饰性花草，正规种的只能在田里，不能到处放）30综合（实体)31建筑材料
	 */
	protected int subType;

	/**
	 * @Field parkItemType : 生态园类型1花草2树3养殖4珍稀5鱼塘
	 */
	protected int parkItemType;

	/**
	 * @Field buildingType1 : 来源1-1矿2采集（大地图）3野外（古迹）4农田5鱼塘6生态园（原6花卉7主页种8渔场9宠物（如孔雀-孔雀毛，金鱼-珍珠））10上海菜馆；11湘菜馆；19十大菜系馆；20面油厂；21糖吧；22调味品厂；23乳品厂24炼炉；25铁匠铺；26酒厂；27工坊（非铁匠铺）28饲料厂29精练室30纺织厂31鞋帽厂32服装厂33饰品厂34饮品吧35蜂蜜场36面包坊37生态园38炼丹炉999商店998商会商店岛997非标996合成；
	 */
	protected int buildingType1;

	/**
	 * @Field recyclePrice : 面值
	 */
	protected int recyclePrice;

	/**
	 * @Field gold : 金币交易价格
	 */
	protected int gold;

	/**
	 * @Field diamond : 钻石交易价格
	 */
	protected int diamond;

	/**
	 * @Field showtableType : 是否触发套装。1、套装；2、合成（可合成是套装的特殊形式）3；合成物。
	 */
	protected int showtableType;

	/**
	 * @Field antiqueId : 套装ID
	 */
	protected String antiqueId;

	/**
	 * @Field antiqueOrder : 套装内序列
	 */
	protected int antiqueOrder;

	/**
	 * @Field collectionId : 图鉴ID
	 */
	protected int collectionId;

	/**
	 * @Field stateId : 图鉴内序列
	 */
	protected int stateId;

	/**
	 * @Field state : 图鉴等级1发现2完善
	 */
	protected int state;

	/**
	 * @Field antiqueIndex : 大字画内序列
	 */
	protected int antiqueIndex;

	/**
	 * @Field speedUp : 加速时间加速分钟数
	 */
	protected int speedUp;



}
