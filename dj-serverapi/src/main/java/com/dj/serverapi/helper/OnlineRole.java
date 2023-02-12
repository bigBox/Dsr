package com.dj.serverapi.helper;

import java.util.Map;

import com.google.common.collect.Maps;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
* @ClassName: OnlineRole  
* @Description: 在线角色
* @author zcq 
* @date 2019年8月5日
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OnlineRole {

	private int gateServerID;
	private String account;
	private String password;
	private String ip;
	
	private long roleID;

	private int todayOnline;
	// 在线满了一分钟
	private int online=0;
	
	/**
	 * 待推送给前端的属性变化
	 */
	private Map<String, Long> attrMap = Maps.newHashMapWithExpectedSize(5);
	
	private int taskPoint = 0;
	
	private volatile int guildTaskID = 0;

	public OnlineRole(int gateServerID, String account, String password, String ip, long roleID, int todayOnline) {
		this.gateServerID = gateServerID;
		this.account = account;
		this.password = password;
		this.ip = ip;
		this.roleID = roleID;
		this.todayOnline = todayOnline;
		this.online = 0;
	}

	public OnlineRole(int gateServerID, long roleID, int todayOnline) {
		this.gateServerID = gateServerID;
		this.roleID = roleID;
		this.todayOnline = todayOnline;
		this.online = 0;
	}
}
