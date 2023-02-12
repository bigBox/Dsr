public class Test33 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/**
		 *
		 * hashCode的存在主要是用于查找的快捷性，如Hashtable，HashMap等，hashCode是用来散列存储结构中确定对象的存储地址的
		 *
		 * HashMap是基于哈希表的Map接口的非同步实现。 此实现提供所有可选的映射操作，并允许使用null值和null键。
		 * 此类不保证映射的顺序，特别是它不保证该顺序恒久不变。 在java编程语言中，最基本的结构就是两种，一个是数组，另外一个是模拟指针（引用）
		 * 所有的数据结构都可以用这两个基本结构来构造的，HashMap也不例外。 HashMap实际上是一个链表散列的数据结构，即数组和链表的结合体
		 *
		 *
		 * HashMap的实现原理： 1.利用key的hashCode重新hash计算当前对象的元素在数组中的下标
		 * 2.存储时，如果出现hash值相同的key，此时有两种情况： (1)如果key相同，则覆盖原始值；
		 * (2)如果key不同（出现冲突），则将当前key-value放链表中
		 * 3.获取时，直接找到hash值对应的下标，在进一步判断key是否相同，从而找到对应值。
		 *
		 * 分布式： 一个业务分拆多个子业务，部署在不同的服务器上 分布式计算： 将大量计算任务分配到多个计算单元上以提高总计算性能 分布式存储：
		 * 将大量数据分配到多个存储单元上以提高总存储量
		 *
		 * 集群：同一个业务，部署在多个服务器上 集群同样也非常好理解，就是在多个服务器上部署同一个业务，这样可以起到两个作用： 1.分散每台服务器的压力
		 * 2.任意一台或者几台服务器宕机也不会影响整个系统
		 */

		bbb: for (int i = 0; i < 10; i++) {
			System.out.println("i=" + i);
			for (int j = 0; j < 10; j++) {
				System.out.println("j=" + j);
				break bbb;
			}
		}

		short num = 10;
		switch (num) {
		case 1:
			break;
		}
	}
}
