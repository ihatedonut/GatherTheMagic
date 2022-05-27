public class GatherTheMagicMain
{
	public static void main(String[] args) 
	{
		GameObject2 g1 = new GameObject2();
		Player player1 = g1.getP1();
		Player player2 = g1.getP2();
		player1.fillDeck("white");
		player2.fillDeck("green");
		
		player1.draw(7);
		player2.draw(7);
		CreatureCard Gamma = new CreatureCard("Aidan Gamma, Thunderous Cleric", "white", "When Aidan Gamma enters the battlefield, "
				+ "gain 1 life for each creature you control.", 4, 2, 3, "gainlifepercreature");
		CreatureCard soldier = new CreatureCard("Holy Soldier","white" , 4,4,4);
		
		player1.addCardToHand(Gamma);
		player1.addCardToHand(soldier);
		g1.putOnP1Battlefield(soldier);
		g1.putOnP1Battlefield(Gamma);
		
		System.out.print(player1.getLife());
		
		while(player1.getLife()>0 || player2.getLife()>0 || player1.getDeckSize()>0 || player2.getDeckSize()>0)
		{
			
			
			
			
		}
		
	}

}
