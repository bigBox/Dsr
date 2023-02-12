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
public class GuildApplyEvent extends BaseEvent implements ITopicEvent {

	private long guildId;
	
	/**
	 *	会长
	 */
	private long chairman;

	@Override
	protected void resetProperties() {
		guildId = 0;
		chairman = 0;
	}

	@Override
	public String getTopic() {
		return ConstantTopic.TOPIC_GUILD_APPLY;
	}
}
