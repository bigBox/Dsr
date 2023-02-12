package com.dj.servercore.service;

import java.lang.reflect.InvocationHandler;

public abstract class AbsServiceHandler implements InvocationHandler {

	/** The target object. */
	private volatile Object targetObject;

	/**
	 * Sets the target object.
	 *
	 * @param targetObject the new target object
	 */
	public void setTargetObject(Object targetObject) {
		this.targetObject = targetObject;
	}

	/**
	 * Gets the target object.
	 *
	 * @return the target object
	 */
	public Object getTargetObject() {
		return targetObject;
	}
}
