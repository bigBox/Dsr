package com.dj.serverapi.service.inf;

public interface IOtherService {

	/**
	 *	获取并添加每天挖矿次数
	 * @param roleID
	 * @return
	 */
	int getAddMineCount(long roleID);

	/**
	 *	获取每天鉴定次数
	 * @param roleID
	 * @return
	 */
	int getVerifyCount(long roleID);
    
	/**
	 * 	添加每天鉴定次数
	 * @param roleID
	 */
    void addVerifyCount(long roleID);
}
