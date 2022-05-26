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
	
	//abilities
	public void P1plus1plus1all()
	{
		ArrayList<CreatureCard> p1Creatures = this.P1getAllCreatures();
		for (CreatureCard c: p1Creatures)
		{
			c.plusOneCounter();
		}
	}
	public void P1gain1all()
	{
		ArrayList<CreatureCard> p1Creatures = this.P1getAllCreatures();
		for (CreatureCard c: p1Creatures)
		{
			P1.incrementLife();
		}
	}
	public void P1loselife()
	{
		ArrayList<CreatureCard> p1Creatures = this.P1getAllCreatures();
		for (CreatureCard c: p1Creatures)
		{
			P1.incrementLife(-1);
		}
	}
	public void P1drawpercreature()
	{
		ArrayList<CreatureCard> p1Creatures = this.P1getAllCreatures();
		for (CreatureCard c: p1Creatures)
		{
			P1.draw();
		}
	}
	public void P1tapopponent()
	{
		ArrayList<CreatureCard> p2Creatures = this.P2getAllCreatures();
		for (CreatureCard c: p2Creatures)
		{
			c.setTapped(true);
		}
	}
	public void returnCreatureHand(CreatureCard c)
	{
		if (P1battlefield.contains(c))
		{
			P1.addCardToHand(c);
			P1battlefield.remove(c);
		}
		if (P2battlefield.contains(c))
		{
			P2.addCardToHand(c);
			P2battlefield.remove(c);
		}
	}
	
	
	

	public void P2plus1plus1all()
	{
		ArrayList<CreatureCard> p2Creatures = this.P1getAllCreatures();
		for (CreatureCard c: p2Creatures)
		{
			c.plusOneCounter();
		}
	}
	public void P2gain1all()
	{
		ArrayList<CreatureCard> p2Creatures = this.P2getAllCreatures();
		for (CreatureCard c: p2Creatures)
		{
			P2.incrementLife();
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
	public ArrayList<CreatureCard> P2getAllCreatures()
	{
		ArrayList<CreatureCard> creaturesOnBattlefield = new ArrayList<CreatureCard>();
		for(int i = 0; i < P2battlefield.size(); i++)
		{
			
			if(P2battlefield.get(i) instanceof CreatureCard)
			{
				creaturesOnBattlefield.add((CreatureCard) P2battlefield.get(i));
			}
		}
		return creaturesOnBattlefield;
	}
	public void putOnP1Battlefield(CreatureCard c)
	{
		P1battlefield.add(c);
		P1.discard(P1.getIndexOfCard(c));
		if(c.getAbilities().equals("damagepercreature"))
		{
			this.P1loselife();
		}
		if(c.getAbilities().equals("gainlifepercreature"))
		{
			this.P1gain1all();
		}
//		if(c.getAbilities().equals("returncreature"))
//		{
//			this.returnCreatureHand(c);   NEED TO FIGURE OUT CARD SELECTED
//		}
		if(c.getAbilities().equals("drawpercreature"))
		{
			this.P1drawpercreature();
		}
		if(c.getAbilities().equals("+1+1percreature"))
		{
			this.P1plus1plus1all();
		}
		if(c.getAbilities().equals("tapopponentcreatures"))
		{
			this.P1plus1plus1all();
		}
		
		
	}
	public void putOnP2Battlefield(CreatureCard c)
	{
		P2battlefield.add(c);
		P2.discard(P2.getIndexOfCard(c));
		
	}
	
	public void putLandOnP1Battlefield(LandCard c)
	{
		P1battlefield.add(c);
		P1.discard(P1.getIndexOfCard(c));
	}
	public void putLandOnP2Battlefield(LandCard c)
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
			p1Phase = "Main Phase";
		}
		if (i==1)
		{
			p1Phase = "Attack Phase";
			p2Phase="Block Phase";
		}
		if (i==2)
		{
			p1Phase = "Main Phase 2";
		}
		if (i==3)
		{
			p1Phase = "End Phase";	
			ArrayList<CreatureCard> p1Creatures = this.P1getAllCreatures();
				for (CreatureCard c: p1Creatures)
				{
					c.setCanAttack(true);
				}
			
		}
	}
	
	public void setPhaseP2(int i) {
		if (i==0)
		{
			p2Phase = "Main Phase";
		}
		if (i==1)
		{
			p2Phase = "Attack Phase";
			p1Phase="Block Phase";
		}
		if (i==2)
		{
			p2Phase = "Main Phase 2";
		}
		if (i==3)
		{
			p2Phase = "End Phase";
			ArrayList<CreatureCard> p1Creatures = this.P1getAllCreatures();
			for (CreatureCard c: p1Creatures)
			{
				c.setCanAttack(true);
			}
		}
	}
	
	


}
