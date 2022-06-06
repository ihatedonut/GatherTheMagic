import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class ConfirmButton extends JButton
{
	private Image buttonImage;
	
	public ConfirmButton()
	{
		this.setSize(125,50);
		this.setVisible(true);
		try 
		{
			buttonImage = ImageIO.read(new File("submit button.png")).getScaledInstance(125,50,Image.SCALE_DEFAULT);
		} 
		catch (IOException e) 
		{
			System.out.println("Error - Confirm Button Image Not Found");
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(buttonImage,0,0,null);
	}
}
