
public class CreatureCard extends Card
{
	private int power;
	private int toughness;
	private String abilities;
	private String cardInfo;
	private int turnsInPlay;
	private boolean canAttack;
	private boolean isSelected;
	private boolean isTapped;
	private boolean canBeBlocked;
	
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
		turnsInPlay=0;
		canAttack=false;	
		isSelected = false;
		isTapped=false;
		canBeBlocked=true;
		
		}
	
	public CreatureCard(String n, String c, String cInfo, int m, int p, int t, String abils)
	{
		power  = p;
		toughness = t;
		this.setName(n);
		this.setColor(c);
		this.setManaCost(m); 
		abilities = abils;
		cardInfo = cInfo;
		turnsInPlay=0;
		isSelected = false;
		canBeBlocked=true;
		if (abils.equals("haste"))
		{
			canAttack=true;
		}
		if (abils.equals("cantbeblocked"))
		{
			canBeBlocked=false;
		}
		
		isTapped=false;
	}
	
	
	
	public String getCardInfo()
	{
		return cardInfo;
	}
	
	public String getAbilities()
	{
		return abilities;
	}
	
	public void setCardInfo(String s)
	{
		cardInfo = s;
	}
	public void setTapped(boolean f)
	{
		isTapped = f;
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
	public void plusOneCounter()
	{
		power++;
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
	public int getTurnsInPlay()
	{
		return turnsInPlay;
	}
	public void setCanAttack(boolean b)
	{
		canAttack = b;
	}
	public void setcanbeBlocked(boolean b)
	{
		canBeBlocked = b;
	}
	public boolean isSelected()
	{
		return isSelected;
	}
	public void dealDamage(int n)
	{
		
	}
	public void takeDamage(int n)
	{
		toughness-=n;
		
	}
	public void attack()
	{
		isAttacking = true;
	}
	public boolean getAttacking()
	{
		return isAttacking;
	}
	
	
	
}
