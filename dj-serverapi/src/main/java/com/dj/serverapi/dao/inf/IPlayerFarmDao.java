package com.dj.serverapi.dao.inf;

import com.dj.domain.entity.player.PlayerFarm;
import com.dj.servercore.db.inf.dao.IDaoOperation;

public interface IPlayerFarmDao extends IDaoOperation<PlayerFarm> {

	void initNewRoleFarm(long roleID);
}
