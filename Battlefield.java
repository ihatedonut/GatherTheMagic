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
	private Library libButton;
	private JFrame frame;
	
	
	public Battlefield(JFrame frame, GameObject2 game, TestGUI gui)
	{
		this.game = game;
		this.frame = frame;
		
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
		
		HandPanel handPanel = new HandPanel(gui, game);
		this.add(handPanel);
		
		char1 = new CharacterPortrait(game.getPlayer1().getLife());
		char2 = new CharacterPortrait(game.getPlayer2().getLife());
		
		char1.setLocation(1200,550);
		this.add(char1);
		
		char2.setLocation(100,60);
		this.add(char2);
		
		turnButton = new TurnButton();
		turnButton.setLocation(1200,680);
		this.add(turnButton);
		
		libButton = new Library(frame);
		libButton.setLocation(100,590);
		this.add(libButton);
		
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
	
