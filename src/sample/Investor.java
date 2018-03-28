package sample;


public class Investor {

	private String name;
	private double netShareVal;
	private double wallet;
	private double hourlyGrowth;
	private Portfolio portfolio;
	
	public Investor(String name_, double netShareVal_, double wallet_, double hourlyGrowth_)
	{
		name = name_;
		netShareVal = netShareVal_;
		wallet = wallet_;
		hourlyGrowth = hourlyGrowth_;
		portfolio = new Portfolio();
	}

	public String getName()
	{
		return name;
	}

	public Portfolio getPortfolio()
	{
		return portfolio;
	}
}
