package com.dj.thread;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		Entity entity = new Entity();
		Thread thread = new Thread(new MyRunnable(entity));
		thread.start();
		System.out.println("join");
		thread.join();
		
		System.out.println("继续");
		System.out.println(entity.getCount());
	}
}
