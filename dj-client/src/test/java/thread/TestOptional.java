package thread;

import java.util.Optional;

public class TestOptional {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Integer value1 = null;
		Integer value2 = new Integer(10);
		Optional<Integer> a = Optional.ofNullable(value1);
		Optional<Integer> b = Optional.of(value2);
		
		a.orElse(new Integer(22));
		
		System.out.println(a.isPresent());
		System.out.println(b.get());
	}
}
