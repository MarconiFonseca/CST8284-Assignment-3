package company;
import java.util.InputMismatchException;

/**Employee.java
 * Class Company: abstracts a company
 * @author Marconi Fonseca CST8284
 * Assignment 2: Company Management Tool prototype
 *  March 31 2019
 */

public abstract class Employee implements java.io.Serializable {
	
	/** private fields to hold relevant Employee information
	 * 
	 */
    private String name;         // Employee's full name
    private int employeeNumber;  // Employee's work number
    private OurDate startDate;   // Employee's first day of work
    private double salary;       // Employee's current salary
    public static final long   serialVersionUID = 1L;
    
    /** default constructor; uses values that clearly indicate default conditions;
     *  chained to (String, int, OurDate, double) Employee constructor below
     */  
    public Employee() { this("unknown", -9, new OurDate(), -1);  }
	
    /**
     *load constructor using Employee's full name, work number, start date and salary
     * @param name
	 * @param employeeNumber
	 * @param startDate
	 * @param salary
	 */
    
    public Employee(String name, int employeeNumber, OurDate startDate, double salary) {
		setName(name);
		setEmployeeNumber(employeeNumber);
		setStartDate(startDate);
		setSalary(salary);
	}
    
    /**
	 * abstract method to be overridden in subclass for loading classes info
	 * @return void
	 */
	public abstract void loadExtraInfo();
	
    /** return's the Employee's full name as a String
     * @return String
     */
	public String getName() { return name;  }
	
	/** return's the Employee number, as an int
	 * @return int
	  */
	public int getEmployeeNumber() {  return employeeNumber;  }
	
	/** return's the Employee's starting date, as an OurDate object
	 * @return OurDate
	 */
	public OurDate getStartDate() {  return startDate;  }
	/**
	* return's the Employee's salary, as a double
	*@return double
	*/

	public double getSalary() {  return salary; }
	
	/**
	 * @param name
	 * @return void
	 * @param employeeNumber
	 * @param startDate
	 * @param salary
     * must be set through the class constructor only
     */
	private void setName(String name) {  this.name = name;  }
	private void setEmployeeNumber(int employeeNumber) {  this.employeeNumber = employeeNumber;  }
	private void setStartDate(OurDate startDate) {  this.startDate = startDate;  }
	private void setSalary(double salary) {  this.salary = salary;  }

	/** Display employee information to the console
	 * @return String
	 */

	@Override
	public String toString() {
		return  getName() + "\t\t" + getEmployeeNumber() + "\t\t" + getStartDate() + "\t" + getSalary();
					
	}
	

	/**
	 *  checks to see if an obj is equal to another obj of this class
	 *  @return boolean
	 *  @param obj
	 */
	@Override	
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass())) return false;
		Employee other = (Employee) obj;		
		return (this.getName().equals(other.getName()) && 
				this.getEmployeeNumber() == other.getEmployeeNumber() && 
				this.getStartDate().equals(other.getStartDate())); 
	}//END EQUALS METHOD 
	
	/**
	 * Passes a String value to check if that string contains character values
	 * Checks to see if name parameter has a digit in it
	 * @throws InputMismatchException
	 * @param name
	 * @return boolean
	 */
	public boolean isInputNameCorrect(String name) {

		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (Character.isDigit(c)) {
				throw new InputMismatchException("Cannot enter a Numeric value into the name");
			} //loops through name, if digit is found - throw InputMismatchException
		}
		return true;
	}
	
	/**
	 * Passes an int parameter to check if that int contains any character values
	 * Checks to see if num parameter has a char in it
	 * @param num
	 * @return boolean
	 * @throws InputMismatchException
	 */
	public boolean isDigit(int num) {
		String str = Integer.toString(num);
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!(Character.isDigit(c))) {
				throw new InputMismatchException("Cannot enter a character into a numeric value");
			} ////loops through num, if digit is found - throw InputMismatchException
		}
		return true;
	}

	public void loadExraInfo() {
		// TODO Auto-generated method stub
		
	}



}//END CLASS EMPLOYEE

