package tw.brad.apis;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

public class Line implements Serializable{
	private ArrayList<Point> points;
	private Color color;
	
	public Line(Color color) {
		points = new ArrayList<Point>();
		this.color = color;
	}
	public void addPoint(int x, int y) {
		Point p = new Point(x, y);
		points.add(p);
	}
	public Point getPoint(int index) {
		return points.get(index);
	}
	public int length() {
		return points.size();
	}
	public Color getColor() {
		return color;
	}
	
}
