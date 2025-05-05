package tw.brad.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.brad.apis.MyPanel;

public class MyGame extends JFrame{
	private MyPanel myPanel;
	
	public MyGame() {
		setLayout(new BorderLayout());
		
		myPanel = new MyPanel();
		add(myPanel, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new MyGame();
	}

}
