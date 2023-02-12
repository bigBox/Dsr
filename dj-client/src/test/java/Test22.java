import java.util.concurrent.locks.ReentrantLock;

public class Test22 implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            lock.lock();
            try {
                i++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test22 test = new Test22();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}

/*
装箱：将基本类型用它们对应的引用类型包装起来；装箱是把基本类型用对应的引用类型封装起来
拆箱：将包装类型转换为基本数据类型；
Java使用自动装箱和拆箱机制
*/