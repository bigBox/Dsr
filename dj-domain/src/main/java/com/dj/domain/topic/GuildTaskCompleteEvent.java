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
public class GuildTaskCompleteEvent extends BaseEvent implements ITopicEvent {

	private long guildID;

	private int taskID;

	private int index;

	private int actionTime;

	private String curItem;

	private int guildScore;

	@Override
	protected void resetProperties() {
		guildID = 0;
		taskID = 0;
		index = 0;
		actionTime = 0;
		curItem = "";
		guildScore = 0;
	}

	@Override
	public String getTopic() {
		return ConstantTopic.TOPIC_GUILD_COMPLETE_TASK;
	}
}
