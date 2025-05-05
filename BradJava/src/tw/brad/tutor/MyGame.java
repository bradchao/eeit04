package tw.brad.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.brad.apis.MyPanel;
import tw.brad.apis.MyPanel2;

public class MyGame extends JFrame{
	private MyPanel2 myPanel;
	
	public MyGame() {
		setLayout(new BorderLayout());
		
		myPanel = new MyPanel2();
		add(myPanel, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new MyGame();
	}

}
