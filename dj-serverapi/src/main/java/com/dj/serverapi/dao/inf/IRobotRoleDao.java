package com.dj.serverapi.dao.inf;

import com.dj.domain.entity.robot.RobotRole;
import com.dj.servercore.db.inf.dao.IDaoOperation;

public interface IRobotRoleDao extends IDaoOperation<RobotRole> {

	RobotRole createRole(long roleID, int level, String reqAccount, String channel, int gateServerID, int fiveEle);

	int cacheUpdate(RobotRole pojo);
}
