/******45J lab***********
//yungchc1 Yung-Chu Chuang 50926235
//----------------------------------
//
//
************************

 o	A class representing all the information for the Simulation. This includes:
	o	A CrapsGame object
	o	A CrapsMetricsMonitor object
	o	The user’s name
	o	The user’s balance
	o	The user’s bet
	o	The current win streak
	o	The current lose streak
	
o	Public methods that this class must implement are:
	o	CrapsSimulation()
		o	Constructor that initializes all fields to default values and 
			constructs any objects used (i.e. Scanner, CrapsMetricsMonitor, …)
	o	void start()
		o	Main loop of a single simulation run. This is where the user inputs 
			their name, balance, and bet, runs the simulation, and 
			continues to do so if the user wants to run it again.
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CrapsSimulation
{
	private CrapsGame crapsGame;
	private CrapsMetricsMonitor crapsMetricsMonitor;
	
	private String userName;
	private int userBalance;
	private int userBet;
	private int currentWinStreak;
	private int currentLoseStreak;
	private int totalGamesPlayed = 0;
	private Thread t;
	
	private Scanner input;
	
	//Constructor
	public CrapsSimulation(String userName, int userBalance, int userBet, String file)
	{
		this.crapsMetricsMonitor = new CrapsMetricsMonitor();
		this.crapsGame = new CrapsGame(crapsMetricsMonitor);
		this.userName = userName;
		this.userBalance = userBalance;
		this.userBet = userBet;
		this.currentWinStreak = 0;
		this.currentLoseStreak = 0;
		this.input = new Scanner(System.in);
		
		start();
	}
	
	//The Game Simulation that prompts the user for the name, budget, and bets
	public void start()
	{
		boolean Playing = true;
		
		while (Playing)
		{
			crapsMetricsMonitor.setMaxBalance(userBalance);
			
			//If balance fall below original bet, use all the balance
			while (userBalance > 0)
			{
				if (userBalance < bet)
				{
					userBet = userBalance;
				}
				else
				{
					userBet = bet;
				}
		
				System.out.println(userName + " bets $" + userBet);
				
				//Start Game
				boolean winGame = crapsGame.playGame();
				if (winGame)
				{
					crapsMetricsMonitor.updateGamesWon();
					currentWinStreak++;
					currentLoseStreak = 0;
					userBalance += userBet;
					
					if(currentWinStreak > crapsMetricsMonitor.getMaxWin())
					{
						crapsMetricsMonitor.setMaxWin(currentWinStreak);
					}
				}
				else
				{
					crapsMetricsMonitor.updateGamesLost();
					currentWinStreak = 0;
					currentLoseStreak++;
					userBalance -= userBet;
					
					if(currentLoseStreak > crapsMetricsMonitor.getMaxLose())
					{
						crapsMetricsMonitor.setMaxLose(currentLoseStreak);
					}
				}
				System.out.println(userName + "'s balance:" +userBalance);
				if (crapsMetricsMonitor.getMaxBalance() < userBalance)
				{
					crapsMetricsMonitor.setMaxBalance(userBalance);
					crapsMetricsMonitor.setBestGame(crapsMetricsMonitor.getGamesPlayed());
				}
			}
			//Ask for replay or quit
			crapsMetricsMonitor.printStatistics();
			System.out.print("Replay? Enter 'y' or 'n': ");
			String replay = input.next();
			if (replay.equalsIgnoreCase("y"))
			{
				crapsMetricsMonitor.reset();
			}
			else
			{
				System.exit(0);
			}
		}
	}
}