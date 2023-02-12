package com.dj.serverapi.dao.inf;

import java.util.Map;

import com.dj.domain.entity.player.PlayerShowTableMoney;
import com.dj.servercore.db.inf.dao.IDaoOperation;

public interface IPlayerShowTableMoneyDao extends IDaoOperation<PlayerShowTableMoney> {

	PlayerShowTableMoney createPlayerShowTableMoney(long roleID, Map<Integer, Integer> moneyMap);
}
