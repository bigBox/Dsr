package com.dj.serverglobal.manager;

import com.dj.servercore.action.base.BaseActionManager;

public class ActionManager extends BaseActionManager {

	private static final ActionManager INSTANCE = new ActionManager();

	public static final ActionManager getInstance() {
		return INSTANCE;
	}
}
