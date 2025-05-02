package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Brad59 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://img.edh.tw/zz/main/202501/5fd87b0c8200000406ed_b.jpg");
			HttpsURLConnection conn = 
				(HttpsURLConnection)url.openConnection();

			BufferedInputStream br = 
				new BufferedInputStream(conn.getInputStream());
			BufferedOutputStream bout = 
				new BufferedOutputStream(new FileOutputStream("dir2/yahoo.jpg"));
			byte[] buf = new byte[4*1024]; int len;
			while ( (len = br.read(buf)) != -1) {
				bout.write(buf, 0, len);
			}
			bout.flush();
			bout.close();
			br.close();
			
			System.out.println("Finish");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
