package com.dj.servertool.core.server;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfig {

	@Bean
	@ConfigurationProperties(prefix = "server.config")
	public ServerProperties serverProperties() {
		return new ServerProperties();
	}
}
