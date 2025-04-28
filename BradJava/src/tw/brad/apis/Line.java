package tw.brad.apis;

import java.util.ArrayList;

public class Line {
	private ArrayList<Point> points;
	public Line() {
		points = new ArrayList<Point>();
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
	
}
