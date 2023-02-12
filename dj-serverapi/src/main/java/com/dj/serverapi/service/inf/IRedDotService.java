package com.dj.serverapi.service.inf;

public interface IRedDotService {

	/**
	 *	获取待鉴定数量
	 * 
	 * @param roleID
	 * @return
	 */
	int getVerifyingCount(long roleID);

	/**
	 *	获取待鉴定数量
	 *
	 * @param roleID
	 * @return
	 */
	int getRobotVerifyingCount(long roleID);

	/**
	 *	生态园待喂动物数量
	 * 
	 * @param roleID
	 * @return
	 */
	int getFeedCount(long roleID);

	/**
	 *	生态园待喂动物数量
	 *
	 * @param roleID
	 * @return
	 */
	int getRobotFeedCount(long roleID);
}
