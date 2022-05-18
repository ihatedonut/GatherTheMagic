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
		P1 = new Player();
		P2 = new Player();

	}
	
	
	
//	public static void main(String[] args)
//	{
//		while(P1.getLife()>0 && P2.getLife()>0)
//		{
//			
//		}
//	}
	
	
	public void P1plus1plus1all()
	{
		for(Card c : P1battlefield)
		{
			//c.incrementPower();
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
	//counter ++ at end step. then if creatures counter is gretaer >0 boolean can attack

	//phases
	public void setPhaseP1(int i) {
		if (i==0)
		{
			p1Phase.equals("Main Phase");
		}
		if (i==1)
		{
			p1Phase.equals("Attack Phase");
		}
		if (i==2)
		{
			p1Phase.equals("Main Phase 2");
		}
		if (i==3)
		{
			p1Phase.equals("End Phase");
		}
	}
	public void setPhaseP2(int i) {
		if (i==0)
		{
			p2Phase.equals("Main Phase");
		}
		if (i==1)
		{
			p2Phase.equals("Attack Phase");
		}
		if (i==2)
		{
			p2Phase.equals("Main Phase 2");
		}
		if (i==3)
		{
			p2Phase.equals("End Phase");
		}
	}

}
