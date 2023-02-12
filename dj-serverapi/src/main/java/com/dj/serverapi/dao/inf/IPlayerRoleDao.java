package com.dj.serverapi.dao.inf;

import com.dj.domain.entity.player.PlayerRole;
import com.dj.servercore.db.inf.dao.IDaoOperation;

public interface IPlayerRoleDao extends IDaoOperation<PlayerRole> {

	PlayerRole createRole(long roleID, int level, String reqAccount, String channel, int gateServerID, int fiveEle);

	int cacheUpdate(PlayerRole pojo);

	//PlayerRole cacheSelect(long roleID);
}
