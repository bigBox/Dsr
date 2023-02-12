package com.dj.servercore.event;

import com.dj.domain.base.BaseEvent;
import com.dj.servercore.pool.PooledObjectFactory;

public abstract class AbsEventListener {

    /**
     * @param event
     * @return void
     * @Title returnEvent
     * @Description 归还事件对象
     */
    protected <T extends BaseEvent> void returnEvent(T event) {
        if (event != null) {
            event.reset();
            PooledObjectFactory.getInstance().returnObject(event);
        }
    }
}
