package com.dj.domain.event;

import com.dj.domain.constant.ConstantTopic;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.base.BaseEvent;
import com.dj.domain.base.IAsyncEvent;
import com.dj.domain.base.ITopicEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@IAsyncEvent
@Data
@EqualsAndHashCode(callSuper = false)
public class TaskActionEvent extends BaseEvent implements ITopicEvent {

    private TaskActionEnum actionEnum;
    private int actionTime;

    @Override
    protected void resetProperties() {
        actionEnum = null;
        actionTime = 0;
    }

    @Override
    public String getTopic() {
        return ConstantTopic.TOPIC_TASK_ACTION;
    }
}
