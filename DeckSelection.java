import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Component;

public class DeckSelection extends JPanel
{
	private boolean deckSelected;
	private String deckColor;
	
	public DeckSelection()
	{
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screen);
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(true);
		this.setBackground(new Color(48, 99, 109));
		deckSelected = false;
		
		JLabel chooseDeckLabel = new JLabel("Choose your deck!");
		chooseDeckLabel.setSize(400,200);
		chooseDeckLabel.setFont(new Font("Dialog",Font.BOLD,40));
		chooseDeckLabel.setLocation(475,100);
		this.add(chooseDeckLabel);
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		
		JButton red = new JButton("Red");  buttons.add(red);
		red.setBackground(Color.red);
		
		JButton blue = new JButton("Blue"); buttons.add(blue);
		blue.setBackground(Color.blue);
		
		JButton green = new JButton("Green"); buttons.add(green);
		green.setBackground(Color.green);
		
		JButton black = new JButton("Black"); buttons.add(black);
		black.setBackground(Color.black);
		
		JButton white = new JButton("White"); buttons.add(white);
		white.setBackground(Color.white);
		
		for (int i = 0; i < buttons.size(); i++)
		{
			buttons.get(i).setSize(100,40);
			buttons.get(i).setLocation(200 + (200 * i), 400);
			this.add(buttons.get(i));
		}
		red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int confirm = JOptionPane.showConfirmDialog(null,"Are you sure?","Warning",JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION)
				{
					deckColor = red.getText().toLowerCase();
					deckSelected = true;
				}
			}
		});
		blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int confirm = JOptionPane.showConfirmDialog(null,"Are you sure?","Warning",JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION)
				{
					deckColor = blue.getText().toLowerCase();
					deckSelected = true;
				}
			}
		});
		green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int confirm = JOptionPane.showConfirmDialog(null,"Are you sure?","Warning",JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION)
				{
					deckColor = green.getText().toLowerCase();
					deckSelected = true;
				}
			}
		});
		white.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int confirm = JOptionPane.showConfirmDialog(null,"Are you sure?","Warning",JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION)
				{
					deckColor = white.getText().toLowerCase();
					deckSelected = true;
				}
			}
		});
		black.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int confirm = JOptionPane.showConfirmDialog(null,"Are you sure?","Warning",JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION)
				{
					deckColor = black.getText().toLowerCase();
					deckSelected = true;
				}
			}
		});
		
	}
	
	public boolean getDeckSelected()
	{
		return deckSelected;
	}
	
	public String getDeckColor()
	{
		return deckColor;
	}
	public Component getThis()
	{
		return this;
	}
}
