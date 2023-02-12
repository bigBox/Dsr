package com.dj.serverapi.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dj.domain.type.AccessType;
import com.dj.domain.entity.global.GlobalTradeOrder;
import com.dj.protobuf.trade.TradeType;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IGlobalTradeOrderDao;
import com.dj.domain.util.lib.QueryParamMap;

@Component
public class GlobalTradeOrderDao extends BaseCacheDao<GlobalTradeOrder> implements IGlobalTradeOrderDao {

	@Override
	public String getAccessType() {
		return AccessType.DIRECT_DB;
	}

	@Override
	public List<GlobalTradeOrder> readDbData(int itemID, TradeType tradeType) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("itemID", itemID);
		queryParams.put("isDelete", 0);
		if(tradeType.getNumber() > 0) {
			queryParams.put("type", tradeType.getNumber());
		}
		return selectList(queryParams, itemID, AccessType.DIRECT_DB);
	}

	@Override
	public List<GlobalTradeOrder> getRoleTradeOrder(long roleID, TradeType tradeType) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(2);
		queryParams.put("roleID", roleID);
		queryParams.put("isDelete", 0);
		if(tradeType.getNumber() > 0) {
			queryParams.put("type", tradeType.getNumber());
		}
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}
}
