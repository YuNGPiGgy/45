/******45J lab***********
//yungchc1 Yung-Chu Chuang 50926235
//tzulingw Tzu-Ling Wang   77721457
//
//
************************

 o	A class representing all the information for the Simulation. This includes:
	o	A CrapsGame object
	o	A CrapsMetricsMonitor object
	o	The user name
	o	The user balance
	o	The user bet
	o	The current win streak
	o	The current lose streak
	
o	Public methods that this class must implement are:
	o	CrapsSimulation()
		o	Constructor that initializes all fields to default values and 
			constructs any objects used (i.e. Scanner, CrapsMetricsMonitor, �)
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
	private String replay;
	private String rebet;
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
		this.replay = "";
		this.rebet = "";
		this.currentWinStreak = 0;
		this.currentLoseStreak = 0;
		this.input = new Scanner(System.in);
		start();
	}
	
	//Ask for user name
	public String askName()
	{
		System.out.println("Welcome to SimCraps! Enter your user name: ");
		String name = input.nextLine();
		return name;
	}
	
	//Ask for balance
	public int askBalance()
	{
		System.out.println("Enter the amount of money you will bring to the table: ");
		return input.nextInt();
	}
	
	//Ask for bet
	public int askBet()
	{
		System.out.println("Enter the bet amount between $1 and $" + userBalance + ": ");
		return input.nextInt();
	}
	
	//Ask for replay
	public String askReplay()
	{
		System.out.println("Play again? 'y' or 'n': ");
		return input.nextLine();
	}
	
	//Ask for rebet
	public String askReBet()
	{
		System.out.println("Bet again? 'y' or 'n': ");
		String answer = input.nextLine();
		return answer;
	}
	
	//The Game Simulation that prompts the user for the name, budget, and bets
	public void start()
	{
		boolean Playing = true;
		boolean Pass;
		while (Playing)
		{
			//User Information
			//Ask User Name
			Pass = false;
			while (!Pass)
			{
				userName = askName();
				try 
				{
					CrapsGame.checkName(userName);
					Pass = true;
				}
				catch(Exception e)
				{
					System.out.println("Exception occured: " + e);
				}
			}
			System.out.println("Hello " + userName + "!");
			//Ask User Balance
			
			Pass = false;
			while (!Pass)
			{
				userBalance = askBalance();
				try
				{
					CrapsGame.checkBalance(userBalance);
					Pass = true;
				}
				catch(Exception e)
				{
					System.out.println("Exception occured: " + e);
				}
			}
			crapsMetricsMonitor.setMaxBalance(userBalance);
			
			//Ask User Bet
			Pass = false;
			boolean keepBetting = true;
			while (keepBetting && userBalance > 0)
			{
				while (!Pass)
				{
					userBet = askBet();
					try
					{
						CrapsGame.checkBet(userBet, userBalance);
						try
						{
							CrapsGame.checkNegativeBet(userBet);
							Pass = true;
						}
						catch(Exception e)
						{
							System.out.println("Exception occured: " + e);
						}
					}
					catch(Exception e)
					{
						System.out.println("Exception occured: " + e);
					}
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
				if (userBalance > 0)
				{
					Pass = false;
					while (!Pass)
					{
						rebet = askReBet();
						try
						{
							CrapsGame.checkAnswer(rebet);
							Pass = true;
						}
						catch(Exception e)
						{
							System.out.println("Exception occured: " + e);
						}
					}
					if (rebet.equalsIgnoreCase("y"))
					{
						Pass = false;
						continue;
					}
					else
					{
						keepBetting = false;
					}
				}
				else
				{
					keepBetting = false;
				}
			}
			//Ask for replay or quit
			crapsMetricsMonitor.printStatistics();
			
			Pass = false;
			while (!Pass)
			{
				replay = askReplay();
				try
				{
					CrapsGame.checkAnswer(replay);
					Pass = true;
				}
				catch(Exception e)
				{
					System.out.println("Exception occured: " + e);
				}
			}
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