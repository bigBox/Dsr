package com.dj.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo {

	public static void main(String[] args) throws Exception {
		ExecutorService es = Executors.newCachedThreadPool();
		Future<?> future = es.submit(new XwRunnable(), true);
		es.shutdown();
		System.out.println(future.get());
		
		
//		new Thread(new XwRunnable()).start();
	}
}
