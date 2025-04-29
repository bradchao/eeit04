package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad47 {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("dir2/coffee.jpg");
			FileInputStream fin = new FileInputStream("dir1/coffee.jpg");
			int len; byte[] buf = new byte[4*1024];
			while ( (len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			fin.close();
			fout.flush();
			fout.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
