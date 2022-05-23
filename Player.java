import java.util.ArrayList;

public class Player 
{
	private int life;
	private ArrayList<Card> hand;
	private ArrayList<Card> deck;
	private ArrayList<Card> graveyard;
	private int availableMana;
	private final int MAXHANDSIZE = 7;
	
	public Player()
	{
		life = 20;
		hand = new ArrayList<Card>();
		deck = new ArrayList<Card>();
	
	
	}
	
	public void fillDeck(String colorDeck)
	{
				if(colorDeck.equals("white"))
				{
					for(int i = 0; i < 25; i++)
					{
						deck.add(new LandCard("Plains", "white"));
					}
					deck.add(new CreatureCard("Aidan Gamma, Thunderous Cleric", "white", "When Aidan Gamma enters the battlefield, gain 1 life for each creature you control.", 4, 2, 3, "gainlifepercreature"));
					deck.add(new CreatureCard("Astral Unicorn", "white", 3, 2, 3));
					deck.add(new CreatureCard("Monk of Familiarity", "white", "When Monk of Familiarity enters the battlefield, return target creature to it's owners hand.", 3, 2, 2, "returncreature"));
					deck.add(new CreatureCard("Usher of the Ageless", "white", 5, 4, 3));
					deck.add(new CreatureCard("Unholy Beggar", "white", 2, 1, 2));
					deck.add(new CreatureCard("Angel of Light","white",3,2,4));
					deck.add(new CreatureCard("Cat","white",1,1,1));
					deck.add(new CreatureCard("Holy Berzerker","white" , 3,4,3));
					deck.add(new CreatureCard("Oath Bringer", "white", 2,2,1));
					deck.add(new CreatureCard("Poop the Soldier","white", 0,0,1));
					deck.add(new CreatureCard("Prophet","white",2,1,2));
					deck.add(new CreatureCard("Big Bulging Ox","white",2,0,5));
					deck.add(new CreatureCard("Jar-Jar", "white", 3, 1, 1));
					deck.add(new CreatureCard("Qucik Fox", "white","Quick Fox can attack the turn it was played", 1,1,1, "haste"));
					
					
					
				}
	
				if(colorDeck.equals("blue"))
				{
					for(int i = 0; i < 25; i++)
					{
						deck.add(new LandCard("Island", "blue"));
					}
					deck.add(new CreatureCard("Samuel Golub, Skyclave Trickster", "blue", "When Samuel Golub enters the battlefield, draw a card for each creature you control.", 6, 4, 7, "drawpercreature"));
					deck.add(new CreatureCard("Tidal Golem", "blue", 7, 5, 7));
					deck.add(new CreatureCard("Samuel Golub, Skyclave Trickster", "blue", "When Samuel Golub enters the battlefield, draw a card for each creature you control.", 6, 4, 7, "drawpercreature"));
					deck.add(new CreatureCard("Annoying Gull", "blue", 2, 1, 1));
					deck.add(new CreatureCard("Swirling Lobster", "blue", 4, 2, 3));
					deck.add(new CreatureCard("Wall of Mist", "blue", "When Wall of Mist enters the battlefield, tap target creature opponent controls.", 2, 0, 4, "tapcreature"));
					deck.add(new CreatureCard("Cobbled Lancer","blue",1,3,3));
					deck.add(new CreatureCard("Aegis Turtle","blue",1,0,5));
					deck.add(new CreatureCard("Symmetry Sage", "blue",1,0,3));
					deck.add(new CreatureCard("Eidolon of Philosophy","blue",1,1,2));
					deck.add(new CreatureCard("Expendable Lackey","blue",1,1,1));
					deck.add(new CreatureCard("Expiremental Pilot","blue",1,1,1));
					deck.add(new CreatureCard("Expiremental Pilot","blue",1,1,1));
					deck.add(new CreatureCard("Expiremental Pilot","blue",1,1,1));
					deck.add(new CreatureCard("Frost Augur","blue",1,1,2));
					deck.add(new CreatureCard("Frost Augur","blue",1,1,2));
					deck.add(new CreatureCard("Frost Augur","blue",1,1,2));
					deck.add(new CreatureCard("Larder Zombie","blue",1,0,3));
					deck.add(new CreatureCard("Aether Theorist","blue",2,1,3));
					deck.add(new CreatureCard("Backstreet Bruiser","blue",2,2,3));
					deck.add(new CreatureCard("Backstreet Bruiser","blue",2,2,3));
					deck.add(new CreatureCard("Backstreet Bruiser","blue",2,2,3));
					deck.add(new CreatureCard("Big Ass Wall","blue",5,0,12));
					deck.add(new CreatureCard("Big Ass Wall","blue",5,0,12));
					deck.add(new CreatureCard("Big Ass Wall","blue",5,0,12));
					deck.add(new CreatureCard("Rapid Swinger","blue",4,6,2));
					deck.add(new CreatureCard("Dubious Carp","blue",3,3,5));
					deck.add(new CreatureCard("The Moon's Vengence","blue",8,6,12));
					deck.add(new CreatureCard("The Moon's Vengence","blue",8,6,12));
					deck.add(new CreatureCard("Ormos, Archive Keeper","blue",6,5,5));
					deck.add(new CreatureCard("Phantom Carraige","blue",4,4,4));
					deck.add(new CreatureCard("Rapid Swinger","blue",4,6,2));	
					deck.add(new CreatureCard("Deathly Stare","blue",5,5,5));
					deck.add(new CreatureCard("Timeless Strike","blue",3,3,3));
					deck.add(new CreatureCard("Naida Magam","blue",2,2,2));
					deck.add(new CreatureCard("Screaming Swarm","blue",2,0,4));
								}
				if(colorDeck.equals("red"))
				{
					for(int i = 0; i < 25; i++)
					{
						deck.add(new LandCard("Mountain", "red"));
					}
					deck.add(new CreatureCard("John Dufour, God of Chaos", "red", "When John Dufour enters the battlefield, deal 1 damage to opponent for each creature you control.", 2, 1, 1, "damagepercreature"));
					deck.add(new CreatureCard("Mischevious Goblin", "red", 2, 2, 2));
					deck.add(new CreatureCard("Mischevious Goblin", "red", 2, 2, 2));
					deck.add(new CreatureCard("Festering Arachnid", "red", 3, 3, 2));
					deck.add(new CreatureCard("Festering Arachnid", "red", 3, 3, 2));
					deck.add(new CreatureCard("Festering Arachnid", "red", 3, 3, 2));
					deck.add(new CreatureCard("Festering Arachnid", "red", 3, 3, 2));
					deck.add(new CreatureCard("Wayward General", "red", "When Wayward General enters the battlefield, deal 3 damage to target creature.", 5, 4, 4, "3damagecreature"));
					deck.add(new CreatureCard("Wayward General", "red", "When Wayward General enters the battlefield, deal 3 damage to target creature.", 5, 4, 4, "3damagecreature"));
					deck.add(new CreatureCard("Bloody Rat", "red", 1, 1, 1));
					deck.add(new CreatureCard("Bloody Rat", "red", 1, 1, 1));
					deck.add(new CreatureCard("Quick Goblin", "red", "Quick Goblin can attack the turn it enters the battlefield", 1, 1, 1, "haste"));
					deck.add(new CreatureCard("Quick Goblin", "red", "Quick Goblin can attack the turn it enters the battlefield", 1, 1, 1, "haste"));
					deck.add(new CreatureCard("Quick Goblin", "red", "Quick Goblin can attack the turn it enters the battlefield", 1, 1, 1, "haste"));
					deck.add(new CreatureCard("Quick Goblin", "red", "Quick Goblin can attack the turn it enters the battlefield", 1, 1, 1, "haste"));
					deck.add(new CreatureCard("Coniving Creature", "red", 0, 0, 1));
					deck.add(new CreatureCard("Coniving Creature", "red", 0, 0, 1));
					deck.add(new CreatureCard("Coniving Creature", "red", 0, 0, 1));
					deck.add(new CreatureCard("Coniving Creature", "red", 0, 0, 1));
					deck.add(new CreatureCard("Towering Troll", "red", 6, 7, 5));
					deck.add(new CreatureCard("Towering Troll", "red", 6, 7, 5));
					deck.add(new CreatureCard("Towering Troll", "red", 6, 7, 5));
					deck.add(new CreatureCard("Towering Troll", "red", 6, 7, 5));
					deck.add(new CreatureCard("Burning Man", "red", 2, 3, 2));
					deck.add(new CreatureCard("Burning Man", "red", 2, 3, 2));
					deck.add(new CreatureCard("Burning Man", "red", 2, 3, 2));
					deck.add(new CreatureCard("Burning Man", "red", 2, 3, 2));
					deck.add(new CreatureCard("Mountain Troll", "red", 8, 9, 8));
					deck.add(new CreatureCard("Mountain Troll", "red", 8, 9, 8));
					deck.add(new CreatureCard("Mountain Troll", "red", 8, 9, 8));
					deck.add(new CreatureCard("Mountain Troll", "red", 8, 9, 8));
					deck.add(new CreatureCard("Tribal Goblin", "red", 4, 4, 3));
					deck.add(new CreatureCard("Tribal Goblin", "red", 4, 4, 3));
					deck.add(new CreatureCard("Tribal Goblin", "red", 4, 4, 3));
										
				}
				if(colorDeck.equals("green"))
				{
					for(int i = 0; i < 25; i++)
					{
						deck.add(new LandCard("Forest", "green"));
					}
					deck.add(new CreatureCard("Michael Sky, Greatest Of All Time", "green", "When Michael Sky enters the battlefield, put a +1/+1 counter on each creature you control.", 3, 3, 3, "+1+1percreature"));
					deck.add(new CreatureCard("Wooden Elf", "green", 4, 3, 2));
					deck.add(new CreatureCard("Treegoing Serpent", "green", 3, 2, 4));
					deck.add(new CreatureCard("Treegoing Serpent", "green", 3, 2, 4));
					deck.add(new CreatureCard("Tunnelling Miner", "green", "Tunnelling Miner can't be blocked.", 4, 1, 1, "cantbeblocked"));
					deck.add(new CreatureCard("Tunnelling Miner", "green", "Tunnelling Miner can't be blocked.", 4, 1, 1, "cantbeblocked"));
					deck.add(new CreatureCard("Trampling Bear-Fox", "green", 6, 8, 8));
					deck.add(new CreatureCard("Trampling Bear-Fox", "green", 6, 8, 8));
					deck.add(new CreatureCard("Spider Spawn", "green", 2, 1, 3));
					deck.add(new CreatureCard("Spider Queen", "green", 4, 3, 5));
					deck.add(new CreatureCard("Rallying Raider", "green", "When Rallying Raider enters the battlefield, put a +1/+1 counter on each creature you control.", 6, 2, 2, "+1+1percreature"));
					deck.add(new CreatureCard("Dominating Elf", "green", 6, 8, 4));
					deck.add(new CreatureCard("Fast Bear", "green", "Fast Bear can attack the turn it enters the battlefield", 4, 4, 3, "haste"));
					deck.add(new CreatureCard("Fast Bear", "green", "Fast Bear can attack the turn it enters the battlefield", 4, 4, 3, "haste"));
					deck.add(new CreatureCard("Junior Koala", "green", 1, 1, 1));
					deck.add(new CreatureCard("Junior Koala", "green", 1, 1, 1));
					deck.add(new CreatureCard("Junior Koala", "green", 1, 1, 1));
					deck.add(new CreatureCard("Junior Koala", "green", 1, 1, 1));
					deck.add(new CreatureCard("Lazy Sloth", "green", 1, 0, 4));
					deck.add(new CreatureCard("Lazy Sloth", "green", 1, 0, 4));
					deck.add(new CreatureCard("Lumbering Giant", "green", 8, 8, 8));
					deck.add(new CreatureCard("Lumbering Giant", "green", 8, 8, 8));
					deck.add(new CreatureCard("Dominating Elf", "green", 6, 8, 4));
					deck.add(new CreatureCard("Dominating Elf", "green", 6, 8, 4));
					deck.add(new CreatureCard("Babbling Ape", "green", 3, 3, 3));
					deck.add(new CreatureCard("Babbling Ape", "green", 3, 3, 3));
					deck.add(new CreatureCard("Babbling Ape", "green", 3, 3, 3));
					deck.add(new CreatureCard("Babbling Ape", "green", 3, 3, 3));
					deck.add(new CreatureCard("Imposta Monkey", "green", 2, 2,2));
					deck.add(new CreatureCard("Imposta Monkey", "green", 2, 2,2));
					deck.add(new CreatureCard("Imposta Monkey", "green", 2, 2,2));
					deck.add(new CreatureCard("Imposta Monkey", "green", 2, 2,2));
					deck.add(new CreatureCard("Simple Wurm", "green", 0, 0, 1));
					deck.add(new CreatureCard("Simple Wurm", "green", 0, 0, 1));
					deck.add(new CreatureCard("Dominating Elf", "green", 6, 8, 4));
				
					
					
				}
				if(colorDeck.equals("black"))
				{
					for(int i = 0; i < 25; i++)
					{
						deck.add(new LandCard("Swamp", "black"));
					}
					deck.add(new CreatureCard("Mr. Ellis, Devouring Chaos", "black", "When Mr. Ellis enters the battlefield, destroy all other creatures.", 7, 5, 5, "destroyothercreatures"));		}
					deck.add(new CreatureCard("Spirit Eater", "black", 3, 1, 2));
					deck.add(new CreatureCard("Horrifying Ghost", "black", 2, 2, 1));
					deck.add(new CreatureCard("Screeching Witch", "black", "When Screeching Witch enters the battlefield, tap all opponent creatures.", 6, 1, 1, "tapopponentcreatures"));
					deck.add(new CreatureCard("Undead Horde", "black", 7, 5, 7));
	}
	
