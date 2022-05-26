import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.event.MouseInputAdapter;

public class CardSleeve extends JComponent
{
	private Image sleeve;
	private HandPanel panel;
	private Card attachedCard;
	
	public CardSleeve(HandPanel panel, Card card)
	{
		this.panel = panel;
		attachedCard = card;
		try 
		{
			sleeve = ImageIO.read(new File(card.getName() + ".png")).getScaledInstance(150,200,Image.SCALE_DEFAULT);
		} 
		catch (IOException e) 
		{
			System.out.println("Error - Image not Found" + card.getName());
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
			}
			public void mouseEntered(MouseEvent e) 
			{
				setLocation(getX(), getY() - 70);
			}
			public void mouseExited(MouseEvent e) 
			{
				setLocation(getX(), 618);
			}
			
		});
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(sleeve, 0, 0, this);
		
	}
}
