package com.dj.servercore.conf;

import com.dj.domain.config.ConfigTasks;
import com.dj.protobuf.task.ETaskType;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.math.RandomUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.List;

public class ConfigTasksConf extends BaseConfigConf<ConfigTasks> {

	public ConfigTasksConf() {
		super(IConfProvider.CONFIG_TASKS);
	}

	private ImmutableMap<Integer, ConfigTasks> taskMap;
	private List<ConfigTasks> task1List = Lists.newArrayList();
	private List<ConfigTasks> task2List = Lists.newArrayList();
	private List<ConfigTasks> task3List = Lists.newArrayList();
	private List<ConfigTasks> task4List = Lists.newArrayList();
	private List<ConfigTasks> task5List = Lists.newArrayList();

	@Override
	public void onLoadOver() {
		taskMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
		task1List.clear();
		task2List.clear();
		task3List.clear();
		task4List.clear();
		task5List.clear();
		for (ConfigTasks item : dataList) {
			switch (item.getType()) {
			case ETaskType.GrowUp_VALUE:
				task1List.add(item);
				break;
			case ETaskType.Day_VALUE:
				task2List.add(item);
				break;
			case ETaskType.Month_VALUE:
				task3List.add(item);
				break;
			case ETaskType.Special_VALUE:
				task4List.add(item);
				break;
			case ETaskType.Guild_VALUE:
				task5List.add(item);
				break;
			}
		}
	}

	public ConfigTasks getTask(int id) {
		if(taskMap.containsKey(id)) {
			return getConfig(id, taskMap);
		}else{
			return null;
		}
	}

	public ImmutableMap<Integer, ConfigTasks> getTaskMap() {
		return getConfig(taskMap);
	}

	public List<ConfigTasks> getTypeTask(int type) {
		switch (type) {
		case ETaskType.GrowUp_VALUE:
			return task1List;
		case ETaskType.Day_VALUE:
			return task2List;
		case ETaskType.Month_VALUE:
			return task3List;
		case ETaskType.Special_VALUE:
			return task4List;
		case ETaskType.Guild_VALUE:
			return task5List;
		}
		return null;
	}

	public ConfigTasks randomTask(List<ConfigTasks> list, int taskID) {
		if (list.size() == 1) {
			return list.get(0);
		} else {
			while (true) {
				int index = RandomUtil.nextInt(list.size());
				if (taskID != list.get(index).getID()) {
					return list.get(index);
				}
			}
		}
	}

}
