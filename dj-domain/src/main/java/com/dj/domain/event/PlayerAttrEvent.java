package com.dj.domain.event;

import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class PlayerAttrEvent extends BaseEvent {

	private PlayerAttrEnum attr;
	
	private long value;
	
	@Override
	protected void resetProperties() {
		attr = null;
		value = 0;
	}
}
