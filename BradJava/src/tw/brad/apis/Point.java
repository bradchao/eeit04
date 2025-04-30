package tw.brad.apis;

import java.io.Serializable;

public class Point implements Serializable{
	public int x, y;
	public Point(int x, int y) {
		this.x = x; this.y = y;
	}
}
