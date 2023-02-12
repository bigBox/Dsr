package com.dj.servercore.server.netty.channel.inf;

import io.netty.channel.ChannelHandlerContext;

/**
 * @ClassName: IChannelServerManager
 * @Description: 网关连接逻辑服通道管理器接口
 * @author zcq
 * @date 2019年8月26日
 */
public interface IChannelServerManager extends IChannelBaseManager {

	/**
	 * 添加通道
	 * 
	 * @param serverID
	 * @param channel
	 */
	void addChannel(int serverID, ChannelHandlerContext channel);

	/**
	 * 删除通道
	 * 
	 * @param serverID
	 * @return
	 */
	boolean delChannel(int serverID);

	/**
	 * 检查是否可以关闭本逻辑服
	 * 
	 * @return
	 */
	boolean checkCanStop();

	/**
	 * 根据服务器id获取通道
	 * @param serverID
	 * @return
	 */
    ChannelHandlerContext getChannel(Integer serverID);
}
