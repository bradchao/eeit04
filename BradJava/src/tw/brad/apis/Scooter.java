package tw.brad.apis;

public class Scooter extends Bike{
	public Scooter() {
		System.out.println("Scooter()");
	}
	public void upSpeed() {
		speed = speed < 1 ? 2 : speed *1.8;
	}
}
