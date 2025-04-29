package tw.brad.tutor;

import java.io.File;

public class Brad42 {
	public static void main(String[] args) {
		File f1 = new File("d:/brad/dir2");
		if (f1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
			f1.mkdir();
		}
		
	}
}
