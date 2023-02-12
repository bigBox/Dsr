package com.dj.bms.third;

/**
 * 第三方集成服务接口
 * 
 * @author: zcq
 * @date: 2019-03-10
 */
public interface BaseService<T> {

	/**
	 * 外接服务初始化实例方法
	 * @return
	 */
	T instance();
}
