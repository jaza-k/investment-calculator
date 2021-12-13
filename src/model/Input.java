package model;

/**
 * Input class is used to get the values that are going to be used to calculate
 * information about the investment
 * This class is a parent to the Goals and Earnings classes
 * 
 * @author Richi, Jaza, Josh
 *
 */
public class Input {
	//the interest rate used in the investment
	private double interestRate;
	//the amount which will be invested at the start
	private double currentSavings;
	//the time the investment will go for
	int timeElapsed;
	
	/**
	 * Class constructor
	 * Sets the <code>interestRate</code> and <code>currentSavings</code> instance variables
	 * 
	 * Precondition: <code>interestRate</code> and <code>currentSavings</code> must be of type double
	 * Postcondition: <code>interestRate</code> and <code>currentSavings</code> are set
	 * 
	 * @param annualInterestRate
	 * @param currentSavings
	 */
	public Input(double annualInterestRate, double currentSavings) {
		setInterestRate(annualInterestRate);
		setCurrentSavings(currentSavings);
	}
	
	/**
	 * getter method for the <code>interestRate</code> instance variable
	 * 
	 * Precondition: none
	 * Postcondition: returns the <code>interestRate</code> instance variable
	 * 
	 * @return returns the value of the <code>interestRate</code> instance variable
	 */
	public double getInterestRate() {
		return interestRate;
	}
	
	/**
	 * setter method for the <code>interestRate</code> instance variable
	 * takes the value of <code>interestRate</code> and divides it by 100
	 * 
	 * Precondition: <code>interestRate</code> must be of type double
	 * Postcondition: the <code>interestRate</code> instance variable will be
	 * set to the parameter percent in decimal form
	 * 
	 * @param interestRate the interest rate to be used for calculation
	 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate / 100;
	}
	
	/**
	 * getter method for the <code>currentSavings</code> instance variable
	 * 
	 * Precondition: none
	 * Postcondition: returns the <code>currentSavings</code> instance variable
	 * 
	 * @return returns the value of the <code>currentSavings</code> instance variable
	 */
	public double getCurrentSavings() {
		return currentSavings;
	}
	
	/**
	 * setter method for the <code>currentSavings</code> instance variable
	 * 
	 * Precondition: <code>currentSavings</code> must be of type double
	 * Postcondition: the <code>currentSavings</code> instance variable
	 * will be set to the value of the parameter
	 * 
	 * @param currentSavings the initial savings amount that will be invested.
	 * the <code>currentSavings</code> instance variable will be set to this value
	 */
	public void setCurrentSavings(double currentSavings) {
		this.currentSavings = currentSavings;
	}
	
	/**
	 * getter method for the <code>timeElapsed</code> instance variable
	 * 
	 * Precondition: none
	 * Postcondition: returns the <code>timeElapsed</code> instance variable
	 * 
	 * @return returns the value of the <code>timeElapsed</code> instance variable
	 */
	public int getTimeElapsed() {
		return timeElapsed;
	}
	
	/**
	 * yearsElapsed method takes the current age of the individual and subtracts
	 * it from the age they plan to retire and cash out the investment at, to get
	 * the total time the investment will go on for
	 * 
	 * Precondition: <code>currentAge</code> and <code>investmentEndAge</code> must be integers
	 * Postcondition: the <code>timeElapsed</code> instance variable will be set to the value
	 * of the <code>investmentEndAge</code> parameter minus the <code>currentAge</code> parameter
	 * 
	 * @param currentAge the age of the user at the moment of investing
	 * @param investmentEndAge the age when the user plans to retire or cash out the investment
	 */
	public void yearsElapsed(int currentAge, int investmentEndAge) {
		int time = investmentEndAge - currentAge;
		timeElapsed = time;
	}
}


