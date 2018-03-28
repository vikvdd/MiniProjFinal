package sample;

import javafx.scene.Parent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class StockMarket 
{
	private ArrayList<Market> markets;
	private Event currentEvent;
	
	public StockMarket() throws IOException
	{
		markets = new ArrayList<Market>();
		markets.add(new Market("companies.txt"));
	}


	//picks random event type and assigns it as the current event
	public void randomEvent()
	{
		Random random = new Random();
		int rand = random.nextInt(2);
		if (rand == 0)
		{
			currentEvent = new WeatherEvent();
		}
		else if (rand == 1)
		{
			currentEvent = new SocioeconomicEvent();
		}
		else if (rand == 2)
		{
			currentEvent = new DemandEvent();
		}
	}

	public ArrayList<Market> getMarkets()
	{
		return markets;
	}

	public Event getCurrentEvent()
	{
		return currentEvent;
	}
}
