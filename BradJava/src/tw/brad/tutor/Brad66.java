package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad66 {

	public static void main(String[] args) {
		while(true) {
			try {
				ServerSocket server = new ServerSocket(9999);
				System.out.println("Listen....");
				
				Socket socket = server.accept();
				String urIp = socket.getInetAddress().getHostAddress();
				FileOutputStream fout = new FileOutputStream("dir2/" + urIp+".png");
				BufferedInputStream bin = 
					new BufferedInputStream(socket.getInputStream());
				byte[] buf = new byte[4*1024*1024]; int len;
				while ((len = bin.read(buf))!= -1) {
					fout.write(buf, 0, len);
				}
				
				fout.flush();
				fout.close();
				bin.close();
				
				server.close();
				System.out.printf("%s\n", urIp);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
