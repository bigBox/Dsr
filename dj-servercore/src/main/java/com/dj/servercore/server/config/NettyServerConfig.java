package com.dj.servercore.server.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>netty服务器配置</p>
 * @author zcq
 * 2019年3月14日
 */
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class NettyServerConfig extends ServerConfig {

	private int port;
}
