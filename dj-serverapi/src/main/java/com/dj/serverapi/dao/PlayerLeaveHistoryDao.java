package com.dj.serverapi.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dj.domain.type.AccessType;
import com.dj.domain.entity.player.PlayerLeaveHistory;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IPlayerLeaveHistoryDao;
import com.dj.domain.util.lib.QueryParamMap;

@Component
public class PlayerLeaveHistoryDao extends BaseCacheDao<PlayerLeaveHistory> implements IPlayerLeaveHistoryDao {

	@Override
	public List<PlayerLeaveHistory> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		List<PlayerLeaveHistory> list = selectList(queryParams, roleID, AccessType.DIRECT_DB);
		return list;
	}
}
