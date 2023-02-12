package com.dj.serverapi.dao;

import com.dj.domain.entity.player.PlayerGameScoreRank;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IPlayerGameScoreRankDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerGameScoreRankDao extends BaseCacheDao<PlayerGameScoreRank> implements IPlayerGameScoreRankDao {

	@Override
	public List<PlayerGameScoreRank> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}
}
