package com.dj.serverapi.dao;

import com.dj.domain.entity.robot.RobotObstacle;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IRobotObstacleDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RobotObstacleDao extends BaseCacheDao<RobotObstacle> implements IRobotObstacleDao {

	@Override
	public void initObstacle(long roleID) {

	}

	@Override
	public List<RobotObstacle> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}
}
