package tw.brad.tutor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Brad68 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime datetime = LocalDateTime.now();
		
		System.out.println(date);
		System.out.println(time);
		System.out.println(datetime);
		
		DateTimeFormatter formater = 
			DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String strDatetime = datetime.format(formater);
		System.out.println(strDatetime);
		
		//---------------------
		String input = "1999-01-02 10:20:30";
		LocalDateTime dd = LocalDateTime.parse(input, formater);
		System.out.println(dd);
		//--------
		LocalDate nndate = date.plusWeeks(4);
		System.out.println(nndate);
		LocalDate lmonth = date.minusMonths(6);
		System.out.println(lmonth);
		//------------
		LocalDate birthday = LocalDate.of(1966, 2, 5);
		Period pp = Period.between(birthday, date);
		System.out.printf("%d 年 %d 個月又 %d 天",
			pp.getYears(), pp.getMonths(), pp.getDays());
		//-----
		
		
		
		
		
		
		
		
		
	}
}
