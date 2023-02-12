package com.dj.serverapi.dao;

import com.dj.domain.entity.robot.RobotShowTableInfo;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IRobotShowTableInfoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RobotShowTableInfoDao extends BaseCacheDao<RobotShowTableInfo> implements IRobotShowTableInfoDao {

	@Override
	public List<RobotShowTableInfo> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}
}
