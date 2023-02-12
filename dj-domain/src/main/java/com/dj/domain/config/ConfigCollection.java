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
public class ConfigCollection{
	
	/**
	 * @Field Id : 图鉴ID50-宝物（非字画），51字画，52观赏鱼，53珍稀动物（陆地），54化石，55标本。器皿和鱼可以是5个，字画、标本是4个或8个---展厅显示问题。
	 */
	protected int Id;

	/**
	 * @Field stage : 属性1 只有亮2有亮有美
	 */
	protected int stage;

	/**
	 * @Field num : 图鉴数量
	 */
	protected int num;



}
