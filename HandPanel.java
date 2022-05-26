import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class HandPanel extends JLayeredPane
{
	private ArrayList<CardSleeve> hand;
	private Dimension screen;
	private TestGUI frame;
	private GameObject2 game;
	
	public HandPanel(TestGUI frame, GameObject2 game)
	{
		this.frame = frame;
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screen);
		this.setLocation(0,0);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setVisible(true);
		
		hand = new ArrayList<CardSleeve>();
		for (int i = 0; i < 7; i++)
		{
			hand.add(new CardSleeve(this, game.getPlayer1().getHand().get(i)));
		}
		this.arrangeCards();
		
	}
	
	public void arrangeCards()
	{
		this.removeAll(); //clear the screen for reset
		
		//width is 850, start is 300, end is 1100
		int spacer = 850 / hand.size();
		
		int start = 250;
		for (int i = 0; i < hand.size(); i++)
		{
			this.add(hand.get(i), i);
			hand.get(i).setLocation(start + (spacer * i), (int) screen.getHeight() - 150);
			frame.repaint();
		}
	}
	
	public void addCardtoHand(Card card)
	{
		hand.add(new CardSleeve(this, card));
	}
	public void addCardstoHand(ArrayList<Card> cards)
	{
		for (int i = 0; i < cards.size(); i++)
		{
			hand.add(new CardSleeve(this, cards.get(i)));
		}
	}

}
