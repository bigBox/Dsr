package com.dj.servercore.server.netty.channel.inf;

import com.dj.servercore.server.netty.channel.BaseChannel;

import io.netty.channel.ChannelHandlerContext;

/**
 * @ClassName: IChannelUserManager
 * @Description: 客户端连接网关通道管理器接口
 * @author zcq
 * @date 2019年8月26日
 */
public interface IChannelUserManager extends IChannelBaseManager {

	BaseChannel setPlayerServer(String key, ChannelHandlerContext channel);

	BaseChannel getChannel(long roleID);

	void closeChannelByRole(long roleID);
}
