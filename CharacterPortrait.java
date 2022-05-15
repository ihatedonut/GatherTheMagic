import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import javax.swing.JComponent;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;

public class CharacterPortrait extends JComponent
{
	private Image portrait;
	private Ellipse2D.Double border;
	
	public CharacterPortrait()
	{
		this.setSize(110,110);
		try 
		{
			portrait = ImageIO.read(new File("sparky transparent.png")).getScaledInstance(100,100,Image.SCALE_DEFAULT);
		} 
		catch (IOException e) 
		{
			System.out.println("Error - Image Not Found");
		}
		
		border = new Ellipse2D.Double(5,5,101,101);
		this.setVisible(true);
		this.setFocusable(false);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(portrait,5,5,null);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(204, 189, 70));
		g2d.setStroke(new BasicStroke(10));
		g2d.draw(border);
		
		revalidate();
		repaint();
	}
}
 