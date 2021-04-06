import java.util.StringTokenizer;
import java.util.Calendar;

/**
 *A class that hold data for a date with methods to gain more information.
 *Also provides utility to check for valid dates(accounting for leap years and other parameters)
 *@author Abdullah Salem, Gent Blaku
 */
public class Date {
	private int year;
	private int month;
	private int day;
	private static final int MINYEAR = 1900;
	private static final int QUARTER  = 4, CENTURY = 100, QUADRICENTENNIAL = 400;
	private static final int MAXMONTH = 12, MINMONTH = 1;
	
	/**
	 * Creates a object of the Date Class
	 * @param date in a "mm/dd/yyyy" string format
	 */
	public Date(String date) {	//taking mm/dd/yyyy and create a Date object
		StringTokenizer tokenizer = new StringTokenizer(date, "/");
		this.month = Integer.parseInt(tokenizer.nextToken());
		this.day   = Integer.parseInt(tokenizer.nextToken());
		this.year  = Integer.parseInt(tokenizer.nextToken());	
		
	} 
	
	/**
	 * Creates a object of the Date Class that corresponds to today's date
	 */
	public Date() { 
		Calendar today = Calendar.getInstance();
		this.month = today.get(Calendar.MONTH);
		this.day   = today.get(Calendar.DATE);
		this.year  = today.get(Calendar.YEAR);
		
	} //create an object with today’s date (see Calendar class)
	
	
	/**
	 * A testbed main that goes through many different test inputs
	 * @param args is not used
	 */
	public static void main(String[] args) {
		boolean valid;
		
		//Invalid days
		System.out.println("Now testing Invalid days (should all be false):");
		
		System.out.println("Testing 1/40/2015...");
		Date date = new Date("1/40/2015");
		valid = date.isValid();
		
		if (!valid) {
			System.out.println("Test Case#1 is not valid (returned false). PASSED!");
		}
		else {
			System.out.println("Test Case#1 is not valid, but it returned true. FAILED!");
		}
		
		
		System.out.println("Testing 1/0/2015...");
		date = new Date("1/0/2015");
		valid = date.isValid();
		
		if (!valid) {
			System.out.println("Test Case#2 is not valid (returned false). PASSED!");
		}
		else {
			System.out.println("Test Case#2 is not valid, but it returned true. FAILED!");
		}
		
		
		//Invalid Months
		System.out.println("Now testing Invalid months (should all be false):");
		
		System.out.println("Testing 0/15/2015...");
		date = new Date("0/15/2015");
		valid = date.isValid();
		
		if (!valid) {
			System.out.println("Test Case#3 is not valid (returned false). PASSED!");
		}
		else {
			System.out.println("Test Case#3 is not valid, but it returned true. FAILED!");
		}
		
		System.out.println("Testing -1/15/2015...");
		date = new Date("-1/15/2015");
		valid = date.isValid();
		
		if (!valid) {
			System.out.println("Test Case#4 is not valid (returned false). PASSED!");
		}
		else {
			System.out.println("Test Case#4 is not valid, but it returned true. FAILED!");
		}
		
		
		System.out.println("Testing 13/15/2015...");
		date = new Date("13/15/2015");
		valid = date.isValid();
		
		if (!valid) {
			System.out.println("Test Case#5 is not valid (returned false). PASSED!");
		}
		else {
			System.out.println("Test Case#5 is not valid, but it returned true. FAILED!");
		}
		
		
		System.out.println("Testing 5/15/2021...");
		date = new Date("5/15/2021");
		valid = date.isValid();
		
		if (!valid) {
			System.out.println("Test Case#6 is not valid (returned false). PASSED!");
		}
		else {
			System.out.println("Test Case#6 is not valid, but it returned true. FAILED!");
		}
		
		
		//Invalid years
		System.out.println("Now testing Invalid years (should all be false):");
		System.out.println("Testing 3/15/2022...");
		date = new Date("3/15/2022");
		valid = date.isValid();
		
		if (!valid) {
			System.out.println("Test Case#7 is not valid (returned false). PASSED!");
		}
		else {
			System.out.println("Test Case#7 is not valid, but it returned true. FAILED!");
		}
		
		System.out.println("Testing 3/15/1899...");
		date = new Date("3/15/1899");
		valid = date.isValid();
		
		if (!valid) {
			System.out.println("Test Case#8 is not valid (returned false). PASSED!");
		}
		else {
			System.out.println("Test Case#8 is not valid, but it returned true. FAILED!");
		}
		
		
		System.out.println("Testing 3/15/-2020...");
		date = new Date("3/15/-2020");
		valid = date.isValid();
		
		if (!valid) {
			System.out.println("Test Case#9 is not valid (returned false). PASSED!");
		}
		else {
			System.out.println("Test Case#9 is not valid, but it returned true. FAILED!");
		}
		
		
		
		//Invalid days per Month (1 more than max)
		System.out.println("Now testing Invalid days per Month (should all be false):");
		System.out.println("Testing 3/32/2015...");
		date = new Date("3/32/2015");
		valid = date.isValid();
		
		if (!valid) {
			System.out.println("Test Case#10 is not valid (returned false). PASSED!");
		}
		else {
			System.out.println("Test Case#10 is not valid, but it returned true. FAILED!");
		}
		
		
		
		System.out.println("Testing 4/31/2015...");
		date = new Date("4/31/2015");
		valid = date.isValid();
		
		if (!valid) {
			System.out.println("Test Case#11 is not valid (returned false). PASSED!");
		}
		else {
			System.out.println("Test Case#11 is not valid, but it returned true. FAILED!");
		}
		
		
		
		System.out.println("Testing 2/30/2015...");
		date = new Date("2/30/2015");
		valid = date.isValid();
		
		if (!valid) {
			System.out.println("Test Case#12 is not valid (returned false). PASSED!");
		}
		else {
			System.out.println("Test Case#12 is not valid, but it returned true. FAILED!");
		}
		
		
		
		//Valid days per Month
		System.out.println("Now testing VALID days per month (should all be true):");
		System.out.println("Testing 3/31/2015...");
		date = new Date("3/31/2015");
		valid = date.isValid();
		 
		if (valid) {
			System.out.println("Test Case#13 is valid and it returned true. PASSED!");
		} 
		else {
			System.out.println("Test Case#13 is valid, (returned false). FAILED!");
		}
		
		
		
		System.out.println("Testing 4/30/2015...");
		date = new Date("4/30/2015");
		valid = date.isValid();
		
		 
		if (valid) {
			System.out.println("Test Case#14 is valid and it returned true. PASSED!");
		} 
		else {
			System.out.println("Test Case#14 is valid, (returned false). FAILED!");
		}
		
		
		System.out.println("Testing 2/28/2015...");
		date = new Date("2/28/2015");
		valid = date.isValid();
		
		 
		if (valid) {
			System.out.println("Test Case#15 is valid and it returned true. PASSED!");
		} 
		else {
			System.out.println("Test Case#15 is valid, (returned false). FAILED!");
		}
		
		
		//Day after today 
		System.out.println("Now Testing the day after today. Should return false:");
		Date tomorrow = new Date();
		tomorrow.day++;
		
		valid = tomorrow.isValid();
		if (!valid) {
			System.out.println("Test Case#16 is not valid (returned false). PASSED!");
		}
		else {
			System.out.println("Test Case#16 is not valid, but it returned true. FAILED!");
		}
		
		
		//Today
		System.out.println("Now testing today. Should return true:");
		Date today = new Date();
		valid = today.isValid();
		
		if (!valid) {
			System.out.println("Test Case#17 is valid (returned false). FAILED!");
		}
		else {
			System.out.println("Test Case#17 is valid, and it returned true. PASSED!");
		}
		
		
		
		//Leap Year 
		System.out.println("Now testing leap year. should return true:");
		System.out.println("Now testing 2/29/2008...");
		Date leapYear = new Date("2/29/2008");
		valid = leapYear.isValid();
		if (!valid) {
			System.out.println("Test Case#18 is valid (returned false). FAILED!");
		}
		else {
			System.out.println("Test Case#18 is valid, and it returned true. PASSED!");
		}
		
		
		//Not a leap year
		System.out.println("Now testing a normal year. should return false:");
		System.out.println("Now testing 2/29/2009...");
		Date notLeapYear = new Date("2/29/2009");
		valid = notLeapYear.isValid();
		if (!valid) {
			System.out.println("Test Case#19 is not valid (returned false). PASSED!");
		}
		else {
			System.out.println("Test Case#19 is not valid, and it returned true. FAILED!");
		}
	}
	
	
	
	
	
	
	
