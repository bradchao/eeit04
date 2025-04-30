package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Brad50 {

	public static void main(String[] args) {
		try (FileReader reader = new FileReader("dir1/ns1hosp.csv");
				BufferedReader br = new BufferedReader(reader);){
			
			br.readLine();
			String line;
			while ( (line = br.readLine()) != null) {
				String[] data = line.split(",");
				System.out.printf("%s : %s\n", data[2], data[4]);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
