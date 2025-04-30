package tw.brad.tutor;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Brad53 {

	public static void main(String[] args) {
		try {
			InetAddress[] ip = 
				InetAddress.getAllByName("www.hinet.net");
			System.out.println(ip.length);
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
	}

}
