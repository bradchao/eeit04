package tw.brad.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import tw.brad.apis.GiftTable;

public class MyGift extends JFrame{
	private GiftTable table;

	public MyGift() {
		super("Gift");
		
		setLayout(new BorderLayout());
		table = new GiftTable();
		JScrollPane jsp = new JScrollPane(table);
		add(jsp, BorderLayout.CENTER);
		
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyGift();
	}

}
