package tw.brad.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	private int ballX, ballY, dx, dy;
	private BufferedImage ballImg;
	private Timer timer;
	private int viewW, viewH;
	private int ballW, ballH;
	
	public MyPanel() {
		setBackground(Color.YELLOW);
		try {
			ballImg = ImageIO.read(new File("dir2/ball.png"));
			ballW = ballImg.getWidth();
			ballH = ballImg.getHeight();
		} catch (Exception e) {
			System.out.println(e);
		}
		ballX = ballY = 4;
		dx = dy = 8;
		timer = new Timer();
		timer.schedule(new MyTask(), 1*1000, 30);
	}
	
	class MyTask extends TimerTask {
		@Override
		public void run() {
			if (ballX <= 0 || ballX + ballW >= viewW) {
				dx *= -1;
			}
			if (ballY <= 0 || ballY + ballH >= viewH) {
				dy *= -1;
			}
			ballX += dx;
			ballY += dy;
			repaint();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		viewW = getWidth(); viewH = getHeight();
		
		g.drawImage(ballImg, ballX, ballY, null);
	}
	

}
