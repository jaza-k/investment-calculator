package model;

import static java.lang.Math.pow;
/**
 * Earnings class is used to calculate total earnings of an investment with monthly contributions
 * it is a child class to the Input class
 * 
 * @author Richi, Josh, Jaza
 * 
 */
public class Earnings extends Input{
	//monthlyContributions instance variable is the amount that will be contributed to investment every month
	private double monthlyContributions;
	//compoundingPeriod instance variable is the compounding period for the interest rate, default is "Annually"
	private String compoundingPeriod = "Annually";
	
	/**
	 * Class constructor
	 * Sets the <code>monthlyContributions</code> and <code>compoundingPeriod</code> instance variables
	 * and calls the constructor in the parent class to set interestRate and currentSavings instance variables in the parent class
	 * 
	 * Precondition: <code>interestRate</code>, <code>currentSavings</code>, <code>monthlyContributions</code> must be a double, <code>compoundingPeriod</code> must be a String
	 * Postcondition: Instance variables will be set
	 * 
	 * @param interestRate The interest rate to use for calculation
	 * @param currentSavings The amount of initial savings to use for calculation
	 * @param monthlyContributions The amount that will be added every month
	 * @param compoundingPeriod The compounding period of the interest
	 */
	public Earnings(double interestRate, double currentSavings, double monthlyContributions, String compoundingPeriod) {
		super(interestRate, currentSavings);
		setMonthlyContributions(monthlyContributions);
		setCompoundingPeriod(compoundingPeriod);
	}
	
	/**
	 * getter method for <code>monthlyContributions</code> instance variable
	 * 
	 * Precondition: none
	 * Postcondition: returns <code>monthlyContributions</code> instance variable
	 * 
	 * @return returns the value of monthlyContributions
	 */
	public double getMonthlyContributions() {
		return monthlyContributions;
	}
	
	/**
	 * setter method for <code>monthlyContributions</code> instance variable
	 * 
	 * Precondition: monthlyContributions must be of type double
	 * Postcondition: <code>monthlyContributions</code> instance variable is set to the value of the parameter
	 * 
	 * @param monthlyContributions The value that the <code>monthlyContributions</code> instance variable will be set to
	 */
	public void setMonthlyContributions(double monthlyContributions) {
		this.monthlyContributions = monthlyContributions;
	}
	
	/**
	 * getter method for the integer value of the <code>compoundingPeriod</code> instance variable
	 * 
	 * Precondition: none
	 * Postcondition: <code>compoundingPeriod</code> will be turned into its integer equivalent and returned
	 * 
	 * @return returns the integer value for the type of compounding. Monthly is 12, Quarterly is 4, Semi-Annually is 2, Annually is 1
	 */
	public int getCompoundingPeriodValue() {
		//returns 12 if the compounding period is monthly
		if(compoundingPeriod.equals("Monthly"))
			return 12;
		//returns 4 if the compounding period is quarterly
		else if(compoundingPeriod.equals("Quarterly"))
			return 4;
		//returns 2 if the compounding period is semi-annually
		else if(compoundingPeriod.equals("Semi-Annually"))
			return 2;
		//returns 1 which is the default value of annually
		else
			return 1;
	}
	
	/**
	 * setter method for the <code>compoundingPeriod</code> instance variable
	 * 
	 * Precondition: <code>compoundingPeriod</code> must be of type String
	 * Postcondition: the <code>compoundingPeriod</code> instance variable will be set
	 * 
	 * @param compoundingPeriod the type of compounding that the <code>compoundingPeriod</code> instance variable will be set to
	 */
	public void setCompoundingPeriod(String compoundingPeriod) {
		this.compoundingPeriod = compoundingPeriod;
	}
	
	/**
	 * calculateAnnualEarnings method
	 * takes the information from all the instance variables to calculate
	 * how much earnings will be made with those specifications
	 * 
	 * Precondition: All instance variables must not be null
	 * Postcondition: calculates the earnings from the data in the instance variables and returns it
	 * 
	 * @return returns the earnings that will be made
	 */
	public double calculateAnnualEarnings() {
		//calculate the earnings using the compound interest + monthly contributions formula
		double earnings = (super.getCurrentSavings() * pow((1 + (super.getInterestRate()/getCompoundingPeriodValue())), super.getTimeElapsed() * getCompoundingPeriodValue())) + (monthlyContributions * ((12/getCompoundingPeriodValue())* (((pow((1 + (super.getInterestRate()/getCompoundingPeriodValue())), super.getTimeElapsed() * getCompoundingPeriodValue())) - 1) / (super.getInterestRate()/getCompoundingPeriodValue()))));
		//rounds to 2 decimal places
		earnings = Math.round(earnings * 100.0) / 100.0;
		return earnings;
	}
}
