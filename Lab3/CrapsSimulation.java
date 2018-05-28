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

public class CrapsSimulation
{
	private CrapsGame crapsGame;
	private CrapsMetricsMonitor crapsMetricsMonitor;
	
	private String userName;
	private int userBalance;
	private int userBet;
	private int currentWinStreak;
	private int currentLoseStreak;
	
	private Scanner input;
	
	//Constructor
	public CrapsSimulation()
	{
		this.crapsMetricsMonitor = new CrapsMetricsMonitor();
		this.crapsGame = new CrapsGame(crapsMetricsMonitor);
		this.userName = "";
		this.userBalance = 0;
		this.userBet = 0;
		this.currentWinStreak = 0;
		this.currentLoseStreak = 0;
		this.input = new Scanner(System.in);
		
		start();
	}
	
	public String askName()
	{
		System.out.println("Welcome to SimCraps! Enter your user name: ");
		userName = input.next();
		return userName;
	}
	
	public int askBalance()
	{
		System.out.println("Enter the amount of money you will bring to the table: ");
		userBalance = input.nextInt();
		return userBalance;
	}
	
	public int askBet()
	{
		System.out.println("Enter the bet amount between $1 and $" + userBalance + ": ");
		userBet = input.nextInt();
		return userBet;
	}
	
	//The Game Simulation that prompts the user for the name, budget, and bets
	public void start()
	{
		boolean Playing = true;
		
		while (Playing)
		{
			//User Information
			
			//Ask User Name
			userName = askName();
			try 
			{
				CrapsGame.checkName(userName);
			}
			catch(Exception e)
			{
				System.out.println("Exception occured: " + e);
				askName();
			}
			System.out.println("Hello " + userName + "!");
			//Ask User Balance
			userBalance = askBalance();
			try
			{
				CrapsGame.checkBalance(userBalance);
			}
			catch(Exception e)
			{
				System.out.println("Exception occured: " + e);
				askBalance();
			}
			crapsMetricsMonitor.setMaxBalance(userBalance);
			
			//Ask User Bet
			boolean keepBetting = true;
			while (keepBetting)
			{
				userBet = askBet();
				try
				{
					CrapsGame.checkBet(userBet, userBalance);
				}
				catch(Exception e)
				{
					System.out.println("Exception occured: " + e);
					askBet();
				}
				
				try
				{
					CrapsGame.checkNegativeBet(userBet);
				}
				catch(Exception e)
				{
					System.out.println("Exception occured: " + e);
					askBet();
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
				System.out.print("Bet again? 'y' or 'n': ");
				String replay = input.next();
				if (replay.equalsIgnoreCase("y"))
				{
					continue;
				}
				else
				{
					keepBetting = false;
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