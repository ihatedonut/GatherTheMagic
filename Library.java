import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Library extends JButton
{
	private Image buttonImage;
	
	public Library()
	{
		this.setSize(125,175);
		this.setVisible(true);
		try 
		{
			buttonImage = ImageIO.read(new File("CardSleeve.jpg")).getScaledInstance(125, 175, Image.SCALE_DEFAULT);
		} 
		catch (IOException e) 
		{
			System.out.println("Error - Image Not Found");
		}
	}


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(buttonImage, 0, 0, null);
	}



}
