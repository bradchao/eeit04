package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad48 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileOutputStream fout = new FileOutputStream("dir2/cafe2.jpg");
			FileInputStream fin = new FileInputStream("dir1/coffee2.jpg");
			int len; byte[] buf = new byte[4*1024];
			while ( (len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			fin.close();
			fout.flush();
			fout.close();
			System.out.println("OK");
			System.out.println(System.currentTimeMillis() - start);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
