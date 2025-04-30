package tw.brad.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Brad55 {

	public static void main(String[] args) {
		byte[] buf = new byte[1024];
		while(true) {
			try {
				DatagramSocket socket = new DatagramSocket(8888);
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				socket.close();
				
				String urIp = packet.getAddress().getHostAddress();
				String mesg = new String(
						packet.getData(), 0, packet.getLength());
				System.out.printf("%s : %s\n", urIp, mesg);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
