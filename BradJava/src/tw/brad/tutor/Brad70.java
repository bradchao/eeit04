package tw.brad.tutor;

public class Brad70 {
	public static void main(String[] args) {
		Store2 store = new Store2();
		Producer2 p = new Producer2(store);
		Consumer2 c1 = new Consumer2(store, "A");
		Consumer2 c2 = new Consumer2(store, "B");
		Consumer2 c3 = new Consumer2(store, "C");
		p.start();
		c1.start();
		c2.start();
		c3.start();

	}
}
class Store2 {
	private int qty;
	private final int max = 10;
	
	synchronized void add(int add) throws InterruptedException {
		System.out.printf("進貨中...%d\n", add);
		while (add + qty > max) {
			// wait....
			wait();
		}
		qty += add;
		notifyAll();
		System.out.printf("完成進貨中...%d, 目前庫存量: %d\n", add, qty);
	}
	synchronized void buy(int buy,String who) throws InterruptedException {
		System.out.printf("買貨中...%d\n", buy);
		while (buy > qty) {
			// wait....
			wait();
		}
		qty -= buy;
		notifyAll();
		System.out.printf("<%s>完成買貨中...%d, 目前庫存量: %d\n", who, buy, qty);
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
			try {
				store.add(5);
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}
class Consumer2 extends Thread {
	private Store2 store;
	private String name;
	
	public Consumer2(Store2 store, String name) {
		this.store = store;
		this.name = name;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			try {
				store.buy((int)(Math.random()*5)+1, name);
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}


