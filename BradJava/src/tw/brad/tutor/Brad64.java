package tw.brad.tutor;

public class Brad64 {
	public static void main(String[] args) {
		System.out.println("main start");
		Brad641 obj1 = new Brad641();
		Brad642 obj2 = new Brad642();
		obj1.start();
		obj2.start();
		
		try {
			obj1.join();
		} catch (InterruptedException e) {
		}
		
		System.out.println("main finish");
		
	}
}
class Brad641 extends Thread{
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
class Brad642 extends Thread{
	@Override
	public void run() {
		for (int i=0; i<100; i++) {
			System.out.println(100+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

