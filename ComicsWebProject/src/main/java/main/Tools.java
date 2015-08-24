package main;
/**This class is for convert the Date to SQL Date and convert the Date to Calendar
 * All methods are static so are accessible for any class
 * */
import java.sql.Date;
import java.util.Calendar;

public class Tools {

	public static Date convertDateToSql(java.util.Date utilDate) {
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}

	public static Calendar DateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

}
