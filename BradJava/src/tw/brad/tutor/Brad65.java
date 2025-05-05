package tw.brad.tutor;

import java.util.Timer;
import java.util.TimerTask;

public class Brad65 {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new Brad651(), 0, 1*1000);
		timer.schedule(new StopTask(timer), 10*1000);
		System.out.println("main finish");
	}
}
class Brad651 extends TimerTask {
	private int i;
	@Override
	public void run() {
		System.out.println(i++);
	}
}
class StopTask extends TimerTask {
	private Timer timer;
	public StopTask(Timer timer) {
		this.timer = timer;
	}
	@Override
	public void run() {
		timer.cancel();
		timer.purge();
		timer = null;
	}
}
