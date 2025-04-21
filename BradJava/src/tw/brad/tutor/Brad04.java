package tw.brad.tutor;

import java.util.Scanner;

public class Brad04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("X = ");
		int x = scanner.nextInt();
		
		System.out.print("Y = ");
		int y = scanner.nextInt();
		
		int var1 = x + y;
		int var2 = x - y;
		int var3 = x * y;
		int var4 = x / y;
		int var5 = x % y;
		
		System.out.printf("%d + %d = %d\n", x, y, var1);
		System.out.printf("%d - %d = %d\n", x, y, var2);
		System.out.printf("%d x %d = %d\n", x, y, var3);
		System.out.printf("%d / %d = %d ... %d\n", x, y, var4, var5);
		
	}

}
