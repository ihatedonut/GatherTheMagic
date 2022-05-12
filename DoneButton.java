import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class DoneButton extends JButton
{
	private Image buttonImage;
	
	public DoneButton()
	{
		this.setSize(100,50);
		this.setVisible(true);
		
		try 
		{
			buttonImage = ImageIO.read(new File("done button.png")).getScaledInstance(100,50,Image.SCALE_DEFAULT);
		} 
		catch (IOException e) 
		{
			System.out.println("Error - Image Not Found");
		}
		
		this.setLocation(1000,20);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(buttonImage,0,0,null);
	}
}
