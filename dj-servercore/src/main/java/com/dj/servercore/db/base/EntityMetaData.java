package com.dj.servercore.db.base;

import com.dj.domain.base.IEntity;

public class EntityMetaData {
	
	public static String getEntityName(Class<? extends IEntity> entityClazz){
		return entityClazz.getSimpleName();
	}
	
	public static String getEntityName(IEntity entity){
		return getEntityName(entity.getClass());
	}
}
