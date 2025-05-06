package tw.brad.apis;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class MyClock extends JLabel {
	private Timer timer;
	private DateTimeFormatter formater;
	
	public MyClock() {
		formater = DateTimeFormatter.ofPattern("HH:mm:ss");		
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				LocalTime time = LocalTime.now();
				String strDatetime = time.format(formater);
				setText(strDatetime);	
			}
		}, 0, 100);
	}
	
}
