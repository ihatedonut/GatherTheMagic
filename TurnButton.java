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
		this.setSize(125,50);
		this.setVisible(true);
		try 
		{
			buttonImage = ImageIO.read(new File("next button.png")).getScaledInstance(125,50,Image.SCALE_DEFAULT);
		} 
		catch (IOException e) 
		{
			System.out.println("Error - Image Not Found");
		}
	}
	
	public void changePhaseImage(String phase)
	{
		if (phase.equals("Main Phase"))
		{
			try 
			{
				buttonImage = ImageIO.read(new File("next button.png")).getScaledInstance(125,50,Image.SCALE_DEFAULT);
				this.paintComponent(getGraphics());
			} 
			catch (IOException e) 
			{
				System.out.println("Error - Turn Button Image Not Found");
			}
		}
		else if (phase.equals("Attack Phase"))
		{
			try 
			{
				buttonImage = ImageIO.read(new File("next button.png")).getScaledInstance(125,50,Image.SCALE_DEFAULT);
			} 
			catch (IOException e) 
			{
				System.out.println("Error - Turn Button Image Not Found");
			}
		}
		else if (phase.equals("Main Phase 2"))
		{
			try 
			{
				buttonImage = ImageIO.read(new File("next button.png")).getScaledInstance(125,50,Image.SCALE_DEFAULT);
			}
			catch (IOException e) 
			{
				System.out.println("Error - Turn Button Image Not Found");
			}
		}
		else if (phase.equals("End Phase"))
		{
			try 
			{
				buttonImage = ImageIO.read(new File("end turn button.png")).getScaledInstance(125,50,Image.SCALE_DEFAULT);
			} 
			catch (IOException e) 
			{
				System.out.println("Error - Turn Button Image Not Found");
			}
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(buttonImage,0,0,null);
	}
	
}
