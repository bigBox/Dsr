package com.dj.servercore.event;

import com.dj.domain.event.PlayerLevelUpEvent;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

public abstract class BasePlayerEventListener extends AbsEventListener {

    @Subscribe
    @AllowConcurrentEvents
    public abstract void listenerPlayerLevelUpEvent(PlayerLevelUpEvent event);
}
