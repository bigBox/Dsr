package com.dj.serverapi.dao.inf;

import com.dj.domain.entity.robot.RobotShowTable;
import com.dj.servercore.db.inf.dao.IDaoOperation;

import java.util.Map;

public interface IRobotShowTableDao extends IDaoOperation<RobotShowTable> {

	Map<Integer, Integer> initNewRoleShowTableItem(long roleID);
}
