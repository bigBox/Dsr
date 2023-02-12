package com.dj.serverapi.dao.task;

import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.enums.TaskState;
import com.dj.domain.type.AccessType;
import com.dj.domain.config.ConfigTasks;
import com.dj.domain.entity.player.task.ITask;
import com.dj.domain.entity.player.task.PlayerTask4;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.task.ETaskType;
import com.dj.protobuf.task.TaskInfo;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.task.inf.IPlayerTask4Dao;
import com.dj.serverapi.dao.task.inf.ITaskDao;
import com.dj.servercore.conf.ConfigTasksConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: PlayerTask4Dao
 * @Description: 节日任务
 * @author zcq
 * @date 2020年7月29日
 */
@Component
public class PlayerTask4Dao extends BaseCacheDao<PlayerTask4> implements IPlayerTask4Dao, ITaskDao<PlayerTask4> {

	@Override
	public List<? extends ITask> flushLevelTask(long roleID, int level) {
		List<PlayerTask4> list = readDbData(roleID);
		int index = 0;
		if(list == null){
			list = Lists.newArrayList();
		}else {
			index = list.size();
		}
		List<PlayerTask4> lists = Lists.newArrayList();
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
			for (PlayerTask4 task : list) {
				if (config.getID() == task.getTaskID()) {
					isNeedNew = false;
					break;
				}
			}
			if(isNeedNew) {
				PlayerTask4 task = new PlayerTask4(roleID);
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
				cacheInsert(task, roleID);
				lists.add(task);
			}
		}
		return lists;
	}
	
	@Override
	public ITask flushTask(ITask task) {
		ConfigTasksConf   conf       = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_TASKS);
		if(conf == null){
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		List<ConfigTasks> list       = conf.getTypeTask(getTaskType());
		ConfigTasks       config     = conf.randomTask(list, task.getTaskID());
		PlayerTask4       playerTask = new PlayerTask4();
		playerTask.setRoleID(task.getRoleID());
		playerTask.setTaskID(config.getID());
		playerTask.setIndex(task.getIndex());
		playerTask.setActionType(config.getActionType());
		playerTask.setActionTime(0);
		playerTask.setActionType1(config.getActionType1());
		playerTask.setActionTime1(0);
		playerTask.setState(TaskState.noAccept.getState());
		playerTask.setFirst(0);
		playerTask.setNeedItem(config.getNeedItem());
		if (StringUtil.isNotEmpty0Null(config.getNeedItem())) {
			playerTask.setNeedItemMap(MapUtil.stringToMap(config.getNeedItem(),";","-"));
		}else {
			playerTask.setNeedItemMap(Maps.newHashMapWithExpectedSize(0));
		}
		playerTask.setCurItem("");
		playerTask.setCurItemMap(Maps.newHashMapWithExpectedSize(0));
		playerTask.setLastLoginTime(0L);
		cacheInsert(playerTask, playerTask.getRoleID());
		return playerTask;
	}

	@Override
	public List<PlayerTask4> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		List<PlayerTask4> list = selectList(queryParams, roleID, AccessType.DIRECT_DB);
		if(list != null && list.size() > 0) {
			for (PlayerTask4 task : list) {
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
		List<PlayerTask4> tasks     = cacheLoadAll(roleID);
		if((tasks != null)&&(tasks.size() > 0)) {
			tasks.forEach(value -> {
				if ((value.getTaskID() > 0) && (value.getState() < TaskState.award.getState())) {
					taskInfos.add(value.toTaskInfo());
				}
			});
		}
		return taskInfos;
	}

	public List<TaskInfo> getLastTaskInfo(long roleID, int level) {
		List<TaskInfo> taskInfos = Lists.newArrayList();
		List<PlayerTask4> tasks = cacheLoadAll(roleID);
		if((tasks != null)&&(tasks.size() > 0)){
			for(PlayerTask4 playerTask4 : tasks){
				if((playerTask4.getTaskID() > 0) && (playerTask4.getState() < TaskState.award.getState())) {
					if(playerTask4.getState() == TaskState.noAccept.getState()){
						playerTask4.setState(TaskState.accept.getState());
						cacheUpdate(playerTask4, roleID);
					}
					taskInfos.add(playerTask4.toTaskInfo());
					break;
				}
			}
		}
		return taskInfos;
	}
	@Override
	public int getTaskType() {
		return ETaskType.Special_VALUE;
	}

	@Override
	public void deleteTask(long roleID, ITask task) {
		cacheDelete(task.getPrimaryKeyValue(), roleID);
	}
}
