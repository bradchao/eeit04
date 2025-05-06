package tw.brad.tutor;

public class Brad69 {
	public static void main(String[] args) {
		Store store = new Store();
		Producer p = new Producer(store);
		Consumer c1 = new Consumer(store);
		Consumer c2 = new Consumer(store);
		Consumer c3 = new Consumer(store);
		p.start();
		c1.start();
		c2.start();
		c3.start();

	}
}
class Store {
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

class Producer extends Thread {
	private Store store;
	public Producer(Store store) {
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
class Consumer extends Thread {
	private Store store;
	public Consumer(Store store) {
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


