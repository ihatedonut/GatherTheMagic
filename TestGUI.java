import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Toolkit;


import javax.swing.*;

public class TestGUI extends JFrame
{
	private GameObject2 game;
	private Battlefield background;
	private Library libButton;

	public TestGUI()
	{
		this.setTitle("Gather the Magic");
		game = new GameObject2();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screen);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setFocusable(false);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setResizable(false);
		
		background = new Battlefield(this, game);
		this.setContentPane(background);
		
		libButton = new Library(this);
		libButton.setLocation(100,550);
		this.add(libButton);
		
		
		
		
	}
	
	public static void main(String[] args)
	{
		new TestGUI();
	}
	
	public Battlefield getBattlefield()
	{
		return background;
	}
	
	public GameObject2 getGame()
	{
		return game;
	}
	
	
}
