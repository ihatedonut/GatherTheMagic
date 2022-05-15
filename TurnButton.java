import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class TurnButton extends JButton 
{
	private Image buttonImage;
	
	public TurnButton()
	{
		this.setSize(175,75);
		this.setVisible(true);
		try 
		{
			buttonImage = ImageIO.read(new File("end turn button.png")).getScaledInstance(175,75,Image.SCALE_DEFAULT);
		} 
		catch (IOException e) 
		{
			System.out.println("Error - Image Not Found");
		}
	}
	
	public void changePhaseImage(String phase)
	{
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(buttonImage,0,0,null);
	}
	
}
