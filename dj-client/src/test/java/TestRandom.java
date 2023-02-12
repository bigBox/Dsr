import com.dj.domain.util.ThreadUtil;
import com.dj.domain.util.math.RandomUtil;

public class TestRandom {
	public static void main(String[] args) {
		while (true) {
//			List<Integer> randomFlyScond = Lists.newArrayListWithExpectedSize(5);
//			for (int i = 0; i < 5; i++) {
//				randomFlyScond.add(i);
//			}
//			for (int i = 0; i < 3; i++) {
//				int index = RandomUtil.nextInt(randomFlyScond.size());
//				System.out.println(randomFlyScond.get(index));
//				randomFlyScond.remove(index);
//			}
			System.out.println(RandomUtil.nextInt(10));
			ThreadUtil.sleep(500);
		}
	}
}
