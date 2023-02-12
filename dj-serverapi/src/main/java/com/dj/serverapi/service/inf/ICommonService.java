package com.dj.serverapi.service.inf;

import java.util.Map;

import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.config.ConfigDigGold;
import com.dj.domain.data.AttrBill;
import com.dj.domain.util.inf.IArgumentRunnable;

public interface ICommonService {

	/**
	 *	玩家属性变化
	 * 
	 * @param roleID
	 * @param key
	 * @param value
	 */
	void addAttrBill(long roleID, String key, long value, ResourceBillEnum bill);

	/**
	 *	处理玩家属性变化
	 * 
	 * @param roleID
	 * @param run
	 */
	void doAttrBill(long roleID, IArgumentRunnable<AttrBill> run);

	/**
	 *	挖矿属性变化
	 * @param roleID
	 * @param digGold
	 */
	void changeAttrDigGold(long roleID, ConfigDigGold digGold);

	/**
	 *	获取客户端数据
	 * 
	 * @param roleID
	 * @return
	 */
	Map<String, Integer> getClientData(long roleID);

	/**
	 *	修改客户端数据
	 * 
	 * @param roleID
	 * @param key
	 * @param value
	 */
	void changeClientData(long roleID, String key, int value);
	
	/**
	 * 是否接受该类型的任务
	 * @param roleID
	 * @param taskType
	 * @return
	 */
	int getAcceptTypeTask(long roleID, int taskType);
    
	/**
	 * 设置接受该类型的任务状态
	 * @param roleID
	 * @param taskType
	 * @param taskID
	 */
    void setAcceptTypeTask(long roleID, int taskType, int taskID);

    /**
     * 获取生态园结算状态
     * @param roleID
     * @return
     */
    boolean getParkDrawPrize(long roleID);
}
