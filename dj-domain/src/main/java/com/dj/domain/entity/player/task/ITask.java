package com.dj.domain.entity.player.task;

import java.util.Map;

import com.dj.domain.config.ConfigTasks;
import com.dj.protobuf.task.TaskInfo;

public interface ITask{

	TaskInfo toTaskInfo();

	Object getPrimaryKeyValue();

	long getRoleID();

	int getTaskID();

	int getIndex();
	
	void setState(int value);
	
	int getState();

	boolean checkFinish(ConfigTasks config);

	void clear();
	
	void setFirst(int value);
	
	long getLastLoginTime();
	void setLastLoginTime(long value);
	
	int getActionType();
	void setActionType(int value);

	int getActionTime();
	void setActionTime(int value);

	int getActionType1();
	void setActionType1(int value);

	int getActionTime1();
	void setActionTime1(int value);

	String getNeedItem();
	void setNeedItem(String value);

	String getCurItem();
	void setCurItem(String value);

	Map<Integer, Integer> getNeedItemMap();
	void setNeedItemMap(Map<Integer, Integer> value);
	
	Map<Integer, Integer> getCurItemMap();
	void setCurItemMap(Map<Integer, Integer> value);


}