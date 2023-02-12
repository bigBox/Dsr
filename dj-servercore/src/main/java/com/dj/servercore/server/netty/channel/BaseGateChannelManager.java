package com.dj.servercore.server.netty.channel;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import com.dj.protobuf.ServerType;
import com.dj.servercore.server.base.ServerAttribute;
import com.dj.servercore.server.netty.channel.inf.IChannelUserManager;
import com.dj.domain.util.cache.CacheUtil;
import com.dj.domain.util.inf.IArgumentRunnable;
import com.google.common.cache.Cache;
import com.google.protobuf.MessageLite;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;


/**
 * @author zcq
 * @ClassName: BaseGateChannelManager
 * @Description: 抽象网关通道管理器
 * @date 2019年8月26日
 */
@Slf4j
@SuppressWarnings("deprecation")
public abstract class BaseGateChannelManager implements IChannelUserManager {
    /**
     * Gate Channel最大数量
     */
    private static final int GATE_CHANNEL_MAXIMUMSIZE = 65536;
    /**
     * Gate Channel并发等级
     */
    private static final int GATE_CHANNEL_CONCURRENCYLEVEL = Runtime.getRuntime().availableProcessors();
    /**
     * Gate Channel过期时间-分钟
     */
    private static final int GATE_CHANNEL_EXPIRE = 120;
    /**
     * key-account,value:Channel
     */
    private Cache<String, BaseChannel> accountChannelMap = CacheUtil.createCache(GATE_CHANNEL_MAXIMUMSIZE * 5, GATE_CHANNEL_CONCURRENCYLEVEL, GATE_CHANNEL_EXPIRE);
    /**
     * key-roleID,value:Channel
     */
    protected Cache<Long, BaseChannel> roleChannelMap = CacheUtil.createCache(GATE_CHANNEL_MAXIMUMSIZE * 5, GATE_CHANNEL_CONCURRENCYLEVEL, GATE_CHANNEL_EXPIRE);
    /**
     *	用来来确保对channelMap，playerIds的读写的原子性
     */
    private final ReentrantLock LOCK = new ReentrantLock();

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private int getIndex() {
        int index = atomicInteger.incrementAndGet();
        if (index >= Integer.MAX_VALUE) {
            atomicInteger.set(0);
        }
        return index;
    }

    @Override
    public BaseChannel setPlayerServer(String key, ChannelHandlerContext channel) {
        LOCK.lock();
        try {
        	String keyString = key.toLowerCase();
            channel.attr(ServerAttribute.key).set(keyString);
            BaseChannel clientChannel = accountChannelMap.getIfPresent(keyString);
            if (clientChannel == null) {
                clientChannel = new ClientChannel(keyString, channel);
                // 玩家服: 全局递增id对玩家服求模
                List<Integer> serverList = getServerList(ServerType.PLAYER);
                if(serverList != null && serverList.size() > 0) {
                    int index = getIndex();
                    index = index % serverList.size();
                    int serverPlayerID = serverList.get(index);
                    clientChannel.setServerPlayerID(serverPlayerID);
                }else {
                    clientChannel.setServerPlayerID(0);
                }
            } else {
                clientChannel.setChannel(channel);
            }
            String channelID = channel.channel().id().toString();
            clientChannel.setChannelID(channelID);
            log.info("add key {} channelID {}", keyString, channelID);
            log.info("key {} player {} game {} global {}", keyString, clientChannel.getServerPlayerID(), clientChannel.getServerGameID(), clientChannel.getServerGlobalID());
            accountChannelMap.put(keyString, clientChannel);
            return clientChannel;
        } finally {
            LOCK.unlock();
        }
    }

    /**
     *	绑定角色channel， 回收账号channel
     *
     * @param roleID
     * @param key
     */
    public void bindRoleChannel(long roleID, String key, IArgumentRunnable<BaseChannel> kickOutGame) {
        LOCK.lock();
        try {
        	String keyString = key.toLowerCase();
            BaseChannel clientChannel = accountChannelMap.getIfPresent(keyString);
            if (clientChannel != null) {
                clientChannel.getChannel().attr(ServerAttribute.roleID).set(roleID);
                clientChannel.bind(roleID, keyString);
                BaseChannel roleChannel = getChannel(roleID);
                if (roleChannel != null) {
                	// 被踢出游戏
                    kickOutGame.run(roleChannel);
                	roleChannel.getChannel().close();
                    roleChannelMap.invalidate(roleID);
                }
                // 绑定角色channel
                roleChannelMap.put(roleID, clientChannel);
                // 游戏服: 角色id对游戏服求模
                List<Integer> serverList = getServerList(ServerType.GAME);
                int index = (int) (roleID % serverList.size());
                int serverID = serverList.get(index);
                clientChannel.setServerID(ServerType.GAME, serverID);
                // 全局服: 角色id对全局服求模
                serverList = getServerList(ServerType.GLOBAL);
                index = (int) (roleID % serverList.size());
                serverID = serverList.get(index);
                clientChannel.setServerID(ServerType.GLOBAL, serverID);
                // 回收账号channel
                accountChannelMap.invalidate(keyString);
                log.info("bind roleID {} key {} channelID {}", roleID, keyString, clientChannel.getChannelID());
                log.info("roleID {} player {} game {} global {}", roleID, clientChannel.getServerPlayerID(), clientChannel.getServerGameID(), clientChannel.getServerGlobalID());
            }
        } finally {
            LOCK.unlock();
        }
    }

    public abstract Map<Integer, Channel> getServerChannelMap(ServerType type);

    public abstract List<Integer> getServerList(ServerType type);

    @Override
    public BaseChannel getChannel(long roleID) {
        return roleChannelMap.getIfPresent(roleID);
    }

    public BaseChannel getAccountChannel(String account) {
    	String key = account.toLowerCase();
        return accountChannelMap.getIfPresent(key);
    }

    @Override
    public void closeChannelByRole(long roleID) {
        BaseChannel channel = getChannel(roleID);
        if (channel != null) {
            channel.getChannel().close();
            roleChannelMap.invalidate(roleID);
        }
    }

    /**
     *	指定逻辑服1个id发送消息
     *
     * @param serverType
     * @param serverID
     * @param message
     */
    public void sendToConnectServer(ServerType serverType, int serverID, MessageLite message) {
        Map<Integer, Channel> channelMap = getServerChannelMap(serverType);
        Channel channel = channelMap.get(serverID);
        if (channel != null) {
            channel.writeAndFlush(message);
        } else {
            log.error("serverType {}, serverID {}", serverType, serverID);
        }
    }

    /**
     *	指定逻辑服全部id发送消息
     *
     * @param serverType
     * @param msg
     */
    public void sendToAllConnectServer(ServerType serverType, MessageLite msg) {
        Map<Integer, Channel> channels = getServerChannelMap(serverType);
        if (channels != null) {
            for (Channel channel : channels.values()) {
                channel.writeAndFlush(msg);
            }
        }
    }

    /**
     *	获取连接channel数量
     * @return
     */
    public long getChannelSize(){
        return roleChannelMap.size();
    }
}
