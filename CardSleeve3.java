import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class CardSleeve3 extends JComponent
{
	private Image sleeve;
	private Card attachedCard;
	
	public CardSleeve3(Card c)
	{
		attachedCard = c;
		try 
		{
			sleeve = ImageIO.read(new File(attachedCard.getName() + ".png")).getScaledInstance(225,300,Image.SCALE_DEFAULT);
		} 
		catch (IOException e) 
		{
			System.out.println("Error - Image not Found");
		}
		
		this.setSize(225,300);
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(sleeve, 0, 0, this);
		Graphics2D g2d = (Graphics2D) g;
		if (attachedCard instanceof CreatureCard)
		{
			g.setColor(new Color(112, 126, 134));
			g.fillOval(200, 19, 12, 12);
			g.setColor(new Color(10,2,3));
			g.setFont(new Font("Dialog",Font.PLAIN,10));
			g.drawString(attachedCard.getManaCost() + "",203,29);
			g2d.setColor(new Color(232, 237, 232));
			g2d.fillRect(170,270,30,10);
			g.setColor(new Color(10,2,3));
			g.setFont(new Font("Dialog",Font.PLAIN,12));
			g.drawString(((CreatureCard) attachedCard).getPower() + "/" + ((CreatureCard) attachedCard).getToughness(),180,280);
		}
	}
	
	public Card getAttachedCard()
	{
		return attachedCard;
	}
}
