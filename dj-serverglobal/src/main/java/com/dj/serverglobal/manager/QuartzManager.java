package com.dj.serverglobal.manager;

import com.dj.servercore.quartz.AbstractQuartzManager;

import com.dj.serverglobal.quartz.TradeHistoryJob;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@Setter(AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class QuartzManager extends AbstractQuartzManager {
	public QuartzManager() {
		setInstance(this);
	}

	public static void init() {
		new QuartzManager();
		QuartzManager.getInstance().initJob();
		QuartzManager.getInstance().start();
	}

	@Override
	public void initJob() {
		TradeHistoryJob.init();
	}
}
