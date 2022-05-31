import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class CardSleeve2 extends JComponent
{
	private Image sleeve;
	private Card attachedCard;
	public CardSleeve2(Card c)
	{
		attachedCard = c;
		try
		{
			sleeve = ImageIO.read(new File(attachedCard.getName() + " played.png")).getScaledInstance(100,100,Image.SCALE_DEFAULT);
		}
		catch (IOException e)
		{
			System.out.println("Error - Image Not Found");
		}
		this.setSize(100,100);
		this.setVisible(true);
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(sleeve,0,0,null);
		if (attachedCard instanceof CreatureCard)
		{
			g.setFont(new Font("Dialog",Font.PLAIN,10));
			g.setColor(new Color(10,2,3));
			g.drawString(((CreatureCard) attachedCard).getPower() + "/" + ((CreatureCard) attachedCard).getToughness(),76,93);
		}
	}

}
