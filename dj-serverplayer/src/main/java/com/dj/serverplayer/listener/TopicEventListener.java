package com.dj.serverplayer.listener;

import com.dj.domain.event.TaskActionEvent;
import com.dj.domain.event.TaskFinishEvent;
import com.dj.domain.event.TaskUpdateEvent;
import com.dj.domain.topic.SyncAttrEvent;
import com.dj.domain.topic.SyncCommonEvent;
import com.dj.domain.topic.SyncItemEvent;
import com.dj.serverapi.topic.TopicManager;
import com.dj.servercore.event.AbsEventListener;
import com.dj.domain.util.Utility;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: TopicEventListener
 * @Description: 本进程topic事件监听器
 * @date 2019年6月25日
 */
@Slf4j
public class TopicEventListener extends AbsEventListener {

    @Subscribe
    @AllowConcurrentEvents
    public void listenSyncCommonEvent(SyncCommonEvent event) {
        try {
            TopicManager.getInstance().publishTopic(event);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            returnEvent(event);
        }
    }

    @Subscribe
    @AllowConcurrentEvents
    public void listenSyncItemEvent(SyncItemEvent event) {
        try {
            TopicManager.getInstance().publishTopic(event);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            returnEvent(event);
        }
    }

    @Subscribe
    @AllowConcurrentEvents
    public void listenSyncAttrEvent(SyncAttrEvent event) {
        try {
            TopicManager.getInstance().publishTopic(event);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            returnEvent(event);
        }
    }

    @Subscribe
    @AllowConcurrentEvents
    public void listenTaskActionEvent(TaskActionEvent event) {
        try {
            TopicManager.getInstance().publishTopic(event);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            returnEvent(event);
        }
    }

    @Subscribe
    @AllowConcurrentEvents
    public void listenTaskUpdateEvent(TaskUpdateEvent event) {
        try {
            TopicManager.getInstance().publishTopic(event);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            returnEvent(event);
        }
    }
	
	
    @Subscribe
    @AllowConcurrentEvents
    public void listenTaskFinishEvent(TaskFinishEvent event) {
        try {
            TopicManager.getInstance().publishTopic(event);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            returnEvent(event);
        }
    }

}
