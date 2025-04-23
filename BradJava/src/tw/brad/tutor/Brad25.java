package tw.brad.tutor;

import tw.brad.apis.TWId;

public class Brad25 {

	public static void main(String[] args) {
		if (TWId.checkTWId("A123456789")) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		System.out.println("----");
		TWId id1 = new TWId();
		TWId id2 = new TWId(false);
		TWId id3 = new TWId('X');
		TWId id4 = new TWId(true, 'R');
		System.out.println(id1.getId());
		System.out.println(id2.getId());
		System.out.println(id3.getId());
		System.out.println(id4.getId());
	}

}
