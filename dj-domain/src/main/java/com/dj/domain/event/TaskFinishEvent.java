package com.dj.domain.event;

import com.dj.domain.constant.ConstantTopic;
import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;
import com.dj.domain.base.ITopicEvent;
import com.dj.domain.entity.player.task.ITask;

import lombok.Data;
import lombok.EqualsAndHashCode;


@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class TaskFinishEvent extends BaseEvent implements ITopicEvent {

	private ITask task;
	
	@Override
	protected void resetProperties() {
		task = null;
	}

	@Override
	public String getTopic() {
		return ConstantTopic.TOPIC_TASK_FINISH_ACTION;
	}
}
