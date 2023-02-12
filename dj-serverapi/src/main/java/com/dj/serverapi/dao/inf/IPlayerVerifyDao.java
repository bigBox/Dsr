package com.dj.serverapi.dao.inf;

import com.dj.domain.entity.player.PlayerVerify;
import com.dj.servercore.db.inf.dao.IDaoOperation;

public interface IPlayerVerifyDao extends IDaoOperation<PlayerVerify> {
	
	void initNewRoleGuideVerify(long roleID);
}
