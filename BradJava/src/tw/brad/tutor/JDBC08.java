package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 * https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx
 */
public class JDBC08 {
	private static final String dataUrl = "https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx"; 
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String SQL = 
		"INSERT INTO gift (name,feature,tel,picurl,city,town,lat,lng)" +
				" VALUES (?,?,?,?,?,?,?,?)";

	public static void main(String[] args) {
		try {
			URL url = new URL(dataUrl);
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			
			BufferedReader br = 
					new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
			String line; StringBuffer mesg = new StringBuffer();
			while ( (line = br.readLine()) != null) {
				mesg.append(line);
			}			
			
			br.close();
			insertData(mesg.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private static void insertData(String json) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		
		try (Connection conn = DriverManager.getConnection(URL, prop)){
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			JSONArray root = new JSONArray(json);
			for (int i=0; i<root.length(); i++) {
				JSONObject row = root.getJSONObject(i);
				String name = row.getString("Name");
				String feature = row.getString("Feature");
				String tel = row.getString("ContactTel");
				String picurl = row.getString("Column1");
				String city = row.getString("County");
				String town = row.getString("Township");
				String lat = row.getString("Latitude");
				String lng = row.getString("Longitude");
				
				pstmt.setString(1, name);
				pstmt.setString(2, feature);
				pstmt.setString(3, tel);
				pstmt.setString(4, picurl);
				pstmt.setString(5, city);
				pstmt.setString(6, town);
				
				try {
					pstmt.setDouble(7, Double.parseDouble(lat));
					pstmt.setDouble(8, Double.parseDouble(lng));
				}catch(Exception e) {
					pstmt.setDouble(7, 0.0);
					pstmt.setDouble(8, 0.0);
				}
				
				pstmt.executeUpdate();
			}
			System.out.println("Finish");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}

}
