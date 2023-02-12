package com.dj.serverapi.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dj.domain.type.AccessType;
import com.dj.domain.entity.player.PlayerVerifyHistory;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IPlayerVerifyHistoryDao;
import com.dj.domain.util.lib.QueryParamMap;

@Component
public class PlayerVerifyHistoryDao extends BaseCacheDao<PlayerVerifyHistory> implements IPlayerVerifyHistoryDao {

	@Override
	public List<PlayerVerifyHistory> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		List<PlayerVerifyHistory> list = selectList(queryParams, roleID, AccessType.DIRECT_DB);
		return list;
	}
}
