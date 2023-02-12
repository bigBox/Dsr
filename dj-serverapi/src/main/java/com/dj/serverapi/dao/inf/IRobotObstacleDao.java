package com.dj.serverapi.dao.inf;

import com.dj.domain.entity.robot.RobotObstacle;
import com.dj.servercore.db.inf.dao.IDaoOperation;

public interface IRobotObstacleDao extends IDaoOperation<RobotObstacle> {
    void initObstacle(long roleID);
}
