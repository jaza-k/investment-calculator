package model;

/**
 * Class creates a single instance of itself and is used to create goals and earnings classes
 * 
 * @author Richi, Jaza
 *
 */
public class Creator {
	/**
	 * instance variables used in the input, goals, and earnings classes
	 */
	private String name;
	private int currentAge;
	private int endingAge;
	private double interest;
	private double startingAmount;
	private double monthlyContributions;
	private double goal;
	private String compoundPeriod;
	
	//singleton instance of this class
	private static Creator singleton;
	/**
	 * Returns the singleton instance of this class
	 * creates a new one if it is null
	 * @return returns the singleton instance
	 */
	public static Creator getInstance() {
		if (singleton == null) {
			singleton = new Creator();
		}
		return singleton;
	}
	
	/**
	 * getter method for the <code>name</code> instance variable
	 * @return returns <code>name</code>
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * setter method for the <code>name</code> instance variable
	 * @param name the name of the user
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * getter method for <code>currentAge</code> instance variable
	 * @return returns <code>currentAge</code>
	 */
	public int getCurrentAge() {
		return currentAge;
	}
	
	/**
	 * setter method for <code>currentAge</code>
	 * @param currentAge the age of the user
	 */
	public void setCurrentAge(int currentAge) {
		this.currentAge = currentAge;
	}
	
	/**
	 * getter method for <code>endingAge</code> instance variable
	 * @return returns <code>endingAge</code>
	 */
	public int getEndingAge() {
		return endingAge;
	}
	
	/**
	 * setter method for <code>endingAge</code>
	 * @param endingAge the age of cashing out the investment
	 */
	public void setEndingAge(int endingAge) {
		this.endingAge = endingAge;
	}
	
	/**
	 * getter method for <code>interest</code> instance variable
	 * @return returns <code>interest</code>
	 */
	public double getInterest() {
		return interest;
	}
	
	/**
	 * setter method for <code>interest</code>
	 * @param interest the interest rate of the investment
	 */
	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	/**
	 * getter method for <code>startingAmount</code> instance variable
	 * @return returns <code>startingAmount</code>
	 */
	public double getStartingAmount() {
		return startingAmount;
	}
	
	/**
	 * setter method for <code>startingAmount</code>
	 * @param startingAmount the amount initially invested
	 */
	public void setStartingAmount(double startingAmount) {
		this.startingAmount = startingAmount;
	}
	
	/**
	 * getter method for <code>monthlyContributions</code> instance variable
	 * @return returns <code>monthlyContributions</code>
	 */
	public double getMonthlyContributions() {
		return monthlyContributions;
	}
	
	/**
	 * setter method for <code>monthlyContributions</code>
	 * @param monthlyContributions the amount contributed monthly
	 */
	public void setMonthlyContributions(double monthlyContributions) {
		this.monthlyContributions = monthlyContributions;
	}
	
	/**
	 * getter method for <code>goal</code> instance variable
	 * @return returns <code>goal</code>
	 */
	public double getGoal() {
		return goal;
	}
	
	/**
	 * setter method for <code>goal</code>
	 * @param goal the amount of money to be reached
	 */
	public void setGoal(double goal) {
		this.goal = goal;
	}
	
	/**
	 * getter method for <code>compoundPeriod</code> instance variable
	 * @return returns <code>compoundPeriod</code>
	 */
	public String getCompoundPeriod() {
		return compoundPeriod;
	}
	
	/**
	 * setter method for <code>compoundPeriod</code>
	 * @param compoundPeriod the period the interest will be compounded by
	 */
	public void setCompoundPeriod(String compoundPeriod) {
		this.compoundPeriod = compoundPeriod;
	}
	/**
	 * createEarnings method creates an instance of earnings and returns the calculation
	 * from the method using the information of the singleton instance
	 * 
	 * @return returns the calculation from the Earnings class
	 */
	public double createEarnings() {
		Earnings earning = new Earnings(interest, startingAmount, monthlyContributions, compoundPeriod);
		earning.yearsElapsed(currentAge, endingAge);
		return earning.calculateAnnualEarnings();
	}
	
	/**
	 * createGoals method creates an instance of goals and returns the calculation
	 * from the method using the information of the singleton instance
	 * @return returns the calculation from the goals class
	 */
	public double createGoals() {
		Goals goal = new Goals(interest, startingAmount, this.goal);
		goal.yearsElapsed(currentAge, endingAge);
		return goal.calcContributions();
	}
	/**
	 * specificYearEarnings method creates an instance of earnings and returns the calculation
	 * from the method using the information of the singleton instance and the specified year
	 * @return
	 */
	public double specificYearEarnings(int year) {
		Earnings earning = new Earnings(interest, startingAmount, monthlyContributions, compoundPeriod);
		earning.yearsElapsed(0, year);
		return earning.calculateAnnualEarnings();
	}
	
	/**
	 * specificYearGoal method creates an instance of goals and returns the calculation
	 * from the method using the information of the singleton instance and the specified year
	 * @param year the number of years elapsed to calculate for
	 * @return returns the calculation from the goals class using the specified years elapsed
	 */
	public double specificYearGoal(int year) {
		Goals goal = new Goals(interest, startingAmount, this.goal);
		goal.yearsElapsed(0, year);
		return goal.calcContributions();
	}
}