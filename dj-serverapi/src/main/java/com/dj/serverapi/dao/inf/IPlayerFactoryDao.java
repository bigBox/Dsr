package com.dj.serverapi.dao.inf;

import com.dj.domain.entity.player.PlayerFactory;
import com.dj.servercore.db.inf.dao.IDaoOperation;

public interface IPlayerFactoryDao extends IDaoOperation<PlayerFactory> {

	void initFactory(long roleID);
}
