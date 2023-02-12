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
public class SyncItemInteractEvent extends BaseEvent implements ITopicEvent {

	@Override
	protected void resetProperties() {
	}

	@Override
	public String getTopic() {
		return ConstantTopic.TOPIC_ITEM_INTERACT;
	}
}
