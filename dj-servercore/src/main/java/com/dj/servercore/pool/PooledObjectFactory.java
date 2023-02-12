package com.dj.servercore.pool;

import com.dj.domain.util.pool.AbstractPooledObjectFactory;

public class PooledObjectFactory extends AbstractPooledObjectFactory {
	private static class SingletonHolder {
		public static PooledObjectFactory INSTANCE = new PooledObjectFactory();
	}

	public static PooledObjectFactory getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public PooledObjectFactory() {
		super.init(102400, 128);
	}
}