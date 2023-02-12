package com.dj.thread;

import com.dj.domain.util.ThreadUtil;

public class MyRunnable implements Runnable {

	private Entity entity;
	
	public MyRunnable(Entity value) {
		entity = value;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			entity.setCount(i);
			
			ThreadUtil.sleep(1000);
		}
	}

}
