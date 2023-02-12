package com.dj.servercore.pool;

import com.dj.domain.util.pool.AbstractPooledObjectFactory;

public class PooledMsgEventFactory extends AbstractPooledObjectFactory {
	private static class SingletonHolder {
		public static PooledMsgEventFactory INSTANCE = new PooledMsgEventFactory();
	}

	public static PooledMsgEventFactory getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public PooledMsgEventFactory() {
		super.init(102400, 128);
	}
}