import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class TestGUI extends JFrame
{
	private GameObject2 game;
	private Battlefield background;
	private Client c;

	public TestGUI(Client c)
	{
		this.c = c;
		this.setTitle("Gather the Magic");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screen);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setFocusable(false);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setResizable(false);
		
		game = new GameObject2();
		
		
		
		DeckSelection deckSelect = new DeckSelection();
		deckSelect.setLocation(0,0);
		this.add(deckSelect);

		boolean deckSelectLoop = true;
		while (deckSelectLoop)
		{
			if (deckSelect.getDeckSelected())
			{
				game.getPlayer1().fillDeck(deckSelect.getDeckColor());
				deckSelectLoop = false;
				this.remove(deckSelect);
				this.repaint();
			}
			this.repaint();
		}
		
		background = new Battlefield(this, game, this, c);
		
		this.add(background);
		
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) 
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					background.getHandPanel().hideCard();
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
		this.repaint();
	}
	
	public Battlefield getBattlefield()
	{
		return background;
	}
	
	public GameObject2 getGame()
	{
		return game;
	}
	
	public void decoder(String message)
	{
		if (message.indexOf("cardplayed") != -1)
		{
			int hyphon = message.indexOf("-");
			String cardName = message.substring(hyphon + 1);
			
			CardSleeve2 newCard = new CardSleeve2(game.getPlayer1().cardLookup(cardName), background.getHandPanel(), background, background.getBatPanel2(), c);
			background.getBatPanel2().addCreature(newCard);
			background.getHandPanel().showCard(newCard.getAttachedCard());
		
		}
		else if (message.indexOf("cardreturned") != -1)
		{
			int firstHyphon = message.indexOf("-");
			int secondHyphon = message.substring(firstHyphon+1).indexOf("-");
			
			String location = message.substring(firstHyphon + 1, firstHyphon + secondHyphon + 1);
			String position = message.substring(firstHyphon + secondHyphon + 2);
			int positionNum = Integer.parseInt(position);
			
			System.out.println("cardreturned " + location + " " + positionNum);
			
			if (location.equals("other"))
			{
				background.getBatPanel2().removeCreature(background.getBatPanel2().getCreatures().get(positionNum));
			}
			else if (location.equals("you"))
			{
				CardSleeve2 returnedCard = background.getBatPanel1().getCreatures().get(positionNum);
				String cardName = returnedCard.getAttachedCard().getName();
				background.getBatPanel1().removeCreature(background.getBatPanel1().getCreatures().get(positionNum));
				background.getHandPanel().addCard(new CardSleeve(background.getHandPanel(), background.getLandPanel(), game.getPlayer1().cardLookup(cardName), game, background.getBatPanel1(), background.getBatPanel2(), background, c));
			}
		
		}
		else if (message.indexOf("tapcreature") != -1 && message.indexOf("untapcreature") == -1)
		{
			int hyphon = message.indexOf("-");
			
			String position = message.substring(hyphon + 1);
			int positionNum = Integer.parseInt(position);
			
			((CreatureCard)background.getBatPanel2().getCreatures().get(positionNum).getAttachedCard()).setTapped(true);
		}
		else if (message.indexOf("untapcreature") != -1)
		{
			int hyphon = message.indexOf("-");
			
			String position = message.substring(hyphon + 1);
			int positionNum = Integer.parseInt(position);
			
			((CreatureCard)background.getBatPanel2().getCreatures().get(positionNum).getAttachedCard()).setTapped(false);
		}
		else if (message.indexOf("lifegained") != -1)
		{
			int hyphon = message.indexOf("-");
			
			String lifeGained = message.substring(hyphon + 1);
			int lifeGainNum = Integer.parseInt(lifeGained);
			
			game.getPlayer2().incrementLife(lifeGainNum);
			background.getLifeLabel2().setLife(game.getPlayer2().getLife());
			repaint();
		}
		else if (message.indexOf("damagetaken") != -1)
		{
			int hyphon = message.indexOf("-");
			
			String damageTaken = message.substring(hyphon + 1);
			int damageTakenNum = Integer.parseInt(damageTaken);
			
			game.getPlayer1().decrementLife(damageTakenNum);
			background.getLifeLabel().setLife(game.getPlayer1().getLife());
			repaint();
		}
		else if (message.indexOf("removeCreature") != -1)
		{
			int hyphon = message.indexOf("-");
			int hyphon2 = message.substring(hyphon + 1).indexOf("-");
			
			String source = message.substring(hyphon + 1, hyphon + hyphon2 + 2);
			String position = message.substring(hyphon + hyphon2 + 2);
			int positionNum = Integer.parseInt(position);
			
			if (source.equals("you"))
			{
				background.getBatPanel1().removeCreature(positionNum);
			}
			else if (source.equals("other"))
			{
				background.getBatPanel2().removeCreature(positionNum);
			}
			
			
		}
		
		else if (message.indexOf("addattacker") != -1)
		{
			int hyphon = message.indexOf("-");
			
			String position = message.substring(hyphon + 1);
			int positionNum = Integer.parseInt(position);
			
			background.getBatPanel2().getCreatures().get(positionNum).setAttacking(true);
			background.getBatPanel2().getCreatures().get(positionNum).add(background.getBatPanel2().getCreatures().get(positionNum).getAttackImage());
		}
		else if (message.indexOf("removeattacker") != -1)
		{
			int hyphon = message.indexOf("-");
			
			String position = message.substring(hyphon + 1);
			int positionNum = Integer.parseInt(position);
			background.getBatPanel2().getCreatures().get(positionNum).setAttacking(false);
			background.getBatPanel2().getCreatures().get(positionNum).remove(background.getBatPanel2().getCreatures().get(positionNum).getAttackImage());
		}
		else if (message.indexOf("addBlocker") != -1)
		{
			int hyphon = message.indexOf("-");
			int hyphon2 = message.substring(hyphon + 1).indexOf("-");
			
			String attacker = message.substring(hyphon + 1, hyphon + 1 + hyphon2);
			String blocker = message.substring(hyphon + hyphon2 + 2);
			int attackerNum = Integer.parseInt(attacker);
			int blockerNum = Integer.parseInt(blocker);
			
			background.getBatPanel1().getCreatures().get(attackerNum).setBlockedBy(background.getBatPanel2().getCreatures().get(blockerNum));
			background.getBatPanel2().getCreatures().get(blockerNum).setBlockingCard(background.getBatPanel1().getCreatures().get(attackerNum));
		
		}
		else if (message.indexOf("removeBlocker") != -1)
		{
			int hyphon = message.indexOf("-");
			int hyphon2 = message.substring(hyphon + 1).indexOf("-");
			
			String attacker = message.substring(hyphon + 1, hyphon + 1 + hyphon2);
			String blocker = message.substring(hyphon + hyphon2 + 2);
			int attackerNum = Integer.parseInt(attacker);
			int blockerNum = Integer.parseInt(blocker);
			
			background.getBatPanel1().getCreatures().get(attackerNum).setBlockedBy(null);
			background.getBatPanel2().getCreatures().get(blockerNum).setBlockingCard(null);
		}
		else if (message.indexOf("attackfinished") != -1)
		{
			background.setPhaseCount(background.getPhaseCount() + 1);
			game.setPhaseP1(background.getPhaseCount());
			background.getPhaseLabel().changePhase(game.getPhaseP1());
			background.getNextPhaseLabel().setNextPhase(game.getPhaseP1());
			background.getTurnButtonActual().changePhaseImage(game.getPhaseP1());
			
			
			boolean otherPersonAttacking = false;
			for (int i = 0; i < background.getBatPanel2().getCreatures().size();i++)
			{
				if (background.getBatPanel2().getCreatures().get(i).getAttacking())
				{
					otherPersonAttacking = true;
				}
			}
			if (otherPersonAttacking)
			{
				boolean canBlock = false;
				for (int i = 0; i < background.getBatPanel1().getCreatures().size();i++)
				{
					if (!((CreatureCard)background.getBatPanel1().getCreatures().get(i).getAttachedCard()).getTapped())
					{
						canBlock = true;
					}
				}
				if (canBlock)
				{
					for (int i = 0; i < background.getBatPanel1().getCreatures().size();i++)
					{
						if (!((CreatureCard)background.getBatPanel1().getCreatures().get(i).getAttachedCard()).getTapped())
						{
							background.getBatPanel1().getCreatures().get(i).setBlocking(true);
						}
						background.remove(background.getTurnButton());
						background.add(background.getConfirmButtonBlock());
						background.add(background.getBlockLabel());
						background.setBlockCardSelect(true);
						background.setSelectCardInstance(true);
					}
				}
				else
				{
					c.sendMessage("blockfinished");
					
					background.setPhaseCount(background.getPhaseCount() + 1);
					game.setPhaseP1(background.getPhaseCount());
					background.getPhaseLabel().changePhase(game.getPhaseP1());
					background.getNextPhaseLabel().setNextPhase(game.getPhaseP1());
					background.getTurnButtonActual().changePhaseImage(game.getPhaseP1());
				}
			}
			else 
			{
				c.sendMessage("blockfinished");
			}
		}
		
		else if (message.indexOf("blockfinished") != -1)
		{
			int damage = 0;
			for (int i = 0; i < background.getBatPanel1().getCreatures().size();i++)
			{
				if (background.getBatPanel1().getCreatures().get(i).getAttacking() && background.getBatPanel1().getCreatures().get(i).getBlockedBy() == null)
				{
					damage += ((CreatureCard)background.getBatPanel1().getCreatures().get(i).getAttachedCard()).getPower();
					((CreatureCard)background.getBatPanel1().getCreatures().get(i).getAttachedCard()).setTapped(true);
					background.getBatPanel1().getCreatures().get(i).setBorder(BorderFactory.createLineBorder(Color.black));
					background.getBatPanel1().getCreatures().get(i).remove(background.getBatPanel1().getCreatures().get(i).getAttackImage());
					background.getBatPanel1().getCreatures().get(i).setAttacking(false);
					c.sendMessage("removeattacker-" + i);
					c.sendMessage("tapcreature-" + i);
				}
				else if (background.getBatPanel1().getCreatures().get(i).getAttacking() && background.getBatPanel1().getCreatures().get(i).getBlockedBy() != null)
				{
					CardSleeve2 attacker = background.getBatPanel1().getCreatures().get(i);
					CardSleeve2 blocker = background.getBatPanel1().getCreatures().get(i).getBlockedBy();
					
					boolean removeBlocker = false;
					boolean removeAttacker = false;
					
					if (((CreatureCard)attacker.getAttachedCard()).getPower() >= ((CreatureCard)blocker.getAttachedCard()).getToughness())
					{
						removeBlocker = true;
					}
					if ( ((CreatureCard)blocker.getAttachedCard()).getPower() >= ((CreatureCard)attacker.getAttachedCard()).getToughness())
					{
						removeAttacker = true;
					}
					else
					{
						((CreatureCard)attacker.getAttachedCard()).setTapped(true);
						attacker.setAttacking(false);
						attacker.setBorder(BorderFactory.createLineBorder(Color.black));
						attacker.remove(attacker.getAttackImage());
					}
					
					if (removeBlocker)
					{
						background.getBatPanel2().removeCreature(blocker);
					}
					if (removeAttacker)
					{
						background.getBatPanel1().removeCreature(attacker);
					}
				
				
				}
				else if (background.getBatPanel1().getCreatures().get(i).getAttacking())
				{
					background.getBatPanel1().getCreatures().get(i).remove(background.getBatPanel1().getCreatures().get(i).getAttackImage());
					((CreatureCard)background.getBatPanel1().getCreatures().get(i).getAttachedCard()).setTapped(true);
					background.getBatPanel1().getCreatures().get(i).setBorder(BorderFactory.createLineBorder(Color.black));
					c.sendMessage("removeattacker-" + i);
					c.sendMessage("tapcreature-" + i);
				}
			}
			c.sendMessage("damagetaken-" + damage);
			game.getPlayer2().decrementLife(damage);
			background.getLifeLabel2().setLife(game.getPlayer2().getLife());
			
			background.getTurnButton().setEnabled(true);
			
			background.setPhaseCount(background.getPhaseCount() + 1);
			game.setPhaseP1(background.getPhaseCount());
			background.getPhaseLabel().changePhase(game.getPhaseP1());
			background.getNextPhaseLabel().setNextPhase(game.getPhaseP1());
			background.getTurnButtonActual().changePhaseImage(game.getPhaseP1());
		}
		
		
		else if (message.indexOf("phaseChange") != -1)
		{
			int hyphon = message.indexOf("-");
			
			String phase = message.substring(hyphon + 1);
			int phaseNum = Integer.parseInt(phase);
			background.setPhaseCount(phaseNum);
			game.setPhaseP1(phaseNum);
			background.getPhaseLabel().changePhase(game.getPhaseP1());
			background.getNextPhaseLabel().setNextPhase(game.getPhaseP1());
			background.getTurnButtonActual().changePhaseImage(game.getPhaseP1());
			
			if (background.getPhaseCount() == 4)
			{
				background.setPhaseCount(0);
			}
		}
		else if (message.indexOf("Your Turn") != -1)
		{
			game.getPlayer1().setLandPlays(1);
			background.setPhaseCount(0);
			game.setPhaseP1(background.getPhaseCount());
			background.getPhaseLabel().changePhase(game.getPhaseP1());
			background.getNextPhaseLabel().setNextPhase(game.getPhaseP1());
			background.getTurnButtonActual().changePhaseImage(game.getPhaseP1());
			
			for (int i = 0; i < background.getBatPanel1().getCreatures().size(); i++)
			{
				((CreatureCard)background.getBatPanel1().getCreatures().get(i).getAttachedCard()).setCanAttack(true);
				((CreatureCard)background.getBatPanel1().getCreatures().get(i).getAttachedCard()).setTapped(false);
				c.sendMessage("untapcreature-" + i);
			}
			if (message.indexOf("Starting Turn") == -1)
			{
				background.getHandPanel().addCard(new CardSleeve(background.getHandPanel(), background.getLandPanel(), game.getPlayer1().draw(), game, background.getBatPanel1(), background.getBatPanel2(), background, c));
				background.repaint();
			}
			else if (message.indexOf("Starting Turn") != -1 && background.getStartingReceived())
			{
				background.getHandPanel().addCard(new CardSleeve(background.getHandPanel(), background.getLandPanel(), game.getPlayer1().draw(), game, background.getBatPanel1(), background.getBatPanel2(), background, c));
				background.repaint();
			}
			else
			{
				background.setStartingReceived(true);
			}
			background.getTurnButton().setEnabled(true);
			game.setP1Turn(true);
			for (int i = 0; i < background.getLandPanel().getLandCards().size(); i++)
			{
				((LandCard) background.getLandPanel().getLandCards().get(i).getAttachedCard()).setTapped(false);
			}
			JOptionPane.showMessageDialog(null,"It's your turn, mothertrucker","Turn Change",JOptionPane.INFORMATION_MESSAGE);
			background.getHandPanel().arrangeCards();
			this.repaint();
		}
	}
	
	
}
