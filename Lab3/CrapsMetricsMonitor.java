/******45J lab***********
//yungchc1 Yung-Chu Chuang 50926235
//tzulingw Tzu-Ling Wang   77721457
//
//
************************

o	A class representing all of the statistics gathered during a single simulation.
o	Public methods:
	o	Any methods you need to update / increment / decrement the class fields.
		These should be called throughout your simulation.
	o	void  printStatistics()
		o	Prints all of the statistics for the simulation (see sample output).
	o	void reset()
		o	A method to reset the state of the CrapsMetricsMonitor object. 
			This will be called if the user wants to start a new simulation after 
			one was just completed.
*/

public class CrapsMetricsMonitor
{
	private int gamesPlayed;	//Number of games played
	private int gamesWon;		//Number of games won
	private int gamesLost;		//Number of games lost
	private int maxRolls;		//Maximum number of rolls in a single game
	private int naturalRolls;	//atural� roll count
	private int crapsRolls;		//raps� roll count
	private int maxWinStreak;	//Maximum winning streak
	private int maxLoseStreak;	//Maximum losing streak
	private int maxBalance;		//Maximum balance throughout simulation
	private int balance;		//Balance the user has left
	private int totalBet;		//The total number of bets made before you run out of money
	private int bestGame;		//The game number when the Maximum balance was obtained
	
	//Constructor
	public CrapsMetricsMonitor()
	{
		this.gamesPlayed = 0;
		this.gamesWon = 0;
		this.gamesLost = 0;
		this.maxRolls = 0;
		this.naturalRolls = 0;
		this.crapsRolls = 0;
		this.maxWinStreak = 0;
		this.maxLoseStreak = 0;
		this.maxBalance = 0;
		this.balance = 0;
		this.totalBet = 0;
		this.bestGame = 0;
	}
	
	//Getters
	public int getGamesPlayed()		{return gamesPlayed;}
	public int getGamesWon()		{return gamesWon;}
	public int getGamesLost()		{return gamesLost;}
	public int getMaxRolls()		{return maxRolls;}
	public int getNaturalRolls()	{return naturalRolls;}
	public int getCrapsRolls()		{return crapsRolls;}
	public int getMaxWin()			{return maxWinStreak;}
	public int getMaxLose()			{return maxLoseStreak;}
	public int getMaxBalance()		{return maxBalance;}
	public int getBalance()			{return balance;}
	public int getTotalBet()		{return totalBet;}
	public int getBestGame()		{return bestGame;}

	
	//Setters & Updates
	public void updateGamesPlayed()		{this.gamesPlayed += 1;}
	public void updateGamesWon()		{this.gamesWon += 1;}
	public void updateGamesLost()		{this.gamesLost += 1;}
	public void updatMaxRolls()			{this.maxRolls += 1;}
	public void updateNaturalRolls()	{this.naturalRolls += 1;}
	public void updateCrapsRolls()		{this.crapsRolls += 1;}
	public void updateTotalBet()		{this.totalBet += 1;}
	public void setMaxWin(int i)		{this.maxWinStreak = i;}
	public void setMaxLose(int i)		{this.maxLoseStreak = i;}
	public void setMaxBalance(int i)	{this.maxBalance = i;}
	public void setBalance(int i)	    {this.balance = i;}
	public void setBestGame(int i)		{this.bestGame = i;}
	public void setMaxRolls(int i)		{this.maxRolls = i;}
	
	//Print Details of the Game
	public void printStatistics()
	{
		System.out.println("*****************************"
				+ "\n*** SIMULATION STATISTICS ***"
				+ "\n***************************** "
				+ "\nGames played: " + gamesPlayed
				+ "\nGames won: " + gamesWon
				+ "\nGames lost: " + gamesLost
				+ "\nMaximum Rolls in a single game: " + maxRolls
				+ "\nNatural Count: " + naturalRolls
				+ "\nCraps Count: " + crapsRolls
				+ "\nMaximum Winning Streak: " + maxWinStreak
				+ "\nMaximum Loosing Streak: " + maxLoseStreak
				+ "\nMaximum balance: " + maxBalance + " during game " + bestGame);
	}
	
	//Initializing Each Variables
	public void reset()
	{
		gamesPlayed = 0;
		gamesWon = 0;
		gamesLost = 0;
		maxRolls = 0;
		naturalRolls = 0;
		crapsRolls = 0;
		maxWinStreak = 0;
		maxLoseStreak = 0;
		maxBalance = 0;
		balance = 0;
		totalBet = 0;
		bestGame = 0;
	}
}