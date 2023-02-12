package thread;

public class TestIntger {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Integer i1 = 33;
		Integer i2 = 33;
		System.out.println(i1==i2);
		
		Integer i11 = -128;
		Integer i22 = -128;
		System.out.println(i11==i22);
		
		
		Integer a = new Integer(2);
        Integer b = new Integer(2);
        System.out.println(a==b);// false
		
	}
}
