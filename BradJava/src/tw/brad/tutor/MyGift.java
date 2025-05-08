package tw.brad.tutor;

import javax.swing.JFrame;

public class MyGift extends JFrame{

	public MyGift() {
		super("Gift");
		
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyGift();
	}

}
