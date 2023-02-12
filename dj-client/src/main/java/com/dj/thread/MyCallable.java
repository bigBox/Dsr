package com.dj.thread;

import java.util.concurrent.Callable;

import com.dj.domain.util.ThreadUtil;

public class MyCallable implements Callable<Entity> {

	@Override
	public Entity call() throws Exception {
		Entity entity = new Entity();
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			entity.setCount(i);
			
			ThreadUtil.sleep(1000);
		}
		return entity;
	}

}
