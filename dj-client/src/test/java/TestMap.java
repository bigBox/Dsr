import java.util.Iterator;
import java.util.Map;

import com.google.common.collect.Maps;

public class TestMap {
	public static void main(String[] args) {
		Map<Integer, Integer> map = Maps.newHashMap();
		for (int i = 0; i < 10; i++) {
			map.put(i, i);
		}
		Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<Integer, Integer> entry = entries.next();
			if (entry.getKey() % 2 == 0) {
				entries.remove();
			}
			System.out.println(entry.getKey());
		}
		map.put(10, 10);
		System.out.println(map.toString());
	}
}
