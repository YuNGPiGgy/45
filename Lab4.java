import java.util.Scanner;

/******45J lab***********
//yungchc1 Yung-Chu Chuang 50926235
//----------------------------------
//
//
************************

 o	Contains the main method. All it does is construct a CrapsSimulation object and calls.start() on it.
*/
import java.util.Scanner;

public class Lab4
{	
	@SuppressWarnings("null")
	public static void main(String[] args)
	{
		String userName;
		int userBalance;
		int userBet;
		Scanner input = null;
		
		System.out.println("Welcome to SimCraps! Enter your user name: ");
		userName = input.next();
		System.out.println("Hello " + userName + "!");
		System.out.println("Enter the amount of money you will bring to the table: ");
		userBalance = input.nextInt();
		System.out.println("Enter the bet amount between $1 and $" + userBalance + ": ");
		int bet = input.nextInt();
		//Prevent User to bet more than balance
		while (bet < 1 || bet > userBalance)
		{
			System.out.println("Invalid bet! Not Enough Balance (" + userBalance + ") Left :");
			bet = input.nextInt();
		}
		userBet = bet;
		
<<<<<<< HEAD
		CrapsSimulation Game1 = new CrapsSimulation(userName, userBalance, userBet, "Game1");
		CrapsSimulation Game2 = new CrapsSimulation(userName, userBalance, userBet, "Game2");
		CrapsSimulation Game3 = new CrapsSimulation(userName, userBalance, userBet, "Game3");
		CrapsSimulation Game4 = new CrapsSimulation(userName, userBalance, userBet, "Game4");
		CrapsSimulation Game5 = new CrapsSimulation(userName, userBalance, userBet, "Game5");
=======
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
		}
		
		CrapsSimulation Game1 = new CrapsSimulation("CrapsGame1", "src/CrapsGame1.txt", userName, userBalance, userBet);
		Thread t1 = new Thread ("CrapsGame1");

		CrapsSimulation Game2 = new CrapsSimulation("CrapsGame2", "src/CrapsGame2.txt", userName, userBalance, userBet);
		Thread t2 = new Thread ("CrapsGame2");
		
		CrapsSimulation Game3 = new CrapsSimulation("CrapsGame3", "src/CrapsGame3.txt", userName, userBalance, userBet);
		Thread t3 = new Thread ("CrapsGame3");
		
		CrapsSimulation Game4 = new CrapsSimulation("CrapsGame4", "src/CrapsGame4.txt", userName, userBalance, userBet);
		Thread t4 = new Thread ("CrapsGame4");
		
