package com.dj.serverapi.service.inf;

import java.util.Map;

import com.dj.domain.data.GuildApply;
import com.dj.domain.entity.global.GlobalGuild;
import com.dj.domain.util.inf.IArgumentRunnable;

public interface IGuildService {

	GlobalGuild getGuild(long guildID);

	void setGuild(GlobalGuild guild);

	/**
	 *	商会申请
	 */
	GuildApply guildApply(long roleID, long guildId);

	/**
	 *	获取商会申请个人
	 * 
	 * @param roleID
	 * @param guildId
	 * @return
	 */
	GuildApply getGuildApply(long roleID, long guildId);

	/**
	 *	商会批准
	 * 
	 * @param roleID
	 * @param guildId
	 * @param run
	 */
	void guildApprove(long roleID, long guildId, IArgumentRunnable<GuildApply> run);

	/**
	 *	获取商会申请列表
	 * 
	 * @param guildId
	 * @return
	 */
	Map<Long, GuildApply> getGuildApplyMap(long guildId);
}
