package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Brad58 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.iii.org.tw");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			
			BufferedReader br = 
					new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
			String line; StringBuffer mesg = new StringBuffer();
			while ( (line = br.readLine()) != null) {
				mesg.append(line + "\n");
			}			
			
			br.close();
			conn.disconnect();
			System.out.println(mesg);
			System.out.println("Finish");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
