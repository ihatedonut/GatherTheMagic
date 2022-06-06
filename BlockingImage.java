import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class BlockingImage extends JComponent
{
	private JLabel blockingNum;
	public BlockingImage()
	{
		this.setSize(30,30);
		this.setLocation(3,3);
		this.setVisible(true);
		blockingNum = new JLabel();
		blockingNum.setFont(new Font("Dialog",Font.BOLD,20));
		
		blockingNum.setSize(30,30);
		blockingNum.setLocation(10,0);
		blockingNum.setVisible(true);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.add(blockingNum);
		g.setColor(Color.white);
		g.fillOval(0,0,30,30);
	}
	
	public void setBlockingNum(int i)
	{
		blockingNum.setText(i + "");
	}
	public JLabel getBlockingNum()
	{
		return blockingNum;
	}
}
