package com.dj.domain.event;

import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class NpcSkillEvent extends BaseEvent{
	
	private int npcID;
	private int skillID;
	
	@Override
	protected void resetProperties() {
		this.npcID = 0;
		this.skillID = 0;
	}
}
