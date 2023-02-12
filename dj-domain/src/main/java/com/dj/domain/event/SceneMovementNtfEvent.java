package com.dj.domain.event;

import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;
import com.dj.protobuf.scene.SceneMovementReq;

import lombok.Data;
import lombok.EqualsAndHashCode;


@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class SceneMovementNtfEvent extends BaseEvent {
	
	private String mapOwner;
	
	private SceneMovementReq req;
	
	@Override
	protected void resetProperties() {
		mapOwner = null;
		req = null;
	}
}
