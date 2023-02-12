package thread;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock implements Runnable{

	public static ReentrantLock lock = new ReentrantLock();
	public static int i = 0;
	
	@Override
	public void run() {
		for (int j = 0; j < 1000; j++) {
			lock.lock();
			try {
				i++;
			} finally {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestLock test = new TestLock();
		
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.start();
		t2.start();
//		t1.join();
//		t2.join();
		
		Thread tt = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					
				}
			}
		});
		tt.start();
		
		System.out.println(i);
	}
	
	
}
