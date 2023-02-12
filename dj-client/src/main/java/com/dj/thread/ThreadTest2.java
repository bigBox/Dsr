package com.dj.thread;

import java.util.concurrent.FutureTask;

public class ThreadTest2 {
	public static void main(String[] args) throws Exception {
		FutureTask<Entity> futureTask = new FutureTask<Entity>(new MyCallable());
		Thread thread = new Thread(futureTask);
		thread.start();
		if(!futureTask.isDone()) {
			System.out.println("task has not finished!");
		}
		System.out.println("继续");
		System.out.println(futureTask.get().getCount());
		System.out.println("结束");
	}
}
