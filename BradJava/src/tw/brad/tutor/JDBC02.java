package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC02 {

	public static void main(String[] args) {
		// http://localhost:8080/
		/*
		 * 	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			String connectionUrl = 
			"jdbc:sqlserver://localhost;encrypt=true;database=AdventureWorks;integratedSecurity=true;"  
			Connection con = DriverManager.getConnection(connectionUrl); 
		 */
		/*
		String url = "jdbc:mysql://localhost/db1?user=root&password=";
		try {
			Connection conn = DriverManager.getConnection(url);
			System.out.println("OK");
		} catch (SQLException e) {
			System.out.println(e);
		}
		*/
		/*
		String url = "jdbc:mysql://localhost/db1";
		try {
			Connection conn = DriverManager.getConnection(url, "root", "");
			System.out.println("OK1");
		}catch(Exception e) {
			System.out.println(e);
		}
		*/
		
		String url = "jdbc:mysql://localhost/db1";
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "");
		try {
			Connection conn = DriverManager.getConnection(url, prop);
			System.out.println("OK2");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
