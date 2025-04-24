package tw.brad.tutor;

public class Brad30 {
	public static void main(String[] args) {
		Brad302 obj1 = new Brad302();
		obj1.m1();
	}
}
interface Brad301 {
	void m1();
	void m2();
}
class Brad302 extends Object implements Brad301, Brad303{
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
}
interface Brad303 {
	void m3();
	void m4();
}
interface Brad304 extends Brad301, Brad303{
	void m5();
}
class Brad305 implements Brad304 {
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
	public void m5() {}
	
}

