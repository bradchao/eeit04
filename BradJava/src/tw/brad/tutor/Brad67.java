package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Brad67 {

	public static void main(String[] args) {
		File source = new File("dir1/ball.png");
		byte[] buf = new byte[(int)source.length()];
		try {
			BufferedInputStream bin = 
				new BufferedInputStream(new FileInputStream(source));
			bin.read(buf);
			bin.close();
			
			
			Socket socket = new Socket(InetAddress.getByName("10.0.104.177"),9999);
			BufferedOutputStream bout = 
				new BufferedOutputStream(socket.getOutputStream());
			bout.write(buf);
			bout.flush();
			bout.close();
			System.out.println("OK");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
