package tw.brad.tutor;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Brad31 extends JFrame implements ActionListener{
	private JButton b1, b2, b3;
	
	public Brad31() {
		b1 = new JButton("B1");
		b2 = new JButton("B2");
		b3 = new JButton("B3");
		setLayout(new FlowLayout());
		
		add(b1);add(b2);add(b3);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEvent();
	}
	
	private void initEvent() {
		//MyListener myListener = new MyListener(); 
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Brad31();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			System.out.println("B1");
		}else if (e.getSource() == b2) {
			System.out.println("B2");
		}else if (e.getSource() == b3) {
			System.out.println("B3");
		}
	}
}

class MyListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		
//		if (e.getSource() == b1) {
//			System.out.println("B1");
//		}else if (e.getSource() == b2) {
//			System.out.println("B2");
//		}else if (e.getSource() == b3) {
//			System.out.println("B3");
//		}		
		
	}
	
}




