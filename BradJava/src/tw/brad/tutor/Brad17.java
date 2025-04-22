package tw.brad.tutor;

import tw.brad.apis.Scooter;

public class Brad17 {
	public static void main(String[] args) {
		Scooter s1 = new Scooter();
		System.out.println(s1.getSpeed());
		s1.upSpeed();
		s1.upSpeed();
		s1.upSpeed();
		System.out.println(s1.getSpeed());
	}
}
