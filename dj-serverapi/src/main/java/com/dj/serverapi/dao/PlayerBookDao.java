package com.dj.serverapi.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dj.domain.type.AccessType;
import com.dj.domain.entity.player.PlayerBook;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IPlayerBookDao;
import com.dj.domain.util.lib.QueryParamMap;

@Component
public class PlayerBookDao extends BaseCacheDao<PlayerBook> implements IPlayerBookDao {

	@Override
	public List<PlayerBook> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}
}
