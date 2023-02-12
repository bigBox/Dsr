package com.dj.servercore.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.dj.servercore.pool.PooledObjectFactory;
import com.dj.servercore.redis.base.AbsService;
import com.dj.servercore.redis.container.ServiceContainer;
import com.dj.servercore.server.SocketServer;
import com.dj.domain.util.Utility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceHandler extends AbsServiceHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// do before - get object
		AbsService serviceBase = (AbsService) PooledObjectFactory.getInstance().borrowObject(getTargetObject().getClass());
		ServiceContainer serviceContainer = (ServiceContainer) PooledObjectFactory.getInstance().borrowObject(ServiceContainer.class);
		// reset
		serviceContainer.init(SocketServer.getRedisTemplate(), SocketServer.getRedisTemplate());
		serviceBase.setServiceContainer(serviceContainer);
		try {
			// invoke
			return method.invoke(serviceBase, args);
		} catch (InvocationTargetException e) {
			serviceContainer.rollBack();
//			e.printStackTrace();
			log.error("Invoke error!{}", Utility.getTraceString(e));
			// 在动态代理的方法执行时捕获异常，然后抛出exception.getCause(),就能抛出自定义异常
			throw e.getCause();
		} catch (Exception e) {
			serviceContainer.rollBack();
			log.error("Invoke error!{}", Utility.getTraceString(e));
			// 在动态代理的方法执行时捕获异常，然后抛出exception.getCause(),就能抛出自定义异常
			throw e.getCause();
		} finally {
			// do after - save&dispose
			serviceContainer.save();
			serviceBase.dispose();
			// return pool
			PooledObjectFactory.getInstance().returnObject(serviceContainer);
			PooledObjectFactory.getInstance().returnObject(serviceBase);
		}
	}
}
