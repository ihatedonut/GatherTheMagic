import java.util.ArrayList;

public class Player 
{
	private int life;
	private ArrayList<Card> hand;
	private ArrayList<Card> deck;
	private ArrayList<Card> graveyard;
	private int availableMana;
	private final int MAXHANDSIZE = 7;
	private int landPlays;
	private ArrayList<Card> allCards;
	
	public Player()
	{
		life = 20;
		hand = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		allCards = new ArrayList<Card>();
		availableMana = 0;
		landPlays = 1;
		
		allCards.add(new CreatureCard("John Dufour, God of Chaos", "red", "When John Dufour enters the battlefield, deal 1 damage to opponent for each creature you control.", 2, 1, 1, "damagepercreature"));
		allCards.add(new CreatureCard("Mischevious Goblin", "red", 2, 2, 2));
		allCards.add(new CreatureCard("Mischevious Goblin", "red", 2, 2, 2));
		allCards.add(new CreatureCard("Festering Arachnid", "red", 3, 3, 2));
		allCards.add(new CreatureCard("Festering Arachnid", "red", 3, 3, 2));
		allCards.add(new CreatureCard("Festering Arachnid", "red", 3, 3, 2));
		allCards.add(new CreatureCard("Festering Arachnid", "red", 3, 3, 2));
		allCards.add(new CreatureCard("Wayward General", "red", "When Wayward General enters the battlefield, deal 3 damage to target creature.", 5, 4, 4, "3damagecreature"));
		allCards.add(new CreatureCard("Wayward General", "red", "When Wayward General enters the battlefield, deal 3 damage to target creature.", 5, 4, 4, "3damagecreature"));
		allCards.add(new CreatureCard("Bloody Rat", "red", 1, 1, 1));
		allCards.add(new CreatureCard("Bloody Rat", "red", 1, 1, 1));
		allCards.add(new CreatureCard("Quick Goblin", "red", "Quick Goblin can attack the turn it enters the battlefield", 1, 1, 1, "haste"));
		allCards.add(new CreatureCard("Quick Goblin", "red", "Quick Goblin can attack the turn it enters the battlefield", 1, 1, 1, "haste"));
		allCards.add(new CreatureCard("Quick Goblin", "red", "Quick Goblin can attack the turn it enters the battlefield", 1, 1, 1, "haste"));
		allCards.add(new CreatureCard("Quick Goblin", "red", "Quick Goblin can attack the turn it enters the battlefield", 1, 1, 1, "haste"));
		allCards.add(new CreatureCard("Coniving Creature", "red", 0, 0, 1));
		allCards.add(new CreatureCard("Coniving Creature", "red", 0, 0, 1));
		allCards.add(new CreatureCard("Coniving Creature", "red", 0, 0, 1));
		allCards.add(new CreatureCard("Coniving Creature", "red", 0, 0, 1));
		allCards.add(new CreatureCard("Towering Troll", "red", 6, 7, 5));
		allCards.add(new CreatureCard("Towering Troll", "red", 6, 7, 5));
		allCards.add(new CreatureCard("Towering Troll", "red", 6, 7, 5));
		allCards.add(new CreatureCard("Towering Troll", "red", 6, 7, 5));
		allCards.add(new CreatureCard("Burning Man", "red", 2, 3, 2));
		allCards.add(new CreatureCard("Burning Man", "red", 2, 3, 2));
		allCards.add(new CreatureCard("Burning Man", "red", 2, 3, 2));
		allCards.add(new CreatureCard("Burning Man", "red", 2, 3, 2));
		allCards.add(new CreatureCard("Mountain Troll", "red", 8, 9, 8));
		allCards.add(new CreatureCard("Mountain Troll", "red", 8, 9, 8));
		allCards.add(new CreatureCard("Mountain Troll", "red", 8, 9, 8));
		allCards.add(new CreatureCard("Mountain Troll", "red", 8, 9, 8));
		allCards.add(new CreatureCard("Tribal Goblin", "red", 4, 4, 3));
		allCards.add(new CreatureCard("Tribal Goblin", "red", 4, 4, 3));
		allCards.add(new CreatureCard("Tribal Goblin", "red", 4, 4, 3));
		allCards.add(new CreatureCard("Samuel Golub, Skyclave Trickster", "blue", "When Samuel Golub enters the battlefield, draw a card for each creature you control.", 6, 4, 7, "drawpercreature"));
		allCards.add(new CreatureCard("Tidal Golem", "blue", 7, 5, 7));
		allCards.add(new CreatureCard("Annoying Gull", "blue", 2, 1, 1));
		allCards.add(new CreatureCard("Swirling Lobster", "blue", 4, 2, 3));
		allCards.add(new CreatureCard("Swirling Lobster", "blue", 4, 2, 3));
		allCards.add(new CreatureCard("Wall of Mist", "blue", "When Wall of Mist enters the battlefield, tap target creature opponent controls.", 2, 0, 4, "tapcreature"));
		allCards.add(new CreatureCard("Cobbled Lancer","blue",1,3,3));
		allCards.add(new CreatureCard("Aegis Turtle","blue",1,0,5));
		allCards.add(new CreatureCard("Symmetry Sage", "blue",1,0,3));
		allCards.add(new CreatureCard("Eidolon of Philosophy","blue",1,1,2));
		allCards.add(new CreatureCard("Expendable Lackey","blue",1,1,1));
		allCards.add(new CreatureCard("Expiremental Pilot","blue",1,1,1));
		allCards.add(new CreatureCard("Expiremental Pilot","blue",1,1,1));
		allCards.add(new CreatureCard("Frost Augur","blue",1,1,2));
		allCards.add(new CreatureCard("Frost Augur","blue",1,1,2));
		allCards.add(new CreatureCard("Frost Augur","blue",1,1,2));
		allCards.add(new CreatureCard("Larder Zombie","blue",1,0,3));
		allCards.add(new CreatureCard("Aether Theorist","blue",2,1,3));
		allCards.add(new CreatureCard("Backstreet Bruiser","blue",2,2,3));
		allCards.add(new CreatureCard("Backstreet Bruiser","blue",2,2,3));
		allCards.add(new CreatureCard("Backstreet Bruiser","blue",2,2,3));
		allCards.add(new CreatureCard("Big Ass Wall","blue",5,0,12));
		allCards.add(new CreatureCard("Big Ass Wall","blue",5,0,12));
		allCards.add(new CreatureCard("Big Ass Wall","blue",5,0,12));
		allCards.add(new CreatureCard("Rapid Swinger","blue",4,6,2));
		allCards.add(new CreatureCard("Dubious Carp","blue",3,3,5));
		allCards.add(new CreatureCard("The Moon's Vengence","blue",8,6,12));
		allCards.add(new CreatureCard("The Moon's Vengence","blue",8,6,12));
		allCards.add(new CreatureCard("Ormos, Archive Keeper","blue",6,5,5));
		allCards.add(new CreatureCard("Phantom Carraige","When Phantom Carraige enters the battlefield, draw a card.","blue",4,3,3,"draw"));
		allCards.add(new CreatureCard("Rapid Swinger","blue",4,6,2));	
		allCards.add(new CreatureCard("Deathly Stare","blue",5,5,5));
		allCards.add(new CreatureCard("Timeless Strike","blue",3,3,3));
		allCards.add(new CreatureCard("Naida Magam","blue",2,2,2));
		allCards.add(new CreatureCard("Screaming Swarm","blue",2,0,4));
		allCards.add(new CreatureCard("Aidan Gamma, Thunderous Cleric", "white", "When Aidan Gamma enters the battlefield, gain 1 life for each creature you control.", 4, 2, 3, "gainlifepercreature"));
		allCards.add(new CreatureCard("Astral Unicorn", "white", 3, 2, 3));
		allCards.add(new CreatureCard("Monk of Familiarity", "white", "When Monk of Familiarity enters the battlefield, return target creature to it's owners hand.", 3, 2, 2, "returncreature"));
		allCards.add(new CreatureCard("Monk of Familiarity", "white", "When Monk of Familiarity enters the battlefield, return target creature to it's owners hand.", 3, 2, 2, "returncreature"));
		allCards.add(new CreatureCard("Monk of Familiarity", "white", "When Monk of Familiarity enters the battlefield, return target creature to it's owners hand.", 3, 2, 2, "returncreature"));
		allCards.add(new CreatureCard("Usher of the Ageless", "white", 5, 4, 3));
		allCards.add(new CreatureCard("Usher of the Ageless", "white", 5, 4, 3));
		allCards.add(new CreatureCard("Usher of the Ageless", "white", 5, 4, 3));
		allCards.add(new CreatureCard("Unholy Beggar", "white", 2, 1, 2));
		allCards.add(new CreatureCard("Angel of Light","white",3,2,4));
		allCards.add(new CreatureCard("Angel of Light","white",3,2,4));
		allCards.add(new CreatureCard("Angel of Light","white",3,2,4));
		allCards.add(new CreatureCard("Angel of Light","white",3,2,4));
		allCards.add(new CreatureCard("Light Cat","white",1,1,1));
		allCards.add(new CreatureCard("Light Cat","white",1,1,1));
		allCards.add(new CreatureCard("Light Cat","white",1,1,1));
		allCards.add(new CreatureCard("Light Cat","white",1,1,1));
		allCards.add(new CreatureCard("Holy Berzerker","white" , 3,4,3));
		allCards.add(new CreatureCard("Holy Berzerker","white" , 3,4,3));
		allCards.add(new CreatureCard("Holy Berzerker","white" , 3,4,3));
		allCards.add(new CreatureCard("Holy Berzerker","white" , 3,4,3));
		allCards.add(new CreatureCard("Oath Bringer", "white", 2,2,1));
		allCards.add(new CreatureCard("Poop Soldier","white", 0,0,1));
		allCards.add(new CreatureCard("Poop Soldier","white", 0,0,1));
		allCards.add(new CreatureCard("Prophet","white",2,1,2));
		allCards.add(new CreatureCard("Big Bulging Ox","white",2,0,5));
		allCards.add(new CreatureCard("Big Bulging Ox","white",2,0,5));
		allCards.add(new CreatureCard("Big Bulging Ox","white",2,0,5));
		allCards.add(new CreatureCard("Big Bulging Ox","white",2,0,5));
		allCards.add(new CreatureCard("Jar-Jar", "white", 3, 1, 1));
		allCards.add(new CreatureCard("Quick Fox", "white","Quick Fox can attack the turn it was played", 1,1,1, "haste"));
		allCards.add(new CreatureCard("Quick Fox", "white","Quick Fox can attack the turn it was played", 1,1,1, "haste"));
		allCards.add(new CreatureCard("Holy Soldier","white" , 4,4,4));
		allCards.add(new CreatureCard("Holy Soldier","white" , 4,4,4));
		allCards.add(new CreatureCard("Holy Soldier","white" , 4,4,4));
		allCards.add(new CreatureCard("Michael Sky, Greatest Of All Time", "green", "When Michael Sky enters the battlefield, put a +1/+1 counter on each creature you control.", 3, 3, 3, "+1+1percreature"));
		allCards.add(new CreatureCard("Wooden Elf", "green", 4, 3, 2));
		allCards.add(new CreatureCard("Treegoing Serpent", "green", 3, 2, 4));
		allCards.add(new CreatureCard("Treegoing Serpent", "green", 3, 2, 4));
		allCards.add(new CreatureCard("Tunneling Miner", "green", "Tunnelling Miner can't be blocked.", 4, 1, 1, "cantbeblocked"));
		allCards.add(new CreatureCard("Tunneling Miner", "green", "Tunnelling Miner can't be blocked.", 4, 1, 1, "cantbeblocked"));
		allCards.add(new CreatureCard("Trampling Bear-Fox", "green", 6, 8, 8));
		allCards.add(new CreatureCard("Trampling Bear-Fox", "green", 6, 8, 8));
		allCards.add(new CreatureCard("Spider Spawn", "green", 2, 1, 3));
		allCards.add(new CreatureCard("Spider Queen", "green", 4, 3, 5));
		allCards.add(new CreatureCard("Rallying Raider", "green", "When Rallying Raider enters the battlefield, put a +1/+1 counter on each creature you control.", 6, 2, 2, "+1+1percreature"));
		allCards.add(new CreatureCard("Dominating Elf", "green", 6, 8, 4));
		allCards.add(new CreatureCard("Fast Bear", "green", "Fast Bear can attack the turn it enters the battlefield", 4, 4, 3, "haste"));
		allCards.add(new CreatureCard("Fast Bear", "green", "Fast Bear can attack the turn it enters the battlefield", 4, 4, 3, "haste"));
		allCards.add(new CreatureCard("Junior Koala", "green", 1, 1, 1));
		allCards.add(new CreatureCard("Junior Koala", "green", 1, 1, 1));
		allCards.add(new CreatureCard("Junior Koala", "green", 1, 1, 1));
		allCards.add(new CreatureCard("Junior Koala", "green", 1, 1, 1));
		allCards.add(new CreatureCard("Lazy Sloth", "green", 1, 0, 4));
		allCards.add(new CreatureCard("Lazy Sloth", "green", 1, 0, 4));
		allCards.add(new CreatureCard("Lumbering Giant", "green", 8, 8, 8));
		allCards.add(new CreatureCard("Lumbering Giant", "green", 8, 8, 8));
		allCards.add(new CreatureCard("Dominating Elf", "green", 6, 8, 4));
		allCards.add(new CreatureCard("Dominating Elf", "green", 6, 8, 4));
		allCards.add(new CreatureCard("Babbling Ape", "green", 3, 3, 3));
		allCards.add(new CreatureCard("Babbling Ape", "green", 3, 3, 3));
		allCards.add(new CreatureCard("Babbling Ape", "green", 3, 3, 3));
		allCards.add(new CreatureCard("Babbling Ape", "green", 3, 3, 3));
		allCards.add(new CreatureCard("Imposta Monkey", "green", 2, 2,2));
		allCards.add(new CreatureCard("Imposta Monkey", "green", 2, 2,2));
		allCards.add(new CreatureCard("Imposta Monkey", "green", 2, 2,2));
		allCards.add(new CreatureCard("Imposta Monkey", "green", 2, 2,2));
		allCards.add(new CreatureCard("Simple Wurm", "green", 0, 0, 1));
		allCards.add(new CreatureCard("Simple Wurm", "green", 0, 0, 1));
		allCards.add(new CreatureCard("Dominating Elf", "green", 6, 8, 4));
		allCards.add(new CreatureCard("Mr. Ellis, Devouring Chaos", "black", "When Mr. Ellis enters the battlefield, destroy all other creatures.", 7, 5, 5, "destroyothercreatures"));		
		allCards.add(new CreatureCard("Spirit Eater", "black", 3, 1, 2));
		allCards.add(new CreatureCard("Spirit Eater", "black", 3, 1, 2));
		allCards.add(new CreatureCard("Horrifying Ghost", "black", 2, 2, 1));
		allCards.add(new CreatureCard("Screeching Witch", "black", "When Screeching Witch enters the battlefield, tap all opponent creatures.", 6, 1, 1, "tapopponentcreatures"));
		allCards.add(new CreatureCard("Undead Horde", "black", 7, 5, 7));
		allCards.add(new CreatureCard("Archfiend's Vessel","black",1,1,1));
		allCards.add(new CreatureCard("Banehound","black",1,1,1));
		allCards.add(new CreatureCard("Lone Zombie", "black",1,2,1));
		allCards.add(new CreatureCard("Lone Zombie", "black",1,2,1));
		allCards.add(new CreatureCard("Lone Zombie", "black",1,2,1));
		allCards.add(new CreatureCard("Lone Zombie", "black",1,2,1));
		allCards.add(new CreatureCard("Concealing Curtains","black",1,0,4));
		allCards.add(new CreatureCard("Changeling Outcast","black",2,2,2));
		allCards.add(new CreatureCard("Elderfang Ritualist","black",2,3,1));
		allCards.add(new CreatureCard("Skemfar Avenger","black",3,3,2));
		allCards.add(new CreatureCard("Sepulchar Ghoul","black",2,2,2));
		allCards.add(new CreatureCard("Asylum Visitor","When Asylum Visitor enters the battlefield, draw a card.","black",3,2,2,"draw"));
		allCards.add(new CreatureCard("BlackLance Paragon","black",2,3,2));
		allCards.add(new CreatureCard("Alley Strangler","black",3,4,2));
		allCards.add(new CreatureCard("Ammit Eternal","black",3,4,4));
		allCards.add(new CreatureCard("Angrath's Ambusher","black",3,2,3));
		allCards.add(new CreatureCard("Thornmantle Striker","black",4,4,3));
		allCards.add(new CreatureCard("Bloodsworn Squire","black",4,3,3));
		allCards.add(new CreatureCard("Bloodhunter Bat","When Bloodhunter Bat enters the battlefield, draw a card.","black",4,2,2,"draw3"));
		allCards.add(new CreatureCard("Anointed Deacon","black",5,5,3));
		allCards.add(new CreatureCard("Silent Knife","black",5,8,2));
		allCards.add(new CreatureCard("Silent Knife","black",5,8,2));
		allCards.add(new CreatureCard("Blade juggler","black",5,4,3));
		allCards.add(new CreatureCard("Dark Commander","When Dark Commander enters the battlfield, put a +1/+1 counter on all creature cards.","black",5,2,2,"p1p1"));
		allCards.add(new CreatureCard("Dark Commander","When Dark Commander enters the battlfield, put a +1/+1 counter on all creature cards.","black",5,2,2,"p1p1"));
		allCards.add(new CreatureCard("Baleful Beholder","black",6,6,5));
		allCards.add(new CreatureCard("Asmodeus the Archfiend","When Asmodeus the Archfiend enters the battlefield, draw a card.","black",7,6,6,"draw"));
		allCards.add(new CreatureCard("Bogstomper","black",6,7,6));
		allCards.add(new CreatureCard("Void Beckoner","black",8,8,8));
	
	
	}
	
