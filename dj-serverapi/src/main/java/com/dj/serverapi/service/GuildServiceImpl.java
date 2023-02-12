package com.dj.serverapi.service;

import com.dj.domain.data.GuildApply;
import com.dj.domain.entity.global.GlobalGuild;
import com.dj.serverapi.redis.model.GuildModel;
import com.dj.serverapi.service.inf.IGuildService;
import com.dj.servercore.redis.base.BaseService;
import com.dj.domain.util.inf.IArgumentRunnable;

import java.util.Map;

public class GuildServiceImpl extends BaseService implements IGuildService {

    @Override
    public GlobalGuild getGuild(long guildID) {
        return getReadModel(guildID, GuildModel.class).getGuild();
    }

    @Override
    public void setGuild(GlobalGuild guild) {
        getWriteModel(guild.getId(), GuildModel.class).setGuild(guild);
    }

    @Override
    public GuildApply guildApply(long roleID, long guildId) {
        GuildModel model = getWriteModel(guildId, GuildModel.class);
        return model.addApply(roleID);
    }

    @Override
    public GuildApply getGuildApply(long roleID, long guildId) {
        GuildModel model = getReadModel(guildId, GuildModel.class);
        return model.getGuildApply(roleID);
    }

    @Override
    public void guildApprove(long roleID, long guildId, IArgumentRunnable<GuildApply> run) {
        GuildModel model = getWriteModel(guildId, GuildModel.class);
        Map<Long, GuildApply> applyMap = model.getApply();
        GuildApply apply = applyMap.get(roleID);
        applyMap.remove(roleID);
        run.run(apply);
    }

    @Override
    public Map<Long, GuildApply> getGuildApplyMap(long guildId) {
        return getReadModel(guildId, GuildModel.class).getApply();
    }
}
