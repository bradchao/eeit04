package tw.brad.tutor;

public class JDBC01 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("OK");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}

}
