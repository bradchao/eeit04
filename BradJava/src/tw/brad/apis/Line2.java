package tw.brad.apis;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

public class Line2 {
	private ArrayList<HashMap<String, Integer>> points;
	private Color color;
	
	public Line2(Color color) {
		points = new ArrayList<>();
		this.color = color;
	}
	public void addPoint(int x, int y) {
		HashMap<String, Integer> p = new HashMap<>();
		p.put("x", x);p.put("y", y);
		points.add(p);
	}
	public HashMap<String, Integer> getPoint(int index) {
		return points.get(index);
	}
	public int length() {
		return points.size();
	}
	public Color getColor() {
		return color;
	}
	
}
