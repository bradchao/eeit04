package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC10 {
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String SQL = 
		"SELECT id,name FROM gift ORDER BY id LIMIT ?,?";
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("頁: ");
		int page = scanner.nextInt();
		int rpp = 7;
		int start = (page - 1)*rpp;
		System.out.println("---");
		
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, start);
			pstmt.setInt(2, rpp);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s:%s\n", id, name);
			}
			
			System.out.println("Finish");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
