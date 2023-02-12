package com.dj.servercore.server.config;

import java.util.List;

import com.dj.servercore.server.base.ServerInfo;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ConnectServerConfig extends ServerConfig {

	private List<ServerInfo> playerServers = Lists.newArrayListWithExpectedSize(3);
	
	private List<ServerInfo> gameServers = Lists.newArrayListWithExpectedSize(3);

	private List<ServerInfo> globalServers = Lists.newArrayListWithExpectedSize(3);
}
