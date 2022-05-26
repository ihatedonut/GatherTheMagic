public class Card 
{
	private String name;
	private String color;
	private int manacost;
	private boolean isPlayable;
	
	public Card()
	{
		
	}
	
	
	public Card(String n, String c, int m)
	{
		name = n;
		color = c;
		manacost = m;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String s)
	{
		name = s;
	}
	public String getColor()
	{
		return color;
	}
	public void setColor(String s)
	{
		color = s;
	}
	public int getManaCost()
	{
		return manacost;
	}
	public void setManaCost(int i)
	{
		manacost = i;
	}
	public boolean getPlayable()
	{
		return isPlayable;
	}
	public void setPlayable()
	{
		
	}
	

	
	
}
