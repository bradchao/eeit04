package tw.brad.tutor;

public class Brad27 {
	public static void main(String[] args) {
//		Brad271 obj1 = new Brad271();
//		Brad271 obj2 = new Brad271();
		Brad271.m2();
		Brad271.m2();
		Brad271.m2();
	}
}
class Brad271 {
	{
		System.out.println("{}");
	}
	static {
		System.out.println("static:{}");
	}
	Brad271(){
		System.out.println("Brad271()");
	}
	void m1() {
		System.out.println("Brad271:m1()");
	}
	static void m2() {
		System.out.println("static:m2()");
	}
}
