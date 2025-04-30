package tw.brad.apis;

public class Scooter extends Bike{
	public Scooter() {
		// super();
		super(2);
		System.out.println("Scooter()");
	}
	public Scooter upSpeed() {
		speed = speed < 1 ? 2 : speed *1.8;
		return this;
	}
}
