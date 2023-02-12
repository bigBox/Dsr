package com.dj.domain.event;

import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;
import com.dj.domain.data.game.MineRole;

import lombok.Data;
import lombok.EqualsAndHashCode;

@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class JoinSceneNtfEvent extends BaseEvent {

	private String mapOwner;

	private MineRole mineRole;

	@Override
	protected void resetProperties() {
		mapOwner = null;
		mineRole = null;
	}
}
