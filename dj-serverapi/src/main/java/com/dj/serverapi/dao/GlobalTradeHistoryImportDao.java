package com.dj.serverapi.dao;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.entity.global.GlobalTradeHistoryImport;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IGlobalTradeHistoryImportDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GlobalTradeHistoryImportDao extends BaseCacheDao<GlobalTradeHistoryImport> implements IGlobalTradeHistoryImportDao {

	@Override
	public String getAccessType() {
		return AccessType.DIRECT_DB;
	}

	@Override
	public List<GlobalTradeHistoryImport> readDbData(String itemID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(2);
		queryParams.put("itemID", itemID);
		return selectList(queryParams, GlobalRoleID.get(), AccessType.DIRECT_DB);
	}
}
