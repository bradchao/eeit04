package tw.brad.tutor;

import tw.brad.apis.TWId;

public class Brad25 {

	public static void main(String[] args) {
		if (TWId.checkTWId("A123456789")) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
	}

}
