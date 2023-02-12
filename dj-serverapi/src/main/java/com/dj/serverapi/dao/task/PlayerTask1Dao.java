package com.dj.serverapi.dao.task;

import com.dj.domain.config.ConfigTasks;
import com.dj.domain.entity.player.task.ITask;
import com.dj.domain.entity.player.task.PlayerTask1;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.enums.TaskState;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.task.ETaskType;
import com.dj.protobuf.task.TaskInfo;
import com.dj.protobuf.task.TaskStateInfo;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.task.inf.IPlayerTask1Dao;
import com.dj.serverapi.dao.task.inf.ITaskDao;
import com.dj.servercore.conf.ConfigTasksConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: PlayerTask1Dao
 * @Description: 成长任务
 * @author zcq
 * @date 2020年2月19日
 */
@Component
public class PlayerTask1Dao extends BaseCacheDao<PlayerTask1> implements IPlayerTask1Dao, ITaskDao<PlayerTask1> {

	@Override
	public List<? extends ITask> flushLevelTask(long roleID, int level) {
		List<PlayerTask1> list = readDbData(roleID);
		int index = 0;
		if(list == null){
			list = Lists.newArrayList();
		}else {
			index = list.size();
		}
		List<PlayerTask1> lists = Lists.newArrayList();
		ConfigTasksConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_TASKS);
		if(conf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		List<ConfigTasks> configList = conf.getTypeTask(getTaskType());
		for(ConfigTasks config : configList) {
			if((config.getConditionLevel() > 0) && (config.getConditionLevel() > level)) {
				continue;
			}
			boolean isNeedNew = true;
			for (PlayerTask1 task : list) {
				if (config.getID() == task.getTaskID()) {
					isNeedNew = false;
					break;
				}
			}
			if(isNeedNew) {
				PlayerTask1 task = new PlayerTask1(roleID);
				task.setTaskID(config.getID());
				task.setIndex(index++);
				task.setActionType(config.getActionType());
				if (config.getActionType() == TaskActionEnum.ACTIVE_DAY.getType()) {
					task.setActionTime(1);
					task.setLastLoginTime(System.currentTimeMillis());
				}
				task.setActionType1(config.getActionType1());
				if (config.getActionType1() == TaskActionEnum.ACTIVE_DAY.getType()) {
					task.setActionTime1(1);
					task.setLastLoginTime(System.currentTimeMillis());
				}
				task.setState(TaskState.noAccept.getState());
				task.setFirst(0);
				task.setNeedItem(config.getNeedItem());
				if (StringUtil.isNotEmpty0Null(config.getNeedItem())) {
					task.setNeedItemMap(MapUtil.stringToMap(config.getNeedItem(),";","-"));
				}else {
					task.setNeedItemMap(Maps.newHashMapWithExpectedSize(0));
				}
				task.setCurItem("");
				task.setCurItemMap(Maps.newHashMapWithExpectedSize(0));
				task.setExtra("");
				cacheInsert(task, roleID);
				lists.add(task);
			}
		}
		return lists;
	}
	
	@Override
	public ITask flushTask(ITask task) {
		return null;
	}

	@Override
	public List<PlayerTask1> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		List<PlayerTask1> list = selectList(queryParams, roleID, AccessType.DIRECT_DB);
		if(list != null && list.size() > 0) {
			for (PlayerTask1 task : list) {
				if (StringUtil.isNotEmpty0Null(task.getNeedItem())) {
					task.setNeedItemMap(MapUtil.stringToMap(task.getNeedItem(),";","-"));
				}else {
					task.setNeedItemMap(Maps.newHashMapWithExpectedSize(0));
				}
				if (StringUtil.isNotEmpty0Null(task.getCurItem())) {
					task.setCurItemMap(MapUtil.stringToMap(task.getCurItem(),";","-"));
				}else {
					task.setCurItemMap(Maps.newHashMapWithExpectedSize(0));
				}
			}
		}
		return list;
	}

	public List<TaskInfo> toTaskInfos(long roleID, int level) {
		List<TaskInfo> taskInfos = Lists.newArrayList();
		ConfigTasksConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_TASKS);
		if(conf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		List<PlayerTask1> tasks = cacheLoadAll(roleID);
		if(tasks != null && tasks.size() > 0) {
			tasks.forEach(value -> {
				ConfigTasks config = conf.getTask(value.getTaskID());
				if ((value.getTaskID() > 0) && (value.getState() < TaskState.award.getState())
						&& (config.getConditionLevel() > 0) && (config.getConditionLevel() <= level)) {
					taskInfos.add(value.toTaskInfo());
				}
			});
		}
		return taskInfos;
	}

	public List<TaskStateInfo> toTaskStateInfos(long roleID, int level) {
		List<TaskStateInfo> taskInfos = Lists.newArrayList();
		ConfigTasksConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_TASKS);
		if(conf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		List<PlayerTask1> tasks = cacheLoadAll(roleID);
		if(tasks != null && tasks.size() > 0) {
			tasks.forEach(value -> {
				ConfigTasks config = conf.getTask(value.getTaskID());
				if ((value.getTaskID() > 0) && (config.getConditionLevel() > 0) && (config.getConditionLevel() <= level)) {
					taskInfos.add(value.toTaskStateInfo());
				}
			});
		}
		return taskInfos;
	}

	public List<TaskInfo> getLastTaskInfo(long roleID, int level) {
		List<TaskInfo> taskInfos = Lists.newArrayList();
		ConfigTasksConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_TASKS);
		if(conf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		List<PlayerTask1> tasks = cacheLoadAll(roleID);
		if((tasks != null)&&(tasks.size() > 0)){
			for(PlayerTask1 playerTask1 : tasks){
				ConfigTasks config = conf.getTask(playerTask1.getTaskID());
				if((config.getConditionLevel() > 0) && (config.getConditionLevel() > level)) {
					continue;
				}
				if((playerTask1.getTaskID() > 0) && (playerTask1.getState() < TaskState.award.getState())) {
					taskInfos.add(playerTask1.toTaskInfo());
					//break;
				}
			}
		}
		return taskInfos;
	}

	public void resetTaskInfo(int taskID, long roleID) {
		List<PlayerTask1> tasks = cacheLoadAll(roleID);
		if((tasks != null)&&(tasks.size() > 0)) {
			tasks.forEach(playerTask -> {
				if (playerTask.getTaskID() <= taskID) {
					playerTask.setActionTime(0);
					playerTask.setState(TaskState.noAccept.getState());
					playerTask.setFirst(0);
					playerTask.setCurItem("");
					playerTask.setCurItemMap(Maps.newHashMapWithExpectedSize(0));
					playerTask.setLastLoginTime(0L);
					playerTask.setExtra("");
					cacheUpdate(playerTask, playerTask.getRoleID());
				}
			});
		}
	}
	@Override
	public int getTaskType() {
		return ETaskType.GrowUp_VALUE;
	}

	@Override
	public void deleteTask(long roleID, ITask task) {
		cacheDelete(task.getPrimaryKeyValue(), roleID);
	}
}
