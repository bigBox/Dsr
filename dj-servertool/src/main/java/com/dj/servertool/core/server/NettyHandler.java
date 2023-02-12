package com.dj.servertool.core.server;

import com.dj.protobuf.login.CreateAccountReq;
import com.dj.protobuf.login.UserLoginReq;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.ThreadUtil;

public class NettyHandler {
	private static NettySocket socketClient = null;

	public static void initClient(NettySocket client) {
		socketClient = client;
		if (socketClient != null) {
			try {
				socketClient.connectBlocking();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		String account = "admin";
		String password = "123456";
		String name = "admin";
		// 创建admin
		CreateAccountReq.Builder create = CreateAccountReq.newBuilder();
		create.setAccount(account);
		create.setPassword(password);
		create.setNickname(name);
		NettySocket.sendMsg(create.build());

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					// 登陆admin
					UserLoginReq.Builder login = UserLoginReq.newBuilder();
					login.setAccount(account);
					login.setPassword(password);
					NettySocket.sendMsg(login.build());

					ThreadUtil.sleep(DateUtil.TWOMINUTE_2_MILLI);
				}
			}
		}).start();
	}

}
