package com.dj.serverapi.service.inf;

import java.util.Map;

import com.dj.domain.data.meetEgg.GuildBattleBuild;

public interface IGuildBattleService {
	
	/**
	 * 获取商会战斗列表
	 * @return
	 */
	Map<Integer, GuildBattleBuild> getGuildBattleBuildMap();
	
	/**
	 * 获取指定商会战斗建筑
	 * @param buildID
	 * @return
	 */
	GuildBattleBuild getGuildBattleBuild(int buildID);
	
	
	/**
	 * 占领建筑
	 * @param roleID
	 * @param buildID
	 * @return
	 */
	GuildBattleBuild holdGuildBattleBuild(long roleID, int buildID);
}
