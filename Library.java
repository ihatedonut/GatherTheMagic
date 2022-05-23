import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Library extends JButton
{
	private Image buttonImage;
	private LibraryView libView;
	
	public Library(JFrame frame)
	{
		this.setSize(100,150);
		this.setVisible(true);
		try 
		{
			buttonImage = ImageIO.read(new File("CardSleeve.jpg")).getScaledInstance(100, 150, Image.SCALE_DEFAULT);
		} 
		catch (IOException e) 
		{
			System.out.println("Error - Image Not Found");
		}
		
		libView = new LibraryView(frame);
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame.setContentPane(libView);
			}
		});
		
		libView.getDoneButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame.setContentPane(TestGUI.getBattlefield());
			}
		});
	}


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(buttonImage, 0, 0, null);
	}



}
