import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
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
	
	public HandPanel(TestGUI frame, GameObject2 game, Battlefield battlefield, BattlefieldPanel batPanel)
	{
		this.battlefield = battlefield;
		this.batPanel = batPanel;
		this.frame = frame;
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screen);
		this.setLocation(0,0);
		this.setVisible(true);
		
		hand = new ArrayList<CardSleeve>();
		for (int i = 0; i < 7; i++)
		{
			hand.add(new CardSleeve(this, battlefield.getLandPanel(), game.getPlayer1().getHand().get(i), game, batPanel));
		}
		this.arrangeCards();
		
	}
	
	public void arrangeCards()
	{
		this.removeAll(); //clear the screen for reset
		
		//width is 850, start is 300, end is 1100
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
		frame.repaint();
	}
	public void removeCard(CardSleeve card)
	{
		hand.remove(card);
		this.arrangeCards();
	}
	public void addCard(CardSleeve card)
	{
		hand.add(card);
		this.arrangeCards();
	}

}
