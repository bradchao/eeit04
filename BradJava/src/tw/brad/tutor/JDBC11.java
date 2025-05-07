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

public class JDBC11 {
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static Connection conn;

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		System.out.print("Account:");
		String account = scaner.next();
		System.out.print("Password:");
		String passwd = scaner.next();
		System.out.print("Name:");
		String cname = scaner.next();
		System.out.println("-----");
		
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			conn = DriverManager.getConnection(URL, prop);
			// check account
			if (!isAccountExist(account)) {
				// insert
				try {
					registerAccount(account, passwd, cname);
				}catch(Exception e) {
					System.out.println(e);
				}
			}else {
				System.out.println("Account EXIST!");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private static boolean isAccountExist(String account) {
		String sql = "SELECT count(account) count FROM member WHERE account = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("count") > 0;
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	private static void registerAccount(
				String account, 
				String passwd, 
				String cname) 
			throws Exception{
		String sql = "INSERT INTO member (account,passwd,cname) VALUES (?,?,?)";
		String hashPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, account);
		pstmt.setString(2, hashPasswd);
		pstmt.setString(3, cname);
		if (pstmt.executeUpdate() == 0) {
			throw new Exception("Update Failure");
		}
		
	}

}
