import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import com.dj.domain.util.ThreadUtil;

public class LANIP {

	public static void main(String[] args) throws Exception {
		String hostStr = "62.196.%d.%d";
		for (int i = 1; i < 255; i++) {
			for (int j = 1; j < 255; j++) {
				String host = String.format(hostStr, i, j);
				boolean result = isHostConnectable(host, 81);
				if(result) {
					System.out.println("http://"+host+":81 -->> "+result);
				}else {
					System.err.println("http://"+host+":81 -->> "+result);
				}
			} 
		}
	}
	
	public static boolean isHostConnectable(String host, int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(host, port), 30);
        } catch (IOException e) {
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
        ThreadUtil.sleep(3000);
        return true;
    }
	
}
