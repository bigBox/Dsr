package com.dj.serverapi.service;

import java.util.List;

import com.dj.domain.config.ConfigGuideTask;
import com.dj.protobuf.task.ETaskType;
import com.dj.serverapi.EventProvider;
import com.dj.serverapi.redis.model.TaskModel;
import com.dj.serverapi.service.inf.ITaskService;
import com.dj.servercore.redis.base.BaseService;

public class TaskServiceImpl extends BaseService implements ITaskService {

	@Override
	public boolean getGuideRewardCheckFinish(long roleID, ConfigGuideTask configGuideTask) {
		TaskModel model = getWriteModel(roleID, TaskModel.class);
		if (configGuideTask.getFinishTag() == 1) {
			model.finishGuide();
			EventProvider.postTaskUpdateEvent(roleID, ETaskType.GrowUp_VALUE);
			EventProvider.commitRoleEvent(roleID);
		}
		List<Integer> list = model.getGuideReward();
		if (list.contains(configGuideTask.getID())) {
			return false;
		}
		list.add(configGuideTask.getID());
		return true;
	}

	@Override
	public void setDayCount(long roleID, int count) {
		TaskModel model = getWriteModel(roleID, TaskModel.class);
		model.setDayCount(count);
	}

	@Override
	public int getDayCount(long roleID) {
		TaskModel model = getReadModel(roleID, TaskModel.class);
		return model.getDayCount();
	}
}
