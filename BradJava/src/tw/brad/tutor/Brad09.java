package tw.brad.tutor;

import java.util.Scanner;

public class Brad09 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Year = ");
		int year = scanner.nextInt();
		boolean isLeap = false;
		
		if (year %4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					isLeap = true;
				}else {
					isLeap = false;
				}
			}else {
				isLeap = true;
			}
		}else {
			isLeap = false;
		}
		
		System.out.printf("%d 年是 %s年", year, isLeap?"潤":"平");
		System.out.println("-----");
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			isLeap = true;
		}else {
			isLeap = false;
		}
		
	}

}
