package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class GuessNumber extends JFrame{
	private JTextField input;
	private JButton guess;
	//private JTextArea log;
	private JTextPane log;
	private String answer;
	private int i;
	
	public GuessNumber() {
		super("猜數字遊戲");
		
		input = new JTextField();
		input.setFont(new Font(null, Font.BOLD | Font.ITALIC, 24));
		
		guess = new JButton("猜");
		//log = new JTextArea();
		log = new JTextPane();
		
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new BorderLayout());
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);
		
		add(top, BorderLayout.NORTH);
		add(log, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEvent();
		initGame();
	}
	
	private void initEvent() {
		guess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guessV2();
			}
		});
	}
	
//	private void guess() {
//		i++;
//		String inputText = input.getText();
//		String result = checkAB(inputText);
//		log.append(String.format("%s => %s\n", inputText, result ));
//		input.setText("");
//		
//		if (result.equals("3A0B")) {
//			JOptionPane.showMessageDialog(null,"WINNER");
//		}else if (i == 3) {
//			JOptionPane.showMessageDialog(null,"LOSER:" + answer);
//		}
//	}

	private void guessV2() {
		i++;
		String inputText = input.getText();
		String result = checkAB(inputText);
		
		StyledDocument style = log.getStyledDocument();
		
		Style style1 = style.addStyle("style1", null);
		StyleConstants.setForeground(style1, Color.RED);
		
		Style style2 = style.addStyle("style2", null);
		StyleConstants.setForeground(style2, Color.BLACK);
		
		Style style3 = style.addStyle("style3", null);
		StyleConstants.setForeground(style3, Color.BLUE);
		
		try {
			style.insertString(style.getLength(), inputText, style1);
			style.insertString(style.getLength(), " => ", style2);
			style.insertString(style.getLength(), result + "\n", style3);
		}catch(Exception e) {
			
		}
		
		
		
		input.setText("");
		
		if (result.equals("3A0B")) {
			JOptionPane.showMessageDialog(null,"WINNER");
		}else if (i == 3) {
			JOptionPane.showMessageDialog(null,"LOSER:" + answer);
		}
	}
	
	private void initGame() {
		answer = createAnswer(3);
		i = 0;
		System.out.println(answer);
	}
	
	private String checkAB(String g) {
		int A = 0, B = 0;
		for (int i=0; i<answer.length(); i++) {
			if (answer.charAt(i) == g.charAt(i)) {
				A++;
			}else if(answer.indexOf(g.charAt(i)) != -1) {
				B++;
			}
		}
		return String.format("%dA%dB", A,B);
	}
	
	private static String createAnswer(int d) {
		int nums = 10;
		int[] poker = new int[nums];
		for (int i=0; i<poker.length; i++) poker[i] = i;
		
		// 2.
		for (int i=nums-1; i>0 ;i--) {
			int rindex = (int)(Math.random()*(i+1));
			
			int temp = poker[rindex];
			poker[rindex] = poker[i];
			poker[i] = temp;
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<d; i++)sb.append(poker[i]);
		
		return sb.toString();
	}

	public static void main(String[] args) {
		new GuessNumber();
	}

}
