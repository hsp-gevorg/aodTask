package aodspace.ood.util;

/**
 * The utility class that gives methods which belong to the math
 * 
 * @author Gevorg
 *
 */
public final class MathUtil {

	/**
	 * To have utility class
	 */
	private MathUtil() {
	}

	/**
	 * method for calculate percent
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static double calculatePercent(double number, double percent) {
		return number * percent / 100;
	}

	/**
	 * Round double with precision
	 * 
	 * @param number
	 * @param precision
	 * @return
	 */
	public static double round(double number) {
		return Math.round(number * 100) / 100.0;
	}
}
