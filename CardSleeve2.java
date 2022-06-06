import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class CardSleeve2 extends JComponent
{
	private Image sleeve;
	private Card attachedCard;
	private Graphics g;
	private TappedImage tappedImage;
	private AttackingImage attackImage;
	private BlockingImage blockImage;
	private Battlefield battlefield;
	private boolean isSelected;
	private boolean isAttacking;
	private boolean isBlocking;
	private CardSleeve2 blockedBy;
	private CardSleeve2 blocking;
	private Client client;
	
	public CardSleeve2(Card c, HandPanel panel, Battlefield battlefield, BattlefieldPanel batPanel, Client client)
	{
		this.client = client;
		isAttacking = false;
		isSelected = false;
		this.battlefield = battlefield;
		this.setLayout(null);
		tappedImage = new TappedImage();
		if (c instanceof CreatureCard)
		{
			attackImage = new AttackingImage();
			blockImage = new BlockingImage();
		}
		
		attachedCard = c;
		try
		{
			sleeve = ImageIO.read(new File(attachedCard.getName() + " played.png")).getScaledInstance(100,100,Image.SCALE_DEFAULT);
		}
		catch (IOException e)
		{
			System.out.println("Error - Image Not Found");
		}
		this.setSize(100,100);
		this.setVisible(true);
		
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) 
			{
				if (e.getButton() == MouseEvent.BUTTON3)
				{
					panel.showCard(getAttachedCard());
				}
				else if (e.getButton() == MouseEvent.BUTTON1 && battlefield.getSelectCardInstance() && battlefield.getSingleCardSelect())
				{
					if (isSelected)
					{
						setBorder(BorderFactory.createLineBorder(Color.black));
						isSelected = false;
					}
					else
					{
						isSelected = true;
						battlefield.setSelectedCard(getThis());
						setBorder(BorderFactory.createLineBorder(Color.red));
					}
					panel.hideCard();
					for (int i = 0; i < battlefield.getBatPanel1().getCreatures().size(); i++)
					{
						if (battlefield.getBatPanel1().getCreatures().get(i) != getThis())
						{
							battlefield.getBatPanel1().getCreatures().get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						}
					}
					for (int i = 0; i < battlefield.getBatPanel2().getCreatures().size(); i++)
					{
						if (battlefield.getBatPanel2().getCreatures().get(i) != getThis())
						{
							battlefield.getBatPanel2().getCreatures().get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						}
					}
				}
				else if (e.getButton() == MouseEvent.BUTTON1 && battlefield.getSelectCardInstance() && battlefield.getAttackCardSelect())
				{
					if (isSelected)
					{
						client.sendMessage("removeattacker-" + batPanel.getCreatures().indexOf(getThis()));
						isAttacking = false;
						remove(attackImage);
						battlefield.getCardsSelected().remove(getThis());
						setBorder(BorderFactory.createLineBorder(Color.black));
						isSelected = false;
					}
					else if (((CreatureCard)attachedCard).getCanAttack())
					{
						client.sendMessage("addattacker-" + batPanel.getCreatures().indexOf(getThis()));
						isAttacking = true;
						isSelected = true;
						battlefield.getCardsSelected().add(getThis());
						add(attackImage);
						setBorder(BorderFactory.createLineBorder(Color.red));
					}
				}
				else if (e.getButton() == MouseEvent.BUTTON1 && battlefield.getSelectCardInstance() && battlefield.getBlockCardSelect())
				{
					if (isAttacking && battlefield.getBlockingCreature() != null)
					{
						blockedBy = battlefield.getBlockingCreature();
						battlefield.getBlockingCreature().setBlockingCard(getThis());
						battlefield.setBlockingCard(null);
						
						blockImage.setBlockingNum(Integer.parseInt(blockedBy.getBlockImage().getBlockingNum().getText()));
						add(blockImage);
						int attackPos = battlefield.getBatPanel2().getCreatures().indexOf(getThis());
						int blockPos = battlefield.getBatPanel1().getCreatures().indexOf(blockedBy);
						
						client.sendMessage("addBlocker-" + attackPos + "-" + blockPos);
					}
					if (isBlocking && !(isSelected))
					{
						isSelected = true;
						blockImage.setBlockingNum(battlefield.getBlockingNums().get(0));
						battlefield.getBlockingNums().remove(0);
						add(blockImage);
						battlefield.setBlockingCard(getThis());
						setBorder(BorderFactory.createLineBorder(Color.red));
					}
					else if (isBlocking && isSelected)
					{
						if (blocking != null)
						{
							int attackPos = battlefield.getBatPanel2().getCreatures().indexOf(blocking);
							int blockPos = battlefield.getBatPanel1().getCreatures().indexOf(getThis());
							
							blocking.setBlockedBy(null);
							blocking.remove(blocking.getBlockImage());
							client.sendMessage("removeBlocker-" + attackPos + "-" + blockPos);
						}
						isSelected = false;
						battlefield.getBlockingNums().add(0, Integer.parseInt(blockImage.getBlockingNum().getText()));
						remove(blockImage);
						battlefield.setBlockingCard(null);
						setBorder(BorderFactory.createLineBorder(Color.black));
					}
				}
				
				else
				{
					panel.hideCard();
				}
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {	
			}
			public void mouseExited(MouseEvent e) {
			}
			
		});
	}
	
	
	public void paintComponent(Graphics g)
	{
		this.g = g.create();
		super.paintComponent(g);
		g.drawImage(sleeve,0,0,null);
		Graphics2D g2d = (Graphics2D) g;
		if (attachedCard instanceof CreatureCard)
		{
			g.setFont(new Font("Dialog",Font.PLAIN,10));
			g2d.setColor(new Color(232, 237, 232));
			g2d.fillRect(67,87,30,10);
			g.setColor(new Color(10,2,3));
			g.drawString(((CreatureCard) attachedCard).getPower() + "/" + ((CreatureCard) attachedCard).getToughness(),76,95);
			if (((CreatureCard) attachedCard).getTapped())
			{
				this.add(tappedImage);
			}
			else
			{
				try
				{
					this.remove(tappedImage);
				}
				catch (Exception e)
				{}
			}
		}
		else
		{
			if (((LandCard)attachedCard).getTapped())
			{
				this.add(tappedImage);
			}
			else
			{
				try
				{
					this.remove(tappedImage);
				}
				catch (Exception e)
				{}
			}
		}
	}
	
	public void resizeCard(int w, int h)
	{
		this.setSize(w,h);
		try
		{
			sleeve = ImageIO.read(new File(attachedCard.getName() + ".png")).getScaledInstance(w,h,Image.SCALE_DEFAULT);
		}
		catch (IOException e)
		{
			System.out.println("Error - Image Not Found");
		}
	}
	
	public Card getAttachedCard()
	{
		return attachedCard;
	}
	public CardSleeve2 getThis()
	{
		return this;
	}
	public void setSelected(boolean b)
	{
		isSelected = b;
	}
	public JComponent getAttackImage()
	{
		return attackImage;
	}
	public boolean getAttacking()
	{
		return isAttacking;
	}
	public void setAttacking(boolean b)
	{
		isAttacking = true;
	}
	public void setBlocking(boolean b)
	{
		isBlocking = b;
	}
	public void setBlockedBy(CardSleeve2 card)
	{
		blockedBy = card;
	}
	public CardSleeve2 getBlockedBy()
	{
		return blockedBy;
	}
	public void setBlockingCard(CardSleeve2 attacker)
	{
		blocking = attacker;
	}
	public CardSleeve2 getBlockingCard()
	{
		return blocking;
	}
	
	public BlockingImage getBlockImage()
	{
		return blockImage;
	}

}
