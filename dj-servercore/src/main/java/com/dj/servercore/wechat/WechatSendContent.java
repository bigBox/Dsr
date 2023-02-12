package com.dj.servercore.wechat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WechatSendContent {
	private String touser;
	private int toparty;
	private String totag;
	private String msgtype;
	private int agentid;
	private Content text;
	private int safe;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class Content {
		private String content;
	}

	public WechatSendContent(String touser, int toparty, String totag, String msgtype, int agentid) {
		super();
		if (!touser.equals("@all")) {
			this.touser = "zcq|" + touser;
		} else {
			this.touser = touser;
		}
		this.toparty = toparty;
		this.totag = totag;
		this.msgtype = msgtype;
		this.agentid = agentid;
		this.text = null;
	}
}
