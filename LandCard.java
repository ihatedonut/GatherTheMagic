public class LandCard extends Card
{
	private boolean tapped;
	
	public LandCard(String n, String c)
	{
		this.setName(n);
		this.setManaCost(0);
		this.setColor(c);
		tapped = false;
	}
	
	public boolean getTapped()
	{
		return tapped;
	}
	public void setTapped(boolean b)
	{
		tapped = b;
	}
	
	
	
	
	
	
	
	
	
	
	
}
