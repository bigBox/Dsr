package com.dj.serverapi.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dj.domain.type.AccessType;
import com.dj.domain.entity.player.PlayerItemInteractHistory;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IPlayerItemInteractHistoryDao;
import com.dj.domain.util.lib.QueryParamMap;

@Component
public class PlayerItemInteractHistoryDao extends BaseCacheDao<PlayerItemInteractHistory> implements IPlayerItemInteractHistoryDao {

	@Override
	public List<PlayerItemInteractHistory> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		List<PlayerItemInteractHistory> list = selectList(queryParams, roleID, AccessType.DIRECT_DB);
		return list;
	}
}
