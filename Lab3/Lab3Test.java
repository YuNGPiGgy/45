import static org.junit.Assert.*;

import org.junit.Test;

public class Lab3Test {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}













import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CrapsGameTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CrapsGameTest
{
    /**
     * Default constructor for test class CrapsGameTest
     */
    public CrapsGameTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test(expected = UnknownAnswerException.class)
    public void testUnknownAnswerException() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.unknownAnswerException("a");
    }

    @Test(expected = InvalidPlayerNameException.class)
    public void testInvalidPlayerNameException() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.invalidPlayerNameException(" ");
    }

    @Test(expected = NegativeBalanceException.class)
    public void testNegativeBalanceException() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.negativeBalanceException(-100);
    }

    @Test(expected = NegativeBetException.class)
    public void testNegativeBetException() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.negativeBetException(-100);
    }

    @Test(expected = BalanceLimitException.class)
    public void testBalanceLimitException() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.balanceLimitException(0);
    }

    @Test(expected = BalanceLimitException.class)
    public void testBalanceLimitExceptionTop() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.balanceLimitException(10000);
    }

    @Test
    public void testNormalBalanceLimitCases() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.balanceLimitException(500);
        game.balanceLimitException(100);
        game.balanceLimitException(800);
    }

    @Test
    public void testNormalNegativeBetCases() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.negativeBetException(10);
        game.negativeBetException(100);
        game.negativeBetException(1000000);
    }

    @Test
    public void testNormalNegativeBalanceCases() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.negativeBalanceException(10);
        game.negativeBalanceException(100);
        game.negativeBalanceException(100000);
    }

    @Test
    public void testNormalInvalidPlayerNameCases() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.invalidPlayerNameException("The");
        game.invalidPlayerNameException("Cheri");
        game.invalidPlayerNameException("+_$*@");
        game.invalidPlayerNameException("<>?PJ##3SDFaA");
        game.invalidPlayerNameException("SuperCaliFragilisticExpialidocious");
    }

    @Test
    public void testNormalUnknownAnswerCases() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.unknownAnswerException("n");
        game.unknownAnswerException("y");
    }

    @Test
    public void testBoundryBalanceLimitCases() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.balanceLimitException(1);
        game.balanceLimitException(1000);
    }

    @Test(expected = BalanceLimitException.class)
    public void testBoundryBalanceLimitFailCases() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.balanceLimitException(0);
        game.balanceLimitException(-1);
        game.balanceLimitException(1001);
    }

    @Test
    public void testBoundryNegativeBetCases() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.negativeBetException(0);
        game.negativeBetException(1);
    }

    @Test(expected = NegativeBetException.class)
    public void testBoundryNegativeBetFailCases() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.negativeBetException(-1);
        game.negativeBetException(-2);
    }

    @Test
    public void testBoundryNegativeBalanceCases() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.negativeBalanceException(0);
        game.negativeBalanceException(1);
    }

    @Test(expected = NegativeBalanceException.class)
    public void testBoundryNegativeBalanceFailCases() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.negativeBalanceException(-1);
        game.negativeBalanceException(-2);
    }

    @Test
    public void testBoundryInvalidPlayerNameCases() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.invalidPlayerNameException("T");
        game.invalidPlayerNameException("As");
    }

    @Test(expected = InvalidPlayerNameException.class)
    public void testBoundryInvalidPlayerNameFailCases() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.invalidPlayerNameException("");
        game.invalidPlayerNameException(" ");
    }

    @Test
    public void testBoundryUnknownAnswerExceptionCases() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.unknownAnswerException("y");
        game.unknownAnswerException("n");
    }

    @Test(expected = UnknownAnswerException.class)
    public void testBoundryUnknownAnswerExceptionFailCases() throws GameExceptions
    {
        CrapsGame game = new CrapsGame(new CrapsMetricsMonitor(), "Cheri", 1000);
        game.unknownAnswerException("a");
        game.unknownAnswerException("");
        game.unknownAnswerException("asef");
    }
}