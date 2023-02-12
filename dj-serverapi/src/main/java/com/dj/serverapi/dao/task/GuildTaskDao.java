package com.dj.serverapi.dao.task;

import com.dj.domain.config.ConfigTasks;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.entity.player.task.GuildTask;
import com.dj.domain.entity.player.task.ITask;
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
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.task.inf.IGuildTaskDao;
import com.dj.serverapi.dao.task.inf.ITaskDao;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.servercore.conf.ConfigTasksConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: GuildTaskDao
 * @Description: 商会任务
 * @author zcq
 * @date 2020年7月30日
 */
@Component
public class GuildTaskDao extends BaseCacheDao<GuildTask> implements IGuildTaskDao, ITaskDao<GuildTask> {

	public List<? extends ITask> flushLevelTask(long roleID, long guildID, int level) {
		try {
			ConfigTasksConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_TASKS);
			if(conf == null){
				throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
			}
			int index = 0;
			List<GuildTask> retList = Lists.newArrayList();
			List<GuildTask> list = readDbData(guildID);
			if((list != null) && (list.size() > 0)) {
				for(GuildTask guildTask : list){
					if((guildTask.getState() == TaskState.teared.getState())&&(guildTask.getCdEndTime().getTime() < System.currentTimeMillis())){
						cacheDelete(guildTask.getId(), roleID);
					}else if ((guildTask.getState() > TaskState.teared.getState())&&(guildTask.getState() <= TaskState.award.getState())) {
						guildTask.setIndex(index++);
						cacheUpdate(guildTask, roleID);
						retList.add(guildTask);
					}
				}
				if(retList.size() == ConfigSundryConf.guildTaskCreateNum){
					return retList;
				}
			}
			List<ConfigTasks> configList = conf.getTypeTask(getTaskType());
			for(ConfigTasks config : configList) {
				boolean isNeedNew = true;
				for (GuildTask task : retList) {
					if (config.getID() == task.getTaskID()) {
						isNeedNew = false;
						break;
					}
				}
				if(isNeedNew) {
					GuildTask task = new GuildTask(roleID);
					task.setGuildID(guildID);
					task.setIndex(index++);
					task.setTaskID(config.getID());
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
					retList.add(task);
				}
				if(retList.size() == ConfigSundryConf.guildTaskCreateNum){
					return retList;
				}
			}
			return retList;
		}catch (Exception e){
			e.printStackTrace();
		}
		return Lists.newArrayList();
	}

	@Override
	public List<? extends ITask> flushLevelTask(long roleID, int level) {
		PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
		if (playerRole.getGuildId() == 0) {
			throw new CommonException(ErrorIDOuterClass.ErrorID.GUILD_NO_JOIN);
		}
		return flushLevelTask(roleID, playerRole.getGuildId(), level);
	}

	@Override
	public ITask flushTask(ITask task) {
		GuildTask guildTask = new GuildTask(task.getRoleID());
		try {
			ConfigTasksConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_TASKS);
			if(conf == null){
				throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
			}
			List<ConfigTasks> list = conf.getTypeTask(getTaskType());
			ConfigTasks config = conf.randomTask(list, task.getTaskID());
			guildTask.setGuildID(((GuildTask)task).getGuildID());
			guildTask.setTaskID(config.getID());
			guildTask.setIndex(task.getIndex());
			guildTask.setActionType(config.getActionType());
			guildTask.setActionTime(0);
			guildTask.setActionType1(config.getActionType1());
			guildTask.setActionTime1(0);
			guildTask.setState(TaskState.noAccept.getState());
			guildTask.setFirst(0);
			guildTask.setNeedItem(config.getNeedItem());
			if (StringUtil.isNotEmpty0Null(config.getNeedItem())) {
				guildTask.setNeedItemMap(MapUtil.stringToMap(config.getNeedItem(),";","-"));
			}else {
				guildTask.setNeedItemMap(Maps.newHashMapWithExpectedSize(0));
			}
			guildTask.setCurItem("");
			guildTask.setCurItemMap(Maps.newHashMapWithExpectedSize(0));
			guildTask.setLastLoginTime(0L);
			cacheInsert(guildTask, guildTask.getGuildID());
			return guildTask;
		}catch (Exception e){
			e.printStackTrace();
		}
		return guildTask;
	}

	@Override
	public List<GuildTask> readDbData(long guildID) {
		try {
			QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
			queryParams.put("guildID", guildID);
			List<GuildTask> tasks = selectList(queryParams, guildID, AccessType.DIRECT_DB);
			if(tasks != null && tasks.size() > 0) {
				for (GuildTask task : tasks) {
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
			return tasks;

		}catch (Exception e){
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public List<TaskInfo> toTaskInfos(long roleID, long guildID) {
		List<TaskInfo> taskInfos = Lists.newArrayList();
		try {
			int index = taskInfos.size();
			List<GuildTask> guildTasks = readDbData(guildID);
			if(guildTasks != null && guildTasks.size() > 0) {
				for(GuildTask task : guildTasks) {
					if(task.getState() == TaskState.teared.getState()){
						if(task.getCdEndTime().getTime() < System.currentTimeMillis()) {
							guildTasks.remove(task);
							cacheDelete(task.getId(), roleID);
						}else{
							task.setIndex(index++);
							cacheUpdate(task, roleID);
							taskInfos.add(task.toTaskInfo());
							roleID = task.getRoleID();
						}
					}
					else if ((task.getState() > TaskState.teared.getState())&&(task.getState() < TaskState.award.getState())) {
						task.setIndex(index++);
						cacheUpdate(task, roleID);
						taskInfos.add(task.toTaskInfo());
						roleID = task.getRoleID();
					}
					if(taskInfos.size() == ConfigSundryConf.guildTaskCreateNum){
						return taskInfos;
					}
				};
			}
			ConfigTasksConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_TASKS);
			if(conf == null){
				throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
			}
			List<ConfigTasks> configList = conf.getTypeTask(getTaskType());
			for(ConfigTasks config : configList) {
				boolean isNeedNew = true;
				for (TaskInfo task : taskInfos) {
					if (config.getID() == task.getTaskId()) {
						isNeedNew = false;
						break;
					}
				}
				if(isNeedNew) {
					GuildTask task = new GuildTask(roleID);
					task.setGuildID(guildID);
					task.setIndex(index++);
					task.setTaskID(config.getID());
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
					taskInfos.add(task.toTaskInfo());
				}
				if(taskInfos.size() == ConfigSundryConf.guildTaskCreateNum){
					return taskInfos;
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return taskInfos;
	}

	@Override
	public int getTaskType() {
		return ETaskType.Guild_VALUE;
	}

	@Override
	public void deleteTask(long roleID, ITask task) {
		cacheDelete(task.getPrimaryKeyValue(), roleID);
	}
}
