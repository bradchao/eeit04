package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Brad61 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			
			BufferedReader br = 
					new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
			String line; StringBuffer mesg = new StringBuffer();
			while ( (line = br.readLine()) != null) {
				mesg.append(line);
			}			
			
			br.close();
			//conn.disconnect();
			//System.out.println(mesg);
			//System.out.println("Finish");
			
			parseJSON(mesg.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void parseJSON(String json) {
		JSONArray root = new JSONArray(json);
		System.out.println(root.length());
		for (int i=0; i<root.length(); i++) {
			JSONObject row = root.getJSONObject(i);
			String name = row.getString("Name");
			String tel = row.getString("ContactTel");
			System.out.printf("%s:%s\n", name, tel);
		}
		
	}
	

}
