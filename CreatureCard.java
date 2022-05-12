
public class CreatureCard extends Card
{
	private int power;
	private int toughness;
	private String abilities;
	
	public CreatureCard()
	{
		
	}
	
	public CreatureCard(String n, String c, int m, int p, int t)
	{
		power  = p;
		toughness = t;
		this.setName(n);
		this.setColor(c);
		this.setManaCost(m);
	}
	
	public CreatureCard(String n, String c, int m, int p, int t, String abils)
	{
		power  = p;
		toughness = t;
		this.setName(n);
		this.setColor(c);
		this.setManaCost(m); 
		abilities = abils;
	}
	
	public int getPower()
	{
		return power;
	}
	
	public int getToughness()
	{
		return toughness;
	}
	
	public void incrementPower()
	{
		power++;
	}
	
	public void incrementToughness()
	{
		toughness++;
	}
	
	public void incrementPower(int num)
	{
		power += num;
	}
	
	public void incrementToughness(int num)
	{
		toughness += num;
	}
	
	public void setPower(int num)
	{
		power = num;
	}
	
	public void setToughness(int num)
	{
		toughness = num;
	}
	
	
	
}
