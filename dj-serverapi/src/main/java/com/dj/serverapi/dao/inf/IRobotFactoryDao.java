package com.dj.serverapi.dao.inf;

import com.dj.domain.entity.robot.RobotFactory;
import com.dj.servercore.db.inf.dao.IDaoOperation;

public interface IRobotFactoryDao extends IDaoOperation<RobotFactory> {

	void initFactory(long roleID);
}
