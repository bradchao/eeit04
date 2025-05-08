package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC09 {
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String SQL = 
		"SELECT id,name pname, feature,city,town FROM gift " + 
			"WHERE name LIKE ? OR feature LIKE ? OR city LIKE ? OR town LIKE ? " +
			"ORDER BY " + 
				"CASE " + 
					"WHEN name LIKE ? THEN 1 " +
					"ELSE 2 " +
				"END, " +
				"id ASC";

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		System.out.print("Keyword:");
		String search = scaner.next();
		System.out.println("-----");
		
		String kw = "%" + search + "%";
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, kw);
			pstmt.setString(2, kw);
			pstmt.setString(3, kw);
			pstmt.setString(4, kw);
			pstmt.setString(5, kw);
			
			ResultSet rs = pstmt.executeQuery();			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("pname");
//				String lat = rs.getString("lat");
//				String lng = rs.getString("lng");
//				System.out.printf("%s:%s:%s:%s\n", id, name, lat, lng);

				String feature = rs.getString("feature");
				String city = rs.getString("city");
				String town = rs.getString("town");
				System.out.printf("%s:%s:%s:%s:%s\n", id, name, feature, city, town);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
