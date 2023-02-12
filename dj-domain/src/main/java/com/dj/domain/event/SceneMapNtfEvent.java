package com.dj.domain.event;

import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;
import com.dj.domain.data.game.SceneCellUnit;
import com.dj.protobuf.common.SceneUpdateType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class SceneMapNtfEvent extends BaseEvent {
	
	private String mapOwner;
	
	private SceneUpdateType type;
	
	private List<SceneCellUnit> list;
	
	@Override
	protected void resetProperties() {
		mapOwner = null;
		type = null;
		list = null;
	}
}
