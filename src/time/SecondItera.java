package time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SecondItera {
	public static void main(String[] args) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = df.parse("2015-04-29 00:00:00");
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(d);
		long base = new GregorianCalendar(calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH), 0, 0, 0).getTime().getTime();
		for (int t = 0; t < 60 * 60 * 12 * 2; t=t+15) {
			int locHourHand = Math.round((t % (60 * 60 * 12)) / (60 * 12));
			int locMinuteHand = Math.round((t % (60 * 60)) / 60);
			int locSecondHand = t % 60;
			Date date = new Date(base + t * 1000);
			System.out.println(df.format(date));
		}
	}
}
