package tw.brad.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.brad.apis.GiftTable;

public class MyGift extends JFrame{
	private GiftTable table;

	public MyGift() {
		super("Gift");
		
		setLayout(new BorderLayout());
		table = new GiftTable();
		add(table, BorderLayout.CENTER);
		
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyGift();
	}

}
