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
public class ConfigFactory{
	
	/**
	 * @Field ID : 工厂ID来源1-1矿2大地图3古迹4仙岛5农田6花卉7主页种8渔场9宠物（如孔雀-孔雀毛，金鱼-珍珠）10上海菜馆；19十大菜系馆；20面油厂；21糖吧；22酱厂；23乳品厂24炼炉；25铁匠铺；26酒厂；27工坊（非铁匠铺）28饲料厂29精练室 30纺织厂31鞋帽厂32服装厂33饰品厂34饮品吧35蜂蜜场36商店37商会商店37仙岛；
	 */
	protected int ID;

	/**
	 * @Field levelRequire : 激活等级
	 */
	protected int levelRequire;

	/**
	 * @Field showLevel : 建筑状态:-1 不会自动显示,要用户根据levelRequire在栅栏里面拖,等于0代表账号创建之后自动生成并且不可挪动的建筑，大于0表示到了多少等级会自动显示在对应的场景里面可以挪动的建筑
	 */
	protected int showLevel;

	/**
	 * @Field x : X坐标
	 */
	protected int x;

	/**
	 * @Field y : Y坐标
	 */
	protected int y;



}
