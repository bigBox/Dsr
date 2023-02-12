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
public class ConfigRobFunc{
	
	/**
	 * @Field ID : 功能序号
	 */
	protected int ID;

	/**
	 * @Field matrial1 : 产出物品1、无；2、虚拟物品；3、奇遇；5、宝物；6、珍稀植物；7、珍稀动物；8、珍稀鱼；9、鸟（原标本）；10、稀有宝物；11、火陷阱；12、落石陷阱；13、水陷阱；14、毒陷阱;15、毒虫陷阱;16、大火、大落石、大水、大毒、大虫。
	 */
	protected String matrial1;

	/**
	 * @Field pro : 出现概率
	 */
	protected int pro;

	/**
	 * @Field cost : 单次行动值消耗
	 */
	protected int cost;

	/**
	 * @Field positionY : 点击位置偏移
	 */
	protected int positionY;



}
