/**
 * A class that holds relevant information regarding the months of the gregorian calender.
 * @author Abdullah Salem, Gent Blaku
 */
public class Months {

	public static final int JANUARY =1 ;
	public static final int FEBRUARY=2 ;
	public static final int MARCH= 3;
	public static final int APRIL= 4;
	public static final int MAY= 5;
	public static final int JUNE= 6;
	public static final int JULY= 7;
	public static final int AUGUST= 8;
	public static final int SEPTEMBER= 9;
	public static final int OCTOBER= 10;
	public static final int NOVEMBER= 11;
	public static final int DECEMBER= 12;
	public static final int NOTFOUND = -1;
	
	/**
	 * A function that fetches the maximum possible days of any given month.
	 * @param month is the number representing the order of the months.
	 * @param isLeapYear is a boolean to account for a leap year
	 * @return an integer holding the maximum possible days of the given month
	 */
	public static int MaxDaysPerMonth(int month, boolean isLeapYear) {
		switch(month) {
			case (JANUARY):
				return 31;
			case (FEBRUARY):
				if (isLeapYear) { 
					return 29;
				}
				else	
					return 28;
			case (MARCH):
				return 31;
			case (APRIL):
				return 30;
			case (MAY):
				return 31;
			case (JUNE):
				return 30;
			case (JULY):
				return 31;
			case (AUGUST):
				return 31;
			case (SEPTEMBER):
				return 30;
			case (OCTOBER):
				return 31;
			case (NOVEMBER):
				return 30;
			case (DECEMBER):
				return 31;
		}
		return NOTFOUND;
	}
	
	/**
	 * A function that fetches the maximum possible days of any given month.
	 * @param month is the number representing the order of the months.
	 * @return an integer holding the maximum possible days of the given month
	 */
	public static int MaxDaysPerMonth(int month) {
		return MaxDaysPerMonth(month, false);
	}
	
	
}
