package com.dj.servercore.db.accessor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.dj.domain.type.AccessType;
import com.dj.servercore.db.inf.IDbAccessor;
import org.springframework.stereotype.Component;

@Component
public class AccessorManager implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	/**
	 *	默认访问类型
	 */
	private String defaultType;

	/**
	 *	访问对象集合
	 */
	public Map<String, String> accessors = new HashMap<>();

	/**
	 *	注入访问器
	 * @param
	 */
	public void setAccessors(Map<String, String> accessors) {
		this.accessors = accessors;
	}

	public void setDefaultType(String defaultType) {
		this.defaultType = defaultType;
	}

	/**
	 *	获取访问对象
	 * @param type 访问器类型 {@link AccessType}
	 */
	public IDbAccessor getAccessor(String type) {
		IDbAccessor accessor = applicationContext.getBean(accessors.get(type), IDbAccessor.class);
		if (null == accessor) {
			throw new NullPointerException("no accessor type:" + type);
		}
		return accessor;
	}

	/**
	 *	获取默认db类型
	 * @param
	 */
	public String getDefaultAccessType() {
		return defaultType;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
