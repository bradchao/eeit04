package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class JDBC03 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/brad";
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "");
		try {
			Connection conn = DriverManager.getConnection(url, prop);
			
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO cust (cname,tel,birthday)" + 
						" VALUES ('brad','123','1999-01-02')";
			int n = stmt.executeUpdate(sql);
			System.out.println(n);
			
			String delSQL = "DELETE FROM cust WHERE id = 3";
			n = stmt.executeUpdate(delSQL);
			System.out.println(n);
			
			String updateSQL = "UPDATE cust SET tel = '321', cname='Tony' WHERE id = 4";
			n = stmt.executeUpdate(updateSQL);
			System.out.println(n);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
