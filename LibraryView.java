import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class LibraryView extends JPanel
{
	private ArrayList<CardSleeve> cards;
	private Image background;
	private DoneButton doneButton;
	
	public LibraryView(JFrame frame)
	{
		this.setSize(frame.getWidth(), frame.getHeight());
		this.setLayout(null);
	
		try 
		{
			background = ImageIO.read(new File("blank battlefield darkened.jpg")).getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_DEFAULT);
		} 
		catch (IOException e) 
		{
			System.out.println("Error - Image Not Found");
		}
		
		doneButton = new DoneButton();
		this.add(doneButton);
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(background,0,0,null);
	}
	
	public DoneButton getDoneButton()
	{
		return doneButton;
	}
}
