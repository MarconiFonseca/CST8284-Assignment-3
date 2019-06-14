package company;

import java.util.Scanner;

/**
 * Class Company: abstracts a company
 * @author Marconi Fonseca CST8284
 * Assignment 2: Company Management Tool prototype
 *  March 31 2019
 */

public class Manager extends Employee {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	// private Scanner in = new Scanner(System.in);

	public Manager() {
		this("unknown", -9, new OurDate(), -1, "Manager");
		// TODO Auto-generated constructor stub
	}
	
	 /** load constructor using super (name, employee number, start date and salary)
	  *set the title
	  */

	public Manager(String name, int employeeNumber, OurDate startDate, double salary, String title) {
		super(name, employeeNumber, startDate, salary);
		if (title.equals(""))
			this.loadExtraInfo();
		else
			this.setTitle(title);

	}
	
	/**all setters in this class
	 * 
	 * @return
	 */


	public String getTitle() {
		return title;

	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
    /** formats Manager info
     * 
     */
	@Override
	public String toString() {
		return getName() + "\t\t" + getEmployeeNumber() + " \t\t" + getStartDate() + "\t " + getSalary() + "\t"
				+ "title: " + getTitle();
	}

	/** Compare two employees for equality by comparing their relevant properties
	 * 
	 */
	@Override

	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass())) 
			return false;
		Manager newManager = (Manager) obj;		
		return (this.getName().equals(newManager.getName()) && 
				this.getEmployeeNumber() == newManager.getEmployeeNumber() && 
				this.getStartDate().equals(newManager.getStartDate())&&
				this.getSalary()==(newManager.getSalary())&&	
				this.getTitle()==newManager.getTitle()); 
				
	}//END EQUALS METHOD

	@Override
	public void loadExtraInfo() {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Manager's Title: ");
		title = in.nextLine();
		setTitle(title);

		
	}
}
