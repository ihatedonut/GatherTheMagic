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
		P1 = new Player("N/A");
		P2 = new Player("N/A");

	}
	
	
	
//	public static void main(String[] args)
//	{
//		while(P1.getLife()>0 && P2.getLife()>0)
//		{
//			
//		}
//	}
	
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

}
