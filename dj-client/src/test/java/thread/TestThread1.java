package thread;

import com.dj.domain.util.ThreadUtil;

public class TestThread1 implements Runnable{

	@Override
	public void run() {
		int i =0;
		while(true) {
			i++;
			ThreadUtil.sleep(1000);
			if(i == 10) {
				synchronized (obj) {
					obj.notify();
				}
			}
			System.out.println(i);
		}
		
	}

	public static Object obj = new Object();
	
	public static void main(String[] args) {
		
		synchronized (obj) {
			new Thread(new TestThread1()).start();
			try {
				obj.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("end...");
	}
	
}
