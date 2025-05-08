package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC18 {
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String QUERY = "SELECT * FROM gift";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(QUERY);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String name = rs.getString("name");
			System.out.println(name);
			
			if (rs.absolute(4)) {
				name = rs.getString("name");
				System.out.println(name);
			}else {
				System.out.println("XX");
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
