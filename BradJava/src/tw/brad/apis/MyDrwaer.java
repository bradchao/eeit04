package tw.brad.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MyDrwaer extends JPanel{
	private ArrayList<Point> line;
	
	
	public MyDrwaer() {
		setBackground(Color.YELLOW);
		
		line = new ArrayList<Point>();
		
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}
	
	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println(String.format("Press: %d x %d", e.getX(), e.getY()));
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			System.out.println(String.format("Drag: %d x %d", e.getX(), e.getY()));
		}
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setStroke(new BasicStroke(10));
		g2d.setColor(Color.RED);
		g2d.drawLine(0, 0, 200, 400);
		
		
	}
	
}
