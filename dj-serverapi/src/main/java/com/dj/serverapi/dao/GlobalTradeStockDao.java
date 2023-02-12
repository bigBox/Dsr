package com.dj.serverapi.dao;

import org.springframework.stereotype.Component;

import com.dj.domain.type.AccessType;
import com.dj.domain.entity.global.GlobalTradeStock;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IGlobalTradeStockDao;

@Component
public class GlobalTradeStockDao extends BaseCacheDao<GlobalTradeStock> implements IGlobalTradeStockDao {
	
	@Override
	public String getAccessType() {
		return AccessType.DIRECT_DB;
	}
}
