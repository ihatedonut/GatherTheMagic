import java.util.ArrayList;

public class GameObject2 
{

	private ArrayList<Card> P1battlefield;
	private ArrayList<Card> P2battlefield;
	private String p1Phase;
	private String p2Phase;
	private Player P1;
	private Player P2;
	
	public GameObject2()
	{
		P1battlefield = new ArrayList<Card>();
		P2battlefield = new ArrayList<Card>();
		P1 = new Player("white");
		P2 = new Player("red");
		this.setPhaseP1(0);

	}
	
	public Player getPlayer1()
	{
		return P1;
	}
	public Player getPlayer2()
	{
		return P2;
	}
	
	
	public void P1plus1plus1all()
	{
		ArrayList<CreatureCard> creatures = this.P1getAllCreatures();
		for (CreatureCard c: creatures)
		{
			c.incrementPower();
			c.incrementToughness();
		}
	}
	public ArrayList<CreatureCard> P1getAllCreatures()
	{
		ArrayList<CreatureCard> creaturesOnBattlefield = new ArrayList<CreatureCard>();
		for(int i = 0; i < P1battlefield.size(); i++)
		{
			
			if(P1battlefield.get(i) instanceof CreatureCard)
			{
				creaturesOnBattlefield.add((CreatureCard) P1battlefield.get(i));
			}
		}
		return creaturesOnBattlefield;
	}
	public void putOnP1Battlefield(Card c)
	{
		P1battlefield.add(c);
		P1.discard(P1.getIndexOfCard(c));
	}
	public void putOnP2Battlefield(Card c)
	{
		P2battlefield.add(c);
		P2.discard(P2.getIndexOfCard(c));
	}
	public void destroyP1Creature(int index)
	{
		P1battlefield.remove(index);
	}
	public void destroyP2Creature(int index)
	{
		P2battlefield.remove(index);
	}
	
	public void setPhaseP1(int i) {
		if (i==0)
		{
			p1Phase = ("Main Phase");
			P1.setLandPlays(1);
			
		}
		if (i==1)
		{
			p1Phase = ("Attack Phase");
		}
		if (i==2)
		{
			p1Phase = ("Main Phase 2");
		}
		if (i==3)
		{
			p1Phase = ("End Phase");
		}
	}
	public String getPhaseP1()
	{
		return p1Phase;
	}


}