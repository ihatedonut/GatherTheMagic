import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class TestGUI extends JFrame
{
	private GameObject2 game;
	private Battlefield background;
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
		background = new Battlefield(this, game, this, c);
		
		
		
		DeckSelection deckSelect = new DeckSelection();
		deckSelect.setLocation(0,0);
		this.add(deckSelect);

		boolean deckSelectLoop = true;
		while (deckSelectLoop)
		{
			if (deckSelect.getDeckSelected())
			{
				game.getPlayer1().fillDeck(deckSelect.getDeckColor());
				deckSelectLoop = false;
				this.remove(deckSelect);
				this.repaint();
			}
			this.repaint();
		}
		
		this.add(background);
		
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
		this.repaint();
	}
	
	public Battlefield getBattlefield()
	{
		return background;
	}
	
	public GameObject2 getGame()
	{
		return game;
	}
	
	public void decoder(String message)
	{
		if (message.indexOf("cardplayed") != -1)
		{
			int hyphon = message.indexOf("-");
			String cardName = message.substring(hyphon + 1);
			
			background.getBatPanel2().addCreature(new CardSleeve2(game.getPlayer1().cardLookup(cardName), background.getHandPanel()));
		}
	}
	
	
}
