import static org.junit.Assert.*;

import org.junit.Test;

/****************************ERROR TEST******************************/

public class JunitTest1 {
	private CrapsGame game = new CrapsGame(new CrapsMetricsMonitor());
	@Test //errorTest1
	public void testcheckBalance() throws NegativeBalanceException{
	System.out.println("Start balace checking test");
	//game.crapsMetricsMonitor.setBalance(-200);
	game.checkBalance(-200);
	}
	@Test //errorTest2
	public void testcheckName() throws InvalidPlayerNameException{
	System.out.println("Start name checking test");
	game.checkName(" ");
	}	
	@Test //errorTest3   
	public void checkNegativeBet() throws NegativeBetException{
	System.out.println("Start negative bet checking test");	
	game.checkNegativeBet(-20);
	}
	@Test //errorTest4
	public void testcheckBet12() throws NegativeBetException{
	System.out.println("Start bet checking test");	
	game.checkNegativeBet(-1000);
	}
	@Test //errorTest5   
	public void testcheckBet() throws NegativeBetException{
		System.out.println("Start bet checking test");	
		game.checkNegativeBet(-10);
	}

/****************************NORMAL TEST******************************/
@Test //normalTest1
public void testcheckBalance1() throws NegativeBalanceException{
System.out.println("Start balace checking test");
//game.crapsMetricsMonitor.setBalance(-200);
game.checkBalance(200);
}
@Test //normalTest2
public void testcheckName1() throws InvalidPlayerNameException{
System.out.println("Start name checking test");
game.checkName("Vivian");
}	
@Test //normalTest3   
public void checkNegativeBet1() throws NegativeBetException{
System.out.println("Start negative bet checking test");	
game.checkNegativeBet(20);
}
@Test //normalTest4
public void testcheckBet111() throws NegativeBetException{
System.out.println("Start bet checking test");	
game.checkNegativeBet(1000);
}
@Test //normalTest5   
public void testcheckBet112() throws NegativeBetException{
	System.out.println("Start bet checking test");	
	game.checkNegativeBet(10);
}

/****************************BOUNDARY TEST******************************/
@Test //boundaryTest1
public void testcheckBalance0() throws NegativeBalanceException{
System.out.println("Start balace checking test");
//game.crapsMetricsMonitor.setBalance(-200);
game.checkBalance(0);
}
@Test //boundaryTest2
public void testcheckName01() throws InvalidPlayerNameException{
System.out.println("Start name checking test");
game.checkName("a");
}	
@Test //boundaryTest3
public void testcheckName00() throws InvalidPlayerNameException{
System.out.println("Start name checking test");
game.checkName("b");
}
@Test //boundaryTest4
public void testcheckName0() throws InvalidPlayerNameException{
System.out.println("Start name checking test");
game.checkName("c");
}	
@Test //boundaryTest5 
public void checkNegativeBet0() throws NegativeBetException{
System.out.println("Start negative bet checking test");	
game.checkNegativeBet(20);
}
@Test //boundaryTest6
public void testcheckBet11() throws NegativeBetException{
System.out.println("Start bet checking test");	
game.checkNegativeBet(1000);
}
@Test //boundaryTest7
public void testcheckBet1() throws NegativeBetException{
	System.out.println("Start bet checking test");	
	game.checkNegativeBet(10);
}
@Test //boundaryTest8
public void testcheckBet19() throws NegativeBetException{
	System.out.println("Start bet checking test");	
	game.checkNegativeBet(100);
	}
}

