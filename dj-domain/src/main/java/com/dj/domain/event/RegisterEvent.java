package com.dj.domain.event;

import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterEvent extends BaseEvent{
	
	private String account;
	private String password;
	
	@Override
	protected void resetProperties() {
		this.account = null;
		this.password = null;
	}
}
