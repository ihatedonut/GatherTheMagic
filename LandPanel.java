import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class LandPanel extends JLayeredPane
{
	private ArrayList<CardSleeve2> lands;
	private JFrame frame;
	public LandPanel(JFrame frame)
	{
		this.frame = frame;
		lands = new ArrayList<CardSleeve2>();
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setSize(500,150);
		this.setLocation(10,575);
		this.arrangeLands();
	}
	
	public void addLand(CardSleeve2 land)
	{
		lands.add(land);
		this.arrangeLands();
	}
	
	public void arrangeLands()
	{
		if (lands.size() > 0)
		{
			int spacer = 400 / lands.size();
			if (spacer > 100)
			{
				spacer = 100;
			}
			for (int i = 0; i < lands.size(); i++)
			{
				this.add(lands.get(i), i);
				lands.get(i).setLocation(0 + (i * spacer), 0);
			}
		}
		frame.repaint();
	}
	
	public int getNumLands()
	{
		return lands.size();
	}
}
