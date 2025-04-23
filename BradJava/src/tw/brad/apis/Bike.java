package tw.brad.apis;

public class Bike{
	protected double speed;
	
	public Bike() {
		// super();
		System.out.println("Bike()");
	}
	public Bike(int a) {
		System.out.println(String.format("Bike(%d)", a));
	}
	
	public void upSpeed() {
		speed = speed < 1 ? 1 : speed*1.4;
	}
	public void downSpeed() {
		speed = speed < 1? 0 : speed * 0.7;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	@Override
	public String toString() {
		return "Bike Speed = " + speed;
	}
	
}
