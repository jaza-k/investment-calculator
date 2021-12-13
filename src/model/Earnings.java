package model;

import static java.lang.Math.pow;

public class Earnings extends Input{
	private double monthlyContributions;
	private String compoundingPeriod = "Annually";
	
	public Earnings(double annualInterestRate, double currentSavings, double monthlyContributions, String compoundingPeriod) {
		super(annualInterestRate, currentSavings);
		setMonthlyContributions(monthlyContributions);
		setCompoundingPeriod(compoundingPeriod);
	}

	public double getMonthlyContributions() {
		return monthlyContributions;
	}

	public void setMonthlyContributions(double monthlyContributions) {
		this.monthlyContributions = monthlyContributions;
	}
	
	public int getCompoundingPeriod() {
		if(compoundingPeriod.equals("Monthly"))
			return 12;
		else if(compoundingPeriod.equals("Quarterly"))
			return 4;
		else if(compoundingPeriod.equals("Semi-Annually"))
			return 2;
		else
			return 1;
	}

	public void setCompoundingPeriod(String compoundingPeriod) {
		this.compoundingPeriod = compoundingPeriod;
	}
	
	public double calculateAnnualEarnings() {
		double earnings = (super.getCurrentSavings() * pow((1 + (super.getInterestRate()/getCompoundingPeriod())), super.getTimeElapsed() * getCompoundingPeriod())) + (monthlyContributions * ((12/getCompoundingPeriod())* (((pow((1 + (super.getInterestRate()/getCompoundingPeriod())), super.getTimeElapsed() * getCompoundingPeriod())) - 1) / (super.getInterestRate()/getCompoundingPeriod()))));
		earnings = Math.round(earnings * 100.0) / 100.0;
		return earnings;
	}
	
	//for testing only
	public static void main(String args[]) {
		Earnings earning = new Earnings(5, 5000, 100, "Annually");
		earning.yearsElapsed(20, 30);
		System.out.println(earning.calculateAnnualEarnings());
	}
}
