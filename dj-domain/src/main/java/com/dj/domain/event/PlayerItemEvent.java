package com.dj.domain.event;

import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;
import com.dj.domain.entity.player.item.IPlayerItem;

import lombok.Data;
import lombok.EqualsAndHashCode;

@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class PlayerItemEvent extends BaseEvent{

	private int col;
	
	private int color;
	
	private IPlayerItem item;
	
	private boolean visible;

	private boolean post2Client;
	
	private boolean itemAdd;

	@Override
	protected void resetProperties() {
		this.col = 0;
		this.color = 0;
		this.item = null;
		visible = false;
		post2Client = false;
		itemAdd = false;
	}
}
