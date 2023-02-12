package com.dj.serverapi.service.inf;

import com.dj.domain.data.MonthCard;
import com.dj.domain.data.NpcSkill;
import com.dj.protobuf.buffer.EDrawTodayType;

public interface IBuffService {

	/**
	 *	获取月卡信息
	 * 
	 * @param roleID
	 * @return
	 */
	MonthCard getMonthCard(long roleID);

	/**
	 *	更新月卡时间
	 * 
	 * @param roleID
	 * @param count
	 */
	MonthCard updateMonthCardTime(long roleID, long count);

	/**
	 *	更新当天领取状态
	 * 
	 * @param roleID
	 * @param type
	 * @param draw
	 */
	MonthCard updateMonthCardDraw(long roleID, EDrawTodayType type, boolean draw);
	
	
	void repairMonthCard(long roleID);
	
	/**
	 * 获取npc技能
	 * @param roleID
	 * @return
	 */
	NpcSkill getNpcSkill(long roleID);
	
	/**
	 * 设置npc技能
	 * @param roleID
	 * @param skillID
	 */
	void setNpcSkill(long roleID, int npcID, int skillID);
}
