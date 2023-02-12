package com.dj.serverapi.dao.inf;

import com.dj.domain.entity.robot.RobotShowTableMoney;
import com.dj.servercore.db.inf.dao.IDaoOperation;

import java.util.Map;

public interface IRobotShowTableMoneyDao extends IDaoOperation<RobotShowTableMoney> {

	RobotShowTableMoney createPlayerShowTableMoney(long roleID, Map<Integer, Integer> moneyMap);
}
