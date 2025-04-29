package tw.brad.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

public class MyDrwaer2 extends JPanel{
	private ArrayList<Line2> lines, recycle;
	private Color defaultColor;
	
	public MyDrwaer2() {
		setBackground(Color.YELLOW);
		
		defaultColor = Color.BLUE;
		lines = new ArrayList<>();
		recycle = new ArrayList<>();
		
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}
	
	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			Line2 line = new Line2(defaultColor);
			line.addPoint(e.getX(), e.getY());
			lines.add(line);
			recycle.clear();
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			lines.getLast().addPoint(e.getX(), e.getY());
			repaint();
		}
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(4));
		
		for (Line2 line : lines) {
			g2d.setColor(line.getColor());
			for (int i = 1; i < line.length(); i++) {
				HashMap<String , Integer> p1 = line.getPoint(i-1);
				HashMap<String , Integer> p2 = line.getPoint(i);
				g2d.drawLine(p1.get("x"), p1.get("y"), 
						p2.get("x"), p2.get("y"));
			}			
		}
	}
	
	public void clear() {
		lines.clear();
		recycle.clear();
		repaint();
	}
	
	public void undo() {
		if (lines.size()>0) {
			recycle.add(lines.removeLast()) ;
			repaint();
		}
	}

	public void redo() {
		if (recycle.size()>0) {
			lines.add(recycle.removeLast());
			repaint();
		}
	}
	
	public Color getDefaultColor() {
		return defaultColor;
	}

	public void setDefaultColor(Color newColor) {
		defaultColor = newColor;
	}
	
}
