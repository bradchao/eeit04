package tw.brad.tutor;

public class Brad26 {
	public static void main(String[] args) {
		System.out.println(Brad261.j);
		Brad261 obj1 = new Brad261();
		Brad261 obj2 = new Brad261();
		Brad261 obj3 = new Brad261();
		System.out.println(obj1.i);
		System.out.println(obj2.i);
		System.out.println(obj3.i);
		System.out.println("----");
		System.out.println(obj1.j);
		System.out.println(Brad261.j);
	}
}

class Brad261 {
	int i;
	static int j;
	Brad261(){
		i++;
		j++;
	}
}


