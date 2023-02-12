package com.dj.domain.data;

import java.util.Map;

import com.dj.domain.data.game.SceneCellUnit;
import com.dj.protobuf.common.SceneUpdateType;
import com.dj.domain.util.collection.MapSubMap;
import com.google.common.collect.Maps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RobMap {

	private long roleID;

	private MapSubMap<Integer, Integer, SceneCellUnit> cellMap = new MapSubMap<Integer, Integer, SceneCellUnit>();

	/**
	 *	大宝
	 */
	private SceneCellUnit treasureCell;

	/**
	 * Sculpture雕像
	 */
	private SceneCellUnit sculptureCell;
	/**
	 * Sculpture_Monster雕像
	 */
	private SceneCellUnit sculptureMonsterCell;

	private SceneCellUnit updateCell;

	private int mapId;
	private int enterCondition;
	private int floor;
	/**
	 *	初始气力值
	 */
	private int actionValue;

	/**
	 *	场景更新类型
	 */
	private int type;

	// 上次与大宝的距离
	private int lastDis;
	//出生点 X
	private int birthX;
	//出生点 Y
	private int birthY;
	
	// 新手引导探宝次数
	private int guideCount;
	
	// 携带的道具，可避免陷阱伤害
	private Map<Integer, Integer> trapItem = Maps.newHashMap();
	
	

	public void reset(int mapId, int enterCondition, int floor, int actionValue) {
		cellMap.clear();
		treasureCell = null;
		sculptureCell = null;
		sculptureMonsterCell = null;
		updateCell = null;
		this.mapId = mapId;
		this.enterCondition = enterCondition;
		this.floor = floor;
		this.actionValue = actionValue;
		type = SceneUpdateType.Total_VALUE;
		lastDis = 0;
		birthX = 0;
		birthY = 0;
		guideCount = 0;
		trapItem.clear();
	}
}
