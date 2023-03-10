package com.dj.servercore.db.cache.write;

import com.dj.domain.base.IEntity;

import java.io.Serializable;

public class EntityOperate implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;

	private IEntity entity;
	
	private boolean insert;
	private boolean update;
	private boolean delete;
	
	public EntityOperate(String entityId) {
		this.id = entityId;
	}
	
	private void updateEntity(IEntity entity,boolean needCopy){
		if(needCopy){
			this.entity = entity.copy();
		}else{
			this.entity = entity;
		}
	}
	
	public void insert(IEntity insertEntity,boolean needCopy){
		this.insert = true;
		updateEntity(insertEntity,needCopy);
	}

	public void update(IEntity updateEntity,boolean needCopy){
		this.update = true;
		updateEntity(updateEntity,needCopy);
	}
	
	public void delete(IEntity deleteEntity,boolean needCopy){
		this.delete = true;
		updateEntity(deleteEntity,needCopy);
	}
	
	public String getId() {
		return id;
	}

	public IEntity getInsert() {
		if(insert) return entity;
		return null;
	}

	public IEntity getUpdate() {
		if(insert) return null;
		if(delete) return null;
		if(update) return entity;
		return null;
	}

	public IEntity getDelete() {
		if(delete) return entity;
		return null;
	}
	
	public String getEntityClassName(){
		if(null != entity){
			return entity.getClass().getSimpleName();
		}
		//throw new RuntimeException("error,entity is null");
		return "";
	}
}
