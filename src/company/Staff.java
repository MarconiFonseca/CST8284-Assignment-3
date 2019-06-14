package company;

import java.util.Scanner;

/**
 * Class Company: abstracts a company
 * @author Marconi Fonseca CST8284
 * Assignment 2: Company Management Tool prototype
 *  March 31 2019
 */

public class Staff extends Employee {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String department;
	private Scanner in = new Scanner(System.in);


	/** default constructor; uses values that clearly indicate default conditions;
	 * 
	 */

	public Staff() {
		this("unknown", -9, new OurDate(), -1, "Clerk");

	}	
	
	 /** load constructor using super (name, employee number, start date and salary)
	  * 
	  * @param name
	  * @param employeeNumber
	  * @param startDate
	  * @param salary
	  * @param department
	  */
	
	public Staff (String name, int employeeNumber , OurDate startDate, double salary, String department){
		super(name, employeeNumber, startDate,salary);
		if (department.equals("")) {
			loadExraInfo();
		} else {
			this.setdepartment(department);
		}
	}
	/**  getter in this class
	 * 
	 * @return
	 */

	public String getDepartment() {
		return department;
		
	}
	
	/**setters in this class 
	 * 
	 * @param department
	 */

	public void setdepartment(String department) {
		this.department = department;
	}
	
	/** loadExraInfo(). This method overrides in the abstract Employee class.
	 * 
	 */

	@Override
	public void loadExraInfo() {

		System.out.print("Enter the Staff's Department: ");
		department = in.nextLine();
		setdepartment(department);
	
		
	}
	
	/** formats employee info
	 * 
	 */
		@Override
		public String toString() {
			return getName() + "\t\t" + getEmployeeNumber() + " \t\t" + getStartDate() + "\t " + getSalary() + "\t"
					+ "Title: "+ getDepartment();
		}
		
		/** Compare two employees for equality by comparing their relevant properties
		 * 
		 */
		@Override

		public boolean equals(Object obj) {
			if ((obj == null) || (this.getClass() != obj.getClass())) 
				return false;
			Staff newStaff = (Staff) obj;		
			return (this.getName().equals(newStaff.getName()) && 
					this.getEmployeeNumber() == newStaff.getEmployeeNumber() && 
					this.getStartDate().equals(newStaff.getStartDate())&&
					this.getSalary()==(newStaff.getSalary())&&	
					this.getDepartment()==newStaff.getDepartment()); 
					
		}//END EQUALS METHOD

		@Override
		public void loadExtraInfo() {
			// TODO Auto-generated method stub
			
		}
		}





