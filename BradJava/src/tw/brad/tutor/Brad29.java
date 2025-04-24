package tw.brad.tutor;

public class Brad29 {
	public static void main(String[] args) {
		//Brad291 obj1 = new Brad291();
		Brad291 obj1 = new Brad291() {
			void m3() {
				System.out.println("Brad291:m3()");
			}
		};
		obj1.m3();
		System.out.println("---");
		Brad291 obj2 = new Brad292();
		obj2.m3();
		System.out.println("---");
		
		Brad291 obj3 = new Brad291() {
			void m3() {
				System.out.println("Brad291:m3():other");
			}
		};
		obj3.m3();
		
		
		
	}
}
abstract class Brad291 {
	Brad291(){System.out.println("Brad291()");}
	void m1() {}
	void m2() {}
	abstract void m3();
}
class Brad292 extends Brad291{
	Brad292(){System.out.println("Brad292()");}
	void m3() {System.out.println("Brad292:m3()");}
}
class Brad293 extends Brad291{
	Brad293(){System.out.println("Brad293()");}
	void m3() {System.out.println("Brad293:m3()");}
}
