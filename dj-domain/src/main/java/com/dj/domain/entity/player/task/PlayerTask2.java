package com.dj.domain.entity.player.task;

import java.util.Map;

import com.dj.domain.enums.TaskActionEnum;

import com.dj.domain.enums.TaskState;
import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import com.dj.domain.config.ConfigTasks;
import com.dj.protobuf.task.ETaskType;
import com.dj.protobuf.task.TaskInfo;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.Maps;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.MapUtils;

/**
 * @ClassName: PlayerTask2 
 * @Description: 每日任务
 * @author zcq 
 * @date 2020年2月19日
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerTask2 extends BaseEntity implements Comparable<PlayerTask2>, ITask {

	private static final long serialVersionUID = -6905844366060723044L;

	public PlayerTask2(long roleID) {
		super(roleID);
	}

	private int taskID;

	private int index;
	
	/**
	 * 行为类型
	 */
	private int actionType;
	/**
	 *	行为次数
	 */
	private int actionTime;
	/**
	 * 行为类型
	 */
	private int actionType1;
	/**
	 * 行为次数
	 */
	private int actionTime1;
	/**
	 * 0 未接受， 1 已接受， 2 已完成， 3 已领取
	 */
	private int state;
	
	/**
	 *	首次状态 0首次，1首次用完
	 */
	private int first;
	
	/**
	 *	任务目标所需要的物品或者所需完成的行为
	 */
	private String                needItem;
	private Map<Integer, Integer> needItemMap;
	
	/**
	 *	任务目前所获得的物品及数量或者所执行的行为次数
	 */
	private String                curItem;
	private Map<Integer, Integer> curItemMap;
	
	/**
	 *	上次登录时间
	 */
	private long lastLoginTime;

//	@Override
//	public String getPrimaryKeyName() {
//		return "taskID";
//	}
//
//	@Override
//	public Object getPrimaryKeyValue() {
//		return taskID;
//	}


	@Override
	public IEntity copy() {
		PlayerTask2 item = new PlayerTask2();
		copySuper(item);
		item.setId(id);
		item.setTaskID(taskID);
		item.setIndex(index);
		item.setActionType(actionType);
		item.setActionTime(actionTime);
		item.setActionType1(actionType1);
		item.setActionTime1(actionTime1);
		item.setState(state);
		item.setFirst(first);
		item.setNeedItemMap(needItemMap);
		item.setNeedItemMap(needItemMap);
		item.setNeedItem(MapUtil.mapToString(needItemMap));
		item.setCurItemMap(curItemMap);
		item.setCurItem(MapUtil.mapToString(curItemMap));
		item.setLastLoginTime(lastLoginTime);
		return item;
	}
	
	@Override
	public int compareTo(PlayerTask2 verify) {
		return this.index - verify.getIndex();
	}

	@Override
	public TaskInfo toTaskInfo() {
		TaskInfo.Builder builder = TaskInfo.newBuilder();
		if(taskID > 0){
			builder.setId(id);
			builder.setTaskId(taskID);
			builder.setIndex(index);
			builder.setType(ETaskType.Day);
			builder.setActionType(actionType);
			builder.setActionTime(actionTime);
			builder.setActionType1(actionType1);
			builder.setActionTime1(actionTime1);
			if ((needItemMap == null)&&(StringUtil.isNotEmpty0Null(needItem))) {
				setNeedItemMap(MapUtil.stringToMap(needItem,";","-"));
			}else if (needItemMap == null){
				setNeedItemMap(Maps.newHashMapWithExpectedSize(0));
			}
			if ((curItemMap == null)&&(StringUtil.isNotEmpty0Null(curItem))) {
				setCurItemMap(MapUtil.stringToMap(curItem,";","-"));
			}else if (curItemMap == null){
				setCurItemMap(Maps.newHashMapWithExpectedSize(0));
			}
//			if(needItemMap != null && needItemMap.size() > 0) {
//				builder.putAllNeedItem(needItemMap);
//			}
			if(curItemMap != null && curItemMap.size() > 0) {
				builder.putAllCurItem(curItemMap);
			}
			builder.setState(state);
			builder.setFirst(first);
		}
		return builder.build();
	}

	@Override
	public boolean checkFinish(ConfigTasks config) {
		if ((actionType != TaskActionEnum.NEED_ITEM.getType())
				&&(actionTime < config.getActionTime())) {
			return false;
		}
		if ((actionType1 != TaskActionEnum.NEED_ITEM.getType())&&(actionType1 != TaskActionEnum.USE_ITEM.getType())
				&&(actionTime1 < config.getActionTime1())) {
			return false;
		}
		if ((needItemMap == null)&&(StringUtil.isNotEmpty0Null(needItem))) {
			setNeedItemMap(MapUtil.stringToMap(needItem,";","-"));
		}else if (needItemMap == null){
			setNeedItemMap(Maps.newHashMapWithExpectedSize(0));
		}
		if ((curItemMap == null)&&(StringUtil.isNotEmpty0Null(curItem))) {
			setCurItemMap(MapUtil.stringToMap(curItem,";","-"));
		}else if (curItemMap == null){
			setCurItemMap(Maps.newHashMapWithExpectedSize(0));
		}

		if(needItemMap != null && needItemMap.size() > 0) {
			for (int itemId : needItemMap.keySet()) {
				int needCount = MapUtils.getIntValue(needItemMap, itemId);
				int curCount = MapUtils.getIntValue(curItemMap, itemId);
				if (curCount < needCount) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void clear() {
		setIndex(0);
		setTaskID(0);
		setActionType(0);
		setActionTime(0);
		setActionType1(0);
		setActionTime1(0);
		setState(TaskState.noAccept.getState());
		setFirst(0);
		setNeedItem("");
		setNeedItemMap(Maps.newHashMapWithExpectedSize(0));
		setCurItem("");
		setCurItemMap(Maps.newHashMapWithExpectedSize(0));
		setLastLoginTime(0l);
	}

}