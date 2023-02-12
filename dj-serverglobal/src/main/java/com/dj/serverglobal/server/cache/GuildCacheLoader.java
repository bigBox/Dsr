package com.dj.serverglobal.server.cache;

import com.dj.domain.entity.global.GlobalGuild;
import com.dj.domain.entity.global.GlobalGuildMember;
import com.dj.domain.entity.player.task.GuildTask;
import com.dj.serverapi.dao.GlobalGuildDao;
import com.dj.serverapi.dao.GlobalGuildMemberDao;
import com.dj.serverapi.dao.task.GuildTaskDao;
import com.dj.servercore.db.cache.IEntityCache;
import com.dj.servercore.db.cache.IEntityCacheLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zcq
 * @ClassName: GuildCacheLoader
 * @Description: 商会缓存加载器， 商会id作为唯一标识
 * @date 2019年6月25日
 */
@Component("guildCacheLoader")
public class GuildCacheLoader implements IEntityCacheLoader {

    @Autowired
    public GlobalGuildDao globalGuildDao;
    @Autowired
    public GlobalGuildMemberDao globalGuildMemberDao;
    @Autowired
    public GuildTaskDao guildTaskDao;

    @Override
    public void loadEntityCache(long identity, IEntityCache entityCache) {
    	// 商会
        GlobalGuild guild = globalGuildDao.cacheQuery(identity, identity);
        if(guild != null) {
            entityCache.addModelData(guild, GlobalGuild.class);
        }
        // 商会成员
        List<GlobalGuildMember> members = globalGuildMemberDao.readDbData(identity);
        if(members != null && members.size() > 0) {
            entityCache.addModelData(members, GlobalGuildMember.class);
        }
        // 商会任务
        List<GuildTask> tasks = guildTaskDao.readDbData(identity);
        if(tasks != null && tasks.size() > 0) {
            entityCache.addModelData(tasks, GuildTask.class);
        }
    }
}
