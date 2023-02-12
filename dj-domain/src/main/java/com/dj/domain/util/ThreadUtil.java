package com.dj.domain.util;

/**
 * 线程工具
 */
public class ThreadUtil {

	/**
	 * 睡眠
	 * @param ms
	 */
	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 */
	public static void join() {
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
