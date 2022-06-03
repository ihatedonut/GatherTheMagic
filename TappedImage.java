import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class TappedImage extends JComponent
{
	private Image image;
	public TappedImage()
	{
		try
		{
			image = ImageIO.read(new File("tapped arrow transparent.png")).getScaledInstance(30,30,Image.SCALE_DEFAULT);
		}
		catch (IOException e)
		{
			System.out.println("Error - Tapped Arrow Image Not Found");
		}
		this.setSize(30,30);
		this.setLocation(10,60);
		this.setVisible(true);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(image,0,0,null);
	}
}
