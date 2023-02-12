package com.dj.serverapi.redis.model;

import java.util.Map;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.RedisKeys;
import com.dj.domain.data.meetEgg.GuildBattleBuild;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.servercore.redis.base.BaseModel;

/**
 * @author zcq
 * @ClassName: GuildBattleModel
 * @Description: 商会战斗
 * @date 2020年7月30日
 */
public class GuildBattleModel extends BaseModel {

    public GuildBattleModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_GUILD_BATTLE, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
        this.data.initNewSubMap(RedisKeys.KEY_GUILD_BATTLE_BUILD);
        
        Map<Integer, GuildBattleBuild> map = getGuildBattleBuildMap();
        for (int i = 1; i <= 5; i++) {
        	GuildBattleBuild build = new GuildBattleBuild(i, GlobalRoleID.getXiaoXun());
        	map.put(i, build);
		}
    }

    public Map<Integer, GuildBattleBuild> getGuildBattleBuildMap() {
        return this.data.get(RedisKeys.KEY_GUILD_BATTLE_BUILD);
    }

    public GuildBattleBuild getGuildBattleBuild(int buildID) {
        return this.data.getSubMapItem(RedisKeys.KEY_GUILD_BATTLE_BUILD, buildID);
    }

}
