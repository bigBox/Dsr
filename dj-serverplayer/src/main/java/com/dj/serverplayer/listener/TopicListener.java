package com.dj.serverplayer.listener;

import com.dj.domain.constant.ConstantTopic;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.event.TaskActionEvent;
import com.dj.domain.topic.GuildAcceptTaskEvent;
import com.dj.domain.topic.GuildApplyEvent;
import com.dj.domain.topic.GuildApproveEvent;
import com.dj.domain.topic.GuildQuitEvent;
import com.dj.domain.topic.SyncAttrEvent;
import com.dj.domain.topic.SyncCommonEvent;
import com.dj.domain.topic.SyncItemEvent;
import com.dj.domain.topic.SyncItemInteractEvent;
import com.dj.serverapi.helper.OnlineHelper;
import com.dj.serverapi.topic.TopicManager;
import com.dj.servercore.server.SocketServer;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverplayer.handler.InitHandler;
import com.dj.serverplayer.manager.DataManager;
import com.dj.serverplayer.manager.ServiceManager;
import com.dj.domain.util.Utility;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: TopicListener
 * @Description: 跨进程topic主题监听器，多项目通过redis的topic主题作为中介传输数据
 * @date 2019年6月25日
 */
@Slf4j
public class TopicListener {
    private static final TopicListener INSTANCE = new TopicListener();

    public static final TopicListener getInstance() {
        return INSTANCE;
    }

    public void initListener() {
        // 通用变更
        TopicManager.getInstance().listenTopic(ConstantTopic.TOPIC_SYNC_COMMON, msg -> {
            SyncCommonEvent event = (SyncCommonEvent) msg;
            runThisServer(event.getRealRoleID(), () -> {
                DataManager.INSTANCE.syncCommon(event);
            });
        });
        // 道具变更
        TopicManager.getInstance().listenTopic(ConstantTopic.TOPIC_SYNC_ITEM, msg -> {
            SyncItemEvent event = (SyncItemEvent) msg;
            runThisServer(event.getRoleID(), () -> {
                DataManager.INSTANCE.syncItem(event.getRoleID());
            });
        });
        // 属性变更
        TopicManager.getInstance().listenTopic(ConstantTopic.TOPIC_SYNC_ATTR, msg -> {
            SyncAttrEvent event = (SyncAttrEvent) msg;
            runThisServer(event.getRoleID(), () -> {
                DataManager.INSTANCE.syncAttr(event.getRoleID());
            });
        });
        // 申请商会
        TopicManager.getInstance().listenTopic(ConstantTopic.TOPIC_GUILD_APPLY, msg -> {
            GuildApplyEvent event = (GuildApplyEvent) msg;
//            runThisServer(event.getChairman(), () -> {
//                DataManager.INSTANCE.guildApply(event);
//            });
            runThisServer(event.getRoleID(), () -> {
              DataManager.INSTANCE.guildApply(event);
            });
        });
        // 商会批准
        TopicManager.getInstance().listenTopic(ConstantTopic.TOPIC_GUILD_APPROVE, msg -> {
            GuildApproveEvent event = (GuildApproveEvent) msg;
            runThisServer(event.getRoleID(), () -> {
                DataManager.INSTANCE.guildApprove(event);
            });
        });
        // 商会退出
        TopicManager.getInstance().listenTopic(ConstantTopic.TOPIC_GUILD_QUIT, msg -> {
            GuildQuitEvent event = (GuildQuitEvent) msg;
            runThisServer(event.getRoleID(), () -> {
                DataManager.INSTANCE.guildQuit(event);
            });
        });
        // 商会接受任务
        TopicManager.getInstance().listenTopic(ConstantTopic.TOPIC_GUILD_ACCEPT_TASK, msg -> {
        	GuildAcceptTaskEvent event = (GuildAcceptTaskEvent) msg;
        	runThisServer(event.getRoleID(), () -> {
        		DataManager.INSTANCE.guildAcceptTask(event);
        	});
        });
        // 任务行为
        TopicManager.getInstance().listenTopic(ConstantTopic.TOPIC_TASK_ACTION, msg -> {
            TaskActionEvent event = (TaskActionEvent) msg;
            runThisServer(event.getRoleID(), () -> {
                DataManager.INSTANCE.taskAction(event);
            });
        });
        // 好友互动物品
        TopicManager.getInstance().listenTopic(ConstantTopic.TOPIC_ITEM_INTERACT, msg -> {
        	SyncItemInteractEvent event = (SyncItemInteractEvent) msg;
        	runThisServer(event.getRoleID(), () -> {
        		DataManager.INSTANCE.syncItemInteract(event.getRoleID());
        	});
        });
    }

    private void runThisServer(long roleID, Runnable runnable) {
        // 在线玩家
        if (OnlineHelper.getInstance().checkOnline(roleID)) {
            PlayerRole playerRole = ServiceManager.getPlayerService().getPlayer(roleID);
            // 本服玩家
            if (playerRole.getPlayerServerID() == SocketServer.getServerConfig().getId()) {
                try {
                    log.info("roleID {}, playerServerID {}", roleID, playerRole.getPlayerServerID());
                    SpringContext.getBean(InitHandler.class).playerCacheManager.checkActivateCache(roleID);
                    runnable.run();
                } catch (Exception e) {
                    String error = Utility.getTraceString(e);
                    log.error("roleID {}, error {}", roleID, error);
                    //WechatUtil.writeActionException(AbsServer.getServerConfig().getTag(), AbsServer.getServerConfig().getName(), AbsServer.getServerConfig().getId(), roleID + "", error);
                }
            }
        }
    }
}