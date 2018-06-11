/******45J lab***********
//yungchc1 Yung-Chu Chuang 50926235
//tzulingw Tzu-Ling Wang   77721457
//This class runs the simulation. The simulation will keep running until the balance is 0.
//We will print the sumulation stats.
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;




public class CrapsSimulation implements Runnable
{
	private CrapsGame crapsGame;
	private CrapsMetricsMonitor crapsMetricsMonitor;
	private String userName;
	private int userBalance;
	private int userBet;
	private int currentWinStreak;
	private int currentLoseStreak;
	private String fileName;
	private PrintWriter pw;
	private Scanner input;
	private Thread t;

	
	//Constructor
	public CrapsSimulation(String threadName, String userName, int userBalance, int userBet)
	{
		this.crapsMetricsMonitor = new CrapsMetricsMonitor();
		this.crapsGame = new CrapsGame(crapsMetricsMonitor);
		this.userName = "";
		this.userBalance = 0;
		this.userBet = 0;
		this.currentWinStreak = 0;
		this.currentLoseStreak = 0;
		this.input = new Scanner(System.in);
		this.fileName = "src/"+threadName+".txt";
		//threadName = threadName;
		try 
		{
			this.pw = new PrintWriter(this.fileName);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		this.pw.write("Simulation starts at " + System.currentTimeMillis()+"\n");
		this.pw.write("Hi " + this.userName + "!! \n");
		this.pw.write("Balance: " + this.userBalance + "\n");
		this.pw.write("Bet: " + this.userBet + "\n");
		//start();
	}
	
	public void startSimulation()
	{
		if (t == null){
   		 Thread t = new Thread (this, threadName);
   		 long startTime = System.currentTimeMillis();
   		 System.out.println("The current time is thread " + threadName + " starting at "+ startTime);
   		 t.start();
   		 long endTime = System.currentTimeMillis();
   		 System.out.println("The current time is thread " + threadName + " finishing at "+ endTime);

   	 	}
	}
	
	//The Game Simulation that prompts the user for the name, budget, and bets
	public void start()
	{
		boolean Playing = true;
		
		while (Playing)
		{
			//User Information
			System.out.println("Welcome to SimCraps! Enter your user name: ");
			userName = input.next();
			System.out.println("Hello " + userName + "!");
			pw.write("Welcome to SimCraps! Enter your user name: " + userName + "\n");
			System.out.println("Enter the amount of money you will bring to the table: ");
			userBalance = input.nextInt();
			crapsMetricsMonitor.setMaxBalance(userBalance);
			pw.write("Enter the amount of money you will bring to the table: " + userBalance + "\n");
			System.out.println("Enter the bet amount between $1 and $" + userBalance + ": ");
			int bet = input.nextInt();
			//Prevent User to bet more than balance
			while (bet < 1 || bet > userBalance)
			{
				System.out.println("Invalid bet! Not Enough Balance (" + userBalance + ") Left :");
				bet = input.nextInt();
			}
			
			
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
				pw.write("Enter the bet amount between $0 and $" + userBalance + ": " + userBet + "\n");
				
				
				
				
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
			this.pw.write("")
		}			
			
	}
}