package tw.brad.tutor;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Brad57 {

	public static void main(String[] args) {
		String mesg = "Hello, World";
		
		try {
			Socket client = new Socket(
					InetAddress.getByName("127.0.0.1"), 9999);
			
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(client.getOutputStream()));
				bw.write(mesg);
				bw.flush();
				bw.close();
			
			client.close();
			System.out.println("Send OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
