import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Battlefield extends JPanel
{
	private Image background;
	private CharacterPortrait char1;
	private CharacterPortrait char2;
	private TurnButton turnButton;
	private int phaseCount = 0;
	private GameObject2 game;
	
	
	public Battlefield(JFrame frame, GameObject2 game)
	{
		this.game = game;
		
		this.setLayout(null);
		try 
		{
			background = ImageIO.read(new File("blank battlefield.jpg")).getScaledInstance(frame.getWidth(), frame.getHeight() + 10, Image.SCALE_DEFAULT);
		}
		catch (IOException e)
		{
			System.out.println("Error - Image Not Found");
		}
		this.setVisible(true);
		this.setSize(frame.getSize());
		
		char1 = new CharacterPortrait(game.getPlayer1().getLife());
		char2 = new CharacterPortrait(game.getPlayer2().getLife());
		
		char1.setLocation(650,600);
		this.add(char1);
		
		char2.setLocation(650,10);
		this.add(char2);
		
		turnButton = new TurnButton();
		turnButton.setLocation(1150,650);
		this.add(turnButton);
		
		turnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				game.setPhaseP1(phaseCount);
				phaseCount++;
				
			if (phaseCount==4)
			{
				phaseCount = 0;
			}
		}});
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		
		revalidate();
		repaint();
		
	}
		

}
	