		CrapsSimulation Game5 = new CrapsSimulation("CrapsGame5", "src/CrapsGame5.txt", userName, userBalance, userBet);
		Thread t5 = new Thread ("CrapsGame5");
	}
	long t1StartTime = System.currentTimeMillis();
	t1.start();
	long t2StartTime = System.currentTimeMillis();
	t2.start();
	long t3StartTime = System.currentTimeMillis();
	t3.start();
	long t4StartTime = System.currentTimeMillis();
	t4.start();
	long t5StartTime = System.currentTimeMillis();
	t5.start();
	try {
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		
		System.out.println(CrapsGame1.getTotalGamesPlayed());
		System.out.println(CrapsGame2.getTotalGamesPlayed());
		System.out.println(CrapsGame3.getTotalGamesPlayed());
		System.out.println(CrapsGame4.getTotalGamesPlayed());
		System.out.println(CrapsGame5.getTotalGamesPlayed());
		int total = CrapsGame1.getTotalGamesPlayed()+CrapsGame2.getTotalGamesPlayed()+CrapsGame3.getTotalGamesPlayed()+CrapsGame4.getTotalGamesPlayed()+CrapsGame5.getTotalGamesPlayed();
		
		System.out.println("thread 1 start time: " + t1StartTime);
		System.out.println("thread 2 start time: " + t2StartTime);
		System.out.println("thread 3 start time: " + t3StartTime);
		System.out.println("thread 4 start time: " + t4StartTime);
		System.out.println("thread 5 start time: " + t5StartTime);
		System.out.println("thread 1 end   time: " + CrapsGame1.getFinTime());
		System.out.println("thread 2 end   time: " + CrapsGame2.getFinTime());
		System.out.println("thread 3 end   time: " + CrapsGame3.getFinTime());
		System.out.println("thread 4 end   time: " + CrapsGame4.getFinTime());
		System.out.println("thread 5 end   time: " + CrapsGame5.getFinTime());
		System.out.println("total games played in all threads " + total);
		
		try {
			PrintWriter pw1 = new PrintWriter(new FileOutputStream(new File("src/sim1.txt"), true));
			PrintWriter pw2 = new PrintWriter(new FileOutputStream(new File("src/sim2.txt"), true));
			PrintWriter pw3 = new PrintWriter(new FileOutputStream(new File("src/sim3.txt"), true));
			PrintWriter pw4 = new PrintWriter(new FileOutputStream(new File("src/sim4.txt"), true));
			PrintWriter pw5 = new PrintWriter(new FileOutputStream(new File("src/sim5.txt"), true));
			PrintWriter pw6 = new PrintWriter(new FileOutputStream(new File("src/results.txt"), true));
			pw1.println("thread 1 start time: " + t1StartTime);
			pw1.println("thread 2 start time: " + t2StartTime);
			pw1.println("thread 3 start time: " + t3StartTime);
			pw1.println("thread 4 start time: " + t4StartTime);
			pw1.println("thread 5 start time: " + t5StartTime);
			pw1.println("thread 1 end   time: " + CrapsGame1.getFinTime());
			pw1.println("thread 2 end   time: " + CrapsGame2.getFinTime());
			pw1.println("thread 3 end   time: " + CrapsGame3.getFinTime());
			pw1.println("thread 4 end   time: " + CrapsGame4.getFinTime());
			pw1.println("thread 5 end   time: " + CrapsGame5.getFinTime());
			pw1.println("total games played in all threads " + total);
			pw1.println();
			pw1.println("*********END OF SIMULATION*********");
			pw1.println();
			pw1.println();
			
			pw2.println("thread 1 start time: " + t1StartTime);
			pw2.println("thread 2 start time: " + t2StartTime);
			pw2.println("thread 3 start time: " + t3StartTime);
			pw2.println("thread 4 start time: " + t4StartTime);
			pw2.println("thread 5 start time: " + t5StartTime);
			pw2.println("thread 1 end   time: " + CrapsGame1.getFinTime());
			pw2.println("thread 2 end   time: " + CrapsGame2.getFinTime());
			pw2.println("thread 3 end   time: " + CrapsGame3.getFinTime());
			pw2.println("thread 4 end   time: " + CrapsGame4.getFinTime());
			pw2.println("thread 5 end   time: " + CrapsGame5.getFinTime());
			pw2.println("total games played in all threads " + total);
			pw2.println();
			pw2.println("*********END OF SIMULATION*********");
			pw2.println();
			pw2.println();
			
			pw3.println("thread 1 start time: " + t1StartTime);
			pw3.println("thread 2 start time: " + t2StartTime);
			pw3.println("thread 3 start time: " + t3StartTime);
			pw3.println("thread 4 start time: " + t4StartTime);
			pw3.println("thread 5 start time: " + t5StartTime);
			pw3.println("thread 1 end   time: " + CrapsGame1.getFinTime());
			pw3.println("thread 2 end   time: " + CrapsGame2.getFinTime());
			pw3.println("thread 3 end   time: " + CrapsGame3.getFinTime());
			pw3.println("thread 4 end   time: " + CrapsGame4.getFinTime());
			pw3.println("thread 5 end   time: " + CrapsGame5.getFinTime());
			pw3.println("total games played in all threads " + total);
			pw3.println();
			pw3.println("*********END OF SIMULATION*********");
			pw3.println();
			pw3.println();
		
			pw4.println("thread 1 start time: " + t1StartTime);
			pw4.println("thread 2 start time: " + t2StartTime);
			pw4.println("thread 3 start time: " + t3StartTime);
			pw4.println("thread 4 start time: " + t4StartTime);
			pw4.println("thread 5 start time: " + t5StartTime);
			pw4.println("thread 1 end   time: " + CrapsGame1.getFinTime());
			pw4.println("thread 2 end   time: " + CrapsGame2.getFinTime());
			pw4.println("thread 3 end   time: " + CrapsGame3.getFinTime());
			pw4.println("thread 4 end   time: " + CrapsGame4.getFinTime());
			pw4.println("thread 5 end   time: " + CrapsGame5.getFinTime());
			pw4.println("total games played in all threads " + total);
			pw4.println();
			pw4.println("*********END OF SIMULATION*********");
			pw4.println();
			pw4.println();
			
			pw5.println("thread 1 start time: " + t1StartTime);
			pw5.println("thread 2 start time: " + t2StartTime);
			pw5.println("thread 3 start time: " + t3StartTime);
			pw5.println("thread 4 start time: " + t4StartTime);
			pw5.println("thread 5 start time: " + t5StartTime);
			pw5.println("thread 1 end   time: " + CrapsGame1.getFinTime());
			pw5.println("thread 2 end   time: " + CrapsGame2.getFinTime());
			pw5.println("thread 3 end   time: " + CrapsGame3.getFinTime());
			pw5.println("thread 4 end   time: " + CrapsGame4.getFinTime());
			pw5.println("thread 5 end   time: " + CrapsGame5.getFinTime());
			pw5.println("total games played in all threads " + total);
			pw5.println();
			pw5.println("*********END OF SIMULATION*********");
			pw5.println();
			pw5.println();
			
			pw6.println("thread 1 start time: " + t1StartTime);
			pw6.println("thread 2 start time: " + t2StartTime);
			pw6.println("thread 3 start time: " + t3StartTime);
			pw6.println("thread 4 start time: " + t4StartTime);
			pw6.println("thread 5 start time: " + t5StartTime);
			pw6.println("thread 1 end   time: " + CrapsGame1.getFinTime());
			pw6.println("thread 2 end   time: " + CrapsGame2.getFinTime());
			pw6.println("thread 3 end   time: " + CrapsGame3.getFinTime());
			pw6.println("thread 4 end   time: " + CrapsGame4.getFinTime());
			pw6.println("thread 5 end   time: " + CrapsGame5.getFinTime());
			pw6.println("total games played in all threads " + total);
			pw6.println();
			pw6.println("*********END*********");
			pw6.println();
			pw6.println();
			
			pw1.close();
			pw2.close();
			pw3.close();
			pw4.close();
			pw5.close();
			pw6.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
>>>>>>> 3b640dcebee0c4c645721133bb8a9c13cbc248a4
			
	}
<<<<<<< HEAD
}
=======

	
	System.out.print("Replay? Enter 'y' or 'n': ");
	play = s.nextLine();
	play = CrapsSimulation.validateResponseV2(play, s);
	CrapsGame1.reset();
	CrapsGame2.reset();
	CrapsGame3.reset();
	CrapsGame4.reset();
	CrapsGame5.reset();
	}
	
}


>>>>>>> 3b640dcebee0c4c645721133bb8a9c13cbc248a4
