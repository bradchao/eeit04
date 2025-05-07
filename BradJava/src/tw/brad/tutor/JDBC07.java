package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

/*
 * https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx
 */
public class JDBC07 {
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String SQL = 
		"UPDATE cust SET cname = ?, tel = ? WHERE id = ?";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ID: ");
		int id = scanner.nextInt();
		System.out.print("Name: ");
		String name = scanner.next();
		System.out.print("Tel: ");
		String tel = scanner.next();
		
		
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setInt(3, id);
			
			if (pstmt.executeUpdate() > 0) {
				System.out.println("Success");
			}else {
				System.out.println("Failure:" + SQL);
			}
			
			System.out.println("Finish");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
