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
public class GuildChangeNameEvent extends BaseEvent implements ITopicEvent {

	/**
	 *	商会id
	 */
	private long guildID;
	/**
	 *	商会名称
	 */
	private String name;

	@Override
	protected void resetProperties() {
		guildID = 0;
		name = null;
	}

	@Override
	public String getTopic() {
		return ConstantTopic.TOPIC_GUILD_CHANGE_NAME;
	}
}
