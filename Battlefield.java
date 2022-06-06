import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Battlefield extends JPanel
{
	private Image background;
	private CharacterPortrait char1;
	private CharacterPortrait char2;
	private TurnButton turnButton;
	private int phaseCount = 0;
	private GameObject2 game;
	private JFrame frame;
	private PhaseLabel phaseLabel;
	private NextPhaseLabel nextPhaseLabel;
	private LandPanel landPanel;
	private HandPanel handPanel;
	private BattlefieldPanel batPanel;
	private BattlefieldPanel batPanel2;
	private Client c;
	private int turnCount;
	private JLabel turnCountLabel;
	private boolean startingReceived;
	private ConfirmButton confirmButtonReturn;
	private boolean selectCardInstance;
	private boolean singleCardSelect;
	private boolean attackCardSelect;
	private boolean blockCardSelect;
	private CardSleeve2 cardSelected;
	private ArrayList<CardSleeve2> cardsSelected;
	private boolean cardSelectedBool;
	private JLabel returnCardLabel;
	private JLabel attackLabel;
	private JLabel blockLabel;
	private ConfirmButton confirmButtonAttack;
	private ConfirmButton confirmButtonBlock;
	
	private ArrayList<Integer> blockingNums; 
	
	private CardSleeve2 blockingCard;
	
	public Battlefield(JFrame frame, GameObject2 game, TestGUI gui, Client c)
	{
		blockingNums = new ArrayList<Integer>();
		for (int i = 0; i < 20; i++)
		{
			blockingNums.add(i+1);
		}
		
		
		returnCardLabel = new JLabel("Select Card to Return to Hand");
		returnCardLabel.setSize(300,30);
		returnCardLabel.setFont(new Font("Dialog",Font.BOLD,15));
		returnCardLabel.setLocation(530,310);
		returnCardLabel.setForeground(Color.white);
		
		attackLabel = new JLabel("Select Attackers");
		attackLabel.setSize(300,30);
		attackLabel.setFont(new Font("Dialog",Font.BOLD,15));
		attackLabel.setLocation(530,310);
		attackLabel.setForeground(Color.white);
		
		blockLabel = new JLabel("Select Blocker");
		blockLabel.setSize(300,30);
		blockLabel.setFont(new Font("Dialog",Font.BOLD,15));
		blockLabel.setLocation(530,310);
		blockLabel.setForeground(Color.white);
		
		cardSelected = null;
		cardsSelected = new ArrayList<CardSleeve2>();
		
		blockingCard = null;
		
		attackCardSelect = false;
		blockCardSelect = false;
		singleCardSelect = false;
		selectCardInstance = false;
		startingReceived = false;
		turnCount = 1;
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
		
		confirmButtonAttack = new ConfirmButton();
		confirmButtonAttack.setLocation(1200,630);
		
		confirmButtonAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int confirm = JOptionPane.showConfirmDialog(null,"Are you sure?","Warning",JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION)
				{
					c.sendMessage("attackfinished");
					
					add(turnButton);
					turnButton.setEnabled(false);
					remove(confirmButtonAttack);
					remove(attackLabel);
					attackCardSelect = false;
					selectCardInstance = false;
					
					game.setPhaseP1(3);
					
					phaseLabel.changePhase(game.getPhaseP1());
					nextPhaseLabel.setNextPhase(game.getPhaseP1());
					turnButton.changePhaseImage(game.getPhaseP1());
				}
			}
		});
		
		confirmButtonBlock = new ConfirmButton();
		confirmButtonBlock.setLocation(1200,630);
		
		confirmButtonBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?","Warning",JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION)
				{
					c.sendMessage("blockfinished");
					
					remove(blockLabel);
					remove(confirmButtonBlock);
					add(turnButton);
					
					blockCardSelect = false;
					selectCardInstance = false;
					
					phaseCount++;
					game.setPhaseP1(phaseCount);
					phaseLabel.changePhase(game.getPhaseP1());
					nextPhaseLabel.setNextPhase(game.getPhaseP1());
					turnButton.changePhaseImage(game.getPhaseP1());
					
					for (int i = 0; i < batPanel.getCreatures().size(); i++)
					{
						
						batPanel.getCreatures().get(i).setBorder(BorderFactory.createLineBorder(Color.black));
						try
						{
							batPanel.getCreatures().get(i).remove(batPanel.getCreatures().get(i).getBlockImage());
						}
						catch (Exception ex)
						{}
						batPanel.getCreatures().get(i).setBlockingCard(null);
					}
					for (int i = 0; i < batPanel2.getCreatures().size();i++)
					{
						batPanel2.getCreatures().get(i).setBlockedBy(null);
						try
						{
							batPanel2.getCreatures().get(i).remove(batPanel2.getCreatures().get(i).getBlockImage());
						}
						catch (Exception ex)
						{}
					}
				}
			
			}
		});
		
		
		confirmButtonReturn = new ConfirmButton();
		confirmButtonReturn.setLocation(1200,630);
		
		confirmButtonReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (cardSelected != null)
				{
					int confirm = JOptionPane.showConfirmDialog(null,"Are you sure?","Warning",JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION)
					{
						for (int i = 0; i < batPanel.getCreatures().size(); i++) 
						{
							if (batPanel.getCreatures().get(i) == cardSelected)
							{
								CardSleeve returnedCard = new CardSleeve(handPanel, landPanel, game.getPlayer1().cardLookup(cardSelected.getAttachedCard().getName()),game,batPanel, batPanel2, getThis(), c);
								handPanel.addCard(returnedCard);
								batPanel.removeCreature(cardSelected);
								c.sendMessage("cardreturned-other-" + i);
								gui.repaint();
							}
						}
						for (int i = 0; i < batPanel2.getCreatures().size(); i++) 
						{
							if (batPanel2.getCreatures().get(i) == cardSelected)
							{
								batPanel2.removeCreature(cardSelected);
								c.sendMessage("cardreturned-you-" + i);
								gui.repaint();
							}
						}
						
						
						cardSelected = null;
						cardSelectedBool = true;
						selectCardInstance = false;
						singleCardSelect = false;
						remove(confirmButtonReturn);
						add(turnButton);
						remove(returnCardLabel);
						
					}
				}
			}
		});
		
		landPanel = new LandPanel(gui);
		
		batPanel = new BattlefieldPanel(gui);
		batPanel.setLocation(200,350);
		
		batPanel2 = new BattlefieldPanel(gui);
		batPanel2.setLocation(200,100);
		
		handPanel = new HandPanel(gui, game, this, batPanel, batPanel2, c);
		this.add(handPanel);
		
		this.add(landPanel);
		
		this.add(batPanel);
		this.add(batPanel2);
		char1 = new CharacterPortrait(game.getPlayer1().getLife());
		char2 = new CharacterPortrait(game.getPlayer2().getLife());
		
		char1.setLocation(1220,475);
		this.add(char1);
		
		char2.setLocation(100,60);
		this.add(char2);
		
		turnCountLabel = new JLabel("Turn " + turnCount);
		turnCountLabel.setFont(new Font("Dialog",Font.BOLD,15));
		turnCountLabel.setSize(100,30);
		turnCountLabel.setLocation(1280,40);
		turnCountLabel.setForeground(Color.white);
		this.add(turnCountLabel);
		
		turnButton = new TurnButton();
		turnButton.setLocation(1200,630);
		this.add(turnButton);
		turnButton.setEnabled(false);
		
		phaseLabel = new PhaseLabel();
		phaseLabel.setLocation(1190,600);
		this.add(phaseLabel);
		
		nextPhaseLabel = new NextPhaseLabel();
		nextPhaseLabel.setLocation(1188,680);
		this.add(nextPhaseLabel);
		
		turnButton.addActionListener(new ActionListener() {
			private int count = 0;
			public void actionPerformed(ActionEvent e)
			{
				c.sendMessage("phaseChange-" + phaseCount);
				if (game.getPhaseP1().equals("End Phase"))
				{
					game.setP1Turn(false);
					turnButton.setEnabled(false);
					if (turnCount > 1)
					{
						c.sendMessage("Your Turn");
					}
					else
					{
						c.sendMessage("Your Turn - Starting Turn");
					}
					incrementTurnCount();
				}
				game.setPhaseP1(phaseCount);
				if (game.getPhaseP1().equals("Attack Phase"))
				{
					boolean creaturesCanAttack = false;
					for (int i = 0; i < batPanel.getCreatures().size();i++)
					{
						if (!(((CreatureCard)batPanel.getCreatures().get(i).getAttachedCard()).getTapped()) && ((CreatureCard)batPanel.getCreatures().get(i).getAttachedCard()).getCanAttack())
						{
							creaturesCanAttack = true;
						}
					}
					
					if (batPanel.getCreatures().size() > 0 && creaturesCanAttack)
					{
						remove(turnButton);
						add(confirmButtonAttack);
						add(attackLabel);
						selectCardInstance = true;
						attackCardSelect = true;
					}
					else 
					{
						game.setPhaseP1(phaseCount + 1);
						c.sendMessage("attackfinished");
					}
				}
				
				phaseLabel.changePhase(game.getPhaseP1());
				nextPhaseLabel.setNextPhase(game.getPhaseP1());
				turnButton.changePhaseImage(game.getPhaseP1());
				phaseCount++;
				if (game.getPhaseP1().equals("Main Phase") && count != 0)
				{
					game.getPlayer1().setAvailableMana(landPanel.getNumLands());
				}
				count++;
				
			if (phaseCount==5)
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
	public BattlefieldPanel getBatPanel1()
	{
		return batPanel;
	}
	public BattlefieldPanel getBatPanel2()
	{
		return batPanel2;
	}
	public JButton getTurnButton()
	{
		return turnButton;
	}
	public TurnButton getTurnButtonActual()
	{
		return turnButton;
	}
	
	public int getTurnCount()
	{
		return turnCount;
	}
	public void incrementTurnCount()
	{
		turnCount++;
		turnCountLabel.setText("Turn " + turnCount);
		this.repaint();
	}
	public JLabel getTurnCountLabel()
	{
		return turnCountLabel;
	}
	public boolean getStartingReceived()
	{
		return startingReceived;
	}
	public void setStartingReceived(boolean b)
	{
		startingReceived = b;
	}
	public LifeLabel getLifeLabel()
	{
		return char1.getLifeLabel();
	}
	public LifeLabel getLifeLabel2()
	{
		return char2.getLifeLabel();
	}
	public boolean getSelectCardInstance()
	{
		return selectCardInstance;
	}
	public void setSelectCardInstance(boolean b)
	{
		selectCardInstance = b;
	}
	public JButton getConfirmButtonReturn()
	{
		return confirmButtonReturn;
	}
	public JButton getConfirmButtonAttack()
	{
		return confirmButtonAttack;
	}
	
	public void setSelectedCard(CardSleeve2 card)
	{
		cardSelected = card;
	}
	public CardSleeve2 getSelectedCard()
	{
		return cardSelected;
	}
	public void setCardSelectedBool(boolean b)
	{
		cardSelectedBool = b;
	}
	public boolean getCardSelectedBool()
	{
		return cardSelectedBool;
	}
	public Battlefield getThis()
	{
		return this;
	}
	public JLabel getReturnCardLabel()
	{
		return returnCardLabel;
	}
	public void setSingleCardSelect(boolean b)
	{
		singleCardSelect = b;
	}
	public boolean getSingleCardSelect()
	{
		return singleCardSelect;
	}
	public boolean getAttackCardSelect()
	{
		return attackCardSelect;
	}
	public void setAttackCardSelect(boolean b)
	{
		attackCardSelect = b;
	}
	public ArrayList<CardSleeve2> getCardsSelected()
	{
		return cardsSelected;
	}
	public int getPhaseCount()
	{
		return phaseCount;
	}
	public void setPhaseCount(int i)
	{
		phaseCount = i;
	}
	public PhaseLabel getPhaseLabel()
	{
		return phaseLabel;
	}
	public NextPhaseLabel getNextPhaseLabel()
	{
		return nextPhaseLabel;
	}
	public boolean getBlockCardSelect()
	{
		return blockCardSelect;
	}
	public void setBlockCardSelect(boolean b)
	{
		blockCardSelect = b;
	}
	public CardSleeve2 getBlockingCreature()
	{
		return blockingCard;
	}
	public void setBlockingCard(CardSleeve2 card)
	{
		blockingCard = card;
	}
	
	public JLabel getBlockLabel()
	{
		return blockLabel;
	}
	public JButton getConfirmButtonBlock()
	{
		return confirmButtonBlock;
	}
	public JLabel getAttackLabel()
	{
		return attackLabel;
	}
	public ArrayList<Integer> getBlockingNums()
	{
		return blockingNums;
	}
}
	
