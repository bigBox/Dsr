package com.dj.demo.queue;

import java.util.concurrent.LinkedBlockingQueue;

import com.dj.domain.util.ThreadUtil;

public class QueueDemo {

	static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();

	public static void main(String[] args) {
		new Thread(() -> {
			int index = 0;
			while (true) {
				queue.add(index++);
				ThreadUtil.sleep(2000);
			}
		}).start();

		new Thread(() -> {
			while (true) {
				System.out.println(queue.peek());
				ThreadUtil.sleep(1000);
			}
		}).start();
	}
}
