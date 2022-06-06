import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Graphics;

public class PhaseLabel extends JPanel
{
	private String phase;
	private JLabel label;
	public PhaseLabel()
	{
		phase = "Main Phase";
		this.setSize(150,30);
		this.setOpaque(false);
		
		label = new JLabel(phase);
		label.setFont(new Font("Dialog",Font.BOLD,18));
		label.setLocation(0,0);
		this.add(label);
		
		
	}
	
	public void changePhase(String phase)
	{
		this.phase = phase;
		label.setText(phase);
	}
}
