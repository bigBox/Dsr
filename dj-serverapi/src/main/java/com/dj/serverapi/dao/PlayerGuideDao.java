package com.dj.serverapi.dao;

import com.dj.domain.type.AccessType;
import com.dj.domain.entity.player.PlayerGuide;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IPlayerGuideDao;
import com.dj.domain.util.lib.QueryParamMap;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerGuideDao extends BaseCacheDao<PlayerGuide> implements IPlayerGuideDao {

	@Override
	public List<PlayerGuide> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}
}
