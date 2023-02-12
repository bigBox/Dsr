package com.dj.serverglobal.listener;

import java.util.List;

import com.dj.domain.type.AccessType;
import com.dj.domain.entity.global.GlobalGuildMember;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.topic.GuildTaskUpdateEvent;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.guildTask.GuildTaskUpdateNtf;
import com.dj.serverapi.dao.GlobalGuildMemberDao;
import com.dj.servercore.event.AbsEventListener;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverglobal.manager.ChannelManager;
import com.dj.serverglobal.manager.ServiceManager;
import com.dj.domain.util.ThreadUtil;
import com.dj.domain.util.Utility;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: GuildTaskEventListener
 * @Description: 商会任务事件监听
 * @date 2020年8月13日
 */
@Slf4j
public class GuildTaskEventListener extends AbsEventListener {
	@Subscribe
    @AllowConcurrentEvents
    public void listenGuildUpdateTaskEvent(GuildTaskUpdateEvent event) {
        try {
        	//推送给商会在线成员
            ThreadUtil.sleep(1000);
            GuildTaskUpdateNtf.Builder guildTaskUpdateNtfBuilder = GuildTaskUpdateNtf.newBuilder();
            guildTaskUpdateNtfBuilder.setTask(event.getTaskInfo());
            GuildTaskUpdateNtf    guildTaskUpdateNtf = guildTaskUpdateNtfBuilder.build();
            QueryParamMap queryParams = new QueryParamMap();
            queryParams.put("guildID", event.getGuildID());
            List<GlobalGuildMember> lists = SpringContext.getBean(GlobalGuildMemberDao.class).selectList(queryParams, event.getRoleID(), AccessType.DIRECT_DB);
            if((lists != null)&&(lists.size() > 0)) {
                lists.forEach(value -> {
                    PlayerRole memberRole = ServiceManager.getPlayerService().getPlayer(value.getRoleID());
                    if (memberRole.isOnline()) {
                        ChannelManager.getInstance().sendGlobalGuildToGate(memberRole.getGateServerID(), value.getRoleID(), guildTaskUpdateNtf);
                    }
                });
            }
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            returnEvent(event);
        }
    }
}
