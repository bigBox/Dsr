package com.dj.serverapi.dao.inf;

import com.dj.domain.entity.robot.RobotFarm;
import com.dj.servercore.db.inf.dao.IDaoOperation;

public interface IRobotFarmDao extends IDaoOperation<RobotFarm> {

	void initNewRoleFarm(long roleID);
}
