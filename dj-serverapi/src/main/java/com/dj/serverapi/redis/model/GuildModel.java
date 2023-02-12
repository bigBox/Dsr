package com.dj.serverapi.redis.model;

import com.dj.domain.RedisKeys;
import com.dj.domain.data.GuildApply;
import com.dj.domain.entity.global.GlobalGuild;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.servercore.redis.base.BaseModel;

import java.util.Map;

/**
 * @author zcq
 * @ClassName: GuildModel
 * @Description: 商会
 * @date 2019年8月7日
 */
public class GuildModel extends BaseModel {

    public GuildModel(Long guildID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_GUILD, guildID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
        this.data.initNewSubMap(RedisKeys.KEY_GUILD_APPLY);
    }

    public GlobalGuild getGuild() {
        return this.data.get(RedisKeys.KEY_GUILD_INFO);
    }

    public void setGuild(GlobalGuild guild) {
        this.data.set(RedisKeys.KEY_GUILD_INFO, guild);
    }

    public Map<Long, GuildApply> getApply() {
        return this.data.getSubMap(RedisKeys.KEY_GUILD_APPLY);
    }

    public GuildApply addApply(long roleID) {
        Map<Long, GuildApply> applyMap = getApply();
        GuildApply apply = applyMap.get(roleID);
        if (apply == null) {
            apply = new GuildApply(roleID, System.currentTimeMillis());
        } else {
            apply.setApplyTime(System.currentTimeMillis());
        }
        applyMap.put(roleID, apply);
        return apply;
    }

    public GuildApply getGuildApply(long roleID) {
        Map<Long, GuildApply> applyMap = getApply();
        return applyMap.get(roleID);
    }
}
