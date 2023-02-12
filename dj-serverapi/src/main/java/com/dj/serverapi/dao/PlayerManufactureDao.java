package com.dj.serverapi.dao;

import com.dj.domain.type.AccessType;
import com.dj.domain.entity.player.PlayerManufacture;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IPlayerManufactureDao;
import com.dj.domain.util.lib.QueryParamMap;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerManufactureDao extends BaseCacheDao<PlayerManufacture> implements IPlayerManufactureDao {

	@Override
	public List<PlayerManufacture> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}
}
