package com.dj.serverapi.dao.task.inf;

import java.util.List;

import com.dj.domain.entity.player.task.ITask;

public interface ITaskDao<P> {

	List<? extends ITask> flushLevelTask(long roleID, int level);
	
	//ITask getSpareTask(long roleID);

	ITask flushTask(ITask task);
	
	int getTaskType();

	void deleteTask(long roleID, ITask task);
}
