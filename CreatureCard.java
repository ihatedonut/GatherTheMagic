
public class CreatureCard extends Card
{
	private int power;
	private int toughness;
	
	
	public CreatureCard(String n, String c, int m, int p, int t)
	{
		power  = p;
		toughness = t;
		this.setName(n);
		this.setColor(c);
		this.setManaCost(m);
	}
	
	public int getPower()
	{
		return power;
	}
	public void setPower(int i)
	{
		power = i;
	}
	public int getToughness()
	{
		return toughness;
	}
	public void setToughness()
	{\
		
		
	}
	
	
	
}
