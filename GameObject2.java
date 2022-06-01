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
		public void p1Deal3()
	{
		CreatureCard other = this.getAllSelectedCreatures();
		other.takeDamage(3);
		{
			if (P1battlefield.contains(other))
			{
				P1battlefield.remove(other);
			}
			if (P2battlefield.contains(other))
			{
				P2battlefield.remove(other);
			}
		}
	}
	public ArrayList<CreatureCard> P1Attacking()
	{
		ArrayList<CreatureCard> a = this.P1getAllCreatures();
		ArrayList<CreatureCard> creaturesOnBattlefieldAttacking = new ArrayList<CreatureCard>();
		
		for (CreatureCard c: a)
		{
			if(c.getAttacking())
			{
				 creaturesOnBattlefieldAttacking.add(c);
				c.setTapped(true);
			}
		}
		return creaturesOnBattlefieldAttacking;

	}
	public void p2Deal3()
	{
		CreatureCard other = this.getAllSelectedCreatures();
		other.takeDamage(3);
		{
			if (other.getToughness()<=0)
			{
				if (P1battlefield.contains(other))
				{
					P1battlefield.remove(other);
				}
				if (P2battlefield.contains(other))
				{
					P2battlefield.remove(other);
				}
			}
		}
	}
	
	
	
	
	
	
	
	public void destroyAllOther(CreatureCard c)
	{
		ArrayList<CreatureCard> p2Creatures = this.P2getAllCreatures();
		ArrayList<CreatureCard> p1Creatures = this.P1getAllCreatures();
		
		for(int i = 0; i < P1battlefield.size(); i++)
		{
			
			if(P1battlefield.get(i) instanceof CreatureCard)
			{
				if (c != P1battlefield.get(i))
				{
					P1battlefield.remove(i);
				}
			}
			if(P2battlefield.get(i) instanceof CreatureCard)
			{
				if (c != P2battlefield.get(i))
				{
					P2battlefield.remove(i);
				}
			}
		}
		
	}
	public void returnCreatureHand()
	{
		CreatureCard c = this.getAllSelectedCreatures();
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
	public void p1TapOpponentCreature()
	{
		CreatureCard c = this.getAllSelectedCreatures();
		if (P2battlefield.contains(c))
		{
			c.setTapped(true);
		}
	}
	public void cantBeBlocked(CreatureCard c)
	{
		c.setcanbeBlocked(false);
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
	public void P2loselife()
	{
		ArrayList<CreatureCard> p2Creatures = this.P2getAllCreatures();
		for (CreatureCard c: p2Creatures)
		{
			P2.incrementLife(-1);
		}
	}
	public void P2drawpercreature()
	{
		ArrayList<CreatureCard> p2Creatures = this.P2getAllCreatures();
		for (CreatureCard c: p2Creatures)
		{
			P2.draw();
		}
	}
	public void P2tapopponent()
	{
		ArrayList<CreatureCard> p1Creatures = this.P1getAllCreatures();
		for (CreatureCard c: p1Creatures)
		{
			c.setTapped(true);
		}
	}
	public void p2TapOpponentCreature()
	{
		CreatureCard c = this.getAllSelectedCreatures();
		if (P1battlefield.contains(c))
		{
			c.setTapped(true);
		}
	}
	public ArrayList<CreatureCard> P2Attacking()
	{
		ArrayList<CreatureCard> a = this.P2getAllCreatures();
		ArrayList<CreatureCard> creaturesOnBattlefieldAttacking = new ArrayList<CreatureCard>();
		
		for (CreatureCard c: a)
		{
			if(c.getAttacking())
			{
				 creaturesOnBattlefieldAttacking.add(c);
				c.setTapped(true);
			}
		}
		return creaturesOnBattlefieldAttacking;

	}
	
	
	public CreatureCard getAllSelectedCreatures()
	{
		CreatureCard selectedCreature = new CreatureCard();
		ArrayList<CreatureCard> p1Creatures = this.P1getAllCreatures();
		ArrayList<CreatureCard> p2Creatures = this.P2getAllCreatures();
		for(int i = 0; i < P1battlefield.size(); i++)
		{
			
			
			for (CreatureCard c: p1Creatures)
			{
				if(c.isSelected())
				{
					selectedCreature = c;
				}
			}
		}
		for(int i = 0; i < P2battlefield.size(); i++)
		{
			
			
			for (CreatureCard c: p2Creatures)
			{
				if(c.isSelected())
				{
					selectedCreature = c;
				}
			}
		}
		return selectedCreature;
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
		if (!(c.getAbilities()==(null)))
		{
		if(c.getAbilities().equals("damagepercreature"))
		{
			this.P1loselife();
		}
		if(c.getAbilities().equals("gainlifepercreature"))
		{
			this.P1gain1all();
		}
		if(c.getAbilities().equals("returncreature"))
		{
			this.returnCreatureHand(); 
		}
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
			this.P1tapopponent();
		}
		if(c.getAbilities().equals("destroyothercreatures"))
		{
			this.destroyAllOther(c);
		}
		if(c.getAbilities().equals("tapcreature"))
		{
			this.p1TapOpponentCreature();
		}
		if(c.getAbilities().equals("cantbeblocked"))
		{
			this.cantBeBlocked(c);
		}
		if(c.getAbilities().equals("3damagecreature"))
		{
			this.p1Deal3();
		}
		}
	}
	public void putOnP2Battlefield(CreatureCard c)
	{
		P2battlefield.add(c);
		P2.discard(P2.getIndexOfCard(c));
		if (!(c.getAbilities()==(null)))
		{
		if(c.getAbilities().equals("damagepercreature"))
		{
			this.P2loselife();
		}
		if(c.getAbilities().equals("gainlifepercreature"))
		{
			this.P2gain1all();
		}
		if(c.getAbilities().equals("returncreature"))
		{
			this.returnCreatureHand(); 
		}
		if(c.getAbilities().equals("drawpercreature"))
		{
			this.P2drawpercreature();
		}
		if(c.getAbilities().equals("+1+1percreature"))
		{
			this.P2plus1plus1all();
		}
		if(c.getAbilities().equals("tapopponentcreatures"))
		{
			this.P2tapopponent();
		}
		if(c.getAbilities().equals("destroyothercreatures"))
		{
			this.destroyAllOther(c);
		}
		if(c.getAbilities().equals("tapcreature"))
		{
			this.p2TapOpponentCreature();
		}
		if(c.getAbilities().equals("cantbeblocked"))
		{
			this.cantBeBlocked(c);
		}
		if(c.getAbilities().equals("3damagecreature"))
		{
			this.p2Deal3();
		}
		}
	}
	public void destroyP1Creature(int index)
	{
		P1battlefield.remove(index);
	}
	public void destroyP2Creature(int index)
	{
		P2battlefield.remove(index);
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
	
	public void setPhaseP1(int i) {
		if (i==0)
		{
			p1Phase = ("Main Phase");
			P1.setLandPlays(1);
			
		}
		if (i==1)
		{
			p1Phase = ("Attack Phase");
			p2Phase="Block Phase";
			ArrayList<CreatureCard> p1Creatures = this.P1getAllCreatures();
			for (CreatureCard c: p1Creatures)
			{
				if(c.isSelected())
				{
					 c.attack();
				}
			}
		}
		if (i==2)
		{
			p1Phase = ("Main Phase 2");
		}
		if (i==3)
		{
			p1Phase = ("End Phase");
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
			ArrayList<CreatureCard> p2Creatures = this.P2getAllCreatures();
				for (CreatureCard c: p2Creatures)
				{
					c.setCanAttack(true);
				}
			
		}
		if (i==2)
		{
			p2Phase = "Main Phase 2";
		}
		if (i==3)
		{
			p2Phase = "End Phase";
			ArrayList<CreatureCard> p2Creatures = this.P2getAllCreatures();
			for (CreatureCard c: p2Creatures)
			{
				c.setCanAttack(true);
			}
		}
	}
	public String getPhaseP1()
	{
		return p1Phase;
	}
	public String getPhaseP2()
	{
		return p2Phase;
	}


}
