package tw.brad.tutor;

public class Brad63 {

	public static void main(String[] args) {
		System.out.println("main start");
		Brad631 obj = new Brad631();
		obj.setDaemon(false);
		obj.start();
		System.out.println("main finish");
	}

}
class Brad631 extends Thread {
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
