package com.dj.serverapi.helper;

import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.dj.domain.config.ConfigTasks;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.protobuf.task.ETaskType;
import com.dj.serverapi.ServiceProvider;
import com.dj.domain.util.ThreadUtil;
import com.dj.domain.util.cache.CacheUtil;
import com.google.common.cache.Cache;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: OnlineHelper
 * @Description: 在线助手
 * @date 2019年6月25日
 */
@Slf4j
public class OnlineHelper {

    private static OnlineHelper instance = new OnlineHelper();

    public static OnlineHelper getInstance() {
        return instance;
    }

    /**
     * 在线缓存最大人数
     */
    private final int ONLINE_CACHE_MAX_COUNT = 10000;

    /**
     * 在线缓存时间(单位：分钟)
     */
    private final int ONLINE_CACHE_TIME = 30;

    /**
     * 指定缓存时间内没属性变化 就默认离线状态
     */
    @Getter
    private Cache<Long, OnlineRole> onlineMap = CacheUtil.createCache(ONLINE_CACHE_MAX_COUNT, ONLINE_CACHE_TIME);

    
    protected final ReentrantReadWriteLock guildTaskRWLock = new ReentrantReadWriteLock();
    /**
     * 添加在线
     *
     * @param account
     * @param password
     * @param ip
     * @param roleID
     */
    public void addOnline(int gateServerID, String account, String password, String ip, long roleID, int todayOnline) {
        if (onlineMap.getIfPresent(roleID) != null) {
            return;
        }
        onlineMap.put(roleID, new OnlineRole(gateServerID, account, password, ip, roleID, todayOnline));
        log.info("role {}", roleID);
    }

    /**
     * 删除在线
     *
     * @param roleID
     * @return
     */
    public OnlineRole removeOnline(Long roleID) {
        OnlineRole onlineRole = onlineMap.getIfPresent(roleID);
        if (onlineRole != null) {
            onlineMap.invalidate(roleID);
            log.info("role {}", roleID);
        }
        return onlineRole;
    }

    /**
     * 获取在线角色变化属性
     *
     * @param roleID
     * @return
     */
    public Map<String, Long> getOnlineRoleAttr(long roleID) {
        if (onlineMap.getIfPresent(roleID) == null) {
            PlayerRole role = ServiceProvider.getPlayerService().getPlayer(roleID);
            onlineMap.put(roleID, new OnlineRole(role.getGateServerID(), roleID, role.getTodayOnline()));
        }
        return onlineMap.getIfPresent(roleID).getAttrMap();
    }

    /**
     * 获取在线玩家网关id
     *
     * @param roleID
     * @return
     */
    public int getOnlineGateID(long roleID) {
        if (onlineMap.getIfPresent(roleID) == null) {
            PlayerRole role = ServiceProvider.getPlayerService().getPlayer(roleID);
            onlineMap.put(roleID, new OnlineRole(role.getGateServerID(), roleID, role.getTodayOnline()));
        }
        return onlineMap.getIfPresent(roleID).getGateServerID();
    }
    
    public void checkTaskFinishNtf(long roleID, ConfigTasks config, Runnable run) {
    	if(config.getType() != ETaskType.Guild_VALUE) {
    		run.run();
    		return;
    	}
    	ThreadUtil.sleep(1000);
    	ReentrantReadWriteLock.ReadLock rlock = guildTaskRWLock.readLock();
		try {
			rlock.lock();
			OnlineRole onlineRole = onlineMap.getIfPresent(roleID);
			int guildTaskID = onlineRole.getGuildTaskID();
	        if(guildTaskID != config.getID()) {
	        	onlineRole.setGuildTaskID(config.getID());
	        	run.run();
	        }
		} finally {
			rlock.unlock();
		}
    }
    
    /**
     * 检查是否在线
     *
     * @param roleID
     * @return
     */
    public boolean checkOnline(long roleID) {
        return onlineMap.getIfPresent(roleID) != null;
    }
}
