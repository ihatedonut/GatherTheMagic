import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class BattlefieldPanel extends JLayeredPane
{
	private ArrayList<CardSleeve2> creatures;
	private JFrame frame;
	public BattlefieldPanel(JFrame frame)
	{
		this.frame = frame;
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setSize(900,200);
		this.setVisible(true);
		creatures = new ArrayList<CardSleeve2>();
	}
	
	public void arrangeCreatures()
	{
		if (creatures.size() > 0)
		{
			int spacerX = 100;
			for (int i = 0; i < creatures.size(); i++)
			{
				this.add(creatures.get(i), i);
				if (i < 9)
				{
					creatures.get(i).setLocation(0 + (i * spacerX), 0);
				}
				else
				{
					int extra = creatures.size() - 9;
					int extraMinus = creatures.size() - i;
					creatures.get(i).setLocation(0 + (spacerX * (extra - extraMinus)),100);
				}
			}
		}
		frame.repaint();
	}
	
	public void addCreature(CardSleeve2 card)
	{
		creatures.add(card);
		this.arrangeCreatures();
	}
	public void removeCreature(CardSleeve2 card)
	{
		creatures.remove(card);
		this.remove(card);
		this.arrangeCreatures();
	}
	public void removeCreature(int n)
	{
		CardSleeve2 card = creatures.get(n);
		removeCreature(card);
	}
	
	
	public ArrayList<CardSleeve2> getCreatures()
	{
		return creatures;
	}
	public void removeAllCreatures()
	{
		creatures.removeAll(creatures);
		this.removeAll();
		this.arrangeCreatures();
	}
}
