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
	}
	public void fillDeck(String colorDeck)
	{
				if(colorDeck.equals("white"))
				{
					for(int i = 0; i < 25; i++)
					{
						deck.add(new LandCard(false, "white"));
					}
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
	
	
	
	
	
	
	
	
	

	
	
}










