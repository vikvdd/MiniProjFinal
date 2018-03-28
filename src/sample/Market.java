package sample;
import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Market {
	
	private ArrayList<Company> companies;
	private ArrayList<String> companiesStr;
	private File file;

	
	public Market(String fileName) throws IOException
	{
		companies = new ArrayList<Company>();
		companiesStr = new ArrayList<String>();
		file = new File(fileName);
	}
	
	public void addCompany(Company company)
	{
		companies.add(company);
		companiesStr.add(company.getName());
		return;
	}
	
	public void removeCompany(String comName)
	{
		for (int i = 0; i < companies.size(); i++)
		{
			if (companies.get(i).getName().equalsIgnoreCase(comName))
			{
				companies.remove(i);
				companiesStr.remove(i);
			}
		}
		
		return;
	}

	//reads a file with stored company info in one line divided by commas, then splits each line into an array of Strings
	public void readCompaniesFiles() throws IOException
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String tempStr;
			while((tempStr = br.readLine()) != null)
			{
				String[] tempArr = tempStr.split(",");
				companies.add(new Company(tempArr));
				companiesStr.add(tempArr[0] + "");
			}



		}
		catch(FileNotFoundException ex)
		{

		}

	}

	public void eventMarketUpdate(Event e)
	{
		for(int i = 0; i < companies.size(); i++)
		{
			companies.get(i).eventStatUpdate(e);
		}
	}

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
