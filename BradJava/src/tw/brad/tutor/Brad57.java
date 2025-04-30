package tw.brad.tutor;

import java.net.InetAddress;
import java.net.Socket;

public class Brad57 {

	public static void main(String[] args) {
		try {
			Socket client = new Socket(
					InetAddress.getByName("127.0.0.1"), 9999);
			client.close();
			System.out.println("Send OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
