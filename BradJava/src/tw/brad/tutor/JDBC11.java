package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC11 {
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";

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
			Connection conn = DriverManager.getConnection(URL, prop);
			// check account
			if (isAccountExist(account)) {
				// insert
				try {
					registerAccount(account, passwd, cname);
				}catch(Exception e) {
					
				}
			}else {
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private static boolean isAccountExist(String account) {
		return false;
	}
	
	private static void registerAccount(
				String account, 
				String passwd, 
				String cname) 
			throws Exception{
		
	}

}
