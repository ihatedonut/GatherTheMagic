import java.util.ArrayList;

public class GameObject2 
{

	private ArrayList<Card> P1battlefield;
	private ArrayList<Card> P2battlefield;
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
		for(int i = 0; i < P1battlefield.size(); i++)
		{
			ArrayList<CreatureCard> creaturesOnBattlefield = new ArrayList<CreatureCard>();
			if(P1battlefield.get(i) instanceof CreatureCard)
			{
				creaturesOnBattlefield.add(P1battlefield.get(i));
			}
		}
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

}