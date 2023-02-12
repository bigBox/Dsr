package com.dj.servercore.task;

import com.dj.servercore.pool.PooledMsgTaskFactory;

import lombok.Data;

@Data
public abstract class AbstractTask implements Runnable {

	/**
	 * @Title: resetProperties
	 * @Description: 重置任务属性
	 */
	public abstract void resetProperties();

	/**
	 * @Title: reset
	 * @Description: 重置任务
	 */
	protected abstract void reset();

	public static <T extends AbstractTask> void returnTask(T task) {
		if (task != null) {
			task.reset();
			PooledMsgTaskFactory.getInstance().returnObject(task);
		}
	}
}
