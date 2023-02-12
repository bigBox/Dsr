package com.dj.domain.util.pool;

/**
 * @Description 基础对象池工厂
 */
@SuppressWarnings("deprecation")
public class BasePooledObjectFactory extends AbstractPooledObjectFactory {
	private static class SingletonHolder {
		public static BasePooledObjectFactory INSTANCE = new BasePooledObjectFactory();
	}

	public static BasePooledObjectFactory getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public BasePooledObjectFactory() {
		super.init(102400, 128);
	}
}