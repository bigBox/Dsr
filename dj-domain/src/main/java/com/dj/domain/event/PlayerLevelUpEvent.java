package com.dj.domain.event;

import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class PlayerLevelUpEvent extends BaseEvent {

	// 现在多少级了
	private int nowLevel;
	// 之前多少级
	private int previousLevel;

	@Override
	protected void resetProperties() {
		nowLevel = 0;
		previousLevel = 0;
	}
}
