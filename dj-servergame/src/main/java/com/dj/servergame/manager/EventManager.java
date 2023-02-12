package com.dj.servergame.manager;

import com.dj.domain.data.game.MineRole;
import com.dj.domain.data.game.SceneCellUnit;
import com.dj.domain.entity.player.item.IPlayerItem;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.event.*;
import com.dj.domain.topic.SyncItemInteractEvent;
import com.dj.protobuf.common.SceneUpdateType;
import com.dj.protobuf.login.PlayerAttrClientNtf;
import com.dj.protobuf.scene.SceneMovementReq;
import com.dj.protobuf.scene.SceneUseSkillReq;
import com.dj.serverapi.EventProvider;
import com.dj.serverapi.helper.OnlineHelper;
import com.dj.servergame.listener.MultiMineEventListener;
import com.dj.servergame.listener.TopicEventListener;

import java.util.List;
import java.util.Map;

public class EventManager extends EventProvider {
	private static final EventManager INSTANCE = new EventManager();

	public static final EventManager getInstance() {
		return INSTANCE;
	}

	@Override
	protected void registerListener() {
		asyncEventBus.register(new MultiMineEventListener());
		asyncEventBus.register(new TopicEventListener());
	}

	/**
	 *	提交场景地图同步事件
	 * 
	 * @param roleID
	 * @param mapOwner
	 * @param type
	 * @param list
	 */
	public static void postSceneMapNtf(long roleID, String mapOwner, SceneUpdateType type, List<SceneCellUnit> list) {
		SceneMapNtfEvent event = borrowEvent(SceneMapNtfEvent.class);
		event.setRoleID(roleID);
		event.setMapOwner(mapOwner);
		event.setType(type);
		event.setList(list);
		putEventCache(event);
	}

	/**
	 *	提交加入场景同步事件
	 * 
	 * @param roleID
	 * @param mapOwner
	 * @param mineRole
	 */
	public static void postJoinSceneNtf(long roleID, String mapOwner, MineRole mineRole) {
		JoinSceneNtfEvent event = borrowEvent(JoinSceneNtfEvent.class);
		event.setRoleID(roleID);
		event.setMapOwner(mapOwner);
		event.setMineRole(mineRole);
		putEventCache(event);
	}

	/**
	 *	提交在场景移动同步事件
	 * 
	 * @param roleID
	 * @param mapOwner
	 * @param req
	 */
	public static void postSceneMovementNtfEvent(long roleID, String mapOwner, SceneMovementReq req) {
		SceneMovementNtfEvent event = borrowEvent(SceneMovementNtfEvent.class);
		event.setRoleID(roleID);
		event.setMapOwner(mapOwner);
		event.setReq(req);
		putEventCache(event);
	}

	/**
	 *	提交在场景使用技能同步事件
	 * 
	 * @param roleID
	 * @param mapOwner
	 * @param req
	 * @param mineRole
	 */
	public static void postSceneUseSkillNtfEvent(long roleID, String mapOwner, SceneUseSkillReq req, MineRole mineRole) {
		SceneUseSkillNtfEvent event = borrowEvent(SceneUseSkillNtfEvent.class);
		event.setRoleID(roleID);
		event.setMapOwner(mapOwner);
		event.setReq(req);
		event.setMineRole(mineRole);
		putEventCache(event);
	}

	/**
	 * 提交好友互动物品
	 * @param roleID
	 */
	public static void postSyncItemInteractEvent(long roleID) {
		SyncItemInteractEvent event = borrowEvent(SyncItemInteractEvent.class);
		event.setRoleID(roleID);
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
                PlayerAttrClientNtf.Builder playerAttrClientNtf = PlayerAttrClientNtf.newBuilder();
                playerAttrClientNtf.putAllIntDic(attrMap);
                attrMap.clear();
                int gateID = OnlineHelper.getInstance().getOnlineGateID(roleID);
                ChannelManager.getInstance().sendPlayerBasicToGate(gateID, roleID, playerAttrClientNtf.build());
            }
        }
    }

}