	public ArrayList<Card> getHand()
	{
		return hand;
	}
	
	public void draw()
	{
		hand.add(deck.get(0));
		deck.remove(0);
	}
	
	public void draw(int num)
	{
		for(int i = 0; i < num; i++)
		{
			hand.add(deck.get(0));
			deck.remove(0);
		}
	}
	public int numCardsInDeck()
	{
		return deck.size();
	}
	
	public Card getRandomCardFromDeck()
	{
		int index = (int) (Math.random() * deck.size());
		return deck.get(index);
	}
	
	public Card getRandomCardFromHand()
	{
		int index = (int) (Math.random() * this.numCardsInHand());
		return hand.get(index);
	}
	public int getIndexOfCard(Card target)
	{
		int index = -1;
	
		for(int i = 0; i < hand.size(); i++)
		{
			
			if(hand.get(i).getName().equals(target.getName()))
			{
				index = i;
			}
		}
		return index;
	
		
	}
	public Card getCardFromHand(int index)
	{
		return hand.get(index);
	}
	
	public int numCardsInHand()
	{
		return hand.size();
	}
	
	public int getAvailableMana()
	{
		return availableMana;
	}
	public int getDeckSize()
	{
		return deck.size();
	}
	
	public void setAvailableMana(int num)
	{
		availableMana = num;
	}
	
	public void incrementAvailableMana()
	{
		availableMana++;
	}
	
	public void incrementAvailableMana(int num)
	{
		availableMana += num;
	}
	
	public int getLife()
	{
		return life;
	}
	
	public void setLife(int num)
	{
		life = num;
	}
	
	public void incrementLife()
	{
		life++;
	}
	
	public void incrementLife(int num)
	{
		life += num;
	}
	
	public void addCardToHand(Card c)
	{
		hand.add(c);
	}
	
	public void discard(int index)
	{
		hand.remove(index);
	}
	
	public void shuffle()
	{
		for (int i = 0; i < deck.size(); i++)
		{
			Card card1 = deck.get(i);
			int index = (int) (Math.random() * 60);
			Card card2 = deck.get(index);
			deck.set(index, card1);
			deck.set(i, card2);
		}
	}
	
	
	
	
	
	
	
	
	

	
	
}









