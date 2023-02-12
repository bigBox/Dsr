package com.dj.serverapi.redis.model;

import java.util.List;

import com.dj.domain.RedisKeys;
import com.dj.protobuf.task.ETaskType;
import com.dj.serverapi.EventProvider;
import com.dj.serverapi.redis.base.InitModel;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.domain.util.DateUtil;
import com.google.common.collect.Lists;

/**
 * @author zcq
 * @ClassName: TaskModel
 * @Description: 任务
 * @date 2019年8月7日
 */
public class TaskModel extends InitModel {

    public TaskModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_TASK, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
        this.data.set(RedisKeys.KEY_TASK_GUIDE_REWARD, Lists.newArrayList());
        this.data.set(RedisKeys.KEY_TASK_GUIDE_FINISH, 0);
        initTime();
    }

    @Override
    protected void onLoadOver() {
        // 如果初始化时间不是今天就重置
        if (!DateUtil.isToday(getInitTime())) {
            resetInitTime();
            setDayCount(0);
        }
    }

    public List<Integer> getGuideReward() {
        return this.data.get(RedisKeys.KEY_TASK_GUIDE_REWARD);
    }

    /**
     *	完成新手引导
     */
    public void finishGuide() {
        this.data.set(RedisKeys.KEY_TASK_GUIDE_FINISH, 1);
    }
    
    public int getDayCount() {
    	if(this.data.isExists(RedisKeys.KEY_TASK_DAY_COUNT)) {
    		return this.data.get(RedisKeys.KEY_TASK_DAY_COUNT);
    	}
    	return 0;
    }
    
    public void setDayCount(int count) {
    	this.data.set(RedisKeys.KEY_TASK_DAY_COUNT, count);
    }
}
