package com.dj.domain.base;

import java.io.Serializable;


public interface IEntity extends Serializable{
	
	/**
	 *	获取主键名
	 */
    String getPrimaryKeyName();
	
	/**
	 *	获取主键值
	 */
    Object getPrimaryKeyValue();
	
	/**
	 *	实体拷贝
	 */
    IEntity copy();
}
