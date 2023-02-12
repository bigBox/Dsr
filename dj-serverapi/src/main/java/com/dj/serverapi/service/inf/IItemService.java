package com.dj.serverapi.service.inf;

import java.util.Map;

import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.data.ItemBill;
import com.dj.domain.data.ItemInteractLog;
import com.dj.domain.util.inf.IArgumentRunnable;

public interface IItemService {

	/**
	 *	添加物品流通
	 * 
	 * @param roleID
	 * @param itemID
	 * @param itemCount
	 */
	void addItemBill(long roleID, int itemID, long itemCount, ResourceBillEnum bill, boolean post2Client, boolean visible);

	/**
	 *	处理物品流通
	 * 
	 * @param roleID
	 * @param run
	 */
	void doItemBill(long roleID, IArgumentRunnable<ItemBill> run);

	/**
	 *	记录道具来源
	 * 
	 * @param roleID
	 * @param itemID
	 * @param count
	 * @param source
	 */
	void recordItemSource(long roleID, int itemID, long count, int source);

	/**
	 *	获取道具来源
	 * 
	 * @param roleID
	 * @param itemID
	 * @return
	 */
	int getItemSource(long roleID, int itemID);
	
	/**
	 *	设置地图碎片
	 * 
	 * @param roleID
	 * @param pieceMap
	 */
	void setItemCount(long roleID, Map<Integer, Long> pieceMap);
	
	/**
	 *	设置地图碎片
	 * 
	 * @param roleID
	 * @param itemID
	 * @param count
	 */
	void setItemCount(long roleID, int itemID, long count);
	
	/**
	 * 获取地图碎片
	 * 
	 * @param roleID
	 */
	Map<Integer, Long> getItemCount(long roleID);
	
	/**
	 * 获取地图碎片
	 * @param roleID
	 * @param itemID
	 * @return
	 */
	long getItemCount(long roleID, int itemID);
	
	
	/**
	 * 添加好友互动物品日志
	 * @param roleID
	 * @param itemID
	 * @param itemCount
	 * @param interactRoleID
	 * @param ps
	 */
	void addItemInteractLog(long roleID, int itemID, long itemCount, long interactRoleID, String ps);
	
	/**
	 * 处理好友互动物品日志
	 * @param roleID
	 * @param run
	 */
	void doItemInteractLog(long roleID, IArgumentRunnable<ItemInteractLog> run);
}
