import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class TestGUI extends JFrame
{
	private GameObject2 game;
	private static Battlefield background;
	private Client c;

	public TestGUI(Client c)
	{
		this.c = c;
		this.setTitle("Gather the Magic");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screen);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setFocusable(false);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setResizable(false);
		
		game = new GameObject2();
		DeckSelection deckSelect = new DeckSelection();
		deckSelect.setLocation(0,0);
		this.add(deckSelect);

		
		background = new Battlefield(this, game, this);
		this.setContentPane(background);
		
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) 
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					background.getHandPanel().hideCard();
				}
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {	
			}
			public void mouseExited(MouseEvent e) {
			}
			
		});
	}
	
	public static Battlefield getBattlefield()
	{
		return background;
	}
	
	public GameObject2 getGame()
	{
		return game;
	}
	
	
}
