package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Brad45 {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/file2.txt");
			
			int c;
			while ( (c = fin.read()) != -1) {
				System.out.print((char)c);
			}
			
			
			fin.close();
			//System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
