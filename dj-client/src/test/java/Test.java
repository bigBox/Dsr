import com.dj.domain.util.ThreadUtil;
import com.dj.domain.util.math.RandomUtil;

public class Test {
	public static void main(String[] args) throws Exception {
		System.setProperty("logFilePath", "/mnt/logs/client/");
		System.setProperty("logLevel", "499");
		
//		for (int i = 0; i < 10; i++) {
//			System.out.println(i%2+1);
//		}
		
//		Scanner scanner = new Scanner(System.in);
//		while (true) {
//			String str = scanner.nextLine().trim();
//			int sum = Integer.parseInt(str);
//			int avg = (int) Math.ceil(sum / 3.0d);
//			int ct3 = sum - avg - avg;
//			System.out.println("sum: " + sum + " -----" + avg + "," + avg + "," + ct3);
//		}
//		Scanner scanner = new Scanner(System.in);
//		while (true) {
//			String stir = scanner.nextLine().trim();
//			System.out.println(Md5Utils.md5To32(stir).substring(8, 24));
//		}
		
//		System.out.println(Math.round(1.5));
//		System.out.println(Math.round(-1.5));
//		System.out.println(Math.round(2.9));
		while (true) {
			System.out.println(RandomUtil.nextInt(3));
			ThreadUtil.sleep(500);
		}
		
//		String str1 = "夏";
//		System.out.println(Sha.getPassword(str1));
		
		
//		String str1 = "通话";
//		String str2 = "重地";
//		System.out.println(String. format("str1：%d | str2：%d",  str1.hashCode(),str2.hashCode()));
//		System.out.println(str1.equals(str2));
//		System.out.println(str1 == str2);
	}
}

/**
*	1.==和equals的区别是什么？
*	基本类型：比较的是值是否相同
*	引用类型：比较的是引用是否相同
*	equals本质上就是==，只不过String和Integer等重写了equals方法，把它变成了值比较。
*
*	2.两个对象hashCode()相同，则equals()也一定为ture，对吗？
*	不对，哈希值相等，并不一定能得出键值对相等
*
*	String属于基础的数据类型吗？
*	String不属于基础类型
*	基础类型有8种：byte 1，short 2，int 4，long 8，float 4，double 8，boolean 1，char 2。而String属于对象
*
*	java中操作字符串都有哪些类？它们之间有什么区别？
*	操作字符串的类有：String、StringBuffer、StringBuilder。
*	String和StringBuffer、StringBuilder的区别在于String声明的是不可变的对象，每次操作都会生成
*	新的String对象，然后将指针指向新的String对象，而StringBuffer、StringBuilder可以在原有对象的基础上
*	进行操作，所以在经常改变字符串内容的情况下最好不要使用String。
*	StringBuffer和StringBuilder最大的区别在于，StringBuffer是线程安全的，而StringBuilder是非线程安全的，
*	但StringBuilder的性能却高于StringBuffer。
*
*
*	sleep和wait有什么区别？
*	sleep方法是线程类Thread的静态方法，让调用线程进入睡眠状态，让出执行机会给其他线程，等到休眠时间结束后，
*	线程进入就绪状态和其他线程一起竞争cpu的执行时间。因为sleep是static静态的方法，他不能改变对象的机锁
*	当一个synchronized快中调用sleep方法，线程虽然进入休眠，但是对象的机锁没有被释放，其他线程依然无法访问这个对象。
*	wait是Object类的方法，当一个线程执行到wait方法时，它就进入到一个和该对象相关的等待池，同时释放对象的机锁，
*	使得其他线程能够访问，可以通过notify，notifyAll方法来唤醒等待的线程
*
*	Java虚拟机
*	JVM执行Java程序的过程
*	Java源代码文件(.java)会被Java编译器编译为字节码文件(.class)，然后由JVM中的类加载器加载各个类
*	的字节码文件，加载完毕后，交由JVM执行引擎执行。
*	1.1 JVM生命周期
*	启动。启动一个Java程序时，一个JVM实例就产生了，任何一个拥有public static void main(String[] args)
*	函数的class都可以作为JVM实例运行的起点。
*	运行。main()作为该程序初始线程的起点，任何其他线程均由该线程启动。
*	消亡。当程序中的所有非守护线程都终止时，JVM才退出；若安全管理器允许，程序也可以使用Runtime类或者System.exit()来退出。
*	1.2 JVM体系结构
*	类加载器（ClassLoader），用来装载class文件
*	执行引擎，执行字节码，或者执行本地方法
*	运行时数据区，方法区，堆，java栈，PC寄存器，本地方法栈，（P3内存模型）
*	总结：
*	1、虚拟机并不神秘，在操作系统的角度看来，它只是一个普通进程。
*	2、这个叫做虚拟机的进程比较特殊，它能够加载我们编写的class文件。如果把JVM比作一个人，那么class文件就是我们吃的食物。
*	3、加载class文件的是一个叫做类加载器的子系统，就好比我们的嘴巴，把食物吃到肚子里。
*	4、虚拟机中的执行引擎用来执行class文件中的字节码指令。就好比我们的肠胃，对吃进去的食物进行消化。
*	5、虚拟机在执行过程中，要分配内存创建创建对象。当这些对象过时无用了，必须要自动清理这些无用的对象。清理对象回收内存的任务由垃圾收集器负责。
*	就好比人吃进去的食物，在消化之后，必须把废物排出体外，腾出空间可以在下次饿的时候吃饭并消化食物。
*
*
*	通过多线程机制使得多个任务同时执行处理，所有的线程共享JVM内存区域main memory，而每个线程又单独的有自己的工作内存，当线程与内存区域进行交互时，
*	数据从主内存拷贝到工作内存，进而交由线程处理
*
*	Java虚拟机运行时数据区
*	方法区：类信息，常量，静态变量，即时编译器编译后的代码
*	虚拟机栈:Java方法（局部变量表，操作数栈，动态链接，方法出口）
*	本地方法栈：Native方法
*	堆：对象实例和数组
*	程序计数器：虚拟机字节码指令的地址或Undefined
*
*
*	GC算法
*	引用计数算法
*	根搜索算法
*	分代手机算法
*
*	Java实现线程通信的四种方式
*	1、synchronized同步
*	当两个线程同时持有一个类的对象时，即时两个线程调用不同的方法（方法名前用synchronized修饰），但由于他们是同步执行的。
*	可实现线程通信。本质上是共享内存式通信，多个线程访问同一共享变量，谁拿到锁，谁执行。
*	2、while轮询
*	3、wait/notify机制
*
*
*	类加载过程
*	1.加载							加载
*	2.验证							验证
*	3.准备							准备
*	4.解析							解析
*	5.初始化（先父后子）			初始化（先父后子）
*
*	创建对象
*	1.在堆区分配对象需要的内存		1.在堆区分配对象所需的内存
*	2.对所有实例变量赋默认值		2.对所有实例变量赋默认值
*	3.执行实例初始化代码			3.执行实例初始化代码
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
**/