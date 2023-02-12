package com.dj.domain.topic;

import com.dj.domain.constant.ConstantTopic;
import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;
import com.dj.domain.base.ITopicEvent;
import com.dj.protobuf.task.TaskInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class GuildTaskUpdateEvent extends BaseEvent implements ITopicEvent {

	private long guildID;
	private TaskInfo taskInfo;
	
	@Override
	protected void resetProperties() {
		guildID = 0;
		taskInfo = null;
	}

	@Override
	public String getTopic() {
		return ConstantTopic.TOPIC_GUILD_UPDATE_TASK;
	}
}
