import java.awt.Color;
import java.util.ArrayList;
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
		this.setSize(650,150);
		this.setVisible(true);
		creatures = new ArrayList<CardSleeve2>();
	}
	
	public void arrangeCreatures()
	{
		if (creatures.size() > 0)
		{
			int spacer;
			if (600 / creatures.size() > 100)
			{
				spacer = 100;
			}
			else
			{
				spacer = 600 / creatures.size();
			}
			for (int i = 0; i < creatures.size(); i++)
			{
				this.add(creatures.get(i), i);
				creatures.get(i).setLocation(0 + (i * spacer), 0);
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
		this.arrangeCreatures();
	}
}
