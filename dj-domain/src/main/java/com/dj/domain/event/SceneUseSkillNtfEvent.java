package com.dj.domain.event;

import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;
import com.dj.domain.data.game.MineRole;
import com.dj.protobuf.scene.SceneUseSkillReq;

import lombok.Data;
import lombok.EqualsAndHashCode;


@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class SceneUseSkillNtfEvent extends BaseEvent {
	
	private String mapOwner;
	
	private SceneUseSkillReq req;
	private MineRole mineRole;
	
	@Override
	protected void resetProperties() {
		mapOwner = null;
		req = null;
		mineRole = null;
	}
}
