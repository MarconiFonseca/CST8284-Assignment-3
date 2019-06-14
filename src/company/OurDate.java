package company;
import java.util.Calendar;  // Note: OurDate wraps Calendar
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
/**
 * Class Company: abstracts a company
 * @author Marconi Fonseca CST8284
 * Assignment 2: Company Management Tool prototype
 *  March 31 2019
 */

public class OurDate {

	// private fields for day, month, year
	private int day;
	private int month;
	private int year;
	
	/** each OurDate object wraps a Calendar object; Calendar's functionality can then
	/be used for initialization, comparison, etc.
	 * 
	 */
	private static final Calendar CALENDAR = Calendar.getInstance();
  
    /** initialization of OurDate default constructor uses today's day, month, 
	*and year, as returned by the Calendar object's methods.  (See, for example,
	* https://www.geeksforgeeks.org/calendar-class-in-java-with-examples/)
 	*This constructor is chained to the (int day, int month, int year) constructor below.  
	* Note that the months are 1-based, not 0-based.  Hence January = 1, 
	*February = 2, etc. 
	*/
	 
	 
    public OurDate() { this(CALENDAR.get(Calendar.DATE), 
		   CALENDAR.get(Calendar.MONTH + 1), 
		   CALENDAR.get(Calendar.YEAR) ); }
	
    /** base constructor.  Note input format: day, month, year, NOT year, month, day
     * as used in Calendar constructor 
	 * @param month
	 * @param year
	 */
	public OurDate(int day, int month, int year) {	
		setDay(day);
		setMonth(month);
		setYear(year);	
	}
	
	/** private setter for day of month
	 * @return void
	 *  @param day
	 */
	
	private void setDay(int day) {  this.day = day;  }
	
	/** private setter for month
	 * 
	 * @param month
	 */
	private void setMonth(int month) {  this.month = month;  }
	
	/** private setter for year
	 * 
	 * @param year
	 */
	private void setYear(int year) {  this.year = year;  }
	
	/**returns the day of the month
	 * 
	 * @return
	 */
	public int getDay() {  return day; }
	
	/** returns the month as an int, where January = 1, February = 2, etc.
	 * 
	 * @return
	 */
	public int getMonth() {  return month; }
	
	/**returns the year
	 * 
	 * @return
	 */
	public int getYear() {  return year;  }

	/**prints date to console in day/month/year format
	 * @return String
	 * @Override
	 */
	@Override
	public String toString() {  return this.day +"/" +this.month + "/" + this.year; }

	/** compares two OurDate objects for equality
	 * @Override
	 */
	@Override
	public boolean equals(Object obj) {

		if ((obj == null) || (this.getClass() != obj.getClass())) return false;
		OurDate other = (OurDate) obj;
	    return (this.getDay() == other.getDay() && 
	    		this.getMonth() == other.getMonth() && 
	    		this.getYear() == other.getYear() ) ; 
			
	}//END EQUALS METHOD
	
	/**
	 * Passes a string. Parses that string, and checks to see if it's impossible.
	 * @param s
	 * @return boolean
	 * @throw InputMismatchException

	 */
	
	public boolean setOurDate(String s) {
		boolean result = true;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		try {
			String[] dmy = s.split("/");
			setYear(Integer.parseInt(dmy[2]));
			setMonth(Integer.parseInt(dmy[1]));
			setDay(Integer.parseInt(dmy[0]));
			CALENDAR.setTime(dateFormat.parse(s));  // use calendar to check for impossible dates
			return result;
		} catch (NumberFormatException g) {
			throw new InputMismatchException("Bad input value; date " + s + " contains non-numeric value");
		} catch (IllegalArgumentException f) {
			throw new InputMismatchException("Bad data type passed to an internal method");
		}  catch (ParseException h) {
			throw new InputMismatchException("Date " + s + " not possible");
		} catch (RuntimeException e) {
			throw new InputMismatchException("General Runtime exception thrown setting start date");
		} 
	}
	
}//END CLASS EMPLOYEE
