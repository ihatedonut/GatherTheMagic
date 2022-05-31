import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private PhaseLabel phaseLabel;
	private NextPhaseLabel nextPhaseLabel;
	private LandPanel landPanel;
	private HandPanel handPanel;
	private BattlefieldPanel batPanel;
	
	
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
		
		landPanel = new LandPanel(gui);
		
		batPanel = new BattlefieldPanel(gui);
		batPanel.setLocation(450,400);
		
		handPanel = new HandPanel(gui, game, this, batPanel);
		this.add(handPanel);
		
		this.add(landPanel);
		
		this.add(batPanel);
		char1 = new CharacterPortrait(game.getPlayer1().getLife());
		char2 = new CharacterPortrait(game.getPlayer2().getLife());
		
		char1.setLocation(1220,475);
		this.add(char1);
		
		char2.setLocation(100,60);
		this.add(char2);
		
		turnButton = new TurnButton();
		turnButton.setLocation(1200,630);
		this.add(turnButton);
		
		libButton = new Library(frame);
		libButton.setLocation(100,590);
		this.add(libButton);
		
		phaseLabel = new PhaseLabel();
		phaseLabel.setLocation(1190,600);
		this.add(phaseLabel);
		
		nextPhaseLabel = new NextPhaseLabel();
		nextPhaseLabel.setLocation(1188,680);
		this.add(nextPhaseLabel);
		
		turnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				game.setPhaseP1(phaseCount);
				phaseLabel.changePhase(game.getPhaseP1());
				nextPhaseLabel.setNextPhase(game.getPhaseP1());
				turnButton.changePhaseImage(game.getPhaseP1());
				phaseCount++;
				if (game.getPhaseP1() == "Main Phase")
				{
					handPanel.addCard(new CardSleeve(handPanel, landPanel, game.getPlayer1().draw(), game, batPanel));
					game.getPlayer1().setAvailableMana(landPanel.getNumLands());
				}
				
			if (phaseCount==4)
			{
				phaseCount = 0;
			}
			revalidate();
			repaint();
		}});
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		
		revalidate();
		repaint();
		
	}
	public HandPanel getHandPanel()
	{
		return handPanel;
	}
	public LandPanel getLandPanel()
	{
		return landPanel;
	}
		

}
	
