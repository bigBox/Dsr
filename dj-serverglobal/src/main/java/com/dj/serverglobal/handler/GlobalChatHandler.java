package com.dj.serverglobal.handler;

import com.dj.domain.entity.global.GlobalGuildMember;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.chat.ChatSendNtf;
import com.dj.protobuf.chat.ChatSendReq;
import com.dj.protobuf.chat.ChatSendRsp;
import com.dj.protobuf.chat.EChatChannel;
import com.dj.protobuf.datetime.DateTime;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.dao.GlobalGuildMemberDao;
import com.dj.serverapi.sensitiveword.SensitivewordFilter;
import com.dj.serverglobal.manager.ChannelManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GlobalChatHandler extends ServiceProvider {

    @Autowired
    public GlobalGuildMemberDao globalGuildMemberDao;

    public void chatSendNtf(ChatSendReq req) {
        // 消息发送者
        PlayerRole roleInfo = ServiceProvider.getPlayerService().getPlayer(req.getRoleID());
        if (roleInfo.getGuildId() == 0) {
            // 商会不存在
            ChatSendRsp.Builder rsp = ChatSendRsp.newBuilder();
            rsp.setErrorID(ErrorID.GUILD_NO_JOIN);
            rsp.setReq(req);
            ChannelManager.getInstance().sendChatSendNtfToGate(roleInfo.getGateServerID(), roleInfo.getRoleID(), rsp.build());
            return;
        }
        // 消息推送
        ChatSendNtf.Builder builder = ChatSendNtf.newBuilder();
        builder.setRoleInfo(roleInfo.toBaseRoleInfo());
        builder.setSendTime(DateTime.newBuilder().setValue(System.currentTimeMillis()));
        builder.setChannel(EChatChannel.Guild);
        builder.setContent(SensitivewordFilter.replaceSensitiveWord(req.getContent()));
        ChatSendNtf ntf = builder.build();
        // 遍历商会成员
        QueryParamMap queryParams = new QueryParamMap();
        queryParams.put("guildID", roleInfo.getGuildId());
        List<GlobalGuildMember> lists = globalGuildMemberDao.selectList(queryParams,roleInfo.getRoleID(), AccessType.DIRECT_DB);
        if((lists != null)&&(lists.size() > 0)) {
            lists.forEach(value -> {
                PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(value.getRoleID());
                if (playerRole.isOnline()) {
                    ChannelManager.getInstance().sendChatSendNtfToGate(playerRole.getGateServerID(), playerRole.getRoleID(), ntf);
                }
            });
        }
    }
}