	public void fillDeck(String colorDeck)
	{
				if (deck.size() > 0)
				{
					deck.removeAll(deck);
				}
				if(colorDeck.equals("white"))
				{
					for(int i = 0; i < 25; i++)
					{
						deck.add(new LandCard("Plains", "white"));
					}
					deck.add(new CreatureCard("Aidan Gamma, Thunderous Cleric", "white", "When Aidan Gamma enters the battlefield, gain 1 life for each creature you control.", 4, 2, 3, "gainlifepercreature"));
					deck.add(new CreatureCard("Astral Unicorn", "white", 3, 2, 3));
					deck.add(new CreatureCard("Monk of Familiarity", "white", "When Monk of Familiarity enters the battlefield, return target creature to it's owners hand.", 3, 2, 2, "returncreature"));
					deck.add(new CreatureCard("Monk of Familiarity", "white", "When Monk of Familiarity enters the battlefield, return target creature to it's owners hand.", 3, 2, 2, "returncreature"));
					deck.add(new CreatureCard("Monk of Familiarity", "white", "When Monk of Familiarity enters the battlefield, return target creature to it's owners hand.", 3, 2, 2, "returncreature"));
					deck.add(new CreatureCard("Usher of the Ageless", "white", 5, 4, 3));
					deck.add(new CreatureCard("Usher of the Ageless", "white", 5, 4, 3));
					deck.add(new CreatureCard("Usher of the Ageless", "white", 5, 4, 3));
					deck.add(new CreatureCard("Unholy Beggar", "white", 2, 1, 2));
					deck.add(new CreatureCard("Angel of Light","white",3,2,4));
					deck.add(new CreatureCard("Angel of Light","white",3,2,4));
					deck.add(new CreatureCard("Angel of Light","white",3,2,4));
					deck.add(new CreatureCard("Angel of Light","white",3,2,4));
					deck.add(new CreatureCard("Light Cat","white",1,1,1));
					deck.add(new CreatureCard("Light Cat","white",1,1,1));
					deck.add(new CreatureCard("Light Cat","white",1,1,1));
					deck.add(new CreatureCard("Light Cat","white",1,1,1));
					deck.add(new CreatureCard("Holy Berzerker","white" , 3,4,3));
					deck.add(new CreatureCard("Holy Berzerker","white" , 3,4,3));
					deck.add(new CreatureCard("Holy Berzerker","white" , 3,4,3));
					deck.add(new CreatureCard("Holy Berzerker","white" , 3,4,3));
					deck.add(new CreatureCard("Oath Bringer", "white", 2,2,1));
					deck.add(new CreatureCard("Poop Soldier","white", 0,0,1));
					deck.add(new CreatureCard("Poop Soldier","white", 0,0,1));
					deck.add(new CreatureCard("Prophet","white",2,1,2));
					deck.add(new CreatureCard("Big Bulging Ox","white",2,0,5));
					deck.add(new CreatureCard("Big Bulging Ox","white",2,0,5));
					deck.add(new CreatureCard("Big Bulging Ox","white",2,0,5));
					deck.add(new CreatureCard("Big Bulging Ox","white",2,0,5));
					deck.add(new CreatureCard("Jar-Jar", "white", 3, 1, 1));
					deck.add(new CreatureCard("Quick Fox", "white","Quick Fox can attack the turn it was played", 1,1,1, "haste"));
					deck.add(new CreatureCard("Quick Fox", "white","Quick Fox can attack the turn it was played", 1,1,1, "haste"));
					deck.add(new CreatureCard("Holy Soldier","white" , 4,4,4));
					deck.add(new CreatureCard("Holy Soldier","white" , 4,4,4));
					deck.add(new CreatureCard("Holy Soldier","white" , 4,4,4));
				}
	
				else if(colorDeck.equals("blue"))
				{
					for(int i = 0; i < 25; i++)
					{
						deck.add(new LandCard("Island", "blue"));
					}
					deck.add(new CreatureCard("Samuel Golub, Skyclave Trickster", "blue", "When Samuel Golub enters the battlefield, draw a card for each creature you control.", 6, 4, 7, "drawpercreature"));
					deck.add(new CreatureCard("Tidal Golem", "blue", 7, 5, 7));
					deck.add(new CreatureCard("Annoying Gull", "blue", 2, 1, 1));
					deck.add(new CreatureCard("Swirling Lobster", "blue", 4, 2, 3));
					deck.add(new CreatureCard("Swirling Lobster", "blue", 4, 2, 3));
					deck.add(new CreatureCard("Wall of Mist", "blue", "When Wall of Mist enters the battlefield, tap target creature opponent controls.", 2, 0, 4, "tapcreature"));
					deck.add(new CreatureCard("Cobbled Lancer","blue",1,3,3));
					deck.add(new CreatureCard("Aegis Turtle","blue",1,0,5));
					deck.add(new CreatureCard("Symmetry Sage", "blue",1,0,3));
					deck.add(new CreatureCard("Eidolon of Philosophy","blue",1,1,2));
					deck.add(new CreatureCard("Expendable Lackey","blue",1,1,1));
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
					deck.add(new CreatureCard("Phantom Carraige","When Phantom Carraige enters the battlefield, draw a card.","blue",4,3,3,"draw"));
					deck.add(new CreatureCard("Rapid Swinger","blue",4,6,2));	
					deck.add(new CreatureCard("Deathly Stare","blue",5,5,5));
					deck.add(new CreatureCard("Timeless Strike","blue",3,3,3));
					deck.add(new CreatureCard("Naida Magam","blue",2,2,2));
					deck.add(new CreatureCard("Screaming Swarm","blue",2,0,4));
				}
				else if(colorDeck.equals("red"))
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
				else if(colorDeck.equals("green"))
				{
					for(int i = 0; i < 25; i++)
					{
						deck.add(new LandCard("Forest", "green"));
					}
					deck.add(new CreatureCard("Michael Sky, Greatest Of All Time", "green", "When Michael Sky enters the battlefield, put a +1/+1 counter on each creature you control.", 3, 3, 3, "+1+1percreature"));
					deck.add(new CreatureCard("Wooden Elf", "green", 4, 3, 2));
					deck.add(new CreatureCard("Treegoing Serpent", "green", 3, 2, 4));
					deck.add(new CreatureCard("Treegoing Serpent", "green", 3, 2, 4));
					deck.add(new CreatureCard("Tunneling Miner", "green", "Tunnelling Miner can't be blocked.", 4, 1, 1, "cantbeblocked"));
					deck.add(new CreatureCard("Tunneling Miner", "green", "Tunnelling Miner can't be blocked.", 4, 1, 1, "cantbeblocked"));
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
				else if(colorDeck.equals("black"))
				{
					
					for(int i = 0; i < 25; i++)
					{
						deck.add(new LandCard("Swamp", "black"));
					}
					deck.add(new CreatureCard("Mr. Ellis, Devouring Chaos", "black", "When Mr. Ellis enters the battlefield, destroy all other creatures.", 7, 5, 5, "destroyothercreatures"));		
					deck.add(new CreatureCard("Spirit Eater", "black", 3, 1, 2));
					deck.add(new CreatureCard("Spirit Eater", "black", 3, 1, 2));
					deck.add(new CreatureCard("Horrifying Ghost", "black", 2, 2, 1));
					deck.add(new CreatureCard("Screeching Witch", "black", "When Screeching Witch enters the battlefield, tap all opponent creatures.", 6, 1, 1, "tapopponentcreatures"));
					deck.add(new CreatureCard("Undead Horde", "black", 7, 5, 7));
					deck.add(new CreatureCard("Archfiend's Vessel","black",1,1,1));
					deck.add(new CreatureCard("Banehound","black",1,1,1));
					deck.add(new CreatureCard("Lone Zombie", "black",1,2,1));
					deck.add(new CreatureCard("Lone Zombie", "black",1,2,1));
					deck.add(new CreatureCard("Lone Zombie", "black",1,2,1));
					deck.add(new CreatureCard("Lone Zombie", "black",1,2,1));
					deck.add(new CreatureCard("Concealing Curtains","black",1,0,4));
					deck.add(new CreatureCard("Changeling Outcast","black",2,2,2));
					deck.add(new CreatureCard("Elderfang Ritualist","black",2,3,1));
					deck.add(new CreatureCard("Skemfar Avenger","black",3,3,2));
					deck.add(new CreatureCard("Sepulchar Ghoul","black",2,2,2));
					deck.add(new CreatureCard("Asylum Visitor","When Asylum Visitor enters the battlefield, draw a card.","black",3,2,2,"draw"));
					deck.add(new CreatureCard("BlackLance Paragon","black",2,3,2));
					deck.add(new CreatureCard("Alley Strangler","black",3,4,2));
					deck.add(new CreatureCard("Ammit Eternal","black",3,4,4));
					deck.add(new CreatureCard("Angrath's Ambusher","black",3,2,3));
					deck.add(new CreatureCard("Thornmantle Striker","black",4,4,3));
					deck.add(new CreatureCard("Bloodsworn Squire","black",4,3,3));
					deck.add(new CreatureCard("Bloodhunter Bat","When Bloodhunter Bat enters the battlefieldd, draw 1 card.","black",4,2,2,"draw"));
					deck.add(new CreatureCard("Anointed Deacon","black",5,5,3));
					deck.add(new CreatureCard("Silent Knife","black",5,8,2));
					deck.add(new CreatureCard("Silent Knife","black",5,8,2));
					deck.add(new CreatureCard("Blade juggler","black",5,4,3));
					deck.add(new CreatureCard("Dark Commander","When Dark Commander enters the battlfield, put a +1/+1 counter on all creature cards.","black",5,2,2,"p1p1"));
					deck.add(new CreatureCard("Dark Commander","When Dark Commander enters the battlfield, put a +1/+1 counter on all creature cards.","black",5,2,2,"p1p1"));
					deck.add(new CreatureCard("Baleful Beholder","black",6,6,5));
					deck.add(new CreatureCard("Asmodeus the Archfiend","When Asmodeus the Archfiend enters the battlefield, draw a card.","black",7,6,6,"draw3"));
					deck.add(new CreatureCard("Bogstomper","black",6,7,6));
					deck.add(new CreatureCard("Void Beckoner","black",8,8,8));
				}
				this.shuffle();
				this.setNewHand();
	}

			
	public void setNewHand()
	{
		for (int i = 0; i < 3; i++)
		{
			int index = -1;
			for (int j = 0; j < deck.size(); j++)
			{
				if (deck.get(j) instanceof LandCard)
				{
					index = j;
				}
			}
			if (index != -1)
			{
				hand.add(deck.remove(index));
			}
		}
		for (int i = 0; i < 4; i++)
		{
			int index = 0;
			while (!(deck.get(index) instanceof CreatureCard))
			{
				index = (int) (Math.random() * deck.size());
			}
			hand.add(deck.remove(index));
		}
	}
	
	public ArrayList<Card> getHand()
	{
		return hand;
	}
	
	public Card draw()
	{
		Card card = deck.get(0);
		hand.add(deck.remove(0));
		return card;
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
	public void decrementLife()
	{
		life--;
	}
	public void decrementLife(int num)
	{
		life -= num;
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
			int index = (int) (Math.random() * 59);
			Card card2 = deck.get(index);
			deck.set(index, card1);
			deck.set(i, card2);
		}
	}
	public int getLandPlays()
	{
		return landPlays;
	}
	public void setLandPlays(int num)
	{
		landPlays = num;
	}
	public void incrementLandPlays()
	{
		landPlays++;
	}
	public void decrementLandPlays()
	{
		landPlays--;
	}
	
	public Card cardLookup(String cardName)
	{
		for (Card c: allCards)
		{
			if (c.getName().equals(cardName))
			{
				return c;
			}
		}
		return null;
	}
	
	
	
	
	
	
	

	
	
}








