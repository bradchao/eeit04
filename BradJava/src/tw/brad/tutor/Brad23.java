package tw.brad.tutor;

import tw.brad.apis.Bike;

public class Brad23 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		System.out.println(b1 == b2);
		int a = 10, b = 3;
		System.out.println(a == b);
		String s1 = "Brad";
		String s2 = "Brad";
		System.out.println(s1 == s2);
		String s3 = new String("Brad");
		System.out.println(s1 == s3);
		String s4 = new String("Brad");
		System.out.println(s4 == s3);
		System.out.println("---");
		System.out.println(s1.equals(s3));
		System.out.println(s4.equals(s3));
		
		
		
		
	}

}
