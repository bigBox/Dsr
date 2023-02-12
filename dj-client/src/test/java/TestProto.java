import com.dj.protobuf.outside.OutSideProduct;

public class TestProto {
	public static void main(String[] args) {

		OutSideProduct.Builder outSideProduct = OutSideProduct.newBuilder();
		outSideProduct.setProductId(1);
		outSideProduct.setCount(100);
		System.out.println(System.identityHashCode(outSideProduct.build()));

		outSideProduct.setProductId(2);
		outSideProduct.setCount(200);
		System.out.println(System.identityHashCode(outSideProduct.build()));
	}
}
