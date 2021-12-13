package model;

public class Input {
	private double annualInterestRate;
	private double currentSavings;
	int timeElapsed;
	
	public Input(double annualInterestRate, double currentSavings) {
		setInterestRate(annualInterestRate);
		setCurrentSavings(currentSavings);
	}
	
	public double getInterestRate() {
		return annualInterestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.annualInterestRate = interestRate / 100;
	}
	
	public double getCurrentSavings() {
		return currentSavings;
	}
	
	public void setCurrentSavings(double currentSavings) {
		this.currentSavings = currentSavings;
	}
	
	public int getTimeElapsed() {
		return timeElapsed;
	}

	public void yearsElapsed(int currentAge, int retirementAge) {
		int time = retirementAge - currentAge;
		timeElapsed = time;
	}
	
}


