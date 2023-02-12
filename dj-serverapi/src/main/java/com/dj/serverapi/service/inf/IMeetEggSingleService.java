package com.dj.serverapi.service.inf;

import java.util.Date;

import com.dj.domain.data.meetEgg.MeetEggBuild;

public interface IMeetEggSingleService {

	/**
	 *	获取接鸡蛋建筑数据
	 * 
	 * @param roleID
	 * @param buildID
	 * @return
	 */
	MeetEggBuild getMeetEggBuild(long roleID, int buildID);

	/**
	 *	检测接鸡蛋奖励
	 * 
	 * @param roleID
	 * @return
	 */
	boolean hasMeetEggReward(long roleID, Date nowDate);

	/**
	 *	获取接鸡蛋奖励
	 * 
	 * @param roleID
	 * @return
	 */
	int getMeetEggReward(long roleID, Date nowDate);

	/**
	 *	更新接鸡蛋建筑数据
	 * 
	 * @param roleID
	 * @param buildID
	 * @param meetEggTime
	 * @param score
	 */
	void updateMeetEggBuild(long roleID, int buildID, long meetEggTime, int score);

	/**
	 *	更新接鸡蛋奖励发放时间
	 * 
	 * @param lastRewardTime
	 */
	void updateMeetEggLastRewardTime(long roleID, long lastRewardTime);
}
