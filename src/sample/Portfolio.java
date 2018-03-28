package sample;

import java.util.*;

public class Portfolio {

	private ArrayList<Company> companies;
	private ArrayList<String> companiesStr;
	
	public Portfolio()
	{
		companies = new ArrayList<Company>();
		companiesStr = new ArrayList<String>();
		setCompaniesStr();
	}

	public void setOwnedCompanies(Market market)
	{
		ArrayList<Company> marketComps = market.getCompanies();
		for (int i = 0; i < marketComps.size(); i++)
		{
			if (marketComps.get(i).getSharesOwned() > 0)
			{
				addCompany(marketComps.get(i));
			}
		}
	}

	//add new company to arraylists
	public void addCompany(Company company)
	{
		companies.add(company);
		companiesStr.add(companies.get(companies.size()-1).getName());
		
		return;
	}


	//removes company by given string name
	public void removeCompany(String name)
	{
		try
		{
			for (int i = 0; i < companies.size(); i++)
			{
				if (companies.get(i).getName().equalsIgnoreCase(name))
				{
					companies.remove(i);
					companiesStr.remove(i);
				}
			}
		}
		catch (NoSuchElementException ex)
		{

		}
	}

	//removes company by given index
	public void removeCompany(int index)
	{
		companies.remove(index);
		companiesStr.remove(index);
	}

	public void eventPortfolioUpdate(Event e)
	{
		for(int i = 0; i < companies.size(); i++)
		{
			companies.get(i).eventStatUpdate(e);
		}
	}

	//converts companies arraylist to matching company name arraylist
	public void setCompaniesStr()
	{
		for (int i = 0; i < companies.size(); i++)
		{
			companiesStr.add(companies.get(i).getName() + "");
		}
	}

	public ArrayList<Company> getCompanies()
	{
		return companies;
	}

	public ArrayList<String> getCompaniesStr()
	{
		return companiesStr;
	}

	//filter through companies by name until finding match
	public Company getCompany(String name)
	{
		Company company = new Company();
		try
		{
			for (int i = 0; i < companies.size(); i++)
			{
				if (companies.get(i).getName().equalsIgnoreCase(name))
				{
					company = companies.get(i);
				}
			}
		}
		catch (NoSuchElementException ex)
		{

		}

		return company;
	}


}
