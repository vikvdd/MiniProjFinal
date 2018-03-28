package sample;

public class Shares 
{
	private double netValue;
	private double valuePer;
	private double quantity;
	
	public Shares(double valuePer_, double quantity_)
	{
		valuePer = valuePer_; 
		quantity = quantity_;
		netValue = calcNetVal();
	}
	
	public double calcNetVal()
	{
		double netVal = valuePer * quantity;
		return netValue;
	}
	
	
	

}
