/******45J lab***********
//yungchc1 Yung-Chu Chuang 50926235
//----------------------------------
//
//
************************

 o	Contains the main method. All it does is construct a CrapsSimulation object and calls.start() on it.
*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.Scanner;

public class Lab4
{	
	public static void main(String[] args)
	{
		String userName;
		int userBalance;
		int userBet;
		Scanner input = null;
	
		//User Information
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
		Thread t1 = new Thread (Game1, "CrapsGame1");

		CrapsSimulation Game2 = new CrapsSimulation("CrapsGame2", "src/CrapsGame2.txt", userName, userBalance, userBet);
		Thread t1 = new Thread (Game1, "CrapsGame2");
		
		CrapsSimulation Game3 = new CrapsSimulation("CrapsGame1", "src/CrapsGame3.txt", userName, userBalance, userBet);
		Thread t1 = new Thread (Game1, "CrapsGame3");
		
		CrapsSimulation Game4 = new CrapsSimulation("CrapsGame1", "src/CrapsGame4.txt", userName, userBalance, userBet);
		Thread t1 = new Thread (Game1, "CrapsGame4");
		
		CrapsSimulation Game5 = new CrapsSimulation("CrapsGame1", "src/CrapsGame5.txt", userName, userBalance, userBet);
		Thread t1 = new Thread (Game1, "CrapsGame5");
	}
}