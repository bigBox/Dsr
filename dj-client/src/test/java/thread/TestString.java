package thread;

public class TestString {
	public static void main(String[] args) {
		String s1 = "cat";
		String s2 = "cat";
		
		String s3 = "cat";
		
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
	}
}
