package com.dj.serverapi.dao;

import com.dj.domain.type.AccessType;
import com.dj.domain.entity.global.GlobalTradeHistory;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IGlobalTradeHistoryDao;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.domain.util.lib.QueryParamMap;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GlobalTradeHistoryDao extends BaseCacheDao<GlobalTradeHistory> implements IGlobalTradeHistoryDao {

	@Override
	public String getAccessType() {
		return AccessType.DIRECT_DB;
	}

	@Override
	public List<GlobalTradeHistory> readDbData(int itemID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(2);
		queryParams.put("itemID", itemID);
		queryParams.put("descTop", ConfigSundryConf.tradeHistoryDescTop);
		return selectList(queryParams, itemID, AccessType.DIRECT_DB);
	}
}
