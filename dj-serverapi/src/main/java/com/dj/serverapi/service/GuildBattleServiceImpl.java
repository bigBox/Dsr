package com.dj.serverapi.service;

import java.util.Map;

import com.dj.domain.data.meetEgg.GuildBattleBuild;
import com.dj.serverapi.redis.model.GuildBattleModel;
import com.dj.serverapi.service.inf.IGuildBattleService;
import com.dj.servercore.redis.base.BaseService;

public class GuildBattleServiceImpl extends BaseService implements IGuildBattleService {

	@Override
	public Map<Integer, GuildBattleBuild> getGuildBattleBuildMap() {
		GuildBattleModel model = getGlobalModel(GuildBattleModel.class, false);
		return model.getGuildBattleBuildMap();
	}

	@Override
	public GuildBattleBuild getGuildBattleBuild(int buildID) {
		GuildBattleModel model = getGlobalModel(GuildBattleModel.class, false);
		return model.getGuildBattleBuild(buildID);
	}

	@Override
	public GuildBattleBuild holdGuildBattleBuild(long roleID, int buildID) {
		GuildBattleModel model = getGlobalModel(GuildBattleModel.class, true);
		GuildBattleBuild build = model.getGuildBattleBuild(buildID);
		build.setHoldRoleID(roleID);
		return build;
	}

}
