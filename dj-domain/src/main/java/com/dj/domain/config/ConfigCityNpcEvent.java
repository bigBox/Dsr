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
public class ConfigCityNpcEvent{
	
	/**
	 * @Field ID : ID人物
	 */
	protected int ID;

	/**
	 * @Field npc : 人物 0没有人、1秋香、2唐伯虎、3石榴姐、4胡蝶、5杜约申、6李书童、7小混混、8沈万山、9西施、10建文帝
	 */
	protected int npc;

	/**
	 * @Field event : 事件 100没有人，101对诗，102赛马，103要金币，104要东西，105打劫，106赞美NPC
	 */
	protected int event;

	/**
	 * @Field explian : 说明
	 */
	protected String explian;



}
