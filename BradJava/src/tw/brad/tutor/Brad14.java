package tw.brad.tutor;

public class Brad14 {

	public static void main(String[] args) {
		int[][] a;
		a = new int[3][2];
		
		int[][] b;
		b = new int[3][];
		b[0] = new int[2];
		b[1] = new int[3];
		b[2] = new int[4];
		
		for(int[] v : b) {
			for (int vv : v) {
				System.out.print(vv + "  ");
			}
			System.out.println();
		}
		System.out.println("====");
		System.out.println(b);
		System.out.println(b[0]);
		System.out.println(b[0][0]);
		
		
	}

}
