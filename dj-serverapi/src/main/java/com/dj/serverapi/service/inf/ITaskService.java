package com.dj.serverapi.service.inf;

import com.dj.domain.config.ConfigGuideTask;

public interface ITaskService {

	/**
	 *	领取新手引导奖励 并检查新手引导是否完成
	 * 
	 * @param roleID
	 * @param configGuideTask
	 * @return
	 */
	boolean getGuideRewardCheckFinish(long roleID, ConfigGuideTask configGuideTask);

	/**
     *	设置日常任务个数
     * @param roleID
     */
    void setDayCount(long roleID, int count);
    
    /**
	 *	获取日常任务个数
	 * @param roleID
	 * @return
	 */
	int getDayCount(long roleID);
}
