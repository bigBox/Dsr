package com.dj.serverapi.dao;

import com.dj.domain.entity.global.GlobalTradeRecord;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.trade.TradeType;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IGlobalTradeRecordDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GlobalTradeRecordDao extends BaseCacheDao<GlobalTradeRecord> implements IGlobalTradeRecordDao {

	@Override
	public String getAccessType() {
		return AccessType.DIRECT_DB;
	}

	@Override
	public List<GlobalTradeRecord> readDbData(int itemID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("itemID", itemID);
		return selectList(queryParams, itemID, AccessType.DIRECT_DB);
	}

	@Override
	public List<GlobalTradeRecord> getRoleTradeRecord(long roleID, TradeType tradeType) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(2);
		queryParams.put("roleID", roleID);
		if(tradeType.getNumber() > 0) {
			queryParams.put("type", tradeType.getNumber());
		}
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}
}
