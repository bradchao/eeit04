package tw.brad.tutor;

public class Brad37 {
	public static void main(String[] args) {
		int a = 10, b =0;
		int c;
		int[] d = {1,2,3,4};
		
		try {
			c = a / b;
			System.out.println(c);
			System.out.println(d[10]);
			System.out.println("OK");
		}catch(ArrayIndexOutOfBoundsException e2) {
			System.out.println("B");
		}catch(ArithmeticException e1) {
			System.out.println("A");
		}catch(Exception e3) {
			System.out.println("C");
		}
		
		System.out.println("Game Over");
		
	}
}
