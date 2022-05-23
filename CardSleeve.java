import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Image;

public class CardSleeve extends JPanel
{
	private Image sleeve;
	private Card card;
	
	public CardSleeve(Card card)
	{
		this.card = card;
		try 
		{
			sleeve = ImageIO.read(new File("CardSleeve.jpg")).getScaledInstance(75,125,Image.SCALE_DEFAULT);
		} 
		catch (IOException e) 
		{
			System.out.println("Error - Image not Found");
		}
		
		this.setSize(75,125);
		this.setVisible(true);
		this.setLocation(200,200);
		
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
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(sleeve, 0, 0, this);
		
	}
	
}
