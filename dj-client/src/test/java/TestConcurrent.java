import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import com.dj.domain.util.ThreadUtil;

public class TestConcurrent {

	public static ConcurrentHashMap<Integer, AtomicInteger> playerCount = new ConcurrentHashMap<Integer, AtomicInteger>(5);
	public static CountDownLatch latch = new CountDownLatch(3);

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < 10; i++) {
			TestConcurrent.playerCount.put(i, new AtomicInteger(1));
		}

		System.out.println(playerCount.toString());

		new CCThread().start();
		new CCThread().start();
		new CCThread().start();

		latch.await();

		System.out.println(playerCount.toString());
	}
}

class CCThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			TestConcurrent.playerCount.get(i).incrementAndGet();
			ThreadUtil.sleep(500);
		}
		TestConcurrent.latch.countDown();
	}

}