package model;

public class Factory {
	private String name;
	private int currentAge;
	private int endingAge;
	private double interest;
	private double startingAmount;
	private double monthlyContributions;
	private double goal;
	private String compoundPeriod;
	
	private static Factory singleton;
	
	public static Factory getInstance() {
		if (singleton == null) {
			singleton = new Factory();
		}
		return singleton;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCurrentAge() {
		return currentAge;
	}
	
	public void setCurrentAge(int currentAge) {
		this.currentAge = currentAge;
	}
	
	public int getEndingAge() {
		return endingAge;
	}
	
	public void setEndingAge(int endingAge) {
		this.endingAge = endingAge;
	}
	
	public double getInterest() {
		return interest;
	}
	
	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	public double getStartingAmount() {
		return startingAmount;
	}
	
	public void setStartingAmount(double startingAmount) {
		this.startingAmount = startingAmount;
	}
	
	public double getMonthlyContributions() {
		return monthlyContributions;
	}
	
	public void setMonthlyContributions(double monthlyContributions) {
		this.monthlyContributions = monthlyContributions;
	}
	
	public double getGoal() {
		return goal;
	}
	
	public void setGoal(double goal) {
		this.goal = goal;
	}
	
	public String getCompoundPeriod() {
		return compoundPeriod;
	}
	
	public void setCompoundPeriod(String compoundPeriod) {
		this.compoundPeriod = compoundPeriod;
	}
	
	public double createEarnings() {
		Earnings earning = new Earnings(interest, startingAmount, monthlyContributions, compoundPeriod);
		earning.yearsElapsed(currentAge, endingAge);
		return earning.calculateAnnualEarnings();
	}
	
	public double createGoals() {
		Goals goal = new Goals(interest, startingAmount, this.goal);
		goal.yearsElapsed(currentAge, endingAge);
		return goal.calcContributions();
	}
	
	public double specificYearGoal(int year) {
		Goals goal = new Goals(interest, startingAmount, this.goal);
		goal.yearsElapsed(0, year);
		return goal.calcContributions();
	}
	
	public double specificYearEarnings() {
		Earnings earning = new Earnings(interest, startingAmount, monthlyContributions, compoundPeriod);
		earning.yearsElapsed(currentAge, endingAge);
		return earning.calculateAnnualEarnings();
	}
}