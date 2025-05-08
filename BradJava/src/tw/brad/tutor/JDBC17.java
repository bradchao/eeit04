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

public class JDBC17 {
	private static final String URL = "jdbc:mysql://localhost/north"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static Connection conn;
	private static final String QUERY = 
		"SELECT e.EmployeeID, e.LastName, SUM(od.UnitPrice*od.Quantity) total FROM orders o "
		+ "JOIN orderdetails od ON (o.OrderID = od.OrderID) "
		+ "JOIN employees e ON (o.EmployeeID = e.EmployeeID) "
		+ "GROUP BY o.EmployeeID "
		+ "ORDER BY total DESC";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(QUERY);
			ResultSet rs = pstmt.executeQuery();
			int rank = 1;
			while (rs.next()) {
				String id = rs.getString("EmployeeID");
				String name = rs.getString("LastName");
				String total = rs.getString("total");
				System.out.printf("%d: %s : %s : %s\n", rank++, id, name, total);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

}
