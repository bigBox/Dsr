package com.dj.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest3 {
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<Entity> future = executorService.submit(new MyCallable());
		System.out.println(future.get().getCount());
	}
}
