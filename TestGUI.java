import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Toolkit;


import javax.swing.*;

public class TestGUI extends JFrame
{
	private GameObject2 game;
	private static Battlefield background;

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
		
		background = new Battlefield(this, game, this);
		this.setContentPane(background);
		
		
		
		
	}
	
	public static void main(String[] args)
	{
		new TestGUI();
	}
	
	public static Battlefield getBattlefield()
	{
		return background;
	}
	
	public GameObject2 getGame()
	{
		return game;
	}
	
	
}
