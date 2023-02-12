package com.dj.servercore.server.netty.channel;

import java.util.concurrent.locks.ReentrantLock;

import com.dj.protobuf.forward.ForwardChatSendNtf;
import com.dj.protobuf.forward.ForwardPlayerBasicRsp;
import com.dj.protobuf.forward.ForwardPlayerFriendRsp;
import com.dj.protobuf.forward.ForwardPlayerInitRsp;
import com.dj.protobuf.forward.ForwardPlayerSingleRsp;
import com.dj.servercore.server.base.ServerAttribute;
import com.dj.servercore.server.netty.channel.inf.IChannelServerManager;
import com.dj.domain.util.cache.CacheUtil;
import com.google.common.cache.Cache;
import com.google.protobuf.GeneratedMessageV3;

import io.netty.channel.ChannelHandlerContext;

/**
 * @author zcq
 * @ClassName: BaseLogicChannelManager
 * @Description: 抽象逻辑服通道管理器
 * @date 2019年8月26日
 */
@SuppressWarnings("deprecation")
public abstract class BaseLogicChannelManager implements IChannelServerManager {
    /**
     * gateServerId,Channel
     */
    protected Cache<Integer, ChannelHandlerContext> gateChannelMap = CacheUtil.createCache();

    /**
     *	用来来确保对ChannelMap的读写的原子性
     */
    private final ReentrantLock LOCK = new ReentrantLock();

    private static BaseLogicChannelManager instance;

    protected static void setInstance(BaseLogicChannelManager instance) {
        BaseLogicChannelManager.instance = instance;
    }

    public static BaseLogicChannelManager getInstance() {
        return instance;
    }

    @Override
    public void addChannel(int serverID, ChannelHandlerContext channel) {
        LOCK.lock();
        try {
            channel.attr(ServerAttribute.serverID).set(serverID);
            gateChannelMap.put(serverID, channel);
        } finally {
            LOCK.unlock();
        }
    }

    @Override
    public boolean delChannel(int serverID) {
        gateChannelMap.invalidate(serverID);
        return checkCanStop();
    }

    public boolean checkCanStop() {
        return gateChannelMap.size() == 0;
    }

    @Override
    public ChannelHandlerContext getChannel(Integer serverID) {
        return gateChannelMap.getIfPresent(serverID);
    }

    /**
     *	玩家初始化推送
     *
     * @param gateID
     * @param roleID
     * @param message
     * @return
     */
    public boolean sendPlayerInitToGate(int gateID, long roleID, GeneratedMessageV3 message) {
        ChannelHandlerContext channel = gateChannelMap.getIfPresent(gateID);
        if (gateID > 0 && channel != null) {
            ForwardPlayerInitRsp.Builder builder = ForwardPlayerInitRsp.newBuilder();
            builder.setRoleID(roleID);
            builder.setRspClz(message.getClass().getName());
            builder.setRsp(message.toByteString());
            channel.writeAndFlush(builder.build());
            return true;
        }
        return false;
    }
    
    /**
     *	玩家初始化推送
     *
     * @param gateID
     * @param roleID
     * @param message
     * @return
     */
    public boolean sendPlayerInitToGate(int gateID, long roleID, GeneratedMessageV3 message, String channelID) {
    	ChannelHandlerContext channel = gateChannelMap.getIfPresent(gateID);
    	if (gateID > 0 && channel != null) {
    		ForwardPlayerInitRsp.Builder builder = ForwardPlayerInitRsp.newBuilder();
    		builder.setRoleID(roleID);
    		builder.setRspClz(message.getClass().getName());
    		builder.setRsp(message.toByteString());
    		builder.setChannelID(channelID);
    		channel.writeAndFlush(builder.build());
    		return true;
    	}
    	return false;
    }

    /**
     *	玩家基础推送
     *
     * @param gateID
     * @param roleID
     * @param message
     * @return
     */
    public boolean sendPlayerBasicToGate(int gateID, long roleID, GeneratedMessageV3 message) {
        ChannelHandlerContext channel = gateChannelMap.getIfPresent(gateID);
        if (gateID > 0 && channel != null) {
            ForwardPlayerBasicRsp.Builder builder = ForwardPlayerBasicRsp.newBuilder();
            builder.setRoleID(roleID);
            builder.setRspClz(message.getClass().getName());
            builder.setRsp(message.toByteString());
            channel.writeAndFlush(builder.build());
            return true;
        }
        return false;
    }

    /**
     *	玩家好友推送
     *
     * @param gateID
     * @param roleID
     * @param message
     * @return
     */
    public boolean sendPlayerFriendToGate(int gateID, long roleID, GeneratedMessageV3 message) {
        ChannelHandlerContext channel = gateChannelMap.getIfPresent(gateID);
        if (gateID > 0 && channel != null) {
            ForwardPlayerFriendRsp.Builder builder = ForwardPlayerFriendRsp.newBuilder();
            builder.setRoleID(roleID);
            builder.setRspClz(message.getClass().getName());
            builder.setRsp(message.toByteString());
            channel.writeAndFlush(builder.build());
            return true;
        }
        return false;
    }

    /**
     *	单机玩法推送
     *
     * @param gateID
     * @param roleID
     * @param message
     * @return
     */
    public boolean sendPlayerSingleToGate(int gateID, long roleID, GeneratedMessageV3 message) {
        ChannelHandlerContext channel = gateChannelMap.getIfPresent(gateID);
        if (gateID > 0 && channel != null) {
            ForwardPlayerSingleRsp.Builder builder = ForwardPlayerSingleRsp.newBuilder();
            builder.setRoleID(roleID);
            builder.setRspClz(message.getClass().getName());
            builder.setRsp(message.toByteString());
            channel.writeAndFlush(builder.build());
            return true;
        }
        return false;
    }

    /**
     *	聊天推送
     *
     * @param gateID
     * @param roleID
     * @param message
     * @return
     */
    public boolean sendChatSendNtfToGate(int gateID, long roleID, GeneratedMessageV3 message) {
        ChannelHandlerContext channel = gateChannelMap.getIfPresent(gateID);
        if (gateID > 0 && channel != null) {
            ForwardChatSendNtf.Builder builder = ForwardChatSendNtf.newBuilder();
            builder.setRoleID(roleID);
            builder.setRspClz(message.getClass().getName());
            builder.setRsp(message.toByteString());
            channel.writeAndFlush(builder.build());
            return true;
        }
        return false;
    }
}
