import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LifeLabel extends JPanel
{
	private JLabel label;
	
	public LifeLabel(int h)
	{
		this.setSize(61,41);
		this.setLocation(21,0);
		this.setVisible(true);
		this.setOpaque(false);
		
		label = new JLabel(h + "");
		label.setFont(new Font("Dialog",Font.BOLD,20));
		label.setLocation(5,10);
		this.add(label);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(new Color(204, 189, 70));
		g2d.setStroke(new BasicStroke(10));
		g2d.fillOval(0,0,60,40);
		
		revalidate();
		repaint();
		
	}
	
	public void setLife(int h)
	{
		label.setText(h + "");
	}
}
