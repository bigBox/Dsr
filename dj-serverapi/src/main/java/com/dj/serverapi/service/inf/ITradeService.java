package com.dj.serverapi.service.inf;

import java.util.Set;


public interface ITradeService {

	/**
	 *	添加订单
	 * 
	 * @param tradeOrder
	 */
	//void addTradeOrder(GlobalTradeOrder tradeOrder);

	/**
	 *	删除订单
	 * 
	 * @param tradeOrder
	 */
	//void delTradeOrder(GlobalTradeOrder tradeOrder);

	/**
	 *	获取订单
	 * @param itemId
	 * @param orderId
	 * @param type
	 * @return
	 */
	//GlobalTradeOrder getTradeOrder(long itemId, long orderId, int type);
	/**
	 *	获取所有订单
	 * @param itemId
	 * @param type
	 * @return
	 */
	//Map<Long, GlobalTradeOrder> getAllTradeOrder(long itemId, int type);

	/**
	 *	添加订单
	 *
	 * @param tradeRecord
	 */
	//void addTradeRecord(GlobalTradeRecord tradeRecord);

	/**
	 *	删除订单
	 *
	 * @param tradeRecord
	 */
	//void delTradeRecord(GlobalTradeRecord tradeRecord);

	/**
	 *	获取订单
	 *
	 * @param orderID
	 * @param itemId
	 * @return
	 */
	//GlobalTradeRecord getTradeRecord(long itemId, long orderID);
	/**
	 *	获取所有订单
	 *
	 * @param itemId
	 * @return
	 */
	//Map<Long, GlobalTradeRecord> getAllTradeRecord(long itemId);


	//void tradeEnqueue(long roleID, TradeEnqueueReq req);

	void addTradeRoleId(long roleId);

	void removeTradeRoleId(long roleId);

	Set<Long> getTradeRoleIds();
}
