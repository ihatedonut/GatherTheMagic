import java.util.ArrayList;

public class Player 
{
	private int life;
	private ArrayList<Card> hand;
	private ArrayList<Card> deck;
	private int availableMana;
	private final int MAXHANDSIZE = 7;
	
	public Player(String colorDeck)
	{
		life = 20;
		hand = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		
		//deck array filler
		if(colorDeck.equals("white"))
		{
			for(int i = 0; i < 25; i++)
			{
				deck.add(new LandCard(false, "white"));
			}
			deck.add(new CreatureCard())
		}
		if(colorDeck.equals("blue"))
		{
			for(int i = 0; i < 25; i++)
			{
				deck.add(new LandCard(false, "blue"));
			}
		}
		if(colorDeck.equals("red"))
		{
			for(int i = 0; i < 25; i++)
			{
				deck.add(new LandCard(false, "red"));
			}
		}
		if(colorDeck.equals("green"))
		{
			for(int i = 0; i < 25; i++)
			{
				deck.add(new LandCard(false, "green"));
			}
		}
		if(colorDeck.equals("black"))
		{
			for(int i = 0; i < 25; i++)
			{
				deck.add(new LandCard(false, "black"));
			}
		}
		//decks have been created past this point
		for(int i = 0; i < 7; i++)
		{
			hand.add(new LandCard(false, "white"));
		}
		
		
		
		
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
	
	public Card getRandomCardFromHand()
	{
		int index = (int) (Math.random() * this.numCardsInHand());
		System.out.println(index);	
		return hand.get(index);
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
	
	
	
	
	
	
	
	
	

	
	
}










