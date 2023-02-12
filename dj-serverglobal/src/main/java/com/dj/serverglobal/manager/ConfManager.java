package com.dj.serverglobal.manager;

import com.dj.servercore.conf.base.BaseConfManager;
import com.dj.servercore.conf.base.ConfProvider;

public class ConfManager extends BaseConfManager {

	private static final ConfManager INSTANCE = new ConfManager();

	public ConfManager() {
		setInstance(this);
	}
	
	public static final ConfManager getInstance() {
		return INSTANCE;
	}

	@Override
	protected void onLoadOver() {
		ConfProvider.setConfigConfProvider(this);
	}
}
