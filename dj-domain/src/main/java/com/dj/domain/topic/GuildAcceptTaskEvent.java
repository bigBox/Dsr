package com.dj.domain.topic;

import com.dj.domain.constant.ConstantTopic;
import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;
import com.dj.domain.base.ITopicEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class GuildAcceptTaskEvent extends BaseEvent implements ITopicEvent {
	private long guildID;

	private int taskID;

	private int index;

	@Override
	protected void resetProperties() {
		taskID = 0;
	}

	@Override
	public String getTopic() {
		return ConstantTopic.TOPIC_GUILD_ACCEPT_TASK;
	}
}
