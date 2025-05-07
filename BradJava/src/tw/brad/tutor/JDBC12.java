package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.apis.BCrypt;

public class JDBC12 {
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static Connection conn;
	private static final String LOGIN = 
		"SELECT * FROM member WHERE account = ?";
	

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		System.out.print("Account:");
		String account = scaner.next();
		System.out.print("Password:");
		String passwd = scaner.next();
		System.out.println("-----");
		
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(LOGIN);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String hashPasswd = rs.getString("passwd");
				if (BCrypt.checkpw(passwd, hashPasswd)) {
					System.out.printf("Welcome, %s", rs.getString("cname"));
				}else {
					System.out.println("Login Failure(2)");
				}
			}else {
				System.out.println("Login Failure(1)");
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

}
