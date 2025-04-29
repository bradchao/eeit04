package tw.brad.tutor;

public class Brad40 {
	public static void main(String[] args) {
		m1();
		System.out.println("Finish");
	}
	static void m1() {
		int a = 10, b = 0;
		try {
			System.out.println(a / b);
			
		}catch(Exception e) {
			System.out.println("XX");
			return;
		}finally {
			System.out.println("finally");
		}
		System.out.println("End");
	}
}
