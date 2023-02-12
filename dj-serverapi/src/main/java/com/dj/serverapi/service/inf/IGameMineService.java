package com.dj.serverapi.service.inf;

import java.util.List;

import com.dj.domain.data.game.SceneCellUnit;

public interface IGameMineService {

	/**
	 *	重置矿区
	 * @param roleID
	 */
	long resetMine(long roleID);

	/**
	 *	获取玩家矿地图数据
	 * 
	 * @param roleID
	 * @return
	 */
	List<SceneCellUnit> getMineCellList(long roleID);

	/**
	 *	获取自己小寻的矿地图数据
	 * 
	 * @param roleID
	 * @return
	 */
	List<SceneCellUnit> getMineCellXXList(long roleID);

	/**
	 *	开始挖矿
	 * 
	 * @param roleID
	 * @param mapOwner
	 * @param x
	 * @param y
	 */
	void userSkillStart(long roleID, long mapOwner, boolean isXX, int x, int y);

	/**
	 *	结束挖矿
	 * 
	 * @param roleID
	 * @param mapOwner
	 * @param x
	 * @param y
	 * @return
	 */
	List<SceneCellUnit> userSkillCancel(long roleID, long mapOwner, boolean isXX, int x, int y);
	
	/**
	 * 触发npc技能
	 * @param roleID
	 */
	void triggerNpcSkill(long roleID);
}
