package tw.brad.tutor;

public class Brad38 {
	public static void main(String[] args) {
		Bird b1 = new Bird();
		try {
			b1.setLeg(-2);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("XX");
		}
	}
}
class Bird {
	int leg;
	void setLeg(int n) throws Exception{
		if (n>=0 && n<=2) {
			leg = n;
		}else {
			throw new Exception();
		}
	}
}

