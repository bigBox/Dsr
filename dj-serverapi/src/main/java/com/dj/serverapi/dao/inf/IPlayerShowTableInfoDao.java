package com.dj.serverapi.dao.inf;

import com.dj.domain.entity.player.PlayerShowTableInfo;
import com.dj.servercore.db.inf.dao.IDaoOperation;

import java.util.List;

public interface IPlayerShowTableInfoDao extends IDaoOperation<PlayerShowTableInfo> {

    List<PlayerShowTableInfo> initNewRoleShowTableInfo(long roleID);

}
