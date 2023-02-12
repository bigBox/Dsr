package com.dj.serverapi;

import java.util.Map;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.enums.SyncCommonEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.entity.player.task.ITask;
import com.dj.domain.event.PlayerAttrEvent;
import com.dj.domain.event.PlayerLevelUpEvent;
import com.dj.domain.event.TaskActionEvent;
import com.dj.domain.event.TaskFinishEvent;
import com.dj.domain.event.TaskUpdateEvent;
import com.dj.domain.topic.SyncAttrEvent;
import com.dj.domain.topic.SyncCommonEvent;
import com.dj.domain.topic.SyncItemEvent;
import com.dj.serverapi.helper.OnlineHelper;
import com.dj.servercore.event.AbsEventManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class EventProvider extends AbsEventManager {

    /**
     *	提交玩家升级事件
     *
     * @param roleID
     * @param nowLevel
     * @param previousLevel
     */
    public static void postPlayerLevelUpEvent(long roleID, int nowLevel, int previousLevel) {
        PlayerLevelUpEvent event = borrowEvent(PlayerLevelUpEvent.class);
        event.setRoleID(roleID);
        event.setNowLevel(nowLevel);
        event.setPreviousLevel(previousLevel);
        putEventCache(event);
    }

    /**
     *	提交玩家属性事件
     *
     * @param roleID
     * @param attr
     * @param value
     */
    public static void postPlayerAttrEvent(long roleID, PlayerAttrEnum attr, long value) {
    	if(roleID == GlobalRoleID.getXiaoXun()) {
    		return;
    	}
        Map<String, Long> attrMap = OnlineHelper.getInstance().getOnlineRoleAttr(roleID);
        attrMap.put(attr.getKey(), value);
        PlayerAttrEvent event = borrowEvent(PlayerAttrEvent.class);
        event.setRoleID(roleID);
        event.setAttr(attr);
        event.setValue(value);
        putEventCache(event);
    }

    /**
     *	提交同步通用事件
     *
     * @param roleID
     * @param type
     * @param args
     */
    public static void postSyncCommonEvent(long roleID, SyncCommonEnum type, Object... args) {
        SyncCommonEvent event = borrowEvent(SyncCommonEvent.class);
        event.setRoleID(roleID);
        event.setType(type);
        event.setArgs(args);
        putEventCache(event);
    }

    /**
     *	提交同步道具事件
     *
     * @param roleID
     */
    public static void postSyncItemEvent(long roleID) {
        SyncItemEvent event = borrowEvent(SyncItemEvent.class);
        event.setRoleID(roleID);
        putEventCache(event);
    }

    /**
     *	提交同步玩家属性事件
     *
     * @param roleID
     */
    public static void postSyncAttrEvent(long roleID) {
        SyncAttrEvent event = borrowEvent(SyncAttrEvent.class);
        event.setRoleID(roleID);
        putEventCache(event);
    }

    /**
     *	提交任务变更事件
     *
     * @param roleID
     * @param taskType
     */
    public static void postTaskUpdateEvent(long roleID, int taskType) {
        log.info("EventProvider postTaskUpdateEvent roleID={}, taskType={}", roleID, taskType);
        TaskUpdateEvent event = borrowEvent(TaskUpdateEvent.class);
        event.setRoleID(roleID);
        event.setTaskType(taskType);
        putEventCache(event);
    }
    
    /**
     *	提交成长任务完成事件
     *
     * @param roleID
     * @param task
     */
    public static void postTaskFinishEvent(long roleID, ITask task) {
        log.info("EventProvider postTaskFinishEvent roleID={}, taskID={}, state={}", roleID, task.getTaskID(), task.getState());
    	TaskFinishEvent event = borrowEvent(TaskFinishEvent.class);
        event.setRoleID(roleID);
        event.setTask(task);;
        putEventCache(event);
    }

    /**
     *	提交任务行为事件
     *
     * @param roleID
     * @param actionEnum
     * @param actionTime
     */
    public static void postTaskActionEvent(long roleID, TaskActionEnum actionEnum, int actionTime) {
        log.info("EventProvider postTaskActionEvent roleID={}, actionEnum={}, actionTime={}", roleID, actionEnum, actionTime);
    	TaskActionEvent event = borrowEvent(TaskActionEvent.class);
    	event.setRoleID(roleID);
    	event.setActionEnum(actionEnum);
    	event.setActionTime(actionTime);
    	putEventCache(event);
    }
}
