package tw.brad.tutor;

public class Brad39 {
	public static void main(String[] args) {
		Brad391 obj = new Brad391();
		obj.m1();
	}
}
class Brad391 {
	void m1() {
		System.out.println("m1");
		try {
			m2();
		} catch (Exception e) {
		}
	}
	void m2() throws Exception{
		System.out.println("m2");
		m3();
	}
	void m3() throws Exception {
		System.out.println("m3");
		throw new Exception();
	}
}
