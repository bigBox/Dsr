package com.dj.stress;

import java.util.Map;
import java.util.concurrent.CountDownLatch;

import com.dj.domain.util.ThreadUtil;
import com.google.common.collect.Maps;

/**
 * 压力测试
 */
public class StressTest {

	public static void main(String[] args) {
		System.setProperty("logFilePath", "/mnt/logs/client/");
		System.setProperty("logLevel", "499");

//		doStress("oppo", 0, 5);
//		doStress("oppo", 5, 10);
//		doStress("huawei", 0, 5);
//		doStress("huawei", 5, 10);
	}
	
	
	public static void doStress(String prefix, int start, int end) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Thread.currentThread().setName(prefix+start);
				ThreadUtil.sleep(3000);
				Map<Integer, StressHandler> handlerMap = Maps.newHashMap();
				try {
					int count = end - start;
					CountDownLatch cdl = new CountDownLatch(count);

					for (int i = start; i < end; i++) {
						StressHandler handler = new StressHandler();
						handler.initClient(new StressSocket("ws://118.25.3.4:9310", cdl), prefix+i);
						handlerMap.put(i, handler);
						ThreadUtil.sleep(300);
					}
					cdl.await();
					System.out.println("登陆完成。。。。。。");
					ThreadUtil.sleep(3000);
					for (StressHandler handler : handlerMap.values()) {
						handler.startMeetEgg();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
