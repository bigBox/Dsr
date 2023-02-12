package com.dj.client;

import java.util.List;

import com.dj.protobuf.gm.GmCommandReq;
import com.dj.protobuf.login.CreateAccountReq;
import com.dj.protobuf.login.UserLoginReq;
import com.dj.domain.util.FileUtil;
import com.dj.domain.util.ThreadUtil;
import com.google.common.collect.Lists;

/**
 * 模拟客户端测试
 */
@SuppressWarnings("unused")
public class ClientTest {
	
	private static List<TestRole> testRoles = Lists.newArrayList();
	public static void main(String[] args) {
		try {
			System.setProperty("logFilePath", "/mnt/logs/client/");
			System.setProperty("logLevel", "499");
//			while (true) {
//				ClientHandler.initClient(new ClientSocket("ws://122.152.215.21:8888"), false);
//				ThreadUtil.sleep(60*60*1000);
//			}
			String config = getClientConfig();
			//正常测试
			switch (config) {
			case "test":
				ClientHandler.initClient(new ClientSocket("ws://118.25.3.4:9310"), true);
				break;
			case "version":
				ClientHandler.initClient(new ClientSocket("ws://122.152.215.21:9310"), true);
				break;
			default:
				ClientHandler.initClient(new ClientSocket("ws://127.0.0.1:9310"), true); 
				break;
			}
			//批量处理账号
//			testRoles.add(new TestRole("low1", "123", 1, 21));
//			testRoles.add(new TestRole("low2", "123", 1, 22));
//			testRoles.add(new TestRole("low3", "123", 1, 23));
//			testRoles.add(new TestRole("low4", "123", 1, 24));
//			testRoles.add(new TestRole("low5", "123", 1, 25));
//			testRoles.add(new TestRole("low6", "123", 1, 26));
//			testRoles.add(new TestRole("low7", "123", 1, 27));
//			testRoles.add(new TestRole("low8", "123", 1, 28));
//			testRoles.add(new TestRole("low9", "123", 1, 29));
//			testRoles.add(new TestRole("low10", "123", 1, 30));

			testRoles.add(new TestRole("super1", "123", 60, 31));
			testRoles.add(new TestRole("super2", "123", 60, 32));
			testRoles.add(new TestRole("super3", "123", 60, 33));
			testRoles.add(new TestRole("super4", "123", 60, 34));
			testRoles.add(new TestRole("super5", "123", 60, 35));
			testRoles.add(new TestRole("super6", "123", 60, 36));
			testRoles.add(new TestRole("super7", "123", 60, 37));
			testRoles.add(new TestRole("super8", "123", 60, 38));
			testRoles.add(new TestRole("super9", "123", 60, 39));
			testRoles.add(new TestRole("super10", "123", 60, 40));
//			//防沉迷初级
//			testRoles.add(new TestRole("xb801", "123", 1, 14));
//			testRoles.add(new TestRole("xb8011", "123", 2, 14));
//			testRoles.add(new TestRole("xb80111", "123", 3, 14));
//			//防沉迷中级
//			testRoles.add(new TestRole("xb802", "123", 34, 15));
//			testRoles.add(new TestRole("xb8022", "123", 34, 15));
//			testRoles.add(new TestRole("xb80222", "123", 34, 15));
//			//防沉迷高级
//			testRoles.add(new TestRole("xb803", "123", 60, 16));
//			testRoles.add(new TestRole("xb8033", "123", 60, 16));
//			testRoles.add(new TestRole("xb80333", "123", 60, 16));
//			//成人低级账号
//			testRoles.add(new TestRole("xbb1", "123", 1, 24));
//			testRoles.add(new TestRole("xbb11", "123", 1, 24));
//			testRoles.add(new TestRole("xbb12", "123", 1, 24));
//			//成人中级账号
//			testRoles.add(new TestRole("xbb2", "123", 34, 25));
//			testRoles.add(new TestRole("xbb21", "123", 34, 25));
//			testRoles.add(new TestRole("xbb22", "123", 34, 25));
//			//成人高级账号
//			testRoles.add(new TestRole("xbb3", "123", 60, 26));
//			testRoles.add(new TestRole("xbb31", "123", 60, 26));
//			testRoles.add(new TestRole("xbb32", "123", 60, 26));
			
//			String url = "ws://127.0.0.1:9310";
//			switch (config) {
//			case "test":
//				url = "ws://118.25.3.4:9310";
//				break;
//			case "version":
//				url = "ws://122.152.215.21:9310";
//				break;
//			}
////			createTestRole(url);
//			loginTestRole(url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createTestRole(String url) {
		new Thread(()->{
			for (TestRole testRole : testRoles) {
				try {
					ClientHandler.initClient(new ClientSocket(url), false);
					
					// 创建账号
					CreateAccountReq.Builder createAccountReq = CreateAccountReq.newBuilder();
					createAccountReq.setAccount(testRole.getAccount());
					createAccountReq.setPassword(testRole.getPassword());
					//createAccountReq.setName("张爱国");
					//createAccountReq.setIdCard(testRole.getIdCard());
					ClientHandler.sendMsg(createAccountReq.build());
					ThreadUtil.sleep(1000);
//					// 登录账号
					UserLoginReq.Builder userLoginReq = UserLoginReq.newBuilder();
					userLoginReq.setAccount(testRole.getAccount());
					userLoginReq.setPassword(testRole.getPassword());
					ClientHandler.sendMsg(userLoginReq.build());
					ThreadUtil.sleep(1000);
					// 升级
					GmCommandReq.Builder gm = GmCommandReq.newBuilder();
					gm.setCmd("level "+ testRole.getLevel());
					ClientHandler.sendMsg(gm.build());
					ThreadUtil.sleep(3000);
					System.out.println(testRole.getAccount());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("end");
		}).start();		
	}
	private static void loginTestRole(String url) {
		new Thread(()->{
			for (TestRole testRole : testRoles) {
				try {
					ClientHandler.initClient(new ClientSocket(url), false);
					
					// 登录账号
					UserLoginReq.Builder userLoginReq = UserLoginReq.newBuilder();
					userLoginReq.setAccount(testRole.getAccount());
					userLoginReq.setPassword(testRole.getPassword());
					ClientHandler.sendMsg(userLoginReq.build());
					ThreadUtil.sleep(1000);
					
					GmCommandReq.Builder gm = GmCommandReq.newBuilder();
					gm.setCmd("superman");
					ClientHandler.sendMsg(gm.build());
//					// 申请加入商会
//					GuildApplyReq.Builder guildApplyReq = GuildApplyReq.newBuilder();
//					guildApplyReq.setGuildId(1);
//					guildApplyReq.setTokenID(609990004);
//					guildApplyReq.setTokenCount(1);
//					ClientHandler.sendMsg(guildApplyReq.build());
					ThreadUtil.sleep(3000);
					System.out.println(testRole.getAccount());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("end");
		}).start();		
	}

	public static String getClientConfig() {
		try {
			String content = FileUtil.readFile("D:\\work-xdq\\local\\client.txt");
			System.out.println(content);
			return "test";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
