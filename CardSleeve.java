import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class CardSleeve extends JComponent
{
	private Image sleeve;
	private HandPanel panel;
	private LandPanel panel2;
	private Card attachedCard;
	private GameObject2 game;
	private BattlefieldPanel battlefield;
	
	public CardSleeve(HandPanel panel, LandPanel panel2, Card card, GameObject2 game, BattlefieldPanel battlefield)
	{
		this.game = game;
		attachedCard = card;
		this.panel = panel;
		this.panel2 = panel2;
		this.battlefield = battlefield;
		try 
		{
			sleeve = ImageIO.read(new File(card.getName() + ".png")).getScaledInstance(150,200,Image.SCALE_DEFAULT);
		} 
		catch (IOException e) 
		{
			System.out.println("Error - Image not Found");
		}
		
		this.setSize(150,200);
		this.setVisible(true);
		
		this.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) 
			{
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - (getWidth() / 2) ,y - (getHeight() / 2));
			}
			public void mouseMoved(MouseEvent e) 
			{
				
			}
		});
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
				
			}
			public void mouseReleased(MouseEvent e) 
			{
				if (getY() > 450)
				{
					panel.arrangeCards();
				}
				else
				{
					if (card instanceof LandCard)
					{
						if (game.getPlayer1().getLandPlays() > 0 && (game.getPhaseP1().equals("Main Phase") || game.getPhaseP1().equals("Main Phase 2") || game.getPhaseP1().equals("End Phase")))
						{
							panel.removeCard(getThis());
							panel2.addLand(new CardSleeve2(attachedCard));
							game.getPlayer1().decrementLandPlays();
							game.getPlayer1().incrementAvailableMana();
						}
					}
					else if (card instanceof CreatureCard)
					{
						if (game.getPlayer1().getAvailableMana() >= card.getManaCost() && (game.getPhaseP1().equals("Main Phase") || game.getPhaseP1().equals("Main Phase 2") || game.getPhaseP1().equals("End Phase")))
						{
							battlefield.addCreature(new CardSleeve2(card));
							panel.removeCard(getThis());
							game.getPlayer1().setAvailableMana(game.getPlayer1().getAvailableMana() - card.getManaCost());
						}
					}
					else
					{
						panel.arrangeCards();
					}
				}
			}
			public void mouseEntered(MouseEvent e) 
			{
				panel.setLayer(getThis(), getLayer() + 1);
				setLocation(getX(), getY() - 70);
			}
			public void mouseExited(MouseEvent e) 
			{
				panel.setLayer(getThis(), getLayer() - 1);
				panel.arrangeCards();
			}
			
		});
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(sleeve, 0, 0, this);
		Graphics2D g2d = (Graphics2D) g;
		if (attachedCard instanceof CreatureCard)
		{
			g.setColor(new Color(112, 126, 134));
			g.fillOval(125, 10, 10, 10);
			g.setColor(new Color(10,2,3));
			g.setFont(new Font("Dialog",Font.PLAIN,10));
			g.drawString(attachedCard.getManaCost() + "",128,19);
			g2d.setColor(new Color(232, 237, 232));
			g2d.fillRect(110,180,30,10);
			g.setColor(new Color(10,2,3));
			g.drawString(((CreatureCard) attachedCard).getPower() + "/" + ((CreatureCard) attachedCard).getToughness(),115,188);
		}
	}
	public CardSleeve getThis()
	{
		return this;
	}
	public int getLayer()
	{
		return panel.getLayer(this);
	}
}
