import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class CardSleeve2 extends JComponent
{
	private Image sleeve;
	private Card attachedCard;
	private Graphics g;
	private TappedImage tappedImage;
	public CardSleeve2(Card c, HandPanel panel)
	{
		this.setLayout(null);
		tappedImage = new TappedImage();
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
		
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) 
			{
				if (e.getButton() == MouseEvent.BUTTON3)
				{
					panel.showCard(getAttachedCard());
				}
				else
				{
					panel.hideCard();
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
	
	
	public void paintComponent(Graphics g)
	{
		this.g = g.create();
		super.paintComponent(g);
		g.drawImage(sleeve,0,0,null);
		Graphics2D g2d = (Graphics2D) g;
		if (attachedCard instanceof CreatureCard)
		{
			g.setFont(new Font("Dialog",Font.PLAIN,10));
			g2d.setColor(new Color(232, 237, 232));
			g2d.fillRect(67,87,30,10);
			g.setColor(new Color(10,2,3));
			g.drawString(((CreatureCard) attachedCard).getPower() + "/" + ((CreatureCard) attachedCard).getToughness(),76,95);
			if (((CreatureCard) attachedCard).getTapped())
			{
				this.add(tappedImage);
			}
			else
			{
				try
				{
					this.remove(tappedImage);
				}
				catch (Exception e)
				{}
			}
		}
		else
		{
			if (((LandCard)attachedCard).getTapped())
			{
				this.add(tappedImage);
			}
			else
			{
				try
				{
					this.remove(tappedImage);
				}
				catch (Exception e)
				{}
			}
		}
	}
	
	public void resizeCard(int w, int h)
	{
		this.setSize(w,h);
		try
		{
			sleeve = ImageIO.read(new File(attachedCard.getName() + ".png")).getScaledInstance(w,h,Image.SCALE_DEFAULT);
		}
		catch (IOException e)
		{
			System.out.println("Error - Image Not Found");
		}
	}
	
	public Card getAttachedCard()
	{
		return attachedCard;
	}

}
