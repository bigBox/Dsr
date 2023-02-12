package com.dj.serverapi.dao;

import com.dj.domain.entity.robot.RobotShowTableMoney;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IRobotShowTableMoneyDao;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RobotShowTableMoneyDao extends BaseCacheDao<RobotShowTableMoney> implements IRobotShowTableMoneyDao {

	@Override
	public RobotShowTableMoney createPlayerShowTableMoney(long roleID, Map<Integer, Integer> moneyMap) {
		RobotShowTableMoney showTableMoneyRobot = cacheLoad("roleID", roleID, roleID);
		if (showTableMoneyRobot == null) {
			showTableMoneyRobot = new RobotShowTableMoney(roleID);
			cacheInsert(showTableMoneyRobot, roleID);
		}
		showTableMoneyRobot.setTitle(1);
		if (moneyMap != null) {
			showTableMoneyRobot.setCol0Money(MapUtils.getIntValue(moneyMap, 0));
			showTableMoneyRobot.setCol1Money(MapUtils.getIntValue(moneyMap, 1));
			showTableMoneyRobot.setCol2Money(MapUtils.getIntValue(moneyMap, 2));
			showTableMoneyRobot.setCol3Money(MapUtils.getIntValue(moneyMap, 3));
		}
		this.cacheUpdate(showTableMoneyRobot, roleID);
		ServiceProvider.getShowTableService().setRobotShowTableMoney(roleID, showTableMoneyRobot);
		return showTableMoneyRobot;
	}
}
