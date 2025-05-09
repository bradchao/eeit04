package tw.brad.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;

public class GiftDB {
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static Connection conn;	// ?
	private static final String SQL = "SELECT * FROM gift";
	private ResultSet rs;
	private String[] fieldNames;
	
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
		
		ResultSetMetaData rsmd = rs.getMetaData();
		fieldNames = new String[rsmd.getColumnCount()];
		for (int i=1; i<=fieldNames.length; i++) {
			fieldNames[i-1] = rsmd.getColumnLabel(i);
			System.out.println(fieldNames[i-1]);
		}
		
	}
	
	public int getRows() {
		try {
			rs.last();
			return rs.getRow();
		}catch(Exception e) {
			return 0;
		}
	}
	
	public int getCols() {
		return fieldNames.length;
	}
	
	// row, col => 0-base
	public String getData(int row, int col) {
		try {
			rs.absolute(row+1);
			return rs.getString(col+1);
		}catch(Exception e) {
			return "ERROR";
		}
	}
	
	
}
