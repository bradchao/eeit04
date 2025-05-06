package tw.brad.tutor;

public class Brad70 {
	public static void main(String[] args) {
		Store2 store = new Store2();
		Producer2 p = new Producer2(store);
		Consumer2 c1 = new Consumer2(store);
		p.start();
		c1.start();

	}
}
class Store2 {
	private int qty;
	private final int max = 10;
	
	void add(int add) {
		System.out.printf("進貨中...%d\n", add);
		while (add + qty > max) {
			// wait....
		}
		qty += add;
		System.out.printf("完成進貨中...%d, 目前庫存量: %d\n", add, qty);
	}
	void buy(int buy) {
		System.out.printf("買貨中...%d\n", buy);
		while (buy > qty) {
			// wait....
		}
		qty -= buy;
		System.out.printf("完成買貨中...%d, 目前庫存量: %d\n", buy, qty);
	}
}

class Producer2 extends Thread {
	private Store2 store;
	public Producer2(Store2 store) {
		this.store = store;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			store.add(5);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}
class Consumer2 extends Thread {
	private Store2 store;
	public Consumer2(Store2 store) {
		this.store = store;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			store.buy((int)(Math.random()*5)+1);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
			}
		}
	}
}


