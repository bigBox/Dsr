import java.nio.ByteBuffer;

public class TestByteBuffer {
	public static void main(String[] args) {
		ByteBuffer buf = ByteBuffer.allocate(1024);
		buf.putShort((short) 17134);
		
		System.out.println(buf.getShort(0));
	}
}
