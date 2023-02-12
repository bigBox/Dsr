package com.dj.servercore.server.base;

import com.dj.protobuf.ServerType;
import com.google.protobuf.MessageLite;
import io.netty.util.AttributeKey;

public class ServerAttribute {

	public static final AttributeKey<String> key = AttributeKey.valueOf("key");
	
	public static final AttributeKey<Long> roleID = AttributeKey.valueOf("roleID");
	
	public static final AttributeKey<Long> master = AttributeKey.valueOf("master");

	public static final AttributeKey<Integer> serverID = AttributeKey.valueOf("serverID");
	
	public static final AttributeKey<ServerType> serverType = AttributeKey.valueOf("serverType");
	
	public static final AttributeKey<MessageLite> req = AttributeKey.valueOf("req");
}
