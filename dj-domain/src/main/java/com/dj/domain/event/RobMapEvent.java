package com.dj.domain.event;

import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;
import com.dj.domain.config.ConfigRobCfg;
import com.dj.domain.data.game.SceneCellUnit;
import com.dj.domain.util.collection.MapSubMap;

import lombok.Data;
import lombok.EqualsAndHashCode;

@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class RobMapEvent extends BaseEvent {

	private ConfigRobCfg cfg;
	
	private MapSubMap<Integer, Integer, SceneCellUnit> cellMap;

	private int type;
	
	private SceneCellUnit treasureCell;
	
	private SceneCellUnit updateCell;
	
	private SceneCellUnit lightCell;
	
	@Override
	protected void resetProperties() {
		this.cfg = null;
		this.cellMap = null;
		this.type = 0;
		this.treasureCell = null;
		this.updateCell = null;
		this.lightCell = null;
	}
}
