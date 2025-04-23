package tw.brad.tutor;

public class Brad21 {
	public static void main(String[] args) {
		byte b = 1;
		Brad213 obj = new Brad213(b);
	}
}
class Brad211 extends Object{
	Brad211(String a){
		// super();
	}
}
class Brad212 extends Brad211 {
	Brad212(int a){
		super("");
		System.out.println("Brad212");
	}
}
class Brad213 extends Brad212 {
	Brad213(){
		super(1);
		System.out.println("A");
	}
//	Brad213(int a){
//		super(1);
//		System.out.println("B");
//	}
//	Brad213(byte a){
//		super(1);
//		System.out.println("C");
//	}
	Brad213(double a){
		super(1);
		System.out.println("D");
	}
}
