package tw.brad.tutor;

public class Brad62 {
	public static void main(String[] args) {
		System.out.println("main start");
		Brad621 obj1 = new Brad621("A");
		Brad621 obj2 = new Brad621("B");
		Brad622 obj3 = new Brad622("C");
		Thread mt1 = new Thread(obj3);
		obj1.start();
		obj2.start();
		mt1.start();
		System.out.println("main finish");
	}
}

class Brad621 extends Thread {
	private String name;
	Brad621(String name){this.name = name;}
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.printf("%s : %d\n", name, i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
	public void m1() {
		System.out.println("Brad621:m1()");
	}
}

class Brad622 implements Runnable {
	private String name;
	Brad622(String name){this.name = name;}
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.printf("%s : %d\n", name, i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
	public void m1() {
		System.out.println("Brad621:m1()");
	}
	
}

