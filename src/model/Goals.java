package model;


import java.text.NumberFormat;

/**
 * This class represents the retirement goal of the
 * users and calculates the monthly contributions
 * It is a child class to the Input class
 * 
 * @author Joshua Lee
 * @author Jaza Khan
 * @author Richi Patel
 */
public class Goals extends Input {
	private double goal;
	
	/**
	 * Class Constructor
	 * <br><br>
	 * Precondition: annualInterestRate, currentSavings, and goal are not null
	 * <br>
	 * Postcondition: Constructs a goals object with the interest rate, current savings,
	 * and goals
	 * 
	 * @param annualInterestRate The annual interest rate
	 * @param currentSavings The current savings
	 * @param goal The goal amount desired by retirement
	 */
	public Goals(double annualInterestRate, double currentSavings, double goal) {
		super(annualInterestRate, currentSavings);
		this.goal = goal;
	}
	
	/**
	 * A getter for the retirement goal amount
	 * <br><br>
	 * Precondition: none 
	 * <br>
	 * Postcondition: <code>goal</code> is returned
	 * 
	 * @return the retirement goal amount
	 */
	public double getGoal() {
		return goal;
	}
	
	/**
	 * A setter for the retirement goal amount
	 * <br><br>
	 * Precondition: none
	 * <br>
	 * Postcondition: A new value for the retirement goal is set
	 * 
	 * @param goal The new retirement goal
	 */
	public void setGoal(double goal) {
		this.goal = goal;
	}
	
	/**
	 * Calculates the monthly contributions the user need to contribute
	 * in order to achieve their retirement goal amount
	 * <p> (r(A - P(1 + r)<sup>t</sup>) + 1)/(1 + r)<sup>t</sup>
	 * <br><br>
	 * Precondition: InterestRate, TimeElapesed, currentSavings, goal are not null.
	 * InterestRate is not -1 and timeElapsed is not odd
	 * <br>
	 * Postcondition: The monthly contribution amount is calculated
	 * @return The monthly contribution is returned
	 */
	public double calcContributions() {
		// calculates the accumulation a = (1 + r)^t
		double accumulation = Math.pow((1 + (super.getInterestRate()/12)), super.getTimeElapsed() * 12);
		
		// calculates the compound interest, P*a
		double compoundInterest = super.getCurrentSavings() * accumulation;
		
		// calculates the yearly contributions, (r * (A - P*a) + 1)/a
		double monthlyContributions = ((super.getInterestRate() * (goal - compoundInterest))/(accumulation - 1));
		
		// round the number to two decimals
		monthlyContributions = Math.round(monthlyContributions * 100.0) / 100.0;
		
		return monthlyContributions;
	}
	
	/**
	 * Returns a formatted string for the monthly contributions
	 * <br><br>
	 * Precondition: InterestRate, TimeElapesed, currentSavings, goal are not null.
	 * InterestRate is not -1 and timeElapsed is not odd
	 * <br>
	 * Postcondition: The formatted string for monthly contributions is returned
	 * @return The formatted string for monthly contributions
	 */
	public String toString() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		// formats into currency form, e.g. $10.02
		String contributions = formatter.format(calcContributions());
		
		return contributions + "/month";
	}
}

