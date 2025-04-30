package tw.brad.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyDrwaer extends JPanel{
	private ArrayList<Line> lines, recycle;
	private Color defaultColor;
	
	public MyDrwaer() {
		setBackground(Color.YELLOW);
		
		defaultColor = Color.BLUE;
		lines = new ArrayList<Line>();
		recycle = new ArrayList<Line>();
		
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}
	
	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			Line line = new Line(defaultColor);
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
		
		for (Line line : lines) {
			g2d.setColor(line.getColor());
			for (int i = 1; i < line.length(); i++) {
				Point p1 = line.getPoint(i-1);
				Point p2 = line.getPoint(i);
				g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
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
	
	public void saveObj(File saveFile) throws Exception {
		ObjectOutputStream oout = 
			new ObjectOutputStream(
				new FileOutputStream(saveFile));
		oout.writeObject(lines);
		oout.flush();
		oout.close();
	}
	
	public void loadObj(File loadFile) throws Exception {
		ObjectInputStream oin = 
			new ObjectInputStream(
				new FileInputStream(loadFile));
		lines = (ArrayList<Line>)oin.readObject();
		oin.close();
		
		recycle.clear();
		repaint();
	}
	
	public boolean saveJPEG() throws Exception{
		BufferedImage img = 
			new BufferedImage(
					getWidth(), 
					getHeight(), 
					BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		paint(g2d);
		
		try {
			return ImageIO.write(img, "jpg", new File("dir2/brad.jpg"));
		} catch (IOException e) {
			throw new Exception();
		}
		
		
	}
	
	
}
