package com.dj.domain.topic;

import com.dj.domain.constant.ConstantTopic;
import com.dj.domain.enums.SyncCommonEnum;
import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;
import com.dj.domain.base.ITopicEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class SyncCommonEvent extends BaseEvent implements ITopicEvent  {

	private SyncCommonEnum type;

	private Object[] args;

	@Override
	protected void resetProperties() {
		type = null;
		args = null;
	}

	public long getRealRoleID() {
		if (type == SyncCommonEnum.FRIEND_ACTION) {
			return (long) args[0];
		}
		return getRoleID();
	}

	@Override
	public String getTopic() {
		return ConstantTopic.TOPIC_SYNC_COMMON;
	}
}
