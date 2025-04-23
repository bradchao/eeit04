package tw.brad.apis;

public class TWId {

	public static boolean checkTWId(String id) {
		boolean isRight = false;
		/*
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		if (id.length() == 10) {
			char c1 = id.charAt(0);
			if (letters.indexOf(c1) != -1) {
				if (id.charAt(1)=='1' || id.charAt(1)=='2') {
					
				}
			}
		}
		*/
		
		if (id.matches("[A-Z][12][0-9]{8}")) {
			isRight = true;
		}
		
		return isRight;
	}
	
}
