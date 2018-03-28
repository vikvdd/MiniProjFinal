package sample;

import javafx.scene.Parent;

public class Company
{
	private String name;
	private String code;
	private String description;
	private double netValue;
	private double shareVal;
	private double lastShareVal;
	private double performance;
	private int sharesOwned;

	//creates empty placeholder company
	public Company()
	{
		name = "No Companies Available";
	}

	//constructor which sets all instance variables given individually
	public Company(String name_, String code_, String desc_, double shareVal_, int sharesOwned_, double lastShareVal_)
	{
		name = name_;
		code = code_;
		description = desc_;
		shareVal = shareVal_;
		sharesOwned = sharesOwned_;
		lastShareVal = lastShareVal_;
	}


	//constructor that splits string array into instance variables in order of array
	public Company(String[] compArr)
	{
		name = compArr[0];
		code = compArr[1];
		description = compArr[2];
		shareVal = Double.parseDouble(compArr[3]);
		sharesOwned = Integer.parseInt(compArr[4]);
		lastShareVal = Double.parseDouble(compArr[5]);
	}


	public void eventStatUpdate(Event e)
	{
		performance = ((shareVal - lastShareVal)/lastShareVal)*100;
		lastShareVal = shareVal;
	}

	public void removeShare()
	{
		sharesOwned--;
		return;
	}

	public void addShare()
	{
		sharesOwned++;
		return;
	}

	public void setName(String name_)
	{
		name = name_;

		return;
	}

	public void setCode(String code_)
	{
		code = code_;

		return;
	}
	
	public Company getCompany()
	{
		return this;
	}
	
	public String getName()
	{
		return name;
	}

	public String getCode()
	{
		return code;
	}

	public double getNetValue()
	{
		return netValue;
	}

	public double getShareVal()
	{
		return shareVal;
	}

	public int getSharesOwned()
	{
		return sharesOwned;
	}
}
