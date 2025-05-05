package tw.brad.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel2 extends JPanel{
	private BufferedImage[] ballImgs;
	private Timer timer;
	private int viewW, viewH;
	private LinkedList<BallTask> balls;
	
	public MyPanel2() {
		setBackground(Color.GREEN);
		ballImgs = new BufferedImage[3];
		try {
			ballImgs[0] = ImageIO.read(new File("dir2/ball.png"));
			ballImgs[1] = ImageIO.read(new File("dir2/ball1.png"));
			ballImgs[2] = ImageIO.read(new File("dir2/ball2.png"));
		} catch (Exception e) {
			System.out.println(e);
		}
		
		balls = new LinkedList<>();
		
		timer = new Timer();
		timer.schedule(new RefreshView(), 0, 16);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				newBall(e.getX(), e.getY());
			}
		});
	}
	
	private void newBall(int x, int y) {
		BallTask ball = new BallTask(x, y, 
			(int)(Math.random()*9-4), (int)(Math.random()*9-4));
		balls.add(ball);
		timer.schedule(ball, 500, 20);
	}
	

	private class BallTask extends TimerTask{
		private int ballX, ballY, dx, dy;
		private int ballW, ballH;
		private int imgIndex;
		
		public BallTask(int ballX, int ballY, int dx, int dy) {
			this.ballX = ballX; this.ballY = ballY;
			this.dx = dx; this.dy = dy;
			imgIndex = (int)(Math.random()*3);
			ballW = ballImgs[imgIndex].getWidth();
			ballH = ballImgs[imgIndex].getHeight();
		}
		
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
		}
	}
	
	private class RefreshView extends TimerTask{
		@Override
		public void run() {
			repaint();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth(); viewH = getHeight();
		
		for (BallTask ball : balls) {
			g.drawImage(ballImgs[ball.imgIndex], ball.ballX, ball.ballY, null);
		}
		
	}
	

}
