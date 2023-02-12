import com.dj.domain.util.ThreadUtil;
import com.dj.domain.util.cache.CacheUtil;
import com.google.common.cache.Cache;

public class TestCache {
	public static void main(String[] args) {
		Cache<Integer, Integer> cache = CacheUtil.createCache(10000, 1);

		for (int i = 0; i < 50; i++) {
			cache.put(i, i);
		}
		System.out.println(cache.size());
		System.out.println("======================");
		ThreadUtil.sleep(2 * 60 * 1000);
		for (int i = 50; i < 100; i++) {
			cache.put(i, i);
		}
		ThreadUtil.sleep(3000);
		cache.cleanUp();
		System.out.println(cache.size());
		for (int i = 0; i < 100; i++) {
			System.out.println(cache.getIfPresent(i));
		}
	}
}
