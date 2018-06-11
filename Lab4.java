/******45J lab***********
//yungchc1 Yung-Chu Chuang 50926235
//tzulingw Tzu-Ling Wang   77721457
//
//This class calls start() and run a simulation for the game.It will keep running until the user has 0 balance
************************

 o	Contains the main method. All it does is construct a CrapsSimulation object and calls.start() on it.
*/

import java.io.*;
import java.util.*;


public class Lab4
{	
	private Thread t;
	public static void main(String[] args)
	{
	
		//CrapsSimulation Game = new CrapsSimulation();
		//Game.start();
		
		String nname = " ";
		int bbalance = 0;
		int bbet = 0;
		
		boolean Playing = true;
		String fileName = "src/" + threadName + ".txt";
		
		PrintWriter pw = new PrintWriter(fileName);

		
		/*
		while(Playing)
		{
			Scanner sc = new Scanner(System.in);
			//LogManager;
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		
		/*
		
		sc.useDelimiter("\n");
		*/
		
	}
}