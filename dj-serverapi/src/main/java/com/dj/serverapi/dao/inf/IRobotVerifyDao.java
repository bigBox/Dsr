package com.dj.serverapi.dao.inf;

import com.dj.domain.entity.robot.RobotVerify;
import com.dj.servercore.db.inf.dao.IDaoOperation;

public interface IRobotVerifyDao extends IDaoOperation<RobotVerify> {
	
	void initNewRoleGuideVerify(long roleID);
}
