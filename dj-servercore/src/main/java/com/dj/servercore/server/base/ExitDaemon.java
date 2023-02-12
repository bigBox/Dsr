package com.dj.servercore.server.base;

import com.dj.domain.util.ThreadUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 守护线程
 */
@Slf4j
public class ExitDaemon implements Runnable {

	@Override
	public void run() {
		while (true) {
			// 延迟5秒关闭服务器
			if (AbsServer.getStopTime() > 0 && AbsServer.getStopTime() + 5000 <= System.currentTimeMillis()) {
				log.info("Daemon running stopTime={},now={}", AbsServer.getStopTime(), System.currentTimeMillis());
				break;
			}
			ThreadUtil.sleep(5000);
		}
		System.exit(1);
	}
}
