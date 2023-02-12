package com.dj.servercore.service;

import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyFactory {

	/**
	 * Gets the proxy.
	 *
	 * @param targetObject
	 * @param handlers
	 * @return the proxy
	 */
	public static Object getProxy(Object targetObject, List<AbsServiceHandler> handlers) {
		Object proxyObject;
		if (handlers.size() > 0) {
			proxyObject = targetObject;
			for (int i = 0; i < handlers.size(); i++) {
				handlers.get(i).setTargetObject(proxyObject);
				proxyObject = Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), handlers.get(i));
			}
			return proxyObject;
		} else {
			return targetObject;
		}
	}

	/**
	 * Gets the proxy.
	 * 
	 * @param targetObject
	 * @param handler
	 * @return
	 */
	public static Object getProxy(Object targetObject, AbsServiceHandler handler) {
		Object proxyObject = targetObject;
		if (handler != null) {
			handler.setTargetObject(proxyObject);
			proxyObject = Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), handler);
		}
		return proxyObject;
	}
}
