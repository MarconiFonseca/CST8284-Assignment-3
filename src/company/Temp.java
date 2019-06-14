package company;

import java.util.Scanner;

/**
 * Class Company: abstracts a company
 * @author Marconi Fonseca CST8284
 * Assignment 2: Company Management Tool prototype
 *  March 31 2019
 */

public class Temp extends Employee {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OurDate endContractDate; // private fields 
	private Scanner in = new Scanner(System.in);


	/** default constructor; uses values that clearly indicate default conditions;
	 * 
	 */
    
	public Temp() {
		setEndContractDate(new OurDate(01, 01,1900));
	}
    /** load constructor using super (name, employee number, start date and salary)
     * 
     * @param name
     * @param employeeNumber
     * @param startDate
     * @param salary
     * @param endContractDate
     */

	public Temp(String name, int employeeNumber, OurDate startDate, double salary, OurDate endContractDate) {
		super(name, employeeNumber, startDate, salary);
		this.endContractDate = endContractDate;
		
	}
	
	/**  getter in this class
	 * 
	 * @return
	 */

	public OurDate getEndContractDate() {
		return endContractDate;
	}

	/**setters in this class 
	 * 
	 * @param endContractDate
	 */
		public void setEndContractDate(OurDate endContractDate) {

			this.endContractDate = endContractDate;
		}

		public void setEndContractDate(int day, int month, int year) {

			this.endContractDate = new OurDate(day, month, year);

		}

		/** loadExraInfo(). This method overrides in the abstract Employee class.
		 * 
		 */
		
	@Override
	public void loadExraInfo() {


		System.out.println("END CONTRACT DATE");
		System.out.print("YEAR: ");
		int year = in.nextInt();

		System.out.print("MONTH: ");
		int month = in.nextInt();

		System.out.print("DAY: ");
		int day = in.nextInt();

		setEndContractDate(day, month, year);

	}

	/** formats Temp info
	 * 
	 */
	@Override
	public String toString() {
		return getName() + "\t\t" + getEmployeeNumber() + " \t\t" + getStartDate() + "\t " + getSalary() + "\t"
				+ "End of Contract: " + getEndContractDate();
	}

	/** Compare two employees for equality by comparing their relevant properties
	 * 
	 */
	@Override

	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass())) 
			return false;
		Temp newTemp = (Temp) obj;		
		return (this.getName().equals(newTemp.getName()) && 
				this.getEmployeeNumber() == newTemp.getEmployeeNumber() && 
				this.getStartDate().equals(newTemp.getStartDate())&&
				this.getSalary()==(newTemp.getSalary())&&				
				this.getEndContractDate()==newTemp.getEndContractDate());
				
	}//END EQUALS METHOD

	@Override
	public void loadExtraInfo() {
		// TODO Auto-generated method stub
		
	}
	}
	

