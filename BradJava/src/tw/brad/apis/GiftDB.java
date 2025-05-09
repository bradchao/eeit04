package tw.brad.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class GiftDB {
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static Connection conn;	// ?
	private static final String SQL = "SELECT * FROM gift";
	private ResultSet rs;
	
	public GiftDB() throws Exception {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		
		conn = DriverManager.getConnection(URL, prop);
		queryDB();
	}
	
	private void queryDB()  throws Exception {
		queryDB(SQL);
	}
	private void queryDB(String sql) throws Exception{
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);
	}
	
	public int getRows() {
		return 12;
	}
	
	
	
}
