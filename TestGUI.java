import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TestGUI extends JFrame
{

	public TestGUI()
	{
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screen);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setFocusable(false);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setResizable(false);
		
		Battlefield background = new Battlefield(this);
		this.setContentPane(background);
		
		Library lib = new Library();
		this.add(lib);
		lib.setLocation(175,500);
		
		LibraryView libView = new LibraryView(this);
		
		lib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setContentPane(libView);
			}
		});
		
		libView.getDoneButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setContentPane(background);
			}
		});
		
		CardSleeve card = new CardSleeve();
		this.add(card);
		this.update(getGraphics());
		
		
	}
	
	public static void main(String[] args)
	{
		new TestGUI();
	}
	
	
}
