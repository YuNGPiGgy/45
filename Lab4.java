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
		
		CrapsSimulation Game1 = new CrapsSimulation(userName, userBalance, userBet, "Game1");
		CrapsSimulation Game2 = new CrapsSimulation(userName, userBalance, userBet, "Game2");
		CrapsSimulation Game3 = new CrapsSimulation(userName, userBalance, userBet, "Game3");
		CrapsSimulation Game4 = new CrapsSimulation(userName, userBalance, userBet, "Game4");
		CrapsSimulation Game5 = new CrapsSimulation(userName, userBalance, userBet, "Game5");
			
	}
}