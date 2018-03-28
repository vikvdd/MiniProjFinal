package sample;
import java.util.Random;

public class Event 
{
	private String eventName;
	private float percentImpact;
	private float severity;
	private float weighting;
	
	public Event()
	{
		
	}

	public void setPercentImpact()
	{
		Random random = new Random();
		severity = random.nextInt();
		weighting = random.nextInt();
		int randomNum = random.nextInt();

		if (randomNum > weighting)
		{
			percentImpact = severity;
		}
		else if (randomNum < weighting)
		{
			percentImpact = severity * -1;
		}
		else
		{
			severity = 0;
		}
	}

	public String getEventName()
	{
		return eventName;
	}
}
