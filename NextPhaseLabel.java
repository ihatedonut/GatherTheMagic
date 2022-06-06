import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NextPhaseLabel extends JPanel
{
	private String nextPhase;
	private JLabel label;
	public NextPhaseLabel()
	{
		nextPhase = "Attack Phase";
		this.setSize(150,30);
		this.setOpaque(false);
		
		label = new JLabel("to " + nextPhase);
		label.setFont(new Font("Dialog",Font.BOLD,15));
		label.setLocation(0,0);
		this.add(label);
	}
	
	public void setNextPhase(String currentPhase)
	{
		if (currentPhase.equals("Main Phase"))
		{
			nextPhase = "Attack Phase";
		}
		else if (currentPhase.equals("Attack Phase"))
		{
			nextPhase = "Block Phase";
		}
		else if (currentPhase.equals("Block Phase"))
		{
			nextPhase = "Main Phase 2";
		}
		else if (currentPhase.equals("Main Phase 2"))
		{
			nextPhase = "End Turn Phase";
		}
		else if (currentPhase.equals("End Phase"))
		{
			nextPhase = "Main Phase";
		}
		label.setText("to " + nextPhase);
	}
}
