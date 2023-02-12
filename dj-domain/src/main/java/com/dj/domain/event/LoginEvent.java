package com.dj.domain.event;

import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;
import com.dj.domain.entity.player.PlayerRole;

import lombok.Data;
import lombok.EqualsAndHashCode;

@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginEvent extends BaseEvent{
	
	private String account;
	private String password;
	private String ip;

	private PlayerRole playerRole;
	
	private boolean login;
	
	private String channelID;

	@Override
	protected void resetProperties() {
		this.account = null;
		this.password = null;
		this.ip = null;
		this.playerRole = null;
		this.login = false;
		this.channelID = null;
	}
}
