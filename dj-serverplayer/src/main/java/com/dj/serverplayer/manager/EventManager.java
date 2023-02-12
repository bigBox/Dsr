package com.dj.serverplayer.manager;

import com.dj.domain.config.ConfigRobCfg;
import com.dj.domain.data.RobMap;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.entity.player.item.IPlayerItem;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.event.*;
import com.dj.protobuf.common.SceneUpdateType;
import com.dj.protobuf.login.PlayerAttrClientNtf;
import com.dj.serverapi.EventProvider;
import com.dj.serverapi.helper.OnlineHelper;
import com.dj.serverplayer.listener.PlayerEventListener;
import com.dj.serverplayer.listener.SingleEventListener;
import com.dj.serverplayer.listener.TopicEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@Slf4j
public class EventManager extends EventProvider {
    private static final EventManager INSTANCE = new EventManager();

    public static final EventManager getInstance() {
        return INSTANCE;
    }

    @Override
    protected void registerListener() {
        asyncEventBus.register(new PlayerEventListener());
        asyncEventBus.register(new SingleEventListener());
        asyncEventBus.register(new TopicEventListener());
    }
    
    /**
     *  提交注册事件
     * @param account
     * @param password
     */
    public static void postRegisterEvent(String account, String password, long roleID) {
    	RegisterEvent event = borrowEvent(RegisterEvent.class);
        event.setAccount(account);
        event.setPassword(password);
        event.setRoleID(roleID);
        putEventCache(event);
    }

    /**
     *	提交登录事件
     *
     * @param account
     * @param password
     * @param ip
     * @param roleID
     * @param playerRole
     */
    public static void postLoginEvent(String account, String password, String ip, long roleID, PlayerRole playerRole, boolean login, String channelID) {
        LoginEvent event = borrowEvent(LoginEvent.class);
        event.setAccount(account);
        event.setPassword(password);
        event.setIp(ip);
        event.setRoleID(roleID);
        event.setPlayerRole(playerRole);
        event.setLogin(login);
        event.setChannelID(channelID);
        putEventCache(event);
    }

    /**
     * 提交玩家道具事件
     * @param roleID
     * @param col
     * @param color
     * @param item
     * @param visible
     * @param post2Client
     * @param itemAdd
     */
    public static void postPlayerItemEvent(long roleID, int col, int color, IPlayerItem item, boolean visible, boolean post2Client, boolean itemAdd) {
        PlayerItemEvent event = borrowEvent(PlayerItemEvent.class);
        event.setRoleID(roleID);
        event.setCol(col);
        event.setColor(color);
        event.setItem(item);
        event.setVisible(visible);
        event.setPost2Client(post2Client);
        event.setItemAdd(itemAdd);
        putEventCache(event);
    }

    /**
     *	提交古迹地图事件
     *
     * @param robMap
     */
    public static void postRobMapEvent(RobMap robMap, ConfigRobCfg cfg , long time) {
        Timer timer = new Timer();// 实例化Timer类
        timer.schedule(new TimerTask() {
            public void run() {
                EventManager.postRobMapEvent(robMap, cfg);
                this.cancel();
            }

        }, time);// 这里百毫秒
    }

    public static void postRobMapEvent(RobMap robMap, ConfigRobCfg cfg) {
        RobMapEvent event = borrowEvent(RobMapEvent.class);
        event.setCfg(cfg);
        event.setRoleID(robMap.getRoleID());
        event.setType(robMap.getType());
        if (robMap.getType() == SceneUpdateType.Total_VALUE) {
            event.setCellMap(robMap.getCellMap());
            // 新手引导
            if(robMap.getEnterCondition() == 2) {
            	event.setTreasureCell(robMap.getTreasureCell());
            }
        } else {
            event.setUpdateCell(robMap.getUpdateCell());
        }
        putEventCache(event);
    }

    /**
     *	提交并推送玩家属性事件
     *
     * @param roleID
     * @param attr
     * @param value
     */
    public static void postCommitPlayerAttrEvent(long roleID, PlayerAttrEnum attr, long value) {
        Map<String, Long> attrMap = OnlineHelper.getInstance().getOnlineRoleAttr(roleID);
        attrMap.put(attr.getKey(), value);
        postPlayerAttr(roleID);
    }

    /**
     *	推送玩家属性
     *
     * @param roleID
     */
    public static void postPlayerAttr(long roleID) {
        Map<String, Long> attrMap = OnlineHelper.getInstance().getOnlineRoleAttr(roleID);
        if (attrMap != null && attrMap.size() > 0) {
            synchronized (attrMap) {
                if (attrMap.size() == 0) {
                    return;
                }
                log.info("roleID {}, attr {}", roleID, attrMap.toString());
                PlayerAttrClientNtf.Builder playerAttrClientNtf = PlayerAttrClientNtf.newBuilder();
                playerAttrClientNtf.putAllIntDic(attrMap);
                attrMap.clear();
                int gateID = OnlineHelper.getInstance().getOnlineGateID(roleID);
                ChannelManager.getInstance().sendPlayerBasicToGate(gateID, roleID, playerAttrClientNtf.build());
            }
        }
    }
    
    /**
     *  出发npc技能
     */
    public static void postNpcSkillEvent(long roleID, int npcID, int skillID) {
    	NpcSkillEvent event = borrowEvent(NpcSkillEvent.class);
        event.setRoleID(roleID);
        event.setNpcID(npcID);
        event.setSkillID(skillID);
        putEventCache(event);
    }
}
