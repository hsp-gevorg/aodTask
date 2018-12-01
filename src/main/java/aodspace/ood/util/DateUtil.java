package aodspace.ood.util;

import java.time.LocalDate;
import java.time.Period;

/**
 * The utility class that gives methods which belong to the date
 * 
 * @author Gevorg
 *
 */
public final class DateUtil {

	/**
	 * To have utility class
	 */
	private DateUtil() {
	}

	/**
	 * return different between two years
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long getYearsDifference(LocalDate startDate, LocalDate endDate) {
		// LocalDate start = LocalDate.of(2004, Month.DECEMBER, 25);
		// LocalDate end = LocalDate.of(2006, Month.JANUARY, 1);

		return Period.between(startDate, endDate).getYears();
	}
}
