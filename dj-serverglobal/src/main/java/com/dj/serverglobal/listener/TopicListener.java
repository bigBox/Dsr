package com.dj.serverglobal.listener;

import com.dj.domain.constant.ConstantTopic;
import com.dj.domain.topic.*;
import com.dj.serverapi.topic.TopicManager;
import com.dj.serverglobal.manager.DataManager;

/**
 * @author zcq
 * @ClassName: TopicListener
 * @Description: 跨进程topic主题监听器，多项目通过redis的topic主题作为中介传输数据
 * @date 2019年6月25日
 */
public class TopicListener {
    private static final TopicListener INSTANCE = new TopicListener();

    public static final TopicListener getInstance() {
        return INSTANCE;
    }

    public void initListener() {
        // 创建商会
        TopicManager.getInstance().listenTopic(ConstantTopic.TOPIC_GUILD_CREATE, msg -> {
            GuildCreateEvent event = (GuildCreateEvent) msg;
            DataManager.INSTANCE.guildCreate(event);
        });
        // 修改商会名称
        TopicManager.getInstance().listenTopic(ConstantTopic.TOPIC_GUILD_CHANGE_NAME, msg -> {
        	GuildChangeNameEvent event = (GuildChangeNameEvent) msg;
        	DataManager.INSTANCE.guildChangeName(event);
        });
        // 商会战斗报名
        TopicManager.getInstance().listenTopic(ConstantTopic.TOPIC_GUILD_BATTLE_SIGN_UP, msg -> {
        	GuildBattleSingUpEvent event = (GuildBattleSingUpEvent) msg;
        	DataManager.INSTANCE.guildBattleSingUp(event);
        });
        // 商会经验
        TopicManager.getInstance().listenTopic(ConstantTopic.TOPIC_GUILD_LEVEL, msg -> {
        	GuildLevelEvent event = (GuildLevelEvent) msg;
        	DataManager.INSTANCE.addGuildExp(event.getRoleID(), event.getGuildID(), event.getGuildScore(), true);
        });
//        // 交易放入队列
//        TopicManager.getInstance().listenTopic(ConstantTopic.TOPIC_TRADE_ENQUEUE, msg -> {
//            TradeEnqueueEvent event = (TradeEnqueueEvent) msg;
//            DataManager.INSTANCE.tradeEnqueue(event);
//        });
//        // 交易买卖
//        TopicManager.getInstance().listenTopic(ConstantTopic.TOPIC_TRADE_USE, msg -> {
//            TradeUseEvent event = (TradeUseEvent) msg;
//            DataManager.INSTANCE.tradeUse(event);
//        });
        // 完成商会任务
        TopicManager.getInstance().listenTopic(ConstantTopic.TOPIC_GUILD_COMPLETE_TASK, msg -> {
            GuildTaskCompleteEvent event = (GuildTaskCompleteEvent) msg;
            DataManager.INSTANCE.guildComplete(event);
        });
    }
}
