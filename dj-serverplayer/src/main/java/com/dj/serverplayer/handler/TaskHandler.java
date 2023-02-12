package com.dj.serverplayer.handler;

import com.dj.domain.base.IEntity;
import com.dj.domain.config.ConfigTasks;
import com.dj.domain.entity.player.PlayerFriend;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.entity.player.task.*;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.enums.TaskState;
import com.dj.domain.topic.GuildTaskCompleteEvent;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.task.*;
import com.dj.serverapi.dao.PlayerFriendDao;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.task.inf.ITaskDao;
import com.dj.serverapi.helper.OnlineHelper;
import com.dj.serverapi.helper.OnlineRole;
import com.dj.serverapi.topic.TopicManager;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.servercore.conf.ConfigTasksConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.EventManager;
import com.dj.serverplayer.manager.ServiceManager;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @author zcq
 * @description 任务业务处理
 * @date 2019年5月9日
 */
@Slf4j
@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class TaskHandler extends BaseHandler {

	private ConfigTasksConf conf = ConfManager.getInstance().getConfigTasksConf();

	/**
	 * 初始化玩家任务
	 * 
	 * @param roleID
	 */
	public void flushLevelTask(long roleID, int level) {
		// 成长任务
		playerTask1Dao.flushLevelTask(roleID, level);
		// 日常任务
		//flushDayTask(roleID, level);
		playerTask2Dao.flushLevelTask(roleID, level);  
		// 月度任务
		playerTask3Dao.flushLevelTask(roleID, level);
		// 节日任务
		playerTask4Dao.flushLevelTask(roleID, level);
		// 商会任务
		//guildTaskDao.flushLevelTask(roleID,level);
	}
	
	/**
	 * 刷新日常任务
	 * @param roleID
	 * @param level
	 */
	public void flushDayTask(long roleID, int level) {
		List<ITask> taskList = (List<ITask>) playerTask2Dao.flushLevelTask(roleID, level);
		if(taskList != null) {
			for(ITask task : taskList) {
				doDayTaskItem(task);
			}
		}
	}
	

	/**
	 * 获取任务列表
	 * 
	 * @param roleID
	 * @param taskType
	 */
	public List<TaskInfo> taskList(long roleID, int taskType) {
		List<TaskInfo> infos = Lists.newArrayList();
		PlayerRole playerRole = playerService.getPlayer(roleID);
		if(playerRole != null) {
			switch (taskType) {
				case ETaskType.GrowUp_VALUE:
					infos.addAll(playerTask1Dao.toTaskInfos(roleID, playerRole.getLevel()));
					break;
				case ETaskType.Day_VALUE:
					infos.addAll(playerTask2Dao.toTaskInfos(roleID, playerRole.getLevel()));
					break;
				case ETaskType.Month_VALUE:
					infos.addAll(playerTask3Dao.toTaskInfos(roleID, playerRole.getLevel()));
					break;
				case ETaskType.Special_VALUE:
					infos.addAll(playerTask4Dao.toTaskInfos(roleID, playerRole.getLevel()));
					break;
				case ETaskType.Guild_VALUE:
					infos.addAll(guildTaskDao.toTaskInfos(roleID, playerRole.getGuildId()));
					break;
				default:
					infos.addAll(playerTask1Dao.getLastTaskInfo(roleID, playerRole.getLevel()));
					if (playerRole.getGuideTaskId() > ConfigSundryConf.newPlayerOpenDailyTask) {
						infos.addAll(playerTask2Dao.getLastTaskInfo(roleID, playerRole.getLevel()));
						infos.addAll(playerTask3Dao.getLastTaskInfo(roleID, playerRole.getLevel()));
						infos.addAll(playerTask4Dao.getLastTaskInfo(roleID, playerRole.getLevel()));
					}
					break;
			}
		}
		return infos;
	}

	/**
	 * 获取任务列表
	 *
	 * @param roleID
	 * @param taskType
	 */
	public List<TaskStateInfo> taskStateList(long roleID, int taskType) {
		List<TaskStateInfo> infos = Lists.newArrayList();
		PlayerRole playerRole = playerService.getPlayer(roleID);
		if(playerRole != null) {
			switch (taskType) {
				case ETaskType.GrowUp_VALUE:
					infos.addAll(playerTask1Dao.toTaskStateInfos(roleID, playerRole.getLevel()));
					break;
				case ETaskType.Day_VALUE:
					break;
				case ETaskType.Month_VALUE:
					break;
				case ETaskType.Special_VALUE:
					break;
				case ETaskType.Guild_VALUE:
					break;
				default:
					break;
			}
		}
		return infos;
	}
	public List<? extends ITask> getTypeTask(long roleID, int taskType) {
		List<? extends ITask> taskList = null;
		switch (taskType) {
			case ETaskType.GrowUp_VALUE:
				taskList = playerTask1Dao.cacheLoadAll(roleID);
				break;
			case ETaskType.Day_VALUE:
				taskList = playerTask2Dao.cacheLoadAll(roleID);
				break;
			case ETaskType.Month_VALUE:
				taskList = playerTask3Dao.cacheLoadAll(roleID);
				break;
			case ETaskType.Special_VALUE:
				taskList = playerTask4Dao.cacheLoadAll(roleID);
				break;
			case ETaskType.Guild_VALUE:
				taskList = guildTaskDao.cacheLoadAll(roleID);
				break;
			default:
				break;
		}
		if(taskList != null) {
			for (ITask task : taskList) {
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
		return taskList;
	}

	public ITask getTypeIndexTask(long roleID, int taskType, int taskID) {
		BaseCacheDao taskDao = null;
		switch (taskType) {
			case ETaskType.GrowUp_VALUE:
				taskDao = playerTask1Dao;
			break;
			case ETaskType.Day_VALUE:
				taskDao = playerTask2Dao;
			break;
			case ETaskType.Month_VALUE:
				taskDao = playerTask3Dao;
			break;
			case ETaskType.Special_VALUE:
				taskDao = playerTask4Dao;
			break;
			case ETaskType.Guild_VALUE:
				taskDao = guildTaskDao;
			break;
		}
		QueryParamMap queryParams = new QueryParamMap();
		queryParams.put("roleID",roleID);
		queryParams.put("taskID",taskID);
		ITask task = (ITask)taskDao.cacheSelect(queryParams, roleID);
		if(task != null){
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
		return task;
	}
	// 更新任务
	public void updateTask(long roleID, int taskType, ITask task) {
		BaseCacheDao taskDao = null;
		switch (taskType) {
			case ETaskType.GrowUp_VALUE:
				taskDao = playerTask1Dao;
			break;
			case ETaskType.Day_VALUE:
				taskDao = playerTask2Dao;
			break;
			case ETaskType.Month_VALUE:
				taskDao = playerTask3Dao;
			break;
			case ETaskType.Special_VALUE:
				taskDao = playerTask4Dao;
			break;
			case ETaskType.Guild_VALUE:
				taskDao = guildTaskDao;
			break;

		}
		if(task.getCurItemMap() != null && task.getCurItemMap().size() > 0) {
			task.setCurItem(MapUtil.mapToString(task.getCurItemMap()));
		}
		taskDao.cacheUpdate((IEntity) task, roleID);
	}


	/**
	 * 接受任务
	 * 
	 * @param roleID
	 * @param req
	 */
	public void taskAccept(long roleID, TaskAcceptReq req, TaskAcceptRsp.Builder builder) {
		ITask task = getTypeIndexTask(roleID, req.getType().getNumber(), req.getTaskId());
		if (task == null || task.getState() == TaskState.accept.getState()) {
			log.error("taskAccept task == null roleID:{}", roleID);
			throw new CommonException(ErrorID.COMMON_PARAM_ERROR, roleID + ":" + req.getType() + "-" + req.getTaskId());
		}
		ConfigTasksConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_TASKS);
		if(conf == null){
			log.error("taskAccept ConfigTasksConf conf == null roleID:{}", roleID);
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigTasks config = conf.getTask(task.getTaskID());
		if(config == null){
			log.error("taskAccept ConfigTasks config == null roleID:{}", roleID);
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		checkLevelEnough(roleID, config.getConditionLevel());

		if (StringUtil.isNotEmpty0Null(config.getAddItem())) {
			Map<Integer, Integer> map = MapUtil.mapStringToMap1(config.getAddItem());
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if(entry.getKey() == 1){
					addGold(roleID, entry.getValue(), ResourceBillEnum.taskReward);
				}else if(entry.getKey() == 2){
					addDiamond(roleID, entry.getValue(), ResourceBillEnum.taskReward);
				}else {
					addItem(roleID, entry.getKey(), entry.getValue(), ResourceBillEnum.taskReward, false);
				}
			}
		}

		if(req.getType().getNumber() == ETaskType.GrowUp_VALUE) {
			List<PlayerTask1> tasks = playerTask1Dao.cacheLoadAll(roleID);
			if((tasks != null)&&(tasks.size() > 0)) {
				tasks.forEach(value -> {
					if (value.getState() == TaskState.accept.getState() || value.getState() == TaskState.complete.getState()) {
						throw new CommonException(ErrorID.PLEASE_COMPLATE_CUR_TASK, roleID + ":" + req.getType() + "-" + req.getTaskId());
					}
				});
			}
			playerService.updateGuideTaskState(roleID, task.getTaskID(), TaskState.accept.getState());
		}
		task.setState(TaskState.accept.getState());
		updateTask(roleID, req.getType().getNumber(), task);
		commonService.setAcceptTypeTask(roleID, req.getType().getNumber(), task.getTaskID());
		builder.setTaskId(task.getTaskID());
		// 加入或发起商会任务
		if((task.getActionType() == TaskActionEnum.HAS_GUILD.getType())
				||(task.getActionType1() == TaskActionEnum.HAS_GUILD.getType())) {
			PlayerRole playerRole = playerService.getPlayer(roleID);
			if(playerRole.getGuildId() > 0) {
				EventManager.postTaskActionEvent(roleID, TaskActionEnum.HAS_GUILD, 1);
				EventManager.commitRoleEvent(roleID);
			}
		}
		if((task.getActionType() == TaskActionEnum.ADD_FRIEND.getType())
				||(task.getActionType1() == TaskActionEnum.ADD_FRIEND.getType())){
			List<PlayerFriend> friendList = SpringContext.getBean(PlayerFriendDao.class).cacheLoadAll(roleID);
			if ((friendList != null)&&(friendList.size() > 2)) {
				EventManager.postTaskActionEvent(roleID, TaskActionEnum.ADD_FRIEND, friendList.size());
				EventManager.commitRoleEvent(roleID);
			}
		}
		//if((config.getActionType() == TaskActionEnum.PARK_ANIMALS.getType())
		//		||(config.getActionType1() == TaskActionEnum.PARK_ANIMALS.getType())
		//		||(config.getActionType() == TaskActionEnum.PRODUCE_GOODS.getType())
		//		||(config.getActionType1() == TaskActionEnum.PRODUCE_GOODS.getType())){
		//	if(config.getExtraParam() > 0){
		//		ConfigFarmParkAnimalConf farmParkAnimalConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMPARKANIMAL);
		//		if(farmParkAnimalConf != null){
		//			ConfigFarmParkAnimal farmParkAnimalConfig = farmParkAnimalConf.getAnimal(config.getExtraParam());
		//			ServiceProvider.getParkService().parkPlaceAnimal(roleID, farmParkAnimalConfig.getID(), farmParkAnimalConfig,0);
		//		}
		//	}
		//}
		// 日常任务
		if(req.getType() == ETaskType.Day) {
			doDayTaskItem(task);
		}
	}

	/**
	 * 领取任务奖励
	 *
	 * @param roleID
	 * @param req
	 */
	public void taskReward(long roleID, TaskRewardReq req, TaskRewardRsp.Builder builder) {
		ITask task = getTypeIndexTask(roleID, req.getType().getNumber(), req.getTaskId());
		if (task == null || task.getState() != TaskState.complete.getState()) {
			log.error("taskReward task == null roleID:{}", roleID);
			throw new CommonException(ErrorID.TASK_NOT_FINISH, roleID + ":" + req.getType() + "-" + req.getTaskId());
		}
		ConfigTasksConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_TASKS);
		if(conf == null){
			log.error("taskReward ConfigTasksConf conf == null roleID:{}", roleID);
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigTasks config = conf.getTask(task.getTaskID());
		if(config == null){
			log.error("taskReward ConfigTasks config == null roleID:{}", roleID);
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
//		if (!task.checkFinish(config)) {
//			throw new CommonException(ErrorID.TASK_NOT_FINISH);
//		}
		// 商会任务
//		if(config.getType() == ETaskType.Guild_VALUE) {
//			// 添加个人商会积分
//			changeGuildScore(roleID, config.getGuildScore(), ResourceBillEnum.taskReward);
//			// 为商会添加经验
//			GuildLevelEvent guildLevelEvent = EventManager.borrowEvent(GuildLevelEvent.class);
//			guildLevelEvent.setRoleID(roleID);
//	        PlayerRole playerRole = playerRoleDao.cacheLoad("roleID", roleID, roleID);
//	        guildLevelEvent.setGuildID(playerRole.getGuildId());
//	        guildLevelEvent.setGuildScore(config.getGuildScore());
//	        TopicManager.getInstance().publishTopic(guildLevelEvent);
//	        // 清空玩家的商会任务
//	        task.setState(TaskState.award.getState());
//	        updateTask(roleID, ETaskType.Guild_VALUE, task);
//
//			// 更新接受任务类型标记
//			ServiceManager.getCommonService().setAcceptTypeTask(roleID, ETaskType.Guild_VALUE, -1);
//			builder.setTask(task.toTaskInfo());
//			EventManager.postTaskActionEvent(roleID, TaskActionEnum.FINISH_GUILD_TASK, 1);
//		} else {
			addItem(roleID, config.getRewardItem(), ResourceBillEnum.taskReward, false);
			//addExp(roleID, config.getRewardExp(), ResourceBillEnum.taskReward);
			//addGold(roleID, config.getRewardGold(), ResourceBillEnum.taskReward);
			if(req.getType() == ETaskType.GrowUp) {
				task.setState(TaskState.award.getState());
				updateTask(roleID, ETaskType.GrowUp_VALUE, task);
				ITask taskNext = getTypeIndexTask(roleID, req.getType().getNumber(), req.getTaskId()+1);
				if(taskNext != null) {
					PlayerRole playerRole = playerService.updateGuideTaskId(roleID, taskNext.getTaskID());
					playerRoleDao.cacheUpdate(playerRole);
					builder.setTask(taskNext.toTaskInfo());
				}
				playerService.updateGuideTaskState(roleID, task.getTaskID(), TaskState.award.getState());
			}else {
				// 日常任务次数限制
				if(req.getType() == ETaskType.Day) {
					int dayCount = ServiceManager.getTaskService().getDayCount(roleID);
					dayCount+=1;
					ServiceManager.getTaskService().setDayCount(roleID, dayCount);
					if(dayCount >= 5) {
						return;
					}
				}
				// 刷新任务
				task.setState(TaskState.award.getState());
				updateTask(roleID, ETaskType.Day_VALUE, task);
				ITask task1 = flushTask(req.getType().getNumber(), task);
				builder.setTask(task1.toTaskInfo());
				// 日常任务
				if(req.getType() == ETaskType.Day) {
					doDayTaskItem(task1);
				}
			}
		//}
	}
	
	private ITask flushTask(int type, ITask task) {
		ITaskDao taskDao = null;
		switch (type) {
			case ETaskType.GrowUp_VALUE:
				taskDao = playerTask1Dao;
			break;
			case ETaskType.Day_VALUE:
				taskDao = playerTask2Dao;
			break;
			case ETaskType.Month_VALUE:
				taskDao = playerTask3Dao;
			break;
			case ETaskType.Special_VALUE:
				taskDao = playerTask4Dao;
			break;
			case ETaskType.Guild_VALUE:
				taskDao = guildTaskDao;
			break;
		}
		return taskDao.flushTask(task);
	}

	private void deleteTask(long roleID, int type, ITask task) {
		ITaskDao taskDao = null;
		switch (type) {
			case ETaskType.GrowUp_VALUE:
				taskDao = playerTask1Dao;
			break;
			case ETaskType.Day_VALUE:
				taskDao = playerTask2Dao;
			break;
			case ETaskType.Month_VALUE:
				taskDao = playerTask3Dao;
			break;
			case ETaskType.Special_VALUE:
				taskDao = playerTask4Dao;
			break;
			case ETaskType.Guild_VALUE:
				taskDao = guildTaskDao;
			break;
		}
		taskDao.deleteTask(roleID, task);
	}
	/**
	 * 删除任务
	 *
	 * @param roleID
	 * @param req
	 * @param builder
	 */
	public void taskRemove(long roleID, TaskRemoveReq req, TaskRemoveRsp.Builder builder) {
		ITask task = getTypeIndexTask(roleID, req.getType().getNumber(), req.getTaskId());
		if(task != null) {
			deleteTask(roleID, req.getType().getNumber(), task);
			builder.setTask(task.toTaskInfo());
		}
	}

	/**
	 * 首次打开任务
	 *
	 * @param roleID
	 * @param req
	 */
	public void taskFirst(long roleID, TaskFirstReq req) {
		ITask task = getTypeIndexTask(roleID, req.getType().getNumber(), req.getTaskId());
		if(task != null) {
			task.setFirst(1);
			updateTask(roleID, req.getType().getNumber(), task);
		}
	}

	/**
	 * 刷新任务
	 *
	 * @param roleID
	 * @param req
	 * @param builder
	 */
	public void taskRefresh(long roleID, TaskRefreshReq req, TaskRefreshRsp.Builder builder) {
		if(req.getType() == ETaskType.Day) {
			ServiceManager.getTaskService().setDayCount(roleID, 0);
			ITask task = getTypeIndexTask(roleID, req.getType().getNumber(), 0);
			if(task != null) {
				ITask task1 = flushTask(req.getType().getNumber(), task);
				if(task1 != null) {
					builder.setTask(task1.toTaskInfo());
				}
			}
		}
	}

	/**
	 * 活跃天数
	 *
	 * @param task
	 * @param actionTime
	 */
	public void doActionActiveDay(long roleID, int taskType, ITask task, int actionTime) {
		if (!DateUtil.isToday(task.getLastLoginTime())) {
			task.setActionTime(task.getActionTime() + actionTime);
			task.setLastLoginTime(System.currentTimeMillis());
			// 检查任务是否已完成
			ConfigTasks config = conf.getTask(task.getTaskID());
			if(task.checkFinish(config)) {
				task.setState(TaskState.complete.getState());
				updateTask(roleID, taskType, task);
				EventManager.postTaskFinishEvent(roleID, task);
				EventManager.commitRoleEvent(roleID);
			}else {
				EventManager.postTaskUpdateEvent(roleID, taskType);
				EventManager.commitRoleEvent(roleID);
			}
			log.info("roleID {}, actionType {}, actionDesc {}, actionTime {}, taskType {}, taskID {}", roleID, TaskActionEnum.ACTIVE_DAY.getType(), TaskActionEnum.ACTIVE_DAY.getDesc(), actionTime, taskType, task.getTaskID());
		}
	}

	/**
	 * 做任务行为
	 *
	 * @param actionEnum
	 * @param actionTime
	 */
	public void doTaskAction(long roleID, TaskActionEnum actionEnum, int actionTime) {
		doTaskAction(roleID, actionEnum, actionTime, ETaskType.GrowUp_VALUE);
		doTaskAction(roleID, actionEnum, actionTime, ETaskType.Day_VALUE);
		doTaskAction(roleID, actionEnum, actionTime, ETaskType.Month_VALUE);
		doTaskAction(roleID, actionEnum, actionTime, ETaskType.Special_VALUE);
		doTaskAction(roleID, actionEnum, actionTime, ETaskType.Guild_VALUE);
	}

	public boolean doTaskAction(long roleID, TaskActionEnum actionEnum, int actionTime, int taskType) {
		try {
			List<? extends ITask> tasks = getTypeTask(roleID, taskType);
			if (tasks == null || tasks.size() == 0) {
				return false;
			}
			log.info("doTaskAction roleID {}, actionType {}, actionDesc {}, actionTime {}", roleID, actionEnum.getType(), actionEnum.getDesc(), actionTime);
			boolean doBln = false;
			for (ITask task : tasks) {
				if (task.getState() != TaskState.accept.getState()) {
					continue;
				}
				if ((task.getActionType() == actionEnum.getType())
						||(task.getActionType1() == actionEnum.getType())) {
					//地图碎片任务特殊处理
					if((task.getActionType() == TaskActionEnum.COLLECT_MAP_FRAGMENT.getType())
							||(task.getActionType1() == TaskActionEnum.COLLECT_MAP_FRAGMENT.getType())){
						MapUtil.fundInt(task.getCurItemMap(), 700000017, 1);
					}
					if(task.getActionType() == actionEnum.getType()) {
						task.setActionTime(task.getActionTime() + actionTime);
					}else{
						task.setActionTime1(task.getActionTime1() + actionTime);
					}
					updateTask(roleID,taskType,task);
					ConfigTasks config = conf.getTask(task.getTaskID());
					if(!task.checkFinish(config)) {
						continue;
					}
					if(taskType == ETaskType.Guild_VALUE){
						guildTaskReward(roleID, task, config);
					}
					if(taskType == ETaskType.GrowUp_VALUE){
						playerService.updateGuideTaskState(roleID, task.getTaskID(), TaskState.complete.getState());
					}
					Method method = this.getClass().getMethod(actionEnum.getMethod(), Long.class, Integer.class, ITask.class, Integer.class, ConfigTasks.class);
					method.invoke(this, roleID, taskType, task, actionTime, config);
					log.info("roleID {}, actionType {}, actionDesc {}, actionTime {}, taskType {}, taskID {}", roleID, actionEnum.getType(), actionEnum.getDesc(), actionTime, taskType, task.getTaskID());
					doBln = true;
				}
			}
			return doBln;
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
		}
		return false;
	}

	/**
	 * 通用次数
	 *
	 * @param task
	 * @param actionTime
	 */
	public void doActionCommonTime(Long roleID, Integer taskType, ITask task, Integer actionTime, ConfigTasks config) {
		log.info("doActionCommonTime roleID={}, taskID={}, actionTime={}, taskType={}", roleID, task.getTaskID(), actionTime, taskType);
		if(task.getState() == TaskState.accept.getState()) {
			if (task.getActionTime() + actionTime > config.getActionTime()) {
				actionTime = config.getActionTime() - task.getActionTime();
			}
			task.setActionTime(task.getActionTime() + actionTime);
			// 任务完成状态
			if (task.checkFinish(config)) {
				task.setState(TaskState.complete.getState());
				updateTask(roleID, taskType, task);
				playerService.updateGuideTaskState(roleID, task.getTaskID(), TaskState.complete.getState());
				EventManager.postTaskFinishEvent(roleID, task);
				EventManager.commitRoleEvent(roleID);
			}else {
				EventManager.postTaskUpdateEvent(roleID, taskType);
				EventManager.commitRoleEvent(roleID);
			}
		}
	}

	/**
	 * 任务目标所需要的物品或者所需完成的行为
	 *
	 * @param itemID
	 * @param count
	 */
	public void doTaskNeedItem(long roleID, int itemID, long count) {
		doTaskNeedItem(roleID, itemID, count, ETaskType.GrowUp_VALUE);
		doTaskNeedItem(roleID, itemID, count, ETaskType.Day_VALUE);
		doTaskNeedItem(roleID, itemID, count, ETaskType.Month_VALUE);
		doTaskNeedItem(roleID, itemID, count, ETaskType.Special_VALUE);
		doTaskNeedItem(roleID, itemID, count, ETaskType.Guild_VALUE);
	}

	private void doTaskNeedItem(long roleID, int itemID, long count, int taskType) {
		List<? extends ITask> tasks = getTypeTask(roleID, taskType);
		if (tasks == null || tasks.size() == 0) {
			return;
		}
		log.info("doTaskNeedItem roleID={}, itemID={}, count={}, taskType={}", roleID, itemID, count, taskType);
		for (ITask task : tasks) {
			if (task.getState() != TaskState.accept.getState()) {
				continue;
			}
			if (task.getNeedItemMap() != null && task.getNeedItemMap().containsKey(itemID)) {
				MapUtil.fundInt(task.getCurItemMap(), itemID, (int)count);
				task.setCurItem(MapUtil.mapToString(task.getCurItemMap()));
				ConfigTasksConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_TASKS);
				if(conf == null){
					throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
				}
				ConfigTasks config = conf.getTask(task.getTaskID());
				if(task.checkFinish(config)) {
					// 任务完成状态
					task.setState(TaskState.complete.getState());
					updateTask(roleID, taskType, task);
					if(taskType == ETaskType.Guild_VALUE){
						guildTaskReward(roleID, task, config);
					}
					if(taskType == ETaskType.GrowUp_VALUE){
						playerService.updateGuideTaskState(roleID, task.getTaskID(), TaskState.complete.getState());
					}
					EventManager.postTaskFinishEvent(roleID, task);
					EventManager.commitRoleEvent(roleID);
				}else {
					updateTask(roleID, taskType, task);
					EventManager.postTaskUpdateEvent(roleID, taskType);
					EventManager.commitRoleEvent(roleID);
				}
			}
		}
	}
	/**
	 * 日常任务道具需求
	 */
	private void doDayTaskItem(ITask task) {
		for(Map.Entry<Integer, Integer> entry : task.getNeedItemMap().entrySet()) {
			long count = ServiceManager.getItemService().getItemCount(task.getRoleID(), entry.getKey());
			if(count > entry.getValue()) {
				count = entry.getValue();
			}
			task.getCurItemMap().put(entry.getKey(), (int)count);
			updateTask(task.getRoleID(), ETaskType.Day_VALUE, task);
		}
	}
	/**
	 * 接任务之后，使用物品
	 *
	 * @param itemID
	 * @param count
	 */
	public void doTaskUseItem(long roleID, int itemID, long count) {
		doTaskUseItem(roleID, itemID, count, ETaskType.GrowUp_VALUE);
		doTaskUseItem(roleID, itemID, count, ETaskType.Day_VALUE);
		doTaskUseItem(roleID, itemID, count, ETaskType.Month_VALUE);
		doTaskUseItem(roleID, itemID, count, ETaskType.Special_VALUE);
		doTaskUseItem(roleID, itemID, count, ETaskType.Guild_VALUE);
	}

	private void doTaskUseItem(long roleID, int itemID, long count, int taskType) {
		List<? extends ITask> tasks = getTypeTask(roleID, taskType);
		if (tasks == null || tasks.size() == 0) {
			log.info("doTaskUseItem task == null roleID:{}", roleID);
			return;
		}
		log.info("doTaskNeedItem roleID={}, itemID={}, count={}, taskType={}",
				roleID, itemID, count, taskType);
		for (ITask task : tasks) {
			if (task.getState() != TaskState.accept.getState()) {
				continue;
			}
			if((task.getActionType() == TaskActionEnum.USE_ITEM.getType())
				||(task.getActionType1() == TaskActionEnum.USE_ITEM.getType())){
				if (task.getNeedItemMap() != null && task.getNeedItemMap().containsKey(itemID)) {
					MapUtil.fundInt(task.getCurItemMap(), itemID, (int)count);
					task.setCurItem(MapUtil.mapToString(task.getCurItemMap()));
					ConfigTasksConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_TASKS);
					if(conf == null){
						log.error("doTaskUseItem ConfigTasksConf conf == null roleID:{}", roleID);
						throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
					}
					ConfigTasks config = conf.getTask(task.getTaskID());
					if (task.checkFinish(config)) {
						// 任务完成状态
						task.setState(TaskState.complete.getState());
						updateTask(roleID, taskType, task);
						if(taskType == ETaskType.Guild_VALUE){
							guildTaskReward(roleID, task, config);
						}
						if(taskType == ETaskType.GrowUp_VALUE){
							playerService.updateGuideTaskState(roleID, task.getTaskID(), TaskState.complete.getState());
						}
						EventManager.postTaskFinishEvent(roleID, task);
						EventManager.commitRoleEvent(roleID);
					} else {
						updateTask(roleID, taskType, task);
						EventManager.postTaskUpdateEvent(roleID, taskType);
						EventManager.commitRoleEvent(roleID);
					}
				}
			}

		}
	}

	public void taskPoint(long roleID, TaskPointReq req) {
		OnlineRole onlineRole = OnlineHelper.getInstance().getOnlineMap().getIfPresent(roleID);
		if(onlineRole == null) {
			log.error("taskPoint onlineRole == null roleID:{}", roleID);
			return;
		}
		if(onlineRole.getTaskPoint() != req.getPoint().getNumber()) {
			onlineRole.setTaskPoint(req.getPoint().getNumber());
		}
	}
	/**
	 * 检查是否有已接受的指定行为成长任务
	 * @param roleID
	 * @param actionEnum
	 * @return
	 */
	public ConfigTasks checkTaskAction(long roleID, TaskActionEnum actionEnum) {
		List<? extends ITask> guildTaskList = guildTaskDao.cacheLoadAll(roleID);
		if((guildTaskList != null)&&(guildTaskList.size() > 0)) {
			for (int i = 0; i < guildTaskList.size(); i++) {
				GuildTask task = (GuildTask) guildTaskList.get(i);
				// 任务没有接受
				if (task.getState() != TaskState.accept.getState()) {
					continue;
				}
				// 不是对应的行为任务
				if ((task.getActionType() == actionEnum.getType())
						||(task.getActionType1() == actionEnum.getType())) {
					ConfigTasks config = conf.getTask(task.getTaskID());
					if (config != null) {
						return config;
					}
				}
			}
		}
		List<? extends ITask> playerTask1List = playerTask1Dao.cacheLoadAll(roleID);
		if((playerTask1List != null)&&(playerTask1List.size() > 0)) {
			for (int i = 0; i < playerTask1List.size(); i++) {
				PlayerTask1 task = (PlayerTask1) playerTask1List.get(i);
				// 任务没有接受
				if (task.getState() != TaskState.accept.getState()) {
					continue;
				}
				// 不是对应的行为任务
				if ((task.getActionType() == actionEnum.getType())
						||(task.getActionType1() == actionEnum.getType())) {
					ConfigTasks config = conf.getTask(task.getTaskID());
					if (config != null) {
						return config;
					}
				}
			}
		}
		List<? extends ITask> playerTask2List = playerTask2Dao.cacheLoadAll(roleID);
		if((playerTask2List != null)&&(playerTask2List.size() > 0)) {
			for (int i = 0; i < playerTask2List.size(); i++) {
				PlayerTask2 task = (PlayerTask2) playerTask2List.get(i);
				// 任务没有接受
				if (task.getState() != TaskState.accept.getState()) {
					continue;
				}
				// 不是对应的行为任务
				if ((task.getActionType() == actionEnum.getType())
						||(task.getActionType1() == actionEnum.getType())) {
					ConfigTasks config = conf.getTask(task.getTaskID());
					if (config != null) {
						return config;
					}
				}
			}
		}
		List<? extends ITask> playerTask3List = playerTask3Dao.cacheLoadAll(roleID);
		if((playerTask3List != null)&&(playerTask3List.size() > 0)) {
			for (int i = 0; i < playerTask3List.size(); i++) {
				PlayerTask3 task = (PlayerTask3) playerTask3List.get(i);
				// 任务没有接受
				if (task.getState() != TaskState.accept.getState()) {
					continue;
				}
				// 不是对应的行为任务
				if ((task.getActionType() == actionEnum.getType())
						||(task.getActionType1() == actionEnum.getType())) {
					ConfigTasks config = conf.getTask(task.getTaskID());
					if (config != null) {
						return config;
					}
				}
			}
		}
		List<? extends ITask> playerTask4List = playerTask4Dao.cacheLoadAll(roleID);
		if((playerTask4List != null)&&(playerTask4List.size() > 0)) {
			for (int i = 0; i < playerTask4List.size(); i++) {
				PlayerTask4 task = (PlayerTask4) playerTask4List.get(i);
				// 任务没有接受
				if (task.getState() != TaskState.accept.getState()) {
					continue;
				}
				// 不是对应的行为任务
				if ((task.getActionType() == actionEnum.getType())
						||(task.getActionType1() == actionEnum.getType())) {
					ConfigTasks config = conf.getTask(task.getTaskID());
					if (config != null) {
						return config;
					}
				}
			}
		}
		return null;
	}

	public void guildTaskReward(long roleID, ITask task, ConfigTasks config){
		// 清空玩家的商会任务
		task.setState(TaskState.award.getState());
		updateTask(roleID, ETaskType.Guild_VALUE, task);
		// 添加个人商会积分
		changeGuildScore(roleID, config.getGuildScore(), ResourceBillEnum.taskReward);

		PlayerRole playerRole = playerService.getPlayer(roleID);
		GuildTaskCompleteEvent event = EventManager.borrowEvent(GuildTaskCompleteEvent.class);
		event.setRoleID(roleID);
		event.setGuildID(playerRole.getGuildId());
		event.setTaskID(task.getTaskID());
		event.setIndex(task.getIndex());
		event.setActionTime(task.getActionTime());
		event.setCurItem(task.getCurItem());
		event.setGuildScore(config.getGuildScore());
		TopicManager.getInstance().publishTopic(event);
		// 更新接受任务类型标记
		ServiceManager.getCommonService().setAcceptTypeTask(roleID, ETaskType.Guild_VALUE, -1);
		EventManager.postTaskActionEvent(roleID, TaskActionEnum.FINISH_GUILD_TASK, 1);
		EventManager.commitRoleEvent(roleID);
	}
}
