package com.dj.serverapi.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dj.domain.type.AccessType;
import com.dj.domain.entity.player.PlayerNpc;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IPlayerNpcDao;
import com.dj.domain.util.lib.QueryParamMap;

@Component
public class PlayerNpcDao extends BaseCacheDao<PlayerNpc> implements IPlayerNpcDao {

	@Override
	public List<PlayerNpc> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}
}
