package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.apis.BCrypt;
import tw.brad.apis.Bike;

public class JDBC16 {
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static Connection conn;
	private static final String QUERY = 
		"SELECT * FROM member WHERE id = ?";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(QUERY);
			pstmt.setInt(1, 3);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				InputStream in = rs.getBinaryStream("bike");
				//---------
				ObjectInputStream oin = new ObjectInputStream(in);
				Object obj = oin.readObject();
				Bike b1 = (Bike)obj;
				System.out.println(b1);
						
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

}
