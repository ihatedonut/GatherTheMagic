import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Battlefield extends JComponent
{
	private Image background;
	private CharacterPortrait char1;
	private CharacterPortrait char2;
	
	public Battlefield(JFrame frame)
	{
		try 
		{
			background = ImageIO.read(new File("blank battlefield.jpg")).getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_DEFAULT);
		}
		catch (IOException e)
		{
			System.out.println("Error - Image Not Found");
		}
		this.setVisible(true);
		this.setSize(frame.getSize());
		
		char1 = new CharacterPortrait();
		char2 = new CharacterPortrait();
		
		char1.setLocation(625,600);
		this.add(char1);
		
		char2.setLocation(625,50);
		this.add(char2);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
	}
		

}
	
