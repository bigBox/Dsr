package com.dj.serverglobal.manager;

import com.dj.serverapi.EventProvider;
import com.dj.serverglobal.listener.GuildBattleEventListener;
import com.dj.serverglobal.listener.TopicEventListener;

public class EventManager extends EventProvider {
	private static final EventManager INSTANCE = new EventManager();

	public static final EventManager getInstance() {
		return INSTANCE;
	}

	@Override
	protected void registerListener() {
		asyncEventBus.register(new TopicEventListener());
		asyncEventBus.register(new GuildBattleEventListener());
	}
}