	/**
	 * A helper method to verify if a year was a leap year
	 * @param bookYear to be checked
	 * @return true if it is a leapyear, false if not
	 */
	private boolean checkForLeapYear(int bookYear) {
		if (bookYear % QUARTER == 0 ) {
			if(bookYear % CENTURY == 0) {
				if (bookYear % QUADRICENTENNIAL == 0) {
					return true;
				}
				else {
					return false;
				}
			}
			else { 
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * A method that checks if the date object has a valid date/
	 * A valid date is one that is both possible, not in the future, and not in the distant past.
	 * @return true if the date is valid, false if it is not
	 */
	public boolean isValid() { 
		if (this.day < 1) {
			return false;
		}
		
		
		if (this.year < MINYEAR) {
			return false;		
		}
		
		if (this.month > MAXMONTH) {
			return false;
		}
		else if (this.month<MINMONTH) {
			return false;
		}
		
		Date today = new Date();
		if (this.year > today.year) {
			return false;
		}
		else if (this.year == today.year) {
			if (this.month > today.month ) {
				return false;
			}
			else if (this.month == today.month) {
				if (this.day > today.day) {
					return false;
				}
			}
		}
		
		if (this.month == Months.JANUARY) {
			if (this.day > Months.MaxDaysPerMonth(Months.JANUARY)) {
				return false;
			}
		}
		
		else if (this.month == Months.FEBRUARY) {
			
			boolean leapYearCheck = checkForLeapYear(this.year);
			if (this.day > Months.MaxDaysPerMonth(Months.FEBRUARY, leapYearCheck)) {
				return false;
			}
		}
		else if (this.month == Months.MARCH) {
			if (this.day > Months.MaxDaysPerMonth(Months.MARCH)) {
				return false;
			}
		}
		else if (this.month == Months.APRIL) {
			if (this.day > Months.MaxDaysPerMonth(Months.APRIL)) {
				return false;
			}
		}
		else if (this.month == Months.MAY) {
			if (this.day > Months.MaxDaysPerMonth(Months.MAY)) {
				return false;
			}
		}
		else if (this.month == Months.JUNE) {
			if (this.day > Months.MaxDaysPerMonth(Months.JUNE)) {
				return false;
			}
		}
		else if (this.month == Months.JULY) {
			if (this.day > Months.MaxDaysPerMonth(Months.JULY)) {
				return false;
			}
		}
		else if (this.month == Months.AUGUST) {
			if (this.day > Months.MaxDaysPerMonth(Months.AUGUST)) {
				return false;
			}
		}
		else if (this.month == Months.SEPTEMBER) {
			if (this.day > Months.MaxDaysPerMonth(Months.SEPTEMBER)) {
				return false;
			}
			
		}
		else if (this.month == Months.OCTOBER) {
			if (this.day > Months.MaxDaysPerMonth(Months.OCTOBER)) {
				return false;
			}
		}
		else if (this.month == Months.NOVEMBER) {
			if (this.day > Months.MaxDaysPerMonth(Months.NOVEMBER)) {
				return false;
			}
		}
		else if (this.month == Months.DECEMBER) {
			if (this.day > Months.MaxDaysPerMonth(Months.DECEMBER)) {
				return false;
			}
		}
		return true;
	}
	
	
	
	/**
	 * A method that checks if the date of the object is chronologically before the date of the other object.
	 * @param other is the object of the date class to be measure against
	 * @return true if this object is older, false if it is younger
	 */
	public boolean isOlderThan(Date other) {
		if (this.year > other.year) {
			return false;
		}
		else if (this.year == other.year) {
			if (this.month > other.month ) {
				return false;
			}
			else if (this.month == other.month) {
				if (this.day > other.day) {
					return false;
				}
			}
		}
		if (this.equals(other)) {
			return false;
		}
		return true;
	}

	

	
	
	
	
	/**
	 * Overriding the equals method inherited from the object class.
	 * Compares if this object is equal to another object based on certain criteria.
	 * @param obj is an object that is being compared to this object
	 * @return true if this object is equal to the other object, false if not equal to
	 */
	@Override
	public boolean equals(Object obj){
		if (obj == null) {
			return false;
		}
		else if (obj instanceof Date){
			Date other = (Date)obj;
			if (this.day == other.day && this.month == other.month && this.year == other.year)
				return true;
		}
		return false;
	}
	
	/**
	 * Overriding the toString method of inherited from the object class.
	 * @returns a string representing this object
	 */
	@Override
	public String toString() {
		return String.valueOf(this.month) + "/" + String.valueOf(this.day) + "/" + String.valueOf(this.year);
	}
	
	
	
	
}
