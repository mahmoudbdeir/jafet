package cmps252.oopreview;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Program {

	public static void main(String[] args) {
		System.out.println("Hello, world!");

		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date currentDatePlusOne = c.getTime();
        System.out.println(String.format("Today is %s\n\tand tomorrow is %s", currentDate, currentDatePlusOne));
        
        
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(String.format("Today is %s\n\tand tomorrow is %s", localDateTime, localDateTime.plusDays(1)));
	}
}