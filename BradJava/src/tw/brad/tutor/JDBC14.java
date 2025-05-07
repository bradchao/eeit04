package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.apis.BCrypt;

public class JDBC14 {
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
				String account = rs.getString("account");
				InputStream in = rs.getBinaryStream("icon");
				new Thread(){
					public void run() {
						try {
							String filename = String.format("dir2/%s.png", account);
							FileOutputStream fout = new FileOutputStream(filename);
							
							byte[] buf = new byte[128*1024]; 
							int len = in.read(buf);
							
							fout.write(buf, 0, len);
							fout.flush();
							fout.close();
							System.out.println("OK");
						}catch(Exception e) {
							System.out.println(e);
						}
					}
				}.start();
				System.out.println("Writing...");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

}
