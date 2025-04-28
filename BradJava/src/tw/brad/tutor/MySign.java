package tw.brad.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.brad.apis.MyDrwaer;

public class MySign extends JFrame{
	private MyDrwaer myDrwaer;
	
	public MySign() {
		super("簽名App");
		setLayout(new BorderLayout());
		
		myDrwaer = new MyDrwaer();
		add(myDrwaer, BorderLayout.CENTER);
		
		
		setSize(800,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new MySign();
	}

}
