package tw.brad.tutor;

import tw.brad.apis.Bike;
import tw.brad.apis.Scooter;

public class Brad22 {
	public static void main(String[] args) {
		String s1 = "Brad";
		String s2 = new String();
		byte[] bs = {97,98,99,100};
		String s3 = new String(bs);
		String s4 = new String(bs, 1, 2);
		String s5 = new String("Brad");
		System.out.println(s1);
		System.out.println("---");
		Bike b1 = new Bike();
		System.out.println(b1);
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(b1);
		System.out.println("---");
		Scooter s6 = new Scooter();
		System.out.println(s6);
		
	}
}
