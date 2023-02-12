package com.dj.serverapi.dao.inf;

import java.util.Map;

import com.dj.domain.entity.player.PlayerShowTable;
import com.dj.servercore.db.inf.dao.IDaoOperation;

public interface IPlayerShowTableDao extends IDaoOperation<PlayerShowTable> {

	Map<Integer, Integer> initNewRoleShowTableItem(long roleID);
}
