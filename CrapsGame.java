/******45J lab***********
//yungchc1 Yung-Chu Chuang 50926235
//----------------------------------
//
//
************************

o	A class representing all the information for a single craps game. This includes:
	o	Number of times a roll happened
	o	A CrapsMetricsMonitor object
o	Public methods that this class must implement are:
	o	CrapsGame(CrapsMetricsMonitor    monitor)
		o	Constructor that initializes the class fields. 
			A CrapsMetricsMonitor is passed into the constructor 
			since there are specific stats within a single game 
			that must be updated (and the same object should be used 
			for all metrics in the simulation).
	o	boolean  playGame()
		o	Contains the algorithm for an actual game.
 */
import java.util.Random;

public class CrapsGame
{
	private CrapsMetricsMonitor crapsMetricsMonitor;
	private int numRolls;
	
	//Constructor
	public CrapsGame(CrapsMetricsMonitor Monitor)
	{
		this.numRolls = 0;
		this.crapsMetricsMonitor = Monitor;
	}
	
	//Quick Dice Rolling Function that Sums the Two Dice Rolled
	public int RollDice()
	{
		Random Dice = new Random();
		int a = Dice.nextInt(6) + 1;
		int b = Dice.nextInt(6) + 1;
		return (a+b);
	}
	
	//General Game Play Determining Win or Lose States
	public boolean playGame()
	{
		numRolls = 1;
		crapsMetricsMonitor.updateGamesPlayed();
		int diceRolled = RollDice();
		System.out.println("Rolled a " + diceRolled);
		
		//Natural
		if((diceRolled == 7) || (diceRolled == 11))
		{
			System.out.println("*****Natural! You Win!*****");
			crapsMetricsMonitor.updateNaturalRolls();
			return true;
		}
		
		//First Roll Craps
		else if((diceRolled == 2) || (diceRolled == 3) || (diceRolled == 12))
		{
			System.out.println("*****Craps! You lose.*****");
			crapsMetricsMonitor.updateCrapsRolls();
			return false;
	    }
		else
		{
			
			while(true)
			{
				int pointNum = diceRolled;
				diceRolled = RollDice();
				System.out.println("Rolled a " + diceRolled);
				numRolls++;
				if (crapsMetricsMonitor.getMaxRolls() < numRolls)
				{
					crapsMetricsMonitor.setMaxRolls(numRolls);
				}
				
				if(diceRolled == pointNum)
				{
					System.out.println("*****Rolled the point! You win!*****");
					return true; 
				}
				else if(diceRolled == 7)
				{
					System.out.println("*****Crap out! You lose.*****");
					return false;
				}
				else
				{
					continue;
				}
			}
		}
	}
}