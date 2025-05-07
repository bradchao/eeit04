package tw.brad.tutor;

import tw.brad.apis.BCrypt;

public class Brad71 {
	public static void main(String[] args) {
		String passwd = "123456";
		String hashPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(hashPasswd);
		
		String input = "123456";
		if (BCrypt.checkpw(input, hashPasswd)) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		
		
	}
}
