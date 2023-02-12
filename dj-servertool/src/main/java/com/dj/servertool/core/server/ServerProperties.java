package com.dj.servertool.core.server;

import lombok.Data;

@Data
public class ServerProperties {

	private String gateIP;

	private int gatePort;
	
	private String cdnUrl;
}
