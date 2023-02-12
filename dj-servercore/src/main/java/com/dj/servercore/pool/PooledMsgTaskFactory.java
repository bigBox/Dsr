package com.dj.servercore.pool;

import com.dj.domain.util.pool.AbstractPooledObjectFactory;

public class PooledMsgTaskFactory extends AbstractPooledObjectFactory {
	private static class SingletonHolder {
		public static PooledMsgTaskFactory INSTANCE = new PooledMsgTaskFactory();
	}

	public static PooledMsgTaskFactory getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public PooledMsgTaskFactory() {
		super.init(102400, 128);
	}
}