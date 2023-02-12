package com.dj.serverapi.dao;

import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Component;

import com.dj.domain.entity.player.PlayerShowTableMoney;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IPlayerShowTableMoneyDao;

@Component
public class PlayerShowTableMoneyDao extends BaseCacheDao<PlayerShowTableMoney> implements IPlayerShowTableMoneyDao {

	@Override
	public PlayerShowTableMoney createPlayerShowTableMoney(long roleID, Map<Integer, Integer> moneyMap) {
		PlayerShowTableMoney showTableMoney = cacheLoad("roleID", roleID, roleID);
		if (showTableMoney == null) {
			showTableMoney = new PlayerShowTableMoney(roleID);
			cacheInsert(showTableMoney, roleID);
		}
		showTableMoney.setTitle(1);
		if (moneyMap != null) {
			showTableMoney.setCol0Money(MapUtils.getIntValue(moneyMap, 0));
			showTableMoney.setCol1Money(MapUtils.getIntValue(moneyMap, 1));
			showTableMoney.setCol2Money(MapUtils.getIntValue(moneyMap, 2));
			showTableMoney.setCol3Money(MapUtils.getIntValue(moneyMap, 3));
		}
		this.cacheUpdate(showTableMoney, roleID);
		ServiceProvider.getShowTableService().setShowTableMoney(roleID, showTableMoney);
		return showTableMoney;
	}
}
