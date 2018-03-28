package sample;


import java.io.IOException;

public class Program
{
	private StockMarket stockMarket;
	private Investor investor;
	private boolean displayShares;
	
	public Program() throws IOException
	{
		stockMarket = new StockMarket();
		investor = new Investor("Mark Wahlberg", 20000, 150000, 3.4);
		displayShares = true;

	}

	public void setDisplayShares(boolean displayShares)
	{
		this.displayShares = displayShares;
	}

	public boolean getDisplayShares()
	{
		return displayShares;
	}


	public Investor getInvestor()
	{
		return investor;
	}

	public StockMarket getStockMarket()
	{
		return stockMarket;
	}

}
