package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC03 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/db1";
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "");
		try {
			Connection conn = DriverManager.getConnection(url, prop);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
