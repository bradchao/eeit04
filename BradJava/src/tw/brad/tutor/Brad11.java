package tw.brad.tutor;

public class Brad11 {

	public static void main(String[] args) {
		int[] a;
		a = new int[3];
		System.out.println(a.length);
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("---");
		a[1] = 123;
		a[0] = 12;
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("---");
		// for-each
		for(int v : a) {
			System.out.println(v);
		}
		
		
		
	}

}
