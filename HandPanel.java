import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;

public class HandPanel extends JLayeredPane
{
	private ArrayList<CardSleeve> hand;
	private Dimension screen;
	private TestGUI frame;
	private GameObject2 game;
	private Battlefield battlefield;
	private BattlefieldPanel batPanel;
	private BattlefieldPanel batPanel2;
	private CardSleeve3 shownCard;
	private boolean inPanel;
	
	public HandPanel(TestGUI frame, GameObject2 game, Battlefield battlefield, BattlefieldPanel batPanel, BattlefieldPanel batPanel2,Client c)
	{
		
		this.battlefield = battlefield;
		this.batPanel = batPanel;
		this.batPanel2 = batPanel2;
		this.frame = frame;
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screen);
		this.setLocation(0,0);
		this.setVisible(true);
		this.game = game;
		hand = new ArrayList<CardSleeve>();
		for (int i = 0; i < 7; i++)
		{
			hand.add(new CardSleeve(this, battlefield.getLandPanel(), game.getPlayer1().getHand().get(i), game, batPanel, batPanel2, battlefield, c));
		}
		this.arrangeCards();
		
	}
	
	public void arrangeCards()
	{
		for (int i = 0; i < hand.size(); i++)
		{
			this.remove(hand.get(i));
		}
		
		if (hand.size() > 0)
		{
			int spacer = 850 / hand.size();
			if (spacer > 150)
			{
				spacer = 150;
			}
			int start = 300;
			for (int i = 0; i < hand.size(); i++)
			{
				this.add(hand.get(i), i);
				hand.get(i).setLocation(start + (spacer * i), (int) screen.getHeight() - 150);
			}
		}
		for (int i = 0; i < hand.size(); i++)
		{
			if (hand.get(i).getAttachedCard() instanceof CreatureCard)
			{
				if (hand.get(i).getAttachedCard().getManaCost() <= game.getPlayer1().getAvailableMana())
				{
					hand.get(i).setBorder(BorderFactory.createLineBorder(new Color(26, 212, 224)));
				}
				else
				{
					hand.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
				}
			}
			else
			{
				if (game.getPlayer1().getLandPlays() > 0)
				{
					hand.get(i).setBorder(BorderFactory.createLineBorder(new Color(26, 212, 224)));
				}
				else
				{
					hand.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
				}
			}
		}
		frame.repaint();
	}
	public void removeCard(CardSleeve card)
	{
		this.remove(card);
		hand.remove(card);
		this.arrangeCards();
	}
	public void addCard(CardSleeve card)
	{
		hand.add(card);
		this.arrangeCards();
	}
	
	public void showCard(Card c)
	{
		inPanel = true;
		if (shownCard == null)
		{
			shownCard = new CardSleeve3(c);
			shownCard.setLocation(100,250);
			this.add(shownCard);
		}
		frame.repaint();
	}
	
	public void hideCard()
	{
		if (shownCard != null)
		{
			this.remove(shownCard);
			shownCard = null;
			inPanel = false;
		}
	}

}
