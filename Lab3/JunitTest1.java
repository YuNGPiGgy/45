/******45J lab***********
//yungchc1 Yung-Chu Chuang 50926235
//tzulingw Tzu-Ling Wang   77721457
//
//
************************
*JUnit Testing with 5 Error Cases, 5 Normal Cases, and 8 Boundary Cases
*/

import static org.junit.Assert.*;
import org.junit.Test;

/****************************ERROR TEST******************************/

public class JunitTest1 {
	private CrapsGame game = new CrapsGame(new CrapsMetricsMonitor());
	
	//Make sure NegativeBalanceException is thrown
	@Test (expected = NegativeBalanceException.class)
	public void testNegBalance() throws NegativeBalanceException{
	game.checkBalance(-10);
	}
	
	//Make sure InvalidPlayerNameException is thrown
	@Test (expected = InvalidPlayerNameException.class)
	public void errorName() throws InvalidPlayerNameException{
	game.checkName("  ");
	}
	
	//Make sure BalanceLimitException is thrown
	@Test (expected = BalanceLimitException.class)
	public void errorLimitBet() throws BalanceLimitException{
	game.checkBet(100,10);
	}
	
	//Make sure NegativeBetException is thrown
	@Test (expected = NegativeBetException.class) 
	public void errorNegBet() throws NegativeBetException{
	game.checkNegativeBet(-10);
	}
	
	//Make sure UnknownAnswerException is thrown
	@Test (expected = UnknownAnswerException.class) 
	public void errorAnswer() throws UnknownAnswerException{
	game.checkAnswer("x");
	}

/****************************NORMAL TEST******************************/
	//Make sure NegativeBalanceException is not thrown
	@Test
	public void normalNegBalance() throws NegativeBalanceException{
	game.checkBalance(10);
	}
	
	//Make sure InvalidPlayerNameException is not thrown
	@Test
	public void normalName() throws InvalidPlayerNameException{
	game.checkName("Peter");
	}
	
	//Make sure BalanceLimitException is not thrown
	@Test
	public void normalLimitBet() throws BalanceLimitException{
	game.checkBet(10,100);
	}
	
	//Make sure NegativeBetException is not thrown
	@Test
	public void normalNegBet() throws NegativeBetException{
	game.checkNegativeBet(10);
	}
	
	//Make sure UnknownAnswerException is not thrown
	@Test
	public void normalAnswer() throws UnknownAnswerException{
	game.checkAnswer("Y");
	}
	
	/****************************BOUNDARY TEST******************************/
	//Make sure zero is invalid balance
	@Test (expected = NegativeBalanceException.class)
	public void boundaryNegBalance() throws NegativeBalanceException{
	game.checkBalance(0);
	}
	
	//Make sure zero is invalid balance
	@Test (expected = NegativeBalanceException.class)
	public void boundaryNegBalance2() throws NegativeBalanceException{
	game.checkBalance(-0);
	}
	
	//Make sure empty is also invalid player name
	@Test (expected = InvalidPlayerNameException.class)
	public void boundaryName() throws InvalidPlayerNameException{
	game.checkName("");
	}
	
	//Make sure space in player name is valid
	@Test 
	public void boundaryName2() throws InvalidPlayerNameException{
	game.checkName("Peter Anteater");
	}	

	// Make sure 0 is invalid bet
	@Test (expected = NegativeBetException.class) 
	public void boundaryNegBet() throws NegativeBetException{
	game.checkNegativeBet(0);
	}
	
	// Make sure 0 is invalid bet
	@Test (expected = NegativeBetException.class)
	public void boundaryNegBet2() throws NegativeBetException{
	game.checkNegativeBet(-0);
	}
	
	//Make sure bet = balance is valid
	@Test
	public void boundaryLimitBet() throws BalanceLimitException{
	game.checkBet(10,10);
	}
	
	//Make sure bet = balance is valid
	@Test (expected = BalanceLimitException.class)
	public void boundaryLimitBet2() throws BalanceLimitException{
	game.checkBet(-10,10);
	}
}
	
