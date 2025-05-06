package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC02 {

	public static void main(String[] args) {
		// http://localhost:8080/
		String url = "jdbc:mysql://localhost/db1?user=root&password=";
		try {
			Connection conn = DriverManager.getConnection(url);
			System.out.println("OK");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
