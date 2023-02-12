package com.dj.serverapi.service.inf;

public interface IPayService {

	/**
	 *	支付宝交易订单号
	 * @param roleId
	 * @param tradeNo
	 */
	void addAliPayItem(Long roleId, String tradeNo);
	/**
	 *	微信交易订单号
	 * @param roleId
	 * @param tradeNo
	 */
	void addWxPayItem(Long roleId, String tradeNo);
}
