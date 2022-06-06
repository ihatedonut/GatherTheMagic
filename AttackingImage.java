import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class AttackingImage extends JComponent
{
	private Image image;
	public AttackingImage()
	{
		try 
		{
			image = ImageIO.read(new File("attacking image transparent.png")).getScaledInstance(50,40,Image.SCALE_DEFAULT);
		}
		catch (IOException e)
		{
			System.out.println("Error - Attacking Image not found");
		}
		this.setSize(50,40);
		this.setLocation(-10,55);
		this.setVisible(true);
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(image,0,0,null);
	}
}
