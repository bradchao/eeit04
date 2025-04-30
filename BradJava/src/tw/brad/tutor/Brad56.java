package tw.brad.tutor;

import java.net.ServerSocket;
import java.net.Socket;

public class Brad56 {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999);
			Socket socket = server.accept();
			server.close();
			System.out.println("Server OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
